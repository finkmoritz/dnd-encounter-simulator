package io.github.finkmoritz.dndencountersimulator.campaign.lmop

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.combatant.Combatant
import io.github.finkmoritz.dndencountersimulator.combatant.Bugbear
import io.github.finkmoritz.dndencountersimulator.combatant.Goblin
import io.github.finkmoritz.dndencountersimulator.combatant.Wolf
import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.encounter.BasicEncounter
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy
import org.junit.jupiter.api.Test

/**
 * Simulation of the first part of the Lost Mines of Phandelver adventure.
 */
class LostMinesOfPhandelver1 {

    @Test
    fun scenario1() {
        val verboseOutput = false

        val numberOfSimulations = 1000
        var survivalCount = 0
        var survivingPartyMembers = 0

        for (i in 1..numberOfSimulations) {
            val party = mutableListOf<Combatant>(
                BaseCombatant(
                    "Fighter 1 (1)", 12u, 17u, -1, 5,
                    DamageDice.fromExpressions("1d12+3", DamageType.SLASHING),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),

                BaseCombatant(
                    "Cleric 1", 11u, 18u, -1, 4,
                    DamageDice.fromExpressions("1d8+2", DamageType.BLUDGEONING),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),

                BaseCombatant(
                    "Rogue 1", 9u, 14u, 3, 5,
                    DamageDice.fromExpressions("1d6+3", DamageType.PIERCING),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),

                BaseCombatant(
                    "Sorcerer 1", 8u, 12u, 2, 99, // magic missile auto-hit
                    DamageDice.fromExpressions("3d4+3", DamageType.FORCE),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),

                BaseCombatant(
                    "Fighter 1 (2)", 12u, 14u, 3, 4,
                    DamageDice.fromExpressions("2d6+2", DamageType.SLASHING),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),
            )

            val goblinsAmbush = mutableListOf<Combatant>(
                Goblin(),
                Goblin(),
                Goblin(),
                Goblin(),
            )

            val goblinsWatch = mutableListOf<Combatant>(
                Goblin(),
                Goblin(),
            )

            val goblinsGuard = mutableListOf<Combatant>(
                Goblin(),
                Goblin(),
                Goblin(),
                // Goblin(),
            )

            val goblinsLiving = mutableListOf<Combatant>(
                Goblin(),
                Goblin(),
                Goblin(),
                Goblin(),
                Goblin(),
                Goblin(),
            )

            val boss = mutableListOf<Combatant>(
                Bugbear(),
                Wolf(targetingStrategy = TargetingStrategy.LOWEST_HP),
                // Goblin(),
                // Goblin(),
            )

            BasicEncounter(party, goblinsAmbush, surprised = party, verbose = verboseOutput).run()

            // heal every living character after ambush
            party.filter { it.isAlive() }.forEach { it.heal(it.maxHp()) }

            BasicEncounter(party, goblinsWatch, verbose = verboseOutput).run()
            BasicEncounter(party, goblinsGuard, verbose = verboseOutput).run()
            BasicEncounter(party, goblinsLiving, verbose = verboseOutput).run()
            BasicEncounter(party, boss, verbose = verboseOutput).run()

            if (party.any { it.isAlive() }) {
                survivalCount++
                survivingPartyMembers += party.count { it.isAlive() }
            }
        }

        println("Survival rate: ${survivalCount.toDouble() / numberOfSimulations * 100}%")
        println("Average number of surviving party members: ${survivingPartyMembers.toDouble() / numberOfSimulations}")
    }
}
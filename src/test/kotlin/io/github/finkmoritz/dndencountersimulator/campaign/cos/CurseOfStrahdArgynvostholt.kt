package io.github.finkmoritz.dndencountersimulator.campaign.cos

import io.github.finkmoritz.dndencountersimulator.combatant.*
import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.encounter.BasicEncounter
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy
import org.junit.jupiter.api.Test

/**
 * Simulation of the first part of the Lost Mines of Phandelver adventure.
 */
class CurseOfStrahdArgynvostholt {

    @Test
    fun scenario1() {
        val verboseOutput = false

        val numberOfSimulations = 1000
        var survivalCount = 0
        var survivingPartyMembers = 0

        for (i in 1..numberOfSimulations) {
            val party = mutableListOf<Combatant>(
                BaseCombatant(
                    "Agatha", 24u, 13u, 1, 5,
                    DamageDice.fromExpressions("1d12+3", DamageType.SLASHING),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),

                BaseCombatant(
                    "Akastos", 36u, 16u, 1, 5,
                    DamageDice.fromExpressions("1d8+2", DamageType.PIERCING, "1d6", DamageType.PIERCING),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),

                BaseCombatant(
                    "Milka", 32u, 16u, 1, 5,
                    DamageDice.fromExpressions("1d6+3", DamageType.PIERCING),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),

                BaseCombatant(
                    "Slyrak", 39u, 18u, -1, 5,
                    DamageDice.fromExpressions("2d6+3", DamageType.SLASHING),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),

                BaseCombatant(
                    "Yavanna", 26u, 14u, 3, 8,
                    DamageDice.fromExpressions("1d8+3", DamageType.PIERCING),
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),
                BaseCombatant(
                    "Esmerelda", 82u, 17u, 4, 8,
                    DamageDice.fromExpressions("1d8+5", DamageType.PIERCING),
                    multiAttack = 3u,
                    targetingStrategy = TargetingStrategy.LOWEST_HP,
                ),
            )

            val q13 = mutableListOf<Combatant>(
                Revenant(),
                Revenant(),
                Revenant(),
            )

            val q27 = mutableListOf<Combatant>(
                PhantomWarrior(),
                PhantomWarrior(),
                PhantomWarrior(),
                PhantomWarrior(),
            )

            val q28 = mutableListOf<Combatant>(
                PhantomWarrior(),
                PhantomWarrior(),
                PhantomWarrior(),
            )

            val q36 = mutableListOf<Combatant>(
                Revenant(name = "Vladimir Horngaard"),
                PhantomWarrior(),
                PhantomWarrior(),
                PhantomWarrior(),
                PhantomWarrior(),
                PhantomWarrior(),
                PhantomWarrior(),
            )

            val q52 = mutableListOf<Combatant>(
                PhantomWarrior(),
                PhantomWarrior(),
            )

            BasicEncounter(party, q13, verbose = verboseOutput).run()
            // BasicEncounter(party, q27 + q28, verbose = verboseOutput).run()
            // BasicEncounter(party, q36, verbose = verboseOutput).run()
            // BasicEncounter(party, q52, verbose = verboseOutput).run()

            if (party.any { it.isAlive() }) {
                survivalCount++
                survivingPartyMembers += party.count { it.isAlive() }
            }
        }

        println("Survival rate: ${survivalCount.toDouble() / numberOfSimulations * 100}%")
        println("Average number of surviving party members: ${survivingPartyMembers.toDouble() / numberOfSimulations}")
    }
}
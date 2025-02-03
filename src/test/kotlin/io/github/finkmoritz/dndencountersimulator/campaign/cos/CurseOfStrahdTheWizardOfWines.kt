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
class CurseOfStrahdTheWizardOfWines {

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

            val approachingTheWinery = MutableList(30) { NeedleBlight() }

            val w9 = MutableList<Combatant>(30) { TwigBlight() }
            w9.add(Druid())

            val w14 = MutableList<Combatant>(5) { NeedleBlight() }
            w14.add(Druid())

            val w16 = mutableListOf(Druid())

            val w20 = mutableListOf(
                Druid(),
                VineBlight(),
                VineBlight(),
            )

            // BasicEncounter(party, approachingTheWinery, verbose = verboseOutput).run()
            BasicEncounter(party, w9, verbose = verboseOutput).run()
            BasicEncounter(party, w14, verbose = verboseOutput).run()
            BasicEncounter(party, w16, verbose = verboseOutput).run()
            BasicEncounter(party, w20, verbose = verboseOutput).run()

            if (party.any { it.isAlive() }) {
                survivalCount++
                survivingPartyMembers += party.count { it.isAlive() }
            }
        }

        println("Survival rate: ${survivalCount.toDouble() / numberOfSimulations * 100}%")
        println("Average number of surviving party members: ${survivingPartyMembers.toDouble() / numberOfSimulations}")
    }
}
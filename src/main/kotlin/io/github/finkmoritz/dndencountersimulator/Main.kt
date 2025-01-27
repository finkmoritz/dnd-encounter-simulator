package io.github.finkmoritz.dndencountersimulator

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.combatant.Combatant
import io.github.finkmoritz.dndencountersimulator.combatant.impl.Bugbear
import io.github.finkmoritz.dndencountersimulator.combatant.impl.Goblin
import io.github.finkmoritz.dndencountersimulator.combatant.impl.Wolf
import io.github.finkmoritz.dndencountersimulator.dice.Dice
import io.github.finkmoritz.dndencountersimulator.encounter.BasicEncounter
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategies

fun main() {
    val numberOfSimulations = 1000
    var survivalCount = 0

    for (i in 1..numberOfSimulations) {
        val party = mutableListOf<Combatant>(
            BaseCombatant("Kämpfer 1 (1)", 12u, 17u, -1, 5, Dice("1d12+3"), TargetingStrategies.WEAKEST),
            BaseCombatant("Kleriker 1", 11u, 18u, -1, 4, Dice("1d8+2"), TargetingStrategies.WEAKEST),
            BaseCombatant("Schurke 1", 9u, 14u, 3, 5, Dice("1d6+3"), TargetingStrategies.WEAKEST),
            BaseCombatant("Magier 1", 8u, 12u, 2, 5, Dice("3d4+3"), TargetingStrategies.WEAKEST),
            BaseCombatant("Kämpfer 1 (2)", 12u, 14u, 3, 4, Dice("2d6+2"), TargetingStrategies.WEAKEST),
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
            Goblin(),
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
            Wolf(targetingStrategy = TargetingStrategies.WEAKEST),
            // Goblin(),
            // Goblin(),
        )

        // BasicEncounter(party, goblinsAmbush).run()
        BasicEncounter(party, goblinsWatch).run()
        BasicEncounter(party, goblinsGuard).run()
        BasicEncounter(party, goblinsLiving).run()
        BasicEncounter(party, boss).run()

        if (party.any { it.hp() > 0u }) {
            survivalCount++
        }
    }

    println("Survival rate: ${survivalCount.toDouble() / numberOfSimulations * 100}%")
}
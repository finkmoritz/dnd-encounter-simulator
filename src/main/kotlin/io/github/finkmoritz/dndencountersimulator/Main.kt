package io.github.finkmoritz.dndencountersimulator

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.combatant.Combatant
import io.github.finkmoritz.dndencountersimulator.combatant.impl.Bugbear
import io.github.finkmoritz.dndencountersimulator.combatant.impl.Goblin
import io.github.finkmoritz.dndencountersimulator.combatant.impl.Wolf
import io.github.finkmoritz.dndencountersimulator.dice.Dice
import io.github.finkmoritz.dndencountersimulator.encounter.BasicEncounter
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

/**
 * Simulation of the first part of the Lost Mines of Phandelver adventure.
 */
fun main() {
    val verboseOutput = false

    val numberOfSimulations = 1000
    var survivalCount = 0
    var survivingPartyMembers = 0;

    for (i in 1..numberOfSimulations) {
        val party = mutableListOf<Combatant>(
            BaseCombatant("Fighter 1 (1)", 12u, 17u, -1, 5, Dice.fromExpression("1d12+3"), TargetingStrategy.WEAKEST),
            BaseCombatant("Cleric 1", 11u, 18u, -1, 4, Dice.fromExpression("1d8+2"), TargetingStrategy.WEAKEST),
            BaseCombatant("Rogue 1", 9u, 14u, 3, 5, Dice.fromExpression("1d6+3"), TargetingStrategy.WEAKEST),
            BaseCombatant("Sorcerer 1", 8u, 12u, 2, 5, Dice.fromExpression("3d4+3"), TargetingStrategy.WEAKEST),
            BaseCombatant("Fighter 1 (2)", 12u, 14u, 3, 4, Dice.fromExpression("2d6+2"), TargetingStrategy.WEAKEST),
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
            Wolf(targetingStrategy = TargetingStrategy.WEAKEST),
            // Goblin(),
            // Goblin(),
        )

        BasicEncounter(party, goblinsAmbush, surprised = party, verbose = verboseOutput).run()
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
    println("Average number of surviving party members: ${survivingPartyMembers.toDouble() / survivalCount}")
}
package io.github.finkmoritz.dndencountersimulator

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.combatant.Combatant
import io.github.finkmoritz.dndencountersimulator.combatant.impl.Bugbear
import io.github.finkmoritz.dndencountersimulator.combatant.impl.Goblin
import io.github.finkmoritz.dndencountersimulator.combatant.impl.Wolf
import io.github.finkmoritz.dndencountersimulator.encounter.BasicEncounter

fun main() {
    val numberOfSimulations = 1000
    var survivalCount = 0

    for (i in 1..numberOfSimulations) {
        val party = mutableListOf<Combatant>(
            BaseCombatant("Kämpfer 1 (1)", 12u, 17u, -1, 5, { (1..12).random().toUInt() + 3u }),
            BaseCombatant("Kleriker 1", 11u, 18u, -1, 4, { (1..8).random().toUInt() + 2u }),
            BaseCombatant("Schurke 1", 9u, 14u, 3, 5, { (1..6).random().toUInt() + 3u }),
            BaseCombatant("Magier 1", 8u, 12u, 2, 5, { ((1..4).random() + (1..4).random() + (1..4).random() + 3).toUInt() }),
            BaseCombatant("Kämpfer 1 (2)", 12u, 14u, 3, 4, { ((1..6).random() + (1..6).random() + 2).toUInt() }),
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
            Wolf(),
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
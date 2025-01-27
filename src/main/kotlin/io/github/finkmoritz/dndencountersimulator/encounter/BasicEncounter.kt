package io.github.finkmoritz.dndencountersimulator.encounter

import io.github.finkmoritz.dndencountersimulator.combatant.Combatant

class BasicEncounter(
    private val friendlyCombatants: MutableList<Combatant>,
    private val opposingCombatants: MutableList<Combatant>,
    ) : Encounter {

    override fun run() {
        val combatants = determineInitiativeOrder()
        println("Determined initiative order: ${combatants.map { it.name() }}")

        var initiativeIndex = 0

        while (friendlyCombatants.any { it.hp() > 0u } && opposingCombatants.any { it.hp() > 0u }) {

            val combatant = combatants[initiativeIndex]

            val target = if (friendlyCombatants.contains(combatant)) {
                opposingCombatants.random()
            } else {
                friendlyCombatants.random()
            }

            println("${combatant.name()} attacks ${target.name()}")

            if (combatant.rollAttack() >= target.ac()) {
                val damage = combatant.rollDamage()
                target.takeDamage(damage)
                println("${combatant.name()} hits ${target.name()} for $damage damage")

                if (target.hp() < 1u) {
                    combatants.remove(target)
                    friendlyCombatants.remove(target)
                    opposingCombatants.remove(target)
                    println("${target.name()} has been defeated")
                }
            }

            initiativeIndex = (initiativeIndex + 1) % combatants.size
        }
    }

    private fun determineInitiativeOrder(): MutableList<Combatant> {
        val initiativePerCombatant: List<Pair<UInt, Combatant>> =
            (friendlyCombatants + opposingCombatants).map { combatant ->
                Pair(
                    combatant.rollInitiative(),
                    combatant
                )
            }
        return initiativePerCombatant.sortedByDescending { it.first }.map { it.second }.toMutableList()
    }
}
package io.github.finkmoritz.dndencountersimulator.encounter

import io.github.finkmoritz.dndencountersimulator.combatant.Combatant

class BasicEncounter(
    party: List<Combatant>,
    opponents: List<Combatant>,
    surprised: List<Combatant> = emptyList(),
    private val verbose: Boolean,
    ) : Encounter {

    private val friendlyCombatants: MutableList<Combatant> = party.filter { it.hp() > 0u }.toMutableList()
    private val opposingCombatants: MutableList<Combatant> = opponents.filter { it.hp() > 0u }.toMutableList()

    private val surprisedCombatants: MutableList<Combatant> = surprised.filter { it.hp() > 0u }.toMutableList()

    override fun run() {
        val combatants = determineInitiativeOrder()
        printIfVerbose("Determined initiative order: ${combatants.map { it.name() }}")

        var initiativeIndex = 0

        while (friendlyCombatants.any { it.hp() > 0u } && opposingCombatants.any { it.hp() > 0u }) {

            val combatant = combatants[initiativeIndex]

            if (surprisedCombatants.remove(combatant)) {
                continue
            }

            val target = if (friendlyCombatants.contains(combatant)) {
                combatant.targetingStrategy().chooseTarget(opposingCombatants)
            } else {
                combatant.targetingStrategy().chooseTarget(friendlyCombatants)
            }

            printIfVerbose("${combatant.name()} attacks ${target.name()}")

            if (combatant.rollAttack() >= target.ac()) {
                val damage = combatant.rollDamage()
                target.takeDamage(damage)
                printIfVerbose("${combatant.name()} hits ${target.name()} for $damage damage")

                if (target.hp() < 1u) {
                    combatants.remove(target)
                    friendlyCombatants.remove(target)
                    opposingCombatants.remove(target)
                    printIfVerbose("${target.name()} has been defeated")
                }
            }

            initiativeIndex = (initiativeIndex + 1) % combatants.size
        }
    }

    private fun printIfVerbose(message: String) {
        if (verbose) {
            println(message)
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
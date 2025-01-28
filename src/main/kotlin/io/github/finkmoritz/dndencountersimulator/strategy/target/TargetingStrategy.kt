package io.github.finkmoritz.dndencountersimulator.strategy.target

import io.github.finkmoritz.dndencountersimulator.combatant.Combatant

interface TargetingStrategy {

    fun chooseTarget(targets: List<Combatant>): Combatant

    companion object {
        val RANDOM = object : TargetingStrategy {
            override fun chooseTarget(targets: List<Combatant>): Combatant {
                return targets.random()
            }
        }

        val HIGHEST_HP = object : TargetingStrategy {
            override fun chooseTarget(targets: List<Combatant>): Combatant {
                return targets.maxByOrNull { it.hp() } ?: throw NoSuchElementException("No targets available")
            }
        }

        val LOWEST_HP = object : TargetingStrategy {
            override fun chooseTarget(targets: List<Combatant>): Combatant {
                return targets.minByOrNull { it.hp() } ?: throw NoSuchElementException("No targets available")
            }
        }

        val HIGHEST_AC = object : TargetingStrategy {
            override fun chooseTarget(targets: List<Combatant>): Combatant {
                return targets.maxByOrNull { it.ac() } ?: throw NoSuchElementException("No targets available")
            }
        }

        val LOWEST_AC = object : TargetingStrategy {
            override fun chooseTarget(targets: List<Combatant>): Combatant {
                return targets.minByOrNull { it.ac() } ?: throw NoSuchElementException("No targets available")
            }
        }
    }
}

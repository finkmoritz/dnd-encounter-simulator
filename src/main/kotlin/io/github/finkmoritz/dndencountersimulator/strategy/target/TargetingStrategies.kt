package io.github.finkmoritz.dndencountersimulator.strategy.target

import io.github.finkmoritz.dndencountersimulator.combatant.Combatant

enum class TargetingStrategies : TargetingStrategy {

    RANDOM {
        override fun chooseTarget(targets: List<Combatant>): Combatant {
            return targets.random()
        }
    },
    STRONGEST {
        override fun chooseTarget(targets: List<Combatant>): Combatant {
            return targets.maxBy { it.hp() }
        }
    },
    WEAKEST {
        override fun chooseTarget(targets: List<Combatant>): Combatant {
            return targets.minBy { it.hp() }
        }
    }
}
package io.github.finkmoritz.dndencountersimulator.strategy.target

import io.github.finkmoritz.dndencountersimulator.combatant.Combatant

interface TargetingStrategy {

    fun chooseTarget(targets: List<Combatant>): Combatant
}
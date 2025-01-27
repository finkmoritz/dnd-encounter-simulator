package io.github.finkmoritz.dndencountersimulator.combatant.impl

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.dice.Dice
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class Goblin(
    name: String = "Goblin",
    hp: UInt = 7u,
    ac: UInt = 15u,
    initiativeBonus: Int = 2,
    attackBonus: Int = 4,
    damageDice: Dice = Dice("1d6+2"),
    targetingStrategy: TargetingStrategy = TargetingStrategy.RANDOM,
) : BaseCombatant(
    name,
    hp,
    ac,
    initiativeBonus,
    attackBonus,
    damageDice,
    targetingStrategy,
)
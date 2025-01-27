package io.github.finkmoritz.dndencountersimulator.combatant.impl

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.dice.Dice
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class Wolf(
    name: String = "Wolf",
    hp: UInt = 11u,
    ac: UInt = 13u,
    initiativeBonus: Int = 2,
    attackBonus: Int = 4,
    damageDice: Dice = Dice.fromExpression("2d4+2"),
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
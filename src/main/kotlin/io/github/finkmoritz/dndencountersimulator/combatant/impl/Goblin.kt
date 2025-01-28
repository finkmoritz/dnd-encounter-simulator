package io.github.finkmoritz.dndencountersimulator.combatant.impl

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.dice.Dice
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class Goblin(
    name: String = "Goblin",
    hp: UInt = 7u,
    ac: UInt = 15u,
    initiativeBonus: Int = 2,
    attackBonus: Int = 4,
    damageDice: DamageDice = DamageDice.fromExpressions("1d6+2", DamageType.SLASHING),
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
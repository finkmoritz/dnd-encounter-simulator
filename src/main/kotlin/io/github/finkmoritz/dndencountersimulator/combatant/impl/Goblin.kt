package io.github.finkmoritz.dndencountersimulator.combatant.impl

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class Goblin(
    name: String = "Goblin",
    maxHp: UInt = 7u,
    ac: UInt = 15u,
    initiativeBonus: Int = 2,
    attackBonus: Int = 4,
    damageDice: DamageDice = DamageDice.fromExpressions("1d6+2", DamageType.SLASHING),
    hp: UInt = maxHp,
    targetingStrategy: TargetingStrategy = TargetingStrategy.RANDOM,
) : BaseCombatant(
    name,
    maxHp,
    ac,
    initiativeBonus,
    attackBonus,
    damageDice,
    hp = hp,
    targetingStrategy = targetingStrategy,
)
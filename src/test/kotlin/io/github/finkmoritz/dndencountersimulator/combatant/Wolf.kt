package io.github.finkmoritz.dndencountersimulator.combatant

import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class Wolf(
    name: String = "Wolf",
    maxHp: UInt = 11u,
    ac: UInt = 13u,
    initiativeBonus: Int = 2,
    attackBonus: Int = 4,
    damageDice: DamageDice = DamageDice.fromExpressions("2d4+2", DamageType.PIERCING),
    hp: UInt = maxHp,
    multiAttack: UInt = 1u,
    targetingStrategy: TargetingStrategy = TargetingStrategy.RANDOM,
) : BaseCombatant(
    name,
    maxHp,
    ac,
    initiativeBonus,
    attackBonus,
    damageDice,
    hp = hp,
    multiAttack = multiAttack,
    targetingStrategy = targetingStrategy,
    )
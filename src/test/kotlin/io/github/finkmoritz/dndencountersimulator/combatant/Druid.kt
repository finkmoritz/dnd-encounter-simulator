package io.github.finkmoritz.dndencountersimulator.combatant

import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class Druid(
    name: String = "Druid",
    maxHp: UInt = 27u,
    ac: UInt = 16u, // assume barkskin
    initiativeBonus: Int = 1,
    attackBonus: Int = 2,
    damageDice: DamageDice = DamageDice.fromExpressions("1d8", DamageType.BLUDGEONING),
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
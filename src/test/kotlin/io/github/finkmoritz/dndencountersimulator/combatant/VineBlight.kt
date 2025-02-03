package io.github.finkmoritz.dndencountersimulator.combatant

import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class VineBlight(
    name: String = "Vine Blight",
    maxHp: UInt = 26u,
    ac: UInt = 12u,
    initiativeBonus: Int = -1,
    attackBonus: Int = 4,
    damageDice: DamageDice = DamageDice.fromExpressions("2d6+2", DamageType.BLUDGEONING),
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
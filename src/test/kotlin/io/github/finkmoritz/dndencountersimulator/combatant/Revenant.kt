package io.github.finkmoritz.dndencountersimulator.combatant

import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class Revenant(
    name: String = "Revenant",
    maxHp: UInt = 136u,
    ac: UInt = 13u,
    initiativeBonus: Int = 2,
    attackBonus: Int = 7,
    damageDice: DamageDice = DamageDice.fromExpressions("2d6+4", DamageType.BLUDGEONING),
    hp: UInt = maxHp,
    multiAttack: UInt = 2u,
    targetingStrategy: TargetingStrategy = TargetingStrategy.LOWEST_HP,
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
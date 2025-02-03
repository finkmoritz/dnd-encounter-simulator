package io.github.finkmoritz.dndencountersimulator.combatant

import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class TwigBlight(
    name: String = "Twig Blight",
    maxHp: UInt = 4u,
    ac: UInt = 13u,
    initiativeBonus: Int = 1,
    attackBonus: Int = 3,
    damageDice: DamageDice = DamageDice.fromExpressions("1d4+1", DamageType.PIERCING),
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
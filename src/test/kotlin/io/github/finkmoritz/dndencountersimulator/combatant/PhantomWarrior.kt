package io.github.finkmoritz.dndencountersimulator.combatant

import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class PhantomWarrior(
    name: String = "Phantom Warrior",
    maxHp: UInt = 45u,
    ac: UInt = 16u,
    initiativeBonus: Int = 0,
    attackBonus: Int = 5,
    damageDice: DamageDice = DamageDice.fromExpressions("1d8+3", DamageType.FORCE),
    hp: UInt = maxHp,
    multiAttack: UInt = 2u,
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
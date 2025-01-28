package io.github.finkmoritz.dndencountersimulator.combatant.impl

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class Bugbear(
    name:String = "Bugbear",
    maxHp:UInt = 27u,
    ac:UInt = 16u,
    initiativeBonus:Int = 2,
    attackBonus:Int = 4,
    damageDice: DamageDice = DamageDice.fromExpressions("2d6+2", DamageType.PIERCING),
    hp:UInt = maxHp,
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
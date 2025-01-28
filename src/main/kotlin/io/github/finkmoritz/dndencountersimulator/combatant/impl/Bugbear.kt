package io.github.finkmoritz.dndencountersimulator.combatant.impl

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant
import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.damage.DamageType
import io.github.finkmoritz.dndencountersimulator.dice.Dice
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

class Bugbear(
    name:String = "Bugbear",
    hp:UInt = 27u,
    ac:UInt = 16u,
    initiativeBonus:Int = 2,
    attackBonus:Int = 4,
    damageDice: DamageDice = DamageDice.fromExpressions("2d6+2", DamageType.PIERCING),
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
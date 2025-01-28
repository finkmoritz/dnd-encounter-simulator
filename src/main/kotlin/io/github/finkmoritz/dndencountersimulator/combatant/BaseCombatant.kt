package io.github.finkmoritz.dndencountersimulator.combatant

import io.github.finkmoritz.dndencountersimulator.damage.Damage
import io.github.finkmoritz.dndencountersimulator.damage.DamageDice
import io.github.finkmoritz.dndencountersimulator.dice.Dice
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

open class BaseCombatant(
    private val name: String,
    private var hp: UInt,
    private val ac: UInt,
    private val initiativeBonus: Int,
    private val attackBonus: Int,
    private val damageDice: DamageDice,
    private val targetingStrategy: TargetingStrategy = TargetingStrategy.RANDOM,
    ) : Combatant {

    override fun name(): String {
        return name
    }

    override fun hp(): UInt {
        return hp
    }

    override fun ac(): UInt {
        return ac
    }

    override fun rollInitiative(): UInt {
        return Dice(1u, 20u, initiativeBonus).roll()
    }

    override fun rollAttack(): UInt {
        return Dice(1u, 20u, attackBonus).roll()
    }

    override fun rollDamage(): Damage {
        return damageDice.roll()
    }

    override fun takeDamage(damage: Damage) {
        hp = if (hp > damage.amount) hp - damage.amount else 0u
        hp = if (damage.extraAmount != null && hp > damage.extraAmount) hp - damage.extraAmount else 0u
    }

    override fun targetingStrategy(): TargetingStrategy {
        return targetingStrategy
    }
}
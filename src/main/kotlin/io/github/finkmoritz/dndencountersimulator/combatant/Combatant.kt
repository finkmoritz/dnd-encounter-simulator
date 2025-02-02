package io.github.finkmoritz.dndencountersimulator.combatant

import io.github.finkmoritz.dndencountersimulator.damage.Damage
import io.github.finkmoritz.dndencountersimulator.strategy.target.TargetingStrategy

interface Combatant {

    fun name(): String

    fun maxHp(): UInt

    fun hp(): UInt

    fun ac(): UInt

    fun rollInitiative(): UInt

    fun rollAttack(): UInt

    fun multiAttack(): UInt

    fun rollDamage(): Damage

    fun takeDamage(damage: Damage)

    fun heal(amount: UInt)

    fun targetingStrategy(): TargetingStrategy

    fun isAlive(): Boolean {
        return hp() > 0u
    }

    fun isDead(): Boolean {
        return !isAlive()
    }
}
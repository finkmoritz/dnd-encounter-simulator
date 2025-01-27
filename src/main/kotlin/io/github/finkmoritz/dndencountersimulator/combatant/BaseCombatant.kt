package io.github.finkmoritz.dndencountersimulator.combatant

import kotlin.math.max

open class BaseCombatant(
    private val name: String,
    private var hp: UInt,
    private val ac: UInt,
    private val initiativeBonus: Int,
    private val attackBonus: Int,
    private val damageRoll: () -> UInt,
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
        return max(1, (1..20).random() + initiativeBonus).toUInt()
    }

    override fun rollAttack(): UInt {
        return max(1, (1..20).random() + attackBonus).toUInt()
    }

    override fun rollDamage(): UInt {
        return damageRoll()
    }

    override fun takeDamage(amount: UInt) {
        hp = max(0, hp.toInt() - amount.toInt()).toUInt()
    }
}
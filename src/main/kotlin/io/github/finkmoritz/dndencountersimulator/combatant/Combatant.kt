package io.github.finkmoritz.dndencountersimulator.combatant

interface Combatant {

    fun name(): String

    fun hp(): UInt

    fun ac(): UInt

    fun rollInitiative(): UInt

    fun rollAttack(): UInt

    fun rollDamage(): UInt

    fun takeDamage(amount: UInt)
}
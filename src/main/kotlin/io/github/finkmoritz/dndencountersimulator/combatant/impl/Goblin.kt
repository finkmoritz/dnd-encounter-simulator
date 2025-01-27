package io.github.finkmoritz.dndencountersimulator.combatant.impl

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant

class Goblin : BaseCombatant("Goblin", 7u, 15u, 2, 4, { (1..6).random().toUInt() + 2u })
package io.github.finkmoritz.dndencountersimulator.combatant.impl

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant

class Wolf : BaseCombatant("Wolf", 11u, 13u, 2, 4, { ((1..4).random() + (1..4).random() + 2).toUInt() })
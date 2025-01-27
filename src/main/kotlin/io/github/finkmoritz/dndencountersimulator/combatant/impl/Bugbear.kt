package io.github.finkmoritz.dndencountersimulator.combatant.impl

import io.github.finkmoritz.dndencountersimulator.combatant.BaseCombatant

class Bugbear : BaseCombatant("Bugbear", 27u, 16u, 2, 4, { ((1..6).random() + (1..6).random() + 2).toUInt() })
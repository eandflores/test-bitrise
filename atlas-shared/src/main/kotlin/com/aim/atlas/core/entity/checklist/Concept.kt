package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
data class Concept(
        val id: Long = 0L,
        var name: String? = null,
        var color: String? = null,
        var isPonderated: Boolean? = null,
        var labels: List<Label>? = null)

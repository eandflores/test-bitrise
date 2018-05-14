package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
data class  StepLabel(val id: Long) {
    final var weight: Float? = null
    final var place: Int? = null
    final var label: Label? = null

    constructor(id: Long,
                weight: Float,
                place: Int,
                label: Label) : this(id) {
        this.weight = weight
        this.place = place
        this.label = label
    }
}
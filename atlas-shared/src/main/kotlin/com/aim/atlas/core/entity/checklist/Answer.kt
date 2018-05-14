package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.valueObjects.Trilean

@TestOpen
class Answer(val id: Long) {
    final var isGraded: Boolean? = null
    final var allowNA: Boolean? = null
    final var umbralOperator: String? = null
    final var umbralValue: Int? = null
    final var description: Trilean? = null
    final var attachment: Trilean? = null
    final var picture: Trilean? = null
    final var gps: Trilean? = null
    final var stepConditioners: List<StepConditioner>? = null

    constructor(id: Long,
                isGraded: Boolean,
                allowNA: Boolean,
                umbralOperator: String,
                umbralValue: Int,
                description: Trilean,
                attachment: Trilean,
                picture: Trilean,
                gps: Trilean,
                stepConditioners: List<StepConditioner>) : this(id) {
        this.isGraded = isGraded
        this.allowNA = allowNA
        this.umbralOperator = umbralOperator
        this.umbralValue = umbralValue
        this.description = description
        this.attachment = attachment
        this.picture = picture
        this.gps = gps
        this.stepConditioners = stepConditioners
    }

}
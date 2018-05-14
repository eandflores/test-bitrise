package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.valueObjects.Trilean

@TestOpen
data class MultipleChoiceAnswer(override val id: Long) : Answer(id) {
    final var options: List<MultipleChoiceOption>? = null

    constructor(id: Long,
                isGraded: Boolean,
                allowNA: Boolean,
                umbralOperator: String,
                umbralValue: Int,
                description: Trilean,
                attachment: Trilean,
                picture: Trilean,
                gps: Trilean,
                stepConditioners: List<StepConditioner>,
                options: List<MultipleChoiceOption>) : this(id) {
        this.isGraded = isGraded
        this.allowNA = allowNA
        this.umbralOperator = umbralOperator
        this.umbralValue = umbralValue
        this.description = description
        this.attachment = attachment
        this.picture = picture
        this.gps = gps
        this.stepConditioners = stepConditioners
        this.options = options
    }
}
package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen
import java.time.LocalDateTime

@TestOpen
data class StepGrade(val id: Long) {
    final var grade: Number? = null
    final var gradeTime: LocalDateTime? = null
    final var picture: String? = null
    final var description: String? = null
    final var attachment: String? = null
    final var stepId: Long? = null
    final var executionId: Long? = null

    constructor(id: Long,
                grade: Number,
                gradeTime: LocalDateTime,
                picture: String,
                description: String,
                attachment: String,
                stepId: Long,
                executionId: Long) : this(id) {
        this.grade = grade
        this.gradeTime = gradeTime
        this.picture = picture
        this.description = description
        this.attachment = attachment
        this.stepId = stepId
        this.executionId = executionId
    }
}
package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
data class ConceptGrade(val id: Long) {
    final var grade: Int? = null
    final var executionId: Long? = null
    final var conceptId: Long? = null
    final var labelGrades: List<LabelGrade>? = null

    constructor(id: Long,
                grade: Int,
                executionId: Long,
                conceptId: Long,
                labelGrades: List<LabelGrade>) : this(id) {
        this.grade = grade
        this.executionId = executionId
        this.labelGrades = labelGrades
        this.conceptId = conceptId
    }
}
package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
data class LabelGrade(val id: Long) {
    final var grade: Int? = null
    final var conceptGradeId: Long? = null
    final var labelId: Long? = null

    constructor(id: Long,
                grade: Int,
                conceptGradeId: Long,
                labelId: Long) : this(id) {
        this.grade = grade
        this.conceptGradeId = conceptGradeId
        this.labelId = labelId
    }
}
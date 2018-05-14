package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
data class MultipleChoiceOption(val id: Long) {
    final var name: String? = null
    final var grade: Int? = null
    final var answerId: Long? = null

    constructor(id: Long,
                name: String,
                grade: Int,
                answerId: Long) : this(id) {
        this.name = name
        this.grade = grade
        this.answerId = answerId
    }
}
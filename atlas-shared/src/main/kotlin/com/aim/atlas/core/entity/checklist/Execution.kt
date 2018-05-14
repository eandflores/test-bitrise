package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen
import java.time.LocalDateTime

@TestOpen
data class Execution(val id: Long) {
    final var startTime: LocalDateTime? = null
    final var endTime: LocalDateTime? = null
    final var gpsLatitude: String? = null
    final var gpsLongitude: String? = null
    final var checklistId: Long? = null
    final var stepGrades: List<StepGrade>? = null
    final var conceptGrades: List<ConceptGrade>? = null

    constructor(id: Long,
                startTime: LocalDateTime,
                endTime: LocalDateTime,
                gpsLatitude: String,
                gpsLongitude: String,
                checklistId: Long,
                stepGrades: List<StepGrade>,
                conceptGrades: List<ConceptGrade>) : this(id) {
        this.startTime = startTime
        this.endTime = endTime
        this.gpsLatitude = gpsLatitude
        this.gpsLongitude = gpsLongitude
        this.checklistId = checklistId
        this.stepGrades = stepGrades
        this.conceptGrades = conceptGrades
    }
}
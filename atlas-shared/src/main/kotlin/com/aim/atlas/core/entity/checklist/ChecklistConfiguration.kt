package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen
import java.time.LocalDateTime

@TestOpen
data class ChecklistConfiguration(
        val id: Long,
        var minGrade: Int? = null,
        var maxGrade: Int? = null,
        var interval: Int? = null,
        var executionTime: Int? = null,
        var publicationTime: LocalDateTime? = null,
        var expirationTime: LocalDateTime? = null,
        var withVenue: Boolean? = null,
        var withAsset: Boolean? = null,
        var withService: Boolean? = null,
        var tourConceptId: Long? = null,
        var defaultConceptId: Long? = null)
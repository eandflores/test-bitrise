package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen
import java.time.LocalDateTime

@TestOpen
data class Checklist(
        val id: Long = 0L,
        var businessAreaId: Long? = null,
        var name: String? = null,
        var description: String? = null,
        var icon: String? = null,
        var testMode: Boolean? = null,
        var createdAt: LocalDateTime? = null,
        var updatedAt: LocalDateTime? = null,
        var concepts: List<Concept>? = null,
        var steps: List<Step>? = null,
        var configuration: ChecklistConfiguration? = null)
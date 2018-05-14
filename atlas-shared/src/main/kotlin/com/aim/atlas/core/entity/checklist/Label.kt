package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
data class Label(
        val id: Long = 0L,
        var name: String? = null,
        var place: Int? = null,
        var weight: Float? = null)
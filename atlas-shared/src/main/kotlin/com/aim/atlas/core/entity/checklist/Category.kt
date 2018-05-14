package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
data class Category(val id: Long) {
    final var businessAreaId: Long? = null
    final var name: String? = null
    final var icon: String? = null
    final var checklists: List<Checklist>? = null


    constructor(id: Long,
                businessAreaId: Long,
                name: String,
                icon: String,
                checklists: List<Checklist>? = null) : this(id) {
        this.businessAreaId = businessAreaId
        this.name = name
        this.icon = icon
        this.checklists = checklists
    }
}
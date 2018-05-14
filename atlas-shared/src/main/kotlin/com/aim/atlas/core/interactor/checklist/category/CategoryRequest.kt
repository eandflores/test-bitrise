package com.aim.atlas.core.interactor.checklist.category

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class CategoryRequest() : RequestModel {
    final var id: Long? = 0
    final var businessAreaId: Long? = null
    final var name: String? = null
    final var icon: String? = null
}
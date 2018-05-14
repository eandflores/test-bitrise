package com.aim.atlas.core.interactor.checklist.category

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel

@TestOpen
data class CategoryResponse(val id: Long,
                            val name: String,
                            val icon: String,
                            val businessAreaId: Long) : ResponseModel
package com.aim.atlas.core.interactor.checklist.category

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class ToggleChecklistRequest() : RequestModel {
    var categoryId: Long? = null
    var checklistId: Long? = null
}
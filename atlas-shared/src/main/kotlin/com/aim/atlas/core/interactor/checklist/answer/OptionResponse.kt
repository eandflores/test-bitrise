package com.aim.atlas.core.interactor.checklist.answer

import com.aim.atlas.core.boundary.ResponseModel

class OptionResponse(
        val id: Long,
        var name: String,
        var grade: Int
): ResponseModel
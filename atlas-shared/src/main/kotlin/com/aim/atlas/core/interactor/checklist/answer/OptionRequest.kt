package com.aim.atlas.core.interactor.checklist.answer

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class OptionRequest : RequestModel {
    lateinit var name: String
    var grade: Int? = 0
}
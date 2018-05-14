package com.aim.atlas.core.interactor.checklist.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel
import com.aim.atlas.core.interactor.checklist.concept.ConceptRequest
import com.aim.atlas.core.interactor.checklist.configuration.ConfigurationRequest
import com.aim.atlas.core.interactor.checklist.step.StepRequest

@TestOpen
class ChecklistRequest() : RequestModel{
    var id: Long = 0L
    lateinit var name: String
    lateinit var description: String
    lateinit var icon: String
    var testMode: Boolean = true
    lateinit var concepts: List<Long>
    lateinit var steps: List<StepRequest>
    lateinit var configuration: ConfigurationRequest
}


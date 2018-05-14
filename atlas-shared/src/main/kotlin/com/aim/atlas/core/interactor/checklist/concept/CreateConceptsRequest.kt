package com.aim.atlas.core.interactor.checklist.concept

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
class CreateConceptsRequest {
    var checklistId: Long? = null
    lateinit var concepts: List<ConceptRequest>
}

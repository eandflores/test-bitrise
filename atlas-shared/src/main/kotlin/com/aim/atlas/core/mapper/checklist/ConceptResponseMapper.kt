package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Concept
import com.aim.atlas.core.interactor.checklist.concept.ConceptResponse
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@TestOpen
@Named
class ConceptResponseMapper(private val labelMapper: LabelResponseMapper): Mapper<Concept, ConceptResponse> {
    override fun transform(source: Concept): ConceptResponse {
        return with(source) {
            ConceptResponse(
                    id,
                    name!!,
                    color!!,
                    isPonderated!!,
                    labels!!.map { labelMapper.transform(it) }
            )
        }
    }
}
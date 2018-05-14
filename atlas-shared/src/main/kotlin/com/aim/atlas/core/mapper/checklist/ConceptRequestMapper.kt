package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Concept
import com.aim.atlas.core.interactor.checklist.concept.ConceptRequest
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@TestOpen
@Named
class ConceptRequestMapper(
        private val labelMapper: LabelRequestMapper
)
    : Mapper<ConceptRequest, Concept>, ListMapper<ConceptRequest, Concept> {
    override fun transform(source: ConceptRequest): Concept {
        return Concept(source.id).apply {
            name = source.name
            color = source.color
            isPonderated = source.isPonderated
            labels = labelMapper.transform(source.labels)
        }
    }

    override fun transform(source: List<ConceptRequest>): List<Concept> {
        return source.map { this.transform(it) }
    }
}
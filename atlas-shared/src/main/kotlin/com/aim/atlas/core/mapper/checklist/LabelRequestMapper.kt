package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.Label
import com.aim.atlas.core.interactor.checklist.label.LabelRequest
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class LabelRequestMapper : Mapper<LabelRequest, Label>, ListMapper<LabelRequest, Label> {
    override fun transform(source: LabelRequest): Label {
        return Label(source.id).apply {
            name = source.name
            place = source.place
            weight = source.weight
        }
    }

    override fun transform(source: List<LabelRequest>): List<Label> {
        return source.map { this.transform(it) }
    }
}
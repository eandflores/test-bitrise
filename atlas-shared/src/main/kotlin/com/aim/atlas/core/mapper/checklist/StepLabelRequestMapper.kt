package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.Label
import com.aim.atlas.core.entity.checklist.StepLabel
import com.aim.atlas.core.interactor.checklist.step.StepLabelRequest
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.repository.checklist.LabelRepository
import javax.inject.Named

@Named
class StepLabelRequestMapper(private val labelRepository: LabelRepository): Mapper<StepLabelRequest, StepLabel> {
    override fun transform(source: StepLabelRequest): StepLabel {
        return StepLabel(source.id).apply {
            weight = source.weight
            place = source.place
            label = labelRepository.findById(source.labelId!!).blockingGet()
        }
    }

}
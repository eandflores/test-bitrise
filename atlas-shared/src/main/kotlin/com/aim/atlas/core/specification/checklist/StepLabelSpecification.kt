package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.StepLabel
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class StepLabelSpecification: AbstractSpecification<StepLabel>() {
    override fun isSatisfiedBy(candidate: StepLabel): Boolean {
        /* Weight must be equal or greater than 0 */
        if (candidate.weight!! < 0) return false

        /* Place must be greater than 0 */
        if (candidate.place!! <= 0) return false

        /* All good */
        return true
    }
}
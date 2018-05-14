package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Step
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class StepSpecification(
        private val stepLabelSpecification: StepLabelSpecification,
        private val answerSpecification: AnswerSpecification
): AbstractSpecification<Step>() {
    override fun isSatisfiedBy(candidate: Step): Boolean {
        /* Name must be equal or greater than 3 */
        if (candidate.name!!.length < 3) return false

        /* Answer must be valid */
        if (!answerSpecification.isSatisfiedBy(candidate.answer!!)) return false

        /* Step Labels must be valid */
        candidate.stepLabels!!.forEach {
            if (!stepLabelSpecification.isSatisfiedBy(it)) return false
        }

        /* All good */
        return true
    }
}
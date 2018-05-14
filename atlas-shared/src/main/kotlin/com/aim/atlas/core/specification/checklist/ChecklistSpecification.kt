package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Checklist
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class ChecklistSpecification(
    private val configurationSpecification: ConfigurationSpecification,
    private val stepSpecification: StepSpecification
): AbstractSpecification<Checklist>() {

    override fun isSatisfiedBy(candidate: Checklist): Boolean {
        /* Name length must be equal or greater than 3 */
        if (candidate.name!!.length < 3) return false

        /* Must have icon */
        if (candidate.icon == null) return false

        /* Must have business area id */
        if (candidate.businessAreaId == null) return false

        /* Checklist configuration must be valid */
        if (!configurationSpecification.isSatisfiedBy(candidate.configuration!!)) return false

        /* Must have concepts */
        if (candidate.concepts!!.isEmpty()) return false

        /* Must have steps */
        if (candidate.steps!!.isEmpty()) return false

        /* Each step must be valid */
        candidate.steps!!.forEach {
            if (it.answer!!.umbralValue!! < candidate.configuration!!.minGrade!!) return false
            if (it.answer!!.umbralValue!! > candidate.configuration!!.maxGrade!!) return false
            if (!stepSpecification.isSatisfiedBy(it)) return false
        }

        /* All good */
        return true
    }
}
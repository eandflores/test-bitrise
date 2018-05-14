package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Concept
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class ConceptSpecification(private val labelSpecification: LabelSpecification): AbstractSpecification<Concept>() {

    private val colorPattern = Regex("^#(?:[0-9a-fA-F]{3}){1,2}\$")

    override fun isSatisfiedBy(candidate: Concept): Boolean {
        /* Names equal or greater than 3 */
        if (candidate.name!!.length < 3) return false

        /* Color must match a hexadecimal pattern */
        if (!candidate.color!!.matches(colorPattern)) return false

        /* Concept must have labels */
        if (candidate.labels!!.isEmpty()) return false

        /* Labels names must be different */
        if (candidate.labels!!.distinctBy { it.name }.size != candidate.labels!!.size) return false

        /* Check labels specification */
        candidate.labels!!.forEach {
            if(!labelSpecification.isSatisfiedBy(it)) return false
        }

        /* All good */
        return true
    }
}
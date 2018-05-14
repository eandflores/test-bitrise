package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Label
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class LabelSpecification: AbstractSpecification<Label>() {
    override fun isSatisfiedBy(candidate: Label): Boolean {
        /* Names equal or greater than 3 */
        if (candidate.name!!.length < 3) return false

        /* Weight must be greater than 0 */
        if (candidate.weight!! < 0) return false

        /* Place must be greater than 0 */
        if (candidate.place!! < 0) return false

        /* All good */
        return true
    }
}
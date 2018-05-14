package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Answer
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class AnswerSpecification: AbstractSpecification<Answer>() {
    private val umbralPattern = Regex("^(^(!=)?|^(<=)?|^(>=)?|^(==)?|^(<)?|^(>)?)?")

    override fun isSatisfiedBy(candidate: Answer): Boolean {
        /* Umbral Operator must match umbral pattern */
        if (!candidate.umbralOperator!!.matches(umbralPattern)) return false

        /* All good */
        return true
    }
}
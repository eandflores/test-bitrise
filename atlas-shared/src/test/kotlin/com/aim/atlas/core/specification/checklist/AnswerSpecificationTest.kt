package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.entity.checklist.Answer
import com.aim.atlas.core.valueObjects.Trilean
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class AnswerSpecificationTest {
    private lateinit var specification: AnswerSpecification

    private lateinit var goodAnswer: Answer
    private lateinit var badUmbralOperatorAnswer: Answer

    @Before
    fun setUp() {
        specification = AnswerSpecification()

        goodAnswer = Answer(0L, true, true, "<=", 5, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.REQUIRED, listOf())
        badUmbralOperatorAnswer = Answer(0L, true, true, "=<", 5, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.OPTIONAL, Trilean.REQUIRED, listOf())
    }

    @Test
    fun isSatisfiedBy() {
        assertEquals(true, specification.isSatisfiedBy(goodAnswer))
    }

    @Test
    fun isNotSatisfiedByUmbralOperator() {
        assertEquals(false, specification.isSatisfiedBy(badUmbralOperatorAnswer))
    }
}
package com.aim.atlas.core.repository.checklist

import com.aim.atlas.core.entity.checklist.Answer
import com.aim.atlas.core.entity.checklist.RangeAnswer
import io.reactivex.Maybe

interface AnswerRepository {
    fun create(answer: Answer): Maybe<Answer>
    fun update(answer: Answer): Maybe<Answer>
    fun delete(id: Long): Maybe<Void>
}
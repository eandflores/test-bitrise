package com.aim.atlas.core.specification

interface Specification<T> {

    /**
     * Ensures that the candidate satisfy the minimun validations
     */
    fun isSatisfiedBy(candidate: T) : Boolean

    fun and(specification: Specification<T>) : Specification<T>

    fun or(specification: Specification<T>) : Specification<T>

    fun not(specification: Specification<T>) : Specification<T>

}
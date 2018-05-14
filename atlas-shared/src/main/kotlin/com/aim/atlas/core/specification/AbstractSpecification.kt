package com.aim.atlas.core.specification

abstract class AbstractSpecification<T> : Specification<T> {
    abstract override fun isSatisfiedBy(candidate: T) : Boolean

    override fun and(specification: Specification<T>) : Specification<T> {
        return AndSpecification<T>(this, specification)
    }

    override fun or(specification: Specification<T>) : Specification<T> {
        return OrSpecification<T>(this, specification)
    }

    override fun not(specification: Specification<T>) : Specification<T> {
        return NotSpecification<T>(this)
    }
}
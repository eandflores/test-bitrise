package com.aim.atlas.core.specification

open class NotSpecification<T>(
        private var spec : Specification<T>
) : AbstractSpecification<T>() {

    override fun isSatisfiedBy(t: T) : Boolean {
        return !spec.isSatisfiedBy(t)
    }
}
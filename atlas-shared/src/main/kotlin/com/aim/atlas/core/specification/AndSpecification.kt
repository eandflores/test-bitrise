package com.aim.atlas.core.specification

open class AndSpecification<T>(
        private var spec1 : Specification<T>,
        private var spec2 : Specification<T>
) : AbstractSpecification<T>() {

    override fun isSatisfiedBy(t: T) : Boolean {
        return spec1.isSatisfiedBy(t) && spec2.isSatisfiedBy(t)
    }

}
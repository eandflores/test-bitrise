package com.aim.atlas.core.mapper

interface ListMapper<S,T> {

    /**
     * Transforms a list of objects
     */
    fun transform(source: List<S>) : List<T>
}
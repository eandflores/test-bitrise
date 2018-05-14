package com.aim.atlas.core.mapper

interface Mapper<S, T> {

    /**
     * Transform a single object
     */
    fun transform(source: S) : T

}
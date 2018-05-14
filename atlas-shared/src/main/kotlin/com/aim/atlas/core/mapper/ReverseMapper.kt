package com.aim.atlas.core.mapper

interface ReverseMapper<S,T> {

    fun reverseTransform(source: T) : S
}
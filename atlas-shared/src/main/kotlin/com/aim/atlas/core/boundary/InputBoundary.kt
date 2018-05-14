package com.aim.atlas.core.boundary

interface InputBoundary<T, U> {

    /** This method set the input for the [Interactor] */
    fun input(input: T) : U
}
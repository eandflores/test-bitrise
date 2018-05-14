package com.aim.atlas.core.interactor

import io.reactivex.Flowable
import io.reactivex.Observable

open abstract class Interactor<T> {

    /** This is the signature for command pattern of Interactors **/
    abstract fun execute() : Flowable<T>

//    /** Handler of execute for response model override */
//    fun <U> execute(presenter: (T) -> U) : U {
//        return presenter(execute())
//    }
}
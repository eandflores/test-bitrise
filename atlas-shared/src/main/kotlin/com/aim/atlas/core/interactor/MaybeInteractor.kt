package com.aim.atlas.core.interactor

import io.reactivex.Maybe

abstract class MaybeInteractor<T> {
    abstract fun execute(): Maybe<T>
}
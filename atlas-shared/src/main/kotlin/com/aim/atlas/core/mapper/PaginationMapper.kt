package com.aim.atlas.core.mapper

import com.aim.atlas.core.interactor.Pagination

interface PaginationMapper<S,T> {

    /**
     * Transform a pagination of objects
     */
    fun transform(source: Pagination<S>) : Pagination<T>
}
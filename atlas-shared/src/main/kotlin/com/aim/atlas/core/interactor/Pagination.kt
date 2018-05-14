package com.aim.atlas.core.interactor

class Pagination<T> (
    val root: List<T>,
    val size: Int,
    val page: Int,
    val place: String,
    val totalElements: Long,
    val totalPages: Int
)
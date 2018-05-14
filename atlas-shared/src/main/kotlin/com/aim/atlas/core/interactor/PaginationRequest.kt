package com.aim.atlas.core.interactor

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class PaginationRequest<T>(
        val input : T,
        val page : Int = 1,
        val size : Int = 10,
        val place : String
) : RequestModel
package com.aim.atlas.core.mapper

interface FullMapper<S,T> : PaginationMapper<S,T>, ReverseMapper<S,T>, ListMapper<S,T>, Mapper<S,T>
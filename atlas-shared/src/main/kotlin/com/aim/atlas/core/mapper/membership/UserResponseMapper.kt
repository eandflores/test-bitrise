package com.aim.atlas.core.mapper.membership

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.membership.User
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.membership.user.UserResponseModel
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import javax.inject.Named

@TestOpen
@Named
class UserResponseMapper :
        Mapper<User, UserResponseModel>,
        ListMapper<User, UserResponseModel>,
        PaginationMapper<User, UserResponseModel> {
    override fun transform(source: List<User>): List<UserResponseModel> {
        return source.map { this.transform(it) }
    }

    override fun transform(source: Pagination<User>): Pagination<UserResponseModel> =
            with(source){
                Pagination(
                        root = transform(source.root),
                        size = source.size,
                        page = source.page,
                        place = source.place,
                        totalElements = source.totalElements,
                        totalPages = source.totalPages
                )
            }

    override fun transform(source: User): UserResponseModel =
            with(source){
                UserResponseModel(
                        id = id!!,
                        name = name!!,
                        email = email!!,
                        password = password!!,
                        oktaId = oktaId
                )
            }
}
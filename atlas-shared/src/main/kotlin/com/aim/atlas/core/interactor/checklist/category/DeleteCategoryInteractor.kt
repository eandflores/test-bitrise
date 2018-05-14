package com.aim.atlas.core.interactor.checklist.category

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.checklist.CategoryResponseMapper
import com.aim.atlas.core.repository.checklist.CategoryRepository
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("delete_checklist_category_interactor")
class DeleteCategoryInteractor(
        private val repository: CategoryRepository,
        private val responseMapper: CategoryResponseMapper
) :
        MaybeInteractor<CategoryResponse>(),
        InputBoundary<Long, DeleteCategoryInteractor> {

    var request: Long? = null

    override fun input(input: Long): DeleteCategoryInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<CategoryResponse> {
        return Maybe.just(request)
                .flatMap { repository.findById(it) }
                .flatMap { repository.delete(it) }
                .map { responseMapper.transform(it) }
    }
}
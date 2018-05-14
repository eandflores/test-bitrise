package com.aim.atlas.core.interactor.checklist.category

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.checklist.CategoryRequestMapper
import com.aim.atlas.core.mapper.checklist.CategoryResponseMapper
import com.aim.atlas.core.repository.checklist.CategoryRepository
import com.aim.atlas.core.specification.checklist.CategorySpecification
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("create_checklist_category_interactor")
class CreateCategoryInteractor(
        private val repository: CategoryRepository,
        private val specification: CategorySpecification,
        private val requestMapper: CategoryRequestMapper,
        private val responseMapper: CategoryResponseMapper
) :
        MaybeInteractor<CategoryResponse>(),
        InputBoundary<CategoryRequest, CreateCategoryInteractor> {

    lateinit var request: CategoryRequest

    override fun input(input: CategoryRequest): CreateCategoryInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<CategoryResponse> {
        return Maybe.just(request)
                .map { requestMapper.transform(it) }
                .filter { specification.isSatisfiedBy(it) }
                .flatMap { repository.create(it) }
                .map { responseMapper.transform(it) }
    }
}
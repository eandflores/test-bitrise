package com.aim.atlas.core.interactor.checklist.category

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.checklist.CategoryRequestMapper
import com.aim.atlas.core.mapper.checklist.CategoryResponseMapper
import com.aim.atlas.core.repository.checklist.CategoryRepository
import com.aim.atlas.core.repository.checklist.ChecklistRepository
import io.reactivex.Maybe
import io.reactivex.rxkotlin.zipWith
import javax.inject.Named

@TestOpen
@Named("remove_checklist_from_category_interactor")
class RemoveChecklistInteractor(
        private val repository: CategoryRepository,
        private val checklistRepository: ChecklistRepository,
        private val responseMapper: CategoryResponseMapper
) :
        MaybeInteractor<CategoryResponse>(),
        InputBoundary<ToggleChecklistRequest, RemoveChecklistInteractor> {

    lateinit var request: ToggleChecklistRequest

    override fun input(input: ToggleChecklistRequest): RemoveChecklistInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<CategoryResponse> {
        val category = repository.findById(request.categoryId!!)
        val checklist = checklistRepository.find(request.checklistId!!)

        return category
                .zipWith(checklist) { cat, chl -> repository.removeChecklist(cat, chl) }
                .flatMap { it.map { responseMapper.transform(it) } }
    }
}
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
@Named("assign_checklist_to_category_interactor")
class AssignChecklistInteractor(
        private val repository: CategoryRepository,
        private val checklistRepository: ChecklistRepository,
        private val responseMapper: CategoryResponseMapper
) :
        MaybeInteractor<CategoryResponse>(),
        InputBoundary<ToggleChecklistRequest, AssignChecklistInteractor> {

    lateinit var request: ToggleChecklistRequest

    override fun input(input: ToggleChecklistRequest): AssignChecklistInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<CategoryResponse> {
        val category = repository.findById(request.categoryId!!)
        val checklist = checklistRepository.find(request.checklistId!!)

        return category
                .zipWith(checklist) { cat, chl -> repository.assignChecklist(cat, chl) }
                .flatMap { it.map { responseMapper.transform(it) } }
    }
}
package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Checklist
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.checklist.checklist.ChecklistResponse
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import javax.inject.Named

@TestOpen
@Named
class ChecklistResponseMapper(
        private val conceptResponseMapper: ConceptResponseMapper,
        private val stepResponseMapper: StepResponseMapper
):
        Mapper<Checklist, ChecklistResponse>,
        ListMapper<Checklist, ChecklistResponse>,
        PaginationMapper<Checklist, ChecklistResponse> {

    override fun transform(source: List<Checklist>): List<ChecklistResponse> {
        return source.map{ transform(it) }
    }

    override fun transform(source: Pagination<Checklist>): Pagination<ChecklistResponse> {
        return Pagination(
                root = this.transform(source.root),
                size = source.size,
                page = source.page,
                place = source.place,
                totalElements = source.totalElements,
                totalPages = source.totalPages
        )
    }

    override fun transform(source: Checklist): ChecklistResponse {
        return with(source) {
            ChecklistResponse(
                    id,
                    name!!,
                    description!!,
                    icon!!,
                    testMode!!,
                    createdAt!!,
                    updatedAt!!,
                    concepts!!.map { conceptResponseMapper.transform(it) },
                    steps!!.map { stepResponseMapper.transform(it) }
            )
        }
    }

}

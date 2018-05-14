package com.aim.atlas.core.interactor.membership

import com.aim.atlas.core.entity.membership.Profile
import com.aim.atlas.core.interactor.membership.user.UserRequestModel
import com.aim.atlas.core.interactor.membership.user.UserResponseModel
import com.aim.atlas.core.entity.membership.User
import com.aim.atlas.core.interactor.membership.user.CreateUserInteractor
import com.aim.atlas.core.mapper.membership.UserRequestMapper
import com.aim.atlas.core.mapper.membership.UserResponseMapper
import com.aim.atlas.core.repository.membership.UserRepository
import com.aim.atlas.core.specification.membership.UserSpecification
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CreateUserInteractorTest {

    lateinit var createUserInteractor: CreateUserInteractor
    lateinit var repository: UserRepository
    lateinit var specification: UserSpecification
    lateinit var requestMapper: UserRequestMapper
    lateinit var responseMapper: UserResponseMapper
    lateinit var requestModelModel: UserRequestModel
    lateinit var user: User
    lateinit var userResponseModel: UserResponseModel


    @Before
    fun setUp() {
        /** Init mocks */
        repository = mock<UserRepository>()
        specification = mock<UserSpecification>()
        requestMapper = mock<UserRequestMapper>()
        responseMapper = mock<UserResponseMapper>()
        requestModelModel = mock<UserRequestModel>()
        userResponseModel = mock<UserResponseModel>()

        createUserInteractor = CreateUserInteractor(
                repository = repository,
                specification = specification,
                requestMapper = requestMapper,
                responseMapper = responseMapper)

        user = User(id= 2, name = "Martha",
                email = "martha@smu.com",
                password = "password",
                profile = Profile())

    }

    @Test
    fun successCreation(){
        Mockito.`when`(specification.isSatisfiedBy(any<User>())).thenReturn(true)
        Mockito.`when`(requestMapper.transform(any<UserRequestModel>())).thenReturn(user)
        createUserInteractor.input(requestModelModel)
        var expectedUser = createUserInteractor.execute()

        val testObserver = TestSubscriber<UserResponseModel>()
        expectedUser.subscribe(testObserver)

        testObserver.assertOf {
            verify(requestMapper, times(1)).transform(any<UserRequestModel>())
            verify(specification, times(1)).isSatisfiedBy(any<User>())
            verify(repository, times(1)).create(any<User>())
        }
    }

    @Test
    fun failureCreation() {
        Mockito.`when`(specification.isSatisfiedBy(any<User>())).thenReturn(false)
        Mockito.`when`(requestMapper.transform(any<UserRequestModel>())).thenReturn(user)
        createUserInteractor.input(requestModelModel)
        var expectedUser = createUserInteractor.execute()

        val testObserver = TestSubscriber<UserResponseModel>()
        expectedUser.subscribe(testObserver)

        testObserver.assertOf {
            verify(requestMapper, times(1)).transform(any<UserRequestModel>())
            verify(specification, times(1)).isSatisfiedBy(any<User>())
            verify(repository, times(0)).create(any<User>())
        }
    }
}

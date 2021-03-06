package com.felipearaujo.teamwork

import android.accounts.NetworkErrorException
import com.felipearaujo.data.DataRepository
import com.felipearaujo.model.ProjectsItem
import com.felipearaujo.model.Response
import com.felipearaujo.teamwork.projects.ProjectsContract
import com.felipearaujo.teamwork.projects.ProjectsPresenter
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.powermock.reflect.Whitebox.invokeMethod


/**
 * Created by felipearaujo on 07/03/18.
 */
@RunWith(JUnit4::class)
open class ProjectsPresenterTest {

    @Mock
    lateinit var view: ProjectsContract.View
    @Mock
    lateinit var dataRepository: DataRepository

    private val presenter: ProjectsPresenter by lazy {
        ProjectsPresenter(view, dataRepository)
    }

    private val fakeResponse: Response by lazy {
        Response("ok", listOf(ProjectsItem()))
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline(); }
    }

    @Test
    fun onReceiveDataWithSuccess() {
        Mockito.doReturn(Single.just(fakeResponse)).`when`(dataRepository).fetchProjects()

        val testObserver = TestObserver<Response>()

        val singleObservable = invokeMethod<Single<Response>>(presenter, "requestProjectsObservable")
        singleObservable.subscribeWith(testObserver)

        Mockito.verify(view, Mockito.times(1)).showLoading()
        Mockito.verify(view, Mockito.times(1)).hideRecyclerView()

        Mockito.verify(view, Mockito.times(1)).hideLoading()
        Mockito.verify(view, Mockito.times(1)).showRecyclerView()

        testObserver.assertValue(fakeResponse)
    }

    @Test
    fun onReceiveError() {
        Mockito.doReturn(
                Single.error<Response>(Throwable(NetworkErrorException()))
        ).`when`(dataRepository).fetchProjects()

        val testObserver = TestObserver<Response>()

        val singleObservable = invokeMethod<Single<Response>>(presenter, "requestProjectsObservable")
        singleObservable.subscribeWith(testObserver)

        Mockito.verify(view, Mockito.times(1)).showLoading()
        Mockito.verify(view, Mockito.times(1)).hideRecyclerView()

        Mockito.verify(view, Mockito.times(1)).hideLoading()
        Mockito.verify(view, Mockito.times(0)).showRecyclerView()

        testObserver.assertError(Throwable::class.java)
    }

    @After
    fun after() {
        RxAndroidPlugins.reset();
        RxJavaPlugins.reset();
    }
}
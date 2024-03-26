package com.yonjar.clashroyalestats.ui.badgesFragment

import com.yonjar.clashroyalestats.MotherObject
import com.yonjar.clashroyalestats.data.RepositoryImp
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BadgesViewModelTest{
    @MockK
    lateinit var repositoryImp: RepositoryImp

    private lateinit var badgesViewModel: BadgesViewModel


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.IO)
        badgesViewModel = BadgesViewModel(repositoryImp)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `chargeBadges() should change the value of the state to Success and get a PlayerMainInfoModel in the state`() = runBlocking {

        coEvery { repositoryImp.getPlayerBadges("#8YCLLVCG") } returns MotherObject.userModel.badges

        badgesViewModel.chargeBadges("#8YCLLVCG")
        delay(10)

        val state = badgesViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getPlayerBadges("#8YCLLVCG") }
        assertTrue(state is BadgesState.Success)
        assertEquals(MotherObject.userModel.badges, (state as BadgesState.Success).badges)
    }

    @Test
    fun `chargeBadges() should change the value of the state to Error if response is null`() = runBlocking {

        coEvery { repositoryImp.getPlayerBadges("#8YCLLVCG") } returns null

        badgesViewModel.chargeBadges("#8YCLLVCG")
        delay(10)

        val state = badgesViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getPlayerBadges("#8YCLLVCG") }

        assertTrue(state is BadgesState.Error)
        assertEquals("Response was null", (state as BadgesState.Error).error)
    }

    @Test
    fun `chargeBadges() should change the value of the state to Error when an exception occurs`() = runBlocking {

        coEvery { repositoryImp.getPlayerBadges("#8YCLLVCG") } throws Exception("Unknown error")

        badgesViewModel.chargeBadges("#8YCLLVCG")
        delay(10)

        val state = badgesViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getPlayerBadges("#8YCLLVCG") }
        assertTrue(state is BadgesState.Error)
        assertEquals("Unknown error", (state as BadgesState.Error).error)
    }
}
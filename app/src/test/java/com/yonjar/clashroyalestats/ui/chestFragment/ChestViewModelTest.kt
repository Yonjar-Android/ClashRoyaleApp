package com.yonjar.clashroyalestats.ui.chestFragment

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
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ChestViewModelTest{
    @MockK
    lateinit var repositoryImp: RepositoryImp

    private lateinit var chestViewModel: ChestViewModel


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.IO)
        chestViewModel = ChestViewModel(repositoryImp)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `chargeBadges() should change the value of the state to Success and get a PlayerMainInfoModel in the state`() = runBlocking {

        coEvery { repositoryImp.getChestCycle("#8YCLLVCG") } returns MotherObject.chestListModel

        chestViewModel.chargeChestCycle("#8YCLLVCG")
        delay(10)

        val state = chestViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getChestCycle("#8YCLLVCG") }
        assertTrue(state is ChestState.Success)
        assertEquals(MotherObject.chestListModel, (state as ChestState.Success).chestList)
    }

    @Test
    fun `chargeBadges() should change the value of the state to Error if response is null`() = runBlocking {

        coEvery { repositoryImp.getChestCycle("#8YCLLVCG") } returns null

        chestViewModel.chargeChestCycle("#8YCLLVCG")
        delay(10)

        val state = chestViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getChestCycle("#8YCLLVCG") }

        assertTrue(state is ChestState.Error)
        assertEquals("Response was null", (state as ChestState.Error).error)
    }

    @Test
    fun `chargeBadges() should change the value of the state to Error when an exception occurs`() = runBlocking {

        coEvery { repositoryImp.getChestCycle("#8YCLLVCG") } throws Exception("Unknown error")

        chestViewModel.chargeChestCycle("#8YCLLVCG")
        delay(10)

        val state = chestViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getChestCycle("#8YCLLVCG") }
        assertTrue(state is ChestState.Error)
        assertEquals("Unknown error", (state as ChestState.Error).error)
    }
}
package com.yonjar.clashroyalestats.ui.mainInfoFragment

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
class MainInfoViewModelTest {

    @MockK
    lateinit var repositoryImp: RepositoryImp

    private lateinit var mainInfoViewModel: MainInfoViewModel


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.IO)
        mainInfoViewModel = MainInfoViewModel(repositoryImp)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `chargePlayerInfo() should change the value of the state to Success and get a PlayerMainInfoModel in the state`() = runBlocking {

        coEvery { repositoryImp.getPlayerInfo("#8YCLLVCG") } returns MotherObject.userModel

        mainInfoViewModel.chargePlayerInfo("#8YCLLVCG")
        delay(10)

        val state = mainInfoViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getPlayerInfo("#8YCLLVCG") }
        assertTrue(state is MainInfoState.Success)
        assertEquals(MotherObject.userModel.tagPlayer, (state as MainInfoState.Success).playerInfo.tagPlayer)
    }

    @Test
    fun `chargePlayerInfo() should change the value of the state to Error if response is null`() = runBlocking {

        coEvery { repositoryImp.getPlayerInfo("#8YCLLVCG") } returns null

        mainInfoViewModel.chargePlayerInfo("#8YCLLVCG")
        delay(10)

        val state = mainInfoViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getPlayerInfo("#8YCLLVCG") }

        assertTrue(state is MainInfoState.Error)
        assertEquals("Player was not found", (state as MainInfoState.Error).error)
    }

    @Test
    fun `chargePlayerInfo() should change the value of the state to Error when an exception occurs`() = runBlocking {

        coEvery { repositoryImp.getPlayerInfo("#8YCLLVCG") } throws Exception("Unknown error")

        mainInfoViewModel.chargePlayerInfo("#8YCLLVCG")
        delay(10)

        val state = mainInfoViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getPlayerInfo("#8YCLLVCG") }
        assertTrue(state is MainInfoState.Error)
        assertEquals("Unknown error", (state as MainInfoState.Error).error)
    }

}
package com.yonjar.clashroyalestats.ui.startFragment

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
class StartViewModelTest{
    @MockK
    lateinit var repositoryImp: RepositoryImp

    private lateinit var startViewModel: StartViewModel


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.IO)
        startViewModel = StartViewModel(repositoryImp)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `verifyPlayer() should change the value of the state to Success and get a PlayerMainInfoModel in the state`() = runBlocking {

        coEvery { repositoryImp.getPlayerInfo("#8YCLLVCG") } returns MotherObject.userModel

        startViewModel.verifyPlayer("#8YCLLVCG")
        delay(10)

        val state = startViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getPlayerInfo("#8YCLLVCG") }
        assertTrue(state is StartFragmentState.Success)
        assertEquals(MotherObject.userModel.tagPlayer, (state as StartFragmentState.Success).playerTag)
    }

    @Test
    fun `verifyPlayer() should change the value of the state to Error if response is null`() = runBlocking {

        coEvery { repositoryImp.getPlayerInfo("#8YCLLVCG") } returns null

        startViewModel.verifyPlayer("#8YCLLVCG")
        delay(10)

        val state = startViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getPlayerInfo("#8YCLLVCG") }

        assertTrue(state is StartFragmentState.Error)
        assertEquals("Player was not found", (state as StartFragmentState.Error).error)
    }

    @Test
    fun `verifyPlayer() should change the value of the state to Error when an exception occurs`() = runBlocking {

        coEvery { repositoryImp.getPlayerInfo("#8YCLLVCG") } throws Exception("Unknown error")

        startViewModel.verifyPlayer("#8YCLLVCG")
        delay(10)

        val state = startViewModel.state.value

        coVerify(exactly = 1) { repositoryImp.getPlayerInfo("#8YCLLVCG") }
        assertTrue(state is StartFragmentState.Error)
        assertEquals("Unknown error", (state as StartFragmentState.Error).error)
    }

}
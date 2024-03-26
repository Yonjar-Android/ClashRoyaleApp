package com.yonjar.clashroyalestats.ui.cardsFragment

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
class CardsViewModelTest {
    @MockK
    lateinit var repositoryImp: RepositoryImp

    private lateinit var cardsViewModel: CardsViewModel


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.IO)
        cardsViewModel = CardsViewModel(repositoryImp)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `chargeCards() should change the value of the state to Success and get a PlayerMainInfoModel in the state`() =
        runBlocking {

            coEvery { repositoryImp.getPlayerCards("#8YCLLVCG") } returns MotherObject.userModel.cards

            cardsViewModel.chargeCards("#8YCLLVCG")
            delay(10)

            val state = cardsViewModel.state.value

            coVerify(exactly = 1) { repositoryImp.getPlayerCards("#8YCLLVCG") }
            assertTrue(state is CardsState.Success)
            assertEquals(MotherObject.userModel.cards, (state as CardsState.Success).playerCards)
        }

    @Test
    fun `chargeCards() should change the value of the state to Error if response is null`() =
        runBlocking {

            coEvery { repositoryImp.getPlayerCards("#8YCLLVCG") } returns null

            cardsViewModel.chargeCards("#8YCLLVCG")
            delay(10)

            val state = cardsViewModel.state.value

            coVerify(exactly = 1) { repositoryImp.getPlayerCards("#8YCLLVCG") }

            assertTrue(state is CardsState.Error)
            assertEquals("Response was null", (state as CardsState.Error).error)
        }

    @Test
    fun `chargeCards() should change the value of the state to Error when an exception occurs`() =
        runBlocking {

            coEvery { repositoryImp.getPlayerCards("#8YCLLVCG") } throws Exception("Unknown error")

            cardsViewModel.chargeCards("#8YCLLVCG")
            delay(10)

            val state = cardsViewModel.state.value

            coVerify(exactly = 1) { repositoryImp.getPlayerCards("#8YCLLVCG") }
            assertTrue(state is CardsState.Error)
            assertEquals("Unknown error", (state as CardsState.Error).error)
        }

}
package com.yonjar.clashroyalestats.data

import com.yonjar.clashroyalestats.MotherObject
import com.yonjar.clashroyalestats.data.network.UserService
import com.yonjar.clashroyalestats.domain.models.PlayerMainInfoModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import java.lang.RuntimeException

class RepositoryImpTest {

    @MockK
    lateinit var userService: UserService

    private lateinit var repositoryImp: RepositoryImp

    private val user = MotherObject.userResponse
    private val userModel = MotherObject.userModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        repositoryImp = RepositoryImp(userService)

    }

    @Test
    fun `getPlayerInfo should return a playerMainInfoModel class object`() = runBlocking {

        // Given
        coEvery { userService.getPlayers("8YCLLVCG") } returns user

        // When
        val response = repositoryImp.getPlayerInfo("8YCLLVCG")

        // Then
        coVerify(exactly = 1) { userService.getPlayers("8YCLLVCG") }
        assertNotNull(response)

        // Verifica que el tag del jugador sea correcto
        assertEquals(response!!.tagPlayer, user.tagPlayer)

        // Verifica que los campos de userModel sean iguales a los de response

        assertEquals(response, userModel )
    }

    @Test
    fun `getPlayerInfo should return a null on service failure`() = runBlocking {

        // Given
        coEvery { userService.getPlayers("8YCLLVCG") } throws RuntimeException("Service unavailable")

        // When
        val response:PlayerMainInfoModel? = repositoryImp.getPlayerInfo("8YCLLVCG")

        // Then
        coVerify(exactly = 1) { userService.getPlayers("8YCLLVCG") }
        assertNull(response)
    }

    @Test
    fun `getPlayerCards should return a list of all the cards of the player`() = runBlocking {

        // Given
        coEvery { userService.getPlayers("8YCLLVCG") } returns user

        // When
        val response = repositoryImp.getPlayerCards("8YCLLVCG")

        // Then
        coVerify(exactly = 1) { userService.getPlayers("8YCLLVCG") }
        assertNotNull(response)

        // Verifica que las cartas sean las mismas
        assertEquals(response!![0].name, user.cards[0].name)
        assertEquals(response[0].cardImage, user.cards[0].cardImage.medium)

    }

    @Test
    fun `getPlayerCards should return a null on service failure`() = runBlocking {

        // Given
        coEvery { userService.getPlayers("8YCLLVCG") } throws RuntimeException("Service unavailable")

        // When
        val response = repositoryImp.getPlayerCards("8YCLLVCG")

        // Then
        coVerify(exactly = 1) { userService.getPlayers("8YCLLVCG") }
        assertNull(response)
    }

    @Test
    fun `getPlayerBadges should return a list of all the badges of the player`() = runBlocking {

        // Given
        coEvery { userService.getPlayers("8YCLLVCG") } returns user

        // When
        val response = repositoryImp.getPlayerBadges("8YCLLVCG")

        // Then
        coVerify(exactly = 1) { userService.getPlayers("8YCLLVCG") }
        assertNotNull(response)

        // Verifica que las insignias sean las mismas
        assertEquals(response!![0].name, user.badges[0].name)
        assertEquals(response[0].image, user.badges[0].image.badgeImage)

    }

    @Test
    fun `getPlayerBadges should return a null on service failure`() = runBlocking {

        // Given
        coEvery { userService.getPlayers("8YCLLVCG") } throws RuntimeException("Service unavailable")

        // When
        val response = repositoryImp.getPlayerBadges("8YCLLVCG")

        // Then
        coVerify(exactly = 1) { userService.getPlayers("8YCLLVCG") }
        assertNull(response)
    }

    @Test
    fun `getChestCycle should return a list of chests with its index`() = runBlocking {

        // Given
        coEvery { userService.getChestCycle("8YCLLVCG") } returns MotherObject.chestList

        // When
        val response = repositoryImp.getChestCycle("8YCLLVCG")

        // Then
        coVerify(exactly = 1) { userService.getChestCycle("8YCLLVCG") }
        assertNotNull(response)

        // Verifica que los cofres sean los mismos
        assertEquals(response!![0].name, MotherObject.chestList.chestList[0].name)
        assertEquals(response[0].index, MotherObject.chestList.chestList[0].index)

    }

    @Test
    fun `getChestCycle should return a null on service failure`() = runBlocking {

        // Given
        coEvery { userService.getChestCycle("8YCLLVCG") } throws RuntimeException("Service unavailable")

        // When
        val response = repositoryImp.getChestCycle("8YCLLVCG")

        // Then
        coVerify(exactly = 1) { userService.getChestCycle("8YCLLVCG") }
        assertNull(response)
    }
}
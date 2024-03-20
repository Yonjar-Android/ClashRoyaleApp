package com.yonjar.clashroyalestats.ui.cardsFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonjar.clashroyalestats.data.RepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(private val repositoryImp: RepositoryImp): ViewModel() {
    private val _state = MutableStateFlow<CardsState>(CardsState.Loading)
    var state: StateFlow<CardsState> = _state

    fun chargeCards(tagPlayer:String){
        try {
            viewModelScope.launch {
                val response = repositoryImp.getPlayerCards(tagPlayer)

                if(response != null){
                    _state.value = CardsState.Success(response)
                } else{
                    _state.value = CardsState.Error("Response was null")
                }

            }
        } catch (e:Exception){
            _state.value = CardsState.Error(e.message ?: "Unknown error")
        }
    }

}
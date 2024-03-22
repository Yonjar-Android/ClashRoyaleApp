package com.yonjar.clashroyalestats.ui.chestFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonjar.clashroyalestats.data.RepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChestViewModel @Inject constructor(private val repositoryImp: RepositoryImp): ViewModel() {

    private val _state = MutableStateFlow<ChestState>(ChestState.Loading)
    var state: StateFlow<ChestState> = _state

    fun chargeChestCycle(tagPlayer:String){
        try {
        viewModelScope.launch {
            val response = repositoryImp.getChestCycle(tagPlayer)

            if(response != null){
                _state.value = ChestState.Success(response)
            } else{
                _state.value = ChestState.Error("Response was null")
            }
            }
        } catch (e:Exception){
                _state.value = ChestState.Error(e.message ?: "Response was null")
            }

    }

}
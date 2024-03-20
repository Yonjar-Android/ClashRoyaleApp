package com.yonjar.clashroyalestats.ui.badgesFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yonjar.clashroyalestats.data.RepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BadgesViewModel @Inject constructor(private val repositoryImp: RepositoryImp): ViewModel() {

    private val _state = MutableStateFlow<BadgesState>(BadgesState.Loading)
    var state: StateFlow<BadgesState> = _state

    fun chargeBadges(tagPlayer:String){
        try {
            viewModelScope.launch {
                val response = repositoryImp.getPlayerBadges(tagPlayer)

                if(response != null){

                    _state.value = BadgesState.Success(response)
                } else{
                    _state.value = BadgesState.Error("Response was null")
                }

            }
        } catch (e:Exception){
            _state.value = BadgesState.Error(e.message ?: "Unknown error")
        }
    }

}
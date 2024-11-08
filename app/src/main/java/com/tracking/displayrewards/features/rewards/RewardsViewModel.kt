package com.tracking.displayrewards.features.rewards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tracking.clients.common.ApiResult
import com.tracking.clients.common.Message
import com.tracking.clients.rewards.model.RewardsItem
import com.tracking.displayrewards.features.rewards.domain.RewardsRepository
import com.tracking.displayrewards.features.rewards.domain.model.Reward
import com.tracking.displayrewards.features.rewards.model.RewardsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RewardsViewModel @Inject constructor(
    private val repository: RewardsRepository,
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<RewardsUiState>(RewardsUiState.Empty)
    val state = _stateFlow.asStateFlow()

    init {
        fetchRewards()
    }

    fun fetchRewards() {
        _stateFlow.value = RewardsUiState.Loading
        viewModelScope.launch {
            val result = repository.fetchRewards()
            when (result) {
                is ApiResult.Success<Map<Int, List<Reward>>> -> handleSuccessResponse(result.response)
                is ApiResult.Error -> handleErrorResponse(result.message)
            }
        }
    }

    fun handleSuccessResponse(response: Map<Int, List<Reward>>) {
        _stateFlow.value = RewardsUiState.UpdateUi(response)
    }

    fun handleErrorResponse(error: Message) {
        _stateFlow.value = RewardsUiState.Error
    }
}

package com.aqua_tech.gads2020.ui.main.top_learners

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aqua_tech.gads2020.api.LeadersRepository
import com.aqua_tech.gads2020.api.Resource
import kotlinx.coroutines.Dispatchers

class TopLearnersViewModel @ViewModelInject constructor(
    private val repository: LeadersRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    fun getTopLearners() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getTopLearners()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}
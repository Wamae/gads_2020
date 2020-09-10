package com.aqua_tech.gads2020.ui.main.submit_project

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aqua_tech.gads2020.api.LeadersRepository
import com.aqua_tech.gads2020.api.ProjectRepository
import com.aqua_tech.gads2020.api.Resource
import kotlinx.coroutines.Dispatchers

class SubmitViewModel @ViewModelInject constructor(
    private val repository: ProjectRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    fun submitProject(
        firstName: String,
        lastName: String,
        email: String,
        projectLink: String
    ) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.submitProject(firstName, lastName, email, projectLink)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}
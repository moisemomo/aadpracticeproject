package sn.moisemomo.aadpracticeproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import sn.moisemomo.aadpracticeproject.repositories.FormSubmissionRepository

class FormSubmissionViewModel: ViewModel() {

    fun submitFormInfo (email: String, name: String, lastName: String, projectUrl: String) = liveData(Dispatchers.IO) {
        val submission  = FormSubmissionRepository.submitForm(email, name, lastName, projectUrl)
        emit(submission)
    }
}
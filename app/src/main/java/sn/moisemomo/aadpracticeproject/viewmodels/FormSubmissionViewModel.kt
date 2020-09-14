package sn.moisemomo.aadpracticeproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import sn.moisemomo.aadpracticeproject.repositories.FormSubmissionRepository

class FormSubmissionViewModel: ViewModel() {

    fun submitFormInfo (email: String, name: String, lastName: String, projectUrl: String) = liveData(Dispatchers.IO) {
        val submissionResponseCode = try {
            FormSubmissionRepository.submitForm(email, name, lastName, projectUrl)
            200
        } catch (e: Exception) {
            400
        }
        emit(submissionResponseCode)
    }
}
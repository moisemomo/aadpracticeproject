package sn.moisemomo.aadpracticeproject.repositories

import sn.moisemomo.aadpracticeproject.api.ServiceGenerator
import sn.moisemomo.aadpracticeproject.api.WebService

object FormSubmissionRepository {
    private const val FORM_BASE_URL = "https://docs.google.com/forms/d/e/"

    private var client: WebService = ServiceGenerator.createService(FORM_BASE_URL)

    suspend fun submitForm(email: String, name: String, lastName: String, projectUrl: String) {
        client.submitProject(email, name, lastName, projectUrl)
    }
}
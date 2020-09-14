package sn.moisemomo.aadpracticeproject.repositories

import sn.moisemomo.aadpracticeproject.api.ServiceGenerator
import sn.moisemomo.aadpracticeproject.api.WebService

object LeadersRepository {
    private const val GADS_API_BASE_URL = "https://gadsapi.herokuapp.com/api/"

    private var client: WebService = ServiceGenerator.createService(GADS_API_BASE_URL)

    suspend fun getLearningLeaders() = client.getLearningLeaders()

    suspend fun getSkillIQLeaders() = client.getSkillIQLeaders()
}
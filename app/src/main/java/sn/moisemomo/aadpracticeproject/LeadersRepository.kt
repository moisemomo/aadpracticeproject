package sn.moisemomo.aadpracticeproject

import sn.moisemomo.aadpracticeproject.api.ServiceGenerator
import sn.moisemomo.aadpracticeproject.api.WebService

object LeadersRepository {
    private var client: WebService = ServiceGenerator.createService()

    suspend fun getLearningLeaders() = client.getLearningLeaders()

    suspend fun getSkillIQLeaders() = client.getSkillIQLeaders()
}
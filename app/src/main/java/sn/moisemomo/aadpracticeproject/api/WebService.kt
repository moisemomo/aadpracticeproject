package sn.moisemomo.aadpracticeproject.api

import retrofit2.http.GET
import sn.moisemomo.aadpracticeproject.model.Learner

interface WebService {
    @GET("hours")
    suspend fun getLearningLeaders(): List<Learner>

    @GET("skilliq")
    suspend fun getSkillIQLeaders(): List<Learner>
}
package sn.moisemomo.aadpracticeproject.api

import com.bumptech.glide.load.engine.Resource
import okhttp3.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import sn.moisemomo.aadpracticeproject.model.Learner

interface WebService {
    @GET("hours")
    suspend fun getLearningLeaders(): List<Learner>

    @GET("skilliq")
    suspend fun getSkillIQLeaders(): List<Learner>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    suspend fun submitProject(
        @Field("entry.1824927963") email: String,
        @Field("entry.1877115667") name: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") projectLink: String
    )
}
package sn.moisemomo.aadpracticeproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class LeadersViewModel: ViewModel() {

    private val repository = LeadersRepository

    val learnerLeaders = liveData(Dispatchers.IO) {
        val learners = repository.getLearningLeaders()
        emit(learners)
    }

    val  skillIQLeaders = liveData(Dispatchers.IO) {
        val learners = repository.getSkillIQLeaders()
        emit(learners)
    }
}
package sn.moisemomo.aadpracticeproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import sn.moisemomo.aadpracticeproject.repositories.LeadersRepository

class LeadersViewModel: ViewModel() {

    val learnerLeaders = liveData(Dispatchers.IO) {
        val learners = LeadersRepository.getLearningLeaders()
        emit(learners)
    }


    val  skillIQLeaders = liveData(Dispatchers.IO) {
        val learners = LeadersRepository.getSkillIQLeaders()
        emit(learners)
    }
}
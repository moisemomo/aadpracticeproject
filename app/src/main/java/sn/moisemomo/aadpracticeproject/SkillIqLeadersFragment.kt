package sn.moisemomo.aadpracticeproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_learning_leaders.*
import kotlinx.android.synthetic.main.fragment_learning_leaders.progress
import kotlinx.android.synthetic.main.fragment_skill_iq_leaders.*


/**
 * A simple [Fragment] subclass.
 * Use the [SkillIqLeadersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SkillIqLeadersFragment : Fragment() {

    private lateinit var mViewModel: LeadersViewModel
    private lateinit var mAdapter: LearnersAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(LeadersViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadData()
    }

    private fun setupRecyclerView() {
        skill_ik_recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            mAdapter = LearnersAdapter(arrayListOf())
            adapter = mAdapter
        }
    }

    private fun loadData() {
        mViewModel.skillIQLeaders.observe(this, Observer {
            it?.let {list->
                if (list.isNotEmpty()) {
                    progress.visibility = View.GONE
                    skill_ik_recyclerview.visibility = View.VISIBLE
                    mAdapter.setData(list)
                }

            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillIqLeadersFragment()
    }
}
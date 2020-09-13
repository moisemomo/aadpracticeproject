package sn.moisemomo.aadpracticeproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_learning_leaders.*

/**
 * A simple [Fragment] subclass.
 * Use the [LearningLeadersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearningLeadersFragment : Fragment() {
    private lateinit var mViewModel: LeadersViewModel
    private lateinit var mAdapter: LearnersAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(LeadersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadData()
    }

    private fun setupRecyclerView() {
        leaders_recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            mAdapter = LearnersAdapter(arrayListOf())
            adapter = mAdapter
        }
    }

    private fun loadData() {
        mViewModel.learnerLeaders.observe(this, Observer {
            it?.let {list->
                if (list.isNotEmpty()) {
                    progress.visibility = View.GONE
                    leaders_recyclerview.visibility = View.VISIBLE
                    mAdapter.setData(list)
                }

            }
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() = LearningLeadersFragment()
    }
}
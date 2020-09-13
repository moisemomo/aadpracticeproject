package sn.moisemomo.aadpracticeproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sn.moisemomo.aadpracticeproject.databinding.ItemLeaderBinding
import sn.moisemomo.aadpracticeproject.model.Learner

class LearnersAdapter(private var learners: List<Learner>?): RecyclerView.Adapter<LearnersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_leader, parent, false)
    return ViewHolder(view)
    }

    override fun getItemCount(): Int = learners?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val learner = learners?.get(position)
        learner?.let { l ->
            holder.itemLeaderBinding.apply {
                name.text = l.name
                val text: String = l.hours?.let { root.context.getString(R.string.learning_hours_var, l.hours) }
                    ?: kotlin.run { root.context.getString(R.string.skill_iq_var, l.score) }
                score.text  = String.format("%s, %s",text, l.country)
                Glide.with(leaderTypeIcon.context).load(l.badgeUrl).into(leaderTypeIcon)
            }
        }
    }

    fun setData(list:List<Learner>) {
        learners = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemLeaderBinding: ItemLeaderBinding =  ItemLeaderBinding.bind(itemView)
    }
}
package sn.moisemomo.aadpracticeproject

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private var mFragmentAdapter: FragmentAdapter?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupFragmentAdapter()
        handleClicks()
    }


    private fun setupFragmentAdapter() {
        mFragmentAdapter = FragmentAdapter(supportFragmentManager,
            mutableListOf(getString(R.string.learning_leaders),getString(R.string.skill_iq_leaders)),
            mutableListOf(LearningLeadersFragment.newInstance(), SkillIqLeadersFragment.newInstance()))
        home_view_pager.apply {
            adapter = mFragmentAdapter
            offscreenPageLimit = 2
        }
        tab_layout.apply {
            setupWithViewPager(home_view_pager)
        }
    }

    private fun handleClicks() {
       home_submit.setOnClickListener {
           startActivity(Intent(this, FormSubmissionActivity::class.java))
       }
    }

    class FragmentAdapter(fm: FragmentManager, private val titles: MutableList<String>,
                          private val fragments: MutableList<Fragment>): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment = fragments[position]
        override fun getCount(): Int = fragments.size
        override fun getPageTitle(position: Int): CharSequence? = titles[position]
    }
}
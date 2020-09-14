package sn.moisemomo.aadpracticeproject

import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_form_submission.*
import sn.moisemomo.aadpracticeproject.viewmodels.FormSubmissionViewModel

class FormSubmissionActivity : AppCompatActivity() {
    private lateinit var mViewModel: FormSubmissionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_submission)
        setSupportActionBar(form_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        mViewModel = ViewModelProvider(this).get(FormSubmissionViewModel::class.java)
        handleClicks()

    }

    private fun handleClicks() {
        submit_form_button.setOnClickListener {
            if (isAllInputsFilled()) {
                mViewModel.submitFormInfo(
                    email.text.toString(),
                    first_name.text.toString(),
                    last_name.text.toString(),
                    link.text.toString())
            }
        }
    }

    private fun isAllInputsFilled(): Boolean {
        if (first_name.isEditextBlankOrEmpty()) {
            first_name.error = getString(R.string.field_cant_be_empty)
            return false
        }

        if (last_name.isEditextBlankOrEmpty()) {
            last_name.error = getString(R.string.field_cant_be_empty)
            return false
        }

        if (email.isEditextBlankOrEmpty()) {
            email.error = getString(R.string.field_cant_be_empty)
            return false
        }

        if (link.isEditextBlankOrEmpty()) {
            link.error = getString(R.string.field_cant_be_empty)
            return false
        }
        return true
    }


    private fun EditText.isEditextBlankOrEmpty(): Boolean {
        return this.text.isEmpty() && this.text.isBlank()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }
}
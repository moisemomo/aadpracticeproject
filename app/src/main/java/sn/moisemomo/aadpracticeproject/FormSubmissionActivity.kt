package sn.moisemomo.aadpracticeproject

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_form_submission.*
import sn.moisemomo.aadpracticeproject.viewmodels.FormSubmissionViewModel
import java.util.logging.Logger


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
                 showConfirmationDialog()
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

    private fun showConfirmationDialog() {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView: View = layoutInflater.inflate(R.layout.dialog_form_confirmation, null)
        dialogBuilder.setView(dialogView)

        val alertDialog: AlertDialog = dialogBuilder.create()
        alertDialog.setCancelable(false)

        alertDialog.show()
        dialogView.findViewById<Button>(R.id.yes).setOnClickListener {
                mViewModel.submitFormInfo(
                    email.text.toString(),
                    first_name.text.toString(),
                    last_name.text.toString(),
                    link.text.toString()).observe(this, Observer {
                    it?.let { code ->
                        alertDialog.dismiss()
                        if (code == 200){
                            showResultDialog(getString(R.string.submission_successful), R.drawable.ic_check_circle)
                        } else {
                            showResultDialog(getString(R.string.submission_not_successful), R.drawable.ic_alert)
                        }
                    }


                })
        }
        dialogView.findViewById<ImageView>(R.id.close_dialog).setOnClickListener {
            alertDialog.dismiss()
        }
    }

    private fun showResultDialog(message: String, @DrawableRes drawable:  Int ) {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView: View = layoutInflater.inflate(R.layout.result_dialog, null)
        dialogView.findViewById<ImageView>(R.id.alert_icon).setImageDrawable(ResourcesCompat.getDrawable(resources, drawable , null))
        dialogView.findViewById<TextView>(R.id.alert_message).text = message

        dialogBuilder.setView(dialogView)

        val alertDialog: AlertDialog = dialogBuilder.create()
        alertDialog.show()

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
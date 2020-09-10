package com.aqua_tech.gads2020.ui.main.submit_project

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import com.aqua_tech.gads2020.R
import com.aqua_tech.gads2020.api.Status
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_submit.*

@AndroidEntryPoint
class SubmitActivity : AppCompatActivity() {

    private lateinit var projectLink: String
    private lateinit var email: String
    private lateinit var lastName: String
    private lateinit var firstName: String
    private val viewModel: SubmitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_submit.setOnClickListener {
            firstName = et_first_name.text.toString()
            lastName = et_last_name.text.toString()
            email = et_email.text.toString()
            projectLink = et_project_link.text.toString()

            when {
                firstName.trim().isEmpty() -> {
                    Toast.makeText(this, "Enter first name", Toast.LENGTH_SHORT).show()
                }
                lastName.trim().isEmpty() -> {
                    Toast.makeText(this, "Enter last name", Toast.LENGTH_SHORT).show()
                }
                email.trim().isEmpty() -> {
                    Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                }
                projectLink.trim().isEmpty() -> {
                    Toast.makeText(this, "Enter project link", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    showConfirmationDialog()
                }
            }
        }
    }

    private fun showConfirmationDialog() {
        val builder = MaterialAlertDialogBuilder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.confirm_dialog_view, null)

        builder.setView(dialogView)
        val dialog = builder.create()

        val btnYes = dialogView.findViewById<Button>(R.id.btn_yes)
        btnYes.setOnClickListener {
            dialog.dismiss()
            submitProject()
        }

        val btnClose = dialogView.findViewById<CardView>(R.id.btn_close)
        btnClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showSuccessDialog() {
        val builder = MaterialAlertDialogBuilder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.success_dialog_view, null)

        builder.setView(dialogView)
        val dialog = builder.create()
        dialog.show()
    }

    private fun showFailureDialog() {
        val builder = MaterialAlertDialogBuilder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.failure_dialog_view, null)

        builder.setView(dialogView)
        val dialog = builder.create()
        dialog.show()
    }

    private fun submitProject() {
        viewModel.submitProject(firstName, lastName, email, projectLink).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progress_bar.visibility = View.GONE
                        // Show success dialog
                        showSuccessDialog()
                        clearFields()
                    }
                    Status.ERROR -> {
                        progress_bar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        // show error dialog
                        showFailureDialog()
                    }
                    Status.LOADING -> {
                        progress_bar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    fun clearFields() {
        et_first_name.setText("")
        et_last_name.setText("")
        et_email.setText("")
        et_project_link.setText("")
    }
}
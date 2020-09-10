package com.aqua_tech.gads2020.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.aqua_tech.gads2020.R
import com.aqua_tech.gads2020.ui.main.submit_project.SubmitActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        btn_submit.setOnClickListener {
            startActivity(Intent(this,SubmitActivity::class.java))
        }
    }

    fun showProgressBar(){
        progress_bar.visibility = View.VISIBLE
    }

    fun hideProgressBar(){
        progress_bar.visibility = View.GONE
    }
}
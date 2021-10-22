package com.example.lab3_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3_4.databinding.Activity1Binding


class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToSecond.setOnClickListener {
            goToSecond()
        }

        binding.btnToAbout.setOnClickListener {
            goToAbout()
        }

        binding.btnToDont.setOnClickListener {
            goToDont()
        }
    }

    private fun goToSecond() {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }

    private fun goToAbout() {
        val intent = Intent(this, ActivityAbout::class.java)
        startActivity(intent)
    }

    private fun goToDont() {
        val intent = Intent(this, ActivityDont::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
    }
}
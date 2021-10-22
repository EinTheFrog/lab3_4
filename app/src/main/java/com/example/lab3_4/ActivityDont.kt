package com.example.lab3_4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.lab3_4.databinding.ActivityDontBinding

class ActivityDont: AppCompatActivity() {
    private val count = MutableLiveData<Int>(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDontBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topText.text = getString(R.string.dont_txt, count.value)
        count.observe(this, Observer {
            binding.topText.text = getString(R.string.dont_txt, it)
        })

        binding.btnReopen.setOnClickListener {
            reopen()
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun reopen() {
        val intent = Intent(this, ActivityDont::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        count.value = (count.value ?: 0) + 1
    }
}
package com.example.empregaeu4

import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.empregaeu4.databinding.ActivityTela2Binding

class Tela2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val nextButton = findViewById<Button>(R.id.btNextPage)
        nextButton.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)

        }




        //setContentView(R.layout.activity_tela2)
    }
}
package com.example.empregaeu4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        startActivity(intent)


        val idNome = findViewById<TextView>(R.id.idNome)
        val myValue = intent.getStringExtra("nome")
        idNome.text = idNome.toString()


    }
}
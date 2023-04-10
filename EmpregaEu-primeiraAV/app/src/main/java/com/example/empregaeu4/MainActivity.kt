package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.empregaeu4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idNome = binding.edUsuario
        val btLogin = binding.btLogin
        val idSenha = binding.idSenha

        btLogin.setOnClickListener {

            if (idSenha != null) {
                if(idNome.text.toString() == "Raysa" && idSenha.text.toString().toIntOrNull() == 157) {
                    val intent = Intent(this, Tela2Activity::class.java)
                    val texto = idNome.text.toString()
                    intent.putExtra("nome", texto)
                    startActivity(intent)
                } else{
                    Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
                }
            }
        }

        //setContentView(R.layout.activity_main)
    }
}

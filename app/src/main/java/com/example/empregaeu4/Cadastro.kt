package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.empregaeu4.databinding.ActivityCadastroBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.widget.Toast

class Cadastro : AppCompatActivity() {
private lateinit var binding : ActivityCadastroBinding
private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuario = binding.idName
        var phonee = binding.idPhone
        var CPFF = binding.CPF
        var birth = binding.birth
        var btCadastrar = binding.btEntrar

        dbRef = FirebaseDatabase.getInstance().getReference("Usuário")

        btCadastrar.setOnClickListener{
            val userName = usuario.text.toString()
            val phone = phonee.text.toString()
            val birthday = birth.text.toString()
            val CPF = CPFF.text.toString()

            if(userName.isEmpty()){
                usuario.error = "Por favor insira um nome"
            }
            if(phone.isEmpty()){
                phonee.error = "Por favor insira um telefone"
            }
            if(CPF.isEmpty()){
                CPFF.error = "Por favor insira um CPF"
            }
            if(birthday.isEmpty()){
                birth.error = "Por favor insira sua data de Nascimento"
            }

            val userId = dbRef.push().key!!

            val Usuário = UsuarioDados(userId, userName, phone, CPF, birthday)

            dbRef.child(userId).setValue(Usuário)
                .addOnCompleteListener{
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()
                    usuario.text.clear()
                        phonee.text.clear()
                    CPFF.text.clear()
                    birth.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
            val intent = Intent(this, ListaOngs::class.java)
            startActivity(intent)
        }


    }
}
package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.empregaeu4.databinding.ActivityCadastroBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Cadastro : AppCompatActivity() {
    private lateinit var apList: ArrayList<UsuarioDados>
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

        apList = arrayListOf<UsuarioDados>()
        dbRef = FirebaseDatabase.getInstance().getReference("Usuário")
        val database = Firebase.database
        val myRef: DatabaseReference = database.getReference("dadosdousuario")

        btCadastrar.setOnClickListener{
            val userName = usuario.text.toString()
            val phone = phonee.text.toString()
            val birthday = birth.text.toString()
            val CPF = CPFF.text.toString()

            if(userName.isEmpty() || phone.isEmpty() || birthday.isEmpty() || CPF.isEmpty()){
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
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
                    myRef.setValue(Usuário)
                    val userList: ArrayList<UsuarioDados>
                    apList.add(Usuário)
//                    val intent = Intent(this, ListaOngs::class.java)
//                    intent.putExtra("apList", apList)
//                    startActivity(intent)

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
           //
        }


    }
}
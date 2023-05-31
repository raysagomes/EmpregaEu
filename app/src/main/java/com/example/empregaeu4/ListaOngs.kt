package com.example.empregaeu4

    import android.content.Intent

            import androidx.appcompat.app.AppCompatActivity
                import android.os.Bundle
                import android.view.View
                import android.widget.TextView
                import androidx.recyclerview.widget.LinearLayoutManager
                import androidx.recyclerview.widget.RecyclerView
                import com.google.firebase.database.*

class ListaOngs : AppCompatActivity() {
            private lateinit var apRecyclerView: RecyclerView
            private lateinit var tvLoadingData: TextView
            private lateinit var apList: ArrayList<UsuarioDados>
            private lateinit var dbRef: DatabaseReference

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_lista_ongs)

                apRecyclerView = findViewById(R.id.listVagas)
                apRecyclerView.layoutManager = LinearLayoutManager(this)
                apRecyclerView.setHasFixedSize(true)
                tvLoadingData = findViewById(R.id.tvLoadingData)

                apList = arrayListOf<UsuarioDados>()

                getOngsData()

                val receivedName = intent.getStringExtra("nome")
                val tvNome = findViewById<TextView>(R.id.tvName)
                tvNome.text = receivedName
//
//                val receivedPhone = intent.getStringExtra("phone")
//                val receivedBirthday = intent.getStringExtra("birthday")
//                val receivedCPF = intent.getStringExtra("CPF")



            }

            private fun getOngsData() {

                apRecyclerView.visibility = View.GONE
                tvLoadingData.visibility = View.VISIBLE

                dbRef = FirebaseDatabase.getInstance().getReference("Ongs")


                dbRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        apList.clear()
                        if (snapshot.exists()){
                            for (empSnap in snapshot.children){
                                val empData = empSnap.getValue(UsuarioDados::class.java)
                                apList.add(empData!!)
                            }
                            if (apList != null) {
                                val mAdapter = apAdapter(apList)
                                apRecyclerView.adapter = mAdapter
                                apRecyclerView.visibility = View.VISIBLE
                                tvLoadingData.visibility = View.GONE
                            }

                            val mAdapter = apAdapter(apList)


                            apRecyclerView.adapter = mAdapter
                            apRecyclerView.visibility = View.VISIBLE
                            tvLoadingData.visibility = View.GONE

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
            }

        }




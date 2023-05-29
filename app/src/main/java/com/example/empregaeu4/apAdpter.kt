package com.example.empregaeu4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class apAdapter(private val OrgList: ArrayList<UsuarioDados>) :
    RecyclerView.Adapter<apAdapter.ViewHolder>() {

    // private lateinit var mListener: onItemClickListener

//    interface onItemClickListener{
//        fun onItemClick(position: Int)
//    }
//
//    fun setOnItemClickListener(clickListener: onItemClickListener){
//        mListener = clickListener
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ap_list_item, parent, false)
        return ViewHolder(itemView)
        //return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentOng = OrgList[position]
        holder.tvapName.text = currentOng.userName
    }

    override fun getItemCount(): Int {
        return OrgList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvapName : TextView = itemView.findViewById(R.id.tvApName)


    }
//    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
//
//        val tvEmpName : TextView = itemView.findViewById(R.id.tvEmpName)
//
//        init {
//            itemView.setOnClickListener {
//                clickListener.onItemClick(adapterPosition)
//            }
//        }
//
//    }

}
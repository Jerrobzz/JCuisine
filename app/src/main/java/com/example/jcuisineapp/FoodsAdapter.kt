package com.example.jcuisineapp

import android.view.LayoutInflater
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FoodsAdapter(private val context: Context, private var userSubject : ArrayList<Food>) : RecyclerView.Adapter<FoodsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_2, parent, false)
        return FoodsAdapter.MyViewHolder(itemView)//Add listener
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userSubject[position]

    }

    override fun getItemCount(): Int {
        return userSubject.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        var mTxtSubjectName: TextView = itemView.findViewById(R.id.subj_name)


    }

    companion object {
        fun MyViewHolder(itemView: View?): MyViewHolder {
            TODO("Not yet implemented")
        }
    }
}
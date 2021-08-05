package com.nicootech.simplerecyclerviewk

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val list :List<Item>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.image_view)
        val textView1 : TextView = itemView.findViewById(R.id.text_1)
        val textView2 : TextView = itemView.findViewById(R.id.text_2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2

//        if(position %3 == 0) {
//            holder.textView1.text = "Hip!"
//            holder.textView1.setBackgroundColor(Color.BLUE)
//        }
//        if(position %5 == 0){
//            holder.textView1.text = "Pop!"
//            holder.textView1.setBackgroundColor(Color.YELLOW)
//        }
//        if(position %15 ==0){
//            holder.textView1.text = "HipPop!"
//            holder.textView1.setBackgroundColor(Color.GREEN)
//        }
    }

    override fun getItemCount() = list.size
}
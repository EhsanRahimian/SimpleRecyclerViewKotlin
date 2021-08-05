package com.nicootech.simplerecyclerviewk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private val list = generateDummyList(500)
    private val adapter = Adapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


    }
    fun insertItem(view: View){
        val index  = Random.nextInt(8)
        val newItem = Item(
            R.drawable.ic_account,
            "New item at position $index",
            "Line 2"
        )
        list.add(index,newItem)
        adapter.notifyItemInserted(index)
    }
    fun removeItem(view: View){
        val index = Random.nextInt(8)
        list.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    private fun generateDummyList(size: Int): ArrayList<Item> {
        val list = ArrayList<Item>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_account
                1 -> R.drawable.ic_baseline
                else -> R.drawable.ic_brightness
            }
            val item = Item(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }


}
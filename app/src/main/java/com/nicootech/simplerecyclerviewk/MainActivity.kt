package com.nicootech.simplerecyclerviewk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = generateDummyList(100)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = Adapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


    }

    private fun generateDummyList(size: Int): List<Item> {
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
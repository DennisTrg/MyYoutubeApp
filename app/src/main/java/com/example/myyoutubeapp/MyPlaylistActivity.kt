package com.example.myyoutubeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyPlaylistActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var list: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_playlist)
        recyclerView = findViewById(R.id.recycleView)
        val intent = intent
        list = intent.getStringArrayListExtra("playList") as ArrayList<String>
//        Log.d(TAG, "onCreate: ${list}")
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        val adapter = MyPlaylistAdapter(this,list)
        recyclerView.adapter = adapter
//        var item = MyPlaylistAdapter(this,list)
//        recyclerView.setAdapter(item)



    }

}
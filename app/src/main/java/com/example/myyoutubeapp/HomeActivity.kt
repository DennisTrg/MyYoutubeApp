package com.example.myyoutubeapp

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    //val API_KEY_VALUE = "AIzaSyAWW1fmq4_PMQvkYiOHfINQ_QB_WMLJbBU"
    lateinit var urlEditText: EditText
    lateinit var playButton: Button
    lateinit var addButton: Button
    lateinit var playlistButton: Button
    val list: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()

    }
    fun initView(){
        urlEditText = findViewById(R.id.urlET)
        playButton = findViewById(R.id.playBT)
        addButton = findViewById(R.id.addBT)
        playlistButton = findViewById(R.id.playlistBT)
        urlEditText.setTextIsSelectable(true)
        playButton.setOnClickListener {
            pushToYoutubePlayer()
        }
        addButton.setOnClickListener {
            savePlaylist()
        }
        playlistButton.setOnClickListener {
            myPlaylist()
        }
//        if (urlEditText.text != null){
//            var abc = urlEditText.text.toString().split("?v=")[1]
//            Log.d(TAG, "onCreate: ${abc}")
//        }

    }
    fun pushToYoutubePlayer(){
        val intent = Intent(this, PlayerActivity::class.java)
        if (urlEditText.text != null) {
           intent.putExtra("url", urlEditText.text.toString().split("?v=")[1])
        }

        startActivity(intent)
    }

    fun savePlaylist() {

        if (urlEditText.text != null) {
            list.add(urlEditText.text.toString())

        }

        Log.d(TAG, "savePlaylist: ${list.size}")
    }

    fun myPlaylist() {
        val intent = Intent(this, MyPlaylistActivity::class.java)
        intent.putStringArrayListExtra("playList", list)
        startActivity(intent)
    }


}


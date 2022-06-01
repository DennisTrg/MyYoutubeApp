package com.example.myyoutubeapp

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myyoutubeapp.database.User
import com.example.myyoutubeapp.database.UserDB

class SignupActivity : AppCompatActivity() {
    lateinit var fullNameEditText: EditText
    private lateinit var userNameEditText: EditText
    private lateinit var passwordEditText: EditText
    lateinit var confirmPasswordEditText: EditText
    lateinit var createButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initView()
    }

    private fun initView() {
        fullNameEditText = findViewById(R.id.fullNameET)
        userNameEditText = findViewById(R.id.userET)
        passwordEditText = findViewById(R.id.passET)
        confirmPasswordEditText = findViewById(R.id.confirmPassET)
        createButton = findViewById(R.id.createBT)
        createButton.setOnClickListener {
            onButtonCreate()
        }
    }

    private fun onButtonCreate() {
        val userName: String = userNameEditText.text.toString()
        val password: String = passwordEditText.text.toString()
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)
        ) {
            return
        }
        val user: User = User(userName, password)
        UserDB.getInstance(this).userDao().insertUser(user)
        Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show()
    }
}
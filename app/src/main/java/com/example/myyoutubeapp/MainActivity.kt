package com.example.myyoutubeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myyoutubeapp.database.User
import com.example.myyoutubeapp.database.UserDB

class MainActivity : AppCompatActivity() {
    private lateinit var userEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginBT: Button
    lateinit var signUpBT: Button
    private lateinit var mListUser: List<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mListUser = mutableListOf()
        initView()
    }

    private fun initView() {
        userEditText = findViewById(R.id.userNameET)
        passwordEditText = findViewById(R.id.passwordET)
        loginBT = findViewById(R.id.loginButton)
        signUpBT = findViewById(R.id.signupButton)
        loginBT.setOnClickListener {
            pushToPlayer()
        }
        signUpBT.setOnClickListener {
            pushToRegister()
        }
    }

    private fun pushToPlayer() {
        val userName: String = userEditText.text.toString().trim()
        val password: String = passwordEditText.text.toString().trim()
        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter your account and password!", Toast.LENGTH_SHORT)
                .show()
        } else {
            val user: User = User(userName, password)
            if (checkIsValidAccount(user)) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Your account and password is not valid!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun checkIsValidAccount(user: User): Boolean {
        mListUser = UserDB.getInstance(this).userDao().checkUser(user.userName)
        return mListUser.isNotEmpty()

    }

    private fun pushToRegister() {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)

    }
}
package com.example.myyoutubeapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun getListUser(): List<User>

    @Query("SELECT * FROM user where userName =:userName ")
    fun checkUser(userName: String): List<User>

}
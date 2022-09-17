package com.database.room.room

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ContactDao {

    @Insert()
    suspend fun insertContact(contact: Contact)

    @Delete()
    suspend fun deleteContact(contact: Contact)

    @Update()
    suspend fun updateContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getContact() : List<Contact>

}
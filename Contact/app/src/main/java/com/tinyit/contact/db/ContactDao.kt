package com.tinyit.contact.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Query("SELECT * FROM ContactInfo ORDER BY id DESC")
    fun getAllContactInfo(): LiveData<List<ContactEntity>>?

    @Insert
    fun insertContact(user: ContactEntity?)

    @Delete
    fun deleteContact(user: ContactEntity?)

    @Update
    fun updateContact(user: ContactEntity?)
}
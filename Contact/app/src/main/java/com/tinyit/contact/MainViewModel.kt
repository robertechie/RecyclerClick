package com.tinyit.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tinyit.contact.db.ContactDatabase
import com.tinyit.contact.db.ContactEntity

class MainViewModel(app: Application) : AndroidViewModel(app) {

    fun getAllContactObservers(): LiveData<List<ContactEntity>> {
        return ContactDatabase.getDatabase((getApplication()))?.contactDao()?.getAllContactInfo()!!
    }


    fun insertUserInfo(entity: ContactEntity) {
        val userDao = ContactDatabase.getDatabase(getApplication())?.contactDao()
        userDao?.insertContact(entity)
    }

    fun updateUserInfo(entity: ContactEntity) {
        val userDao = ContactDatabase.getDatabase(getApplication())?.contactDao()
        userDao?.updateContact(entity)

    }

    fun deleteUserInfo(entity: ContactEntity) {
        val userDao = ContactDatabase.getDatabase(getApplication())?.contactDao()
        userDao?.deleteContact(entity)
    }

}
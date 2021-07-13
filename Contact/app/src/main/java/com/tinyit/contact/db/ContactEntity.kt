package com.tinyit.contact.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ContactInfo")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name="phone") var phone:Long,
    @ColumnInfo(name="email") var email:String,
    @ColumnInfo(name="name") var name:String,
    @ColumnInfo(name="address") var address:String,
)

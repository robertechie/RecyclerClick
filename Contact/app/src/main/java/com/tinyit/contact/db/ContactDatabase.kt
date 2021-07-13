package com.tinyit.contact.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [ContactEntity::class], version = 2)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao?

    companion object {
        private var INSTANCE: ContactDatabase? = null
//        val migration_1_2: Migration = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE ContactInfo ADD COLUMN phone TEXT DEFAULT ''")
//            }
//        }

        fun getDatabase(context: Context):ContactDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<ContactDatabase>(
                    context.applicationContext,
                    ContactDatabase::class.java, "ContactDatabase"
                )
                    .allowMainThreadQueries().build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}

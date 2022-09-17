package com.database.room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Contact::class],version = 1)
@TypeConverters(Converters::class)
abstract class ContactDataBase : RoomDatabase(){

    abstract fun contactDao() : ContactDao

    companion object{

        //when you want to migrate your table
        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        @Volatile //just make sure all thread will get updated value from instance
        private var INSTANCE : ContactDataBase? = null


        fun  getDataBase(context: Context) : ContactDataBase{
            if(INSTANCE==null){
                synchronized(this){  //when multiple thread wil create db object it will prevent it and onlu one use
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDataBase::class.java,
                        Constant.DATABASENAME
                    ).addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!
        }

    }
}
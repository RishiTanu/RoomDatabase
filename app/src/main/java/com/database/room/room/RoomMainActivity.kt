package com.database.room.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.database.room.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class RoomMainActivity : AppCompatActivity() {

    lateinit var contactDataBase : ContactDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_main)
        contactDataBase  = ContactDataBase.getDataBase(this)

        GlobalScope.launch {
            contactDataBase.contactDao().insertContact(Contact(1,"Rishi","09838322222", Date(),1))
        }
    }
}
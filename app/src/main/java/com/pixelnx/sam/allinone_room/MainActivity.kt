package com.pixelnx.sam.allinone_room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pixelnx.sam.allinone_room.model.Note

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val note = Note("jhujdv", "bvghd", "kjhujd")

    }
}

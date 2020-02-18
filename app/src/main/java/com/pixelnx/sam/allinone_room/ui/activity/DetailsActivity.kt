package com.pixelnx.sam.allinone_room.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pixelnx.sam.allinone_room.R
import com.pixelnx.sam.allinone_room.model.Note
import com.pixelnx.sam.allinone_room.util.Const

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "DetailsActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (intent.hasExtra(Const.SELECTED_NOTE)) {
            val note = intent.getParcelableExtra<Note>(Const.SELECTED_NOTE)
            Log.i(TAG, "TITLE IS ${note.title} Date IS ${note.timeStamp}")
        }
    }
}

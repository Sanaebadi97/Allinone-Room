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

    private var isNewNotes: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (getIncomingIntent()) {

            //this is a new note (EDIT MODE)
        } else {
            //this is NOT a new note (View MODE)
        }

    }

    fun getIncomingIntent(): Boolean {
        if (intent.hasExtra(Const.SELECTED_NOTE)) {

            val incomingNote = intent.getParcelableExtra<Note>(Const.SELECTED_NOTE)
            Log.i(
                TAG,
                "INCOMING NOTE $incomingNote , ${incomingNote.timeStamp} , ${incomingNote.title}"
            )

            isNewNotes = false
            return false
        }

        isNewNotes = true
        return false
    }
}

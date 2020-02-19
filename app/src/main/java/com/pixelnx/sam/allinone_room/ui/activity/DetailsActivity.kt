package com.pixelnx.sam.allinone_room.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pixelnx.sam.allinone_room.R
import com.pixelnx.sam.allinone_room.model.Note
import com.pixelnx.sam.allinone_room.util.Const
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.layout_note_toolbar.*

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "DetailsActivity"
    }

    private var isNewNotes: Boolean? = false
    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (getIncomingIntent()) {
            //this is a new note (EDIT MODE)
            setNewNoteProperties()
        } else {
            //this is NOT a new note (View MODE)
            setNoteProperties()
        }

    }

    private fun getIncomingIntent(): Boolean {
        if (intent.hasExtra(Const.SELECTED_NOTE)) {

            note = intent.getParcelableExtra<Note>(Const.SELECTED_NOTE)
            Log.i(
                TAG,
                "INCOMING NOTE $note , ${note!!.timeStamp} , ${note!!.title}"
            )

            isNewNotes = false
            return false
        }

        isNewNotes = true
        return false
    }

    private fun setNoteProperties() {
        note_text_title.text = note!!.title
        note_edit_title.setText(note!!.title)
        note_text.setText(note!!.content)
    }

    @SuppressLint("SetTextI18n")
    private fun setNewNoteProperties() {
        note_text_title.text = getString(R.string.note_title)
        note_edit_title.setText(getString(R.string.note_title))
    }
}

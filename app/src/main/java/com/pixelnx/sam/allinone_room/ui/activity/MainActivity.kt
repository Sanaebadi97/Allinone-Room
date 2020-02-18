package com.pixelnx.sam.allinone_room.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pixelnx.sam.allinone_room.R
import com.pixelnx.sam.allinone_room.model.Note
import com.pixelnx.sam.allinone_room.ui.adapter.NoteAdapter
import com.pixelnx.sam.allinone_room.util.VerticalSpacingItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,NoteAdapter.OnNoteListener{

    companion object {
        const val TAG: String = "MainActivity"
    }

    private val noteList: MutableList<Note> = ArrayList()
    lateinit var noteAdapter: NoteAdapter
    lateinit var itemDecorator: VerticalSpacingItemDecorator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvConfig()
        insertFakeData()

        setSupportActionBar(toolbar)
        title = getString(R.string.toobar_title)


    }

    private fun rvConfig() {
        rv_note.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_note.setHasFixedSize(true)
        itemDecorator = VerticalSpacingItemDecorator(10)
        rv_note.addItemDecoration(itemDecorator)
        noteAdapter = NoteAdapter(noteList)
        rv_note.adapter = noteAdapter
    }

    private fun insertFakeData() {
        for (i in 0..100) {
            val note = Note("Title $i", "Content $i", "Dec 2018-02-09")
            noteList.add(note)
        }
        noteAdapter.notifyDataSetChanged()
    }

    override fun onNoteClick(position: Int) {
    }
}

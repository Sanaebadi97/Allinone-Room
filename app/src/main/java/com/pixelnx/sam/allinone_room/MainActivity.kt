package com.pixelnx.sam.allinone_room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pixelnx.sam.allinone_room.adapter.NoteAdapter
import com.pixelnx.sam.allinone_room.model.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "MainActivity"
    }

    // lateinit var recyclerView: RecyclerView
    private val noteList: MutableList<Note> = ArrayList<Note>()
    lateinit var noteAdapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recyclerView = findViewById(R.id.rv_note)

        rvConfig()
        insertFakeData()


    }

    private fun rvConfig() {
        rv_note.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_note.setHasFixedSize(true)
        noteAdapter = NoteAdapter(noteList)
        rv_note.adapter = noteAdapter
    }

    private fun insertFakeData() {
        for (i in 0..100) {
            val note = Note("Title $i", "Content $i", "Date $i")
            noteList.add(note)
        }
        noteAdapter.notifyDataSetChanged()
    }
}

package com.pixelnx.sam.allinone_room.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pixelnx.sam.allinone_room.R
import com.pixelnx.sam.allinone_room.model.Note

class NoteAdapter(var notList: List<Note>, var onNoteListener: OnNoteListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View, var onNoteListener: OnNoteListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {


        val title: TextView = itemView.findViewById(R.id.note_title)
        val timeStamp: TextView = itemView.findViewById(R.id.note_timestamp)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onNoteListener.onNoteClick(adapterPosition)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.note_item_list, parent, false)
        return NoteViewHolder(view, onNoteListener)
    }

    override fun getItemCount() = notList.size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.timeStamp.text = notList[position].timeStamp
        holder.title.text = notList[position].title

    }

    public interface OnNoteListener {
        fun onNoteClick(position: Int)
    }
}
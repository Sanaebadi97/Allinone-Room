package com.pixelnx.sam.allinone_room.model

data class Note(
    val title: String,
    val content: String,
    val timeStamp: String
) {

    override fun toString(): String {
        return super.toString()
        println("Title $title , Content $content , TimeSyamp $timeStamp")
    }
}
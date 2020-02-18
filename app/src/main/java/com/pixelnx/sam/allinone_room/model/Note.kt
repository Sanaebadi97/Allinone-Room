package com.pixelnx.sam.allinone_room.model

import android.os.Parcel
import android.os.Parcelable

data class Note (
    var title: String,
    val content: String,
    val timeStamp: String
) :Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun toString(): String {
        return super.toString()
        println("Title $title , Content $content , TimeSyamp $timeStamp")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(timeStamp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }
}
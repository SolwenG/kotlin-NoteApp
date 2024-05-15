package com.example.noteapp

import android.os.Parcel
import android.os.Parcelable

data class Note(var title: String? = "", var text: String? = "", var filename: String? = "")
    : Parcelable {

    constructor(parcel: Parcel): this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {}

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(text)
        parcel.writeString(filename)
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        private val serialVersionUid : Long = 11111111

        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }
}

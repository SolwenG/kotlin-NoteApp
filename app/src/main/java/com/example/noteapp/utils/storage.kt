package com.example.noteapp.utils

import android.content.Context
import android.text.TextUtils
import com.example.noteapp.Note
import java.io.ObjectOutputStream
import java.util.UUID

fun persistNote(context: Context, note: Note) {
    if(TextUtils.isEmpty(note.filename)) {
        note.filename = UUID.randomUUID().toString()+".note"
    }

    val fileOutput = context.openFileOutput(note.filename, Context.MODE_PRIVATE)
    val outputStream = ObjectOutputStream(fileOutput)

    outputStream.writeObject(note)
    outputStream.close()
}
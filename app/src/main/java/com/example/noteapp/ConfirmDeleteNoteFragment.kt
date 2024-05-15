package com.example.noteapp

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ConfirmDeleteNoteFragment(val noteTitle: String=""): DialogFragment() {
    interface  ConfirmDeleteDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    var listener: ConfirmDeleteDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = activity?.let { AlertDialog.Builder(it) }

        builder?.setMessage("Are you sure you want to delete the note \"$noteTitle\"?")
        ?.setPositiveButton("Delete",
            DialogInterface.OnClickListener{dialog, id -> listener ?.onDialogPositiveClick()
        })
        ?.setNegativeButton("Abort",
            DialogInterface.OnClickListener{dialog, id -> listener ?.onDialogNegativeClick()
        })

        return builder!!.create()
    }
}
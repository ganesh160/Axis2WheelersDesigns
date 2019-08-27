package com.example.axis2wheelersdesigns.workingwithCamera

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.axis2wheelersdesigns.R

class ConfirmationDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(activity)
            .setMessage("Allow Access To Camera Permission")
            .setPositiveButton(android.R.string.ok) { _, _ ->
                parentFragment!!.requestPermissions(arrayOf(Manifest.permission.CAMERA),
                    1)
            }
            .setNegativeButton(android.R.string.cancel) { _, _ ->
                parentFragment!!.activity?.finish()
            }
            .create()
}
package com.vad.roomtest.screens.dialogfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.vad.roomtest.R
import com.vad.roomtest.screens.listusersfragment.UsersViewModel

class AddUserFragment(private val viewModel: UsersViewModel) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_add_user, container, false)

        val spinner = v.findViewById<Spinner>(R.id.workListSpinner)
        var works = ArrayList<String>()

        viewModel.getUsers.observe(viewLifecycleOwner) {
            works = it.map { it.work.nameWork } as ArrayList<String>
        }

        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, works.toArray())
        spinner.adapter = arrayAdapter
        spinner.setSelection(1)
        spinner.onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                println(p2)
                println(works.get(p2))
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        v.findViewById<Button>(R.id.addUserAndWorkBtn).setOnClickListener {

        }

        return v
    }
}
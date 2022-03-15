package com.vad.roomtest.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vad.roomtest.R
import com.vad.roomtest.room.dao.Work

class ListWorksFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(WorksViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v: View = inflater.inflate(R.layout.fragment_list_works, container, false)

        val recycler = v.findViewById<RecyclerView>(R.id.listWorksRecycler)
        val adapterListWorks = AdapterListWorks()

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapterListWorks

        viewModel.getWorks.observe(viewLifecycleOwner) {
            adapterListWorks.setWorks(it)
        }

        val dialog = DialogAddFragment()
        v.findViewById<Button>(R.id.addWork).setOnClickListener {
            activity?.supportFragmentManager?.let { dialog.show(it, "Add work") }
        }

        return v
    }
}
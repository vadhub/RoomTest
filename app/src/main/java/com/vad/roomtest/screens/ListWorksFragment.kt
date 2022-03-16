package com.vad.roomtest.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vad.roomtest.R

class ListWorksFragment : Fragment() {

    private val viewModel: WorksViewModel by lazy {
        val viewModelFactory = ViewModelFactory(requireActivity().application)
        ViewModelProvider(requireActivity(), viewModelFactory).get(WorksViewModel::class.java)
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
        v.findViewById<FloatingActionButton>(R.id.addWork).setOnClickListener {
            activity?.supportFragmentManager?.let { dialog.show(it, "Add work") }
        }

        return v
    }
}
package com.vad.roomtest.screens.listworksfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vad.roomtest.R
import com.vad.roomtest.screens.ClickOptionMenu
import com.vad.roomtest.screens.dialogfragments.AddWorkFragment

class ListWorksFragment : Fragment() {

    private val viewModel: WorksViewModel by lazy {
        val viewModelFactory = ViewModelFactory(requireActivity().application)
        ViewModelProvider(requireActivity(), viewModelFactory).get(WorksViewModel::class.java)
    }

    private val adapterListWorks by lazy { AdapterListWorks() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v: View = inflater.inflate(R.layout.fragment_list_works, container, false)

        val recycler = v.findViewById<RecyclerView>(R.id.listWorksRecycler)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapterListWorks

        adapterListWorks.setOnClickOptionMenu(object : ClickOptionMenu {
            override fun onClickOptionMenu(view: View, position: Int) {
                optionMenu(view, position)
            }

        })

        viewModel.getWorks.observe(viewLifecycleOwner) {
            adapterListWorks.setWorks(it)
        }

        val dialog = AddWorkFragment(viewModel)
        v.findViewById<FloatingActionButton>(R.id.addWork).setOnClickListener {
            activity?.supportFragmentManager?.let { dialog.show(it, "Add work") }
        }

        return v
    }

    fun optionMenu(view: View, position: Int) {
        val popupMenu = context?.let { PopupMenu(it, view) }
        popupMenu?.inflate(R.menu.option_menu_items)
        popupMenu?.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener when (it.itemId) {
                R.id.optDelete -> {
                    viewModel.deleteWork(adapterListWorks.getWorks().get(position))
                    true
                }
                R.id.optUpdate -> true
                else -> false
            }
        }
        popupMenu?.show()
    }
}
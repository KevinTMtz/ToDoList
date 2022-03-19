package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todolist.data.ToDo
import com.example.todolist.data.ToDoDataProvider
import com.example.todolist.databinding.FragmentInputBinding
import java.text.SimpleDateFormat
import java.util.*

class InputFragment : Fragment() {
    lateinit var binding: FragmentInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val owner = arguments?.getString("owner")
        binding.textViewListOwner.text = "${owner}'s To Do List"

        binding.buttonAdd.setOnClickListener {
            val toDo = ToDo(
                binding.textViewTitle.text.toString(),
                binding.textViewDescription.text.toString(),
                binding.textViewPriority.text.toString().toInt(),
                SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            )

            ToDoDataProvider.addData(toDo)

            val action = InputFragmentDirections.actionInputFragmentToListFragment(toDo)
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(layoutInflater)

        return binding.root
    }
}
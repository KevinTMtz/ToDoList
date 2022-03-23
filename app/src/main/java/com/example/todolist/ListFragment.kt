package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapter.ToDoAdapter
import com.example.todolist.data.ToDo
import com.example.todolist.data.ToDoDataProvider
import com.example.todolist.databinding.FragmentInputBinding
import com.example.todolist.databinding.FragmentListBinding
import java.text.SimpleDateFormat
import java.util.*

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val toDoRecyclerView : RecyclerView = binding.recyclerView
        val toDoAdapter = ToDoAdapter(ToDoDataProvider.getData())

        toDoRecyclerView.layoutManager = LinearLayoutManager(activity)
        toDoRecyclerView.adapter = toDoAdapter

        toDoAdapter.setOnItemClickListener(object: ToDoAdapter.ClickListener{
            override fun onItemClick(view: View, pos: Int) {
                Toast.makeText(context, "${toDoAdapter.getData(pos).title}\r\nPriority: ${toDoAdapter.getData(pos).priority}" , Toast.LENGTH_SHORT).show()
            }
        })

        val toDo = arguments?.getParcelable<ToDo>("todo")!!
        Toast.makeText(activity, "Added ToDo: ${toDo.title},\r\n${toDo.description},\r\n${toDo.date},\r\n${toDo.priority}", Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)

        return binding.root
    }
}
package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var itemlist = ArrayList<String>()
    var filehelp = FileHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemlist = filehelp.readData(this)
        var arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,itemlist)
        binding.itemlistview.adapter = arrayAdapter


        binding.button.setOnClickListener {
            var itemName:String = binding.addtaskcontainer.text.toString()
            itemlist.add(itemName)
            binding.addtaskcontainer.setText("")
            filehelp.writedata(itemlist,applicationContext)
            arrayAdapter.notifyDataSetChanged()
        }



    }
}
package com.example.todolist

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
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
        binding.itemlistview.setOnItemClickListener { parent, view, position, id ->
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Delete")
            alert.setMessage("Do you want to delete this item?")
            alert.setCancelable(false)
            alert.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                itemlist.removeAt(position)
                arrayAdapter.notifyDataSetChanged()
                filehelp.writedata(itemlist,applicationContext)
            })
            alert.create().show()
        }





    }
}
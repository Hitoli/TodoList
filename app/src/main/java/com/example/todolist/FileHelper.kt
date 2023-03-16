package com.example.todolist

import android.content.Context
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {
    val FileName = "listinfo.dat"

     fun writedata(item:ArrayList<String>,context: Context){
         var fos: FileOutputStream = context.openFileOutput(FileName,Context.MODE_PRIVATE);
         var oas = ObjectOutputStream(fos)
         oas.writeObject(item)
         oas.close()
     }
    fun readData(context: Context): ArrayList<String> {
        var itemlist: ArrayList<String> = ArrayList()
        try {
            var fis: FileInputStream = context.openFileInput(FileName)
            var ois: ObjectInputStream = ObjectInputStream(fis)
            itemlist = ois.readObject() as ArrayList<String>
            ois.close()
            fis.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return itemlist
    }//This is a Kotlin class FileHelper that contains two functions writedata and readData.
// These functions are used for writing and reading data to/from a file respectively.
// The file name is "listinfo.dat" and it is located in the app's internal storage.

   // The writedata function takes an ArrayList of Strings and a Context as input parameters.
// It opens the file using openFileOutput method and sets the file mode to Context.MODE_PRIVATE
// which means that the file can only be accessed by the app. It then creates an ObjectOutputStream object
// and writes the ArrayList to the file using writeObject method. Finally, it closes the stream.

   // The readData function takes a Context as input parameter and returns an ArrayList of Strings.
// It first creates an empty ArrayList. It then tries to open the file using openFileInput method and
// reads the contents of the file using ObjectInputStream object's readObject method. It then closes
// the streams and returns the ArrayList. If there is an exception while reading the file, it prints
// the stack trace of the exception.

   // Overall, this class provides an easy way to read and write data to a file in the app's internal storage.

}
package com.example.suspend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("MyTag", "Calculation started.....")

            val stock1 = getStock1()
            val stock2 = getStock2()
            val total = stock1+stock2
            Log.i("MyTag", "total  is $total")

        }
    }

    private suspend fun getStock1(): Int {
        delay(10000)
        Log.i("MyTag", "stock 1 returned")
        return 55000
    }

    private suspend fun getStock2(): Int {
        delay(8000)
        Log.i("MyTag", "stock 2 returned")
        return 35000
    }


}
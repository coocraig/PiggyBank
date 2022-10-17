package com.example.piggybank

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.piggybank.databinding.ActivityMainBinding
import java.text.DateFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {


    //Creats list of transactions
    private lateinit var transactions : ArrayList<String>

    //Instantiating of binding variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var transactionAdapter: TransactionAdapter


    //Beginning the total at 0
    private var currentTotal = 0.0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        transactions = ArrayList()

        //transactions.add("Beginning")



        transactionAdapter = TransactionAdapter(transactions)
        recyclerView.adapter = transactionAdapter


        binding.button.setOnClickListener{ deposit()}

    }



    private fun deposit() {

        //Grabbing deposit amount from text field
        val depositAmount = binding.editTextNumber.text.toString().toDouble()

        //Grabs the date of the transaction and format it
        var dateCurrent = Calendar.getInstance().time
        var formattedDate = DateFormat.getDateInstance().format(dateCurrent).toString()

        //Formats the new deposit
        val formattedDeposit = NumberFormat.getCurrencyInstance().format(depositAmount)


        //Adding the number to an arraylist of strings to be in the recycler view
        transactions.add("$formattedDeposit on $formattedDate")
        //myAdapter.notifyDataSetChanged()

        //Adds the deposit to the current total
        currentTotal += depositAmount

        //formats the new total to have currency conventions
        val newTotal = NumberFormat.getCurrencyInstance().format(currentTotal)

        //Clearing the text field
        binding.editTextNumber.text.clear()

        //Sets the text of the total to the formatted new total
        binding.total.text = newTotal


        //myAdapter.notifyDataSetChanged()
    }
}
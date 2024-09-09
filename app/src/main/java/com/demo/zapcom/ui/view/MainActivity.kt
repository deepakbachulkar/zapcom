package com.demo.zapcom.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.zapcom.R
import com.demo.zapcom.data.NetworkUtils
import com.demo.zapcom.databinding.ActivityMainBinding
import com.demo.zapcom.ui.adapter.ItemsAdapter
import com.demo.zapcom.ui.view.utils.dismissLoadingDialog
import com.demo.zapcom.ui.view.utils.showLoadingDialog
import com.demo.zapcom.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var adapter: ItemsAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        setContentView(binding.root)


        // Find the Toolbar in the layout
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = resources.getString(R.string.app_name)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ItemsAdapter()

        if(NetworkUtils().isInternetAvailable(this)){
            showLoadingDialog(this)
            viewModel.items.observe(this) { items ->
                adapter.submitList(items)
                recyclerView.adapter = adapter
                dismissLoadingDialog()
            }
            binding.errorMessage.visibility = View.GONE
        }else{
            binding.errorMessage.visibility = View.VISIBLE
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
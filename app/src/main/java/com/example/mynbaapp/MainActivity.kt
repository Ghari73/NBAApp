package com.example.mynbaapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynbaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Star>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(findViewById(R.id.my_toolbar))

        binding.rvStar.setHasFixedSize(true)
        list.addAll(getListStar())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_about -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListStar(): ArrayList<Star>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataTeam = resources.getStringArray(R.array.data_team)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPos = resources.getStringArray(R.array.data_pos)
        val dataHeight = resources.getStringArray(R.array.data_height)
        val dataDesc = resources.getStringArray(R.array.data_description)

        val listStar = ArrayList<Star>()
        for (i in dataName.indices){
            val star = Star(dataName[i],dataTeam[i],dataPhoto.getResourceId(i,-1),dataDesc[i],dataHeight[i],dataPos[i])
            listStar.add(star)
        }

        return listStar
    }

    private fun showRecyclerList(){
        binding.apply {
            rvStar.layoutManager = LinearLayoutManager(this@MainActivity)
            rvStar.adapter = ListStarAdapter(list)
        }
    }
}
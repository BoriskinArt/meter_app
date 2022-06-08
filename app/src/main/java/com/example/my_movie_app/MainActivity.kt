package com.example.my_movie_app


import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.my_movie_app.Fragment.MainFragment

import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(){

    private lateinit var ft: FragmentTransaction


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    private lateinit var toolbar: Toolbar
    lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val arguments: Bundle? = intent.extras


        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            val bundle = bundleOf("some_int" to 0)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.nav_host_fragment_content_main, args = bundle)
            }
        }



    }

    override fun onStart() {
        super.onStart()
        initFields()
        createToolBar()
        initFunc()


    }



    private fun initFunc() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfig = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfig)

        createHeader()
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }



    private fun createToolBar() {
        toolbar?.setTitle("Показания счетчиков")
        setSupportActionBar(toolbar)
    }

    private fun createHeader() {
        var header: View = navView.getHeaderView(0)
        //тут происходит изменение header в navigationView
        var tx1:TextView = header.findViewById(R.id.email)
        tx1.setText("boriskin.art@yandex.r")


    }

    private fun initFields() {
        //toolbar = mBinding.toolbar

        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)

        navView = findViewById(R.id.nav_view)

        MyNavigation()

}

    fun MyNavigation(){
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {

                    toolbar?.setTitle("Показания счетчиков")
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    ft = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.nav_host_fragment_content_main, MainFragment())
                    ft.addToBackStack(null)
                    ft.commit()
                    true
                }
                R.id.nav_gallery -> {
                    Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                    finish()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }



}
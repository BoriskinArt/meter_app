package com.example.my_movie_app

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.my_movie_app.Fragment.AdminFragment
import com.example.my_movie_app.Fragment.MainFragment
import com.google.android.material.navigation.NavigationView

class MainActivityForAdmin: AppCompatActivity() {
    private lateinit var navView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var ft: FragmentTransaction
    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_layout_main)

    }

    override fun onStart(){
        super.onStart()
        initFields()
        createToolBar()
        initFunc()


    }
    private fun initFunc() {
        appBarConfig = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfig)

        createHeader()
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }

    private fun createToolBar() {
        toolbar?.setTitle("Страница администратора")
        setSupportActionBar(toolbar)
    }

    private fun createHeader() {
        var header: View = navView.getHeaderView(0)
        //тут происходит изменение header в navigationView
        //изменение шапки админа

        var admin_email: TextView = header.findViewById(R.id.admin_email)
        var fio_TV: TextView = header.findViewById(R.id.fio_TV)
        admin_email.setText("boriskin.art@yandex.ru")



    }
    private fun initFields() {
        //toolbar = mBinding.toolbar
        navController = findNavController(R.id.nav_host_fragment_content_admin)

        toolbar = findViewById(R.id.toolbar_admin)
        drawerLayout = findViewById(R.id.drawer_layout_admin)

        navView = findViewById(R.id.nav_view_admin)

        MyNavigation()

    }

    fun MyNavigation(){
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    toolbar?.setTitle("Страница администратора")
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    /*ft = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.nav_host_fragment_content_admin, AdminFragment())
                    ft.addToBackStack(null)
                    ft.commit()*/
                    val navController = Navigation.findNavController(this,R.id.nav_host_fragment_content_admin)
                    navController.navigate(R.id.admin_layout_fragment)
                    true
                }
                R.id.nav_gallery -> {

                    Toast.makeText(this, "выход", Toast.LENGTH_SHORT).show()
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
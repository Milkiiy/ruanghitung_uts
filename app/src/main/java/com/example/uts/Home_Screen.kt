package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        loadFragment(HomeFragment())
        var bottomNav = findViewById<BottomNavigationView>(R.id.navBar)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bott_menu_home -> {
                    loadFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.bott_menu_calc -> {
                    loadFragment(CalcFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.bott_menu_bmi -> {
                    loadFragment(BmiFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.bott_menu_uang -> {
                    loadFragment(UangFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.bott_menu_suhu -> {
                    loadFragment(SuhuFragment())
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }

    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}
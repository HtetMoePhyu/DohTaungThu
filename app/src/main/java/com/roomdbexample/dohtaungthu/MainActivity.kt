package com.roomdbexample.dohtaungthu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.roomdbexample.dohtaungthu.ui.notification.NotificationActivity
import kotlinx.android.synthetic.main.action_bar_main_activity.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.action_bar_main_activity)

        val navHostFragment = nav_host_fragment as NavHostFragment
        val graphInflater = navHostFragment.navController.navInflater
        val navGraph = graphInflater.inflate(R.navigation.mobile_navigation)
        navController = navHostFragment.navController

        nav_view.setOnNavigationItemSelectedListener { menuItem ->
            val destination = when (menuItem.itemId) {
                R.id.nav_home -> {
                    R.id.fragmentHome
                }
                R.id.nav_news -> {
                    R.id.fragmentNews
                }
                R.id.nav_order -> {
                    R.id.fragmentOrders
                }
                R.id.nav_profile -> {
                    R.id.fragmentProfile
                }
                else -> R.id.fragmentHome
            }
            navGraph.startDestination = destination
            navController.graph = navGraph

            return@setOnNavigationItemSelectedListener true
        }

        actionBarNotificationBtn.setOnClickListener {
            val intent = Intent(this,NotificationActivity::class.java)
            startActivity(intent)
        }
    }
}

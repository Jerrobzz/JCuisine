package com.example.jcuisineapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    lateinit var menu:CardView
    lateinit var reservation:CardView
    lateinit var order:CardView
    lateinit var chefs:CardView
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var list: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mydrawerLayout: DrawerLayout = findViewById(R.id.my_drawer)
        val navView: NavigationView = findViewById(R.id.nav_view)

        list = findViewById(R.id.list_drawout)
        list.setOnClickListener {
            mydrawerLayout.openDrawer(navView)
        }

        toggle = ActionBarDrawerToggle(this, mydrawerLayout, R.string.open, R.string.close)
        mydrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        menu = findViewById(R.id.menu)
        menu.setOnClickListener{
            startActivity(Intent(this@MainActivity,MenuActivity::class.java))
        }
        reservation = findViewById(R.id.book_reservation)
        reservation.setOnClickListener{
            startActivity(Intent(this@MainActivity,MenuActivity::class.java))
        }
        order = findViewById(R.id.order_food)
        order.setOnClickListener{
            startActivity(Intent(this@MainActivity,MenuActivity::class.java))
        }
        chefs = findViewById(R.id.chefs)
        chefs.setOnClickListener{
            startActivity(Intent(this@MainActivity,MenuActivity::class.java))
        }


    }
}
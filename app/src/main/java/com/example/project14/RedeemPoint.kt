package com.example.project14

// MainActivity.kt
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity

class RedeemPoint : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redeem_point)

        val btnShowMenu: Button = findViewById(R.id.btnShowMenu)

        // Menambahkan listener klik ke tombol
        btnShowMenu.setOnClickListener { view ->
            // Membuat objek PopupMenu dengan asosiasi dengan tombol
            val popupMenu = PopupMenu(this, view)

            // Inflate menu dari res/menu/menu_dropdown.xml
            popupMenu.menuInflater.inflate(R.menu.menu_dropdown, popupMenu.menu)

            // Menangani item yang dipilih dari menu
            popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.menu_item_1 -> {
                            // Tindakan untuk menu item 1
                            return true
                        }
                        R.id.menu_item_2 -> {
                            // Tindakan untuk menu item 2
                            return true
                        }
                        R.id.menu_item_3 -> {
                            // Tindakan untuk menu item 3
                            return true
                        }
                        else -> return false
                    }
                }
            })

            // Menampilkan popup menu
            popupMenu.show()
        }
    }
}

package com.gamespower258.chatbluetooth

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private val bluetoothAdapter: BluetoothAdapter? =
        BluetoothAdapter.getDefaultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(40, 40, 40, 40)

        val title = TextView(this)
        title.text = "CHAT BLUETOOTH"
        title.textSize = 28f

        val status = TextView(this)
        status.text = "Status: belum diperiksa"
        status.textSize = 18f

        val button = Button(this)
        button.text = "Periksa Bluetooth"

        layout.addView(title)
        layout.addView(status)
        layout.addView(button)

        setContentView(layout)

        button.setOnClickListener {

            if (bluetoothAdapter == null) {

                status.text = "Bluetooth tidak tersedia ❌"

            } else if (bluetoothAdapter.isEnabled) {

                status.text = "Bluetooth aktif ✅"

            } else {

                status.text = "Bluetooth mati ❌"

            }
        }
    }
}

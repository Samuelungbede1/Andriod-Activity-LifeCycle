package com.example.weektwotask

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //Initializing the two count variables to zero
    var portCount = 0
    var landCount = 0


    // creating the handler object to handle the delay in display
    val handler = Handler(Looper.getMainLooper())

    /*This onSaveInstance function will save the previous state of the application
    in the event of interruption*/
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("key1", portCount)
        outState.putInt("key2", landCount)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Logic to check if previous saved instance is null
        if (savedInstanceState != null) {
            portCount = savedInstanceState.getInt("key1")
            landCount = savedInstanceState.getInt("key2")
        }



        //Logic to check the current orientation
        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                landCount++
                currentOrientation.text = "LANDSCAPE $landCount"
            }
            Configuration.ORIENTATION_PORTRAIT -> {
                portCount++
                currentOrientation.text = "PORTRAIT $portCount"
            }
        }

        stateOfActivity.text = "App OnCreate Mode"

    }

    //All the functions below will display the current mode of the appCycle
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "This is OnStart mode", Toast.LENGTH_SHORT).show()
        handler.postDelayed({ stateOfActivity.text = "App OnStart Mode" }, 1500)
    }


    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "This is Resume mode", Toast.LENGTH_SHORT).show()
        handler.postDelayed({ stateOfActivity.text = "App OnStart Mode" }, 2500)
    }


    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "This is Pause mode", Toast.LENGTH_SHORT).show()
        handler.postDelayed({ stateOfActivity.text = "App OnPause Mode" }, 3000)
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "This is Stop mode", Toast.LENGTH_SHORT).show()
        handler.postDelayed({ stateOfActivity.text = "App OnStop Mode" }, 3500)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "This is Destroy mode", Toast.LENGTH_SHORT).show()
        handler.postDelayed({ stateOfActivity.text = "App OnDestroy Mode" }, 3600)
    }


    override fun onConfigurationChanged(newConfig: Configuration) {

        super.onConfigurationChanged(newConfig)
    }
}



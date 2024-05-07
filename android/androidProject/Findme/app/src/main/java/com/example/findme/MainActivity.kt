package com.example.findme

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.findme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val requestPermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){
        if(it) getLocation()
    }
    private fun getLocation(){
        if(PackageManager.PERMISSION_GRANTED == checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
            val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
            val provider = LocationManager.GPS_PROVIDER
            val location = locationManager.getLastKnownLocation(provider)
            if(location==null){
                locationManager.requestLocationUpdates(provider, 3000L, 100f) {
                        result -> displayLocation(result)
                }
            } else {
                displayLocation(location)
            }
        }
    }
    private fun displayLocation(location: Location){
        val latitude=location.latitude
        val longitude = location.longitude
        Log.d("MyLocation",

            "$latitude, $longitude")

        val url = "https://maps.google.com/maps?q=$latitude,$longitude"
        binding.webView.loadUrl(url);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.webView.webViewClient= WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://www.google.co.kr/maps/?hl=ko")

        if(PackageManager.PERMISSION_GRANTED !=
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)){
            requestPermission.launch(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        } else {
            getLocation()
        }
    }
}

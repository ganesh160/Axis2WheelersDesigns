package com.example.axis2wheelersdesigns.gps

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.axis2wheelersdesigns.BuildConfig
import com.example.axis2wheelersdesigns.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.location.*

class GettingGps : AppCompatActivity() ,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener
{

     var mGoogleApiClient:GoogleApiClient? =null
     var locationRequest: LocationRequest? = null

    lateinit var get_location:Button
    lateinit var result : PendingResult<LocationSettingsResult>
    val geocoder: Geocoder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_gps)


        get_location=findViewById(R.id.get_location)
        mGoogleApiClient =  GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).build();
        mGoogleApiClient?.connect();
        locationRequest = LocationRequest.create();
        locationRequest!!.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest!!.setInterval(30 * 1000);
        locationRequest!!.setFastestInterval(5 * 1000)


        get_location.setOnClickListener { v->
            dperformLogic()
        }


    }



    override fun onConnected(p0: Bundle?) {

        val builder =  LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest!!)
        builder.setAlwaysShow(true);
         result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient,builder.build())
        result.setResultCallback(ResultCallback { this })
    }

    override fun onConnectionSuspended(p0: Int) {

    }

    override fun onConnectionFailed(p0: ConnectionResult) {

    }


    fun dperformLogic()
    {
        val gps = LocationServicess ()
        Toast.makeText(this,""+gps.latitude,Toast.LENGTH_SHORT).show()
    }


}

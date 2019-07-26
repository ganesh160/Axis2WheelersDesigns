package com.example.axis2wheelersdesigns.gps

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.*
import android.location.LocationListener
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
import java.io.IOException
import java.lang.Error
import java.util.*

class GettingGps : AppCompatActivity() ,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener,LocationListener
{

    var isGPSEnabled :Boolean?  = false
    var isNetworkEnabled:Boolean?= false
    var canGetLocation :Boolean?= false

    var location: Location? =null
    var latitude: Double? = 0.toDouble()
    var longitude:Double? = 0.toDouble()

    var locationManager: LocationManager? =null

    var mGoogleApiClient:GoogleApiClient? =null
     var locationRequest: LocationRequest? = null

    var addresses: List<Address> = emptyList()

    lateinit var get_location:Button
    lateinit var result : PendingResult<LocationSettingsResult>
    // var geocoder: Geocoder? = null

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

        //geocoder= Geocoder(this@GettingGps, Locale.getDefault());

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

       // val gps = getLOcation()

        try {


            val gps= LocationServicess(this@GettingGps).getLOcation()

            /*val geocoder = Geocoder(this, Locale.getDefault())
            addresses = geocoder!!.getFromLocation(gps!!.latitude, gps.longitude, 1)*/

            Toast.makeText(this,""+gps!!.latitude,Toast.LENGTH_SHORT).show()
            Log.d("errss",""+addresses)
        }catch (ioException: IOException){
            Log.d("except",""+ioException)
        }

    }

    @SuppressLint("MissingPermission")
    fun getLOcation(): Location? {
        try {
            locationManager = this?.getSystemService(Context.LOCATION_SERVICE) as LocationManager

            isGPSEnabled = locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER)

            isNetworkEnabled = locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER)


            if (!isGPSEnabled!! && !isNetworkEnabled!!) {

            } else {
                this.canGetLocation = true

                if (isNetworkEnabled!!) {

                    locationManager!!.requestLocationUpdates("gps",6000,3f,this)

                    if (locationManager != null) {
                        location = locationManager?.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                        if (location != null) {
                            latitude = location?.getLatitude()
                            longitude = location?.getLongitude()
                        }
                    }
                }
                if (isGPSEnabled!!) {
                    if (location == null)
                    {
                        locationManager!!.requestLocationUpdates("gps", 60000, 3f, this)
                        if (locationManager != null) {
                            location = locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                            if (location != null) {
                                latitude = location?.getLatitude()
                                longitude = location?.getLongitude()
                            }
                        }
                    }

                } else {
                    showAlertDialog();
                }
            }
        } catch (e: Exception) {
            Log.e("errss",""+e)
        }

        return location
    }

    fun showAlertDialog()
    {
        val dialogss= AlertDialog.Builder(this)
        dialogss.setTitle("hello")
        dialogss.setPositiveButton("ok"){ dialog, which ->

            val s=Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(s)
            dialog.dismiss()
        }
        dialogss.show()
    }


    override fun onLocationChanged(p0: Location?) {
        if (location != null){
            this.location = location
        }
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}

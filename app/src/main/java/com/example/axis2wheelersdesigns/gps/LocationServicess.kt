package com.example.axis2wheelersdesigns.gps

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Service
import android.content.Context
import android.content.Intent

import android.os.IBinder

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle
import android.provider.Settings
import androidx.core.content.ContextCompat.getSystemService






class LocationServicess : Service(),LocationListener {

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



     var context: Context? =applicationContext
     var isGPSEnabled :Boolean?  = false
    var isNetworkEnabled:Boolean?= false
    var canGetLocation :Boolean?= false

      var location: Location? =null
    var latitude: Double? = 0.toDouble()
    var longitude:Double? = 0.toDouble()

     var locationManager: LocationManager? =null


    @SuppressLint("MissingPermission")
    fun getLOcation(): Location? {
        try {
            locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager

            isGPSEnabled = locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER)

            isNetworkEnabled = locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER)


            if (!isGPSEnabled!! && !isNetworkEnabled!!) {

            } else {
                this.canGetLocation = true

                if (isNetworkEnabled!!) {

                    //locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60000, 3, context)

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
                        //locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 3, context)
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
            e.printStackTrace()
        }

        return location
    }

    fun showAlertDialog()
    {
        val dialogss=AlertDialog.Builder(context)
        dialogss.setTitle("hello")
        dialogss.setPositiveButton("ok"){ dialog, which ->

            val s=Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(s)
            dialog.dismiss()
        }
        dialogss.show()
    }


    override fun onBind(p0: Intent?): IBinder? {
        getLOcation()
        return null
    }

    override fun onLocationChanged(p0: Location?) {
        if (location != null){
            this.location = location
        }
    }
}
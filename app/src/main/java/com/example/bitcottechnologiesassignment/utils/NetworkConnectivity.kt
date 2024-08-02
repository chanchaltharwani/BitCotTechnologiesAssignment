package com.example.bitcottechnologiesassignment.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
/**
 * Utility class to check network connectivity.
 */
class NetworkConnectivity {
    companion object {
        fun isInternetAvailable(contex: Context): Boolean {
            // Get the ConnectivityManager from the system services
            (contex.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
                // Check for internet capability on devices running Android Marshmallow (API 23) and above
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    return this.getNetworkCapabilities(this.activeNetwork)
                        ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
                } else {
                    // Fallback for older Android versions
                    return this.activeNetworkInfo?.isConnectedOrConnecting ?: false
                }
            }


        }
    }
}
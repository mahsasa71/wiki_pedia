package ir.dunijet.wikipedia

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build

class Vpnchecker(private val context: Context) {

    object NetworkUtils {

        fun isVpnConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val network: Network? = cm.activeNetwork
                if (network != null) {
                    val capabilities: NetworkCapabilities? = cm.getNetworkCapabilities(network)
                    return capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)
                }
            } else {
                // Deprecated in API level 23 (Marshmallow)
                // Use this for devices below API level 23
                // Note: This method may not work reliably on newer versions of Android.
                // It's recommended to target API level 23 or higher and use the new network API.
                val networkInfo = cm.activeNetworkInfo
                return networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_VPN && networkInfo.isConnected
            }
            return false
        }
    }
}
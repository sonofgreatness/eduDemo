package com.example.edudemo.utils

import android.app.Application
import android.app.Application.NOTIFICATION_SERVICE
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

import androidx.core.content.ContextCompat.getSystemService
import com.example.edudemo.R

class RaiseNotifications(context: Context) {

/*


    var builder = NotificationCompat.Builder(context, Constants.NOTIFICATIONS_CHANNEL)
        .setSmallIcon(R.drawable.notification_icon)
        .setContentTitle("Generate String")
        .setContentText("bfsbfjhbsbhbhshbfjhsb")
        .setStyle(NotificationCompat.BigTextStyle()
            .bigText("Much longer text that can not fit in  one line ......"))
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)


    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = Constants.NOTIFICATIONS_CHANNEL
            val descriptionText = Constants.NOTIFICATIONS_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(Constants.NOTIFICATIONS_CHANNEL, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

*/
}
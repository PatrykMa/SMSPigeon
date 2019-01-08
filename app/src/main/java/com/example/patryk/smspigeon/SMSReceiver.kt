package com.example.patryk.smspigeon

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.content.Context.NOTIFICATION_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.app.NotificationManager
import android.app.PendingIntent
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.app.RemoteInput


class SMSReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"odebrano",Toast.LENGTH_LONG).show()
        var intToBroadCast =Intent(context,ReplyReceiver::class.java)
        var replyPendingIntent: PendingIntent =
            PendingIntent.getBroadcast(context,
                2,
                intToBroadCast,
                PendingIntent.FLAG_UPDATE_CURRENT)

        var replyLabel: String = "replayLabel"
        var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel(replyLabel)
            build()}
        var action: NotificationCompat.Action =
            NotificationCompat.Action.Builder(R.drawable.ic_launcher_background,
                "label", replyPendingIntent)
                .addRemoteInput(remoteInput)
                .build()
        val newMessageNotification = NotificationCompat.Builder(context!!, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("title")
            .setContentText("content")
            .addAction(action)
            .setPriority(2)
            .build()

// Issue the notification.
        with(NotificationManagerCompat.from(context)) {
            notify(2, newMessageNotification)
        }


    }
}
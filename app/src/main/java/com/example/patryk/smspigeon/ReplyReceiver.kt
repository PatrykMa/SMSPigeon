package com.example.patryk.smspigeon

import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationManagerCompat
import android.widget.Toast

class ReplyReceiver():BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        //toDO
        Toast.makeText(context,"wysłano ${getMessageText(intent)}",Toast.LENGTH_SHORT).show()
        NotificationManagerCompat.from(context!!).apply {
            cancel(getID(intent))
        }
    }
    private fun getMessageText(intent: Intent?): CharSequence? {
        return RemoteInput.getResultsFromIntent(intent)?.getCharSequence(KEY_TEXT_REPLY)
    }
    private fun getID(intent: Intent?):Int
    {
        return intent?.getIntExtra(notyficationID,2)!!
    }

}
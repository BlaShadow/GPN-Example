package com.example.pushgcm;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.widget.Toast;

public class GCMBroadCastReceiver extends WakefulBroadcastReceiver{

	private String TAG = "BroadCast Receiver";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// Explicitly specify that GcmIntentService will handle the intent.
        ComponentName comp = new ComponentName(context.getPackageName(),GCMService.class.getName());
        // Start the service, keeping the device awake while it is launching.
        startWakefulService(context, (intent.setComponent(comp)));
        
        setResultCode(Activity.RESULT_OK);
        
        Toast.makeText(context,"Psh receive", 0).show();
        
        Log.i(TAG,"Notification receive");
	}

}

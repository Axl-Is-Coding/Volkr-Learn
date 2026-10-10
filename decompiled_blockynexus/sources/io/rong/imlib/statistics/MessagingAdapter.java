package io.rong.imlib.statistics;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import io.rong.imlib.statistics.DeviceId;

/* JADX INFO: loaded from: classes5.dex */
public class MessagingAdapter {
    private static final String MESSAGING_CLASS_NAME = "ly.count.android.sdk.messaging.CountlyMessaging";
    private static final String TAG = "MessagingAdapter";

    public static boolean init(Activity activity, Class<? extends Activity> cls, String str, String[] strArr) {
        try {
            Class.forName(MESSAGING_CLASS_NAME).getMethod("init", Activity.class, Class.class, String.class, String[].class).invoke(null, activity, cls, str, strArr);
            return true;
        } catch (Throwable th) {
            Log.e(TAG, "Couldn't init Statistics Messaging", th);
            return false;
        }
    }

    public static boolean isMessagingAvailable() {
        try {
            Class.forName(MESSAGING_CLASS_NAME);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean storeConfiguration(Context context, String str, String str2, String str3, DeviceId.Type type) {
        try {
            Class.forName(MESSAGING_CLASS_NAME).getMethod("storeConfiguration", Context.class, String.class, String.class, String.class, DeviceId.Type.class).invoke(null, context, str, str2, str3, type);
            return true;
        } catch (Throwable th) {
            Log.e(TAG, "Couldn't store configuration in Statistics Messaging", th);
            return false;
        }
    }
}

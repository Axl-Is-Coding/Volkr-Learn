package io.rong.imlib.statistics;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import io.rong.imlib.statistics.DeviceId;

/* JADX INFO: loaded from: classes5.dex */
public class AdvertisingIdAdapter {
    private static final String ADVERTISING_ID_CLIENT_CLASS_NAME = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static final String TAG = "AdvertisingIdAdapter";
    private static Handler handler;

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAdvertisingId(Context context) throws Throwable {
        Object objInvoke = Class.forName(ADVERTISING_ID_CLIENT_CLASS_NAME).getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
        if (objInvoke != null) {
            return (String) objInvoke.getClass().getMethod("getId", new Class[0]).invoke(objInvoke, new Object[0]);
        }
        return null;
    }

    public static boolean isAdvertisingIdAvailable() {
        try {
            Class.forName(ADVERTISING_ID_CLIENT_CLASS_NAME);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void setAdvertisingId(final Context context, final StatisticsStore statisticsStore, final DeviceId deviceId) {
        new Thread(new Runnable() { // from class: io.rong.imlib.statistics.AdvertisingIdAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    deviceId.setId(DeviceId.Type.ADVERTISING_ID, AdvertisingIdAdapter.getAdvertisingId(context));
                } catch (Throwable th) {
                    if (th.getCause() != null && th.getCause().getClass().toString().contains("GooglePlayServicesAvailabilityException")) {
                        if (Statistics.sharedInstance().isLoggingEnabled()) {
                            Log.i(AdvertisingIdAdapter.TAG, "Advertising ID cannot be determined yet");
                        }
                    } else {
                        if (th.getCause() == null || !th.getCause().getClass().toString().contains("GooglePlayServicesNotAvailableException")) {
                            Log.e(AdvertisingIdAdapter.TAG, "Couldn't get advertising ID", th);
                            return;
                        }
                        if (Statistics.sharedInstance().isLoggingEnabled()) {
                            Log.w(AdvertisingIdAdapter.TAG, "Advertising ID cannot be determined because Play Services are not available");
                        }
                        deviceId.switchToIdType(DeviceId.Type.OPEN_UDID, context, statisticsStore);
                    }
                }
            }
        }).start();
    }
}

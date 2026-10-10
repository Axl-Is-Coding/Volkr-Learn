package io.rong.push.rongpush;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import io.rong.imlib.RongJobIntentService;
import io.rong.imlib.common.SharedPreferencesUtils;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class PushService extends RongJobIntentService {
    private static final String TAG = "PushService";
    private static final int UNIQUE_JOB_ID = 2017113004;
    private static volatile boolean pushCanceled;
    private PushReceiver pushReceiver;

    public static void enqueueWork(Context context, Intent intent) {
        RongJobIntentService.enqueueWork(context, PushService.class, UNIQUE_JOB_ID, intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int handleWork(android.content.Intent r8) {
        /*
            Method dump skipped, instruction units count: 748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.push.rongpush.PushService.handleWork(android.content.Intent):int");
    }

    private void initAndUpdateWithIntentParams(Intent intent) {
        String stringExtra = intent.getStringExtra("appKey");
        String stringExtra2 = intent.getStringExtra("deviceId");
        String stringExtra3 = intent.getStringExtra(PushConst.PushDomain);
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(this, PushConst.PUSH_SHARE_PREFERENCE, 0);
        String string = sharedPreferences.getString("appKey", "");
        String string2 = sharedPreferences.getString("deviceId", "");
        String string3 = sharedPreferences.getString(PushConst.PushDomain, "");
        PushConnectivityManager.getInstance().init(this, stringExtra2, stringExtra);
        PushConnectivityManager.getInstance().setServerDomain(stringExtra3);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (!string3.equals(stringExtra3)) {
            editorEdit.putString(PushConst.PushDomain, stringExtra3);
        }
        if (!string.equals(stringExtra) || !string2.equals(stringExtra2)) {
            editorEdit.putString("appKey", stringExtra);
            editorEdit.putString("deviceId", stringExtra2);
            RLog.d(TAG, "update cached values.");
        }
        editorEdit.commit();
    }

    private void initWithCachedParams() {
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(this, PushConst.PUSH_SHARE_PREFERENCE, 0);
        String string = sharedPreferences.getString("appKey", "");
        String string2 = sharedPreferences.getString("deviceId", "");
        String string3 = sharedPreferences.getString(PushConst.PushDomain, "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || PushConnectivityManager.getInstance().isInitialized()) {
            return;
        }
        PushConnectivityManager.getInstance().init(this, string2, string);
        if (TextUtils.isEmpty(string3)) {
            return;
        }
        PushConnectivityManager.getInstance().setServerDomain(string3);
    }

    @Override // io.rong.imlib.RongJobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            this.pushReceiver = new PushReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.pushReceiver, intentFilter);
        } catch (Exception unused) {
            RLog.d(TAG, "Failed to register push receiver.");
        }
        RLog.d(TAG, "OnCreate");
    }

    @Override // io.rong.imlib.RongJobIntentService, android.app.Service
    public void onDestroy() {
        RLog.d(TAG, "onDestroy");
        super.onDestroy();
        try {
            unregisterReceiver(this.pushReceiver);
        } catch (Exception unused) {
            RLog.d(TAG, "Failed to unregister push receiver.");
        }
    }

    @Override // io.rong.imlib.RongJobIntentService
    protected void onHandleWork(Intent intent) {
        handleWork(intent);
    }

    @Override // io.rong.imlib.RongJobIntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        RLog.d(TAG, "onStartCommand, intent " + intent);
        return handleWork(intent);
    }
}

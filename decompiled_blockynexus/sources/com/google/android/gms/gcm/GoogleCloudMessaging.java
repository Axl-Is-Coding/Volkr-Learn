package com.google.android.gms.gcm;

import a.a.b;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzaf;
import com.tendcloud.tenddata.ab;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";

    @Deprecated
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";

    @Deprecated
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";

    @Deprecated
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";

    @Deprecated
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    private static GoogleCloudMessaging zzac;
    private static final AtomicInteger zzaf = new AtomicInteger(1);
    private PendingIntent zzad;
    private final Map<String, Handler> zzae = Collections.synchronizedMap(new b());
    private final BlockingQueue<Intent> zzag = new LinkedBlockingQueue();
    private final Messenger zzah = new Messenger(new zzf(this, Looper.getMainLooper()));
    private Context zzk;

    @Deprecated
    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        if (zzac == null) {
            zze(context);
            GoogleCloudMessaging googleCloudMessaging = new GoogleCloudMessaging();
            zzac = googleCloudMessaging;
            googleCloudMessaging.zzk = context.getApplicationContext();
        }
        return zzac;
    }

    @Deprecated
    private final Intent zzd(Bundle bundle, boolean z) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        if (zzf(this.zzk) < 0) {
            throw new IOException("Google Play Services missing");
        }
        Intent intent = new Intent(z ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(zzaf.zzl(this.zzk));
        zze(intent);
        int andIncrement = zzaf.getAndIncrement();
        StringBuilder sb = new StringBuilder(21);
        sb.append("google.rpc");
        sb.append(andIncrement);
        intent.putExtra("google.message_id", sb.toString());
        intent.putExtras(bundle);
        intent.putExtra("google.messenger", this.zzah);
        if (z) {
            this.zzk.sendBroadcast(intent);
        } else {
            this.zzk.startService(intent);
        }
        try {
            return this.zzag.poll(ab.R, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @VisibleForTesting
    @Deprecated
    private final synchronized String zzd(boolean z, String... strArr) throws IOException {
        String strZzl = zzaf.zzl(this.zzk);
        if (strZzl == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(',');
            sb.append(strArr[i]);
        }
        String string = sb.toString();
        Bundle bundle = new Bundle();
        if (strZzl.contains(".gsf")) {
            bundle.putString("legacy.sender", string);
            return InstanceID.getInstance(this.zzk).getToken(string, "GCM", bundle);
        }
        bundle.putString("sender", string);
        Intent intentZzd = zzd(bundle, z);
        if (intentZzd == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intentZzd.getStringExtra("registration_id");
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intentZzd.getStringExtra("error");
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzd(Intent intent) {
        Handler handlerRemove;
        String stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra == null || (handlerRemove = this.zzae.remove(stringExtra)) == null) {
            return false;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = intent;
        return handlerRemove.sendMessage(messageObtain);
    }

    static void zze(Context context) {
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 48);
        sb.append("GCM SDK is deprecated, ");
        sb.append(packageName);
        sb.append(" should update to use FCM");
        Log.w("GCM", sb.toString());
    }

    private final synchronized void zze(Intent intent) {
        if (this.zzad == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzad = PendingIntent.getBroadcast(this.zzk, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzad);
    }

    public static int zzf(Context context) {
        String strZzl = zzaf.zzl(context);
        if (strZzl == null) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strZzl, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    private final synchronized void zzg() {
        if (this.zzad != null) {
            this.zzad.cancel();
            this.zzad = null;
        }
    }

    @Deprecated
    public void close() {
        zzac = null;
        zzd.zzj = null;
        zzg();
    }

    @Deprecated
    public String getMessageType(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra != null ? stringExtra : MESSAGE_TYPE_MESSAGE;
    }

    @Deprecated
    public synchronized String register(String... strArr) throws IOException {
        return zzd(zzaf.zzk(this.zzk), strArr);
    }

    @Deprecated
    public void send(String str, String str2, long j, Bundle bundle) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        String strZzl = zzaf.zzl(this.zzk);
        if (strZzl == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        zze(intent);
        intent.setPackage(strZzl);
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        int iIndexOf = str.indexOf(64);
        String strSubstring = iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
        InstanceID.getInstance(this.zzk);
        intent.putExtra("google.from", InstanceID.zzn().zze("", strSubstring, "GCM"));
        if (!strZzl.contains(".gsf")) {
            this.zzk.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        Bundle bundle2 = new Bundle();
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj instanceof String) {
                String strValueOf = String.valueOf(str3);
                bundle2.putString(strValueOf.length() != 0 ? "gcm.".concat(strValueOf) : new String("gcm."), (String) obj);
            }
        }
        bundle2.putString("google.to", str);
        bundle2.putString("google.message_id", str2);
        InstanceID.getInstance(this.zzk).zze("GCM", "upstream", bundle2);
    }

    @Deprecated
    public void send(String str, String str2, Bundle bundle) throws IOException {
        send(str, str2, -1L, bundle);
    }

    @Deprecated
    public synchronized void unregister() throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        InstanceID.getInstance(this.zzk).deleteInstanceID();
    }
}

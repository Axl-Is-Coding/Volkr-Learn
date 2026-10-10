package com.google.android.gms.iid;

import a.a.b;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzaf {
    private PendingIntent zzad;
    private Messenger zzah;
    private Map<String, Object> zzcu = new b();
    private Messenger zzcv;
    private MessengerCompat zzcw;
    private Context zzk;
    private static final zzaj<Boolean> zzco = zzai.zzw().zzd("gcm_iid_use_messenger_ipc", true);
    private static String zzcp = null;
    private static boolean zzcq = false;
    private static int zzcr = 0;
    private static int zzcs = 0;
    private static int zzck = 0;
    private static BroadcastReceiver zzct = null;

    public zzaf(Context context) {
        this.zzk = context;
    }

    private static void zzd(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message messageObtain = Message.obtain();
            messageObtain.obj = obj2;
            try {
                messenger.send(messageObtain);
            } catch (RemoteException e2) {
                String strValueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 24);
                sb.append("Failed to send response ");
                sb.append(strValueOf);
                Log.w("InstanceID", sb.toString());
            }
        }
    }

    private final void zzd(String str, Object obj) {
        synchronized (zzaf.class) {
            Object obj2 = this.zzcu.get(str);
            this.zzcu.put(str, obj);
            zzd(obj2, obj);
        }
    }

    private static boolean zzd(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            zzcp = applicationInfo.packageName;
            zzcs = applicationInfo.uid;
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static boolean zzd(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return zzd(packageManager, str);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56 + String.valueOf(str2).length());
        sb.append("Possible malicious package ");
        sb.append(str);
        sb.append(" declares ");
        sb.append(str2);
        sb.append(" without permission");
        Log.w("InstanceID", sb.toString());
        return false;
    }

    private final synchronized void zzg(Intent intent) {
        if (this.zzad == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzad = PendingIntent.getBroadcast(this.zzk, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzad);
    }

    static String zzi(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string == null) {
            string = bundle.getString("unregistered");
        }
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("error");
        if (string2 != null) {
            throw new IOException(string2);
        }
        String strValueOf = String.valueOf(bundle);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 29);
        sb.append("Unexpected response from GCM ");
        sb.append(strValueOf);
        Log.w("InstanceID", sb.toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private final Bundle zzj(Bundle bundle) throws IOException {
        Bundle bundleZzk = zzk(bundle);
        if (bundleZzk == null || !bundleZzk.containsKey("google.messenger")) {
            return bundleZzk;
        }
        Bundle bundleZzk2 = zzk(bundle);
        if (bundleZzk2 == null || !bundleZzk2.containsKey("google.messenger")) {
            return bundleZzk2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.os.Bundle zzk(android.os.Bundle r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzaf.zzk(android.os.Bundle):android.os.Bundle");
    }

    public static boolean zzk(Context context) {
        if (zzcp != null) {
            zzl(context);
        }
        return zzcq;
    }

    public static String zzl(Context context) {
        boolean z;
        String str = zzcp;
        if (str != null) {
            return str;
        }
        zzcr = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        boolean z2 = true;
        if (!PlatformVersion.isAtLeastO()) {
            Iterator<ResolveInfo> it = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (zzd(packageManager, it.next().serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                    zzcq = false;
                    z = true;
                    break;
                }
            }
            if (z) {
                return zzcp;
            }
        }
        Iterator<ResolveInfo> it2 = packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
        while (true) {
            if (!it2.hasNext()) {
                z2 = false;
                break;
            }
            if (zzd(packageManager, it2.next().activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                zzcq = true;
                break;
            }
        }
        if (z2) {
            return zzcp;
        }
        Log.w("InstanceID", "Failed to resolve IID implementation package, falling back");
        if (zzd(packageManager, "com.google.android.gms")) {
            zzcq = PlatformVersion.isAtLeastO();
            return zzcp;
        }
        if (PlatformVersion.isAtLeastLollipop() || !zzd(packageManager, "com.google.android.gsf")) {
            Log.w("InstanceID", "Google Play services is missing, unable to get tokens");
            return null;
        }
        zzcq = false;
        return zzcp;
    }

    private static int zzm(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzl(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    private static synchronized String zzv() {
        int i;
        i = zzck;
        zzck = i + 1;
        return Integer.toString(i);
    }

    final Bundle zzd(Bundle bundle, KeyPair keyPair) throws IOException {
        int iZzm = zzm(this.zzk);
        bundle.putString("gmsv", Integer.toString(iZzm));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(InstanceID.zzg(this.zzk)));
        bundle.putString("app_ver_name", InstanceID.zzh(this.zzk));
        bundle.putString("cliv", "iid-12451000");
        bundle.putString("appid", InstanceID.zzd(keyPair));
        if (iZzm < 12000000 || !zzco.get().booleanValue()) {
            return zzj(bundle);
        }
        try {
            return (Bundle) Tasks.await(new zzr(this.zzk).zzd(1, bundle));
        } catch (InterruptedException | ExecutionException e2) {
            if (Log.isLoggable("InstanceID", 3)) {
                String strValueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(strValueOf);
                Log.d("InstanceID", sb.toString());
            }
            if ((e2.getCause() instanceof zzaa) && ((zzaa) e2.getCause()).getErrorCode() == 4) {
                return zzj(bundle);
            }
            return null;
        }
    }

    public final void zze(Message message) {
        if (message == null) {
            return;
        }
        Object obj = message.obj;
        if (!(obj instanceof Intent)) {
            Log.w("InstanceID", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) obj;
        intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof MessengerCompat) {
                this.zzcw = (MessengerCompat) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.zzcv = (Messenger) parcelableExtra;
            }
        }
        zzh((Intent) message.obj);
    }

    public final void zzh(Intent intent) {
        String strSubstring;
        if (intent == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Unexpected response: null");
                return;
            }
            return;
        }
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action) && !"com.google.android.gms.iid.InstanceID".equals(action)) {
            if (Log.isLoggable("InstanceID", 3)) {
                String strValueOf = String.valueOf(intent.getAction());
                Log.d("InstanceID", strValueOf.length() != 0 ? "Unexpected response ".concat(strValueOf) : new String("Unexpected response "));
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (!matcher.matches()) {
                if (Log.isLoggable("InstanceID", 3)) {
                    String strValueOf2 = String.valueOf(stringExtra);
                    Log.d("InstanceID", strValueOf2.length() != 0 ? "Unexpected response string: ".concat(strValueOf2) : new String("Unexpected response string: "));
                    return;
                }
                return;
            }
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            Bundle extras = intent.getExtras();
            extras.putString("registration_id", strGroup2);
            zzd(strGroup, (Object) extras);
            return;
        }
        String stringExtra2 = intent.getStringExtra("error");
        if (stringExtra2 == null) {
            String strValueOf3 = String.valueOf(intent.getExtras());
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf3).length() + 49);
            sb.append("Unexpected response, no error or registration id ");
            sb.append(strValueOf3);
            Log.w("InstanceID", sb.toString());
            return;
        }
        if (Log.isLoggable("InstanceID", 3)) {
            String strValueOf4 = String.valueOf(stringExtra2);
            Log.d("InstanceID", strValueOf4.length() != 0 ? "Received InstanceID error ".concat(strValueOf4) : new String("Received InstanceID error "));
        }
        String str = null;
        if (stringExtra2.startsWith("|")) {
            String[] strArrSplit = stringExtra2.split("\\|");
            if (!"ID".equals(strArrSplit[1])) {
                String strValueOf5 = String.valueOf(stringExtra2);
                Log.w("InstanceID", strValueOf5.length() != 0 ? "Unexpected structured response ".concat(strValueOf5) : new String("Unexpected structured response "));
            }
            if (strArrSplit.length > 2) {
                String str2 = strArrSplit[2];
                strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(":")) {
                    strSubstring = strSubstring.substring(1);
                }
                str = str2;
            } else {
                strSubstring = "UNKNOWN";
            }
            stringExtra2 = strSubstring;
            intent.putExtra("error", stringExtra2);
        }
        if (str != null) {
            zzd(str, (Object) stringExtra2);
            return;
        }
        synchronized (zzaf.class) {
            for (String str3 : this.zzcu.keySet()) {
                Object obj = this.zzcu.get(str3);
                this.zzcu.put(str3, stringExtra2);
                zzd(obj, stringExtra2);
            }
        }
    }
}

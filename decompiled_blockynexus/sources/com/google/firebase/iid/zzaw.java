package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaw {
    private static zzaw zzdf;
    private String zzdg = null;
    private Boolean zzdh = null;
    private Boolean zzdi = null;
    private final Queue<Intent> zzdj = new ArrayDeque();

    private zzaw() {
    }

    public static synchronized zzaw zzak() {
        if (zzdf == null) {
            zzdf = new zzaw();
        }
        return zzdf;
    }

    private final int zzd(Context context, Intent intent) {
        ComponentName componentNameStartService;
        String strZze = zze(context, intent);
        if (strZze != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(strZze);
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Restricting intent to a specific service: ".concat(strValueOf) : new String("Restricting intent to a specific service: "));
            }
            intent.setClassName(context.getPackageName(), strZze);
        }
        try {
            if (zzd(context)) {
                componentNameStartService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (IllegalStateException e2) {
            String strValueOf2 = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf2).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(strValueOf2);
            Log.e("FirebaseInstanceId", sb.toString());
            return 402;
        } catch (SecurityException e3) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e3);
            return 401;
        }
    }

    private final synchronized String zze(Context context, Intent intent) {
        if (this.zzdg != null) {
            return this.zzdg;
        }
        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfoResolveService != null && resolveInfoResolveService.serviceInfo != null) {
            ServiceInfo serviceInfo = resolveInfoResolveService.serviceInfo;
            if (context.getPackageName().equals(serviceInfo.packageName) && serviceInfo.name != null) {
                if (serviceInfo.name.startsWith(Consts.DOT)) {
                    String strValueOf = String.valueOf(context.getPackageName());
                    String strValueOf2 = String.valueOf(serviceInfo.name);
                    this.zzdg = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                } else {
                    this.zzdg = serviceInfo.name;
                }
                return this.zzdg;
            }
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 94 + String.valueOf(str2).length());
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(str);
            sb.append("/");
            sb.append(str2);
            Log.e("FirebaseInstanceId", sb.toString());
            return null;
        }
        Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    public final Intent zzal() {
        return this.zzdj.poll();
    }

    public final int zzc(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Starting service");
        }
        this.zzdj.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return zzd(context, intent2);
    }

    final boolean zzd(Context context) {
        if (this.zzdh == null) {
            this.zzdh = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.zzdh.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.zzdh.booleanValue();
    }

    final boolean zze(Context context) {
        if (this.zzdi == null) {
            this.zzdi = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.zzdh.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.zzdi.booleanValue();
    }
}

package com.google.firebase.iid;

import a.a.b;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class zzaz {
    private final zzav zzar;
    private int zzdp = 0;
    private final Map<Integer, TaskCompletionSource<Void>> zzdq = new b();

    zzaz(zzav zzavVar) {
        this.zzar = zzavVar;
    }

    private final String zzap() {
        String strZzai;
        synchronized (this.zzar) {
            strZzai = this.zzar.zzai();
        }
        if (TextUtils.isEmpty(strZzai)) {
            return null;
        }
        String[] strArrSplit = strZzai.split(",");
        if (strArrSplit.length <= 1 || TextUtils.isEmpty(strArrSplit[1])) {
            return null;
        }
        return strArrSplit[1];
    }

    private final synchronized boolean zzk(String str) {
        synchronized (this.zzar) {
            String strZzai = this.zzar.zzai();
            String strValueOf = String.valueOf(str);
            if (!strZzai.startsWith(strValueOf.length() != 0 ? ",".concat(strValueOf) : new String(","))) {
                return false;
            }
            String strValueOf2 = String.valueOf(str);
            this.zzar.zzf(strZzai.substring((strValueOf2.length() != 0 ? ",".concat(strValueOf2) : new String(",")).length()));
            return true;
        }
    }

    final synchronized Task<Void> zza(String str) {
        String strZzai;
        TaskCompletionSource<Void> taskCompletionSource;
        synchronized (this.zzar) {
            strZzai = this.zzar.zzai();
            zzav zzavVar = this.zzar;
            StringBuilder sb = new StringBuilder(String.valueOf(strZzai).length() + 1 + String.valueOf(str).length());
            sb.append(strZzai);
            sb.append(",");
            sb.append(str);
            zzavVar.zzf(sb.toString());
        }
        taskCompletionSource = new TaskCompletionSource<>();
        this.zzdq.put(Integer.valueOf(this.zzdp + (TextUtils.isEmpty(strZzai) ? 0 : strZzai.split(",").length - 1)), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    final synchronized boolean zzao() {
        return zzap() != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (com.google.firebase.iid.FirebaseInstanceId.zzm() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        android.util.Log.d("FirebaseInstanceId", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean zzc(com.google.firebase.iid.FirebaseInstanceId r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            java.lang.String r0 = r4.zzap()     // Catch: java.lang.Throwable -> L42
            r1 = 1
            if (r0 != 0) goto L17
            boolean r5 = com.google.firebase.iid.FirebaseInstanceId.zzm()     // Catch: java.lang.Throwable -> L42
            if (r5 == 0) goto L15
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r0 = "topic sync succeeded"
            android.util.Log.d(r5, r0)     // Catch: java.lang.Throwable -> L42
        L15:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            return r1
        L17:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            boolean r2 = zza(r5, r0)
            if (r2 != 0) goto L20
            r5 = 0
            return r5
        L20:
            monitor-enter(r4)
            java.util.Map<java.lang.Integer, com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>> r2 = r4.zzdq     // Catch: java.lang.Throwable -> L3f
            int r3 = r4.zzdp     // Catch: java.lang.Throwable -> L3f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r2 = r2.remove(r3)     // Catch: java.lang.Throwable -> L3f
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch: java.lang.Throwable -> L3f
            r4.zzk(r0)     // Catch: java.lang.Throwable -> L3f
            int r0 = r4.zzdp     // Catch: java.lang.Throwable -> L3f
            int r0 = r0 + r1
            r4.zzdp = r0     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L0
            r0 = 0
            r2.setResult(r0)
            goto L0
        L3f:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
            throw r5
        L42:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            goto L46
        L45:
            throw r5
        L46:
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzaz.zzc(com.google.firebase.iid.FirebaseInstanceId):boolean");
    }

    private static boolean zza(FirebaseInstanceId firebaseInstanceId, String str) {
        String[] strArrSplit = str.split("!");
        if (strArrSplit.length == 2) {
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            byte b2 = -1;
            try {
                int iHashCode = str2.hashCode();
                if (iHashCode != 83) {
                    if (iHashCode == 85 && str2.equals("U")) {
                        b2 = 1;
                    }
                } else if (str2.equals("S")) {
                    b2 = 0;
                }
                if (b2 == 0) {
                    firebaseInstanceId.zzb(str3);
                    if (FirebaseInstanceId.zzm()) {
                        Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                    }
                } else if (b2 == 1) {
                    firebaseInstanceId.zzc(str3);
                    if (FirebaseInstanceId.zzm()) {
                        Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                    }
                }
            } catch (IOException e2) {
                String strValueOf = String.valueOf(e2.getMessage());
                Log.e("FirebaseInstanceId", strValueOf.length() != 0 ? "Topic sync failed: ".concat(strValueOf) : new String("Topic sync failed: "));
                return false;
            }
        }
        return true;
    }
}

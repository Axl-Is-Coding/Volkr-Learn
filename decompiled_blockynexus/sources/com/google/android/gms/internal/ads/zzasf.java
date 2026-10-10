package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.umeng.analytics.pro.au;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzasf implements zzasj {
    private static final Object lock = new Object();

    @VisibleForTesting
    private static zzasj zzdqi = null;

    @VisibleForTesting
    private static zzasj zzdqj = null;
    private final Context zzclo;
    private final Object zzdqk;
    private final WeakHashMap<Thread, Boolean> zzdql;
    private final zzbbx zzdqm;
    private final ExecutorService zzyu;

    private zzasf(Context context) {
        this(context, zzbbx.zzyv());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063 A[Catch: all -> 0x006e, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0015, B:10:0x0027, B:12:0x0036, B:13:0x0038, B:16:0x0044, B:20:0x0053, B:21:0x0054, B:22:0x0063, B:23:0x006a, B:14:0x0039, B:15:0x0043), top: B:31:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzasj zzc(android.content.Context r4, com.google.android.gms.internal.ads.zzbbx r5) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzasf.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzasj r1 = com.google.android.gms.internal.ads.zzasf.zzdqj     // Catch: java.lang.Throwable -> L6e
            if (r1 != 0) goto L6a
            com.google.android.gms.internal.ads.zzaci<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzadb.zzdcf     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L6e
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L6e
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L63
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabb.zzcxs     // Catch: java.lang.Throwable -> L6e
            com.google.android.gms.internal.ads.zzaax r2 = com.google.android.gms.internal.ads.zzwm.zzpx()     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L6e
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L6e
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L6e
            if (r1 != 0) goto L63
            com.google.android.gms.internal.ads.zzasf r1 = new com.google.android.gms.internal.ads.zzasf     // Catch: java.lang.Throwable -> L6e
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L6e
            android.os.Looper r4 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L6e
            java.lang.Thread r4 = r4.getThread()     // Catch: java.lang.Throwable -> L6e
            if (r4 == 0) goto L54
            java.lang.Object r5 = r1.zzdqk     // Catch: java.lang.Throwable -> L6e
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L6e
            java.util.WeakHashMap<java.lang.Thread, java.lang.Boolean> r2 = r1.zzdql     // Catch: java.lang.Throwable -> L51
            r3 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L51
            r2.put(r4, r3)     // Catch: java.lang.Throwable -> L51
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L51
            java.lang.Thread$UncaughtExceptionHandler r5 = r4.getUncaughtExceptionHandler()     // Catch: java.lang.Throwable -> L6e
            com.google.android.gms.internal.ads.zzasg r2 = new com.google.android.gms.internal.ads.zzasg     // Catch: java.lang.Throwable -> L6e
            r2.<init>(r1, r5)     // Catch: java.lang.Throwable -> L6e
            r4.setUncaughtExceptionHandler(r2)     // Catch: java.lang.Throwable -> L6e
            goto L54
        L51:
            r4 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L51
            throw r4     // Catch: java.lang.Throwable -> L6e
        L54:
            java.lang.Thread$UncaughtExceptionHandler r4 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch: java.lang.Throwable -> L6e
            com.google.android.gms.internal.ads.zzash r5 = new com.google.android.gms.internal.ads.zzash     // Catch: java.lang.Throwable -> L6e
            r5.<init>(r1, r4)     // Catch: java.lang.Throwable -> L6e
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r5)     // Catch: java.lang.Throwable -> L6e
            com.google.android.gms.internal.ads.zzasf.zzdqj = r1     // Catch: java.lang.Throwable -> L6e
            goto L6a
        L63:
            com.google.android.gms.internal.ads.zzasi r4 = new com.google.android.gms.internal.ads.zzasi     // Catch: java.lang.Throwable -> L6e
            r4.<init>()     // Catch: java.lang.Throwable -> L6e
            com.google.android.gms.internal.ads.zzasf.zzdqj = r4     // Catch: java.lang.Throwable -> L6e
        L6a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6e
            com.google.android.gms.internal.ads.zzasj r4 = com.google.android.gms.internal.ads.zzasf.zzdqj
            return r4
        L6e:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6e
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasf.zzc(android.content.Context, com.google.android.gms.internal.ads.zzbbx):com.google.android.gms.internal.ads.zzasj");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[Catch: all -> 0x003a, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0015, B:10:0x0027, B:11:0x002f, B:12:0x0036), top: B:18:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzasj zzt(android.content.Context r3) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzasf.lock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzasj r1 = com.google.android.gms.internal.ads.zzasf.zzdqi     // Catch: java.lang.Throwable -> L3a
            if (r1 != 0) goto L36
            com.google.android.gms.internal.ads.zzaci<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzadb.zzdcf     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L3a
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L3a
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L2f
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabb.zzcxs     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.internal.ads.zzaax r2 = com.google.android.gms.internal.ads.zzwm.zzpx()     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L3a
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L3a
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L3a
            if (r1 != 0) goto L2f
            com.google.android.gms.internal.ads.zzasf r1 = new com.google.android.gms.internal.ads.zzasf     // Catch: java.lang.Throwable -> L3a
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.internal.ads.zzasf.zzdqi = r1     // Catch: java.lang.Throwable -> L3a
            goto L36
        L2f:
            com.google.android.gms.internal.ads.zzasi r3 = new com.google.android.gms.internal.ads.zzasi     // Catch: java.lang.Throwable -> L3a
            r3.<init>()     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.internal.ads.zzasf.zzdqi = r3     // Catch: java.lang.Throwable -> L3a
        L36:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.internal.ads.zzasj r3 = com.google.android.gms.internal.ads.zzasf.zzdqi
            return r3
        L3a:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3a
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasf.zzt(android.content.Context):com.google.android.gms.internal.ads.zzasj");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zza(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L40
            r1 = r11
            r2 = 0
            r3 = 0
        L7:
            if (r1 == 0) goto L3b
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = r3
            r3 = r2
            r2 = 0
        L11:
            if (r2 >= r5) goto L34
            r7 = r4[r2]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzbbg.zzey(r8)
            if (r8 == 0) goto L20
            r3 = 1
        L20:
            java.lang.Class<com.google.android.gms.internal.ads.zzasf> r8 = com.google.android.gms.internal.ads.zzasf.class
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L31
            r6 = 1
        L31:
            int r2 = r2 + 1
            goto L11
        L34:
            java.lang.Throwable r1 = r1.getCause()
            r2 = r3
            r3 = r6
            goto L7
        L3b:
            if (r2 == 0) goto L40
            if (r3 != 0) goto L40
            goto L41
        L40:
            r10 = 0
        L41:
            if (r10 == 0) goto L4a
            r10 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r0 = ""
            r9.zza(r11, r0, r10)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasf.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    private zzasf(Context context, zzbbx zzbbxVar) {
        this.zzdqk = new Object();
        this.zzdql = new WeakHashMap<>();
        this.zzyu = zzdvg.zzaxc().zzej(zzdvl.zzhov);
        this.zzclo = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdqm = zzbbxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasj
    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzasj
    public final void zza(Throwable th, String str, float f2) {
        if (zzbbg.zzd(th) == null) {
            return;
        }
        String name = th.getClass().getName();
        StringWriter stringWriter = new StringWriter();
        zzehy.zza(th, new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        int i = 0;
        boolean z = Math.random() < ((double) f2);
        int i2 = f2 > WheelView.DividerConfig.FILL ? (int) (1.0f / f2) : 1;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza(name, string, str, i2).toString());
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                final String str2 = (String) obj;
                final zzbbu zzbbuVar = new zzbbu();
                this.zzyu.execute(new Runnable(zzbbuVar, str2) { // from class: com.google.android.gms.internal.ads.zzase
                    private final String zzdgm;
                    private final zzbbu zzdqh;

                    {
                        this.zzdqh = zzbbuVar;
                        this.zzdgm = str2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzdqh.zzes(this.zzdgm);
                    }
                });
            }
        }
    }

    @VisibleForTesting
    private final Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean zIsCallerInstantApp;
        String packageName;
        try {
            zIsCallerInstantApp = Wrappers.packageManager(this.zzclo).isCallerInstantApp();
        } catch (Throwable th) {
            zzbbq.zzc("Error fetching instant app info", th);
            zIsCallerInstantApp = false;
        }
        try {
            packageName = this.zzclo.getPackageName();
        } catch (Throwable unused) {
            zzbbq.zzfe("Cannot obtain package name, proceeding.");
            packageName = "unknown";
        }
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(zIsCallerInstantApp)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter(au.w, Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str4 = Build.MANUFACTURER;
        String string = Build.MODEL;
        if (!string.startsWith(str4)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 1 + String.valueOf(string).length());
            sb.append(str4);
            sb.append(" ");
            sb.append(string);
            string = sb.toString();
        }
        Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter("device", string).appendQueryParameter("js", this.zzdqm.zzbre).appendQueryParameter("appid", packageName).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzabb.zzrg())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "330794610").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzwm.zzpy()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzadb.zzdcd.get()));
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcpz)).booleanValue()) {
            builderAppendQueryParameter2.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzclo))).appendQueryParameter("lite", this.zzdqm.zzeeo ? "1" : "0");
        }
        return builderAppendQueryParameter2;
    }
}

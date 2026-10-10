package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawo {
    private final AtomicReference<ExecutorService> zzdxn = new AtomicReference<>(null);
    private final Object zzdxo = new Object();
    private String zzdxp = null;
    private String zzdxq = null;

    @VisibleForTesting
    private final AtomicBoolean zzdxr = new AtomicBoolean(false);
    private final AtomicInteger zzdxs = new AtomicInteger(-1);
    private final AtomicReference<Object> zzdxt = new AtomicReference<>(null);
    private final AtomicReference<Object> zzdxu = new AtomicReference<>(null);
    private final ConcurrentMap<String, Method> zzdxv = new ConcurrentHashMap(9);
    private final AtomicReference<zzbiq> zzdxw = new AtomicReference<>(null);
    private final BlockingQueue<FutureTask<?>> zzdxx = new ArrayBlockingQueue(20);
    private final Object zzdxy = new Object();

    @VisibleForTesting
    private static boolean zzad(Context context) {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcns)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzwm.zzpx().zzd(zzabb.zzcnt)).intValue()) {
            return false;
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcnu)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    private final Method zzaj(Context context) {
        Method method = this.zzdxv.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.zzdxv.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh("logEventInternal", true);
            return null;
        }
    }

    private final Method zzm(Context context, String str) {
        Method method = this.zzdxv.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.zzdxv.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final Method zzn(Context context, String str) {
        Method method = this.zzdxv.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzdxv.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final Method zzo(Context context, String str) {
        Method method = this.zzdxv.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.zzdxv.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final ExecutorService zzvx() {
        ExecutorService threadPoolExecutor;
        if (this.zzdxn.get() == null) {
            if (ClientLibraryUtils.isPackageSide()) {
                threadPoolExecutor = zzdvg.zzaxc().zza(((Integer) zzwm.zzpx().zzd(zzabb.zzcnr)).intValue(), zzvy(), zzdvl.zzhov);
            } else {
                threadPoolExecutor = new ThreadPoolExecutor(((Integer) zzwm.zzpx().zzd(zzabb.zzcnr)).intValue(), ((Integer) zzwm.zzpx().zzd(zzabb.zzcnr)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzvy());
            }
            this.zzdxn.compareAndSet(null, threadPoolExecutor);
        }
        return this.zzdxn.get();
    }

    private final ThreadFactory zzvy() {
        return new zzaxc(this);
    }

    public final void zza(Context context, zzaae zzaaeVar) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcny)).booleanValue() && zzac(context) && zzad(context)) {
            synchronized (this.zzdxy) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzac(android.content.Context r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabb.zzcnl
            com.google.android.gms.internal.ads.zzaax r1 = com.google.android.gms.internal.ads.zzwm.zzpx()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L67
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.zzdxr
            boolean r0 = r0.get()
            if (r0 == 0) goto L1c
            goto L67
        L1c:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabb.zzcnv
            com.google.android.gms.internal.ads.zzaax r2 = com.google.android.gms.internal.ads.zzwm.zzpx()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 1
            if (r0 == 0) goto L30
            return r2
        L30:
            java.util.concurrent.atomic.AtomicInteger r0 = r4.zzdxs
            int r0 = r0.get()
            r3 = -1
            if (r0 != r3) goto L5e
            com.google.android.gms.internal.ads.zzwm.zzpt()
            r0 = 12451000(0xbdfcb8, float:1.7447567E-38)
            boolean r0 = com.google.android.gms.internal.ads.zzbbg.zzd(r5, r0)
            if (r0 != 0) goto L59
            com.google.android.gms.internal.ads.zzwm.zzpt()
            boolean r5 = com.google.android.gms.internal.ads.zzbbg.zzbp(r5)
            if (r5 == 0) goto L59
            java.lang.String r5 = "Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service."
            com.google.android.gms.internal.ads.zzbbq.zzfe(r5)
            java.util.concurrent.atomic.AtomicInteger r5 = r4.zzdxs
            r5.set(r1)
            goto L5e
        L59:
            java.util.concurrent.atomic.AtomicInteger r5 = r4.zzdxs
            r5.set(r2)
        L5e:
            java.util.concurrent.atomic.AtomicInteger r5 = r4.zzdxs
            int r5 = r5.get()
            if (r5 != r2) goto L67
            return r2
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawo.zzac(android.content.Context):boolean");
    }

    public final String zzae(Context context) {
        if (!zzac(context)) {
            return "";
        }
        if (zzad(context)) {
            return (String) zza("getCurrentScreenNameOrScreenClass", "", (zzaxf<String>) zzawx.zzdya);
        }
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdxt, true)) {
            return "";
        }
        try {
            String str = (String) zzn(context, "getCurrentScreenName").invoke(this.zzdxt.get(), new Object[0]);
            if (str == null) {
                str = (String) zzn(context, "getCurrentScreenClass").invoke(this.zzdxt.get(), new Object[0]);
            }
            return str != null ? str : "";
        } catch (Exception unused) {
            zzh("getCurrentScreenName", false);
            return "";
        }
    }

    public final String zzaf(Context context) {
        if (!zzac(context)) {
            return null;
        }
        synchronized (this.zzdxo) {
            if (this.zzdxp != null) {
                return this.zzdxp;
            }
            if (zzad(context)) {
                this.zzdxp = (String) zza("getGmpAppId", this.zzdxp, (zzaxf<String>) zzawz.zzdya);
            } else {
                this.zzdxp = (String) zza("getGmpAppId", context);
            }
            return this.zzdxp;
        }
    }

    public final String zzag(final Context context) {
        if (!zzac(context)) {
            return null;
        }
        long jLongValue = ((Long) zzwm.zzpx().zzd(zzabb.zzcnq)).longValue();
        if (zzad(context)) {
            try {
                return jLongValue < 0 ? (String) zza("getAppInstanceId", (Object) null, (zzaxf<Object>) zzawy.zzdya) : (String) zzvx().submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzaxb
                    private final zzawo zzdyb;

                    {
                        this.zzdyb = this;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzdyb.zzvz();
                    }
                }).get(jLongValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        }
        if (jLongValue < 0) {
            return (String) zza("getAppInstanceId", context);
        }
        try {
            return (String) zzvx().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.zzaxa
                private final Context zzckh;
                private final zzawo zzdyb;

                {
                    this.zzdyb = this;
                    this.zzckh = context;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzdyb.zzak(this.zzckh);
                }
            }).get(jLongValue, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused3) {
            return "TIME_OUT";
        } catch (Exception unused4) {
            return null;
        }
    }

    public final String zzah(Context context) {
        if (!zzac(context)) {
            return null;
        }
        if (zzad(context)) {
            Long l = (Long) zza("getAdEventId", (Object) null, (zzaxf<Object>) zzaxd.zzdya);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object objZza = zza("generateEventId", context);
        if (objZza != null) {
            return objZza.toString();
        }
        return null;
    }

    public final String zzai(Context context) {
        if (!zzac(context)) {
            return null;
        }
        synchronized (this.zzdxo) {
            if (this.zzdxq != null) {
                return this.zzdxq;
            }
            if (zzad(context)) {
                this.zzdxq = (String) zza("getAppIdOrigin", this.zzdxq, (zzaxf<String>) zzawq.zzdya);
            } else {
                this.zzdxq = "fa";
            }
            return this.zzdxq;
        }
    }

    final /* synthetic */ String zzak(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }

    public final void zzf(Context context, final String str) {
        if (zzac(context)) {
            if (zzad(context)) {
                zza("beginAdUnitExposure", new zzaxe(str) { // from class: com.google.android.gms.internal.ads.zzawr
                    private final String zzdgt;

                    {
                        this.zzdgt = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzaxe
                    public final void zzb(zzbiq zzbiqVar) throws RemoteException {
                        zzbiqVar.beginAdUnitExposure(this.zzdgt);
                    }
                });
            } else {
                zza(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zzg(Context context, final String str) {
        if (zzac(context)) {
            if (zzad(context)) {
                zza("endAdUnitExposure", new zzaxe(str) { // from class: com.google.android.gms.internal.ads.zzawu
                    private final String zzdgt;

                    {
                        this.zzdgt = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzaxe
                    public final void zzb(zzbiq zzbiqVar) throws RemoteException {
                        zzbiqVar.endAdUnitExposure(this.zzdgt);
                    }
                });
            } else {
                zza(context, str, "endAdUnitExposure");
            }
        }
    }

    public final void zzh(final Context context, final String str) {
        if (zzac(context) && (context instanceof Activity)) {
            if (zzad(context)) {
                zza("setScreenName", new zzaxe(context, str) { // from class: com.google.android.gms.internal.ads.zzaww
                    private final Context zzcyt;
                    private final String zzdgm;

                    {
                        this.zzcyt = context;
                        this.zzdgm = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzaxe
                    public final void zzb(zzbiq zzbiqVar) throws RemoteException {
                        Context context2 = this.zzcyt;
                        zzbiqVar.zzb(ObjectWrapper.wrap(context2), this.zzdgm, context2.getPackageName());
                    }
                });
            } else if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzdxu, false)) {
                try {
                    zzo(context, "setCurrentScreen").invoke(this.zzdxu.get(), (Activity) context, str, context.getPackageName());
                } catch (Exception unused) {
                    zzh("setCurrentScreen", false);
                }
            }
        }
    }

    public final void zzi(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzk(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzl(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }

    final /* synthetic */ String zzvz() throws Exception {
        return (String) zza("getAppInstanceId", (Object) null, (zzaxf<Object>) zzawv.zzdya);
    }

    private static Bundle zzl(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e2) {
            String strValueOf = String.valueOf(str);
            zzbbq.zzc(strValueOf.length() != 0 ? "Invalid event ID: ".concat(strValueOf) : new String("Invalid event ID: "), e2);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    public final void zza(Context context, zzvg zzvgVar) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcny)).booleanValue() && zzac(context) && zzad(context)) {
            synchronized (this.zzdxy) {
            }
        }
    }

    private final void zzh(String str, boolean z) {
        if (this.zzdxr.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
        sb.append("Invoke Firebase method ");
        sb.append(str);
        sb.append(" error.");
        zzbbq.zzfe(sb.toString());
        if (z) {
            zzbbq.zzfe("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.zzdxr.set(true);
        }
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzac(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzayp.zzei(sb.toString());
        }
    }

    private final void zza(Context context, final String str, String str2, Bundle bundle) {
        if (zzac(context)) {
            final Bundle bundleZzl = zzl(str2, str);
            if (bundle != null) {
                bundleZzl.putAll(bundle);
            }
            if (zzad(context)) {
                zza("logEventInternal", new zzaxe(str, bundleZzl) { // from class: com.google.android.gms.internal.ads.zzawt
                    private final String zzdgt;
                    private final Bundle zzdyd;

                    {
                        this.zzdgt = str;
                        this.zzdyd = bundleZzl;
                    }

                    @Override // com.google.android.gms.internal.ads.zzaxe
                    public final void zzb(zzbiq zzbiqVar) throws RemoteException {
                        zzbiqVar.logEvent("am", this.zzdgt, this.zzdyd);
                    }
                });
            } else if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdxt, true)) {
                try {
                    zzaj(context).invoke(this.zzdxt.get(), "am", str, bundleZzl);
                } catch (Exception unused) {
                    zzh("logEventInternal", true);
                }
            }
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdxt, true)) {
            try {
                zzm(context, str2).invoke(this.zzdxt.get(), str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzayp.zzei(sb.toString());
            } catch (Exception unused) {
                zzh(str2, false);
            }
        }
    }

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdxt, true)) {
            return null;
        }
        try {
            return zzn(context, str).invoke(this.zzdxt.get(), new Object[0]);
        } catch (Exception unused) {
            zzh(str, true);
            return null;
        }
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception unused) {
                zzh("getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void zza(final String str, final zzaxe zzaxeVar) {
        synchronized (this.zzdxw) {
            FutureTask<?> futureTask = new FutureTask<>(new Runnable(this, zzaxeVar, str) { // from class: com.google.android.gms.internal.ads.zzaws
                private final String zzdjk;
                private final zzawo zzdyb;
                private final zzaxe zzdyc;

                {
                    this.zzdyb = this;
                    this.zzdyc = zzaxeVar;
                    this.zzdjk = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzdyb.zza(this.zzdyc, this.zzdjk);
                }
            }, null);
            if (this.zzdxw.get() != null) {
                futureTask.run();
            } else {
                this.zzdxx.offer(futureTask);
            }
        }
    }

    private final <T> T zza(String str, T t, zzaxf<T> zzaxfVar) {
        synchronized (this.zzdxw) {
            if (this.zzdxw.get() != null) {
                try {
                    return zzaxfVar.zza(this.zzdxw.get());
                } catch (Exception unused) {
                    zzh(str, false);
                }
            }
            return t;
        }
    }

    final /* synthetic */ void zza(zzaxe zzaxeVar, String str) {
        if (this.zzdxw.get() != null) {
            try {
                zzaxeVar.zzb(this.zzdxw.get());
            } catch (Exception unused) {
                zzh(str, false);
            }
        }
    }
}

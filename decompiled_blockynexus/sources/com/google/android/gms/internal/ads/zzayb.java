package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayb {
    private zzbbx zzbpe;
    private zzqn zzdza;
    private zzdzc<ArrayList<String>> zzdzh;
    private Context zzvr;
    private final Object lock = new Object();
    private final zzayq zzdzb = new zzayq();
    private final zzayi zzdyh = new zzayi(zzwm.zzpy(), this.zzdzb);
    private boolean zzzh = false;
    private zzabi zzdzc = null;
    private Boolean zzdzd = null;
    private final AtomicInteger zzdze = new AtomicInteger(0);
    private final zzayc zzdzf = new zzayc(null);
    private final Object zzdzg = new Object();

    @TargetApi(16)
    private static ArrayList<String> zzam(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final Context getApplicationContext() {
        return this.zzvr;
    }

    public final Resources getResources() {
        if (this.zzbpe.zzeen) {
            return this.zzvr.getResources();
        }
        try {
            zzbbt.zzbu(this.zzvr).getResources();
            return null;
        } catch (zzbbv e2) {
            zzbbq.zzd("Cannot load resource from dynamite apk or local jar", e2);
            return null;
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzdzd = bool;
        }
    }

    public final void zzb(Throwable th, String str) {
        zzasf.zzc(this.zzvr, this.zzbpe).zza(th, str, zzadb.zzdch.get().floatValue());
    }

    @TargetApi(23)
    public final void zzd(Context context, zzbbx zzbbxVar) {
        synchronized (this.lock) {
            if (!this.zzzh) {
                this.zzvr = context.getApplicationContext();
                this.zzbpe = zzbbxVar;
                com.google.android.gms.ads.internal.zzp.zzku().zza(this.zzdyh);
                zzabi zzabiVar = null;
                this.zzdzb.zza(this.zzvr, (String) null, true);
                zzasf.zzc(this.zzvr, this.zzbpe);
                this.zzdza = new zzqn(context.getApplicationContext(), this.zzbpe);
                com.google.android.gms.ads.internal.zzp.zzla();
                if (zzacp.zzdap.get().booleanValue()) {
                    zzabiVar = new zzabi();
                } else {
                    zzayp.zzei("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                }
                this.zzdzc = zzabiVar;
                if (this.zzdzc != null) {
                    zzbcc.zza(new zzayd(this).zzwz(), "AppState.registerCsiReporter");
                }
                this.zzzh = true;
                zzwu();
            }
        }
        com.google.android.gms.ads.internal.zzp.zzkr().zzs(context, zzbbxVar.zzbre);
    }

    public final zzabi zzwn() {
        zzabi zzabiVar;
        synchronized (this.lock) {
            zzabiVar = this.zzdzc;
        }
        return zzabiVar;
    }

    public final Boolean zzwo() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzdzd;
        }
        return bool;
    }

    public final void zzwp() {
        this.zzdzf.zzwp();
    }

    public final void zzwq() {
        this.zzdze.incrementAndGet();
    }

    public final void zzwr() {
        this.zzdze.decrementAndGet();
    }

    public final int zzws() {
        return this.zzdze.get();
    }

    public final zzayr zzwt() {
        zzayq zzayqVar;
        synchronized (this.lock) {
            zzayqVar = this.zzdzb;
        }
        return zzayqVar;
    }

    public final zzdzc<ArrayList<String>> zzwu() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zzvr != null) {
            if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcra)).booleanValue()) {
                synchronized (this.zzdzg) {
                    if (this.zzdzh != null) {
                        return this.zzdzh;
                    }
                    zzdzc<ArrayList<String>> zzdzcVarZze = zzbbz.zzeep.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzaya
                        private final zzayb zzdyz;

                        {
                            this.zzdyz = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zzdyz.zzww();
                        }
                    });
                    this.zzdzh = zzdzcVarZze;
                    return zzdzcVarZze;
                }
            }
        }
        return zzdyq.zzaf(new ArrayList());
    }

    public final zzayi zzwv() {
        return this.zzdyh;
    }

    final /* synthetic */ ArrayList zzww() throws Exception {
        return zzam(zzatx.zzab(this.zzvr));
    }

    public final void zza(Throwable th, String str) {
        zzasf.zzc(this.zzvr, this.zzbpe).zza(th, str);
    }
}

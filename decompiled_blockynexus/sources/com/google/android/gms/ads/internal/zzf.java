package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzcw;
import com.google.android.gms.internal.ads.zzdp;
import com.google.android.gms.internal.ads.zzdw;
import com.google.android.gms.internal.ads.zzed;
import com.google.android.gms.internal.ads.zzwm;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzf implements zzdw, Runnable {
    private zzbbx zzbot;
    private Context zzvr;
    private final int zzxo;
    private final List<Object[]> zzboq = new Vector();
    private final AtomicReference<zzdw> zzbor = new AtomicReference<>();
    private final AtomicReference<zzdw> zzbos = new AtomicReference<>();
    private CountDownLatch zzbou = new CountDownLatch(1);

    public zzf(Context context, zzbbx zzbbxVar) {
        this.zzvr = context;
        this.zzbot = zzbbxVar;
        int iIntValue = ((Integer) zzwm.zzpx().zzd(zzabb.zzcqq)).intValue();
        if (iIntValue == 1) {
            this.zzxo = zzcw.zznk;
        } else if (iIntValue != 2) {
            this.zzxo = zzcw.zznj;
        } else {
            this.zzxo = zzcw.zznl;
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcrg)).booleanValue()) {
            zzbbz.zzeep.execute(this);
            return;
        }
        zzwm.zzpt();
        if (zzbbg.zzyn()) {
            zzbbz.zzeep.execute(this);
        } else {
            run();
        }
    }

    private final zzdw zzca() {
        return this.zzxo == zzcw.zznk ? this.zzbos.get() : this.zzbor.get();
    }

    private static Context zze(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final boolean zzka() {
        try {
            this.zzbou.await();
            return true;
        } catch (InterruptedException e2) {
            zzbbq.zzd("Interrupted during GADSignals creation.", e2);
            return false;
        }
    }

    private final void zzkb() {
        zzdw zzdwVarZzca = zzca();
        if (this.zzboq.isEmpty() || zzdwVarZzca == null) {
            return;
        }
        for (Object[] objArr : this.zzboq) {
            if (objArr.length == 1) {
                zzdwVarZzca.zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                zzdwVarZzca.zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzboq.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzbot.zzeen;
            if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcos)).booleanValue() && z2) {
                z = true;
            }
            if (this.zzxo != zzcw.zznk) {
                this.zzbor.set(zzed.zzb(this.zzbot.zzbre, zze(this.zzvr), z, this.zzxo));
            }
            if (this.zzxo != zzcw.zznj) {
                this.zzbos.set(zzdp.zza(this.zzbot.zzbre, zze(this.zzvr), z));
            }
        } finally {
            this.zzbou.countDown();
            this.zzvr = null;
            this.zzbot = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, View view, Activity activity) {
        zzdw zzdwVarZzca = zzca();
        return zzdwVarZzca != null ? zzdwVarZzca.zza(context, view, activity) : "";
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zzb(Context context) {
        if (!zzka()) {
            return "";
        }
        int i = this.zzxo;
        zzdw zzdwVar = (i == zzcw.zznk || i == zzcw.zznl) ? this.zzbos.get() : this.zzbor.get();
        if (zzdwVar == null) {
            return "";
        }
        zzkb();
        return zzdwVar.zzb(zze(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view, Activity activity) {
        zzdw zzdwVarZzca;
        if (!zzka() || (zzdwVarZzca = zzca()) == null) {
            return "";
        }
        zzkb();
        return zzdwVarZzca.zza(zze(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zzb(View view) {
        zzdw zzdwVarZzca = zzca();
        if (zzdwVarZzca != null) {
            zzdwVarZzca.zzb(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(MotionEvent motionEvent) {
        zzdw zzdwVarZzca = zzca();
        if (zzdwVarZzca != null) {
            zzkb();
            zzdwVarZzca.zza(motionEvent);
        } else {
            this.zzboq.add(new Object[]{motionEvent});
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(int i, int i2, int i3) {
        zzdw zzdwVarZzca = zzca();
        if (zzdwVarZzca != null) {
            zzkb();
            zzdwVarZzca.zza(i, i2, i3);
        } else {
            this.zzboq.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzajp {
    private final zzwz zzacr;
    private final Context zzvr;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zzajp(Context context, String str) {
        this(context, zzwm.zzpu().zzb(context, str, new zzanc()));
        Preconditions.checkNotNull(context, "context cannot be null");
    }

    public final zzajp zza(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        try {
            this.zzacr.zza(new zzajn(instreamAdLoadCallback));
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        return this;
    }

    public final zzajq zztg() {
        try {
            return new zzajq(this.zzvr, this.zzacr.zzqf());
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final zzajp zza(zzajo zzajoVar) {
        try {
            this.zzacr.zza(new zzajc(zzajoVar));
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        return this;
    }

    private zzajp(Context context, zzwz zzwzVar) {
        this.zzvr = context;
        this.zzacr = zzwzVar;
    }
}

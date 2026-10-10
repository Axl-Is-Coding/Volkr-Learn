package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzajq {
    private final zzvl zzacs;
    private final zzwu zzact;
    private final Context zzvr;

    zzajq(Context context, zzwu zzwuVar) {
        this(context, zzwuVar, zzvl.zzchs);
    }

    private final void zza(zzyw zzywVar) {
        try {
            this.zzact.zzb(zzvl.zza(this.zzvr, zzywVar));
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdr());
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdr());
    }

    private zzajq(Context context, zzwu zzwuVar, zzvl zzvlVar) {
        this.zzvr = context;
        this.zzact = zzwuVar;
        this.zzacs = zzvlVar;
    }
}

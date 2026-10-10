package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzsr {

    @AppOpenAd.AppOpenAdOrientation
    private final int orientation;
    private final zzyw zzacu;
    private zzxc zzbut;
    private final String zzbuu;
    private final AppOpenAd.AppOpenAdLoadCallback zzbuv;
    private final Context zzvr;
    private final zzanc zzbuw = new zzanc();
    private final zzvl zzacs = zzvl.zzchs;

    public zzsr(Context context, String str, zzyw zzywVar, @AppOpenAd.AppOpenAdOrientation int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzvr = context;
        this.zzbuu = str;
        this.zzacu = zzywVar;
        this.orientation = i;
        this.zzbuv = appOpenAdLoadCallback;
    }

    public final void zzmu() {
        try {
            this.zzbut = zzwm.zzpu().zza(this.zzvr, zzvn.zzpm(), this.zzbuu, this.zzbuw);
            this.zzbut.zza(new zzvs(this.orientation));
            this.zzbut.zza(new zzsb(this.zzbuv));
            this.zzbut.zza(zzvl.zza(this.zzvr, this.zzacu));
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }
}

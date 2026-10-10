package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbys;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdjw<AppOpenAd extends zzbqo, AppOpenRequestComponent extends zzbnw<AppOpenAd>, AppOpenRequestComponentBuilder extends zzbtq<AppOpenRequestComponent>> implements zzdae<AppOpenAd> {
    private final Executor zzfoc;
    private final ViewGroup zzfpw;
    private final zzdom zzgsm;
    private zzdzc<AppOpenAd> zzgsx;
    protected final zzbix zzguj;
    private final Context zzhah;
    private final zzdkc zzhai;
    private final zzdlv<AppOpenRequestComponent, AppOpenAd> zzhaj;

    protected zzdjw(Context context, Executor executor, zzbix zzbixVar, zzdlv<AppOpenRequestComponent, AppOpenAd> zzdlvVar, zzdkc zzdkcVar, zzdom zzdomVar) {
        this.zzhah = context;
        this.zzfoc = executor;
        this.zzguj = zzbixVar;
        this.zzhaj = zzdlvVar;
        this.zzhai = zzdkcVar;
        this.zzgsm = zzdomVar;
        this.zzfpw = new FrameLayout(context);
    }

    @Override // com.google.android.gms.internal.ads.zzdae
    public final boolean isLoading() {
        zzdzc<AppOpenAd> zzdzcVar = this.zzgsx;
        return (zzdzcVar == null || zzdzcVar.isDone()) ? false : true;
    }

    protected abstract AppOpenRequestComponentBuilder zza(zzbol zzbolVar, zzbtp zzbtpVar, zzbys zzbysVar);

    @Override // com.google.android.gms.internal.ads.zzdae
    public final synchronized boolean zza(zzvg zzvgVar, String str, zzdad zzdadVar, zzdag<? super AppOpenAd> zzdagVar) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzbbq.zzfc("Ad unit ID should not be null for app open ad.");
            this.zzfoc.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdjz
                private final zzdjw zzhak;

                {
                    this.zzhak = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhak.zzass();
                }
            });
            return false;
        }
        if (this.zzgsx != null) {
            return false;
        }
        zzdox.zze(this.zzhah, zzvgVar.zzche);
        zzdok zzdokVarZzatn = this.zzgsm.zzgt(str).zze(zzvn.zzpm()).zzh(zzvgVar).zzatn();
        zzdkd zzdkdVar = new zzdkd(null);
        zzdkdVar.zzfsk = zzdokVarZzatn;
        this.zzgsx = this.zzhaj.zza(new zzdlw(zzdkdVar), new zzdlx(this) { // from class: com.google.android.gms.internal.ads.zzdjy
            private final zzdjw zzhak;

            {
                this.zzhak = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdlx
            public final zzbtq zzc(zzdlu zzdluVar) {
                return this.zzhak.zzb(zzdluVar);
            }
        });
        zzdyq.zza(this.zzgsx, new zzdkb(this, zzdagVar, zzdkdVar), this.zzfoc);
        return true;
    }

    final /* synthetic */ void zzass() {
        this.zzhai.zzk(zzdpe.zza(zzdpg.INVALID_AD_UNIT_ID, null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized AppOpenRequestComponentBuilder zzb(zzdlu zzdluVar) {
        zzdkd zzdkdVar = (zzdkd) zzdluVar;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyg)).booleanValue()) {
            return (AppOpenRequestComponentBuilder) zza(new zzbol(this.zzfpw), new zzbtp.zza().zzce(this.zzhah).zza(zzdkdVar.zzfsk).zzajv(), new zzbys.zza().zzakr());
        }
        zzdkc zzdkcVarZzb = zzdkc.zzb(this.zzhai);
        zzbys.zza zzaVar = new zzbys.zza();
        zzaVar.zza((zzbui) zzdkcVarZzb, this.zzfoc);
        zzaVar.zza((zzbwb) zzdkcVarZzb, this.zzfoc);
        zzaVar.zza((com.google.android.gms.ads.internal.overlay.zzp) zzdkcVarZzb, this.zzfoc);
        zzaVar.zza(zzdkcVarZzb);
        return (AppOpenRequestComponentBuilder) zza(new zzbol(this.zzfpw), new zzbtp.zza().zzce(this.zzhah).zza(zzdkdVar.zzfsk).zzajv(), zzaVar.zzakr());
    }

    public final void zza(zzvs zzvsVar) {
        this.zzgsm.zzb(zzvsVar);
    }

    static /* synthetic */ zzdzc zza(zzdjw zzdjwVar, zzdzc zzdzcVar) {
        zzdjwVar.zzgsx = null;
        return null;
    }
}

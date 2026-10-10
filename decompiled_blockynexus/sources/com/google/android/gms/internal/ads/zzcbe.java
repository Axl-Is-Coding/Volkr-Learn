package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbe extends zzbqo {
    private final zzccm zzfpr;
    private boolean zzfps;
    private final WeakReference<zzbgj> zzfwr;
    private final zzbzp zzfws;
    private final zzbrh zzfwt;
    private final zzdtn zzfwu;
    private final zzbuk zzfwv;
    private final Context zzvr;

    zzcbe(zzbqn zzbqnVar, Context context, zzbgj zzbgjVar, zzbzp zzbzpVar, zzccm zzccmVar, zzbrh zzbrhVar, zzdtn zzdtnVar, zzbuk zzbukVar) {
        super(zzbqnVar);
        this.zzfps = false;
        this.zzvr = context;
        this.zzfwr = new WeakReference<>(zzbgjVar);
        this.zzfws = zzbzpVar;
        this.zzfpr = zzccmVar;
        this.zzfwt = zzbrhVar;
        this.zzfwu = zzdtnVar;
        this.zzfwv = zzbukVar;
    }

    public final void finalize() throws Throwable {
        try {
            zzbgj zzbgjVar = this.zzfwr.get();
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxj)).booleanValue()) {
                if (!this.zzfps && zzbgjVar != null) {
                    zzdzb zzdzbVar = zzbbz.zzeet;
                    zzbgjVar.getClass();
                    zzdzbVar.execute(zzcbd.zzh(zzbgjVar));
                }
            } else if (zzbgjVar != null) {
                zzbgjVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean isClosed() {
        return this.zzfwt.isClosed();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzbi(boolean r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabb.zzcnz
            com.google.android.gms.internal.ads.zzaax r1 = com.google.android.gms.internal.ads.zzwm.zzpx()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L49
            com.google.android.gms.ads.internal.zzp.zzkr()
            android.content.Context r0 = r4.zzvr
            boolean r0 = com.google.android.gms.internal.ads.zzayu.zzav(r0)
            if (r0 == 0) goto L49
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzbbq.zzfe(r0)
            com.google.android.gms.internal.ads.zzbuk r0 = r4.zzfwv
            r0.zzajw()
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabb.zzcoa
            com.google.android.gms.internal.ads.zzaax r3 = com.google.android.gms.internal.ads.zzwm.zzpx()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L4f
            com.google.android.gms.internal.ads.zzdtn r0 = r4.zzfwu
            com.google.android.gms.internal.ads.zzdog r3 = r4.zzfmw
            com.google.android.gms.internal.ads.zzdoe r3 = r3.zzhew
            com.google.android.gms.internal.ads.zzdnw r3 = r3.zzeou
            java.lang.String r3 = r3.zzdtb
            r0.zzhc(r3)
            goto L4f
        L49:
            boolean r0 = r4.zzfps
            if (r0 != 0) goto L4f
            r0 = 1
            goto L50
        L4f:
            r0 = 0
        L50:
            if (r0 != 0) goto L53
            return r2
        L53:
            com.google.android.gms.internal.ads.zzbzp r0 = r4.zzfws
            r0.zzajl()
            com.google.android.gms.internal.ads.zzccm r0 = r4.zzfpr     // Catch: com.google.android.gms.internal.ads.zzccl -> L67
            android.content.Context r3 = r4.zzvr     // Catch: com.google.android.gms.internal.ads.zzccl -> L67
            r0.zza(r5, r3)     // Catch: com.google.android.gms.internal.ads.zzccl -> L67
            com.google.android.gms.internal.ads.zzbzp r5 = r4.zzfws     // Catch: com.google.android.gms.internal.ads.zzccl -> L67
            r5.zzajj()     // Catch: com.google.android.gms.internal.ads.zzccl -> L67
            r4.zzfps = r1
            return r1
        L67:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbuk r0 = r4.zzfwv
            r0.zza(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbe.zzbi(boolean):boolean");
    }
}

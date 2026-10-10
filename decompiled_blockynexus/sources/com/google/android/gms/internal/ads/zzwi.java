package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzwi extends zzwn<zzaei> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvx zzcij;
    private final /* synthetic */ FrameLayout zzcis;
    private final /* synthetic */ FrameLayout zzcit;

    zzwi(zzvx zzvxVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzcij = zzvxVar;
        this.zzcis = frameLayout;
        this.zzcit = frameLayout2;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzaei zza(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.zza(ObjectWrapper.wrap(this.zzcis), ObjectWrapper.wrap(this.zzcit));
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    protected final /* synthetic */ zzaei zzpp() {
        zzvx.zza(this.val$context, "native_ad_view_delegate");
        return new zzzw();
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final /* synthetic */ zzaei zzpq() throws RemoteException {
        return this.zzcij.zzcin.zzb(this.val$context, this.zzcis, this.zzcit);
    }
}

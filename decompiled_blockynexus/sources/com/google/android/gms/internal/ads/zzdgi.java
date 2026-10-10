package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgi implements zzdgx<zzdgj> {
    private final zzbbx zzbpe;
    private final zzdzb zzgcz;
    private final Context zzvr;

    public zzdgi(zzdzb zzdzbVar, Context context, zzbbx zzbbxVar) {
        this.zzgcz = zzdzbVar;
        this.zzvr = context;
        this.zzbpe = zzbbxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgj> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdgl
            private final zzdgi zzgxv;

            {
                this.zzgxv = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgxv.zzary();
            }
        });
    }

    final /* synthetic */ zzdgj zzary() throws Exception {
        boolean zIsCallerInstantApp = Wrappers.packageManager(this.zzvr).isCallerInstantApp();
        com.google.android.gms.ads.internal.zzp.zzkr();
        boolean zZzaz = zzayu.zzaz(this.zzvr);
        String str = this.zzbpe.zzbre;
        com.google.android.gms.ads.internal.zzp.zzkt();
        boolean zZzxy = zzazd.zzxy();
        com.google.android.gms.ads.internal.zzp.zzkr();
        return new zzdgj(zIsCallerInstantApp, zZzaz, str, zZzxy, zzayu.zzaw(this.zzvr), DynamiteModule.getRemoteVersion(this.zzvr, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.zzvr, ModuleDescriptor.MODULE_ID));
    }
}

package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzds implements zzdux {
    private final /* synthetic */ zzdta zzwe;

    zzds(zzdp zzdpVar, zzdta zzdtaVar) {
        this.zzwe = zzdtaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdux
    public final boolean zzb(File file) {
        try {
            return this.zzwe.zzb(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}

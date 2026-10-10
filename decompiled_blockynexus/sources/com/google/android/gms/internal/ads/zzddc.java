package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddc implements zzdgu<Bundle> {
    private final float zzdrh;
    private final int zzdul;
    private final boolean zzdum;
    private final boolean zzdun;
    private final int zzduo;
    private final int zzdup;
    private final int zzduq;
    private final boolean zzgwb;

    public zzddc(int i, boolean z, boolean z2, int i2, int i3, int i4, float f2, boolean z3) {
        this.zzdul = i;
        this.zzdum = z;
        this.zzdun = z2;
        this.zzduo = i2;
        this.zzdup = i3;
        this.zzduq = i4;
        this.zzdrh = f2;
        this.zzgwb = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putInt("am", this.zzdul);
        bundle2.putBoolean("ma", this.zzdum);
        bundle2.putBoolean("sp", this.zzdun);
        bundle2.putInt("muv", this.zzduo);
        bundle2.putInt("rm", this.zzdup);
        bundle2.putInt("riv", this.zzduq);
        bundle2.putFloat("android_app_volume", this.zzdrh);
        bundle2.putBoolean("android_app_muted", this.zzgwb);
    }
}

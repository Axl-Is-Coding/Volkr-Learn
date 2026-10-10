package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzmj implements zzmc.zza {
    public final String zzagx;

    public zzmj(String str) {
        zzoz.checkNotNull(str);
        this.zzagx = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}

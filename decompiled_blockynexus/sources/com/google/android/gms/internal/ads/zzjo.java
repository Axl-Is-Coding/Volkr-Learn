package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzjn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjo implements Parcelable.Creator<zzjn.zza> {
    zzjo() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjn.zza createFromParcel(Parcel parcel) {
        return new zzjn.zza(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjn.zza[] newArray(int i) {
        return new zzjn.zza[i];
    }
}

package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzaak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaak> CREATOR = new zzaaj();

    @SafeParcelable.Field(id = 2)
    public final boolean zzadv;

    @SafeParcelable.Field(id = 3)
    public final boolean zzadw;

    @SafeParcelable.Field(id = 4)
    public final boolean zzadx;

    public zzaak(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzadv);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzadw);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzadx);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzaak(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z3) {
        this.zzadv = z;
        this.zzadw = z2;
        this.zzadx = z3;
    }
}

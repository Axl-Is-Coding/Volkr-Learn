package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "RtbVersionInfoParcelCreator")
public final class zzapv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzapv> CREATOR = new zzapy();

    @SafeParcelable.Field(id = 1)
    private final int major;

    @SafeParcelable.Field(id = 2)
    private final int minor;

    @SafeParcelable.Field(id = 3)
    private final int zzdmq;

    @SafeParcelable.Constructor
    zzapv(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3) {
        this.major = i;
        this.minor = i2;
        this.zzdmq = i3;
    }

    public static zzapv zza(VersionInfo versionInfo) {
        return new zzapv(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzapv)) {
            zzapv zzapvVar = (zzapv) obj;
            if (zzapvVar.zzdmq == this.zzdmq && zzapvVar.minor == this.minor && zzapvVar.major == this.major) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.major, this.minor, this.zzdmq});
    }

    public final String toString() {
        int i = this.major;
        int i2 = this.minor;
        int i3 = this.zzdmq;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(Consts.DOT);
        sb.append(i2);
        sb.append(Consts.DOT);
        sb.append(i3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.major);
        SafeParcelWriter.writeInt(parcel, 2, this.minor);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdmq);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "HttpRequestParcelCreator")
public final class zzaic extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaic> CREATOR = new zzaib();

    @SafeParcelable.Field(id = 1)
    private final String url;

    @SafeParcelable.Field(id = 2)
    private final String[] zzdft;

    @SafeParcelable.Field(id = 3)
    private final String[] zzdfu;

    @SafeParcelable.Constructor
    zzaic(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) String[] strArr2) {
        this.url = str;
        this.zzdft = strArr;
        this.zzdfu = strArr2;
    }

    public static zzaic zzh(zzaa<?> zzaaVar) throws zzl {
        Map<String, String> headers = zzaaVar.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new zzaic(zzaaVar.getUrl(), strArr, strArr2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzdft, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzdfu, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

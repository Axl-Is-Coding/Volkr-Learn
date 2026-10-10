package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaip implements Parcelable.Creator<zzaiq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiq createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        String strCreateString = null;
        String strCreateString2 = null;
        int i = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 2) {
                z = SafeParcelReader.readBoolean(parcel, header);
            } else if (fieldId == 3) {
                i = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                strCreateString2 = SafeParcelReader.createString(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzaiq(strCreateString, z, i, strCreateString2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiq[] newArray(int i) {
        return new zzaiq[i];
    }
}

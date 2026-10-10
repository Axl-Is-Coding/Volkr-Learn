package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaxq implements Parcelable.Creator<zzaxr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaxr createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        zzvn zzvnVar = null;
        zzvg zzvgVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 2) {
                strCreateString2 = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 3) {
                zzvnVar = (zzvn) SafeParcelReader.createParcelable(parcel, header, zzvn.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                zzvgVar = (zzvg) SafeParcelReader.createParcelable(parcel, header, zzvg.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzaxr(strCreateString, strCreateString2, zzvnVar, zzvgVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaxr[] newArray(int i) {
        return new zzaxr[i];
    }
}

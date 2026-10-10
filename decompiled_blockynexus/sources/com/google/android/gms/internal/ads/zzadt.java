package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadt implements Parcelable.Creator<zzadu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzadu createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzaak zzaakVar = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        int i4 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zzaakVar = (zzaak) SafeParcelReader.createParcelable(parcel, header, zzaak.CREATOR);
                    break;
                case 7:
                    z3 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 8:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzadu(i, z, i2, z2, i3, zzaakVar, z3, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzadu[] newArray(int i) {
        return new zzadu[i];
    }
}

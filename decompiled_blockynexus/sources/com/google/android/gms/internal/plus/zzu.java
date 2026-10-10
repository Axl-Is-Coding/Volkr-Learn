package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.plus.zzr;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class zzu implements Parcelable.Creator<zzr.zzb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzb createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        zzr.zzb.zza zzaVar = null;
        zzr.zzb.C0128zzb c0128zzb = null;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            int i3 = 1;
            if (fieldId != 1) {
                i3 = 2;
                if (fieldId != 2) {
                    i3 = 3;
                    if (fieldId != 3) {
                        i3 = 4;
                        if (fieldId != 4) {
                            SafeParcelReader.skipUnknownField(parcel, header);
                        } else {
                            i2 = SafeParcelReader.readInt(parcel, header);
                        }
                    } else {
                        c0128zzb = (zzr.zzb.C0128zzb) SafeParcelReader.createParcelable(parcel, header, zzr.zzb.C0128zzb.CREATOR);
                    }
                } else {
                    zzaVar = (zzr.zzb.zza) SafeParcelReader.createParcelable(parcel, header, zzr.zzb.zza.CREATOR);
                }
            } else {
                i = SafeParcelReader.readInt(parcel, header);
            }
            hashSet.add(Integer.valueOf(i3));
        }
        if (parcel.dataPosition() == iValidateObjectHeader) {
            return new zzr.zzb(hashSet, i, zzaVar, c0128zzb, i2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(iValidateObjectHeader);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr.zzb[] newArray(int i) {
        return new zzr.zzb[i];
    }
}

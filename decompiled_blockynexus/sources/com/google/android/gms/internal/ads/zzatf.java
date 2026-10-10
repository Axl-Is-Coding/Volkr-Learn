package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatf implements Parcelable.Creator<zzatc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatc createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundleCreateBundle = null;
        zzbbx zzbbxVar = null;
        ApplicationInfo applicationInfo = null;
        String strCreateString = null;
        ArrayList<String> arrayListCreateStringList = null;
        PackageInfo packageInfo = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        zzdqg zzdqgVar = null;
        String strCreateString4 = null;
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    bundleCreateBundle = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 2:
                    zzbbxVar = (zzbbx) SafeParcelReader.createParcelable(parcel, header, zzbbx.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.createParcelable(parcel, header, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 6:
                    packageInfo = (PackageInfo) SafeParcelReader.createParcelable(parcel, header, PackageInfo.CREATOR);
                    break;
                case 7:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 8:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 9:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 10:
                    zzdqgVar = (zzdqg) SafeParcelReader.createParcelable(parcel, header, zzdqg.CREATOR);
                    break;
                case 11:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzatc(bundleCreateBundle, zzbbxVar, applicationInfo, strCreateString, arrayListCreateStringList, packageInfo, strCreateString2, z, strCreateString3, zzdqgVar, strCreateString4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatc[] newArray(int i) {
        return new zzatc[i];
    }
}

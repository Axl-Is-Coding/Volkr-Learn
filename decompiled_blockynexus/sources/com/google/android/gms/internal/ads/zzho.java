package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.umeng.analytics.pro.au;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzho implements Parcelable {
    public static final Parcelable.Creator<zzho> CREATOR = new zzhr();
    public final int height;
    public final int width;
    private final String zzagx;
    public final int zzagy;
    public final String zzagz;
    private final zzmc zzaha;
    private final String zzahb;
    public final String zzahc;
    public final int zzahd;
    public final List<byte[]> zzahe;
    public final zzjn zzahf;
    public final float zzahg;
    public final int zzahh;
    public final float zzahi;
    private final int zzahj;
    private final byte[] zzahk;
    private final zzpr zzahl;
    public final int zzahm;
    public final int zzahn;
    public final int zzaho;
    private final int zzahp;
    private final int zzahq;
    public final long zzahr;
    public final int zzahs;
    public final String zzaht;
    private final int zzahu;
    private int zzahv;

    private zzho(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f2, int i5, float f3, byte[] bArr, int i6, zzpr zzprVar, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzjn zzjnVar, zzmc zzmcVar) {
        this.zzagx = str;
        this.zzahb = str2;
        this.zzahc = str3;
        this.zzagz = str4;
        this.zzagy = i;
        this.zzahd = i2;
        this.width = i3;
        this.height = i4;
        this.zzahg = f2;
        this.zzahh = i5;
        this.zzahi = f3;
        this.zzahk = bArr;
        this.zzahj = i6;
        this.zzahl = zzprVar;
        this.zzahm = i7;
        this.zzahn = i8;
        this.zzaho = i9;
        this.zzahp = i10;
        this.zzahq = i11;
        this.zzahs = i12;
        this.zzaht = str5;
        this.zzahu = i13;
        this.zzahr = j;
        this.zzahe = list == null ? Collections.emptyList() : list;
        this.zzahf = zzjnVar;
        this.zzaha = zzmcVar;
    }

    public static zzho zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f2, List<byte[]> list, int i5, float f3, byte[] bArr, int i6, zzpr zzprVar, zzjn zzjnVar) {
        return new zzho(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f3, bArr, i6, zzprVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, zzjnVar, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzho.class == obj.getClass()) {
            zzho zzhoVar = (zzho) obj;
            if (this.zzagy == zzhoVar.zzagy && this.zzahd == zzhoVar.zzahd && this.width == zzhoVar.width && this.height == zzhoVar.height && this.zzahg == zzhoVar.zzahg && this.zzahh == zzhoVar.zzahh && this.zzahi == zzhoVar.zzahi && this.zzahj == zzhoVar.zzahj && this.zzahm == zzhoVar.zzahm && this.zzahn == zzhoVar.zzahn && this.zzaho == zzhoVar.zzaho && this.zzahp == zzhoVar.zzahp && this.zzahq == zzhoVar.zzahq && this.zzahr == zzhoVar.zzahr && this.zzahs == zzhoVar.zzahs && zzpq.zza(this.zzagx, zzhoVar.zzagx) && zzpq.zza(this.zzaht, zzhoVar.zzaht) && this.zzahu == zzhoVar.zzahu && zzpq.zza(this.zzahb, zzhoVar.zzahb) && zzpq.zza(this.zzahc, zzhoVar.zzahc) && zzpq.zza(this.zzagz, zzhoVar.zzagz) && zzpq.zza(this.zzahf, zzhoVar.zzahf) && zzpq.zza(this.zzaha, zzhoVar.zzaha) && zzpq.zza(this.zzahl, zzhoVar.zzahl) && Arrays.equals(this.zzahk, zzhoVar.zzahk) && this.zzahe.size() == zzhoVar.zzahe.size()) {
                for (int i = 0; i < this.zzahe.size(); i++) {
                    if (!Arrays.equals(this.zzahe.get(i), zzhoVar.zzahe.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahv == 0) {
            String str = this.zzagx;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.zzahb;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzahc;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzagz;
            int iHashCode4 = (((((((((((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzagy) * 31) + this.width) * 31) + this.height) * 31) + this.zzahm) * 31) + this.zzahn) * 31;
            String str5 = this.zzaht;
            int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.zzahu) * 31;
            zzjn zzjnVar = this.zzahf;
            int iHashCode6 = (iHashCode5 + (zzjnVar == null ? 0 : zzjnVar.hashCode())) * 31;
            zzmc zzmcVar = this.zzaha;
            this.zzahv = iHashCode6 + (zzmcVar != null ? zzmcVar.hashCode() : 0);
        }
        return this.zzahv;
    }

    public final String toString() {
        String str = this.zzagx;
        String str2 = this.zzahb;
        String str3 = this.zzahc;
        int i = this.zzagy;
        String str4 = this.zzaht;
        int i2 = this.width;
        int i3 = this.height;
        float f2 = this.zzahg;
        int i4 = this.zzahm;
        int i5 = this.zzahn;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f2);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzagx);
        parcel.writeString(this.zzahb);
        parcel.writeString(this.zzahc);
        parcel.writeString(this.zzagz);
        parcel.writeInt(this.zzagy);
        parcel.writeInt(this.zzahd);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzahg);
        parcel.writeInt(this.zzahh);
        parcel.writeFloat(this.zzahi);
        parcel.writeInt(this.zzahk != null ? 1 : 0);
        byte[] bArr = this.zzahk;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzahj);
        parcel.writeParcelable(this.zzahl, i);
        parcel.writeInt(this.zzahm);
        parcel.writeInt(this.zzahn);
        parcel.writeInt(this.zzaho);
        parcel.writeInt(this.zzahp);
        parcel.writeInt(this.zzahq);
        parcel.writeInt(this.zzahs);
        parcel.writeString(this.zzaht);
        parcel.writeInt(this.zzahu);
        parcel.writeLong(this.zzahr);
        int size = this.zzahe.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzahe.get(i2));
        }
        parcel.writeParcelable(this.zzahf, 0);
        parcel.writeParcelable(this.zzaha, 0);
    }

    public final zzho zzb(int i, int i2) {
        return new zzho(this.zzagx, this.zzahb, this.zzahc, this.zzagz, this.zzagy, this.zzahd, this.width, this.height, this.zzahg, this.zzahh, this.zzahi, this.zzahk, this.zzahj, this.zzahl, this.zzahm, this.zzahn, this.zzaho, i, i2, this.zzahs, this.zzaht, this.zzahu, this.zzahr, this.zzahe, this.zzahf, this.zzaha);
    }

    public final zzho zzds(long j) {
        return new zzho(this.zzagx, this.zzahb, this.zzahc, this.zzagz, this.zzagy, this.zzahd, this.width, this.height, this.zzahg, this.zzahh, this.zzahi, this.zzahk, this.zzahj, this.zzahl, this.zzahm, this.zzahn, this.zzaho, this.zzahp, this.zzahq, this.zzahs, this.zzaht, this.zzahu, j, this.zzahe, this.zzahf, this.zzaha);
    }

    public final int zzez() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzfa() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzahc);
        String str = this.zzaht;
        if (str != null) {
            mediaFormat.setString(au.M, str);
        }
        zza(mediaFormat, "max-input-size", this.zzahd);
        zza(mediaFormat, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.width);
        zza(mediaFormat, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.height);
        float f2 = this.zzahg;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        zza(mediaFormat, "rotation-degrees", this.zzahh);
        zza(mediaFormat, "channel-count", this.zzahm);
        zza(mediaFormat, "sample-rate", this.zzahn);
        zza(mediaFormat, "encoder-delay", this.zzahp);
        zza(mediaFormat, "encoder-padding", this.zzahq);
        for (int i = 0; i < this.zzahe.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzahe.get(i)));
        }
        zzpr zzprVar = this.zzahl;
        if (zzprVar != null) {
            zza(mediaFormat, "color-transfer", zzprVar.zzarx);
            zza(mediaFormat, "color-standard", zzprVar.zzarw);
            zza(mediaFormat, "color-range", zzprVar.zzary);
            byte[] bArr = zzprVar.zzbkr;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final zzho zzv(int i) {
        return new zzho(this.zzagx, this.zzahb, this.zzahc, this.zzagz, this.zzagy, i, this.width, this.height, this.zzahg, this.zzahh, this.zzahi, this.zzahk, this.zzahj, this.zzahl, this.zzahm, this.zzahn, this.zzaho, this.zzahp, this.zzahq, this.zzahs, this.zzaht, this.zzahu, this.zzahr, this.zzahe, this.zzahf, this.zzaha);
    }

    public static zzho zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzjn zzjnVar, int i5, String str4) {
        return zza(str, str2, null, -1, -1, i3, i4, -1, null, zzjnVar, 0, str4);
    }

    public static zzho zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzjn zzjnVar, int i6, String str4) {
        return new zzho(str, null, str2, null, -1, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzjnVar, null);
    }

    public static zzho zza(String str, String str2, String str3, int i, int i2, String str4, zzjn zzjnVar) {
        return zza(str, str2, null, -1, i2, str4, -1, zzjnVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static zzho zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zzjn zzjnVar, long j, List<byte[]> list) {
        return new zzho(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzjnVar, null);
    }

    public static zzho zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzjn zzjnVar) {
        return new zzho(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzjnVar, null);
    }

    public static zzho zza(String str, String str2, long j) {
        return new zzho(null, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static zzho zza(String str, String str2, String str3, int i, zzjn zzjnVar) {
        return new zzho(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, zzjnVar, null);
    }

    public final zzho zza(zzjn zzjnVar) {
        return new zzho(this.zzagx, this.zzahb, this.zzahc, this.zzagz, this.zzagy, this.zzahd, this.width, this.height, this.zzahg, this.zzahh, this.zzahi, this.zzahk, this.zzahj, this.zzahl, this.zzahm, this.zzahn, this.zzaho, this.zzahp, this.zzahq, this.zzahs, this.zzaht, this.zzahu, this.zzahr, this.zzahe, zzjnVar, this.zzaha);
    }

    public final zzho zza(zzmc zzmcVar) {
        return new zzho(this.zzagx, this.zzahb, this.zzahc, this.zzagz, this.zzagy, this.zzahd, this.width, this.height, this.zzahg, this.zzahh, this.zzahi, this.zzahk, this.zzahj, this.zzahl, this.zzahm, this.zzahn, this.zzaho, this.zzahp, this.zzahq, this.zzahs, this.zzaht, this.zzahu, this.zzahr, this.zzahe, this.zzahf, zzmcVar);
    }

    @TargetApi(16)
    private static void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    zzho(Parcel parcel) {
        this.zzagx = parcel.readString();
        this.zzahb = parcel.readString();
        this.zzahc = parcel.readString();
        this.zzagz = parcel.readString();
        this.zzagy = parcel.readInt();
        this.zzahd = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzahg = parcel.readFloat();
        this.zzahh = parcel.readInt();
        this.zzahi = parcel.readFloat();
        this.zzahk = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzahj = parcel.readInt();
        this.zzahl = (zzpr) parcel.readParcelable(zzpr.class.getClassLoader());
        this.zzahm = parcel.readInt();
        this.zzahn = parcel.readInt();
        this.zzaho = parcel.readInt();
        this.zzahp = parcel.readInt();
        this.zzahq = parcel.readInt();
        this.zzahs = parcel.readInt();
        this.zzaht = parcel.readString();
        this.zzahu = parcel.readInt();
        this.zzahr = parcel.readLong();
        int i = parcel.readInt();
        this.zzahe = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.zzahe.add(parcel.createByteArray());
        }
        this.zzahf = (zzjn) parcel.readParcelable(zzjn.class.getClassLoader());
        this.zzaha = (zzmc) parcel.readParcelable(zzmc.class.getClassLoader());
    }
}

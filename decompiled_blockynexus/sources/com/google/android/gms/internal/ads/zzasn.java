package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
public final class zzasn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasn> CREATOR = new zzasm();

    @SafeParcelable.Field(id = 6)
    private final ApplicationInfo applicationInfo;

    @SafeParcelable.Field(id = 1)
    private final int versionCode;

    @SafeParcelable.Field(id = 11)
    private final zzbbx zzbpe;

    @SafeParcelable.Field(id = 4)
    private final zzvn zzbpf;

    @SafeParcelable.Field(id = 20)
    private final float zzbsa;

    @SafeParcelable.Field(id = 5)
    private final String zzbuu;

    @SafeParcelable.Field(id = 10)
    private final String zzcja;

    @SafeParcelable.Field(id = 42)
    private final boolean zzdko;

    @SafeParcelable.Field(id = 29)
    private final zzadu zzdly;

    @SafeParcelable.Field(id = 14)
    private final List<String> zzdlz;

    @SafeParcelable.Field(id = 18)
    private final int zzdoc;

    @SafeParcelable.Field(id = 19)
    private final int zzdod;

    @SafeParcelable.Field(id = 2)
    private final Bundle zzdqq;

    @SafeParcelable.Field(id = 3)
    private final zzvg zzdqr;

    @SafeParcelable.Field(id = 7)
    private final PackageInfo zzdqs;

    @SafeParcelable.Field(id = 8)
    private final String zzdqt;

    @SafeParcelable.Field(id = 9)
    private final String zzdqu;

    @SafeParcelable.Field(id = 12)
    private final Bundle zzdqv;

    @SafeParcelable.Field(id = 13)
    private final int zzdqw;

    @SafeParcelable.Field(id = 15)
    private final Bundle zzdqx;

    @SafeParcelable.Field(id = 16)
    private final boolean zzdqy;

    @SafeParcelable.Field(id = 21)
    private final String zzdqz;

    @SafeParcelable.Field(id = 25)
    private final long zzdra;

    @SafeParcelable.Field(id = 26)
    private final String zzdrb;

    @SafeParcelable.Field(id = 27)
    private final List<String> zzdrc;

    @SafeParcelable.Field(id = 28)
    private final String zzdrd;

    @SafeParcelable.Field(id = 30)
    private final List<String> zzdre;

    @SafeParcelable.Field(id = 31)
    private final long zzdrf;

    @SafeParcelable.Field(id = 33)
    private final String zzdrg;

    @SafeParcelable.Field(id = 34)
    private final float zzdrh;

    @SafeParcelable.Field(id = 35)
    private final int zzdri;

    @SafeParcelable.Field(id = 36)
    private final int zzdrj;

    @SafeParcelable.Field(id = 37)
    private final boolean zzdrk;

    @SafeParcelable.Field(id = 38)
    private final boolean zzdrl;

    @SafeParcelable.Field(id = 39)
    private final String zzdrm;

    @SafeParcelable.Field(id = 40)
    private final boolean zzdrn;

    @SafeParcelable.Field(id = 41)
    private final String zzdro;

    @SafeParcelable.Field(id = 43)
    private final int zzdrp;

    @SafeParcelable.Field(id = 44)
    private final Bundle zzdrq;

    @SafeParcelable.Field(id = 45)
    private final String zzdrr;

    @SafeParcelable.Field(id = 46)
    private final zzyu zzdrs;

    @SafeParcelable.Field(id = 47)
    private final boolean zzdrt;

    @SafeParcelable.Field(id = 48)
    private final Bundle zzdru;

    @SafeParcelable.Field(id = 49)
    private final String zzdrv;

    @SafeParcelable.Field(id = 50)
    private final String zzdrw;

    @SafeParcelable.Field(id = 51)
    private final String zzdrx;

    @SafeParcelable.Field(id = 52)
    private final boolean zzdry;

    @SafeParcelable.Field(id = 53)
    private final List<Integer> zzdrz;

    @SafeParcelable.Field(id = 54)
    private final String zzdsa;

    @SafeParcelable.Field(id = 55)
    private final List<String> zzdsb;

    @SafeParcelable.Field(id = 56)
    private final int zzdsc;

    @SafeParcelable.Field(id = 57)
    private final boolean zzdsd;

    @SafeParcelable.Field(id = 58)
    private final boolean zzdse;

    @SafeParcelable.Field(id = 59)
    private final boolean zzdsf;

    @SafeParcelable.Field(id = 60)
    private final ArrayList<String> zzdsg;

    @SafeParcelable.Field(id = 61)
    private final String zzdsh;

    @SafeParcelable.Field(id = 63)
    private final zzajc zzdsi;

    @SafeParcelable.Field(id = 64)
    private final String zzdsj;

    @SafeParcelable.Field(id = 65)
    private final Bundle zzdsk;

    @SafeParcelable.Constructor
    zzasn(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Bundle bundle, @SafeParcelable.Param(id = 3) zzvg zzvgVar, @SafeParcelable.Param(id = 4) zzvn zzvnVar, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 7) PackageInfo packageInfo, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) String str4, @SafeParcelable.Param(id = 11) zzbbx zzbbxVar, @SafeParcelable.Param(id = 12) Bundle bundle2, @SafeParcelable.Param(id = 13) int i2, @SafeParcelable.Param(id = 14) List<String> list, @SafeParcelable.Param(id = 15) Bundle bundle3, @SafeParcelable.Param(id = 16) boolean z, @SafeParcelable.Param(id = 18) int i3, @SafeParcelable.Param(id = 19) int i4, @SafeParcelable.Param(id = 20) float f2, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 25) long j, @SafeParcelable.Param(id = 26) String str6, @SafeParcelable.Param(id = 27) List<String> list2, @SafeParcelable.Param(id = 28) String str7, @SafeParcelable.Param(id = 29) zzadu zzaduVar, @SafeParcelable.Param(id = 30) List<String> list3, @SafeParcelable.Param(id = 31) long j2, @SafeParcelable.Param(id = 33) String str8, @SafeParcelable.Param(id = 34) float f3, @SafeParcelable.Param(id = 40) boolean z2, @SafeParcelable.Param(id = 35) int i5, @SafeParcelable.Param(id = 36) int i6, @SafeParcelable.Param(id = 37) boolean z3, @SafeParcelable.Param(id = 38) boolean z4, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 41) String str10, @SafeParcelable.Param(id = 42) boolean z5, @SafeParcelable.Param(id = 43) int i7, @SafeParcelable.Param(id = 44) Bundle bundle4, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) zzyu zzyuVar, @SafeParcelable.Param(id = 47) boolean z6, @SafeParcelable.Param(id = 48) Bundle bundle5, @SafeParcelable.Param(id = 49) String str12, @SafeParcelable.Param(id = 50) String str13, @SafeParcelable.Param(id = 51) String str14, @SafeParcelable.Param(id = 52) boolean z7, @SafeParcelable.Param(id = 53) List<Integer> list4, @SafeParcelable.Param(id = 54) String str15, @SafeParcelable.Param(id = 55) List<String> list5, @SafeParcelable.Param(id = 56) int i8, @SafeParcelable.Param(id = 57) boolean z8, @SafeParcelable.Param(id = 58) boolean z9, @SafeParcelable.Param(id = 59) boolean z10, @SafeParcelable.Param(id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(id = 61) String str16, @SafeParcelable.Param(id = 63) zzajc zzajcVar, @SafeParcelable.Param(id = 64) String str17, @SafeParcelable.Param(id = 65) Bundle bundle6) {
        this.versionCode = i;
        this.zzdqq = bundle;
        this.zzdqr = zzvgVar;
        this.zzbpf = zzvnVar;
        this.zzbuu = str;
        this.applicationInfo = applicationInfo;
        this.zzdqs = packageInfo;
        this.zzdqt = str2;
        this.zzdqu = str3;
        this.zzcja = str4;
        this.zzbpe = zzbbxVar;
        this.zzdqv = bundle2;
        this.zzdqw = i2;
        this.zzdlz = list;
        this.zzdre = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzdqx = bundle3;
        this.zzdqy = z;
        this.zzdoc = i3;
        this.zzdod = i4;
        this.zzbsa = f2;
        this.zzdqz = str5;
        this.zzdra = j;
        this.zzdrb = str6;
        this.zzdrc = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzdrd = str7;
        this.zzdly = zzaduVar;
        this.zzdrf = j2;
        this.zzdrg = str8;
        this.zzdrh = f3;
        this.zzdrn = z2;
        this.zzdri = i5;
        this.zzdrj = i6;
        this.zzdrk = z3;
        this.zzdrl = z4;
        this.zzdrm = str9;
        this.zzdro = str10;
        this.zzdko = z5;
        this.zzdrp = i7;
        this.zzdrq = bundle4;
        this.zzdrr = str11;
        this.zzdrs = zzyuVar;
        this.zzdrt = z6;
        this.zzdru = bundle5;
        this.zzdrv = str12;
        this.zzdrw = str13;
        this.zzdrx = str14;
        this.zzdry = z7;
        this.zzdrz = list4;
        this.zzdsa = str15;
        this.zzdsb = list5;
        this.zzdsc = i8;
        this.zzdsd = z8;
        this.zzdse = z9;
        this.zzdsf = z10;
        this.zzdsg = arrayList;
        this.zzdsh = str16;
        this.zzdsi = zzajcVar;
        this.zzdsj = str17;
        this.zzdsk = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdqq, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdqr, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbpf, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbuu, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.applicationInfo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdqs, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdqt, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzdqu, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzcja, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzbpe, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzdqv, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdqw);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzdlz, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzdqx, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzdqy);
        SafeParcelWriter.writeInt(parcel, 18, this.zzdoc);
        SafeParcelWriter.writeInt(parcel, 19, this.zzdod);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzbsa);
        SafeParcelWriter.writeString(parcel, 21, this.zzdqz, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzdra);
        SafeParcelWriter.writeString(parcel, 26, this.zzdrb, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzdrc, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzdrd, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzdly, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzdre, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzdrf);
        SafeParcelWriter.writeString(parcel, 33, this.zzdrg, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzdrh);
        SafeParcelWriter.writeInt(parcel, 35, this.zzdri);
        SafeParcelWriter.writeInt(parcel, 36, this.zzdrj);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzdrk);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdrl);
        SafeParcelWriter.writeString(parcel, 39, this.zzdrm, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzdrn);
        SafeParcelWriter.writeString(parcel, 41, this.zzdro, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdko);
        SafeParcelWriter.writeInt(parcel, 43, this.zzdrp);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzdrq, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdrr, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzdrs, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdrt);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdru, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzdrv, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzdrw, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzdrx, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzdry);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzdrz, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzdsa, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzdsb, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzdsc);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdsd);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzdse);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzdsf);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzdsg, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzdsh, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzdsi, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzdsj, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzdsk, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AdResponseParcelCreator")
public final class zzasp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasp> CREATOR = new zzaso();

    @SafeParcelable.Field(id = 5)
    private final int errorCode;

    @SafeParcelable.Field(id = 12)
    private final int orientation;

    @SafeParcelable.Field(id = 1)
    private final int versionCode;

    @SafeParcelable.Field(id = 37)
    private final zzasr zzboh;

    @SafeParcelable.Field(id = 49)
    private final boolean zzbpc;

    @SafeParcelable.Field(id = 53)
    private final boolean zzbpd;

    @SafeParcelable.Field(id = 23)
    private final boolean zzbrg;

    @SafeParcelable.Field(id = 31)
    private final boolean zzchv;

    @SafeParcelable.Field(id = 32)
    private final boolean zzchw;

    @SafeParcelable.Field(id = 4)
    private final List<String> zzdkj;

    @SafeParcelable.Field(id = 6)
    private final List<String> zzdkk;

    @SafeParcelable.Field(id = 52)
    private final List<String> zzdkl;

    @SafeParcelable.Field(id = 40)
    private final List<String> zzdkn;

    @SafeParcelable.Field(id = 42)
    private final boolean zzdko;

    @SafeParcelable.Field(id = 11)
    private final long zzdkq;

    @SafeParcelable.Field(id = 2)
    private final String zzdpn;

    @SafeParcelable.Field(id = 24)
    private final boolean zzdqy;

    @SafeParcelable.Field(id = 38)
    private final boolean zzdrl;

    @SafeParcelable.Field(id = 39)
    private String zzdrm;

    @SafeParcelable.Field(id = 47)
    private final boolean zzdry;

    @SafeParcelable.Field(id = 3)
    private String zzdsl;

    @SafeParcelable.Field(id = 7)
    private final long zzdsm;

    @SafeParcelable.Field(id = 8)
    private final boolean zzdsn;

    @SafeParcelable.Field(id = 9)
    private final long zzdso;

    @SafeParcelable.Field(id = 10)
    private final List<String> zzdsp;

    @SafeParcelable.Field(id = 13)
    private final String zzdsq;

    @SafeParcelable.Field(id = 14)
    private final long zzdsr;

    @SafeParcelable.Field(id = 15)
    private final String zzdss;

    @SafeParcelable.Field(id = 18)
    private final boolean zzdst;

    @SafeParcelable.Field(id = 19)
    private final String zzdsu;

    @SafeParcelable.Field(id = 21)
    private final String zzdsv;

    @SafeParcelable.Field(id = 22)
    private final boolean zzdsw;

    @SafeParcelable.Field(id = 25)
    private final boolean zzdsx;

    @SafeParcelable.Field(id = 26)
    private final boolean zzdsy;

    @SafeParcelable.Field(id = 28)
    private zzatb zzdsz;

    @SafeParcelable.Field(id = 29)
    private String zzdta;

    @SafeParcelable.Field(id = 30)
    private final String zzdtb;

    @SafeParcelable.Field(id = 33)
    private final zzauv zzdtc;

    @SafeParcelable.Field(id = 34)
    private final List<String> zzdtd;

    @SafeParcelable.Field(id = 35)
    private final List<String> zzdte;

    @SafeParcelable.Field(id = 36)
    private final boolean zzdtf;

    @SafeParcelable.Field(id = 43)
    private final String zzdtg;

    @SafeParcelable.Field(id = 44)
    private final zzawg zzdth;

    @SafeParcelable.Field(id = 45)
    private final String zzdti;

    @SafeParcelable.Field(id = 46)
    private final boolean zzdtj;

    @SafeParcelable.Field(id = 48)
    private Bundle zzdtk;

    @SafeParcelable.Field(id = 50)
    private final int zzdtl;

    @SafeParcelable.Field(id = 51)
    private final boolean zzdtm;

    @SafeParcelable.Field(id = 54)
    private final String zzdtn;

    @SafeParcelable.Field(id = 55)
    private String zzdto;

    @SafeParcelable.Field(id = 56)
    private boolean zzdtp;

    @SafeParcelable.Field(id = 57)
    private boolean zzdtq;

    @SafeParcelable.Constructor
    zzasp(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List<String> list, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) List<String> list2, @SafeParcelable.Param(id = 7) long j, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2, @SafeParcelable.Param(id = 10) List<String> list3, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) int i3, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) long j4, @SafeParcelable.Param(id = 15) String str4, @SafeParcelable.Param(id = 18) boolean z2, @SafeParcelable.Param(id = 19) String str5, @SafeParcelable.Param(id = 21) String str6, @SafeParcelable.Param(id = 22) boolean z3, @SafeParcelable.Param(id = 23) boolean z4, @SafeParcelable.Param(id = 24) boolean z5, @SafeParcelable.Param(id = 25) boolean z6, @SafeParcelable.Param(id = 26) boolean z7, @SafeParcelable.Param(id = 28) zzatb zzatbVar, @SafeParcelable.Param(id = 29) String str7, @SafeParcelable.Param(id = 30) String str8, @SafeParcelable.Param(id = 31) boolean z8, @SafeParcelable.Param(id = 32) boolean z9, @SafeParcelable.Param(id = 33) zzauv zzauvVar, @SafeParcelable.Param(id = 34) List<String> list4, @SafeParcelable.Param(id = 35) List<String> list5, @SafeParcelable.Param(id = 36) boolean z10, @SafeParcelable.Param(id = 37) zzasr zzasrVar, @SafeParcelable.Param(id = 38) boolean z11, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 40) List<String> list6, @SafeParcelable.Param(id = 42) boolean z12, @SafeParcelable.Param(id = 43) String str10, @SafeParcelable.Param(id = 44) zzawg zzawgVar, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) boolean z13, @SafeParcelable.Param(id = 47) boolean z14, @SafeParcelable.Param(id = 48) Bundle bundle, @SafeParcelable.Param(id = 49) boolean z15, @SafeParcelable.Param(id = 50) int i4, @SafeParcelable.Param(id = 51) boolean z16, @SafeParcelable.Param(id = 52) List<String> list7, @SafeParcelable.Param(id = 53) boolean z17, @SafeParcelable.Param(id = 54) String str12, @SafeParcelable.Param(id = 55) String str13, @SafeParcelable.Param(id = 56) boolean z18, @SafeParcelable.Param(id = 57) boolean z19) {
        zzatb zzatbVar2;
        zzate zzateVar;
        this.versionCode = i;
        this.zzdpn = str;
        this.zzdsl = str2;
        this.zzdkj = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzdkk = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzdsm = j;
        this.zzdsn = z;
        this.zzdso = j2;
        this.zzdsp = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzdkq = j3;
        this.orientation = i3;
        this.zzdsq = str3;
        this.zzdsr = j4;
        this.zzdss = str4;
        this.zzdst = z2;
        this.zzdsu = str5;
        this.zzdsv = str6;
        this.zzdsw = z3;
        this.zzbrg = z4;
        this.zzdqy = z5;
        this.zzdsx = z6;
        this.zzdtj = z13;
        this.zzdsy = z7;
        this.zzdsz = zzatbVar;
        this.zzdta = str7;
        this.zzdtb = str8;
        if (this.zzdsl == null && (zzatbVar2 = this.zzdsz) != null && (zzateVar = (zzate) zzatbVar2.zza(zzate.CREATOR)) != null && !TextUtils.isEmpty(zzateVar.zzdud)) {
            this.zzdsl = zzateVar.zzdud;
        }
        this.zzchv = z8;
        this.zzchw = z9;
        this.zzdtc = zzauvVar;
        this.zzdtd = list4;
        this.zzdte = list5;
        this.zzdtf = z10;
        this.zzboh = zzasrVar;
        this.zzdrl = z11;
        this.zzdrm = str9;
        this.zzdkn = list6;
        this.zzdko = z12;
        this.zzdtg = str10;
        this.zzdth = zzawgVar;
        this.zzdti = str11;
        this.zzdry = z14;
        this.zzdtk = bundle;
        this.zzbpc = z15;
        this.zzdtl = i4;
        this.zzdtm = z16;
        this.zzdkl = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.zzbpd = z17;
        this.zzdtn = str12;
        this.zzdto = str13;
        this.zzdtp = z18;
        this.zzdtq = z19;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzdpn, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdsl, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzdkj, false);
        SafeParcelWriter.writeInt(parcel, 5, this.errorCode);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdkk, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzdsm);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdsn);
        SafeParcelWriter.writeLong(parcel, 9, this.zzdso);
        SafeParcelWriter.writeStringList(parcel, 10, this.zzdsp, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzdkq);
        SafeParcelWriter.writeInt(parcel, 12, this.orientation);
        SafeParcelWriter.writeString(parcel, 13, this.zzdsq, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzdsr);
        SafeParcelWriter.writeString(parcel, 15, this.zzdss, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzdst);
        SafeParcelWriter.writeString(parcel, 19, this.zzdsu, false);
        SafeParcelWriter.writeString(parcel, 21, this.zzdsv, false);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzdsw);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzbrg);
        SafeParcelWriter.writeBoolean(parcel, 24, this.zzdqy);
        SafeParcelWriter.writeBoolean(parcel, 25, this.zzdsx);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzdsy);
        SafeParcelWriter.writeParcelable(parcel, 28, this.zzdsz, i, false);
        SafeParcelWriter.writeString(parcel, 29, this.zzdta, false);
        SafeParcelWriter.writeString(parcel, 30, this.zzdtb, false);
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzchv);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzchw);
        SafeParcelWriter.writeParcelable(parcel, 33, this.zzdtc, i, false);
        SafeParcelWriter.writeStringList(parcel, 34, this.zzdtd, false);
        SafeParcelWriter.writeStringList(parcel, 35, this.zzdte, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzdtf);
        SafeParcelWriter.writeParcelable(parcel, 37, this.zzboh, i, false);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdrl);
        SafeParcelWriter.writeString(parcel, 39, this.zzdrm, false);
        SafeParcelWriter.writeStringList(parcel, 40, this.zzdkn, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdko);
        SafeParcelWriter.writeString(parcel, 43, this.zzdtg, false);
        SafeParcelWriter.writeParcelable(parcel, 44, this.zzdth, i, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdti, false);
        SafeParcelWriter.writeBoolean(parcel, 46, this.zzdtj);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdry);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdtk, false);
        SafeParcelWriter.writeBoolean(parcel, 49, this.zzbpc);
        SafeParcelWriter.writeInt(parcel, 50, this.zzdtl);
        SafeParcelWriter.writeBoolean(parcel, 51, this.zzdtm);
        SafeParcelWriter.writeStringList(parcel, 52, this.zzdkl, false);
        SafeParcelWriter.writeBoolean(parcel, 53, this.zzbpd);
        SafeParcelWriter.writeString(parcel, 54, this.zzdtn, false);
        SafeParcelWriter.writeString(parcel, 55, this.zzdto, false);
        SafeParcelWriter.writeBoolean(parcel, 56, this.zzdtp);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdtq);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AdRequestParcelCreator")
public final class zzvg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvg> CREATOR = new zzvi();

    @SafeParcelable.Field(id = 3)
    public final Bundle extras;

    @SafeParcelable.Field(id = 1)
    public final int versionCode;

    @SafeParcelable.Field(id = 7)
    public final int zzadm;

    @SafeParcelable.Field(id = 20)
    public final int zzadn;

    @SafeParcelable.Field(id = 21)
    public final String zzado;

    @SafeParcelable.Field(id = 8)
    public final boolean zzbny;

    @SafeParcelable.Field(id = 2)
    @Deprecated
    public final long zzchb;

    @SafeParcelable.Field(id = 4)
    @Deprecated
    public final int zzchc;

    @SafeParcelable.Field(id = 5)
    public final List<String> zzchd;

    @SafeParcelable.Field(id = 6)
    public final boolean zzche;

    @SafeParcelable.Field(id = 9)
    public final String zzchf;

    @SafeParcelable.Field(id = 10)
    public final zzaag zzchg;

    @SafeParcelable.Field(id = 12)
    public final String zzchh;

    @SafeParcelable.Field(id = 13)
    public final Bundle zzchi;

    @SafeParcelable.Field(id = 14)
    public final Bundle zzchj;

    @SafeParcelable.Field(id = 15)
    public final List<String> zzchk;

    @SafeParcelable.Field(id = 16)
    public final String zzchl;

    @SafeParcelable.Field(id = 17)
    public final String zzchm;

    @SafeParcelable.Field(id = 18)
    @Deprecated
    public final boolean zzchn;

    @SafeParcelable.Field(id = 19)
    public final zzuy zzcho;

    @SafeParcelable.Field(id = 22)
    public final List<String> zzchp;

    @SafeParcelable.Field(id = 11)
    public final Location zznb;

    @SafeParcelable.Constructor
    public zzvg(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) int i3, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) String str, @SafeParcelable.Param(id = 10) zzaag zzaagVar, @SafeParcelable.Param(id = 11) Location location, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 13) Bundle bundle2, @SafeParcelable.Param(id = 14) Bundle bundle3, @SafeParcelable.Param(id = 15) List<String> list2, @SafeParcelable.Param(id = 16) String str3, @SafeParcelable.Param(id = 17) String str4, @SafeParcelable.Param(id = 18) boolean z3, @SafeParcelable.Param(id = 19) zzuy zzuyVar, @SafeParcelable.Param(id = 20) int i4, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 22) List<String> list3) {
        this.versionCode = i;
        this.zzchb = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzchc = i2;
        this.zzchd = list;
        this.zzche = z;
        this.zzadm = i3;
        this.zzbny = z2;
        this.zzchf = str;
        this.zzchg = zzaagVar;
        this.zznb = location;
        this.zzchh = str2;
        this.zzchi = bundle2 == null ? new Bundle() : bundle2;
        this.zzchj = bundle3;
        this.zzchk = list2;
        this.zzchl = str3;
        this.zzchm = str4;
        this.zzchn = z3;
        this.zzcho = zzuyVar;
        this.zzadn = i4;
        this.zzado = str5;
        this.zzchp = list3 == null ? new ArrayList<>() : list3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzvg)) {
            return false;
        }
        zzvg zzvgVar = (zzvg) obj;
        return this.versionCode == zzvgVar.versionCode && this.zzchb == zzvgVar.zzchb && Objects.equal(this.extras, zzvgVar.extras) && this.zzchc == zzvgVar.zzchc && Objects.equal(this.zzchd, zzvgVar.zzchd) && this.zzche == zzvgVar.zzche && this.zzadm == zzvgVar.zzadm && this.zzbny == zzvgVar.zzbny && Objects.equal(this.zzchf, zzvgVar.zzchf) && Objects.equal(this.zzchg, zzvgVar.zzchg) && Objects.equal(this.zznb, zzvgVar.zznb) && Objects.equal(this.zzchh, zzvgVar.zzchh) && Objects.equal(this.zzchi, zzvgVar.zzchi) && Objects.equal(this.zzchj, zzvgVar.zzchj) && Objects.equal(this.zzchk, zzvgVar.zzchk) && Objects.equal(this.zzchl, zzvgVar.zzchl) && Objects.equal(this.zzchm, zzvgVar.zzchm) && this.zzchn == zzvgVar.zzchn && this.zzadn == zzvgVar.zzadn && Objects.equal(this.zzado, zzvgVar.zzado) && Objects.equal(this.zzchp, zzvgVar.zzchp);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzchb), this.extras, Integer.valueOf(this.zzchc), this.zzchd, Boolean.valueOf(this.zzche), Integer.valueOf(this.zzadm), Boolean.valueOf(this.zzbny), this.zzchf, this.zzchg, this.zznb, this.zzchh, this.zzchi, this.zzchj, this.zzchk, this.zzchl, this.zzchm, Boolean.valueOf(this.zzchn), Integer.valueOf(this.zzadn), this.zzado, this.zzchp);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzchb);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzchc);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzchd, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzche);
        SafeParcelWriter.writeInt(parcel, 7, this.zzadm);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbny);
        SafeParcelWriter.writeString(parcel, 9, this.zzchf, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzchg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zznb, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzchh, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzchi, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzchj, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzchk, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzchl, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzchm, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzchn);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzcho, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzadn);
        SafeParcelWriter.writeString(parcel, 21, this.zzado, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzchp, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

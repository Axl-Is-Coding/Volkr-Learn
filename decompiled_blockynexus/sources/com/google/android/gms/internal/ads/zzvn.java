package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzvn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvn> CREATOR = new zzvm();

    @SafeParcelable.Field(id = 3)
    public final int height;

    @SafeParcelable.Field(id = 4)
    public final int heightPixels;

    @SafeParcelable.Field(id = 6)
    public final int width;

    @SafeParcelable.Field(id = 7)
    public final int widthPixels;

    @SafeParcelable.Field(id = 2)
    public final String zzacy;

    @SafeParcelable.Field(id = 9)
    public final boolean zzbrg;

    @SafeParcelable.Field(id = 5)
    public final boolean zzcht;

    @SafeParcelable.Field(id = 8)
    public final zzvn[] zzchu;

    @SafeParcelable.Field(id = 10)
    public final boolean zzchv;

    @SafeParcelable.Field(id = 11)
    public boolean zzchw;

    @SafeParcelable.Field(id = 12)
    public boolean zzchx;

    @SafeParcelable.Field(id = 13)
    private boolean zzchy;

    @SafeParcelable.Field(id = 14)
    public boolean zzchz;

    @SafeParcelable.Field(id = 15)
    public boolean zzcia;

    public zzvn() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (zzd(displayMetrics) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzvn zzpk() {
        return new zzvn("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false);
    }

    public static zzvn zzpl() {
        return new zzvn("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public static zzvn zzpm() {
        return new zzvn("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false);
    }

    public static zzvn zzpn() {
        return new zzvn("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzacy, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzcht);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzchu, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbrg);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzchv);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzchw);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzchx);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzchy);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzchz);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzcia);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final AdSize zzpo() {
        return com.google.android.gms.ads.zzb.zza(this.width, this.height, this.zzacy);
    }

    public zzvn(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzvn(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    zzvn(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) int i3, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) zzvn[] zzvnVarArr, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) boolean z3, @SafeParcelable.Param(id = 11) boolean z4, @SafeParcelable.Param(id = 12) boolean z5, @SafeParcelable.Param(id = 13) boolean z6, @SafeParcelable.Param(id = 14) boolean z7, @SafeParcelable.Param(id = 15) boolean z8) {
        this.zzacy = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzcht = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzchu = zzvnVarArr;
        this.zzbrg = z2;
        this.zzchv = z3;
        this.zzchw = z4;
        this.zzchx = z5;
        this.zzchy = z6;
        this.zzchz = z7;
        this.zzcia = z8;
    }
}

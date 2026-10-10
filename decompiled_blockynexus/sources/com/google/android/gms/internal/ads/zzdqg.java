package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "PoolConfigurationCreator")
public final class zzdqg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdqg> CREATOR = new zzdqh();
    private final zzdqf[] zzhht;
    private final int[] zzhhu;
    private final int[] zzhhv;

    @SafeParcelable.Field(getter = "getFormatInt", id = 1)
    private final int zzhhw;
    public final zzdqf zzhhx;

    @SafeParcelable.Field(id = 2)
    public final int zzhhy;

    @SafeParcelable.Field(id = 3)
    public final int zzhhz;

    @SafeParcelable.Field(id = 4)
    public final int zzhia;

    @SafeParcelable.Field(id = 5)
    public final String zzhib;

    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", id = 6)
    private final int zzhic;
    public final int zzhid;

    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", id = 7)
    private final int zzhie;
    private final int zzhif;
    public final Context zzvr;

    private zzdqg(Context context, zzdqf zzdqfVar, int i, int i2, int i3, String str, String str2, String str3) {
        this.zzhht = zzdqf.values();
        this.zzhhu = zzdqi.zzauo();
        this.zzhhv = zzdqi.zzaup();
        this.zzvr = context;
        this.zzhhw = zzdqfVar.ordinal();
        this.zzhhx = zzdqfVar;
        this.zzhhy = i;
        this.zzhhz = i2;
        this.zzhia = i3;
        this.zzhib = str;
        this.zzhid = "oldest".equals(str2) ? zzdqi.zzhig : ("lru".equals(str2) || !"lfu".equals(str2)) ? zzdqi.zzhih : zzdqi.zzhii;
        this.zzhic = this.zzhid - 1;
        "onAdClosed".equals(str3);
        this.zzhif = zzdqi.zzhik;
        this.zzhie = this.zzhif - 1;
    }

    public static zzdqg zza(zzdqf zzdqfVar, Context context) {
        if (zzdqfVar == zzdqf.Rewarded) {
            return new zzdqg(context, zzdqfVar, ((Integer) zzwm.zzpx().zzd(zzabb.zzcwr)).intValue(), ((Integer) zzwm.zzpx().zzd(zzabb.zzcwx)).intValue(), ((Integer) zzwm.zzpx().zzd(zzabb.zzcwz)).intValue(), (String) zzwm.zzpx().zzd(zzabb.zzcxb), (String) zzwm.zzpx().zzd(zzabb.zzcwt), (String) zzwm.zzpx().zzd(zzabb.zzcwv));
        }
        if (zzdqfVar == zzdqf.Interstitial) {
            return new zzdqg(context, zzdqfVar, ((Integer) zzwm.zzpx().zzd(zzabb.zzcws)).intValue(), ((Integer) zzwm.zzpx().zzd(zzabb.zzcwy)).intValue(), ((Integer) zzwm.zzpx().zzd(zzabb.zzcxa)).intValue(), (String) zzwm.zzpx().zzd(zzabb.zzcxc), (String) zzwm.zzpx().zzd(zzabb.zzcwu), (String) zzwm.zzpx().zzd(zzabb.zzcww));
        }
        if (zzdqfVar != zzdqf.AppOpen) {
            return null;
        }
        return new zzdqg(context, zzdqfVar, ((Integer) zzwm.zzpx().zzd(zzabb.zzcxf)).intValue(), ((Integer) zzwm.zzpx().zzd(zzabb.zzcxh)).intValue(), ((Integer) zzwm.zzpx().zzd(zzabb.zzcxi)).intValue(), (String) zzwm.zzpx().zzd(zzabb.zzcxd), (String) zzwm.zzpx().zzd(zzabb.zzcxe), (String) zzwm.zzpx().zzd(zzabb.zzcxg));
    }

    public static boolean zzaun() {
        return ((Boolean) zzwm.zzpx().zzd(zzabb.zzcwq)).booleanValue();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzhhw);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhhy);
        SafeParcelWriter.writeInt(parcel, 3, this.zzhhz);
        SafeParcelWriter.writeInt(parcel, 4, this.zzhia);
        SafeParcelWriter.writeString(parcel, 5, this.zzhib, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzhic);
        SafeParcelWriter.writeInt(parcel, 7, this.zzhie);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzdqg(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i5, @SafeParcelable.Param(id = 7) int i6) {
        this.zzhht = zzdqf.values();
        this.zzhhu = zzdqi.zzauo();
        this.zzhhv = zzdqi.zzaup();
        this.zzvr = null;
        this.zzhhw = i;
        this.zzhhx = this.zzhht[i];
        this.zzhhy = i2;
        this.zzhhz = i3;
        this.zzhia = i4;
        this.zzhib = str;
        this.zzhic = i5;
        this.zzhid = this.zzhhu[i5];
        this.zzhie = i6;
        this.zzhif = this.zzhhv[i6];
    }
}

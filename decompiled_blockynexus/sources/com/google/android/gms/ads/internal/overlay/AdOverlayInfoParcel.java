package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzagt;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzux;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();

    @SafeParcelable.Field(id = 11)
    public final int orientation;

    @SafeParcelable.Field(id = 13)
    public final String url;

    @SafeParcelable.Field(id = 14)
    public final zzbbx zzbpe;

    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", id = 3, type = "android.os.IBinder")
    public final zzux zzcgv;

    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", id = 18, type = "android.os.IBinder")
    public final zzagt zzdep;

    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", id = 6, type = "android.os.IBinder")
    public final zzagv zzdeq;

    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", id = 5, type = "android.os.IBinder")
    public final zzbgj zzdgy;

    @SafeParcelable.Field(id = 2)
    public final zzb zzdpl;

    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", id = 4, type = "android.os.IBinder")
    public final zzp zzdpm;

    @SafeParcelable.Field(id = 7)
    public final String zzdpn;

    @SafeParcelable.Field(id = 8)
    public final boolean zzdpo;

    @SafeParcelable.Field(id = 9)
    public final String zzdpp;

    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", id = 10, type = "android.os.IBinder")
    public final zzv zzdpq;

    @SafeParcelable.Field(id = 12)
    public final int zzdpr;

    @SafeParcelable.Field(id = 16)
    public final String zzdps;

    @SafeParcelable.Field(id = 17)
    public final com.google.android.gms.ads.internal.zzi zzdpt;

    public AdOverlayInfoParcel(zzux zzuxVar, zzp zzpVar, zzv zzvVar, zzbgj zzbgjVar, int i, zzbbx zzbbxVar, String str, com.google.android.gms.ads.internal.zzi zziVar, String str2, String str3) {
        this.zzdpl = null;
        this.zzcgv = null;
        this.zzdpm = zzpVar;
        this.zzdgy = zzbgjVar;
        this.zzdep = null;
        this.zzdeq = null;
        this.zzdpn = str2;
        this.zzdpo = false;
        this.zzdpp = str3;
        this.zzdpq = null;
        this.orientation = i;
        this.zzdpr = 1;
        this.url = null;
        this.zzbpe = zzbbxVar;
        this.zzdps = str;
        this.zzdpt = zziVar;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzd(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdpl, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzcgv).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzdpm).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzdgy).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zzdeq).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdpn, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdpo);
        SafeParcelWriter.writeString(parcel, 9, this.zzdpp, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzdpq).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.orientation);
        SafeParcelWriter.writeInt(parcel, 12, this.zzdpr);
        SafeParcelWriter.writeString(parcel, 13, this.url, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzbpe, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzdps, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzdpt, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzdep).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public AdOverlayInfoParcel(zzux zzuxVar, zzp zzpVar, zzv zzvVar, zzbgj zzbgjVar, boolean z, int i, zzbbx zzbbxVar) {
        this.zzdpl = null;
        this.zzcgv = zzuxVar;
        this.zzdpm = zzpVar;
        this.zzdgy = zzbgjVar;
        this.zzdep = null;
        this.zzdeq = null;
        this.zzdpn = null;
        this.zzdpo = z;
        this.zzdpp = null;
        this.zzdpq = zzvVar;
        this.orientation = i;
        this.zzdpr = 2;
        this.url = null;
        this.zzbpe = zzbbxVar;
        this.zzdps = null;
        this.zzdpt = null;
    }

    public AdOverlayInfoParcel(zzux zzuxVar, zzp zzpVar, zzagt zzagtVar, zzagv zzagvVar, zzv zzvVar, zzbgj zzbgjVar, boolean z, int i, String str, zzbbx zzbbxVar) {
        this.zzdpl = null;
        this.zzcgv = zzuxVar;
        this.zzdpm = zzpVar;
        this.zzdgy = zzbgjVar;
        this.zzdep = zzagtVar;
        this.zzdeq = zzagvVar;
        this.zzdpn = null;
        this.zzdpo = z;
        this.zzdpp = null;
        this.zzdpq = zzvVar;
        this.orientation = i;
        this.zzdpr = 3;
        this.url = str;
        this.zzbpe = zzbbxVar;
        this.zzdps = null;
        this.zzdpt = null;
    }

    public AdOverlayInfoParcel(zzux zzuxVar, zzp zzpVar, zzagt zzagtVar, zzagv zzagvVar, zzv zzvVar, zzbgj zzbgjVar, boolean z, int i, String str, String str2, zzbbx zzbbxVar) {
        this.zzdpl = null;
        this.zzcgv = zzuxVar;
        this.zzdpm = zzpVar;
        this.zzdgy = zzbgjVar;
        this.zzdep = zzagtVar;
        this.zzdeq = zzagvVar;
        this.zzdpn = str2;
        this.zzdpo = z;
        this.zzdpp = str;
        this.zzdpq = zzvVar;
        this.orientation = i;
        this.zzdpr = 3;
        this.url = null;
        this.zzbpe = zzbbxVar;
        this.zzdps = null;
        this.zzdpt = null;
    }

    public AdOverlayInfoParcel(zzb zzbVar, zzux zzuxVar, zzp zzpVar, zzv zzvVar, zzbbx zzbbxVar) {
        this.zzdpl = zzbVar;
        this.zzcgv = zzuxVar;
        this.zzdpm = zzpVar;
        this.zzdgy = null;
        this.zzdep = null;
        this.zzdeq = null;
        this.zzdpn = null;
        this.zzdpo = false;
        this.zzdpp = null;
        this.zzdpq = zzvVar;
        this.orientation = -1;
        this.zzdpr = 4;
        this.url = null;
        this.zzbpe = zzbbxVar;
        this.zzdps = null;
        this.zzdpt = null;
    }

    @SafeParcelable.Constructor
    AdOverlayInfoParcel(@SafeParcelable.Param(id = 2) zzb zzbVar, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2, @SafeParcelable.Param(id = 5) IBinder iBinder3, @SafeParcelable.Param(id = 6) IBinder iBinder4, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str2, @SafeParcelable.Param(id = 10) IBinder iBinder5, @SafeParcelable.Param(id = 11) int i, @SafeParcelable.Param(id = 12) int i2, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) zzbbx zzbbxVar, @SafeParcelable.Param(id = 16) String str4, @SafeParcelable.Param(id = 17) com.google.android.gms.ads.internal.zzi zziVar, @SafeParcelable.Param(id = 18) IBinder iBinder6) {
        this.zzdpl = zzbVar;
        this.zzcgv = (zzux) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdpm = (zzp) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzdgy = (zzbgj) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzdep = (zzagt) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zzdeq = (zzagv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzdpn = str;
        this.zzdpo = z;
        this.zzdpp = str2;
        this.zzdpq = (zzv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.orientation = i;
        this.zzdpr = i2;
        this.url = str3;
        this.zzbpe = zzbbxVar;
        this.zzdps = str4;
        this.zzdpt = zziVar;
    }
}

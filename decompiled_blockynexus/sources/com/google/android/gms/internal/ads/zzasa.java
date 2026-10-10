package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "NativeAdLayoutInfoParcelCreator")
public final class zzasa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasa> CREATOR = new zzasd();

    @SafeParcelable.Field(getter = "getAdViewAsBinder", id = 1, type = "android.os.IBinder")
    public final View zzaat;

    @SafeParcelable.Field(getter = "getAssetViewMapAsBinder", id = 2, type = "android.os.IBinder")
    public final Map<String, WeakReference<View>> zzdqc;

    @SafeParcelable.Constructor
    public zzasa(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) IBinder iBinder2) {
        this.zzaat = (View) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdqc = (Map) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, ObjectWrapper.wrap(this.zzaat).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, ObjectWrapper.wrap(this.zzdqc).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzsz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsz> CREATOR = new zztc();

    @SafeParcelable.Field(getter = "getContentFileDescriptor", id = 2)
    private ParcelFileDescriptor zzbvd;

    public zzsz() {
        this(null);
    }

    private final synchronized ParcelFileDescriptor zzmy() {
        return this.zzbvd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzmy(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final synchronized boolean zzmw() {
        return this.zzbvd != null;
    }

    public final synchronized InputStream zzmx() {
        if (this.zzbvd == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbvd);
        this.zzbvd = null;
        return autoCloseInputStream;
    }

    @SafeParcelable.Constructor
    public zzsz(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbvd = parcelFileDescriptor;
    }
}

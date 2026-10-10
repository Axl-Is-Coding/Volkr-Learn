package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.umeng.analytics.pro.au;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
@SafeParcelable.Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {

    @SafeParcelable.VersionField(id = 1000)
    private final int zzb;

    @SafeParcelable.Field(getter = "getStatusCode", id = 1)
    private final int zzc;

    @SafeParcelable.Field(getter = "getStatusMessage", id = 2)
    private final String zzd;

    @SafeParcelable.Field(getter = "getPendingIntent", id = 3)
    private final PendingIntent zze;

    @ShowFirstParty
    @VisibleForTesting
    @KeepForSdk
    public static final Status RESULT_SUCCESS = new Status(0);

    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);

    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);

    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);

    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);

    @ShowFirstParty
    private static final Status zza = new Status(17);

    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzb();

    @SafeParcelable.Constructor
    @KeepForSdk
    Status(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
        this.zze = pendingIntent;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzb == status.zzb && this.zzc == status.zzc && Objects.equal(this.zzd, status.zzd) && Objects.equal(this.zze, status.zze);
    }

    public final PendingIntent getResolution() {
        return this.zze;
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.zzc;
    }

    public final String getStatusMessage() {
        return this.zzd;
    }

    @VisibleForTesting
    public final boolean hasResolution() {
        return this.zze != null;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze);
    }

    public final boolean isCanceled() {
        return this.zzc == 16;
    }

    public final boolean isInterrupted() {
        return this.zzc == 14;
    }

    public final boolean isSuccess() {
        return this.zzc <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zze;
            Preconditions.checkNotNull(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("statusCode", zza()).add(au.y, this.zze).toString();
    }

    @Override // android.os.Parcelable
    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zze, i, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        String str = this.zzd;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.zzc);
    }

    @KeepForSdk
    public Status(int i) {
        this(i, null);
    }

    @KeepForSdk
    public Status(int i, String str) {
        this(1, i, str, null);
    }

    @KeepForSdk
    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }
}

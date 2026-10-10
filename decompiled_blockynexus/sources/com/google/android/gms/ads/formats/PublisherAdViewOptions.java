package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzaai;
import com.google.android.gms.internal.ads.zzafx;
import com.google.android.gms.internal.ads.zzafy;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzxk;
import com.google.android.gms.internal.ads.zzxn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();

    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", id = 1)
    private final boolean zzbny;

    @SafeParcelable.Field(getter = "getAppEventListenerBinder", id = 2, type = "android.os.IBinder")
    private final zzxk zzbnz;
    private AppEventListener zzboa;

    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", id = 3)
    private final IBinder zzbob;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static final class Builder {
        private boolean zzbny = false;
        private AppEventListener zzboa;
        private ShouldDelayBannerRenderingListener zzboc;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzboa = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbny = z;
            return this;
        }

        @KeepForSdk
        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzboc = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzbny = builder.zzbny;
        this.zzboa = builder.zzboa;
        AppEventListener appEventListener = this.zzboa;
        this.zzbnz = appEventListener != null ? new zzvt(appEventListener) : null;
        this.zzbob = builder.zzboc != null ? new zzaai(builder.zzboc) : null;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboa;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbny;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzxk zzxkVar = this.zzbnz;
        SafeParcelWriter.writeIBinder(parcel, 2, zzxkVar == null ? null : zzxkVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzbob, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzxk zzjv() {
        return this.zzbnz;
    }

    public final zzafy zzjw() {
        return zzafx.zzy(this.zzbob);
    }

    @SafeParcelable.Constructor
    PublisherAdViewOptions(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) IBinder iBinder2) {
        this.zzbny = z;
        this.zzbnz = iBinder != null ? zzxn.zze(iBinder) : null;
        this.zzbob = iBinder2;
    }
}

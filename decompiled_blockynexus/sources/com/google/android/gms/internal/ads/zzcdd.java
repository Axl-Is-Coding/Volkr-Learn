package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdd implements zzeoy<String> {
    public static zzcdd zzalk() {
        return zzcdg.zzfxr;
    }

    public static String zzall() {
        zzepe.zza(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "Cannot return null from a non-@Nullable @Provides method");
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzall();
    }
}

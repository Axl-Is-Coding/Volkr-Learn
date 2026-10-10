package com.google.firebase.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzc {
    static final /* synthetic */ int[] zza = new int[FirebaseAnalytics.ConsentStatus.values().length];

    static {
        try {
            zza[FirebaseAnalytics.ConsentStatus.GRANTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[FirebaseAnalytics.ConsentStatus.DENIED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

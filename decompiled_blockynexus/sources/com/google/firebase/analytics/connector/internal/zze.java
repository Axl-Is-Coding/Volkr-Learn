package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zze implements zza {
    private AnalyticsConnector.AnalyticsConnectorListener zza;
    private AppMeasurementSdk zzb;
    private zzg zzc = new zzg(this);

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = appMeasurementSdk;
        this.zzb.registerOnMeasurementEventListener(this.zzc);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zza(Set<String> set) {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb() {
    }
}

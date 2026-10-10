package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamu extends zzbit {
    private final AppMeasurementSdk zzdji;

    zzamu(AppMeasurementSdk appMeasurementSdk) {
        this.zzdji = appMeasurementSdk;
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final void beginAdUnitExposure(String str) throws RemoteException {
        this.zzdji.beginAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdji.clearConditionalUserProperty(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final void endAdUnitExposure(String str) throws RemoteException {
        this.zzdji.endAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final long generateEventId() throws RemoteException {
        return this.zzdji.generateEventId();
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final String getAppIdOrigin() throws RemoteException {
        return this.zzdji.getAppIdOrigin();
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final String getAppInstanceId() throws RemoteException {
        return this.zzdji.getAppInstanceId();
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final List getConditionalUserProperties(String str, String str2) throws RemoteException {
        return this.zzdji.getConditionalUserProperties(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final String getCurrentScreenClass() throws RemoteException {
        return this.zzdji.getCurrentScreenClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final String getCurrentScreenName() throws RemoteException {
        return this.zzdji.getCurrentScreenName();
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final String getGmpAppId() throws RemoteException {
        return this.zzdji.getGmpAppId();
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final int getMaxUserProperties(String str) throws RemoteException {
        return this.zzdji.getMaxUserProperties(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final Map getUserProperties(String str, String str2, boolean z) throws RemoteException {
        return this.zzdji.getUserProperties(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final void logEvent(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdji.logEvent(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final void performAction(Bundle bundle) throws RemoteException {
        this.zzdji.performAction(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final Bundle performActionWithResponse(Bundle bundle) throws RemoteException {
        return this.zzdji.performActionWithResponse(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final void setConditionalUserProperty(Bundle bundle) throws RemoteException {
        this.zzdji.setConditionalUserProperty(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzdji.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzbiq
    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.zzdji.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }
}

package com.google.android.gms.measurement.internal;

import a.a.b;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzml;
import com.umeng.analytics.pro.ay;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzu {

    @VisibleForTesting
    zzfu zza = null;
    private final Map<Integer, zzgz> zzb = new b();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
    class zza implements zzgw {
        private com.google.android.gms.internal.measurement.zzab zza;

        zza(com.google.android.gms.internal.measurement.zzab zzabVar) {
            this.zza = zzabVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzgw
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.zza.zzq().zzh().zza("Event interceptor threw exception", e2);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
    class zzb implements zzgz {
        private com.google.android.gms.internal.measurement.zzab zza;

        zzb(com.google.android.gms.internal.measurement.zzab zzabVar) {
            this.zza = zzabVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzgz
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.zza.zzq().zzh().zza("Event listener threw exception", e2);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzy().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzg().zzc(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void clearMeasurementEnabled(long j) throws RemoteException {
        zza();
        this.zza.zzg().zza((Boolean) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzy().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void generateEventId(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        this.zza.zzh().zza(zzwVar, this.zza.zzh().zzf());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        this.zza.zzp().zza(new zzh(this, zzwVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        zza(zzwVar, this.zza.zzg().zzag());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        this.zza.zzp().zza(new zzk(this, zzwVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        zza(zzwVar, this.zza.zzg().zzaj());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        zza(zzwVar, this.zza.zzg().zzai());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        zza(zzwVar, this.zza.zzg().zzak());
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        this.zza.zzg();
        Preconditions.checkNotEmpty(str);
        this.zza.zzh().zza(zzwVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getTestFlag(com.google.android.gms.internal.measurement.zzw zzwVar, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzh().zza(zzwVar, this.zza.zzg().zzac());
            return;
        }
        if (i == 1) {
            this.zza.zzh().zza(zzwVar, this.zza.zzg().zzad().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.zza.zzh().zza(zzwVar, this.zza.zzg().zzae().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.zza.zzh().zza(zzwVar, this.zza.zzg().zzab().booleanValue());
                return;
            }
        }
        zzkv zzkvVarZzh = this.zza.zzh();
        double dDoubleValue = this.zza.zzg().zzaf().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzwVar.zza(bundle);
        } catch (RemoteException e2) {
            zzkvVarZzh.zzy.zzq().zzh().zza("Error returning double value to wrapper", e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        this.zza.zzp().zza(new zzi(this, zzwVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzae zzaeVar, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfu zzfuVar = this.zza;
        if (zzfuVar == null) {
            this.zza = zzfu.zza(context, zzaeVar, Long.valueOf(j));
        } else {
            zzfuVar.zzq().zzh().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzw zzwVar) throws RemoteException {
        zza();
        this.zza.zzp().zza(new zzm(this, zzwVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzg().zza(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzw zzwVar, long j) throws RemoteException {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzp().zza(new zzj(this, zzwVar, new zzaq(str2, new zzap(bundle), "app", j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        this.zza.zzq().zza(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzg().zza;
        if (zzhyVar != null) {
            this.zza.zzg().zzaa();
            zzhyVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzg().zza;
        if (zzhyVar != null) {
            this.zza.zzg().zzaa();
            zzhyVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzg().zza;
        if (zzhyVar != null) {
            this.zza.zzg().zzaa();
            zzhyVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzg().zza;
        if (zzhyVar != null) {
            this.zza.zzg().zzaa();
            zzhyVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzw zzwVar, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzg().zza;
        Bundle bundle = new Bundle();
        if (zzhyVar != null) {
            this.zza.zzg().zzaa();
            zzhyVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzwVar.zza(bundle);
        } catch (RemoteException e2) {
            this.zza.zzq().zzh().zza("Error returning bundle value to wrapper", e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzg().zza;
        if (zzhyVar != null) {
            this.zza.zzg().zzaa();
            zzhyVar.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzhy zzhyVar = this.zza.zzg().zza;
        if (zzhyVar != null) {
            this.zza.zzg().zzaa();
            zzhyVar.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzw zzwVar, long j) throws RemoteException {
        zza();
        zzwVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzab zzabVar) throws RemoteException {
        zzgz zzbVar;
        zza();
        synchronized (this.zzb) {
            zzbVar = this.zzb.get(Integer.valueOf(zzabVar.zza()));
            if (zzbVar == null) {
                zzbVar = new zzb(zzabVar);
                this.zzb.put(Integer.valueOf(zzabVar.zza()), zzbVar);
            }
        }
        this.zza.zzg().zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        zzhb zzhbVarZzg = this.zza.zzg();
        zzhbVarZzg.zza((String) null);
        zzhbVarZzg.zzp().zza(new zzhk(zzhbVarZzg, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzq().zze().zza("Conditional user property must not be null");
        } else {
            this.zza.zzg().zza(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setConsent(Bundle bundle, long j) throws RemoteException {
        zza();
        zzhb zzhbVarZzg = this.zza.zzg();
        if (zzml.zzb() && zzhbVarZzg.zzs().zzd(null, zzas.zzcg)) {
            zzhbVarZzg.zza(bundle, 30, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zza();
        zzhb zzhbVarZzg = this.zza.zzg();
        if (zzml.zzb() && zzhbVarZzg.zzs().zzd(null, zzas.zzch)) {
            zzhbVarZzg.zza(bundle, 10, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzu().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        zzhb zzhbVarZzg = this.zza.zzg();
        zzhbVarZzg.zzv();
        zzhbVarZzg.zzp().zza(new zzhf(zzhbVarZzg, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setDefaultEventParameters(Bundle bundle) {
        zza();
        final zzhb zzhbVarZzg = this.zza.zzg();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zzhbVarZzg.zzp().zza(new Runnable(zzhbVarZzg, bundle2) { // from class: com.google.android.gms.measurement.internal.zzha
            private final zzhb zza;
            private final Bundle zzb;

            {
                this.zza = zzhbVarZzg;
                this.zzb = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(this.zzb);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzab zzabVar) throws RemoteException {
        zza();
        zza zzaVar = new zza(zzabVar);
        if (this.zza.zzp().zzf()) {
            this.zza.zzg().zza(zzaVar);
        } else {
            this.zza.zzp().zza(new zzl(this, zzaVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzac zzacVar) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzg().zza(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        zzhb zzhbVarZzg = this.zza.zzg();
        zzhbVarZzg.zzp().zza(new zzhh(zzhbVarZzg, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        zzhb zzhbVarZzg = this.zza.zzg();
        zzhbVarZzg.zzp().zza(new zzhg(zzhbVarZzg, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzg().zza((String) null, ay.f20688d, (Object) str, true, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzg().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzab zzabVar) throws RemoteException {
        zzgz zzgzVarRemove;
        zza();
        synchronized (this.zzb) {
            zzgzVarRemove = this.zzb.remove(Integer.valueOf(zzabVar.zza()));
        }
        if (zzgzVarRemove == null) {
            zzgzVarRemove = new zzb(zzabVar);
        }
        this.zza.zzg().zzb(zzgzVarRemove);
    }

    private final void zza(com.google.android.gms.internal.measurement.zzw zzwVar, String str) {
        this.zza.zzh().zza(zzwVar, str);
    }
}

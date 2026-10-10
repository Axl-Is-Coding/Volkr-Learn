package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.umeng.analytics.pro.au;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfl {
    final zzfu zza;

    zzfl(zzfu zzfuVar) {
        this.zza = zzfuVar;
    }

    protected final void zza(String str) {
        if (str == null || str.isEmpty()) {
            this.zza.zzq().zzi().zza("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.zza.zzp().zzc();
        if (!zza()) {
            this.zza.zzq().zzu().zza("Install Referrer Reporter is not available");
            return;
        }
        zzfk zzfkVar = new zzfk(this, str);
        this.zza.zzp().zzc();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.zza.zzm().getPackageManager();
        if (packageManager == null) {
            this.zza.zzq().zzi().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            this.zza.zzq().zzu().zza("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str2) || !zza()) {
                this.zza.zzq().zzh().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.zza.zzq().zzw().zza("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.zza.zzm(), new Intent(intent), zzfkVar, 1) ? "available" : "not available");
            } catch (Exception e2) {
                this.zza.zzq().zze().zza("Exception occurred while binding to Install Referrer Service", e2.getMessage());
            }
        }
    }

    @VisibleForTesting
    private final boolean zza() {
        try {
            PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(this.zza.zzm());
            if (packageManagerWrapperPackageManager != null) {
                return packageManagerWrapperPackageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.zza.zzq().zzw().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e2) {
            this.zza.zzq().zzw().zza("Failed to retrieve Play Store version for Install Referrer", e2);
            return false;
        }
    }

    @VisibleForTesting
    final Bundle zza(String str, com.google.android.gms.internal.measurement.zzd zzdVar) {
        this.zza.zzp().zzc();
        if (zzdVar == null) {
            this.zza.zzq().zzh().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(au.n, str);
        try {
            Bundle bundleZza = zzdVar.zza(bundle);
            if (bundleZza != null) {
                return bundleZza;
            }
            this.zza.zzq().zze().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e2) {
            this.zza.zzq().zze().zza("Exception occurred while retrieving the Install Referrer", e2.getMessage());
            return null;
        }
    }
}

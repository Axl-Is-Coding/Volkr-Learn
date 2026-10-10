package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzii extends zzg {

    @VisibleForTesting
    protected zzij zza;
    private volatile zzij zzb;
    private zzij zzc;
    private final Map<Activity, zzij> zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzij zzg;
    private zzij zzh;
    private boolean zzi;
    private final Object zzj;
    private zzij zzk;
    private String zzl;

    public zzii(zzfu zzfuVar) {
        super(zzfuVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final zzij zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzij zzijVar = this.zzd.get(activity);
        if (zzijVar == null) {
            zzij zzijVar2 = new zzij(null, zza(activity.getClass().getCanonicalName()), zzo().zzf());
            this.zzd.put(activity, zzijVar2);
            zzijVar = zzijVar2;
        }
        return (zzs().zza(zzas.zzbu) && this.zzg != null) ? this.zzg : zzijVar;
    }

    public final zzij zza(boolean z) {
        zzv();
        zzc();
        if (!zzs().zza(zzas.zzbu) || !z) {
            return this.zza;
        }
        zzij zzijVar = this.zza;
        return zzijVar != null ? zzijVar : this.zzh;
    }

    public final zzij zzaa() {
        return this.zzb;
    }

    public final void zzb(Activity activity) {
        if (zzs().zza(zzas.zzbu)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long jElapsedRealtime = zzl().elapsedRealtime();
        if (zzs().zza(zzas.zzbt) && !zzs().zzh().booleanValue()) {
            this.zzb = null;
            zzp().zza(new zzim(this, jElapsedRealtime));
        } else {
            zzij zzijVarZzd = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzp().zza(new zzip(this, zzijVarZzd, jElapsedRealtime));
        }
    }

    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zzs().zzh().booleanValue()) {
            this.zzd.remove(activity);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzen zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzir zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzii zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzem zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjx zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzy() {
        return false;
    }

    public final void zza(Bundle bundle, long j) {
        String str;
        if (!zzs().zza(zzas.zzbu)) {
            zzq().zzj().zza("Manual screen reporting is disabled.");
            return;
        }
        synchronized (this.zzj) {
            if (!this.zzi) {
                zzq().zzj().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String strZza = null;
            if (bundle != null) {
                String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
                if (string != null && (string.length() <= 0 || string.length() > 100)) {
                    zzq().zzj().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 != null && (string2.length() <= 0 || string2.length() > 100)) {
                    zzq().zzj().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    strZza = string2;
                }
            } else {
                str = null;
            }
            if (strZza == null) {
                strZza = this.zze != null ? zza(this.zze.getClass().getCanonicalName()) : "Activity";
            }
            String str2 = strZza;
            if (this.zzf && this.zzb != null) {
                this.zzf = false;
                boolean zZzc = zzkv.zzc(this.zzb.zzb, str2);
                boolean zZzc2 = zzkv.zzc(this.zzb.zza, str);
                if (zZzc && zZzc2) {
                    zzq().zzj().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzq().zzw().zza("Logging screen view with name, class", str == null ? "null" : str, str2 == null ? "null" : str2);
            zzij zzijVar = this.zzb == null ? this.zzc : this.zzb;
            zzij zzijVar2 = new zzij(str, str2, zzo().zzf(), true, j);
            this.zzb = zzijVar2;
            this.zzc = zzijVar;
            this.zzg = zzijVar2;
            zzp().zza(new zzil(this, bundle, zzijVar2, zzijVar, zzl().elapsedRealtime()));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzij zzijVar;
        if (!zzs().zzh().booleanValue() || bundle == null || (zzijVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzijVar.zzc);
        bundle2.putString("name", zzijVar.zza);
        bundle2.putString("referrer_name", zzijVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Bundle bundle, zzij zzijVar, zzij zzijVar2, long j) {
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zza(zzijVar, zzijVar2, j, true, zzo().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, true, true));
    }

    @Deprecated
    public final void zza(Activity activity, String str, String str2) {
        if (!zzs().zzh().booleanValue()) {
            zzq().zzj().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        if (this.zzb == null) {
            zzq().zzj().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(activity) == null) {
            zzq().zzj().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(activity.getClass().getCanonicalName());
        }
        boolean zZzc = zzkv.zzc(this.zzb.zzb, str2);
        boolean zZzc2 = zzkv.zzc(this.zzb.zza, str);
        if (zZzc && zZzc2) {
            zzq().zzj().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            zzq().zzj().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            zzq().zzj().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzq().zzw().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzij zzijVar = new zzij(str, str2, zzo().zzf());
        this.zzd.put(activity, zzijVar);
        zza(activity, zzijVar, true);
    }

    private final void zza(Activity activity, zzij zzijVar, boolean z) {
        zzij zzijVar2;
        zzij zzijVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzijVar.zzb == null) {
            zzijVar2 = new zzij(zzijVar.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zzijVar.zzc, zzijVar.zze, zzijVar.zzf);
        } else {
            zzijVar2 = zzijVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzijVar2;
        zzp().zza(new zzik(this, zzijVar2, zzijVar3, zzl().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.measurement.internal.zzij r10, com.google.android.gms.measurement.internal.zzij r11, long r12, boolean r14, android.os.Bundle r15) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzii.zza(com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzij, long, boolean, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzij zzijVar, boolean z, long j) {
        zzd().zza(zzl().elapsedRealtime());
        if (!zzj().zza(zzijVar != null && zzijVar.zzd, z, j) || zzijVar == null) {
            return;
        }
        zzijVar.zzd = false;
    }

    public static void zza(zzij zzijVar, Bundle bundle, boolean z) {
        if (bundle == null || zzijVar == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && zzijVar == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = zzijVar.zza;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = zzijVar.zzb;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", zzijVar.zzc);
    }

    public final void zza(String str, zzij zzijVar) {
        zzc();
        synchronized (this) {
            if (this.zzl == null || this.zzl.equals(str) || zzijVar != null) {
                this.zzl = str;
                this.zzk = zzijVar;
            }
        }
    }

    @VisibleForTesting
    private static String zza(String str) {
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zzs().zzh().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzij(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zza(Activity activity) {
        if (zzs().zza(zzas.zzbu)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (zzs().zza(zzas.zzbt) && zzs().zzh().booleanValue()) {
                        this.zzg = null;
                        zzp().zza(new zzio(this));
                    }
                }
            }
        }
        if (zzs().zza(zzas.zzbt) && !zzs().zzh().booleanValue()) {
            this.zzb = this.zzg;
            zzp().zza(new zzin(this));
        } else {
            zza(activity, zzd(activity), false);
            zza zzaVarZzd = zzd();
            zzaVarZzd.zzp().zza(new zze(zzaVarZzd, zzaVarZzd.zzl().elapsedRealtime()));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    static /* synthetic */ zzij zza(zzii zziiVar, zzij zzijVar) {
        zziiVar.zzh = null;
        return null;
    }
}

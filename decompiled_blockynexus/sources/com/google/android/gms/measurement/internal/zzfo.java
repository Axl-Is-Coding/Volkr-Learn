package com.google.android.gms.measurement.internal;

import a.a.b;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfo extends zzki implements zzad {

    @VisibleForTesting
    private static int zzb = 65535;

    @VisibleForTesting
    private static int zzc = 2;
    private final Map<String, Map<String, String>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, Map<String, Boolean>> zzf;
    private final Map<String, zzca.zzb> zzg;
    private final Map<String, Map<String, Integer>> zzh;
    private final Map<String, String> zzi;

    zzfo(zzkl zzklVar) {
        super(zzklVar);
        this.zzd = new b();
        this.zze = new b();
        this.zzf = new b();
        this.zzg = new b();
        this.zzi = new b();
        this.zzh = new b();
    }

    private final void zzi(String str) throws Throwable {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] bArrZzd = zzi().zzd(str);
            if (bArrZzd != null) {
                zzca.zzb.zza zzaVarZzbo = zza(str, bArrZzd).zzbo();
                zza(str, zzaVarZzbo);
                this.zzd.put(str, zza((zzca.zzb) zzaVarZzbo.zzy()));
                this.zzg.put(str, (zzca.zzb) zzaVarZzbo.zzy());
                this.zzi.put(str, null);
                return;
            }
            this.zzd.put(str, null);
            this.zze.put(str, null);
            this.zzf.put(str, null);
            this.zzg.put(str, null);
            this.zzi.put(str, null);
            this.zzh.put(str, null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzkr f_() {
        return super.f_();
    }

    protected final zzca.zzb zza(String str) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    protected final String zzb(String str) {
        zzc();
        return this.zzi.get(str);
    }

    protected final void zzc(String str) {
        zzc();
        this.zzi.put(str, null);
    }

    final void zzd(String str) {
        zzc();
        this.zzg.remove(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzki
    protected final boolean zzd() {
        return false;
    }

    final boolean zze(String str) {
        zzc();
        zzca.zzb zzbVarZza = zza(str);
        if (zzbVarZza == null) {
            return false;
        }
        return zzbVarZza.zzh();
    }

    final long zzf(String str) throws Throwable {
        String strZza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strZza)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZza);
        } catch (NumberFormatException e2) {
            zzq().zzh().zza("Unable to parse timezone offset. appId", zzeq.zza(str), e2);
            return 0L;
        }
    }

    final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzfo zzj() {
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

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzr zzh() {
        return super.zzh();
    }

    final boolean zzb(String str, String str2) throws Throwable {
        Boolean bool;
        zzc();
        zzi(str);
        if (zzg(str) && zzkv.zzd(str2)) {
            return true;
        }
        if (zzh(str) && zzkv.zza(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzc(String str, String str2) throws Throwable {
        Boolean bool;
        zzc();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzf.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final int zzd(String str, String str2) throws Throwable {
        Integer num;
        zzc();
        zzi(str);
        Map<String, Integer> map = this.zzh.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzad
    public final String zza(String str, String str2) throws Throwable {
        zzc();
        zzi(str);
        Map<String, String> map = this.zzd.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzjr zzf() {
        return super.zzf();
    }

    private static Map<String, String> zza(zzca.zzb zzbVar) {
        b bVar = new b();
        if (zzbVar != null) {
            for (zzca.zzc zzcVar : zzbVar.zze()) {
                bVar.put(zzcVar.zza(), zzcVar.zzb());
            }
        }
        return bVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    private final void zza(String str, zzca.zzb.zza zzaVar) {
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        if (zzaVar != null) {
            for (int i = 0; i < zzaVar.zza(); i++) {
                zzca.zza.C0125zza c0125zzaZzbo = zzaVar.zza(i).zzbo();
                if (TextUtils.isEmpty(c0125zzaZzbo.zza())) {
                    zzq().zzh().zza("EventConfig contained null event name");
                } else {
                    String strZza = c0125zzaZzbo.zza();
                    String strZzb = zzgv.zzb(c0125zzaZzbo.zza());
                    if (!TextUtils.isEmpty(strZzb)) {
                        c0125zzaZzbo = c0125zzaZzbo.zza(strZzb);
                        zzaVar.zza(i, c0125zzaZzbo);
                    }
                    if (zzlo.zzb() && zzs().zza(zzas.zzcm)) {
                        bVar.put(strZza, Boolean.valueOf(c0125zzaZzbo.zzb()));
                    } else {
                        bVar.put(c0125zzaZzbo.zza(), Boolean.valueOf(c0125zzaZzbo.zzb()));
                    }
                    bVar2.put(c0125zzaZzbo.zza(), Boolean.valueOf(c0125zzaZzbo.zzc()));
                    if (c0125zzaZzbo.zzd()) {
                        if (c0125zzaZzbo.zze() >= zzc && c0125zzaZzbo.zze() <= zzb) {
                            bVar3.put(c0125zzaZzbo.zza(), Integer.valueOf(c0125zzaZzbo.zze()));
                        } else {
                            zzq().zzh().zza("Invalid sampling rate. Event name, sample rate", c0125zzaZzbo.zza(), Integer.valueOf(c0125zzaZzbo.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, bVar);
        this.zzf.put(str, bVar2);
        this.zzh.put(str, bVar3);
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzaf zzi() {
        return super.zzi();
    }

    protected final boolean zza(String str, byte[] bArr, String str2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        zzca.zzb.zza zzaVarZzbo = zza(str, bArr).zzbo();
        if (zzaVarZzbo == null) {
            return false;
        }
        zza(str, zzaVarZzbo);
        this.zzg.put(str, (zzca.zzb) zzaVarZzbo.zzy());
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((zzca.zzb) zzaVarZzbo.zzy()));
        zzi().zza(str, new ArrayList(zzaVarZzbo.zzb()));
        try {
            zzaVarZzbo.zzc();
            bArr = ((zzca.zzb) ((com.google.android.gms.internal.measurement.zzhy) zzaVarZzbo.zzy())).zzbk();
        } catch (RuntimeException e2) {
            zzq().zzh().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzeq.zza(str), e2);
        }
        zzaf zzafVarZzi = zzi();
        Preconditions.checkNotEmpty(str);
        zzafVarZzi.zzc();
        zzafVarZzi.zzaj();
        new ContentValues().put("remote_config", bArr);
        try {
            if (zzafVarZzi.c_().update("apps", r2, "app_id = ?", new String[]{str}) == 0) {
                zzafVarZzi.zzq().zze().zza("Failed to update remote config (got 0). appId", zzeq.zza(str));
            }
        } catch (SQLiteException e3) {
            zzafVarZzi.zzq().zze().zza("Error storing remote config. appId", zzeq.zza(str), e3);
        }
        this.zzg.put(str, (zzca.zzb) zzaVarZzbo.zzy());
        return true;
    }

    private final zzca.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzca.zzb.zzj();
        }
        try {
            zzca.zzb zzbVar = (zzca.zzb) ((com.google.android.gms.internal.measurement.zzhy) ((zzca.zzb.zza) zzkr.zza(zzca.zzb.zzi(), bArr)).zzy());
            zzq().zzw().zza("Parsed config. version, gmp_app_id", zzbVar.zza() ? Long.valueOf(zzbVar.zzb()) : null, zzbVar.zzc() ? zzbVar.zzd() : null);
            return zzbVar;
        } catch (com.google.android.gms.internal.measurement.zzij e2) {
            zzq().zzh().zza("Unable to merge remote config. appId", zzeq.zza(str), e2);
            return zzca.zzb.zzj();
        } catch (RuntimeException e3) {
            zzq().zzh().zza("Unable to merge remote config. appId", zzeq.zza(str), e3);
            return zzca.zzb.zzj();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}

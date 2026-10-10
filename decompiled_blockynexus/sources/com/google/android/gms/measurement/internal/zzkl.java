package com.google.android.gms.measurement.internal;

import a.a.b;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zznw;
import com.tendcloud.tenddata.ab;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzkl implements zzgt {
    private static volatile zzkl zza;
    private final zzky zzaa;
    private zzfo zzb;
    private zzex zzc;
    private zzaf zzd;
    private zzfa zze;
    private zzkh zzf;
    private zzr zzg;
    private final zzkr zzh;
    private zzih zzi;
    private zzjr zzj;
    private final zzfu zzk;
    private boolean zzl;
    private boolean zzm;

    @VisibleForTesting
    private long zzn;
    private List<Runnable> zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List<Long> zzw;
    private List<Long> zzx;
    private long zzy;
    private final Map<String, zzac> zzz;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    private class zza implements zzah {
        zzcd.zzg zza;
        List<Long> zzb;
        List<zzcd.zzc> zzc;
        private long zzd;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzah
        public final void zza(zzcd.zzg zzgVar) {
            Preconditions.checkNotNull(zzgVar);
            this.zza = zzgVar;
        }

        /* synthetic */ zza(zzkl zzklVar, zzkk zzkkVar) {
            this();
        }

        @Override // com.google.android.gms.measurement.internal.zzah
        public final boolean zza(long j, zzcd.zzc zzcVar) {
            Preconditions.checkNotNull(zzcVar);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzcVar)) {
                return false;
            }
            long jZzbp = this.zzd + ((long) zzcVar.zzbp());
            if (jZzbp >= Math.max(0, zzas.zzh.zza(null).intValue())) {
                return false;
            }
            this.zzd = jZzbp;
            this.zzc.add(zzcVar);
            this.zzb.add(Long.valueOf(j));
            return this.zzc.size() < Math.max(1, zzas.zzi.zza(null).intValue());
        }

        private static long zza(zzcd.zzc zzcVar) {
            return ((zzcVar.zze() / 1000) / 60) / 60;
        }
    }

    private zzkl(zzks zzksVar) {
        this(zzksVar, null);
    }

    public static zzkl zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkl.class) {
                if (zza == null) {
                    zza = new zzkl(new zzks(context));
                }
            }
        }
        return zza;
    }

    private final boolean zzaa() {
        zzx();
        zzn();
        return zze().zzx() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zzab() {
        long jMax;
        long jMax2;
        zzx();
        zzn();
        if (this.zzn > 0) {
            long jAbs = 3600000 - Math.abs(this.zzk.zzl().elapsedRealtime() - this.zzn);
            if (jAbs > 0) {
                this.zzk.zzq().zzw().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzv().zzb();
                zzw().zze();
                return;
            }
            this.zzn = 0L;
        }
        if (!this.zzk.zzaf() || !zzaa()) {
            this.zzk.zzq().zzw().zza("Nothing to upload or uploading impossible");
            zzv().zzb();
            zzw().zze();
            return;
        }
        long jCurrentTimeMillis = this.zzk.zzl().currentTimeMillis();
        long jMax3 = Math.max(0L, zzas.zzz.zza(null).longValue());
        boolean z = zze().zzy() || zze().e_();
        if (z) {
            String strZzw = this.zzk.zza().zzw();
            jMax = (TextUtils.isEmpty(strZzw) || ".none.".equals(strZzw)) ? Math.max(0L, zzas.zzt.zza(null).longValue()) : Math.max(0L, zzas.zzu.zza(null).longValue());
        } else {
            jMax = Math.max(0L, zzas.zzs.zza(null).longValue());
        }
        long jZza = this.zzk.zzb().zzc.zza();
        long jZza2 = this.zzk.zzb().zzd.zza();
        long j = jMax;
        long jMax4 = Math.max(zze().zzv(), zze().zzw());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jAbs3, jAbs4);
            long jMin = jAbs2 + jMax3;
            if (z && jMax5 > 0) {
                jMin = Math.min(jAbs2, jMax5) + j;
            }
            jMax2 = !zzh().zza(jMax5, j) ? jMax5 + j : jMin;
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                for (int i = 0; i < Math.min(20, Math.max(0, zzas.zzab.zza(null).intValue())); i++) {
                    jMax2 += Math.max(0L, zzas.zzaa.zza(null).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                }
                jMax2 = 0;
            }
        }
        if (jMax2 == 0) {
            this.zzk.zzq().zzw().zza("Next upload time is 0");
            zzv().zzb();
            zzw().zze();
            return;
        }
        if (!zzd().zze()) {
            this.zzk.zzq().zzw().zza("No network");
            zzv().zza();
            zzw().zze();
            return;
        }
        long jZza3 = this.zzk.zzb().zze.zza();
        long jMax6 = Math.max(0L, zzas.zzq.zza(null).longValue());
        if (!zzh().zza(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzv().zzb();
        long jCurrentTimeMillis2 = jMax2 - this.zzk.zzl().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            jCurrentTimeMillis2 = Math.max(0L, zzas.zzv.zza(null).longValue());
            this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
        }
        this.zzk.zzq().zzw().zza("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzw().zza(jCurrentTimeMillis2);
    }

    private final void zzac() {
        zzx();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzk.zzq().zzw().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzk.zzq().zzw().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.zzo.clear();
    }

    @VisibleForTesting
    private final boolean zzad() {
        FileLock fileLock;
        zzx();
        if (this.zzk.zza().zza(zzas.zzbh) && (fileLock = this.zzu) != null && fileLock.isValid()) {
            this.zzk.zzq().zzw().zza("Storage concurrent access okay");
            return true;
        }
        try {
            this.zzv = new RandomAccessFile(new File(this.zzk.zzm().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzu = this.zzv.tryLock();
            if (this.zzu != null) {
                this.zzk.zzq().zzw().zza("Storage concurrent access okay");
                return true;
            }
            this.zzk.zzq().zze().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            this.zzk.zzq().zze().zza("Failed to acquire storage lock", e2);
            return false;
        } catch (IOException e3) {
            this.zzk.zzq().zze().zza("Failed to access storage lock file", e3);
            return false;
        } catch (OverlappingFileLockException e4) {
            this.zzk.zzq().zzh().zza("Storage lock already acquired", e4);
            return false;
        }
    }

    private final zzfa zzv() {
        zzfa zzfaVar = this.zze;
        if (zzfaVar != null) {
            return zzfaVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkh zzw() {
        zzb(this.zzf);
        return this.zzf;
    }

    private final void zzx() {
        this.zzk.zzp().zzc();
    }

    private final long zzy() {
        long jCurrentTimeMillis = this.zzk.zzl().currentTimeMillis();
        zzfc zzfcVarZzb = this.zzk.zzb();
        zzfcVarZzb.zzab();
        zzfcVarZzb.zzc();
        long jZza = zzfcVarZzb.zzg.zza();
        if (jZza == 0) {
            jZza = 1 + ((long) zzfcVarZzb.zzo().zzg().nextInt(86400000));
            zzfcVarZzb.zzg.zza(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    @Deprecated
    private final String zzz() {
        byte[] bArr = new byte[16];
        this.zzk.zzh().zzg().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final zzab zzb() {
        return this.zzk.zza();
    }

    public final zzfo zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzex zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzaf zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    public final zzr zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzih zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzkr zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzjr zzi() {
        return this.zzj;
    }

    public final zzeo zzj() {
        return this.zzk.zzi();
    }

    public final zzkv zzk() {
        return this.zzk.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Clock zzl() {
        return this.zzk.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Context zzm() {
        return this.zzk.zzm();
    }

    final void zzn() {
        if (!this.zzl) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    final void zzo() {
        zzf zzfVarZzb;
        String strZzad;
        zzx();
        zzn();
        this.zzt = true;
        try {
            Boolean boolZzaf = this.zzk.zzv().zzaf();
            if (boolZzaf == null) {
                this.zzk.zzq().zzh().zza("Upload data called on the client side before use of service was decided");
                return;
            }
            if (boolZzaf.booleanValue()) {
                this.zzk.zzq().zze().zza("Upload called in the client side when service should be used");
                return;
            }
            if (this.zzn > 0) {
                zzab();
                return;
            }
            zzx();
            if (this.zzw != null) {
                this.zzk.zzq().zzw().zza("Uploading requested multiple times");
                return;
            }
            if (!zzd().zze()) {
                this.zzk.zzq().zzw().zza("Network not connected, ignoring upload request");
                zzab();
                return;
            }
            long jCurrentTimeMillis = this.zzk.zzl().currentTimeMillis();
            int iZzb = this.zzk.zza().zzb(null, zzas.zzap);
            long jZzv = jCurrentTimeMillis - zzab.zzv();
            for (int i = 0; i < iZzb && zza((String) null, jZzv); i++) {
            }
            long jZza = this.zzk.zzb().zzc.zza();
            if (jZza != 0) {
                this.zzk.zzq().zzv().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jZza)));
            }
            String strD_ = zze().d_();
            if (TextUtils.isEmpty(strD_)) {
                this.zzy = -1L;
                String strZza = zze().zza(jCurrentTimeMillis - zzab.zzv());
                if (!TextUtils.isEmpty(strZza) && (zzfVarZzb = zze().zzb(strZza)) != null) {
                    zza(zzfVarZzb);
                }
            } else {
                if (this.zzy == -1) {
                    this.zzy = zze().zzz();
                }
                List<Pair<zzcd.zzg, Long>> listZza = zze().zza(strD_, this.zzk.zza().zzb(strD_, zzas.zzf), Math.max(0, this.zzk.zza().zzb(strD_, zzas.zzg)));
                if (!listZza.isEmpty()) {
                    if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zza(strD_).zzc()) {
                        Iterator<Pair<zzcd.zzg, Long>> it = listZza.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                strZzad = null;
                                break;
                            }
                            zzcd.zzg zzgVar = (zzcd.zzg) it.next().first;
                            if (!TextUtils.isEmpty(zzgVar.zzad())) {
                                strZzad = zzgVar.zzad();
                                break;
                            }
                        }
                        if (strZzad != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= listZza.size()) {
                                    break;
                                }
                                zzcd.zzg zzgVar2 = (zzcd.zzg) listZza.get(i2).first;
                                if (!TextUtils.isEmpty(zzgVar2.zzad()) && !zzgVar2.zzad().equals(strZzad)) {
                                    listZza = listZza.subList(0, i2);
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                    zzcd.zzf.zza zzaVarZzb = zzcd.zzf.zzb();
                    int size = listZza.size();
                    ArrayList arrayList = new ArrayList(listZza.size());
                    boolean z = this.zzk.zza().zzh(strD_) && !(zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && !zza(strD_).zzc());
                    boolean z2 = (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && !zza(strD_).zzc()) ? false : true;
                    boolean z3 = (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && !zza(strD_).zze()) ? false : true;
                    int i3 = 0;
                    while (i3 < size) {
                        zzcd.zzg.zza zzaVarZzbo = ((zzcd.zzg) listZza.get(i3).first).zzbo();
                        arrayList.add((Long) listZza.get(i3).second);
                        ArrayList arrayList2 = arrayList;
                        zzaVarZzbo.zzg(33025L).zza(jCurrentTimeMillis).zzb(false);
                        if (!z) {
                            zzaVarZzbo.zzr();
                        }
                        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
                            if (!z2) {
                                zzaVarZzbo.zzk();
                                zzaVarZzbo.zzl();
                            }
                            if (!z3) {
                                zzaVarZzbo.zzm();
                            }
                        }
                        if (this.zzk.zza().zze(strD_, zzas.zzaw)) {
                            zzaVarZzbo.zzl(zzh().zza(((zzcd.zzg) ((com.google.android.gms.internal.measurement.zzhy) zzaVarZzbo.zzy())).zzbk()));
                        }
                        zzaVarZzb.zza(zzaVarZzbo);
                        i3++;
                        arrayList = arrayList2;
                    }
                    ArrayList arrayList3 = arrayList;
                    String strZza2 = this.zzk.zzq().zza(2) ? zzh().zza((zzcd.zzf) ((com.google.android.gms.internal.measurement.zzhy) zzaVarZzb.zzy())) : null;
                    zzh();
                    byte[] bArrZzbk = ((zzcd.zzf) ((com.google.android.gms.internal.measurement.zzhy) zzaVarZzb.zzy())).zzbk();
                    String strZza3 = zzas.zzp.zza(null);
                    try {
                        URL url = new URL(strZza3);
                        Preconditions.checkArgument(!arrayList3.isEmpty());
                        if (this.zzw != null) {
                            this.zzk.zzq().zze().zza("Set uploading progress before finishing the previous upload");
                        } else {
                            this.zzw = new ArrayList(arrayList3);
                        }
                        this.zzk.zzb().zzd.zza(jCurrentTimeMillis);
                        this.zzk.zzq().zzw().zza("Uploading data. app, uncompressed size, data", size > 0 ? zzaVarZzb.zza(0).zzx() : "?", Integer.valueOf(bArrZzbk.length), strZza2);
                        this.zzs = true;
                        zzex zzexVarZzd = zzd();
                        zzkn zzknVar = new zzkn(this, strD_);
                        zzexVarZzd.zzc();
                        zzexVarZzd.zzaj();
                        Preconditions.checkNotNull(url);
                        Preconditions.checkNotNull(bArrZzbk);
                        Preconditions.checkNotNull(zzknVar);
                        zzexVarZzd.zzp().zzc(new zzfb(zzexVarZzd, strD_, url, bArrZzbk, null, zzknVar));
                    } catch (MalformedURLException unused) {
                        this.zzk.zzq().zze().zza("Failed to parse upload URL. Not uploading. appId", zzeq.zza(strD_), strZza3);
                    }
                }
            }
        } finally {
            this.zzt = false;
            zzac();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzfr zzp() {
        return this.zzk.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzeq zzq() {
        return this.zzk.zzq();
    }

    @VisibleForTesting
    final void zzr() {
        zzx();
        zzn();
        if (this.zzm) {
            return;
        }
        this.zzm = true;
        if (zzad()) {
            int iZza = zza(this.zzv);
            int iZzae = this.zzk.zzx().zzae();
            zzx();
            if (iZza > iZzae) {
                this.zzk.zzq().zze().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(iZza), Integer.valueOf(iZzae));
            } else if (iZza < iZzae) {
                if (zza(iZzae, this.zzv)) {
                    this.zzk.zzq().zzw().zza("Storage version upgraded. Previous, current version", Integer.valueOf(iZza), Integer.valueOf(iZzae));
                } else {
                    this.zzk.zzq().zze().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(iZza), Integer.valueOf(iZzae));
                }
            }
        }
    }

    final void zzs() {
        this.zzq++;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzw zzt() {
        return this.zzk.zzt();
    }

    final zzfu zzu() {
        return this.zzk;
    }

    private zzkl(zzks zzksVar, zzfu zzfuVar) {
        this.zzl = false;
        this.zzaa = new zzko(this);
        Preconditions.checkNotNull(zzksVar);
        this.zzk = zzfu.zza(zzksVar.zza, null, null);
        this.zzy = -1L;
        zzkr zzkrVar = new zzkr(this);
        zzkrVar.zzak();
        this.zzh = zzkrVar;
        zzex zzexVar = new zzex(this);
        zzexVar.zzak();
        this.zzc = zzexVar;
        zzfo zzfoVar = new zzfo(this);
        zzfoVar.zzak();
        this.zzb = zzfoVar;
        this.zzz = new HashMap();
        this.zzk.zzp().zza(new zzkk(this, zzksVar));
    }

    private static void zzb(zzki zzkiVar) {
        if (zzkiVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzkiVar.zzai()) {
            return;
        }
        String strValueOf = String.valueOf(zzkiVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:297:0x0972 A[Catch: all -> 0x09c1, TryCatch #0 {all -> 0x09c1, blocks: (B:39:0x013b, B:42:0x014a, B:44:0x0154, B:49:0x0160, B:56:0x0172, B:59:0x017e, B:61:0x0195, B:67:0x01b1, B:72:0x01e7, B:74:0x01ed, B:76:0x01fb, B:78:0x0207, B:80:0x0211, B:82:0x021c, B:85:0x0223, B:93:0x02b2, B:95:0x02bc, B:99:0x02f6, B:103:0x0308, B:105:0x0355, B:107:0x035a, B:108:0x0373, B:112:0x0384, B:114:0x0398, B:116:0x039d, B:117:0x03b6, B:121:0x03db, B:125:0x0400, B:126:0x0419, B:129:0x0428, B:132:0x044b, B:133:0x0467, B:135:0x0471, B:137:0x047d, B:139:0x0483, B:140:0x048e, B:142:0x049a, B:143:0x04b1, B:145:0x04d8, B:148:0x04f1, B:151:0x0537, B:153:0x055f, B:155:0x0599, B:156:0x059e, B:158:0x05a6, B:159:0x05ab, B:161:0x05b3, B:162:0x05b8, B:164:0x05c1, B:165:0x05c7, B:167:0x05d4, B:168:0x05d9, B:170:0x05df, B:172:0x05ed, B:173:0x0604, B:175:0x060a, B:177:0x061a, B:179:0x0624, B:181:0x062c, B:182:0x0631, B:184:0x063b, B:186:0x0645, B:188:0x064d, B:194:0x066a, B:196:0x0672, B:197:0x0677, B:199:0x0686, B:200:0x0689, B:202:0x069f, B:204:0x06ad, B:230:0x075b, B:232:0x07a3, B:233:0x07a8, B:235:0x07b0, B:237:0x07b6, B:239:0x07c4, B:241:0x07cb, B:243:0x07d1, B:240:0x07c8, B:244:0x07d6, B:246:0x07e2, B:248:0x07f1, B:250:0x07ff, B:252:0x080e, B:254:0x081e, B:256:0x082c, B:259:0x083d, B:261:0x0872, B:262:0x0877, B:258:0x0832, B:251:0x0807, B:263:0x0883, B:265:0x0889, B:267:0x0897, B:272:0x08ae, B:274:0x08b8, B:275:0x08bf, B:276:0x08ca, B:278:0x08d0, B:280:0x0901, B:281:0x0911, B:283:0x0919, B:284:0x091f, B:286:0x0925, B:295:0x096c, B:297:0x0972, B:300:0x098e, B:289:0x0932, B:291:0x0957, B:299:0x0976, B:269:0x089d, B:271:0x08a7, B:206:0x06b3, B:208:0x06bd, B:210:0x06c7, B:212:0x06cb, B:214:0x06d6, B:215:0x06e3, B:217:0x06f5, B:219:0x06f9, B:221:0x06ff, B:223:0x070f, B:225:0x0721, B:229:0x0758, B:226:0x073b, B:228:0x0741, B:189:0x0653, B:191:0x065d, B:193:0x0665, B:152:0x0551, B:86:0x024d, B:87:0x026b, B:92:0x0299, B:91:0x0288, B:79:0x020c, B:70:0x01bf, B:71:0x01dd), top: B:307:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02f6 A[Catch: all -> 0x09c1, TRY_LEAVE, TryCatch #0 {all -> 0x09c1, blocks: (B:39:0x013b, B:42:0x014a, B:44:0x0154, B:49:0x0160, B:56:0x0172, B:59:0x017e, B:61:0x0195, B:67:0x01b1, B:72:0x01e7, B:74:0x01ed, B:76:0x01fb, B:78:0x0207, B:80:0x0211, B:82:0x021c, B:85:0x0223, B:93:0x02b2, B:95:0x02bc, B:99:0x02f6, B:103:0x0308, B:105:0x0355, B:107:0x035a, B:108:0x0373, B:112:0x0384, B:114:0x0398, B:116:0x039d, B:117:0x03b6, B:121:0x03db, B:125:0x0400, B:126:0x0419, B:129:0x0428, B:132:0x044b, B:133:0x0467, B:135:0x0471, B:137:0x047d, B:139:0x0483, B:140:0x048e, B:142:0x049a, B:143:0x04b1, B:145:0x04d8, B:148:0x04f1, B:151:0x0537, B:153:0x055f, B:155:0x0599, B:156:0x059e, B:158:0x05a6, B:159:0x05ab, B:161:0x05b3, B:162:0x05b8, B:164:0x05c1, B:165:0x05c7, B:167:0x05d4, B:168:0x05d9, B:170:0x05df, B:172:0x05ed, B:173:0x0604, B:175:0x060a, B:177:0x061a, B:179:0x0624, B:181:0x062c, B:182:0x0631, B:184:0x063b, B:186:0x0645, B:188:0x064d, B:194:0x066a, B:196:0x0672, B:197:0x0677, B:199:0x0686, B:200:0x0689, B:202:0x069f, B:204:0x06ad, B:230:0x075b, B:232:0x07a3, B:233:0x07a8, B:235:0x07b0, B:237:0x07b6, B:239:0x07c4, B:241:0x07cb, B:243:0x07d1, B:240:0x07c8, B:244:0x07d6, B:246:0x07e2, B:248:0x07f1, B:250:0x07ff, B:252:0x080e, B:254:0x081e, B:256:0x082c, B:259:0x083d, B:261:0x0872, B:262:0x0877, B:258:0x0832, B:251:0x0807, B:263:0x0883, B:265:0x0889, B:267:0x0897, B:272:0x08ae, B:274:0x08b8, B:275:0x08bf, B:276:0x08ca, B:278:0x08d0, B:280:0x0901, B:281:0x0911, B:283:0x0919, B:284:0x091f, B:286:0x0925, B:295:0x096c, B:297:0x0972, B:300:0x098e, B:289:0x0932, B:291:0x0957, B:299:0x0976, B:269:0x089d, B:271:0x08a7, B:206:0x06b3, B:208:0x06bd, B:210:0x06c7, B:212:0x06cb, B:214:0x06d6, B:215:0x06e3, B:217:0x06f5, B:219:0x06f9, B:221:0x06ff, B:223:0x070f, B:225:0x0721, B:229:0x0758, B:226:0x073b, B:228:0x0741, B:189:0x0653, B:191:0x065d, B:193:0x0665, B:152:0x0551, B:86:0x024d, B:87:0x026b, B:92:0x0299, B:91:0x0288, B:79:0x020c, B:70:0x01bf, B:71:0x01dd), top: B:307:0x013b, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzc(com.google.android.gms.measurement.internal.zzaq r27, com.google.android.gms.measurement.internal.zzn r28) {
        /*
            Method dump skipped, instruction units count: 2509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzc(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzn):void");
    }

    private final boolean zze(zzn zznVar) {
        return (zznv.zzb() && this.zzk.zza().zze(zznVar.zza, zzas.zzbi)) ? (TextUtils.isEmpty(zznVar.zzb) && TextUtils.isEmpty(zznVar.zzv) && TextUtils.isEmpty(zznVar.zzr)) ? false : true : (TextUtils.isEmpty(zznVar.zzb) && TextUtils.isEmpty(zznVar.zzr)) ? false : true;
    }

    final String zzd(zzn zznVar) {
        try {
            return (String) this.zzk.zzp().zza(new zzkp(this, zznVar)).get(ab.R, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            this.zzk.zzq().zze().zza("Failed to get app instance id. appId", zzeq.zza(zznVar.zza), e2);
            return null;
        }
    }

    private final void zzb(zzaq zzaqVar, zzn zznVar) {
        if (zznw.zzb() && this.zzk.zza().zza(zzas.zzbz)) {
            zzeu zzeuVarZza = zzeu.zza(zzaqVar);
            this.zzk.zzh().zza(zzeuVarZza.zzb, zze().zzi(zznVar.zza));
            this.zzk.zzh().zza(zzeuVarZza, this.zzk.zza().zza(zznVar.zza));
            zzaqVar = zzeuVarZza.zza();
        }
        if (this.zzk.zza().zza(zzas.zzbd) && "_cmp".equals(zzaqVar.zza) && "referrer API v2".equals(zzaqVar.zzb.zzd("_cis"))) {
            String strZzd = zzaqVar.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(strZzd)) {
                zza(new zzku("_lgclid", zzaqVar.zzd, strZzd, "auto"), zznVar);
            }
        }
        zza(zzaqVar, zznVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzks zzksVar) {
        this.zzk.zzp().zzc();
        zzaf zzafVar = new zzaf(this);
        zzafVar.zzak();
        this.zzd = zzafVar;
        this.zzk.zza().zza(this.zzb);
        zzjr zzjrVar = new zzjr(this);
        zzjrVar.zzak();
        this.zzj = zzjrVar;
        zzr zzrVar = new zzr(this);
        zzrVar.zzak();
        this.zzg = zzrVar;
        zzih zzihVar = new zzih(this);
        zzihVar.zzak();
        this.zzi = zzihVar;
        zzkh zzkhVar = new zzkh(this);
        zzkhVar.zzak();
        this.zzf = zzkhVar;
        this.zze = new zzfa(this);
        if (this.zzp != this.zzq) {
            this.zzk.zzq().zze().zza("Not all upload components initialized", Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
        }
        this.zzl = true;
    }

    private final void zzb(zzcd.zzc.zza zzaVar, zzcd.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        zzcd.zze zzeVarZza = zzkr.zza((zzcd.zzc) zzaVar.zzy(), "_et");
        if (!zzeVarZza.zze() || zzeVarZza.zzf() <= 0) {
            return;
        }
        long jZzf = zzeVarZza.zzf();
        zzh();
        zzcd.zze zzeVarZza2 = zzkr.zza((zzcd.zzc) zzaVar2.zzy(), "_et");
        if (zzeVarZza2 != null && zzeVarZza2.zzf() > 0) {
            jZzf += zzeVarZza2.zzf();
        }
        zzh();
        zzkr.zza(zzaVar2, "_et", Long.valueOf(jZzf));
        zzh();
        zzkr.zza(zzaVar, "_fr", (Object) 1L);
    }

    private final Boolean zzb(zzf zzfVar) {
        try {
            if (zzfVar.zzm() != -2147483648L) {
                if (zzfVar.zzm() == Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzfVar.zzc(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzfVar.zzc(), 0).versionName;
                if (zzfVar.zzl() != null && zzfVar.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    protected final void zza() {
        this.zzk.zzp().zzc();
        zze().zzu();
        if (this.zzk.zzb().zzc.zza() == 0) {
            this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
        }
        zzab();
    }

    final void zza(String str, zzac zzacVar) {
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            this.zzz.put(str, zzacVar);
            zzaf zzafVarZze = zze();
            if (zzml.zzb() && zzafVarZze.zzs().zza(zzas.zzci)) {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(zzacVar);
                zzafVarZze.zzc();
                zzafVarZze.zzaj();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", zzacVar.zza());
                try {
                    if (zzafVarZze.c_().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                        zzafVarZze.zzq().zze().zza("Failed to insert/update consent setting (got -1). appId", zzeq.zza(str));
                    }
                } catch (SQLiteException e2) {
                    zzafVarZze.zzq().zze().zza("Error storing consent setting. appId, error", zzeq.zza(str), e2);
                }
            }
        }
    }

    final void zzb(zzku zzkuVar, zzn zznVar) {
        zzx();
        zzn();
        if (zze(zznVar)) {
            if (!zznVar.zzh) {
                zzc(zznVar);
                return;
            }
            if ("_npa".equals(zzkuVar.zza) && zznVar.zzs != null) {
                this.zzk.zzq().zzv().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzku("_npa", this.zzk.zzl().currentTimeMillis(), Long.valueOf(zznVar.zzs.booleanValue() ? 1L : 0L), "auto"), zznVar);
                return;
            }
            this.zzk.zzq().zzv().zza("Removing user property", this.zzk.zzi().zzc(zzkuVar.zza));
            zze().zze();
            try {
                zzc(zznVar);
                zze().zzb(zznVar.zza, zzkuVar.zza);
                zze().b_();
                this.zzk.zzq().zzv().zza("User property removed", this.zzk.zzi().zzc(zzkuVar.zza));
            } finally {
                zze().zzg();
            }
        }
    }

    final zzac zza(String str) {
        zzac zzacVarZzj = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            zzacVarZzj = this.zzz.get(str);
            if (zzacVarZzj == null) {
                zzacVarZzj = zze().zzj(str);
                if (zzacVarZzj == null) {
                    zzacVarZzj = zzac.zza;
                }
                zza(str, zzacVarZzj);
            }
        }
        return zzacVarZzj;
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x0492 A[Catch: all -> 0x04bd, TryCatch #3 {all -> 0x04bd, blocks: (B:24:0x009e, B:26:0x00ac, B:44:0x010d, B:46:0x0119, B:48:0x0130, B:49:0x0158, B:51:0x015f, B:53:0x01a9, B:63:0x01d5, B:65:0x01e0, B:70:0x01ef, B:72:0x01f7, B:74:0x01fd, B:78:0x020c, B:80:0x020f, B:83:0x0234, B:85:0x0239, B:91:0x0259, B:94:0x026d, B:96:0x02c7, B:98:0x02cf, B:100:0x02d3, B:101:0x02d6, B:103:0x02f7, B:143:0x03d9, B:144:0x03de, B:155:0x044d, B:157:0x045d, B:159:0x0477, B:160:0x047e, B:164:0x04ae, B:106:0x0313, B:111:0x033e, B:113:0x0346, B:115:0x0350, B:119:0x0364, B:123:0x0372, B:127:0x037d, B:130:0x0390, B:135:0x03bb, B:137:0x03c1, B:138:0x03c6, B:140:0x03cc, B:133:0x03a3, B:120:0x036a, B:109:0x0326, B:147:0x03f6, B:149:0x042b, B:151:0x0433, B:153:0x0437, B:154:0x043a, B:161:0x0492, B:163:0x0496, B:88:0x0249, B:59:0x01bf, B:30:0x00bb, B:32:0x00bf, B:36:0x00d0, B:38:0x00ea, B:40:0x00f4, B:43:0x00fe), top: B:177:0x009e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020f A[Catch: all -> 0x04bd, TryCatch #3 {all -> 0x04bd, blocks: (B:24:0x009e, B:26:0x00ac, B:44:0x010d, B:46:0x0119, B:48:0x0130, B:49:0x0158, B:51:0x015f, B:53:0x01a9, B:63:0x01d5, B:65:0x01e0, B:70:0x01ef, B:72:0x01f7, B:74:0x01fd, B:78:0x020c, B:80:0x020f, B:83:0x0234, B:85:0x0239, B:91:0x0259, B:94:0x026d, B:96:0x02c7, B:98:0x02cf, B:100:0x02d3, B:101:0x02d6, B:103:0x02f7, B:143:0x03d9, B:144:0x03de, B:155:0x044d, B:157:0x045d, B:159:0x0477, B:160:0x047e, B:164:0x04ae, B:106:0x0313, B:111:0x033e, B:113:0x0346, B:115:0x0350, B:119:0x0364, B:123:0x0372, B:127:0x037d, B:130:0x0390, B:135:0x03bb, B:137:0x03c1, B:138:0x03c6, B:140:0x03cc, B:133:0x03a3, B:120:0x036a, B:109:0x0326, B:147:0x03f6, B:149:0x042b, B:151:0x0433, B:153:0x0437, B:154:0x043a, B:161:0x0492, B:163:0x0496, B:88:0x0249, B:59:0x01bf, B:30:0x00bb, B:32:0x00bf, B:36:0x00d0, B:38:0x00ea, B:40:0x00f4, B:43:0x00fe), top: B:177:0x009e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0239 A[Catch: all -> 0x04bd, TryCatch #3 {all -> 0x04bd, blocks: (B:24:0x009e, B:26:0x00ac, B:44:0x010d, B:46:0x0119, B:48:0x0130, B:49:0x0158, B:51:0x015f, B:53:0x01a9, B:63:0x01d5, B:65:0x01e0, B:70:0x01ef, B:72:0x01f7, B:74:0x01fd, B:78:0x020c, B:80:0x020f, B:83:0x0234, B:85:0x0239, B:91:0x0259, B:94:0x026d, B:96:0x02c7, B:98:0x02cf, B:100:0x02d3, B:101:0x02d6, B:103:0x02f7, B:143:0x03d9, B:144:0x03de, B:155:0x044d, B:157:0x045d, B:159:0x0477, B:160:0x047e, B:164:0x04ae, B:106:0x0313, B:111:0x033e, B:113:0x0346, B:115:0x0350, B:119:0x0364, B:123:0x0372, B:127:0x037d, B:130:0x0390, B:135:0x03bb, B:137:0x03c1, B:138:0x03c6, B:140:0x03cc, B:133:0x03a3, B:120:0x036a, B:109:0x0326, B:147:0x03f6, B:149:0x042b, B:151:0x0433, B:153:0x0437, B:154:0x043a, B:161:0x0492, B:163:0x0496, B:88:0x0249, B:59:0x01bf, B:30:0x00bb, B:32:0x00bf, B:36:0x00d0, B:38:0x00ea, B:40:0x00f4, B:43:0x00fe), top: B:177:0x009e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0259 A[Catch: all -> 0x04bd, TRY_LEAVE, TryCatch #3 {all -> 0x04bd, blocks: (B:24:0x009e, B:26:0x00ac, B:44:0x010d, B:46:0x0119, B:48:0x0130, B:49:0x0158, B:51:0x015f, B:53:0x01a9, B:63:0x01d5, B:65:0x01e0, B:70:0x01ef, B:72:0x01f7, B:74:0x01fd, B:78:0x020c, B:80:0x020f, B:83:0x0234, B:85:0x0239, B:91:0x0259, B:94:0x026d, B:96:0x02c7, B:98:0x02cf, B:100:0x02d3, B:101:0x02d6, B:103:0x02f7, B:143:0x03d9, B:144:0x03de, B:155:0x044d, B:157:0x045d, B:159:0x0477, B:160:0x047e, B:164:0x04ae, B:106:0x0313, B:111:0x033e, B:113:0x0346, B:115:0x0350, B:119:0x0364, B:123:0x0372, B:127:0x037d, B:130:0x0390, B:135:0x03bb, B:137:0x03c1, B:138:0x03c6, B:140:0x03cc, B:133:0x03a3, B:120:0x036a, B:109:0x0326, B:147:0x03f6, B:149:0x042b, B:151:0x0433, B:153:0x0437, B:154:0x043a, B:161:0x0492, B:163:0x0496, B:88:0x0249, B:59:0x01bf, B:30:0x00bb, B:32:0x00bf, B:36:0x00d0, B:38:0x00ea, B:40:0x00f4, B:43:0x00fe), top: B:177:0x009e, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzb(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            Method dump skipped, instruction units count: 1224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzb(com.google.android.gms.measurement.internal.zzn):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zza(com.google.android.gms.measurement.internal.zzaq r36, java.lang.String r37) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(com.google.android.gms.measurement.internal.zzaq, java.lang.String):void");
    }

    final void zza(zzaq zzaqVar, zzn zznVar) {
        List<zzz> listZza;
        List<zzz> listZza2;
        List<zzz> listZza3;
        zzaq zzaqVar2 = zzaqVar;
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.zza);
        zzx();
        zzn();
        String str = zznVar.zza;
        long j = zzaqVar2.zzd;
        zzh();
        if (zzkr.zza(zzaqVar, zznVar)) {
            if (!zznVar.zzh) {
                zzc(zznVar);
                return;
            }
            List<String> list = zznVar.zzu;
            if (list != null) {
                if (list.contains(zzaqVar2.zza)) {
                    Bundle bundleZzb = zzaqVar2.zzb.zzb();
                    bundleZzb.putLong("ga_safelisted", 1L);
                    zzaqVar2 = new zzaq(zzaqVar2.zza, new zzap(bundleZzb), zzaqVar2.zzc, zzaqVar2.zzd);
                } else {
                    this.zzk.zzq().zzv().zza("Dropping non-safelisted event. appId, event name, origin", str, zzaqVar2.zza, zzaqVar2.zzc);
                    return;
                }
            }
            zze().zze();
            try {
                zzaf zzafVarZze = zze();
                Preconditions.checkNotEmpty(str);
                zzafVarZze.zzc();
                zzafVarZze.zzaj();
                if (j < 0) {
                    zzafVarZze.zzq().zzh().zza("Invalid time querying timed out conditional properties", zzeq.zza(str), Long.valueOf(j));
                    listZza = Collections.emptyList();
                } else {
                    listZza = zzafVarZze.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzz zzzVar : listZza) {
                    if (zzzVar != null) {
                        this.zzk.zzq().zzw().zza("User property timed out", zzzVar.zza, this.zzk.zzi().zzc(zzzVar.zzc.zza), zzzVar.zzc.zza());
                        if (zzzVar.zzg != null) {
                            zzc(new zzaq(zzzVar.zzg, j), zznVar);
                        }
                        zze().zze(str, zzzVar.zzc.zza);
                    }
                }
                zzaf zzafVarZze2 = zze();
                Preconditions.checkNotEmpty(str);
                zzafVarZze2.zzc();
                zzafVarZze2.zzaj();
                if (j < 0) {
                    zzafVarZze2.zzq().zzh().zza("Invalid time querying expired conditional properties", zzeq.zza(str), Long.valueOf(j));
                    listZza2 = Collections.emptyList();
                } else {
                    listZza2 = zzafVarZze2.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(listZza2.size());
                for (zzz zzzVar2 : listZza2) {
                    if (zzzVar2 != null) {
                        this.zzk.zzq().zzw().zza("User property expired", zzzVar2.zza, this.zzk.zzi().zzc(zzzVar2.zzc.zza), zzzVar2.zzc.zza());
                        zze().zzb(str, zzzVar2.zzc.zza);
                        if (zzzVar2.zzk != null) {
                            arrayList.add(zzzVar2.zzk);
                        }
                        zze().zze(str, zzzVar2.zzc.zza);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zzc(new zzaq((zzaq) obj, j), zznVar);
                }
                zzaf zzafVarZze3 = zze();
                String str2 = zzaqVar2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzafVarZze3.zzc();
                zzafVarZze3.zzaj();
                if (j < 0) {
                    zzafVarZze3.zzq().zzh().zza("Invalid time querying triggered conditional properties", zzeq.zza(str), zzafVarZze3.zzn().zza(str2), Long.valueOf(j));
                    listZza3 = Collections.emptyList();
                } else {
                    listZza3 = zzafVarZze3.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(listZza3.size());
                for (zzz zzzVar3 : listZza3) {
                    if (zzzVar3 != null) {
                        zzku zzkuVar = zzzVar3.zzc;
                        zzkw zzkwVar = new zzkw(zzzVar3.zza, zzzVar3.zzb, zzkuVar.zza, j, zzkuVar.zza());
                        if (zze().zza(zzkwVar)) {
                            this.zzk.zzq().zzw().zza("User property triggered", zzzVar3.zza, this.zzk.zzi().zzc(zzkwVar.zzc), zzkwVar.zze);
                        } else {
                            this.zzk.zzq().zze().zza("Too many active user properties, ignoring", zzeq.zza(zzzVar3.zza), this.zzk.zzi().zzc(zzkwVar.zzc), zzkwVar.zze);
                        }
                        if (zzzVar3.zzi != null) {
                            arrayList2.add(zzzVar3.zzi);
                        }
                        zzzVar3.zzc = new zzku(zzkwVar);
                        zzzVar3.zze = true;
                        zze().zza(zzzVar3);
                    }
                }
                zzc(zzaqVar2, zznVar);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    zzc(new zzaq((zzaq) obj2, j), zznVar);
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    private final String zza(zzac zzacVar) {
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && !zzacVar.zze()) {
            return null;
        }
        return zzz();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0278 A[Catch: all -> 0x0fff, TRY_ENTER, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x027f A[Catch: all -> 0x0fff, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x028d A[Catch: all -> 0x0fff, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x064e A[Catch: all -> 0x0fff, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0729 A[Catch: all -> 0x0fff, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x08aa  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x08b0 A[Catch: all -> 0x0fff, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x090e  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x096c A[Catch: all -> 0x0fff, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0c65 A[Catch: all -> 0x0fff, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0c78  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0c7b A[Catch: all -> 0x0fff, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0ca2 A[Catch: all -> 0x0fff, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0121 A[Catch: SQLiteException -> 0x0253, all -> 0x0ff7, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x0253, blocks: (B:49:0x00f5, B:51:0x0121, B:55:0x0139, B:56:0x013d, B:57:0x014f, B:59:0x0155, B:60:0x0166, B:62:0x0172, B:64:0x0194, B:63:0x0187, B:93:0x023c), top: B:575:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:559:0x0fe7 A[Catch: all -> 0x0fff, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x0fff, blocks: (B:3:0x000b, B:26:0x008a, B:108:0x027b, B:110:0x027f, B:116:0x028d, B:117:0x02b5, B:120:0x02c7, B:123:0x02eb, B:125:0x0324, B:131:0x033a, B:133:0x0344, B:329:0x092d, B:135:0x0370, B:137:0x0378, B:139:0x038c, B:141:0x039c, B:144:0x03be, B:146:0x03c4, B:148:0x03d4, B:150:0x03e2, B:152:0x03f2, B:153:0x0401, B:154:0x0404, B:157:0x041a, B:186:0x047b, B:189:0x0485, B:191:0x0493, B:195:0x04de, B:192:0x04b2, B:194:0x04c2, B:199:0x04eb, B:201:0x051b, B:202:0x0549, B:204:0x057d, B:206:0x0583, B:209:0x058f, B:211:0x05c4, B:212:0x05e1, B:214:0x05e7, B:216:0x05f5, B:220:0x0608, B:217:0x05fd, B:223:0x060f, B:225:0x0615, B:226:0x0633, B:228:0x064e, B:229:0x065a, B:231:0x0660, B:237:0x0687, B:234:0x0674, B:240:0x068d, B:242:0x0699, B:244:0x06a5, B:260:0x06f6, B:263:0x0715, B:265:0x0729, B:267:0x0733, B:270:0x0748, B:272:0x075b, B:274:0x0769, B:318:0x08b0, B:320:0x08ba, B:322:0x08c0, B:323:0x08da, B:325:0x08ed, B:326:0x0907, B:328:0x0910, B:279:0x077e, B:281:0x078a, B:284:0x079f, B:286:0x07b2, B:288:0x07c0, B:291:0x07d2, B:293:0x07ea, B:295:0x07f6, B:298:0x0809, B:300:0x081c, B:302:0x0867, B:304:0x086e, B:306:0x0874, B:308:0x087e, B:310:0x0885, B:312:0x088b, B:314:0x0895, B:315:0x08a5, B:248:0x06c8, B:252:0x06dc, B:254:0x06e2, B:257:0x06ed, B:164:0x043c, B:167:0x0446, B:170:0x0450, B:334:0x094b, B:336:0x0959, B:338:0x0964, B:349:0x0996, B:339:0x096c, B:341:0x0975, B:343:0x097b, B:346:0x0987, B:348:0x0991, B:351:0x099b, B:352:0x09a7, B:354:0x09ad, B:359:0x09c4, B:360:0x09d1, B:365:0x09de, B:369:0x0a07, B:371:0x0a26, B:373:0x0a34, B:375:0x0a3a, B:377:0x0a44, B:378:0x0a76, B:380:0x0a7c, B:382:0x0a8c, B:386:0x0a97, B:383:0x0a91, B:387:0x0a9a, B:388:0x0aa9, B:390:0x0aaf, B:392:0x0abf, B:393:0x0ac6, B:395:0x0ad2, B:396:0x0ad9, B:397:0x0adc, B:399:0x0ae2, B:401:0x0af4, B:402:0x0af7, B:404:0x0b34, B:405:0x0b49, B:407:0x0b4f, B:409:0x0b65, B:411:0x0b80, B:412:0x0b91, B:414:0x0b95, B:416:0x0ba1, B:417:0x0bab, B:419:0x0baf, B:421:0x0bb7, B:422:0x0bc5, B:423:0x0bd0, B:497:0x0e25, B:425:0x0bd7, B:429:0x0c0b, B:430:0x0c13, B:432:0x0c19, B:434:0x0c2b, B:436:0x0c2f, B:450:0x0c65, B:453:0x0c7b, B:454:0x0ca2, B:456:0x0cae, B:458:0x0cc4, B:460:0x0d06, B:464:0x0d1e, B:466:0x0d25, B:468:0x0d36, B:470:0x0d3a, B:472:0x0d3e, B:474:0x0d42, B:475:0x0d4e, B:476:0x0d53, B:478:0x0d59, B:480:0x0d7a, B:481:0x0d83, B:496:0x0e22, B:482:0x0d97, B:484:0x0d9e, B:488:0x0dc0, B:490:0x0dec, B:491:0x0dfa, B:492:0x0e0a, B:494:0x0e10, B:485:0x0da9, B:438:0x0c3d, B:440:0x0c41, B:442:0x0c4b, B:444:0x0c4f, B:498:0x0e2b, B:500:0x0e36, B:501:0x0e3d, B:502:0x0e45, B:504:0x0e4b, B:506:0x0e60, B:508:0x0e70, B:528:0x0ee5, B:530:0x0eeb, B:532:0x0efb, B:535:0x0f02, B:540:0x0f35, B:536:0x0f0a, B:538:0x0f16, B:539:0x0f1c, B:541:0x0f46, B:542:0x0f5d, B:545:0x0f65, B:546:0x0f6a, B:547:0x0f7a, B:549:0x0f94, B:550:0x0fad, B:551:0x0fb5, B:556:0x0fd7, B:555:0x0fc6, B:509:0x0e8a, B:511:0x0e90, B:513:0x0e9a, B:515:0x0ea1, B:521:0x0eb1, B:523:0x0eb8, B:525:0x0ed7, B:527:0x0ede, B:526:0x0edb, B:522:0x0eb5, B:514:0x0e9e, B:366:0x09e3, B:368:0x09eb, B:559:0x0fe7, B:53:0x0134, B:69:0x01d4, B:77:0x020c, B:85:0x022c, B:565:0x0ffb, B:566:0x0ffe, B:107:0x0278, B:95:0x024f, B:45:0x00e6, B:56:0x013d), top: B:584:0x000b, inners: #0, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0139 A[Catch: SQLiteException -> 0x0253, all -> 0x0ff7, TRY_ENTER, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x0253, blocks: (B:49:0x00f5, B:51:0x0121, B:55:0x0139, B:56:0x013d, B:57:0x014f, B:59:0x0155, B:60:0x0166, B:62:0x0172, B:64:0x0194, B:63:0x0187, B:93:0x023c), top: B:575:0x00f5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zza(java.lang.String r47, long r48) {
        /*
            Method dump skipped, instruction units count: 4107
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(java.lang.String, long):boolean");
    }

    private final zzn zzb(String str) {
        zzf zzfVarZzb = zze().zzb(str);
        if (zzfVarZzb != null && !TextUtils.isEmpty(zzfVarZzb.zzl())) {
            Boolean boolZzb = zzb(zzfVarZzb);
            if (boolZzb != null && !boolZzb.booleanValue()) {
                this.zzk.zzq().zze().zza("App version does not match; dropping. appId", zzeq.zza(str));
                return null;
            }
            return new zzn(str, zzfVarZzb.zze(), zzfVarZzb.zzl(), zzfVarZzb.zzm(), zzfVarZzb.zzn(), zzfVarZzb.zzo(), zzfVarZzb.zzp(), (String) null, zzfVarZzb.zzr(), false, zzfVarZzb.zzi(), zzfVarZzb.zzae(), 0L, 0, zzfVarZzb.zzaf(), zzfVarZzb.zzag(), false, zzfVarZzb.zzf(), zzfVarZzb.zzah(), zzfVarZzb.zzq(), zzfVarZzb.zzai(), (zznv.zzb() && this.zzk.zza().zze(str, zzas.zzbi)) ? zzfVarZzb.zzg() : null, (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) ? zza(str).zza() : "");
        }
        this.zzk.zzq().zzv().zza("No app data available; dropping", str);
        return null;
    }

    final void zzb(zzz zzzVar) {
        zzn zznVarZzb = zzb(zzzVar.zza);
        if (zznVarZzb != null) {
            zzb(zzzVar, zznVarZzb);
        }
    }

    final void zzb(zzz zzzVar, zzn zznVar) {
        Preconditions.checkNotNull(zzzVar);
        Preconditions.checkNotEmpty(zzzVar.zza);
        Preconditions.checkNotNull(zzzVar.zzc);
        Preconditions.checkNotEmpty(zzzVar.zzc.zza);
        zzx();
        zzn();
        if (zze(zznVar)) {
            if (!zznVar.zzh) {
                zzc(zznVar);
                return;
            }
            zze().zze();
            try {
                zzc(zznVar);
                zzz zzzVarZzd = zze().zzd(zzzVar.zza, zzzVar.zzc.zza);
                if (zzzVarZzd != null) {
                    this.zzk.zzq().zzv().zza("Removing conditional user property", zzzVar.zza, this.zzk.zzi().zzc(zzzVar.zzc.zza));
                    zze().zze(zzzVar.zza, zzzVar.zzc.zza);
                    if (zzzVarZzd.zze) {
                        zze().zzb(zzzVar.zza, zzzVar.zzc.zza);
                    }
                    if (zzzVar.zzk != null) {
                        zzc(this.zzk.zzh().zza(zzzVar.zza, zzzVar.zzk.zza, zzzVar.zzk.zzb != null ? zzzVar.zzk.zzb.zzb() : null, zzzVarZzd.zzb, zzzVar.zzk.zzd, true, false, zzlo.zzb() && this.zzk.zza().zza(zzas.zzcl)), zznVar);
                    }
                } else {
                    this.zzk.zzq().zzh().zza("Conditional user property doesn't exist", zzeq.zza(zzzVar.zza), this.zzk.zzi().zzc(zzzVar.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    final zzf zzc(zzn zznVar) {
        zzx();
        zzn();
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.zza);
        zzf zzfVarZzb = zze().zzb(zznVar.zza);
        zzac zzacVarZzb = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzacVarZzb = zza(zznVar.zza).zzb(zzac.zza(zznVar.zzw));
        }
        String strZza = (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && !zzacVarZzb.zzc()) ? "" : this.zzj.zza(zznVar.zza);
        if (zzne.zzb() && this.zzk.zza().zza(zzas.zzbn)) {
            if (zzfVarZzb == null) {
                zzfVarZzb = new zzf(this.zzk, zznVar.zza);
                if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
                    if (zzacVarZzb.zze()) {
                        zzfVarZzb.zza(zza(zzacVarZzb));
                    }
                    if (zzacVarZzb.zzc()) {
                        zzfVarZzb.zze(strZza);
                    }
                } else {
                    zzfVarZzb.zza(zzz());
                    zzfVarZzb.zze(strZza);
                }
            } else if ((!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzacVarZzb.zzc()) && !strZza.equals(zzfVarZzb.zzh())) {
                zzfVarZzb.zze(strZza);
                if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
                    zzfVarZzb.zza(zza(zzacVarZzb));
                } else {
                    zzfVarZzb.zza(zzz());
                }
            } else if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && TextUtils.isEmpty(zzfVarZzb.zzd()) && zzacVarZzb.zze()) {
                zzfVarZzb.zza(zza(zzacVarZzb));
            }
            zzfVarZzb.zzb(zznVar.zzb);
            zzfVarZzb.zzc(zznVar.zzr);
            if (zznv.zzb() && this.zzk.zza().zze(zzfVarZzb.zzc(), zzas.zzbi)) {
                zzfVarZzb.zzd(zznVar.zzv);
            }
            if (!TextUtils.isEmpty(zznVar.zzk)) {
                zzfVarZzb.zzf(zznVar.zzk);
            }
            long j = zznVar.zze;
            if (j != 0) {
                zzfVarZzb.zzd(j);
            }
            if (!TextUtils.isEmpty(zznVar.zzc)) {
                zzfVarZzb.zzg(zznVar.zzc);
            }
            zzfVarZzb.zzc(zznVar.zzj);
            String str = zznVar.zzd;
            if (str != null) {
                zzfVarZzb.zzh(str);
            }
            zzfVarZzb.zze(zznVar.zzf);
            zzfVarZzb.zza(zznVar.zzh);
            if (!TextUtils.isEmpty(zznVar.zzg)) {
                zzfVarZzb.zzi(zznVar.zzg);
            }
            if (!this.zzk.zza().zza(zzas.zzbx)) {
                zzfVarZzb.zzp(zznVar.zzl);
            }
            zzfVarZzb.zzb(zznVar.zzo);
            zzfVarZzb.zzc(zznVar.zzp);
            zzfVarZzb.zza(zznVar.zzs);
            zzfVarZzb.zzf(zznVar.zzt);
            if (zzfVarZzb.zza()) {
                zze().zza(zzfVarZzb);
            }
            return zzfVarZzb;
        }
        return zza(zznVar, zzfVarZzb, strZza);
    }

    @VisibleForTesting
    private final void zza(zzcd.zzg.zza zzaVar, long j, boolean z) {
        zzkw zzkwVar;
        String str = z ? "_se" : "_lte";
        zzkw zzkwVarZzc = zze().zzc(zzaVar.zzj(), str);
        if (zzkwVarZzc != null && zzkwVarZzc.zze != null) {
            zzkwVar = new zzkw(zzaVar.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(((Long) zzkwVarZzc.zze).longValue() + j));
        } else {
            zzkwVar = new zzkw(zzaVar.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(j));
        }
        zzcd.zzk zzkVar = (zzcd.zzk) zzcd.zzk.zzj().zza(str).zza(this.zzk.zzl().currentTimeMillis()).zzb(((Long) zzkwVar.zze).longValue()).zzy();
        boolean z2 = false;
        int iZza = zzkr.zza(zzaVar, str);
        if (iZza >= 0) {
            zzaVar.zza(iZza, zzkVar);
            z2 = true;
        }
        if (!z2) {
            zzaVar.zza(zzkVar);
        }
        if (j > 0) {
            zze().zza(zzkwVar);
            this.zzk.zzq().zzw().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkwVar.zze);
        }
    }

    private final boolean zza(zzcd.zzc.zza zzaVar, zzcd.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        zzcd.zze zzeVarZza = zzkr.zza((zzcd.zzc) zzaVar.zzy(), "_sc");
        String strZzd = zzeVarZza == null ? null : zzeVarZza.zzd();
        zzh();
        zzcd.zze zzeVarZza2 = zzkr.zza((zzcd.zzc) zzaVar2.zzy(), "_pc");
        String strZzd2 = zzeVarZza2 != null ? zzeVarZza2.zzd() : null;
        if (strZzd2 == null || !strZzd2.equals(strZzd)) {
            return false;
        }
        zzb(zzaVar, zzaVar2);
        return true;
    }

    @VisibleForTesting
    private static void zza(zzcd.zzc.zza zzaVar, String str) {
        List<zzcd.zze> listZza = zzaVar.zza();
        for (int i = 0; i < listZza.size(); i++) {
            if (str.equals(listZza.get(i).zzb())) {
                zzaVar.zzb(i);
                return;
            }
        }
    }

    @VisibleForTesting
    private static void zza(zzcd.zzc.zza zzaVar, int i, String str) {
        List<zzcd.zze> listZza = zzaVar.zza();
        for (int i2 = 0; i2 < listZza.size(); i2++) {
            if ("_err".equals(listZza.get(i2).zzb())) {
                return;
            }
        }
        zzaVar.zza((zzcd.zze) zzcd.zze.zzm().zza("_err").zza(Long.valueOf(i).longValue()).zzy()).zza((zzcd.zze) zzcd.zze.zzm().zza("_ev").zzb(str).zzy());
    }

    @VisibleForTesting
    final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzx();
        zzn();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzs = false;
                zzac();
            }
        }
        List<Long> list = this.zzw;
        this.zzw = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
                this.zzk.zzb().zzd.zza(0L);
                zzab();
                this.zzk.zzq().zzw().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zze();
                try {
                    for (Long l : list) {
                        try {
                            zzaf zzafVarZze = zze();
                            long jLongValue = l.longValue();
                            zzafVarZze.zzc();
                            zzafVarZze.zzaj();
                            try {
                                if (zzafVarZze.c_().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e2) {
                                zzafVarZze.zzq().zze().zza("Failed to delete a bundle in a queue table", e2);
                                throw e2;
                            }
                        } catch (SQLiteException e3) {
                            if (this.zzx == null || !this.zzx.contains(l)) {
                                throw e3;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzg();
                    this.zzx = null;
                    if (zzd().zze() && zzaa()) {
                        zzo();
                    } else {
                        this.zzy = -1L;
                        zzab();
                    }
                    this.zzn = 0L;
                } catch (Throwable th2) {
                    zze().zzg();
                    throw th2;
                }
            } catch (SQLiteException e4) {
                this.zzk.zzq().zze().zza("Database error while trying to delete uploaded bundles", e4);
                this.zzn = this.zzk.zzl().elapsedRealtime();
                this.zzk.zzq().zzw().zza("Disable upload, time", Long.valueOf(this.zzn));
            }
        } else {
            this.zzk.zzq().zzw().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzb().zzd.zza(this.zzk.zzl().currentTimeMillis());
            if (i != 503 && i != 429) {
                z = false;
            }
            if (z) {
                this.zzk.zzb().zze.zza(this.zzk.zzl().currentTimeMillis());
            }
            zze().zza(list);
            zzab();
        }
    }

    private final void zza(zzf zzfVar) {
        b bVar;
        zzx();
        if (zznv.zzb() && this.zzk.zza().zze(zzfVar.zzc(), zzas.zzbi)) {
            if (TextUtils.isEmpty(zzfVar.zze()) && TextUtils.isEmpty(zzfVar.zzg()) && TextUtils.isEmpty(zzfVar.zzf())) {
                zza(zzfVar.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzfVar.zze()) && TextUtils.isEmpty(zzfVar.zzf())) {
            zza(zzfVar.zzc(), 204, null, null, null);
            return;
        }
        String strZza = this.zzk.zza().zza(zzfVar);
        try {
            URL url = new URL(strZza);
            this.zzk.zzq().zzw().zza("Fetching remote configuration", zzfVar.zzc());
            zzca.zzb zzbVarZza = zzc().zza(zzfVar.zzc());
            String strZzb = zzc().zzb(zzfVar.zzc());
            if (zzbVarZza == null || TextUtils.isEmpty(strZzb)) {
                bVar = null;
            } else {
                b bVar2 = new b();
                bVar2.put("If-Modified-Since", strZzb);
                bVar = bVar2;
            }
            this.zzr = true;
            zzex zzexVarZzd = zzd();
            String strZzc = zzfVar.zzc();
            zzkm zzkmVar = new zzkm(this);
            zzexVarZzd.zzc();
            zzexVarZzd.zzaj();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkmVar);
            zzexVarZzd.zzp().zzc(new zzfb(zzexVarZzd, strZzc, url, null, bVar, zzkmVar));
        } catch (MalformedURLException unused) {
            this.zzk.zzq().zze().zza("Failed to parse config URL. Not fetching. appId", zzeq.zza(zzfVar.zzc()), strZza);
        }
    }

    @VisibleForTesting
    final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzx();
        zzn();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzr = false;
                zzac();
            }
        }
        this.zzk.zzq().zzw().zza("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zze().zze();
        try {
            zzf zzfVarZzb = zze().zzb(str);
            boolean z = true;
            boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
            if (zzfVarZzb == null) {
                this.zzk.zzq().zzh().zza("App does not exist in onConfigFetched. appId", zzeq.zza(str));
            } else if (!z2 && i != 404) {
                zzfVarZzb.zzi(this.zzk.zzl().currentTimeMillis());
                zze().zza(zzfVarZzb);
                this.zzk.zzq().zzw().zza("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzc().zzc(str);
                this.zzk.zzb().zzd.zza(this.zzk.zzl().currentTimeMillis());
                if (i != 503 && i != 429) {
                    z = false;
                }
                if (z) {
                    this.zzk.zzb().zze.zza(this.zzk.zzl().currentTimeMillis());
                }
                zzab();
            } else {
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i != 404 && i != 304) {
                    if (!zzc().zza(str, bArr, str2)) {
                        return;
                    }
                } else if (zzc().zza(str) == null && !zzc().zza(str, null, null)) {
                    return;
                }
                zzfVarZzb.zzh(this.zzk.zzl().currentTimeMillis());
                zze().zza(zzfVarZzb);
                if (i == 404) {
                    this.zzk.zzq().zzj().zza("Config not found. Using empty config. appId", str);
                } else {
                    this.zzk.zzq().zzw().zza("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (zzd().zze() && zzaa()) {
                    zzo();
                } else {
                    zzab();
                }
            }
            zze().b_();
        } finally {
            zze().zzg();
        }
    }

    final void zza(Runnable runnable) {
        zzx();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzx();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int i = fileChannel.read(byteBufferAllocate);
                if (i == 4) {
                    byteBufferAllocate.flip();
                    return byteBufferAllocate.getInt();
                }
                if (i != -1) {
                    this.zzk.zzq().zzh().zza("Unexpected data length. Bytes read", Integer.valueOf(i));
                }
                return 0;
            } catch (IOException e2) {
                this.zzk.zzq().zze().zza("Failed to read from channel", e2);
                return 0;
            }
        }
        this.zzk.zzq().zze().zza("Bad channel to read from");
        return 0;
    }

    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzx();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.putInt(i);
            byteBufferAllocate.flip();
            try {
                fileChannel.truncate(0L);
                if (this.zzk.zza().zza(zzas.zzbr) && Build.VERSION.SDK_INT <= 19) {
                    fileChannel.position(0L);
                }
                fileChannel.write(byteBufferAllocate);
                fileChannel.force(true);
                if (fileChannel.size() != 4) {
                    this.zzk.zzq().zze().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
                }
                return true;
            } catch (IOException e2) {
                this.zzk.zzq().zze().zza("Failed to write to channel", e2);
                return false;
            }
        }
        this.zzk.zzq().zze().zza("Bad channel to read from");
        return false;
    }

    @VisibleForTesting
    final void zza(zzn zznVar) {
        if (this.zzw != null) {
            this.zzx = new ArrayList();
            this.zzx.addAll(this.zzw);
        }
        zzaf zzafVarZze = zze();
        String str = zznVar.zza;
        Preconditions.checkNotEmpty(str);
        zzafVarZze.zzc();
        zzafVarZze.zzaj();
        try {
            SQLiteDatabase sQLiteDatabaseC_ = zzafVarZze.c_();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseC_.delete("apps", "app_id=?", strArr) + 0 + sQLiteDatabaseC_.delete(com.umeng.analytics.pro.b.ao, "app_id=?", strArr) + sQLiteDatabaseC_.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseC_.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseC_.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseC_.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseC_.delete("queue", "app_id=?", strArr) + sQLiteDatabaseC_.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseC_.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseC_.delete("default_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                zzafVarZze.zzq().zzw().zza("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e2) {
            zzafVarZze.zzq().zze().zza("Error resetting analytics data. appId, error", zzeq.zza(str), e2);
        }
        if (zznVar.zzh) {
            zzb(zznVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zza(com.google.android.gms.measurement.internal.zzku r14, com.google.android.gms.measurement.internal.zzn r15) {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(com.google.android.gms.measurement.internal.zzku, com.google.android.gms.measurement.internal.zzn):void");
    }

    final void zza(zzki zzkiVar) {
        this.zzp++;
    }

    final void zza(zzz zzzVar) {
        zzn zznVarZzb = zzb(zzzVar.zza);
        if (zznVarZzb != null) {
            zza(zzzVar, zznVarZzb);
        }
    }

    final void zza(zzz zzzVar, zzn zznVar) {
        Preconditions.checkNotNull(zzzVar);
        Preconditions.checkNotEmpty(zzzVar.zza);
        Preconditions.checkNotNull(zzzVar.zzb);
        Preconditions.checkNotNull(zzzVar.zzc);
        Preconditions.checkNotEmpty(zzzVar.zzc.zza);
        zzx();
        zzn();
        if (zze(zznVar)) {
            if (!zznVar.zzh) {
                zzc(zznVar);
                return;
            }
            zzz zzzVar2 = new zzz(zzzVar);
            boolean z = false;
            zzzVar2.zze = false;
            zze().zze();
            try {
                zzz zzzVarZzd = zze().zzd(zzzVar2.zza, zzzVar2.zzc.zza);
                if (zzzVarZzd != null && !zzzVarZzd.zzb.equals(zzzVar2.zzb)) {
                    this.zzk.zzq().zzh().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzk.zzi().zzc(zzzVar2.zzc.zza), zzzVar2.zzb, zzzVarZzd.zzb);
                }
                if (zzzVarZzd != null && zzzVarZzd.zze) {
                    zzzVar2.zzb = zzzVarZzd.zzb;
                    zzzVar2.zzd = zzzVarZzd.zzd;
                    zzzVar2.zzh = zzzVarZzd.zzh;
                    zzzVar2.zzf = zzzVarZzd.zzf;
                    zzzVar2.zzi = zzzVarZzd.zzi;
                    zzzVar2.zze = zzzVarZzd.zze;
                    zzzVar2.zzc = new zzku(zzzVar2.zzc.zza, zzzVarZzd.zzc.zzb, zzzVar2.zzc.zza(), zzzVarZzd.zzc.zze);
                } else if (TextUtils.isEmpty(zzzVar2.zzf)) {
                    zzzVar2.zzc = new zzku(zzzVar2.zzc.zza, zzzVar2.zzd, zzzVar2.zzc.zza(), zzzVar2.zzc.zze);
                    zzzVar2.zze = true;
                    z = true;
                }
                if (zzzVar2.zze) {
                    zzku zzkuVar = zzzVar2.zzc;
                    zzkw zzkwVar = new zzkw(zzzVar2.zza, zzzVar2.zzb, zzkuVar.zza, zzkuVar.zzb, zzkuVar.zza());
                    if (zze().zza(zzkwVar)) {
                        this.zzk.zzq().zzv().zza("User property updated immediately", zzzVar2.zza, this.zzk.zzi().zzc(zzkwVar.zzc), zzkwVar.zze);
                    } else {
                        this.zzk.zzq().zze().zza("(2)Too many active user properties, ignoring", zzeq.zza(zzzVar2.zza), this.zzk.zzi().zzc(zzkwVar.zzc), zzkwVar.zze);
                    }
                    if (z && zzzVar2.zzi != null) {
                        zzc(new zzaq(zzzVar2.zzi, zzzVar2.zzd), zznVar);
                    }
                }
                if (zze().zza(zzzVar2)) {
                    this.zzk.zzq().zzv().zza("Conditional property added", zzzVar2.zza, this.zzk.zzi().zzc(zzzVar2.zzc.zza), zzzVar2.zzc.zza());
                } else {
                    this.zzk.zzq().zze().zza("Too many conditional properties, ignoring", zzeq.zza(zzzVar2.zza), this.zzk.zzi().zzc(zzzVar2.zzc.zza), zzzVar2.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.measurement.internal.zzf zza(com.google.android.gms.measurement.internal.zzn r9, com.google.android.gms.measurement.internal.zzf r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(com.google.android.gms.measurement.internal.zzn, com.google.android.gms.measurement.internal.zzf, java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    final void zza(boolean z) {
        zzab();
    }
}

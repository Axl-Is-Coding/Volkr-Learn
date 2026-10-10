package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzua;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzts {
    private final zztx zzbvw;
    private final zzua.zzi.zza zzbvx;
    private final boolean zzbvy;

    public zzts(zztx zztxVar) {
        this.zzbvx = zzua.zzi.zzob();
        this.zzbvw = zztxVar;
        this.zzbvy = ((Boolean) zzwm.zzpx().zzd(zzabb.zzctw)).booleanValue();
    }

    private final synchronized void zzb(zztu.zza.zzb zzbVar) {
        this.zzbvx.zznx().zza(zznb());
        this.zzbvw.zzf(((zzua.zzi) ((zzejz) this.zzbvx.zzbgt())).toByteArray()).zzby(zzbVar.zzv()).zzdx();
        String strValueOf = String.valueOf(Integer.toString(zzbVar.zzv(), 10));
        zzayp.zzei(strValueOf.length() != 0 ? "Logging Event with event code : ".concat(strValueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zztu.zza.zzb zzbVar) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(zzd(zzbVar).getBytes());
                } catch (IOException unused) {
                    zzayp.zzei("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        zzayp.zzei("Could not close Clearcut output stream.");
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    zzayp.zzei("Could not close Clearcut output stream.");
                }
            }
        } catch (FileNotFoundException unused4) {
            zzayp.zzei("Could not find file for Clearcut");
        }
    }

    private final synchronized String zzd(zztu.zza.zzb zzbVar) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.zzbvx.zznw(), Long.valueOf(com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime()), Integer.valueOf(zzbVar.zzv()), Base64.encodeToString(((zzua.zzi) ((zzejz) this.zzbvx.zzbgt())).toByteArray(), 3));
    }

    public static zzts zzna() {
        return new zzts();
    }

    private static List<Long> zznb() {
        List<String> listZzrh = zzabb.zzrh();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listZzrh.iterator();
        while (it.hasNext()) {
            for (String str : it.next().split(",")) {
                try {
                    arrayList.add(Long.valueOf(str));
                } catch (NumberFormatException unused) {
                    zzayp.zzei("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public final synchronized void zza(zztu.zza.zzb zzbVar) {
        if (this.zzbvy) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzctx)).booleanValue()) {
                zzc(zzbVar);
            } else {
                zzb(zzbVar);
            }
        }
    }

    private zzts() {
        this.zzbvx = zzua.zzi.zzob();
        this.zzbvy = false;
        this.zzbvw = new zztx();
    }

    public final synchronized void zza(zztr zztrVar) {
        if (this.zzbvy) {
            try {
                zztrVar.zza(this.zzbvx);
            } catch (NullPointerException e2) {
                com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AdMobClearcutLogger.modify");
            }
        }
    }
}

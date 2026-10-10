package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdva {
    private static final Object zzhok = new Object();
    private final SharedPreferences zzcln;
    private final String zzhoj;
    private final Context zzvr;

    public zzdva(Context context, zzgo zzgoVar) {
        this.zzvr = context;
        this.zzhoj = Integer.toString(zzgoVar.zzv());
        this.zzcln = context.getSharedPreferences("pcvmspf", 0);
    }

    private final String zzawt() {
        String strValueOf = String.valueOf(this.zzhoj);
        return strValueOf.length() != 0 ? "FBAMTD".concat(strValueOf) : new String("FBAMTD");
    }

    private final String zzawu() {
        String strValueOf = String.valueOf(this.zzhoj);
        return strValueOf.length() != 0 ? "LATMTD".concat(strValueOf) : new String("LATMTD");
    }

    private static String zzb(zzgq zzgqVar) {
        return Hex.bytesToStringLowercase(((zzgr) zzgr.zzdl().zzaw(zzgqVar.zzdc().zzdg()).zzax(zzgqVar.zzdc().zzdh()).zzdk(zzgqVar.zzdc().zzdj()).zzdl(zzgqVar.zzdc().zzdk()).zzdj(zzgqVar.zzdc().zzdi()).zzbgt()).zzbdw().toByteArray());
    }

    private final zzgr zzei(int i) {
        String string = i == zzduz.zzhof ? this.zzcln.getString(zzawu(), null) : i == zzduz.zzhog ? this.zzcln.getString(zzawt(), null) : null;
        if (string == null) {
            return null;
        }
        try {
            return zzgr.zzb(zzeip.zzu(Hex.stringToBytes(string)), zzejm.zzbfu());
        } catch (zzekj unused) {
            return null;
        }
    }

    private final File zzhg(String str) {
        return new File(new File(this.zzvr.getDir("pccache", 0), this.zzhoj), str);
    }

    public final boolean zza(zzgq zzgqVar, zzdux zzduxVar) {
        synchronized (zzhok) {
            zzgr zzgrVarZzei = zzei(zzduz.zzhof);
            String strZzdg = zzgqVar.zzdc().zzdg();
            if (zzgrVarZzei != null && zzgrVarZzei.zzdg().equals(strZzdg)) {
                return false;
            }
            if (!zzhg(strZzdg).mkdirs()) {
                return false;
            }
            File fileZzhg = zzhg(strZzdg);
            File file = new File(fileZzhg, "pcam");
            File file2 = new File(fileZzhg, "pcbc");
            if (!zzduu.zza(file, zzgqVar.zzdd().toByteArray())) {
                return false;
            }
            if (!zzduu.zza(file2, zzgqVar.zzde().toByteArray())) {
                return false;
            }
            if (zzduxVar != null && !zzduxVar.zzb(file)) {
                zzduu.zze(fileZzhg);
                return false;
            }
            String strZzb = zzb(zzgqVar);
            String string = this.zzcln.getString(zzawu(), null);
            SharedPreferences.Editor editorEdit = this.zzcln.edit();
            editorEdit.putString(zzawu(), strZzb);
            if (string != null) {
                editorEdit.putString(zzawt(), string);
            }
            if (!editorEdit.commit()) {
                return false;
            }
            HashSet hashSet = new HashSet();
            zzgr zzgrVarZzei2 = zzei(zzduz.zzhof);
            if (zzgrVarZzei2 != null) {
                hashSet.add(zzgrVarZzei2.zzdg());
            }
            zzgr zzgrVarZzei3 = zzei(zzduz.zzhog);
            if (zzgrVarZzei3 != null) {
                hashSet.add(zzgrVarZzei3.zzdg());
            }
            for (File file3 : new File(this.zzvr.getDir("pccache", 0), this.zzhoj).listFiles()) {
                if (!hashSet.contains(file3.getName())) {
                    zzduu.zze(file3);
                }
            }
            return true;
        }
    }

    public final zzdus zzp(int i) {
        synchronized (zzhok) {
            zzgr zzgrVarZzei = zzei(i);
            if (zzgrVarZzei == null) {
                return null;
            }
            File fileZzhg = zzhg(zzgrVarZzei.zzdg());
            return new zzdus(zzgrVarZzei, new File(fileZzhg, "pcam"), new File(fileZzhg, "pcbc"), new File(fileZzhg, "pcopt"));
        }
    }

    public final boolean zza(zzgq zzgqVar) {
        synchronized (zzhok) {
            if (!zzduu.zza(new File(zzhg(zzgqVar.zzdc().zzdg()), "pcbc"), zzgqVar.zzde().toByteArray())) {
                return false;
            }
            String strZzb = zzb(zzgqVar);
            SharedPreferences.Editor editorEdit = this.zzcln.edit();
            editorEdit.putString(zzawu(), strZzb);
            return editorEdit.commit();
        }
    }
}

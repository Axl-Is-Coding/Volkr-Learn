package com.google.android.gms.iid;

import a.a.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzak {
    private SharedPreferences zzcz;
    private final zzn zzda;
    private final Map<String, zzo> zzdb;
    private Context zzk;

    public zzak(Context context) {
        this(context, new zzn());
    }

    @VisibleForTesting
    private zzak(Context context, zzn zznVar) {
        this.zzdb = new b();
        this.zzk = context;
        this.zzcz = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzda = zznVar;
        File file = new File(androidx.core.content.b.c(this.zzk), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || isEmpty()) {
                return;
            }
            Log.i("InstanceID/Store", "App restored, clearing state");
            InstanceIDListenerService.zzd(this.zzk, this);
        } catch (IOException e2) {
            if (Log.isLoggable("InstanceID/Store", 3)) {
                String strValueOf = String.valueOf(e2.getMessage());
                Log.d("InstanceID/Store", strValueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    private static String zzd(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    static String zzh(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    final synchronized String get(String str) {
        return this.zzcz.getString(str, null);
    }

    public final boolean isEmpty() {
        return this.zzcz.getAll().isEmpty();
    }

    public final synchronized void zzd(String str, String str2, String str3, String str4, String str5) {
        String strZzd = zzd(str, str2, str3);
        SharedPreferences.Editor editorEdit = this.zzcz.edit();
        editorEdit.putString(strZzd, str4);
        editorEdit.putString("appVersion", str5);
        editorEdit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        editorEdit.commit();
    }

    public final synchronized String zze(String str, String str2, String str3) {
        return this.zzcz.getString(zzd(str, str2, str3), null);
    }

    public final synchronized void zzf(String str, String str2, String str3) {
        String strZzd = zzd(str, str2, str3);
        SharedPreferences.Editor editorEdit = this.zzcz.edit();
        editorEdit.remove(strZzd);
        editorEdit.commit();
    }

    public final synchronized void zzi(String str) {
        SharedPreferences.Editor editorEdit = this.zzcz.edit();
        for (String str2 : this.zzcz.getAll().keySet()) {
            if (str2.startsWith(str)) {
                editorEdit.remove(str2);
            }
        }
        editorEdit.commit();
    }

    public final synchronized zzo zzj(String str) {
        zzo zzoVarZzf;
        zzo zzoVar = this.zzdb.get(str);
        if (zzoVar != null) {
            return zzoVar;
        }
        try {
            zzoVarZzf = this.zzda.zze(this.zzk, str);
        } catch (zzp unused) {
            Log.w("InstanceID/Store", "Stored data is corrupt, generating new identity");
            InstanceIDListenerService.zzd(this.zzk, this);
            zzoVarZzf = this.zzda.zzf(this.zzk, str);
        }
        this.zzdb.put(str, zzoVarZzf);
        return zzoVarZzf;
    }

    final void zzk(String str) {
        synchronized (this) {
            this.zzdb.remove(str);
        }
        zzn.zzg(this.zzk, str);
        zzi(String.valueOf(str).concat("|"));
    }

    public final synchronized void zzx() {
        this.zzdb.clear();
        zzn.zzi(this.zzk);
        this.zzcz.edit().clear().commit();
    }
}

package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdc {
    public static zzdy<zzdd> zza(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
            z = true;
        }
        if (!z) {
            return zzdy.zzc();
        }
        if (zzcr.zza() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzdy<File> zzdyVarZzb = zzb(context);
        return zzdyVarZzb.zza() ? zzdy.zza(zza(zzdyVarZzb.zzb())) : zzdy.zzc();
    }

    private static zzdy<File> zzb(Context context) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? zzdy.zza(file) : zzdy.zzc();
        } catch (RuntimeException e2) {
            Log.e("HermeticFileOverrides", "no data dir", e2);
            return zzdy.zzc();
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private static zzdd zza(File file) {
        BufferedReader bufferedReader;
        HashMap map;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                map = new HashMap();
            } finally {
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                String[] strArrSplit = line.split(" ", 3);
                if (strArrSplit.length != 3) {
                    String strValueOf = String.valueOf(line);
                    Log.e("HermeticFileOverrides", strValueOf.length() != 0 ? "Invalid: ".concat(strValueOf) : new String("Invalid: "));
                } else {
                    String str = strArrSplit[0];
                    String strDecode = Uri.decode(strArrSplit[1]);
                    String strDecode2 = Uri.decode(strArrSplit[2]);
                    if (!map.containsKey(str)) {
                        map.put(str, new HashMap());
                    }
                    ((Map) map.get(str)).put(strDecode, strDecode2);
                }
            } else {
                String strValueOf2 = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf2).length() + 7);
                sb.append("Parsed ");
                sb.append(strValueOf2);
                Log.i("HermeticFileOverrides", sb.toString());
                zzdd zzddVar = new zzdd(map);
                bufferedReader.close();
                return zzddVar;
            }
            throw new RuntimeException(e2);
        }
    }
}

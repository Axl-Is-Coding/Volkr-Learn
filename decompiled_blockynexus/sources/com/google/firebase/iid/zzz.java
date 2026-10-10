package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* JADX INFO: loaded from: classes2.dex */
final class zzz {
    zzz() {
    }

    static void zza(Context context) {
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private final zzy zzd(Context context, String str) throws Throwable {
        try {
            zzy zzyVarZze = zze(context, str);
            if (zzyVarZze != null) {
                zza(context, str, zzyVarZze);
                return zzyVarZze;
            }
            e = null;
        } catch (zzaa e2) {
            e = e2;
        }
        try {
            zzy zzyVarZza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
            if (zzyVarZza != null) {
                zza(context, str, zzyVarZza, false);
                return zzyVarZza;
            }
        } catch (zzaa e3) {
            e = e3;
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    private final zzy zze(Context context, String str) throws zzaa {
        File fileZzf = zzf(context, str);
        if (!fileZzf.exists()) {
            return null;
        }
        try {
            return zza(fileZzf);
        } catch (zzaa | IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(strValueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            try {
                return zza(fileZzf);
            } catch (IOException e3) {
                String strValueOf2 = String.valueOf(e3);
                StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(strValueOf2);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new zzaa(e3);
            }
        }
    }

    private static File zzf(Context context, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = "com.google.InstanceId.properties";
        } else {
            try {
                String strEncodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(strEncodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(strEncodeToString);
                sb.append(".properties");
                string = sb.toString();
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return new File(zzb(context), string);
    }

    final zzy zzb(Context context, String str) throws Throwable {
        zzy zzyVarZzd = zzd(context, str);
        return zzyVarZzd != null ? zzyVarZzd : zzc(context, str);
    }

    final zzy zzc(Context context, String str) throws Throwable {
        zzy zzyVar = new zzy(zza.zzc(), System.currentTimeMillis());
        zzy zzyVarZza = zza(context, str, zzyVar, true);
        if (zzyVarZza != null && !zzyVarZza.equals(zzyVar)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
            }
            return zzyVarZza;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Generated new key");
        }
        zza(context, str, zzyVar);
        return zzyVar;
    }

    private static File zzb(Context context) {
        File fileC = b.c(context);
        if (fileC != null && fileC.isDirectory()) {
            return fileC;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad A[Catch: all -> 0x00b1, Throwable -> 0x00b4, TRY_ENTER, TryCatch #9 {all -> 0x00b1, Throwable -> 0x00b4, blocks: (B:7:0x0041, B:15:0x005d, B:26:0x009b, B:36:0x00ad, B:37:0x00b0), top: B:54:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[Catch: all -> 0x00b1, Throwable -> 0x00b4, SYNTHETIC, TRY_LEAVE, TryCatch #9 {all -> 0x00b1, Throwable -> 0x00b4, blocks: (B:7:0x0041, B:15:0x005d, B:26:0x009b, B:36:0x00ad, B:37:0x00b0), top: B:54:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.firebase.iid.zzy zza(android.content.Context r10, java.lang.String r11, com.google.firebase.iid.zzy r12, boolean r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzz.zza(android.content.Context, java.lang.String, com.google.firebase.iid.zzy, boolean):com.google.firebase.iid.zzy");
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzav.zzd(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private static KeyPair zzc(String str, String str2) throws zzaa {
        try {
            byte[] bArrDecode = Base64.decode(str, 8);
            byte[] bArrDecode2 = Base64.decode(str2, 8);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(bArrDecode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArrDecode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
                String strValueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(strValueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzaa(e2);
            }
        } catch (IllegalArgumentException e3) {
            throw new zzaa(e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e A[Catch: all -> 0x0032, Throwable -> 0x0034, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0006, B:7:0x001c, B:17:0x002e, B:18:0x0031), top: B:25:0x0006, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[Catch: all -> 0x0032, Throwable -> 0x0034, SYNTHETIC, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0006, B:7:0x001c, B:17:0x002e, B:18:0x0031), top: B:25:0x0006, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.firebase.iid.zzy zza(java.io.File r10) throws java.io.IOException, com.google.firebase.iid.zzaa {
        /*
            r9 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r10)
            r10 = 0
            java.nio.channels.FileChannel r7 = r0.getChannel()     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
            r2 = 0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = 1
            r1 = r7
            r1.lock(r2, r4, r6)     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L26
            com.google.firebase.iid.zzy r1 = zza(r7)     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L26
            if (r7 == 0) goto L1f
            zza(r10, r7)     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
        L1f:
            zza(r10, r0)
            return r1
        L23:
            r1 = move-exception
            r2 = r10
            goto L2c
        L26:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L28
        L28:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
        L2c:
            if (r7 == 0) goto L31
            zza(r2, r7)     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
        L31:
            throw r1     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
        L32:
            r1 = move-exception
            goto L36
        L34:
            r10 = move-exception
            throw r10     // Catch: java.lang.Throwable -> L32
        L36:
            zza(r10, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzz.zza(java.io.File):com.google.firebase.iid.zzy");
    }

    private static zzy zza(FileChannel fileChannel) throws IOException, zzaa {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property != null && property2 != null) {
            try {
                return new zzy(zzc(property, property2), Long.parseLong(properties.getProperty("cre")));
            } catch (NumberFormatException e2) {
                throw new zzaa(e2);
            }
        }
        throw new zzaa("Invalid properties file");
    }

    private static zzy zza(SharedPreferences sharedPreferences, String str) throws zzaa {
        String string = sharedPreferences.getString(zzav.zzd(str, "|P|"), null);
        String string2 = sharedPreferences.getString(zzav.zzd(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new zzy(zzc(string, string2), zzb(sharedPreferences, str));
    }

    private final void zza(Context context, String str, zzy zzyVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzyVar.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzaa unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(zzav.zzd(str, "|P|"), zzyVar.zzv());
        editorEdit.putString(zzav.zzd(str, "|K|"), zzyVar.zzw());
        editorEdit.putString(zzav.zzd(str, "cre"), String.valueOf(zzyVar.zzbx));
        editorEdit.commit();
    }

    private static /* synthetic */ void zza(Throwable th, FileChannel fileChannel) {
        if (th == null) {
            fileChannel.close();
            return;
        }
        try {
            fileChannel.close();
        } catch (Throwable th2) {
            com.google.android.gms.internal.firebase_messaging.zzn.zza(th, th2);
        }
    }

    private static /* synthetic */ void zza(Throwable th, RandomAccessFile randomAccessFile) throws IOException {
        if (th == null) {
            randomAccessFile.close();
            return;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable th2) {
            com.google.android.gms.internal.firebase_messaging.zzn.zza(th, th2);
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) throws IOException {
        if (th == null) {
            fileInputStream.close();
            return;
        }
        try {
            fileInputStream.close();
        } catch (Throwable th2) {
            com.google.android.gms.internal.firebase_messaging.zzn.zza(th, th2);
        }
    }
}

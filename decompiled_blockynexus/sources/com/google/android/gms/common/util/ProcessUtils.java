package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class ProcessUtils {
    private static String zza;
    private static int zzb;

    private ProcessUtils() {
    }

    @KeepForSdk
    public static String getMyProcessName() {
        if (zza == null) {
            if (zzb == 0) {
                zzb = Process.myPid();
            }
            zza = zza(zzb);
        }
        return zza;
    }

    private static String zza(int i) throws Throwable {
        BufferedReader bufferedReaderZza;
        BufferedReader bufferedReader = null;
        String strTrim = null;
        if (i <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReaderZza = zza(sb.toString());
        } catch (IOException unused) {
            bufferedReaderZza = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            strTrim = bufferedReaderZza.readLine().trim();
            IOUtils.closeQuietly(bufferedReaderZza);
        } catch (IOException unused2) {
            IOUtils.closeQuietly(bufferedReaderZza);
        } catch (Throwable th2) {
            bufferedReader = bufferedReaderZza;
            th = th2;
            IOUtils.closeQuietly(bufferedReader);
            throw th;
        }
        return strTrim;
    }

    private static BufferedReader zza(String str) throws IOException {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}

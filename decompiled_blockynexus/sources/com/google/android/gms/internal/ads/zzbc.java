package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbc {
    public static zzn zzb(zzy zzyVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzyVar.zzam;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long jZzg = str != null ? zzg(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            j = 0;
            int i2 = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long jZzg2 = str3 != null ? zzg(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long jZzg3 = str4 != null ? zzg(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j3 = jCurrentTimeMillis + (j * 1000);
            if (i != 0) {
                j4 = j3;
            } else {
                Long.signum(j2);
                j4 = (j2 * 1000) + j3;
            }
        } else if (jZzg <= 0 || jZzg2 < jZzg) {
            j3 = 0;
            j4 = j3;
        } else {
            j4 = (jZzg2 - jZzg) + jCurrentTimeMillis;
            j3 = j4;
        }
        zzn zznVar = new zzn();
        zznVar.data = zzyVar.data;
        zznVar.zzr = str5;
        zznVar.zzv = j3;
        zznVar.zzu = j4;
        zznVar.zzs = jZzg;
        zznVar.zzt = jZzg3;
        zznVar.zzw = map;
        zznVar.zzx = zzyVar.allHeaders;
        return zznVar;
    }

    private static long zzg(String str) {
        try {
            return zzh("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e2) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzaq.v("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzaq.zza(e2, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    private static SimpleDateFormat zzh(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    static String zzb(long j) {
        return zzh("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }
}

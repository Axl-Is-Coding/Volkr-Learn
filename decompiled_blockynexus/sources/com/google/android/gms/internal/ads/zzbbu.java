package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbbu implements zzbbl {
    private final String zzbij;

    public zzbbu() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbbl
    public final void zzes(String str) {
        try {
            try {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.setThreadStatsTag(263);
                }
                String strValueOf = String.valueOf(str);
                zzbbq.zzef(strValueOf.length() != 0 ? "Pinging URL: ".concat(strValueOf) : new String("Pinging URL: "));
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    zzwm.zzpt();
                    zzbbg.zza(true, httpURLConnection, this.zzbij);
                    zzbbk zzbbkVar = new zzbbk();
                    zzbbkVar.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzbbkVar.zza(httpURLConnection, responseCode);
                    if (responseCode < 200 || responseCode >= 300) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                        sb.append("Received non-success response code ");
                        sb.append(responseCode);
                        sb.append(" from pinging URL: ");
                        sb.append(str);
                        zzbbq.zzfe(sb.toString());
                    }
                    if (ClientLibraryUtils.isPackageSide()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e2) {
                String message = e2.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length());
                sb2.append("Error while pinging URL: ");
                sb2.append(str);
                sb2.append(". ");
                sb2.append(message);
                zzbbq.zzfe(sb2.toString());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IndexOutOfBoundsException e3) {
                String message2 = e3.getMessage();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message2).length());
                sb3.append("Error while parsing ping URL: ");
                sb3.append(str);
                sb3.append(". ");
                sb3.append(message2);
                zzbbq.zzfe(sb3.toString());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (RuntimeException e4) {
                String message3 = e4.getMessage();
                StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length());
                sb4.append("Error while pinging URL: ");
                sb4.append(str);
                sb4.append(". ");
                sb4.append(message3);
                zzbbq.zzfe(sb4.toString());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            }
        } catch (Throwable th) {
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th;
        }
    }

    public zzbbu(String str) {
        this.zzbij = str;
    }
}

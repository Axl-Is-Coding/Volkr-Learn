package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabs {
    private zzabs zzczp;
    private final List<zzabq> zzczn = new LinkedList();
    private final Map<String, String> zzczo = new LinkedHashMap();
    private final Object lock = new Object();

    @VisibleForTesting
    boolean zzczm = true;

    public zzabs(boolean z, String str, String str2) {
        this.zzczo.put("action", str);
        this.zzczo.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public final boolean zza(zzabq zzabqVar, long j, String... strArr) {
        synchronized (this.lock) {
            for (String str : strArr) {
                this.zzczn.add(new zzabq(j, str, zzabqVar));
            }
        }
        return true;
    }

    public final void zzc(zzabs zzabsVar) {
        synchronized (this.lock) {
            this.zzczp = zzabsVar;
        }
    }

    public final zzabq zzex(long j) {
        if (this.zzczm) {
            return new zzabq(j, null, null);
        }
        return null;
    }

    public final void zzh(String str, String str2) {
        zzabi zzabiVarZzwn;
        if (!this.zzczm || TextUtils.isEmpty(str2) || (zzabiVarZzwn = com.google.android.gms.ads.internal.zzp.zzkv().zzwn()) == null) {
            return;
        }
        synchronized (this.lock) {
            zzabm zzabmVarZzcu = zzabiVarZzwn.zzcu(str);
            Map<String, String> map = this.zzczo;
            map.put(str, zzabmVarZzcu.zzg(map.get(str), str2));
        }
    }

    public final String zzrt() {
        String string;
        StringBuilder sb = new StringBuilder();
        synchronized (this.lock) {
            for (zzabq zzabqVar : this.zzczn) {
                long time = zzabqVar.getTime();
                String strZzrq = zzabqVar.zzrq();
                zzabq zzabqVarZzrr = zzabqVar.zzrr();
                if (zzabqVarZzrr != null && time > 0) {
                    long time2 = time - zzabqVarZzrr.getTime();
                    sb.append(strZzrq);
                    sb.append('.');
                    sb.append(time2);
                    sb.append(',');
                }
            }
            this.zzczn.clear();
            if (!TextUtils.isEmpty(null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            string = sb.toString();
        }
        return string;
    }

    @VisibleForTesting
    final Map<String, String> zzru() {
        synchronized (this.lock) {
            zzabi zzabiVarZzwn = com.google.android.gms.ads.internal.zzp.zzkv().zzwn();
            if (zzabiVarZzwn != null && this.zzczp != null) {
                return zzabiVarZzwn.zza(this.zzczo, this.zzczp.zzru());
            }
            return this.zzczo;
        }
    }
}

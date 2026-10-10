package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagy implements zzahq<zzbgj> {
    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        zzbgj zzbgjVar2 = zzbgjVar;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_LABEL);
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzbbq.zzfe("No label given for CSI tick.");
                return;
            }
            if (TextUtils.isEmpty(str4)) {
                zzbbq.zzfe("No timestamp given for CSI tick.");
                return;
            }
            try {
                long jElapsedRealtime = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() + (Long.parseLong(str4) - com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis());
                if (TextUtils.isEmpty(str3)) {
                    str3 = "native:view_load";
                }
                zzbgjVar2.zzzw().zzb(str2, str3, jElapsedRealtime);
                return;
            } catch (NumberFormatException e2) {
                zzbbq.zzd("Malformed timestamp for CSI tick.", e2);
                return;
            }
        }
        if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzbbq.zzfe("No value given for CSI experiment.");
                return;
            }
            zzabs zzabsVarZzrp = zzbgjVar2.zzzw().zzrp();
            if (zzabsVarZzrp == null) {
                zzbbq.zzfe("No ticker for WebView, dropping experiment ID.");
                return;
            } else {
                zzabsVarZzrp.zzh("e", str5);
                return;
            }
        }
        if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzbbq.zzfe("No value given for CSI extra.");
                return;
            }
            if (TextUtils.isEmpty(str6)) {
                zzbbq.zzfe("No name given for CSI extra.");
                return;
            }
            zzabs zzabsVarZzrp2 = zzbgjVar2.zzzw().zzrp();
            if (zzabsVarZzrp2 == null) {
                zzbbq.zzfe("No ticker for WebView, dropping extra parameter.");
            } else {
                zzabsVarZzrp2.zzh(str6, str7);
            }
        }
    }
}

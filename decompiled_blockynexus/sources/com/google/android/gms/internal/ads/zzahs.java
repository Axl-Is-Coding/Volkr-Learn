package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzahs implements zzahq<Object> {
    private final Context zzvr;

    public zzahs(Context context) {
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        if (com.google.android.gms.ads.internal.zzp.zzlp().zzac(this.zzvr)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            byte b2 = -1;
            int iHashCode = str.hashCode();
            if (iHashCode != 94399) {
                if (iHashCode != 94401) {
                    if (iHashCode == 94407 && str.equals("_ai")) {
                        b2 = 1;
                    }
                } else if (str.equals("_ac")) {
                    b2 = 0;
                }
            } else if (str.equals("_aa")) {
                b2 = 2;
            }
            if (b2 == 0) {
                com.google.android.gms.ads.internal.zzp.zzlp().zzi(this.zzvr, str2);
                return;
            }
            if (b2 == 1) {
                com.google.android.gms.ads.internal.zzp.zzlp().zzj(this.zzvr, str2);
            } else if (b2 != 2) {
                zzbbq.zzfc("logScionEvent gmsg contained unsupported eventName");
            } else {
                com.google.android.gms.ads.internal.zzp.zzlp().zzl(this.zzvr, str2);
            }
        }
    }
}

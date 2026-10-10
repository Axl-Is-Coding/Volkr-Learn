package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzdbd {
    private String zzgup;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static class zza {
        private String zzgup;

        public final zza zzgs(String str) {
            this.zzgup = str;
            return this;
        }
    }

    private zzdbd(zza zzaVar) {
        this.zzgup = zzaVar.zzgup;
    }

    public final Set<String> zzarg() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zzgup.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzarh() {
        return this.zzgup.toLowerCase(Locale.ROOT);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzua.zza.EnumC0120zza zzari() {
        /*
            r5 = this;
            java.lang.String r0 = r5.zzgup
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1999289321: goto L2b;
                case -1372958932: goto L21;
                case 543046670: goto L17;
                case 1951953708: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L35
        Ld:
            java.lang.String r1 = "BANNER"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L35
            r0 = 0
            goto L36
        L17:
            java.lang.String r1 = "REWARDED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L35
            r0 = 3
            goto L36
        L21:
            java.lang.String r1 = "INTERSTITIAL"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L35
            r0 = 1
            goto L36
        L2b:
            java.lang.String r1 = "NATIVE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L35
            r0 = 2
            goto L36
        L35:
            r0 = -1
        L36:
            if (r0 == 0) goto L4a
            if (r0 == r4) goto L47
            if (r0 == r3) goto L44
            if (r0 == r2) goto L41
            com.google.android.gms.internal.ads.zzua$zza$zza r0 = com.google.android.gms.internal.ads.zzua.zza.EnumC0120zza.AD_INITIATER_UNSPECIFIED
            return r0
        L41:
            com.google.android.gms.internal.ads.zzua$zza$zza r0 = com.google.android.gms.internal.ads.zzua.zza.EnumC0120zza.REWARD_BASED_VIDEO_AD
            return r0
        L44:
            com.google.android.gms.internal.ads.zzua$zza$zza r0 = com.google.android.gms.internal.ads.zzua.zza.EnumC0120zza.AD_LOADER
            return r0
        L47:
            com.google.android.gms.internal.ads.zzua$zza$zza r0 = com.google.android.gms.internal.ads.zzua.zza.EnumC0120zza.INTERSTITIAL
            return r0
        L4a:
            com.google.android.gms.internal.ads.zzua$zza$zza r0 = com.google.android.gms.internal.ads.zzua.zza.EnumC0120zza.BANNER
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdbd.zzari():com.google.android.gms.internal.ads.zzua$zza$zza");
    }
}

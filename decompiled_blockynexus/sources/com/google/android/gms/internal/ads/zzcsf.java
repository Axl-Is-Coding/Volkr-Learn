package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzua;
import com.tencent.map.geolocation.TencentLocation;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsf {
    private static final SparseArray<zzua.zzo.zzb> zzgmq;
    private final zzbtm zzfsr;
    private final zzcsc zzgjt;
    private final TelephonyManager zzgmn;
    private final zzcrw zzgmo;
    private zzuk zzgmp;
    private final Context zzvr;

    static {
        SparseArray<zzua.zzo.zzb> sparseArray = new SparseArray<>();
        zzgmq = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzua.zzo.zzb.CONNECTED);
        zzgmq.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzua.zzo.zzb.CONNECTING);
        zzgmq.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzua.zzo.zzb.CONNECTING);
        zzgmq.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzua.zzo.zzb.CONNECTING);
        zzgmq.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzua.zzo.zzb.DISCONNECTING);
        zzgmq.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzua.zzo.zzb.DISCONNECTED);
        zzgmq.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzua.zzo.zzb.DISCONNECTED);
        zzgmq.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzua.zzo.zzb.DISCONNECTED);
        zzgmq.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzua.zzo.zzb.DISCONNECTED);
        zzgmq.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzua.zzo.zzb.DISCONNECTED);
        zzgmq.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzua.zzo.zzb.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            zzgmq.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzua.zzo.zzb.CONNECTING);
        }
        zzgmq.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzua.zzo.zzb.CONNECTING);
    }

    zzcsf(Context context, zzbtm zzbtmVar, zzcsc zzcscVar, zzcrw zzcrwVar) {
        this.zzvr = context;
        this.zzfsr = zzbtmVar;
        this.zzgjt = zzcscVar;
        this.zzgmo = zzcrwVar;
        this.zzgmn = (TelephonyManager) context.getSystemService("phone");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zzua.zzc.zza> arrayList, zzua.zzm zzmVar, zzua.zzo.zzb zzbVar) {
        return ((zzua.zzo.zza) zzua.zzo.zza.zzok().zze(arrayList).zzh(zzbl(com.google.android.gms.ads.internal.zzp.zzkt().zzb(this.zzvr.getContentResolver()) != 0)).zzi(com.google.android.gms.ads.internal.zzp.zzkt().zza(this.zzvr, this.zzgmn)).zzet(this.zzgjt.zzaqd()).zzeu(this.zzgjt.zzaqf()).zzcm(this.zzgjt.getResponseCode()).zzb(zzbVar).zzb(zzmVar).zzj(this.zzgmp).zzf(zzbl(z)).zzes(com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis()).zzg(zzbl(com.google.android.gms.ads.internal.zzp.zzkt().zza(this.zzvr.getContentResolver()) != 0)).zzbgt()).toByteArray();
    }

    private static zzuk zzbl(boolean z) {
        return z ? zzuk.ENUM_TRUE : zzuk.ENUM_FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzua.zzm zzk(Bundle bundle) {
        zzua.zzm.zzb zzbVar;
        zzua.zzm.zza zzaVarZzog = zzua.zzm.zzog();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzgmp = zzuk.ENUM_TRUE;
        } else {
            this.zzgmp = zzuk.ENUM_FALSE;
            if (i == 0) {
                zzaVarZzog.zza(zzua.zzm.zzc.CELL);
            } else if (i != 1) {
                zzaVarZzog.zza(zzua.zzm.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzaVarZzog.zza(zzua.zzm.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzua.zzm.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzua.zzm.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzua.zzm.zzb.LTE;
                    break;
                default:
                    zzbVar = zzua.zzm.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzaVarZzog.zza(zzbVar);
        }
        return (zzua.zzm) zzaVarZzog.zzbgt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzua.zzo.zzb zzl(Bundle bundle) {
        return zzgmq.get(zzdot.zza(zzdot.zza(bundle, "device"), TencentLocation.NETWORK_PROVIDER).getInt("active_network_state", -1), zzua.zzo.zzb.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzua.zzc.zza> zzm(android.os.Bundle r7) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r7 = r7.get(r0)
            boolean r0 = r7 instanceof java.util.List
            if (r0 == 0) goto Ld
            java.util.List r7 = (java.util.List) r7
            goto L17
        Ld:
            boolean r0 = r7 instanceof java.lang.String[]
            if (r0 == 0) goto L3d
            java.lang.String[] r7 = (java.lang.String[]) r7
            java.util.List r7 = java.util.Arrays.asList(r7)
        L17:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L24:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L38
            java.lang.Object r1 = r7.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L24
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L24
        L38:
            java.util.List r7 = java.util.Collections.unmodifiableList(r0)
            goto L41
        L3d:
            java.util.List r7 = java.util.Collections.emptyList()
        L41:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L4a:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto La3
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1396342996: goto L80;
                case -1052618729: goto L76;
                case -239580146: goto L6c;
                case 604727084: goto L62;
                default: goto L61;
            }
        L61:
            goto L89
        L62:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L89
            r2 = 1
            goto L89
        L6c:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L89
            r2 = 3
            goto L89
        L76:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L89
            r2 = 2
            goto L89
        L80:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L89
            r2 = 0
        L89:
            if (r2 == 0) goto L9d
            if (r2 == r6) goto L9a
            if (r2 == r5) goto L97
            if (r2 == r4) goto L94
            com.google.android.gms.internal.ads.zzua$zzc$zza r1 = com.google.android.gms.internal.ads.zzua.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L9f
        L94:
            com.google.android.gms.internal.ads.zzua$zzc$zza r1 = com.google.android.gms.internal.ads.zzua.zzc.zza.REWARD_BASED_VIDEO_AD
            goto L9f
        L97:
            com.google.android.gms.internal.ads.zzua$zzc$zza r1 = com.google.android.gms.internal.ads.zzua.zzc.zza.NATIVE_APP_INSTALL
            goto L9f
        L9a:
            com.google.android.gms.internal.ads.zzua$zzc$zza r1 = com.google.android.gms.internal.ads.zzua.zzc.zza.INTERSTITIAL
            goto L9f
        L9d:
            com.google.android.gms.internal.ads.zzua$zzc$zza r1 = com.google.android.gms.internal.ads.zzua.zzc.zza.BANNER
        L9f:
            r0.add(r1)
            goto L4a
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcsf.zzm(android.os.Bundle):java.util.ArrayList");
    }

    public final void zzbk(boolean z) {
        zzdyq.zza(this.zzfsr.zzajo(), new zzcsi(this, z), zzbbz.zzeeu);
    }
}

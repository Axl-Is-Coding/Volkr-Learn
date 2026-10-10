package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzyz {
    private String zzado;
    private String zzchf;
    private String zzchh;
    private String zzchl;
    private boolean zzchn;
    private AdInfo zzcjr;
    private Date zzmx;
    private Location zznb;
    private final HashSet<String> zzcjz = new HashSet<>();
    private final Bundle zzcjm = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzcka = new HashMap<>();
    private final HashSet<String> zzckb = new HashSet<>();
    private final Bundle zzchj = new Bundle();
    private final HashSet<String> zzckc = new HashSet<>();
    private final List<String> zzchp = new ArrayList();
    private int zzchc = -1;
    private boolean zzbny = false;
    private int zzadm = -1;
    private int zzadn = -1;

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbny = z;
    }

    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzcka.put((Class<? extends NetworkExtras>) networkExtras.getClass(), networkExtras);
        }
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.zzchn = z;
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzcjm.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzcjm.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzcjm.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzc(List<String> list) {
        this.zzchp.clear();
        for (String str : list) {
            if (TextUtils.isEmpty(str)) {
                zzbbq.zzfe("neighboring content URL should not be null or empty");
            } else {
                this.zzchp.add(str);
            }
        }
    }

    public final void zzcj(String str) {
        this.zzcjz.add(str);
    }

    public final void zzck(String str) {
        this.zzckb.add(str);
    }

    public final void zzcl(String str) {
        this.zzckb.remove(str);
    }

    public final void zzcm(String str) {
        this.zzchh = str;
    }

    public final void zzcn(String str) {
        this.zzchf = str;
    }

    public final void zzco(String str) {
        this.zzchl = str;
    }

    public final void zzcp(String str) {
        this.zzckc.add(str);
    }

    @Deprecated
    public final void zzcq(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzado = str;
        }
    }

    @Deprecated
    public final void zzda(int i) {
        this.zzchc = i;
    }

    @Deprecated
    public final void zzdb(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzadn = i;
        }
    }

    public final void zze(String str, String str2) {
        this.zzchj.putString(str, str2);
    }

    @Deprecated
    public final void zzz(boolean z) {
        this.zzadm = z ? 1 : 0;
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzcjm.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zzmx = date;
    }

    public final void zza(Location location) {
        this.zznb = location;
    }

    public final void zza(AdInfo adInfo) {
        this.zzcjr = adInfo;
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavy implements zzawl {
    private static List<Future<Void>> zzdwk = Collections.synchronizedList(new ArrayList());
    private final zzawg zzdth;
    private final zzent.zzb.zza zzdwl;
    private final LinkedHashMap<String, zzent.zzb.zzh.C0118zzb> zzdwm;
    private final zzawn zzdwp;
    private boolean zzdwq;
    private final zzawm zzdwr;
    private final Context zzvr;
    private final List<String> zzdwn = new ArrayList();
    private final List<String> zzdwo = new ArrayList();
    private final Object lock = new Object();
    private HashSet<String> zzdws = new HashSet<>();
    private boolean zzdwt = false;
    private boolean zzdwu = false;
    private boolean zzdwv = false;

    public zzavy(Context context, zzbbx zzbbxVar, zzawg zzawgVar, String str, zzawn zzawnVar) {
        Preconditions.checkNotNull(zzawgVar, "SafeBrowsing config is not present.");
        this.zzvr = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdwm = new LinkedHashMap<>();
        this.zzdwp = zzawnVar;
        this.zzdth = zzawgVar;
        Iterator<String> it = this.zzdth.zzdxg.iterator();
        while (it.hasNext()) {
            this.zzdws.add(it.next().toLowerCase(Locale.ENGLISH));
        }
        this.zzdws.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzent.zzb.zza zzaVarZzbjm = zzent.zzb.zzbjm();
        zzaVarZzbjm.zza(zzent.zzb.zzg.OCTAGON_AD);
        zzaVarZzbjm.zzhy(str);
        zzaVarZzbjm.zzhz(str);
        zzent.zzb.C0114zzb.zza zzaVarZzbjo = zzent.zzb.C0114zzb.zzbjo();
        String str2 = this.zzdth.zzdxc;
        if (str2 != null) {
            zzaVarZzbjo.zzic(str2);
        }
        zzaVarZzbjm.zza((zzent.zzb.C0114zzb) zzaVarZzbjo.zzbgt());
        zzent.zzb.zzi.zza zzaVarZzbx = zzent.zzb.zzi.zzbkc().zzbx(Wrappers.packageManager(this.zzvr).isCallerInstantApp());
        String str3 = zzbbxVar.zzbre;
        if (str3 != null) {
            zzaVarZzbx.zzij(str3);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzvr);
        if (apkVersion > 0) {
            zzaVarZzbx.zzfu(apkVersion);
        }
        zzaVarZzbjm.zza((zzent.zzb.zzi) zzaVarZzbx.zzbgt());
        this.zzdwl = zzaVarZzbjm;
        this.zzdwr = new zzawm(this.zzvr, this.zzdth.zzdxj, this);
    }

    private final zzent.zzb.zzh.C0118zzb zzed(String str) {
        zzent.zzb.zzh.C0118zzb c0118zzb;
        synchronized (this.lock) {
            c0118zzb = this.zzdwm.get(str);
        }
        return c0118zzb;
    }

    static final /* synthetic */ Void zzee(String str) {
        return null;
    }

    private final zzdzc<Void> zzvu() {
        zzdzc<Void> zzdzcVarZzb;
        if (!((this.zzdwq && this.zzdth.zzdxi) || (this.zzdwv && this.zzdth.zzdxh) || (!this.zzdwq && this.zzdth.zzdxf))) {
            return zzdyq.zzaf(null);
        }
        synchronized (this.lock) {
            Iterator<zzent.zzb.zzh.C0118zzb> it = this.zzdwm.values().iterator();
            while (it.hasNext()) {
                this.zzdwl.zza((zzent.zzb.zzh) ((zzejz) it.next().zzbgt()));
            }
            this.zzdwl.zzm(this.zzdwn);
            this.zzdwl.zzn(this.zzdwo);
            if (zzawi.isEnabled()) {
                String url = this.zzdwl.getUrl();
                String strZzbjj = this.zzdwl.zzbjj();
                StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 53 + String.valueOf(strZzbjj).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(url);
                sb.append("\n  clickUrl: ");
                sb.append(strZzbjj);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzent.zzb.zzh zzhVar : this.zzdwl.zzbji()) {
                    sb2.append("    [");
                    sb2.append(zzhVar.zzbjz());
                    sb2.append("] ");
                    sb2.append(zzhVar.getUrl());
                }
                zzawi.zzef(sb2.toString());
            }
            zzdzc<String> zzdzcVarZza = new zzbag(this.zzvr).zza(1, this.zzdth.zzdxd, null, ((zzent.zzb) ((zzejz) this.zzdwl.zzbgt())).toByteArray());
            if (zzawi.isEnabled()) {
                zzdzcVarZza.addListener(zzawd.zzdxa, zzbbz.zzeep);
            }
            zzdzcVarZzb = zzdyq.zzb(zzdzcVarZza, zzawc.zzdwz, zzbbz.zzeeu);
        }
        return zzdzcVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzawl
    public final void zza(String str, Map<String, String> map, int i) {
        synchronized (this.lock) {
            if (i == 3) {
                this.zzdwv = true;
            }
            if (this.zzdwm.containsKey(str)) {
                if (i == 3) {
                    this.zzdwm.get(str).zzb(zzent.zzb.zzh.zza.zzhw(i));
                }
                return;
            }
            zzent.zzb.zzh.C0118zzb c0118zzbZzbka = zzent.zzb.zzh.zzbka();
            zzent.zzb.zzh.zza zzaVarZzhw = zzent.zzb.zzh.zza.zzhw(i);
            if (zzaVarZzhw != null) {
                c0118zzbZzbka.zzb(zzaVarZzhw);
            }
            c0118zzbZzbka.zzhx(this.zzdwm.size());
            c0118zzbZzbka.zzih(str);
            zzent.zzb.zzd.zza zzaVarZzbjs = zzent.zzb.zzd.zzbjs();
            if (this.zzdws.size() > 0 && map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey() != null ? entry.getKey() : "";
                    String value = entry.getValue() != null ? entry.getValue() : "";
                    if (this.zzdws.contains(key.toLowerCase(Locale.ENGLISH))) {
                        zzaVarZzbjs.zza((zzent.zzb.zzc) ((zzejz) zzent.zzb.zzc.zzbjq().zzan(zzeip.zzhu(key)).zzao(zzeip.zzhu(value)).zzbgt()));
                    }
                }
            }
            c0118zzbZzbka.zzb((zzent.zzb.zzd) ((zzejz) zzaVarZzbjs.zzbgt()));
            this.zzdwm.put(str, c0118zzbZzbka);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawl
    public final void zzea(String str) {
        synchronized (this.lock) {
            if (str == null) {
                this.zzdwl.zzbjk();
            } else {
                this.zzdwl.zzia(str);
            }
        }
    }

    final void zzeb(String str) {
        synchronized (this.lock) {
            this.zzdwn.add(str);
        }
    }

    final void zzec(String str) {
        synchronized (this.lock) {
            this.zzdwo.add(str);
        }
    }

    final /* synthetic */ zzdzc zzi(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (jSONArrayOptJSONArray != null) {
                        synchronized (this.lock) {
                            int length = jSONArrayOptJSONArray.length();
                            zzent.zzb.zzh.C0118zzb c0118zzbZzed = zzed(str);
                            if (c0118zzbZzed == null) {
                                String strValueOf = String.valueOf(str);
                                zzawi.zzef(strValueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(strValueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                for (int i = 0; i < length; i++) {
                                    c0118zzbZzed.zzii(jSONArrayOptJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                this.zzdwq = (length > 0) | this.zzdwq;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (zzadc.zzdcj.get().booleanValue()) {
                    zzbbq.zzb("Failed to get SafeBrowsing metadata", e2);
                }
                return zzdyq.immediateFailedFuture(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzdwq) {
            synchronized (this.lock) {
                this.zzdwl.zza(zzent.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return zzvu();
    }

    @Override // com.google.android.gms.internal.ads.zzawl
    public final void zzl(View view) {
        if (this.zzdth.zzdxe && !this.zzdwu) {
            com.google.android.gms.ads.internal.zzp.zzkr();
            final Bitmap bitmapZzn = zzayu.zzn(view);
            if (bitmapZzn == null) {
                zzawi.zzef("Failed to capture the webview bitmap.");
            } else {
                this.zzdwu = true;
                zzayu.zzc(new Runnable(this, bitmapZzn) { // from class: com.google.android.gms.internal.ads.zzawb
                    private final zzavy zzdwx;
                    private final Bitmap zzdwy;

                    {
                        this.zzdwx = this;
                        this.zzdwy = bitmapZzn;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzdwx.zza(this.zzdwy);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawl
    public final zzawg zzvq() {
        return this.zzdth;
    }

    @Override // com.google.android.gms.internal.ads.zzawl
    public final boolean zzvr() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdth.zzdxe && !this.zzdwu;
    }

    @Override // com.google.android.gms.internal.ads.zzawl
    public final void zzvs() {
        this.zzdwt = true;
    }

    @Override // com.google.android.gms.internal.ads.zzawl
    public final void zzvt() {
        synchronized (this.lock) {
            zzdzc zzdzcVarZzb = zzdyq.zzb(this.zzdwp.zza(this.zzvr, this.zzdwm.keySet()), new zzdya(this) { // from class: com.google.android.gms.internal.ads.zzawa
                private final zzavy zzdwx;

                {
                    this.zzdwx = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdya
                public final zzdzc zzf(Object obj) {
                    return this.zzdwx.zzi((Map) obj);
                }
            }, zzbbz.zzeeu);
            zzdzc zzdzcVarZza = zzdyq.zza(zzdzcVarZzb, 10L, TimeUnit.SECONDS, zzbbz.zzees);
            zzdyq.zza(zzdzcVarZzb, new zzawf(this, zzdzcVarZza), zzbbz.zzeeu);
            zzdwk.add(zzdzcVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawl
    public final String[] zza(String[] strArr) {
        return (String[]) this.zzdwr.zzb(strArr).toArray(new String[0]);
    }

    final /* synthetic */ void zza(Bitmap bitmap) {
        zzeiy zzeiyVarZzbei = zzeip.zzbei();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzeiyVarZzbei);
        synchronized (this.lock) {
            this.zzdwl.zza((zzent.zzb.zzf) ((zzejz) zzent.zzb.zzf.zzbjx().zzaq(zzeiyVarZzbei.zzbdw()).zzie("image/png").zza(zzent.zzb.zzf.EnumC0117zzb.TYPE_CREATIVE).zzbgt()));
        }
    }
}

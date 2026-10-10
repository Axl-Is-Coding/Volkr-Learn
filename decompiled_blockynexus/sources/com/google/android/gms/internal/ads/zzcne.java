package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcne {
    private List<Map<String, String>> zzghv = new ArrayList();
    private boolean zzghw = false;
    private boolean zzghx = false;
    private String zzghy;
    private zzcmz zzghz;

    public zzcne(String str, zzcmz zzcmzVar) {
        this.zzghy = str;
        this.zzghz = zzcmzVar;
    }

    private final Map<String, String> zzapk() {
        Map<String, String> mapZzapg = this.zzghz.zzapg();
        mapZzapg.put("tms", Long.toString(com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime(), 10));
        mapZzapg.put("tid", this.zzghy);
        return mapZzapg;
    }

    public final synchronized void zzapi() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqm)).booleanValue()) {
            if (!this.zzghw) {
                Map<String, String> mapZzapk = zzapk();
                mapZzapk.put("action", "init_started");
                this.zzghv.add(mapZzapk);
                this.zzghw = true;
            }
        }
    }

    public final synchronized void zzapj() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqm)).booleanValue()) {
            if (!this.zzghx) {
                Map<String, String> mapZzapk = zzapk();
                mapZzapk.put("action", "init_finished");
                this.zzghv.add(mapZzapk);
                Iterator<Map<String, String>> it = this.zzghv.iterator();
                while (it.hasNext()) {
                    this.zzghz.zzn(it.next());
                }
                this.zzghx = true;
            }
        }
    }

    public final synchronized void zzgj(String str) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqm)).booleanValue()) {
            Map<String, String> mapZzapk = zzapk();
            mapZzapk.put("action", "adapter_init_started");
            mapZzapk.put("ancn", str);
            this.zzghv.add(mapZzapk);
        }
    }

    public final synchronized void zzgk(String str) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqm)).booleanValue()) {
            Map<String, String> mapZzapk = zzapk();
            mapZzapk.put("action", "adapter_init_finished");
            mapZzapk.put("ancn", str);
            this.zzghv.add(mapZzapk);
        }
    }

    public final synchronized void zzs(String str, String str2) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqm)).booleanValue()) {
            Map<String, String> mapZzapk = zzapk();
            mapZzapk.put("action", "adapter_init_finished");
            mapZzapk.put("ancn", str);
            mapZzapk.put("rqe", str2);
            this.zzghv.add(mapZzapk);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzakd<ReferenceT> implements zzake {
    private final Map<String, CopyOnWriteArrayList<zzahq<? super ReferenceT>>> zzdgr = new HashMap();
    private ReferenceT zzdgs;

    private final synchronized void zzb(final String str, final Map<String, String> map) {
        if (zzbbq.isLoggable(2)) {
            String strValueOf = String.valueOf(str);
            zzayp.zzei(strValueOf.length() != 0 ? "Received GMSG: ".concat(strValueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzayp.zzei(sb.toString());
            }
        }
        CopyOnWriteArrayList<zzahq<? super ReferenceT>> copyOnWriteArrayList = this.zzdgr.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxk)).booleanValue() && com.google.android.gms.ads.internal.zzp.zzkv().zzwn() != null) {
                zzbbz.zzeep.execute(new Runnable(str) { // from class: com.google.android.gms.internal.ads.zzakf
                    private final String zzdgt;

                    {
                        this.zzdgt = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        com.google.android.gms.ads.internal.zzp.zzkv().zzwn().zzcv(this.zzdgt.substring(1));
                    }
                });
                return;
            }
            return;
        }
        for (final zzahq<? super ReferenceT> zzahqVar : copyOnWriteArrayList) {
            zzbbz.zzeet.execute(new Runnable(this, zzahqVar, map) { // from class: com.google.android.gms.internal.ads.zzakg
                private final zzakd zzdgu;
                private final zzahq zzdgv;
                private final Map zzdgw;

                {
                    this.zzdgu = this;
                    this.zzdgv = zzahqVar;
                    this.zzdgw = map;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzdgu.zza(this.zzdgv, this.zzdgw);
                }
            });
        }
    }

    public final synchronized void reset() {
        this.zzdgr.clear();
    }

    public final synchronized void zza(String str, zzahq<? super ReferenceT> zzahqVar) {
        CopyOnWriteArrayList<zzahq<? super ReferenceT>> copyOnWriteArrayList = this.zzdgr.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.zzdgr.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzahqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final boolean zzdg(String str) {
        return str != null && zzg(Uri.parse(str));
    }

    public final void zzg(ReferenceT referencet) {
        this.zzdgs = referencet;
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzb(path, zzayu.zzj(uri));
    }

    public final boolean zzg(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        zzh(uri);
        return true;
    }

    public final synchronized void zza(String str, Predicate<zzahq<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList<zzahq<? super ReferenceT>> copyOnWriteArrayList = this.zzdgr.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (zzahq<? super ReferenceT> zzahqVar : copyOnWriteArrayList) {
            if (predicate.apply(zzahqVar)) {
                arrayList.add(zzahqVar);
            }
        }
        copyOnWriteArrayList.removeAll(arrayList);
    }

    final /* synthetic */ void zza(zzahq zzahqVar, Map map) {
        zzahqVar.zza(this.zzdgs, map);
    }

    public final synchronized void zzb(String str, zzahq<? super ReferenceT> zzahqVar) {
        CopyOnWriteArrayList<zzahq<? super ReferenceT>> copyOnWriteArrayList = this.zzdgr.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(zzahqVar);
    }
}

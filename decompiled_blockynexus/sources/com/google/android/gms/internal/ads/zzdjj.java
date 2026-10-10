package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdjj implements zzeoy<zzdgw<JSONObject>> {
    public static zzdgw<JSONObject> zza(zzaxt zzaxtVar, Object obj, zzdhr zzdhrVar, zzdio zzdioVar, zzeos<zzdhl> zzeosVar, zzeos<zzdhv> zzeosVar2, zzeos<zzdhz> zzeosVar3, zzeos<zzdif> zzeosVar4, zzeos<zzdik> zzeosVar5, zzeos<zzdit> zzeosVar6, zzeos<zzdix> zzeosVar7, zzeos<zzdjl> zzeosVar8, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzdig) obj);
        hashSet.add(zzdhrVar);
        hashSet.add(zzdioVar);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvk)).booleanValue()) {
            hashSet.add(zzeosVar.get());
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvl)).booleanValue()) {
            hashSet.add(zzeosVar2.get());
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvm)).booleanValue()) {
            hashSet.add(zzeosVar3.get());
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvn)).booleanValue()) {
            hashSet.add(zzeosVar4.get());
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvr)).booleanValue()) {
            hashSet.add(new zzdfi(zzeosVar6.get(), ((Long) zzwm.zzpx().zzd(zzabb.zzcsm)).longValue(), scheduledExecutorService));
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvt)).booleanValue()) {
            hashSet.add(zzeosVar7.get());
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvu)).booleanValue()) {
            hashSet.add(zzeosVar8.get());
        }
        zzdgw<JSONObject> zzdgwVar = new zzdgw<>(executor, hashSet);
        zzepe.zza(zzdgwVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdgwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}

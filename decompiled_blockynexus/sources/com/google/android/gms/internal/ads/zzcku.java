package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcku {
    private final zzckp zzgfy;
    private final AtomicReference<zzanb> zzgfz = new AtomicReference<>();

    zzcku(zzckp zzckpVar) {
        this.zzgfy = zzckpVar;
    }

    private final zzanb zzaog() throws RemoteException {
        zzanb zzanbVar = this.zzgfz.get();
        if (zzanbVar != null) {
            return zzanbVar;
        }
        zzbbq.zzfe("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    private final zzang zze(String str, JSONObject jSONObject) throws RemoteException {
        zzanb zzanbVarZzaog = zzaog();
        if (AdUnit.CUSTOM_EVENT_ADAPTER_CLASS.equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                return zzanbVarZzaog.zzdj(jSONObject.getString("class_name")) ? zzanbVarZzaog.zzdi("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") : zzanbVarZzaog.zzdi(AdUnit.CUSTOM_EVENT_ADAPTER_CLASS);
            } catch (JSONException e2) {
                zzbbq.zzc("Invalid custom event.", e2);
            }
        }
        return zzanbVarZzaog.zzdi(str);
    }

    public final boolean zzaof() {
        return this.zzgfz.get() != null;
    }

    public final void zzb(zzanb zzanbVar) {
        this.zzgfz.compareAndSet(null, zzanbVar);
    }

    public final zzdpa zzd(String str, JSONObject jSONObject) throws zzdos {
        try {
            zzdpa zzdpaVar = new zzdpa(AdUnit.GOOGLE_ADAPTER_CLASS.equals(str) ? new zzanx(new AdMobAdapter()) : "com.google.ads.mediation.AdUrlAdapter".equals(str) ? new zzanx(new AdUrlAdapter()) : "com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str) ? new zzanx(new zzapx()) : zze(str, jSONObject));
            this.zzgfy.zza(str, zzdpaVar);
            return zzdpaVar;
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final zzaph zzdk(String str) throws RemoteException {
        zzaph zzaphVarZzdk = zzaog().zzdk(str);
        this.zzgfy.zza(str, zzaphVarZzdk);
        return zzaphVarZzdk;
    }
}

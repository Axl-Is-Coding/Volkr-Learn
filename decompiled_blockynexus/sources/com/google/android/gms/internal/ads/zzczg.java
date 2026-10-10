package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczg extends zzapl {
    private final String zzdfz;
    private final zzaph zzgsh;
    private zzbcg<JSONObject> zzgsi;
    private final JSONObject zzgsj = new JSONObject();
    private boolean zzgsk = false;

    public zzczg(String str, zzaph zzaphVar, zzbcg<JSONObject> zzbcgVar) {
        this.zzgsi = zzbcgVar;
        this.zzdfz = str;
        this.zzgsh = zzaphVar;
        try {
            this.zzgsj.put("adapter_version", this.zzgsh.zzua().toString());
            this.zzgsj.put("sdk_version", this.zzgsh.zzub().toString());
            this.zzgsj.put("name", this.zzdfz);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapm
    public final synchronized void onFailure(String str) throws RemoteException {
        if (this.zzgsk) {
            return;
        }
        try {
            this.zzgsj.put("signal_error", str);
        } catch (JSONException unused) {
        }
        this.zzgsi.set(this.zzgsj);
        this.zzgsk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzapm
    public final synchronized void zzds(String str) throws RemoteException {
        if (this.zzgsk) {
            return;
        }
        if (str == null) {
            onFailure("Adapter returned null signals");
            return;
        }
        try {
            this.zzgsj.put("signals", str);
        } catch (JSONException unused) {
        }
        this.zzgsi.set(this.zzgsj);
        this.zzgsk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzapm
    public final synchronized void zzg(zzva zzvaVar) throws RemoteException {
        if (this.zzgsk) {
            return;
        }
        try {
            this.zzgsj.put("signal_error", zzvaVar.zzcgw);
        } catch (JSONException unused) {
        }
        this.zzgsi.set(this.zzgsj);
        this.zzgsk = true;
    }
}

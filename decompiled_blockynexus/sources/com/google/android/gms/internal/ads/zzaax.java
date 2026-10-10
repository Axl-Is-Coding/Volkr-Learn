package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaax implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzclo;
    private final Object lock = new Object();
    private final ConditionVariable zzclm = new ConditionVariable();
    private volatile boolean zzzh = false;

    @VisibleForTesting
    private volatile boolean zzckl = false;
    private SharedPreferences zzcln = null;
    private Bundle metaData = new Bundle();
    private JSONObject zzclp = new JSONObject();

    private final void zzri() {
        if (this.zzcln == null) {
            return;
        }
        try {
            this.zzclp = new JSONObject((String) zzbay.zza(new zzdwe(this) { // from class: com.google.android.gms.internal.ads.zzaaz
                private final zzaax zzclq;

                {
                    this.zzclq = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdwe
                public final Object get() {
                    return this.zzclq.zzrj();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    public final void initialize(Context context) {
        if (this.zzzh) {
            return;
        }
        synchronized (this.lock) {
            if (this.zzzh) {
                return;
            }
            if (!this.zzckl) {
                this.zzckl = true;
            }
            this.zzclo = context.getApplicationContext() == null ? context : context.getApplicationContext();
            try {
                this.metaData = Wrappers.packageManager(this.zzclo).getApplicationInfo(this.zzclo.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            try {
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext == null && context != null && (remoteContext = context.getApplicationContext()) == null) {
                    remoteContext = context;
                }
                if (remoteContext == null) {
                    return;
                }
                zzwm.zzpv();
                this.zzcln = remoteContext.getSharedPreferences("google_ads_flags", 0);
                if (this.zzcln != null) {
                    this.zzcln.registerOnSharedPreferenceChangeListener(this);
                }
                zzadj.zza(new zzabc(this));
                zzri();
                this.zzzh = true;
            } finally {
                this.zzckl = false;
                this.zzclm.open();
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzri();
        }
    }

    public final <T> T zzd(final zzaaq<T> zzaaqVar) {
        if (!this.zzclm.block(5000L)) {
            synchronized (this.lock) {
                if (!this.zzckl) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzzh || this.zzcln == null) {
            synchronized (this.lock) {
                if (this.zzzh && this.zzcln != null) {
                }
                return zzaaqVar.zzrf();
            }
        }
        if (zzaaqVar.getSource() != 2) {
            return (zzaaqVar.getSource() == 1 && this.zzclp.has(zzaaqVar.getKey())) ? zzaaqVar.zzb(this.zzclp) : (T) zzbay.zza(new zzdwe(this, zzaaqVar) { // from class: com.google.android.gms.internal.ads.zzaba
                private final zzaax zzclq;
                private final zzaaq zzclr;

                {
                    this.zzclq = this;
                    this.zzclr = zzaaqVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdwe
                public final Object get() {
                    return this.zzclq.zze(this.zzclr);
                }
            });
        }
        Bundle bundle = this.metaData;
        return bundle == null ? zzaaqVar.zzrf() : zzaaqVar.zza(bundle);
    }

    final /* synthetic */ Object zze(zzaaq zzaaqVar) {
        return zzaaqVar.zza(this.zzcln);
    }

    final /* synthetic */ String zzrj() {
        return this.zzcln.getString("flag_configuration", "{}");
    }
}

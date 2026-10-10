package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayq implements zzayr {
    private SharedPreferences zzcln;
    private boolean zzeag;
    private zzdzc<?> zzeai;
    private SharedPreferences.Editor zzeak;
    private String zzeam;
    private String zzean;
    private final Object lock = new Object();
    private final List<Runnable> zzeah = new ArrayList();
    private zzrk zzeaj = null;
    private boolean zzeal = false;
    private boolean zzdqy = true;
    private boolean zzdrl = false;
    private String zzdro = "";
    private long zzeao = 0;
    private long zzeap = 0;
    private long zzeaq = 0;
    private int zzear = -1;
    private int zzeas = 0;
    private Set<String> zzeat = Collections.emptySet();
    private JSONObject zzeau = new JSONObject();
    private boolean zzdsx = true;
    private boolean zzdtj = true;
    private String zzeav = null;
    private int zzeaw = -1;

    private final void zzc(Bundle bundle) {
        zzbbz.zzeep.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzays
            private final zzayq zzeax;

            {
                this.zzeax = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeax.zzxd();
            }
        });
    }

    private final void zzxb() {
        zzdzc<?> zzdzcVar = this.zzeai;
        if (zzdzcVar == null || zzdzcVar.isDone()) {
            return;
        }
        try {
            this.zzeai.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzbbq.zzd("Interrupted while waiting for preferences loaded.", e2);
        } catch (CancellationException e3) {
            e = e3;
            zzbbq.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e4) {
            e = e4;
            zzbbq.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e5) {
            e = e5;
            zzbbq.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final Bundle zzxc() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.lock) {
            bundle.putBoolean("use_https", this.zzdqy);
            bundle.putBoolean("content_url_opted_out", this.zzdsx);
            bundle.putBoolean("content_vertical_opted_out", this.zzdtj);
            bundle.putBoolean("auto_collect_location", this.zzdrl);
            bundle.putInt("version_code", this.zzeas);
            bundle.putStringArray("never_pool_slots", (String[]) this.zzeat.toArray(new String[0]));
            bundle.putString("app_settings_json", this.zzdro);
            bundle.putLong("app_settings_last_update_ms", this.zzeao);
            bundle.putLong("app_last_background_time_ms", this.zzeap);
            bundle.putInt("request_in_session_count", this.zzear);
            bundle.putLong("first_ad_req_time_ms", this.zzeaq);
            bundle.putString("native_advanced_settings", this.zzeau.toString());
            bundle.putString("display_cutout", this.zzeav);
            bundle.putInt("app_measurement_npa", this.zzeaw);
            if (this.zzeam != null) {
                bundle.putString("content_url_hashes", this.zzeam);
            }
            if (this.zzean != null) {
                bundle.putString("content_vertical_hashes", this.zzean);
            }
        }
        return bundle;
    }

    public final void zza(final Context context, String str, boolean z) {
        final String strConcat;
        synchronized (this.lock) {
            if (this.zzcln != null) {
                return;
            }
            if (str == null) {
                strConcat = "admob";
            } else {
                String strValueOf = String.valueOf(str);
                strConcat = strValueOf.length() != 0 ? "admob__".concat(strValueOf) : new String("admob__");
            }
            this.zzeai = zzbbz.zzeep.submit(new Runnable(this, context, strConcat) { // from class: com.google.android.gms.internal.ads.zzayt
                private final Context zzckh;
                private final String zzdjk;
                private final zzayq zzeax;

                {
                    this.zzeax = this;
                    this.zzckh = context;
                    this.zzdjk = strConcat;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeax.zzq(this.zzckh, this.zzdjk);
                }
            });
            this.zzeag = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzao(boolean z) {
        zzxb();
        synchronized (this.lock) {
            if (this.zzdsx == z) {
                return;
            }
            this.zzdsx = z;
            if (this.zzeak != null) {
                this.zzeak.putBoolean("content_url_opted_out", z);
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.zzdsx);
            bundle.putBoolean("content_vertical_opted_out", this.zzdtj);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzap(boolean z) {
        zzxb();
        synchronized (this.lock) {
            if (this.zzdtj == z) {
                return;
            }
            this.zzdtj = z;
            if (this.zzeak != null) {
                this.zzeak.putBoolean("content_vertical_opted_out", z);
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.zzdsx);
            bundle.putBoolean("content_vertical_opted_out", this.zzdtj);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzaq(boolean z) {
        zzxb();
        synchronized (this.lock) {
            if (this.zzdrl == z) {
                return;
            }
            this.zzdrl = z;
            if (this.zzeak != null) {
                this.zzeak.putBoolean("auto_collect_location", z);
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", z);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzb(Runnable runnable) {
        this.zzeah.add(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzdf(int i) {
        zzxb();
        synchronized (this.lock) {
            if (this.zzeas == i) {
                return;
            }
            this.zzeas = i;
            if (this.zzeak != null) {
                this.zzeak.putInt("version_code", i);
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("version_code", i);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzdg(int i) {
        zzxb();
        synchronized (this.lock) {
            if (this.zzear == i) {
                return;
            }
            this.zzear = i;
            if (this.zzeak != null) {
                this.zzeak.putInt("request_in_session_count", i);
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("request_in_session_count", i);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzej(String str) {
        zzxb();
        synchronized (this.lock) {
            if (str != null) {
                if (!str.equals(this.zzeam)) {
                    this.zzeam = str;
                    if (this.zzeak != null) {
                        this.zzeak.putString("content_url_hashes", str);
                        this.zzeak.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_url_hashes", str);
                    zzc(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzek(String str) {
        zzxb();
        synchronized (this.lock) {
            if (str != null) {
                if (!str.equals(this.zzean)) {
                    this.zzean = str;
                    if (this.zzeak != null) {
                        this.zzeak.putString("content_vertical_hashes", str);
                        this.zzeak.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_vertical_hashes", str);
                    zzc(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzel(String str) {
        zzxb();
        synchronized (this.lock) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
            this.zzeao = jCurrentTimeMillis;
            if (str != null && !str.equals(this.zzdro)) {
                this.zzdro = str;
                if (this.zzeak != null) {
                    this.zzeak.putString("app_settings_json", str);
                    this.zzeak.putLong("app_settings_last_update_ms", jCurrentTimeMillis);
                    this.zzeak.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("app_settings_json", str);
                bundle.putLong("app_settings_last_update_ms", jCurrentTimeMillis);
                zzc(bundle);
                Iterator<Runnable> it = this.zzeah.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzem(String str) {
        zzxb();
        synchronized (this.lock) {
            if (TextUtils.equals(this.zzeav, str)) {
                return;
            }
            this.zzeav = str;
            if (this.zzeak != null) {
                this.zzeak.putString("display_cutout", str);
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("display_cutout", str);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzez(long j) {
        zzxb();
        synchronized (this.lock) {
            if (this.zzeap == j) {
                return;
            }
            this.zzeap = j;
            if (this.zzeak != null) {
                this.zzeak.putLong("app_last_background_time_ms", j);
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", j);
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzfa(long j) {
        zzxb();
        synchronized (this.lock) {
            if (this.zzeaq == j) {
                return;
            }
            this.zzeaq = j;
            if (this.zzeak != null) {
                this.zzeak.putLong("first_ad_req_time_ms", j);
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("first_ad_req_time_ms", j);
            zzc(bundle);
        }
    }

    final /* synthetic */ void zzq(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzcln = sharedPreferences;
            this.zzeak = editorEdit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzeal = z;
            this.zzdqy = this.zzcln.getBoolean("use_https", this.zzdqy);
            this.zzdsx = this.zzcln.getBoolean("content_url_opted_out", this.zzdsx);
            this.zzeam = this.zzcln.getString("content_url_hashes", this.zzeam);
            this.zzdrl = this.zzcln.getBoolean("auto_collect_location", this.zzdrl);
            this.zzdtj = this.zzcln.getBoolean("content_vertical_opted_out", this.zzdtj);
            this.zzean = this.zzcln.getString("content_vertical_hashes", this.zzean);
            this.zzeas = this.zzcln.getInt("version_code", this.zzeas);
            this.zzdro = this.zzcln.getString("app_settings_json", this.zzdro);
            this.zzeao = this.zzcln.getLong("app_settings_last_update_ms", this.zzeao);
            this.zzeap = this.zzcln.getLong("app_last_background_time_ms", this.zzeap);
            this.zzear = this.zzcln.getInt("request_in_session_count", this.zzear);
            this.zzeaq = this.zzcln.getLong("first_ad_req_time_ms", this.zzeaq);
            this.zzeat = this.zzcln.getStringSet("never_pool_slots", this.zzeat);
            this.zzeav = this.zzcln.getString("display_cutout", this.zzeav);
            this.zzeaw = this.zzcln.getInt("app_measurement_npa", this.zzeaw);
            try {
                this.zzeau = new JSONObject(this.zzcln.getString("native_advanced_settings", "{}"));
            } catch (JSONException e2) {
                zzbbq.zzd("Could not convert native advanced settings to json object", e2);
            }
            zzc(zzxc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final zzrk zzxd() {
        if (!this.zzeag) {
            return null;
        }
        if ((zzxe() && zzxg()) || !zzacq.zzdar.get().booleanValue()) {
            return null;
        }
        synchronized (this.lock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzeaj == null) {
                this.zzeaj = new zzrk();
            }
            this.zzeaj.zzmi();
            zzbbq.zzfd("start fetching content...");
            return this.zzeaj;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final boolean zzxe() {
        boolean z;
        zzxb();
        synchronized (this.lock) {
            z = this.zzdsx;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final String zzxf() {
        String str;
        zzxb();
        synchronized (this.lock) {
            str = this.zzeam;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final boolean zzxg() {
        boolean z;
        zzxb();
        synchronized (this.lock) {
            z = this.zzdtj;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final String zzxh() {
        String str;
        zzxb();
        synchronized (this.lock) {
            str = this.zzean;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final boolean zzxi() {
        boolean z;
        zzxb();
        synchronized (this.lock) {
            z = this.zzdrl;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final int zzxj() {
        int i;
        zzxb();
        synchronized (this.lock) {
            i = this.zzeas;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final zzaxy zzxk() {
        zzaxy zzaxyVar;
        zzxb();
        synchronized (this.lock) {
            zzaxyVar = new zzaxy(this.zzdro, this.zzeao);
        }
        return zzaxyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final long zzxl() {
        long j;
        zzxb();
        synchronized (this.lock) {
            j = this.zzeap;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final int zzxm() {
        int i;
        zzxb();
        synchronized (this.lock) {
            i = this.zzear;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final long zzxn() {
        long j;
        zzxb();
        synchronized (this.lock) {
            j = this.zzeaq;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final JSONObject zzxo() {
        JSONObject jSONObject;
        zzxb();
        synchronized (this.lock) {
            jSONObject = this.zzeau;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zzxp() {
        zzxb();
        synchronized (this.lock) {
            this.zzeau = new JSONObject();
            if (this.zzeak != null) {
                this.zzeak.remove("native_advanced_settings");
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final String zzxq() {
        String str;
        zzxb();
        synchronized (this.lock) {
            str = this.zzeav;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzayr
    public final void zza(String str, String str2, boolean z) {
        zzxb();
        synchronized (this.lock) {
            JSONArray jSONArrayOptJSONArray = this.zzeau.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            int length = jSONArrayOptJSONArray.length();
            int i = 0;
            while (true) {
                if (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null) {
                        return;
                    }
                    if (!str2.equals(jSONObjectOptJSONObject.optString("template_id"))) {
                        i++;
                    } else if (z && jSONObjectOptJSONObject.optBoolean("uses_media_view", false)) {
                        return;
                    } else {
                        length = i;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis());
                jSONArrayOptJSONArray.put(length, jSONObject);
                this.zzeau.put(str, jSONArrayOptJSONArray);
            } catch (JSONException e2) {
                zzbbq.zzd("Could not update native advanced settings", e2);
            }
            if (this.zzeak != null) {
                this.zzeak.putString("native_advanced_settings", this.zzeau.toString());
                this.zzeak.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.zzeau.toString());
            zzc(bundle);
        }
    }
}

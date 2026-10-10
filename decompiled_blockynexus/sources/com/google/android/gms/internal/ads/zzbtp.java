package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbtp {
    private final zzdok zzfsk;
    private Bundle zzfuh;
    private final String zzfui;
    private final zzdoj zzfuj;
    private final Context zzvr;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static class zza {
        private zzdok zzfsk;
        private Bundle zzfuh;
        private String zzfui;
        private zzdoj zzfuj;
        private Context zzvr;

        public final zza zza(zzdok zzdokVar) {
            this.zzfsk = zzdokVar;
            return this;
        }

        public final zzbtp zzajv() {
            return new zzbtp(this);
        }

        public final zza zzce(Context context) {
            this.zzvr = context;
            return this;
        }

        public final zza zzf(Bundle bundle) {
            this.zzfuh = bundle;
            return this;
        }

        public final zza zzfx(String str) {
            this.zzfui = str;
            return this;
        }

        public final zza zza(zzdoj zzdojVar) {
            this.zzfuj = zzdojVar;
            return this;
        }
    }

    private zzbtp(zza zzaVar) {
        this.zzvr = zzaVar.zzvr;
        this.zzfsk = zzaVar.zzfsk;
        this.zzfuh = zzaVar.zzfuh;
        this.zzfui = zzaVar.zzfui;
        this.zzfuj = zzaVar.zzfuj;
    }

    final zza zzajq() {
        return new zza().zzce(this.zzvr).zza(this.zzfsk).zzfx(this.zzfui).zzf(this.zzfuh);
    }

    final zzdok zzajr() {
        return this.zzfsk;
    }

    final zzdoj zzajs() {
        return this.zzfuj;
    }

    final Bundle zzajt() {
        return this.zzfuh;
    }

    final String zzaju() {
        return this.zzfui;
    }

    final Context zzcd(Context context) {
        return this.zzfui != null ? context : this.zzvr;
    }
}

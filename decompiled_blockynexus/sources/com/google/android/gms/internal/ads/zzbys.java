package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbys {
    private final zzdls zzfrs;
    private final Set<zzcab<zzux>> zzfvs;
    private final Set<zzcab<zzbuh>> zzfvt;
    private final Set<zzcab<zzbuz>> zzfvu;
    private final Set<zzcab<zzbwb>> zzfvv;
    private final Set<zzcab<zzbvs>> zzfvw;
    private final Set<zzcab<zzbui>> zzfvx;
    private final Set<zzcab<zzbuv>> zzfvy;
    private final Set<zzcab<AdMetadataListener>> zzfvz;
    private final Set<zzcab<AppEventListener>> zzfwa;
    private final Set<zzcab<zzbwl>> zzfwb;
    private final Set<zzcab<com.google.android.gms.ads.internal.overlay.zzp>> zzfwc;
    private zzbug zzfwd;
    private zzcwj zzfwe;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static class zza {
        private zzdls zzfrs;
        private Set<zzcab<zzux>> zzfvs = new HashSet();
        private Set<zzcab<zzbuh>> zzfvt = new HashSet();
        private Set<zzcab<zzbuz>> zzfvu = new HashSet();
        private Set<zzcab<zzbwb>> zzfvv = new HashSet();
        private Set<zzcab<zzbvs>> zzfvw = new HashSet();
        private Set<zzcab<zzbui>> zzfvx = new HashSet();
        private Set<zzcab<AdMetadataListener>> zzfvz = new HashSet();
        private Set<zzcab<AppEventListener>> zzfwa = new HashSet();
        private Set<zzcab<zzbuv>> zzfvy = new HashSet();
        private Set<zzcab<zzbwl>> zzfwf = new HashSet();
        private Set<zzcab<com.google.android.gms.ads.internal.overlay.zzp>> zzfwc = new HashSet();

        public final zza zza(zzbuh zzbuhVar, Executor executor) {
            this.zzfvt.add(new zzcab<>(zzbuhVar, executor));
            return this;
        }

        public final zzbys zzakr() {
            return new zzbys(this);
        }

        public final zza zza(zzbvs zzbvsVar, Executor executor) {
            this.zzfvw.add(new zzcab<>(zzbvsVar, executor));
            return this;
        }

        public final zza zza(zzbui zzbuiVar, Executor executor) {
            this.zzfvx.add(new zzcab<>(zzbuiVar, executor));
            return this;
        }

        public final zza zza(zzbuv zzbuvVar, Executor executor) {
            this.zzfvy.add(new zzcab<>(zzbuvVar, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.zzfvz.add(new zzcab<>(adMetadataListener, executor));
            return this;
        }

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzfwa.add(new zzcab<>(appEventListener, executor));
            return this;
        }

        public final zza zza(zzxk zzxkVar, Executor executor) {
            if (this.zzfwa != null) {
                zzczr zzczrVar = new zzczr();
                zzczrVar.zzb(zzxkVar);
                this.zzfwa.add(new zzcab<>(zzczrVar, executor));
            }
            return this;
        }

        public final zza zza(zzux zzuxVar, Executor executor) {
            this.zzfvs.add(new zzcab<>(zzuxVar, executor));
            return this;
        }

        public final zza zza(zzbuz zzbuzVar, Executor executor) {
            this.zzfvu.add(new zzcab<>(zzbuzVar, executor));
            return this;
        }

        public final zza zza(zzbwb zzbwbVar, Executor executor) {
            this.zzfvv.add(new zzcab<>(zzbwbVar, executor));
            return this;
        }

        public final zza zza(com.google.android.gms.ads.internal.overlay.zzp zzpVar, Executor executor) {
            this.zzfwc.add(new zzcab<>(zzpVar, executor));
            return this;
        }

        public final zza zza(zzbwl zzbwlVar, Executor executor) {
            this.zzfwf.add(new zzcab<>(zzbwlVar, executor));
            return this;
        }

        public final zza zza(zzdls zzdlsVar) {
            this.zzfrs = zzdlsVar;
            return this;
        }
    }

    private zzbys(zza zzaVar) {
        this.zzfvs = zzaVar.zzfvs;
        this.zzfvu = zzaVar.zzfvu;
        this.zzfvv = zzaVar.zzfvv;
        this.zzfvt = zzaVar.zzfvt;
        this.zzfvw = zzaVar.zzfvw;
        this.zzfvx = zzaVar.zzfvx;
        this.zzfvy = zzaVar.zzfvy;
        this.zzfvz = zzaVar.zzfvz;
        this.zzfwa = zzaVar.zzfwa;
        this.zzfwb = zzaVar.zzfwf;
        this.zzfrs = zzaVar.zzfrs;
        this.zzfwc = zzaVar.zzfwc;
    }

    public final zzcwj zza(Clock clock, zzcwl zzcwlVar, zzctd zzctdVar) {
        if (this.zzfwe == null) {
            this.zzfwe = new zzcwj(clock, zzcwlVar, zzctdVar);
        }
        return this.zzfwe;
    }

    public final Set<zzcab<zzbuh>> zzakf() {
        return this.zzfvt;
    }

    public final Set<zzcab<zzbvs>> zzakg() {
        return this.zzfvw;
    }

    public final Set<zzcab<zzbui>> zzakh() {
        return this.zzfvx;
    }

    public final Set<zzcab<zzbuv>> zzaki() {
        return this.zzfvy;
    }

    public final Set<zzcab<AdMetadataListener>> zzakj() {
        return this.zzfvz;
    }

    public final Set<zzcab<AppEventListener>> zzakk() {
        return this.zzfwa;
    }

    public final Set<zzcab<zzux>> zzakl() {
        return this.zzfvs;
    }

    public final Set<zzcab<zzbuz>> zzakm() {
        return this.zzfvu;
    }

    public final Set<zzcab<zzbwb>> zzakn() {
        return this.zzfvv;
    }

    public final Set<zzcab<zzbwl>> zzako() {
        return this.zzfwb;
    }

    public final Set<zzcab<com.google.android.gms.ads.internal.overlay.zzp>> zzakp() {
        return this.zzfwc;
    }

    public final zzdls zzakq() {
        return this.zzfrs;
    }

    public final zzbug zzc(Set<zzcab<zzbui>> set) {
        if (this.zzfwd == null) {
            this.zzfwd = new zzbug(set);
        }
        return this.zzfwd;
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbky {
    private zza zzfly;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static abstract class zza {
        public abstract zzbft zzaei();

        public abstract zzbde zzaej();

        public abstract zztx zzaek();

        public abstract zzawn zzael();

        public abstract zzarj zzaem();

        public abstract zzams zzaen();

        public abstract zzacg zzaeo();
    }

    public zzbky(zza zzaVar) {
        this.zzfly = zzaVar;
    }

    public final zzawn zzael() {
        return this.zzfly.zzael();
    }

    public final zzarj zzaem() {
        return this.zzfly.zzaem();
    }

    public final zzams zzaen() {
        return this.zzfly.zzaen();
    }

    public final zzacg zzaeo() {
        return this.zzfly.zzaeo();
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzawe, com.google.android.gms.internal.ads.zzawk] */
    public final com.google.android.gms.ads.internal.zzb zzagu() {
        zza zzaVar = this.zzfly;
        return new com.google.android.gms.ads.internal.zzb(zzaVar.zzaei(), zzaVar.zzaej(), new zzawe(zzaVar.zzael()), zzaVar.zzaek(), zzaVar.zzaem(), zzaVar.zzaeo());
    }
}

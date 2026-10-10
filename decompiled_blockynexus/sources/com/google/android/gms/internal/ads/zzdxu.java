package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzdxu<InputT, OutputT> extends zzdxy<OutputT> {
    private static final Logger logger = Logger.getLogger(zzdxu.class.getName());
    private zzdwk<? extends zzdzc<? extends InputT>> zzhsi;
    private final boolean zzhsj;
    private final boolean zzhsk;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    enum zza {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    zzdxu(zzdwk<? extends zzdzc<? extends InputT>> zzdwkVar, boolean z, boolean z2) {
        super(zzdwkVar.size());
        zzdwd.checkNotNull(zzdwkVar);
        this.zzhsi = zzdwkVar;
        this.zzhsj = z;
        this.zzhsk = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(int i, Future<? extends InputT> future) {
        try {
            zzb(i, zzdyq.zza(future));
        } catch (ExecutionException e2) {
            zzk(e2.getCause());
        } catch (Throwable th) {
            zzk(th);
        }
    }

    private final void zzk(Throwable th) {
        zzdwd.checkNotNull(th);
        if (this.zzhsj && !setException(th) && zza(zzaya(), th)) {
            zzl(th);
        } else if (th instanceof Error) {
            zzl(th);
        }
    }

    private static void zzl(Throwable th) {
        logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final void afterDone() {
        super.afterDone();
        zzdwk<? extends zzdzc<? extends InputT>> zzdwkVar = this.zzhsi;
        zza(zza.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdwkVar != null)) {
            boolean zWasInterrupted = wasInterrupted();
            zzdxg zzdxgVar = (zzdxg) zzdwkVar.iterator();
            while (zzdxgVar.hasNext()) {
                ((Future) zzdxgVar.next()).cancel(zWasInterrupted);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final String pendingToString() {
        zzdwk<? extends zzdzc<? extends InputT>> zzdwkVar = this.zzhsi;
        if (zzdwkVar == null) {
            return super.pendingToString();
        }
        String strValueOf = String.valueOf(zzdwkVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 8);
        sb.append("futures=");
        sb.append(strValueOf);
        return sb.toString();
    }

    final void zzaxy() {
        if (this.zzhsi.isEmpty()) {
            zzaxz();
            return;
        }
        if (!this.zzhsj) {
            zzdxw zzdxwVar = new zzdxw(this, this.zzhsk ? this.zzhsi : null);
            zzdxg zzdxgVar = (zzdxg) this.zzhsi.iterator();
            while (zzdxgVar.hasNext()) {
                ((zzdzc) zzdxgVar.next()).addListener(zzdxwVar, zzdyj.INSTANCE);
            }
            return;
        }
        int i = 0;
        zzdxg zzdxgVar2 = (zzdxg) this.zzhsi.iterator();
        while (zzdxgVar2.hasNext()) {
            zzdzc zzdzcVar = (zzdzc) zzdxgVar2.next();
            zzdzcVar.addListener(new zzdxx(this, zzdzcVar, i), zzdyj.INSTANCE);
            i++;
        }
    }

    abstract void zzaxz();

    abstract void zzb(int i, InputT inputt);

    @Override // com.google.android.gms.internal.ads.zzdxy
    final void zzh(Set<Throwable> set) {
        zzdwd.checkNotNull(set);
        if (isCancelled()) {
            return;
        }
        zza(set, zzaxv());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdwk<? extends Future<? extends InputT>> zzdwkVar) {
        int iZzayb = zzayb();
        int i = 0;
        if (!(iZzayb >= 0)) {
            throw new IllegalStateException("Less than 0 remaining futures");
        }
        if (iZzayb == 0) {
            if (zzdwkVar != null) {
                zzdxg zzdxgVar = (zzdxg) zzdwkVar.iterator();
                while (zzdxgVar.hasNext()) {
                    Future<? extends InputT> future = (Future) zzdxgVar.next();
                    if (!future.isCancelled()) {
                        zza(i, future);
                    }
                    i++;
                }
            }
            zzayc();
            zzaxz();
            zza(zza.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    void zza(zza zzaVar) {
        zzdwd.checkNotNull(zzaVar);
        this.zzhsi = null;
    }

    private static boolean zza(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    static /* synthetic */ zzdwk zza(zzdxu zzdxuVar, zzdwk zzdwkVar) {
        zzdxuVar.zzhsi = null;
        return null;
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzdxt<I, O, F, T> extends zzdyk<O> implements Runnable {
    private zzdzc<? extends I> zzhrl;
    private F zzhsh;

    zzdxt(zzdzc<? extends I> zzdzcVar, F f2) {
        zzdwd.checkNotNull(zzdzcVar);
        this.zzhrl = zzdzcVar;
        zzdwd.checkNotNull(f2);
        this.zzhsh = f2;
    }

    static <I, O> zzdzc<O> zza(zzdzc<I> zzdzcVar, zzdya<? super I, ? extends O> zzdyaVar, Executor executor) {
        zzdwd.checkNotNull(executor);
        zzdxs zzdxsVar = new zzdxs(zzdzcVar, zzdyaVar);
        zzdzcVar.addListener(zzdxsVar, zzdze.zza(executor, zzdxsVar));
        return zzdxsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final void afterDone() {
        maybePropagateCancellationTo(this.zzhrl);
        this.zzhrl = null;
        this.zzhsh = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final String pendingToString() {
        String string;
        zzdzc<? extends I> zzdzcVar = this.zzhrl;
        F f2 = this.zzhsh;
        String strPendingToString = super.pendingToString();
        if (zzdzcVar != null) {
            String strValueOf = String.valueOf(zzdzcVar);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(strValueOf);
            sb.append("], ");
            string = sb.toString();
        } else {
            string = "";
        }
        if (f2 == null) {
            if (strPendingToString == null) {
                return null;
            }
            String strValueOf2 = String.valueOf(string);
            String strValueOf3 = String.valueOf(strPendingToString);
            return strValueOf3.length() != 0 ? strValueOf2.concat(strValueOf3) : new String(strValueOf2);
        }
        String strValueOf4 = String.valueOf(f2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 11 + String.valueOf(strValueOf4).length());
        sb2.append(string);
        sb2.append("function=[");
        sb2.append(strValueOf4);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        zzdzc<? extends I> zzdzcVar = this.zzhrl;
        F f2 = this.zzhsh;
        if ((isCancelled() | (zzdzcVar == null)) || (f2 == null)) {
            return;
        }
        this.zzhrl = null;
        if (zzdzcVar.isCancelled()) {
            setFuture(zzdzcVar);
            return;
        }
        try {
            try {
                try {
                    Object objZzd = zzd(f2, zzdyq.zza(zzdzcVar));
                    this.zzhsh = null;
                    setResult(objZzd);
                } catch (Throwable th) {
                    setException(th);
                    this.zzhsh = null;
                }
            } catch (Throwable th2) {
                this.zzhsh = null;
                throw th2;
            }
        } catch (Error e2) {
            setException(e2);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e3) {
            setException(e3);
        } catch (ExecutionException e4) {
            setException(e4.getCause());
        }
    }

    abstract void setResult(T t);

    abstract T zzd(F f2, I i) throws Exception;

    static <I, O> zzdzc<O> zza(zzdzc<I> zzdzcVar, zzdvu<? super I, ? extends O> zzdvuVar, Executor executor) {
        zzdwd.checkNotNull(zzdvuVar);
        zzdxv zzdxvVar = new zzdxv(zzdzcVar, zzdvuVar);
        zzdzcVar.addListener(zzdxvVar, zzdze.zza(executor, zzdxvVar));
        return zzdxvVar;
    }
}

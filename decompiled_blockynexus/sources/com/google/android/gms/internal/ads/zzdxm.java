package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzdxm<V, X extends Throwable, F, T> extends zzdyk<V> implements Runnable {
    private zzdzc<? extends V> zzhrl;
    private Class<X> zzhrm;
    private F zzhrn;

    zzdxm(zzdzc<? extends V> zzdzcVar, Class<X> cls, F f2) {
        zzdwd.checkNotNull(zzdzcVar);
        this.zzhrl = zzdzcVar;
        zzdwd.checkNotNull(cls);
        this.zzhrm = cls;
        zzdwd.checkNotNull(f2);
        this.zzhrn = f2;
    }

    static <X extends Throwable, V> zzdzc<V> zza(zzdzc<? extends V> zzdzcVar, Class<X> cls, zzdya<? super X, ? extends V> zzdyaVar, Executor executor) {
        zzdxp zzdxpVar = new zzdxp(zzdzcVar, cls, zzdyaVar);
        zzdzcVar.addListener(zzdxpVar, zzdze.zza(executor, zzdxpVar));
        return zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final void afterDone() {
        maybePropagateCancellationTo(this.zzhrl);
        this.zzhrl = null;
        this.zzhrm = null;
        this.zzhrn = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final String pendingToString() {
        String string;
        zzdzc<? extends V> zzdzcVar = this.zzhrl;
        Class<X> cls = this.zzhrm;
        F f2 = this.zzhrn;
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
        if (cls == null || f2 == null) {
            if (strPendingToString == null) {
                return null;
            }
            String strValueOf2 = String.valueOf(string);
            String strValueOf3 = String.valueOf(strPendingToString);
            return strValueOf3.length() != 0 ? strValueOf2.concat(strValueOf3) : new String(strValueOf2);
        }
        String strValueOf4 = String.valueOf(cls);
        String strValueOf5 = String.valueOf(f2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 29 + String.valueOf(strValueOf4).length() + String.valueOf(strValueOf5).length());
        sb2.append(string);
        sb2.append("exceptionType=[");
        sb2.append(strValueOf4);
        sb2.append("], fallback=[");
        sb2.append(strValueOf5);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        zzdzc<? extends V> zzdzcVar = this.zzhrl;
        Class<X> cls = this.zzhrm;
        F f2 = this.zzhrn;
        if (((f2 == null) || ((zzdzcVar == null) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zzhrl = null;
        try {
            th = zzdzcVar instanceof zzdzt ? zzdzw.zza((zzdzt) zzdzcVar) : null;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause == null) {
                String strValueOf = String.valueOf(zzdzcVar.getClass());
                String strValueOf2 = String.valueOf(e2.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 35 + String.valueOf(strValueOf2).length());
                sb.append("Future type ");
                sb.append(strValueOf);
                sb.append(" threw ");
                sb.append(strValueOf2);
                sb.append(" without a cause");
                cause = new NullPointerException(sb.toString());
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        Object objZza = th == null ? zzdyq.zza(zzdzcVar) : null;
        if (th == null) {
            set(objZza);
            return;
        }
        try {
            if (!cls.isInstance(th)) {
                setFuture(zzdzcVar);
                return;
            }
            try {
                Object objZza2 = zza(f2, th);
                this.zzhrm = null;
                this.zzhrn = null;
                setResult(objZza2);
            } catch (Throwable th2) {
                setException(th2);
                this.zzhrm = null;
                this.zzhrn = null;
            }
        } catch (Throwable th3) {
            this.zzhrm = null;
            this.zzhrn = null;
            throw th3;
        }
    }

    abstract void setResult(T t);

    abstract T zza(F f2, X x) throws Exception;
}

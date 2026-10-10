package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzaq;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaa<T> implements Comparable<zzaa<T>> {
    private final Object mLock;
    private final zzaq.zza zzap;
    private final int zzaq;
    private final String zzar;
    private final int zzas;
    private zzai zzat;
    private Integer zzau;
    private zzae zzav;
    private boolean zzaw;
    private boolean zzax;
    private boolean zzay;
    private boolean zzaz;
    private zzan zzba;
    private zzn zzbb;
    private zzac zzbc;

    public zzaa(int i, String str, zzai zzaiVar) {
        Uri uri;
        String host;
        this.zzap = zzaq.zza.zzbw ? new zzaq.zza() : null;
        this.mLock = new Object();
        this.zzaw = true;
        int iHashCode = 0;
        this.zzax = false;
        this.zzay = false;
        this.zzaz = false;
        this.zzbb = null;
        this.zzaq = i;
        this.zzar = str;
        this.zzat = zzaiVar;
        this.zzba = new zzq();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzas = iHashCode;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        zzaa zzaaVar = (zzaa) obj;
        zzaf zzafVar = zzaf.NORMAL;
        return zzafVar == zzafVar ? this.zzau.intValue() - zzaaVar.zzau.intValue() : zzafVar.ordinal() - zzafVar.ordinal();
    }

    public Map<String, String> getHeaders() throws zzl {
        return Collections.emptyMap();
    }

    public final int getMethod() {
        return this.zzaq;
    }

    public final String getUrl() {
        return this.zzar;
    }

    public final boolean isCanceled() {
        synchronized (this.mLock) {
        }
        return false;
    }

    public String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.zzas));
        String strConcat = strValueOf.length() != 0 ? "0x".concat(strValueOf) : new String("0x");
        isCanceled();
        String str = this.zzar;
        String strValueOf2 = String.valueOf(zzaf.NORMAL);
        String strValueOf3 = String.valueOf(this.zzau);
        StringBuilder sb = new StringBuilder("[ ] ".length() + 3 + String.valueOf(str).length() + String.valueOf(strConcat).length() + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(" ");
        sb.append(strConcat);
        sb.append(" ");
        sb.append(strValueOf2);
        sb.append(" ");
        sb.append(strValueOf3);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzaa<?> zza(zzae zzaeVar) {
        this.zzav = zzaeVar;
        return this;
    }

    protected abstract zzaj<T> zza(zzy zzyVar);

    protected abstract void zza(T t);

    public final void zzb(zzao zzaoVar) {
        zzai zzaiVar;
        synchronized (this.mLock) {
            zzaiVar = this.zzat;
        }
        if (zzaiVar != null) {
            zzaiVar.zzc(zzaoVar);
        }
    }

    public final void zzc(String str) {
        if (zzaq.zza.zzbw) {
            this.zzap.zza(str, Thread.currentThread().getId());
        }
    }

    public final int zzd() {
        return this.zzas;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzaa<?> zze(int i) {
        this.zzau = Integer.valueOf(i);
        return this;
    }

    public final zzn zzf() {
        return this.zzbb;
    }

    public byte[] zzg() throws zzl {
        return null;
    }

    public final boolean zzh() {
        return this.zzaw;
    }

    public final int zzi() {
        return this.zzba.zzb();
    }

    public final zzan zzj() {
        return this.zzba;
    }

    public final void zzk() {
        synchronized (this.mLock) {
            this.zzay = true;
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzay;
        }
        return z;
    }

    final void zzm() {
        zzac zzacVar;
        synchronized (this.mLock) {
            zzacVar = this.zzbc;
        }
        if (zzacVar != null) {
            zzacVar.zza(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzaa<?> zza(zzn zznVar) {
        this.zzbb = zznVar;
        return this;
    }

    final void zzd(String str) {
        zzae zzaeVar = this.zzav;
        if (zzaeVar != null) {
            zzaeVar.zzf(this);
        }
        if (zzaq.zza.zzbw) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzad(this, str, id));
            } else {
                this.zzap.zza(str, id);
                this.zzap.zzd(toString());
            }
        }
    }

    public final String zze() {
        String str = this.zzar;
        int i = this.zzaq;
        if (i == 0 || i == -1) {
            return str;
        }
        String string = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(str).length());
        sb.append(string);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    final void zza(zzac zzacVar) {
        synchronized (this.mLock) {
            this.zzbc = zzacVar;
        }
    }

    final void zza(zzaj<?> zzajVar) {
        zzac zzacVar;
        synchronized (this.mLock) {
            zzacVar = this.zzbc;
        }
        if (zzacVar != null) {
            zzacVar.zza(this, zzajVar);
        }
    }

    final void zzd(int i) {
        zzae zzaeVar = this.zzav;
        if (zzaeVar != null) {
            zzaeVar.zza(this, i);
        }
    }
}

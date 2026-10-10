package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzber implements zzhf, zzmy, zzpa<zzom>, zzqd {

    @VisibleForTesting
    private static int zzekp;

    @VisibleForTesting
    private static int zzekq;
    private int bytesTransferred;
    private final zzbdv zzejr;
    private final zzhx zzeks;
    private zzhc zzekv;
    private ByteBuffer zzekw;
    private boolean zzekx;
    private zzbey zzeky;
    private final Context zzvr;
    private Set<WeakReference<zzbek>> zzekz = new HashSet();
    private final zzbeo zzekr = new zzbeo();
    private final zzhx zzekt = new zzjb(zzlw.zzbcw);
    private final zzoa zzeku = new zznv();

    public zzber(Context context, zzbdv zzbdvVar) {
        this.zzvr = context;
        this.zzejr = zzbdvVar;
        this.zzeks = new zzpx(this.zzvr, zzlw.zzbcw, 0L, zzayu.zzeba, this, -1);
        if (zzayp.zzxa()) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(strValueOf);
            zzayp.zzei(sb.toString());
        }
        zzekp++;
        this.zzekv = zzhg.zza(new zzhx[]{this.zzekt, this.zzeks}, this.zzeku, this.zzekr);
        this.zzekv.zza(this);
    }

    public static int zzaav() {
        return zzekp;
    }

    public static int zzaaw() {
        return zzekq;
    }

    public final void finalize() throws Throwable {
        zzekp--;
        if (zzayp.zzxa()) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(strValueOf);
            zzayp.zzei(sb.toString());
        }
    }

    public final long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public final void release() {
        zzhc zzhcVar = this.zzekv;
        if (zzhcVar != null) {
            zzhcVar.zzb(this);
            this.zzekv.release();
            this.zzekv = null;
            zzekq--;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zza(Surface surface) {
    }

    public final void zza(zzbey zzbeyVar) {
        this.zzeky = zzbeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zzhu zzhuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zzhy zzhyVar, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zznp zznpVar, zzod zzodVar) {
    }

    public final zzhc zzaau() {
        return this.zzekv;
    }

    public final zzbeo zzaax() {
        return this.zzekr;
    }

    final void zzaw(boolean z) {
        if (this.zzekv == null) {
            return;
        }
        for (int i = 0; i < this.zzekv.zzel(); i++) {
            this.zzeku.zzf(i, !z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void zzb(IOException iOException) {
        zzbey zzbeyVar = this.zzeky;
        if (zzbeyVar != null) {
            zzbeyVar.zza("onLoadError", iOException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* synthetic */ void zzc(zzom zzomVar, int i) {
        this.bytesTransferred += i;
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zzd(String str, long j, long j2) {
    }

    final /* synthetic */ void zzd(boolean z, long j) {
        zzbey zzbeyVar = this.zzeky;
        if (zzbeyVar != null) {
            zzbeyVar.zzb(z, j);
        }
    }

    public final void zzdp(int i) {
        Iterator<WeakReference<zzbek>> it = this.zzekz.iterator();
        while (it.hasNext()) {
            zzbek zzbekVar = it.next().get();
            if (zzbekVar != null) {
                zzbekVar.setReceiveBufferSize(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zze(int i, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zze(zzjl zzjlVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* bridge */ /* synthetic */ void zze(zzom zzomVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zzen() {
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zzf(zzjl zzjlVar) {
    }

    final /* synthetic */ zzom zzfl(String str) {
        zzber zzberVar = this.zzejr.zzeiy ? null : this;
        zzbdv zzbdvVar = this.zzejr;
        return new zzop(str, null, zzberVar, zzbdvVar.zzeis, zzbdvVar.zzeiu, true, null);
    }

    final /* synthetic */ zzom zzfm(String str) {
        zzber zzberVar = this.zzejr.zzeiy ? null : this;
        zzbdv zzbdvVar = this.zzejr;
        zzbek zzbekVar = new zzbek(str, zzberVar, zzbdvVar.zzeis, zzbdvVar.zzeiu, zzbdvVar.zzeix);
        this.zzekz.add(new WeakReference<>(zzbekVar));
        return zzbekVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zzg(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zzk(zzho zzhoVar) {
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzmz zzneVar;
        if (this.zzekv == null) {
            return;
        }
        this.zzekw = byteBuffer;
        this.zzekx = z;
        if (uriArr.length == 1) {
            zzneVar = zzb(uriArr[0], str);
        } else {
            zzmz[] zzmzVarArr = new zzmz[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                zzmzVarArr[i] = zzb(uriArr[i], str);
            }
            zzneVar = new zzne(zzmzVarArr);
        }
        this.zzekv.zza(zzneVar);
        zzekq++;
    }

    final void zzb(float f2, boolean z) {
        if (this.zzekv == null) {
            return;
        }
        zzhh zzhhVar = new zzhh(this.zzekt, 2, Float.valueOf(f2));
        if (z) {
            this.zzekv.zzb(zzhhVar);
        } else {
            this.zzekv.zza(zzhhVar);
        }
    }

    @VisibleForTesting
    private final zzmz zzb(Uri uri, final String str) {
        final zzol zzolVar;
        zzol zzolVar2;
        zzka zzkaVar;
        if (this.zzekx && this.zzekw.limit() > 0) {
            final byte[] bArr = new byte[this.zzekw.limit()];
            this.zzekw.get(bArr);
            zzolVar2 = new zzol(bArr) { // from class: com.google.android.gms.internal.ads.zzbeq
                private final byte[] zzeek;

                {
                    this.zzeek = bArr;
                }

                @Override // com.google.android.gms.internal.ads.zzol
                public final zzom zzip() {
                    return new zzoj(this.zzeek);
                }
            };
        } else {
            if (this.zzejr.zzeix > 0) {
                zzolVar = new zzol(this, str) { // from class: com.google.android.gms.internal.ads.zzbet
                    private final String zzdgm;
                    private final zzber zzela;

                    {
                        this.zzela = this;
                        this.zzdgm = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzol
                    public final zzom zzip() {
                        return this.zzela.zzfm(this.zzdgm);
                    }
                };
            } else {
                zzolVar = new zzol(this, str) { // from class: com.google.android.gms.internal.ads.zzbes
                    private final String zzdgm;
                    private final zzber zzela;

                    {
                        this.zzela = this;
                        this.zzdgm = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzol
                    public final zzom zzip() {
                        return this.zzela.zzfl(this.zzdgm);
                    }
                };
            }
            final zzol zzolVar3 = this.zzejr.zzeiy ? new zzol(this, zzolVar) { // from class: com.google.android.gms.internal.ads.zzbev
                private final zzber zzela;
                private final zzol zzelc;

                {
                    this.zzela = this;
                    this.zzelc = zzolVar;
                }

                @Override // com.google.android.gms.internal.ads.zzol
                public final zzom zzip() {
                    return this.zzela.zza(this.zzelc);
                }
            } : zzolVar;
            if (this.zzekw.limit() > 0) {
                final byte[] bArr2 = new byte[this.zzekw.limit()];
                this.zzekw.get(bArr2);
                zzolVar3 = new zzol(zzolVar3, bArr2) { // from class: com.google.android.gms.internal.ads.zzbeu
                    private final byte[] zzdtu;
                    private final zzol zzelb;

                    {
                        this.zzelb = zzolVar3;
                        this.zzdtu = bArr2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzol
                    public final zzom zzip() {
                        zzol zzolVar4 = this.zzelb;
                        byte[] bArr3 = this.zzdtu;
                        return new zzbfb(new zzoj(bArr3), bArr3.length, zzolVar4.zzip());
                    }
                };
            }
            zzolVar2 = zzolVar3;
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcmf)).booleanValue()) {
            zzkaVar = zzbex.zzeld;
        } else {
            zzkaVar = zzbew.zzeld;
        }
        zzka zzkaVar2 = zzkaVar;
        zzbdv zzbdvVar = this.zzejr;
        return new zzmv(uri, zzolVar2, zzkaVar2, zzbdvVar.zzeiz, zzayu.zzeba, this, null, zzbdvVar.zzeiv);
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zza(int i, int i2, int i3, float f2) {
        zzbey zzbeyVar = this.zzeky;
        if (zzbeyVar != null) {
            zzbeyVar.zzn(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(boolean z, int i) {
        zzbey zzbeyVar = this.zzeky;
        if (zzbeyVar != null) {
            zzbeyVar.zzdq(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zzhd zzhdVar) {
        zzbey zzbeyVar = this.zzeky;
        if (zzbeyVar != null) {
            zzbeyVar.zza("onPlayerError", zzhdVar);
        }
    }

    final void zza(Surface surface, boolean z) {
        if (this.zzekv == null) {
            return;
        }
        zzhh zzhhVar = new zzhh(this.zzeks, 1, surface);
        if (z) {
            this.zzekv.zzb(zzhhVar);
        } else {
            this.zzekv.zza(zzhhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* synthetic */ void zza(zzom zzomVar, zzon zzonVar) {
        this.bytesTransferred = 0;
    }

    final /* synthetic */ zzom zza(zzol zzolVar) {
        return new zzbem(this.zzvr, zzolVar.zzip(), this, new zzbep(this) { // from class: com.google.android.gms.internal.ads.zzbez
            private final zzber zzela;

            {
                this.zzela = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbep
            public final void zzb(boolean z, long j) {
                this.zzela.zzd(z, j);
            }
        });
    }
}

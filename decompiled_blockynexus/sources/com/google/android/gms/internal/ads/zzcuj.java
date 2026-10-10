package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.f;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcuj implements zzcta<zzcbe> {
    private final zzdnt zzfmt;
    private final Executor zzfoc;
    private final zzcce zzgos;
    private final Context zzvr;

    public zzcuj(Context context, Executor executor, zzcce zzcceVar, zzdnt zzdntVar) {
        this.zzvr = context;
        this.zzgos = zzcceVar;
        this.zzfoc = executor;
        this.zzfmt = zzdntVar;
    }

    private static String zzf(zzdnv zzdnvVar) {
        try {
            return zzdnvVar.zzhdu.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        return (this.zzvr instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacc.zzk(this.zzvr) && !TextUtils.isEmpty(zzf(zzdnvVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<zzcbe> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar) {
        String strZzf = zzf(zzdnvVar);
        final Uri uri = strZzf != null ? Uri.parse(strZzf) : null;
        return zzdyq.zzb(zzdyq.zzaf(null), new zzdya(this, uri, zzdogVar, zzdnvVar) { // from class: com.google.android.gms.internal.ads.zzcum
            private final Uri zzebh;
            private final zzdog zzgoa;
            private final zzcuj zzgot;
            private final zzdnv zzgou;

            {
                this.zzgot = this;
                this.zzebh = uri;
                this.zzgoa = zzdogVar;
                this.zzgou = zzdnvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgot.zza(this.zzebh, this.zzgoa, this.zzgou, obj);
            }
        }, this.zzfoc);
    }

    final /* synthetic */ zzdzc zza(Uri uri, zzdog zzdogVar, zzdnv zzdnvVar, Object obj) throws Exception {
        try {
            f fVarA = new f.a().a();
            fVarA.f773a.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzb zzbVar = new com.google.android.gms.ads.internal.overlay.zzb(fVarA.f773a);
            final zzbcg zzbcgVar = new zzbcg();
            zzcbg zzcbgVarZza = this.zzgos.zza(new zzbre(zzdogVar, zzdnvVar, null), new zzcbf(new zzccm(zzbcgVar) { // from class: com.google.android.gms.internal.ads.zzcul
                private final zzbcg zzbvu;

                {
                    this.zzbvu = zzbcgVar;
                }

                @Override // com.google.android.gms.internal.ads.zzccm
                public final void zza(boolean z, Context context) {
                    zzbcg zzbcgVar2 = this.zzbvu;
                    try {
                        com.google.android.gms.ads.internal.zzp.zzkq();
                        com.google.android.gms.ads.internal.overlay.zzl.zza(context, (AdOverlayInfoParcel) zzbcgVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }));
            zzbcgVar.set(new AdOverlayInfoParcel(zzbVar, null, zzcbgVarZza.zzagk(), null, new zzbbx(0, 0, false)));
            this.zzfmt.zzwp();
            return zzdyq.zzaf(zzcbgVarZza.zzagj());
        } catch (Throwable th) {
            zzbbq.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}

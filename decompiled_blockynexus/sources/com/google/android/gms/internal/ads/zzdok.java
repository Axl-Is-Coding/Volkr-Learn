package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdok {
    public final zzvn zzbpf;
    public final zzadu zzdly;
    public final zzajc zzdsi;
    public final int zzgtu;
    public final boolean zzgvi;
    public final zzxq zzhey;
    public final zzaak zzhez;
    public final zzvg zzhfa;
    public final String zzhfb;
    public final ArrayList<String> zzhfc;
    public final ArrayList<String> zzhfd;
    public final zzvs zzhfe;
    public final PublisherAdViewOptions zzhff;
    public final zzxk zzhfg;
    public final zzdob zzhfh;

    private zzdok(zzdom zzdomVar) {
        this.zzbpf = zzdomVar.zzbpf;
        this.zzhfb = zzdomVar.zzhfb;
        this.zzhey = zzdomVar.zzhey;
        this.zzhfa = new zzvg(zzdomVar.zzhfa.versionCode, zzdomVar.zzhfa.zzchb, zzdomVar.zzhfa.extras, zzdomVar.zzhfa.zzchc, zzdomVar.zzhfa.zzchd, zzdomVar.zzhfa.zzche, zzdomVar.zzhfa.zzadm, zzdomVar.zzhfa.zzbny || zzdomVar.zzbny, zzdomVar.zzhfa.zzchf, zzdomVar.zzhfa.zzchg, zzdomVar.zzhfa.zznb, zzdomVar.zzhfa.zzchh, zzdomVar.zzhfa.zzchi, zzdomVar.zzhfa.zzchj, zzdomVar.zzhfa.zzchk, zzdomVar.zzhfa.zzchl, zzdomVar.zzhfa.zzchm, zzdomVar.zzhfa.zzchn, zzdomVar.zzhfa.zzcho, zzdomVar.zzhfa.zzadn, zzdomVar.zzhfa.zzado, zzdomVar.zzhfa.zzchp);
        this.zzhez = zzdomVar.zzhez != null ? zzdomVar.zzhez : zzdomVar.zzdly != null ? zzdomVar.zzdly.zzddn : null;
        this.zzhfc = zzdomVar.zzhfc;
        this.zzhfd = zzdomVar.zzhfd;
        this.zzdly = zzdomVar.zzhfc == null ? null : zzdomVar.zzdly == null ? new zzadu(new NativeAdOptions.Builder().build()) : zzdomVar.zzdly;
        this.zzhfe = zzdomVar.zzhfe;
        this.zzgtu = zzdomVar.zzgtu;
        this.zzhff = zzdomVar.zzhff;
        this.zzhfg = zzdomVar.zzhfg;
        this.zzdsi = zzdomVar.zzdsi;
        this.zzhfh = new zzdob(zzdomVar.zzhfj);
        this.zzgvi = zzdomVar.zzgvi;
    }

    public final zzafy zzati() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzhff;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzjw();
    }
}

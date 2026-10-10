package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdom {
    private boolean zzbny;
    private zzvn zzbpf;
    private zzadu zzdly;
    private zzajc zzdsi;
    private zzxq zzhey;
    private zzaak zzhez;
    private zzvg zzhfa;
    private String zzhfb;
    private ArrayList<String> zzhfc;
    private ArrayList<String> zzhfd;
    private zzvs zzhfe;
    private PublisherAdViewOptions zzhff;
    private zzxk zzhfg;
    private int zzgtu = 1;
    private zzdod zzhfj = new zzdod();
    private boolean zzgvi = false;

    public final zzvg zzatk() {
        return this.zzhfa;
    }

    public final String zzatl() {
        return this.zzhfb;
    }

    public final zzdod zzatm() {
        return this.zzhfj;
    }

    public final zzdok zzatn() {
        Preconditions.checkNotNull(this.zzhfb, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzbpf, "ad size must not be null");
        Preconditions.checkNotNull(this.zzhfa, "ad request must not be null");
        return new zzdok(this);
    }

    public final boolean zzato() {
        return this.zzgvi;
    }

    public final zzdom zzb(zzadu zzaduVar) {
        this.zzdly = zzaduVar;
        return this;
    }

    public final zzdom zzbo(boolean z) {
        this.zzgvi = z;
        return this;
    }

    public final zzdom zzbp(boolean z) {
        this.zzbny = z;
        return this;
    }

    public final zzdom zzc(zzxq zzxqVar) {
        this.zzhey = zzxqVar;
        return this;
    }

    public final zzdom zzd(ArrayList<String> arrayList) {
        this.zzhfd = arrayList;
        return this;
    }

    public final zzdom zze(zzvn zzvnVar) {
        this.zzbpf = zzvnVar;
        return this;
    }

    public final zzdom zzec(int i) {
        this.zzgtu = i;
        return this;
    }

    public final zzdom zzgt(String str) {
        this.zzhfb = str;
        return this;
    }

    public final zzdom zzh(zzvg zzvgVar) {
        this.zzhfa = zzvgVar;
        return this;
    }

    public final zzvn zzkg() {
        return this.zzbpf;
    }

    public final zzdom zzb(zzvs zzvsVar) {
        this.zzhfe = zzvsVar;
        return this;
    }

    public final zzdom zzc(zzaak zzaakVar) {
        this.zzhez = zzaakVar;
        return this;
    }

    public final zzdom zzb(zzajc zzajcVar) {
        this.zzdsi = zzajcVar;
        this.zzhez = new zzaak(false, true, false);
        return this;
    }

    public final zzdom zzc(ArrayList<String> arrayList) {
        this.zzhfc = arrayList;
        return this;
    }

    public final zzdom zzc(zzdok zzdokVar) {
        this.zzhfj.zza(zzdokVar.zzhfh);
        this.zzhfa = zzdokVar.zzhfa;
        this.zzbpf = zzdokVar.zzbpf;
        this.zzhey = zzdokVar.zzhey;
        this.zzhfb = zzdokVar.zzhfb;
        this.zzhez = zzdokVar.zzhez;
        this.zzhfc = zzdokVar.zzhfc;
        this.zzhfd = zzdokVar.zzhfd;
        this.zzdly = zzdokVar.zzdly;
        this.zzhfe = zzdokVar.zzhfe;
        zzdom zzdomVarZzb = zzb(zzdokVar.zzhff);
        zzdomVarZzb.zzgvi = zzdokVar.zzgvi;
        return zzdomVarZzb;
    }

    public final zzdom zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzhff = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbny = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzhfg = publisherAdViewOptions.zzjv();
        }
        return this;
    }
}

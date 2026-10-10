package com.google.android.gms.internal.ads;

import a.a.i;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcep {
    public static final zzcep zzgap = new zzcer().zzamw();
    private final zzaff zzgai;
    private final zzafe zzgaj;
    private final zzaft zzgak;
    private final zzafs zzgal;
    private final zzajk zzgam;
    private final i<String, zzafl> zzgan;
    private final i<String, zzafk> zzgao;

    private zzcep(zzcer zzcerVar) {
        this.zzgai = zzcerVar.zzgai;
        this.zzgaj = zzcerVar.zzgaj;
        this.zzgak = zzcerVar.zzgak;
        this.zzgan = new i<>(zzcerVar.zzgan);
        this.zzgao = new i<>(zzcerVar.zzgao);
        this.zzgal = zzcerVar.zzgal;
        this.zzgam = zzcerVar.zzgam;
    }

    public final zzaff zzamp() {
        return this.zzgai;
    }

    public final zzafe zzamq() {
        return this.zzgaj;
    }

    public final zzaft zzamr() {
        return this.zzgak;
    }

    public final zzafs zzams() {
        return this.zzgal;
    }

    public final zzajk zzamt() {
        return this.zzgam;
    }

    public final ArrayList<String> zzamu() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzgak != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzgai != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzgaj != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzgan.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzgam != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzamv() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzgan.size());
        for (int i = 0; i < this.zzgan.size(); i++) {
            arrayList.add(this.zzgan.b(i));
        }
        return arrayList;
    }

    public final zzafl zzgd(String str) {
        return this.zzgan.get(str);
    }

    public final zzafk zzge(String str) {
        return this.zzgao.get(str);
    }
}

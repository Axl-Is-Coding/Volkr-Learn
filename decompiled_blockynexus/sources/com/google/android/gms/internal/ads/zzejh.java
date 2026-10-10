package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzejh implements zzelz {
    private int tag;
    private final zzeja zzifr;
    private int zzifs;
    private int zzift = 0;

    private zzejh(zzeja zzejaVar) {
        zzekb.zza(zzejaVar, "input");
        this.zzifr = zzejaVar;
        this.zzifr.zzifg = this;
    }

    public static zzejh zza(zzeja zzejaVar) {
        zzejh zzejhVar = zzejaVar.zzifg;
        return zzejhVar != null ? zzejhVar : new zzejh(zzejaVar);
    }

    private final <T> T zzc(zzemf<T> zzemfVar, zzejm zzejmVar) throws IOException {
        int iZzbey = this.zzifr.zzbey();
        zzeja zzejaVar = this.zzifr;
        if (zzejaVar.zzifd >= zzejaVar.zzife) {
            throw new zzekj("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzga = zzejaVar.zzga(iZzbey);
        T tNewInstance = zzemfVar.newInstance();
        this.zzifr.zzifd++;
        zzemfVar.zza(tNewInstance, this, zzejmVar);
        zzemfVar.zzaj(tNewInstance);
        this.zzifr.zzfy(0);
        r5.zzifd--;
        this.zzifr.zzgb(iZzga);
        return tNewInstance;
    }

    private final <T> T zzd(zzemf<T> zzemfVar, zzejm zzejmVar) throws IOException {
        int i = this.zzifs;
        this.zzifs = ((this.tag >>> 3) << 3) | 4;
        try {
            T tNewInstance = zzemfVar.newInstance();
            zzemfVar.zza(tNewInstance, this, zzejmVar);
            zzemfVar.zzaj(tNewInstance);
            if (this.tag == this.zzifs) {
                return tNewInstance;
            }
            throw zzekj.zzbhe();
        } finally {
            this.zzifs = i;
        }
    }

    private final void zzgi(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzekj.zzbhc();
        }
    }

    private static void zzgj(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzekj.zzbhe();
        }
    }

    private static void zzgk(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzekj.zzbhe();
        }
    }

    private final void zzgl(int i) throws IOException {
        if (this.zzifr.zzbfg() != i) {
            throw zzekj.zzbgx();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final double readDouble() throws IOException {
        zzgi(1);
        return this.zzifr.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final float readFloat() throws IOException {
        zzgi(5);
        return this.zzifr.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final String readString() throws IOException {
        zzgi(2);
        return this.zzifr.readString();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzaa(List<Long> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekx)) {
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.zzifr.zzbfd()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbfg = this.zzifr.zzbfg() + this.zzifr.zzbey();
            do {
                list.add(Long.valueOf(this.zzifr.zzbfd()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            zzgl(iZzbfg);
            return;
        }
        zzekx zzekxVar = (zzekx) list;
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                zzekxVar.zzfs(this.zzifr.zzbfd());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbfg2 = this.zzifr.zzbfg() + this.zzifr.zzbey();
        do {
            zzekxVar.zzfs(this.zzifr.zzbfd());
        } while (this.zzifr.zzbfg() < iZzbfg2);
        zzgl(iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final <T> T zzb(zzemf<T> zzemfVar, zzejm zzejmVar) throws IOException {
        zzgi(3);
        return (T) zzd(zzemfVar, zzejmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final long zzbeq() throws IOException {
        zzgi(0);
        return this.zzifr.zzbeq();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final long zzber() throws IOException {
        zzgi(0);
        return this.zzifr.zzber();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final int zzbes() throws IOException {
        zzgi(0);
        return this.zzifr.zzbes();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final long zzbet() throws IOException {
        zzgi(1);
        return this.zzifr.zzbet();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final int zzbeu() throws IOException {
        zzgi(5);
        return this.zzifr.zzbeu();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final boolean zzbev() throws IOException {
        zzgi(0);
        return this.zzifr.zzbev();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final String zzbew() throws IOException {
        zzgi(2);
        return this.zzifr.zzbew();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final zzeip zzbex() throws IOException {
        zzgi(2);
        return this.zzifr.zzbex();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final int zzbey() throws IOException {
        zzgi(0);
        return this.zzifr.zzbey();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final int zzbez() throws IOException {
        zzgi(0);
        return this.zzifr.zzbez();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final int zzbfa() throws IOException {
        zzgi(5);
        return this.zzifr.zzbfa();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final long zzbfb() throws IOException {
        zzgi(1);
        return this.zzifr.zzbfb();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final int zzbfc() throws IOException {
        zzgi(0);
        return this.zzifr.zzbfc();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final long zzbfd() throws IOException {
        zzgi(0);
        return this.zzifr.zzbfd();
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final int zzbfn() throws IOException {
        int i = this.zzift;
        if (i != 0) {
            this.tag = i;
            this.zzift = 0;
        } else {
            this.tag = this.zzifr.zzbep();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzifs) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final boolean zzbfo() throws IOException {
        int i;
        if (this.zzifr.zzbff() || (i = this.tag) == this.zzifs) {
            return false;
        }
        return this.zzifr.zzfz(i);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzl(List<Double> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzejk)) {
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    list.add(Double.valueOf(this.zzifr.readDouble()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbey = this.zzifr.zzbey();
            zzgj(iZzbey);
            int iZzbfg = this.zzifr.zzbfg() + iZzbey;
            do {
                list.add(Double.valueOf(this.zzifr.readDouble()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            return;
        }
        zzejk zzejkVar = (zzejk) list;
        int i2 = this.tag & 7;
        if (i2 == 1) {
            do {
                zzejkVar.zze(this.zzifr.readDouble());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbey2 = this.zzifr.zzbey();
        zzgj(iZzbey2);
        int iZzbfg2 = this.zzifr.zzbfg() + iZzbey2;
        do {
            zzejkVar.zze(this.zzifr.readDouble());
        } while (this.zzifr.zzbfg() < iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzm(List<Float> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzejy)) {
            int i = this.tag & 7;
            if (i == 2) {
                int iZzbey = this.zzifr.zzbey();
                zzgk(iZzbey);
                int iZzbfg = this.zzifr.zzbfg() + iZzbey;
                do {
                    list.add(Float.valueOf(this.zzifr.readFloat()));
                } while (this.zzifr.zzbfg() < iZzbfg);
                return;
            }
            if (i != 5) {
                throw zzekj.zzbhc();
            }
            do {
                list.add(Float.valueOf(this.zzifr.readFloat()));
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep = this.zzifr.zzbep();
                }
            } while (iZzbep == this.tag);
            this.zzift = iZzbep;
            return;
        }
        zzejy zzejyVar = (zzejy) list;
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int iZzbey2 = this.zzifr.zzbey();
            zzgk(iZzbey2);
            int iZzbfg2 = this.zzifr.zzbfg() + iZzbey2;
            do {
                zzejyVar.zzh(this.zzifr.readFloat());
            } while (this.zzifr.zzbfg() < iZzbfg2);
            return;
        }
        if (i2 != 5) {
            throw zzekj.zzbhc();
        }
        do {
            zzejyVar.zzh(this.zzifr.readFloat());
            if (this.zzifr.zzbff()) {
                return;
            } else {
                iZzbep2 = this.zzifr.zzbep();
            }
        } while (iZzbep2 == this.tag);
        this.zzift = iZzbep2;
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzn(List<Long> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekx)) {
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.zzifr.zzbeq()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbfg = this.zzifr.zzbfg() + this.zzifr.zzbey();
            do {
                list.add(Long.valueOf(this.zzifr.zzbeq()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            zzgl(iZzbfg);
            return;
        }
        zzekx zzekxVar = (zzekx) list;
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                zzekxVar.zzfs(this.zzifr.zzbeq());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbfg2 = this.zzifr.zzbfg() + this.zzifr.zzbey();
        do {
            zzekxVar.zzfs(this.zzifr.zzbeq());
        } while (this.zzifr.zzbfg() < iZzbfg2);
        zzgl(iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzo(List<Long> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekx)) {
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(this.zzifr.zzber()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbfg = this.zzifr.zzbfg() + this.zzifr.zzbey();
            do {
                list.add(Long.valueOf(this.zzifr.zzber()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            zzgl(iZzbfg);
            return;
        }
        zzekx zzekxVar = (zzekx) list;
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                zzekxVar.zzfs(this.zzifr.zzber());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbfg2 = this.zzifr.zzbfg() + this.zzifr.zzbey();
        do {
            zzekxVar.zzfs(this.zzifr.zzber());
        } while (this.zzifr.zzbfg() < iZzbfg2);
        zzgl(iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzp(List<Integer> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekc)) {
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zzifr.zzbes()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbfg = this.zzifr.zzbfg() + this.zzifr.zzbey();
            do {
                list.add(Integer.valueOf(this.zzifr.zzbes()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            zzgl(iZzbfg);
            return;
        }
        zzekc zzekcVar = (zzekc) list;
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                zzekcVar.zzhc(this.zzifr.zzbes());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbfg2 = this.zzifr.zzbfg() + this.zzifr.zzbey();
        do {
            zzekcVar.zzhc(this.zzifr.zzbes());
        } while (this.zzifr.zzbfg() < iZzbfg2);
        zzgl(iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzq(List<Long> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekx)) {
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(this.zzifr.zzbet()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbey = this.zzifr.zzbey();
            zzgj(iZzbey);
            int iZzbfg = this.zzifr.zzbfg() + iZzbey;
            do {
                list.add(Long.valueOf(this.zzifr.zzbet()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            return;
        }
        zzekx zzekxVar = (zzekx) list;
        int i2 = this.tag & 7;
        if (i2 == 1) {
            do {
                zzekxVar.zzfs(this.zzifr.zzbet());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbey2 = this.zzifr.zzbey();
        zzgj(iZzbey2);
        int iZzbfg2 = this.zzifr.zzbfg() + iZzbey2;
        do {
            zzekxVar.zzfs(this.zzifr.zzbet());
        } while (this.zzifr.zzbfg() < iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzr(List<Integer> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekc)) {
            int i = this.tag & 7;
            if (i == 2) {
                int iZzbey = this.zzifr.zzbey();
                zzgk(iZzbey);
                int iZzbfg = this.zzifr.zzbfg() + iZzbey;
                do {
                    list.add(Integer.valueOf(this.zzifr.zzbeu()));
                } while (this.zzifr.zzbfg() < iZzbfg);
                return;
            }
            if (i != 5) {
                throw zzekj.zzbhc();
            }
            do {
                list.add(Integer.valueOf(this.zzifr.zzbeu()));
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep = this.zzifr.zzbep();
                }
            } while (iZzbep == this.tag);
            this.zzift = iZzbep;
            return;
        }
        zzekc zzekcVar = (zzekc) list;
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int iZzbey2 = this.zzifr.zzbey();
            zzgk(iZzbey2);
            int iZzbfg2 = this.zzifr.zzbfg() + iZzbey2;
            do {
                zzekcVar.zzhc(this.zzifr.zzbeu());
            } while (this.zzifr.zzbfg() < iZzbfg2);
            return;
        }
        if (i2 != 5) {
            throw zzekj.zzbhc();
        }
        do {
            zzekcVar.zzhc(this.zzifr.zzbeu());
            if (this.zzifr.zzbff()) {
                return;
            } else {
                iZzbep2 = this.zzifr.zzbep();
            }
        } while (iZzbep2 == this.tag);
        this.zzift = iZzbep2;
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzs(List<Boolean> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzein)) {
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzifr.zzbev()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbfg = this.zzifr.zzbfg() + this.zzifr.zzbey();
            do {
                list.add(Boolean.valueOf(this.zzifr.zzbev()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            zzgl(iZzbfg);
            return;
        }
        zzein zzeinVar = (zzein) list;
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                zzeinVar.addBoolean(this.zzifr.zzbev());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbfg2 = this.zzifr.zzbfg() + this.zzifr.zzbey();
        do {
            zzeinVar.addBoolean(this.zzifr.zzbev());
        } while (this.zzifr.zzbfg() < iZzbfg2);
        zzgl(iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzt(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzu(List<zzeip> list) throws IOException {
        int iZzbep;
        if ((this.tag & 7) != 2) {
            throw zzekj.zzbhc();
        }
        do {
            list.add(zzbex());
            if (this.zzifr.zzbff()) {
                return;
            } else {
                iZzbep = this.zzifr.zzbep();
            }
        } while (iZzbep == this.tag);
        this.zzift = iZzbep;
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzv(List<Integer> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekc)) {
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zzifr.zzbey()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbfg = this.zzifr.zzbfg() + this.zzifr.zzbey();
            do {
                list.add(Integer.valueOf(this.zzifr.zzbey()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            zzgl(iZzbfg);
            return;
        }
        zzekc zzekcVar = (zzekc) list;
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                zzekcVar.zzhc(this.zzifr.zzbey());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbfg2 = this.zzifr.zzbfg() + this.zzifr.zzbey();
        do {
            zzekcVar.zzhc(this.zzifr.zzbey());
        } while (this.zzifr.zzbfg() < iZzbfg2);
        zzgl(iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzw(List<Integer> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekc)) {
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zzifr.zzbez()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbfg = this.zzifr.zzbfg() + this.zzifr.zzbey();
            do {
                list.add(Integer.valueOf(this.zzifr.zzbez()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            zzgl(iZzbfg);
            return;
        }
        zzekc zzekcVar = (zzekc) list;
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                zzekcVar.zzhc(this.zzifr.zzbez());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbfg2 = this.zzifr.zzbfg() + this.zzifr.zzbey();
        do {
            zzekcVar.zzhc(this.zzifr.zzbez());
        } while (this.zzifr.zzbfg() < iZzbfg2);
        zzgl(iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzx(List<Integer> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekc)) {
            int i = this.tag & 7;
            if (i == 2) {
                int iZzbey = this.zzifr.zzbey();
                zzgk(iZzbey);
                int iZzbfg = this.zzifr.zzbfg() + iZzbey;
                do {
                    list.add(Integer.valueOf(this.zzifr.zzbfa()));
                } while (this.zzifr.zzbfg() < iZzbfg);
                return;
            }
            if (i != 5) {
                throw zzekj.zzbhc();
            }
            do {
                list.add(Integer.valueOf(this.zzifr.zzbfa()));
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep = this.zzifr.zzbep();
                }
            } while (iZzbep == this.tag);
            this.zzift = iZzbep;
            return;
        }
        zzekc zzekcVar = (zzekc) list;
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int iZzbey2 = this.zzifr.zzbey();
            zzgk(iZzbey2);
            int iZzbfg2 = this.zzifr.zzbfg() + iZzbey2;
            do {
                zzekcVar.zzhc(this.zzifr.zzbfa());
            } while (this.zzifr.zzbfg() < iZzbfg2);
            return;
        }
        if (i2 != 5) {
            throw zzekj.zzbhc();
        }
        do {
            zzekcVar.zzhc(this.zzifr.zzbfa());
            if (this.zzifr.zzbff()) {
                return;
            } else {
                iZzbep2 = this.zzifr.zzbep();
            }
        } while (iZzbep2 == this.tag);
        this.zzift = iZzbep2;
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzy(List<Long> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekx)) {
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(this.zzifr.zzbfb()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbey = this.zzifr.zzbey();
            zzgj(iZzbey);
            int iZzbfg = this.zzifr.zzbfg() + iZzbey;
            do {
                list.add(Long.valueOf(this.zzifr.zzbfb()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            return;
        }
        zzekx zzekxVar = (zzekx) list;
        int i2 = this.tag & 7;
        if (i2 == 1) {
            do {
                zzekxVar.zzfs(this.zzifr.zzbfb());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbey2 = this.zzifr.zzbey();
        zzgj(iZzbey2);
        int iZzbfg2 = this.zzifr.zzbfg() + iZzbey2;
        do {
            zzekxVar.zzfs(this.zzifr.zzbfb());
        } while (this.zzifr.zzbfg() < iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final void zzz(List<Integer> list) throws IOException {
        int iZzbep;
        int iZzbep2;
        if (!(list instanceof zzekc)) {
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.zzifr.zzbfc()));
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep = this.zzifr.zzbep();
                    }
                } while (iZzbep == this.tag);
                this.zzift = iZzbep;
                return;
            }
            if (i != 2) {
                throw zzekj.zzbhc();
            }
            int iZzbfg = this.zzifr.zzbfg() + this.zzifr.zzbey();
            do {
                list.add(Integer.valueOf(this.zzifr.zzbfc()));
            } while (this.zzifr.zzbfg() < iZzbfg);
            zzgl(iZzbfg);
            return;
        }
        zzekc zzekcVar = (zzekc) list;
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                zzekcVar.zzhc(this.zzifr.zzbfc());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep2 = this.zzifr.zzbep();
                }
            } while (iZzbep2 == this.tag);
            this.zzift = iZzbep2;
            return;
        }
        if (i2 != 2) {
            throw zzekj.zzbhc();
        }
        int iZzbfg2 = this.zzifr.zzbfg() + this.zzifr.zzbey();
        do {
            zzekcVar.zzhc(this.zzifr.zzbfc());
        } while (this.zzifr.zzbfg() < iZzbfg2);
        zzgl(iZzbfg2);
    }

    @Override // com.google.android.gms.internal.ads.zzelz
    public final <T> T zza(zzemf<T> zzemfVar, zzejm zzejmVar) throws IOException {
        zzgi(2);
        return (T) zzc(zzemfVar, zzejmVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzelz
    public final <T> void zzb(List<T> list, zzemf<T> zzemfVar, zzejm zzejmVar) throws IOException {
        int iZzbep;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzemfVar, zzejmVar));
                if (this.zzifr.zzbff() || this.zzift != 0) {
                    return;
                } else {
                    iZzbep = this.zzifr.zzbep();
                }
            } while (iZzbep == i);
            this.zzift = iZzbep;
            return;
        }
        throw zzekj.zzbhc();
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int iZzbep;
        int iZzbep2;
        if ((this.tag & 7) == 2) {
            if ((list instanceof zzeku) && !z) {
                zzeku zzekuVar = (zzeku) list;
                do {
                    zzekuVar.zzaj(zzbex());
                    if (this.zzifr.zzbff()) {
                        return;
                    } else {
                        iZzbep2 = this.zzifr.zzbep();
                    }
                } while (iZzbep2 == this.tag);
                this.zzift = iZzbep2;
                return;
            }
            do {
                list.add(z ? zzbew() : readString());
                if (this.zzifr.zzbff()) {
                    return;
                } else {
                    iZzbep = this.zzifr.zzbep();
                }
            } while (iZzbep == this.tag);
            this.zzift = iZzbep;
            return;
        }
        throw zzekj.zzbhc();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzelz
    public final <T> void zza(List<T> list, zzemf<T> zzemfVar, zzejm zzejmVar) throws IOException {
        int iZzbep;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzemfVar, zzejmVar));
                if (this.zzifr.zzbff() || this.zzift != 0) {
                    return;
                } else {
                    iZzbep = this.zzifr.zzbep();
                }
            } while (iZzbep == i);
            this.zzift = iZzbep;
            return;
        }
        throw zzekj.zzbhc();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzelz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.ads.zzele<K, V> r9, com.google.android.gms.internal.ads.zzejm r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzgi(r0)
            com.google.android.gms.internal.ads.zzeja r1 = r7.zzifr
            int r1 = r1.zzbey()
            com.google.android.gms.internal.ads.zzeja r2 = r7.zzifr
            int r1 = r2.zzga(r1)
            K r2 = r9.zzilj
            V r3 = r9.zzclg
        L14:
            int r4 = r7.zzbfn()     // Catch: java.lang.Throwable -> L64
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5b
            com.google.android.gms.internal.ads.zzeja r5 = r7.zzifr     // Catch: java.lang.Throwable -> L64
            boolean r5 = r5.zzbff()     // Catch: java.lang.Throwable -> L64
            if (r5 != 0) goto L5b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L46
            if (r4 == r0) goto L39
            boolean r4 = r7.zzbfo()     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.ads.zzekj r4 = new com.google.android.gms.internal.ads.zzekj     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
            r4.<init>(r6)     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
            throw r4     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
        L39:
            com.google.android.gms.internal.ads.zzeno r4 = r9.zzilk     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
            V r5 = r9.zzclg     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
            goto L14
        L46:
            com.google.android.gms.internal.ads.zzeno r4 = r9.zzili     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: com.google.android.gms.internal.ads.zzekm -> L4e java.lang.Throwable -> L64
            goto L14
        L4e:
            boolean r4 = r7.zzbfo()     // Catch: java.lang.Throwable -> L64
            if (r4 == 0) goto L55
            goto L14
        L55:
            com.google.android.gms.internal.ads.zzekj r8 = new com.google.android.gms.internal.ads.zzekj     // Catch: java.lang.Throwable -> L64
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L64
            throw r8     // Catch: java.lang.Throwable -> L64
        L5b:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.internal.ads.zzeja r8 = r7.zzifr
            r8.zzgb(r1)
            return
        L64:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzeja r9 = r7.zzifr
            r9.zzgb(r1)
            goto L6c
        L6b:
            throw r8
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejh.zza(java.util.Map, com.google.android.gms.internal.ads.zzele, com.google.android.gms.internal.ads.zzejm):void");
    }

    private final Object zza(zzeno zzenoVar, Class<?> cls, zzejm zzejmVar) throws IOException {
        switch (zzejg.zzifq[zzenoVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbev());
            case 2:
                return zzbex();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbez());
            case 5:
                return Integer.valueOf(zzbeu());
            case 6:
                return Long.valueOf(zzbet());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbes());
            case 9:
                return Long.valueOf(zzber());
            case 10:
                zzgi(2);
                return zzc(zzely.zzbic().zzh(cls), zzejmVar);
            case 11:
                return Integer.valueOf(zzbfa());
            case 12:
                return Long.valueOf(zzbfb());
            case 13:
                return Integer.valueOf(zzbfc());
            case 14:
                return Long.valueOf(zzbfd());
            case 15:
                return zzbew();
            case 16:
                return Integer.valueOf(zzbey());
            case 17:
                return Long.valueOf(zzbeq());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}

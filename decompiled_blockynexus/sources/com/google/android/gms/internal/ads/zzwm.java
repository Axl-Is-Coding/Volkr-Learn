package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.Random;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzwm {
    private static zzwm zzcix = new zzwm();
    private final zzbbg zzciy;
    private final zzvx zzciz;
    private final String zzcja;
    private final zzaaw zzcjb;
    private final zzaay zzcjc;
    private final zzaax zzcjd;
    private final zzbbx zzcje;
    private final Random zzcjf;
    private final WeakHashMap<QueryInfo, String> zzcjg;

    protected zzwm() {
        this(new zzbbg(), new zzvx(new zzve(), new zzvf(), new zzzl(), new zzagi(), new zzauk(), new zzavo(), new zzaqz(), new zzagh()), new zzaaw(), new zzaay(), new zzaax(), zzbbg.zzyo(), new zzbbx(0, 202510000, true), new Random(), new WeakHashMap());
    }

    public static zzbbg zzpt() {
        return zzcix.zzciy;
    }

    public static zzvx zzpu() {
        return zzcix.zzciz;
    }

    public static zzaay zzpv() {
        return zzcix.zzcjc;
    }

    public static zzaaw zzpw() {
        return zzcix.zzcjb;
    }

    public static zzaax zzpx() {
        return zzcix.zzcjd;
    }

    public static String zzpy() {
        return zzcix.zzcja;
    }

    public static zzbbx zzpz() {
        return zzcix.zzcje;
    }

    public static Random zzqa() {
        return zzcix.zzcjf;
    }

    public static WeakHashMap<QueryInfo, String> zzqb() {
        return zzcix.zzcjg;
    }

    private zzwm(zzbbg zzbbgVar, zzvx zzvxVar, zzaaw zzaawVar, zzaay zzaayVar, zzaax zzaaxVar, String str, zzbbx zzbbxVar, Random random, WeakHashMap<QueryInfo, String> weakHashMap) {
        this.zzciy = zzbbgVar;
        this.zzciz = zzvxVar;
        this.zzcjb = zzaawVar;
        this.zzcjc = zzaayVar;
        this.zzcjd = zzaaxVar;
        this.zzcja = str;
        this.zzcje = zzbbxVar;
        this.zzcjf = random;
        this.zzcjg = weakHashMap;
    }
}

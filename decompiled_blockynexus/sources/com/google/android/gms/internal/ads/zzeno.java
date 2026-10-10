package com.google.android.gms.internal.ads;

import com.tendcloud.tenddata.a;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzipe' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeno {
    public static final zzeno zziow = new zzeno("DOUBLE", 0, zzenr.DOUBLE, 1);
    public static final zzeno zziox = new zzeno("FLOAT", 1, zzenr.FLOAT, 5);
    public static final zzeno zzioy = new zzeno("INT64", 2, zzenr.LONG, 0);
    public static final zzeno zzioz = new zzeno("UINT64", 3, zzenr.LONG, 0);
    public static final zzeno zzipa = new zzeno("INT32", 4, zzenr.INT, 0);
    public static final zzeno zzipb = new zzeno("FIXED64", 5, zzenr.LONG, 1);
    public static final zzeno zzipc = new zzeno("FIXED32", 6, zzenr.INT, 5);
    public static final zzeno zzipd = new zzeno("BOOL", 7, zzenr.BOOLEAN, 0);
    public static final zzeno zzipe;
    public static final zzeno zzipf;
    public static final zzeno zzipg;
    public static final zzeno zziph;
    public static final zzeno zzipi;
    public static final zzeno zzipj;
    public static final zzeno zzipk;
    public static final zzeno zzipl;
    public static final zzeno zzipm;
    public static final zzeno zzipn;
    private static final /* synthetic */ zzeno[] zzipq;
    private final zzenr zzipo;
    private final int zzipp;

    static {
        final int i = 2;
        final int i2 = 3;
        final zzenr zzenrVar = zzenr.STRING;
        final int i3 = 8;
        final String str = a.MF_STRING;
        zzipe = new zzeno(str, i3, zzenrVar, i) { // from class: com.google.android.gms.internal.ads.zzenn
            {
                int i4 = 8;
                int i5 = 2;
                zzenl zzenlVar = null;
            }
        };
        final zzenr zzenrVar2 = zzenr.MESSAGE;
        final int i4 = 9;
        final String str2 = "GROUP";
        zzipf = new zzeno(str2, i4, zzenrVar2, i2) { // from class: com.google.android.gms.internal.ads.zzenq
            {
                int i5 = 9;
                int i6 = 3;
                zzenl zzenlVar = null;
            }
        };
        final zzenr zzenrVar3 = zzenr.MESSAGE;
        final int i5 = 10;
        final String str3 = "MESSAGE";
        zzipg = new zzeno(str3, i5, zzenrVar3, i) { // from class: com.google.android.gms.internal.ads.zzenp
            {
                int i6 = 10;
                int i7 = 2;
                zzenl zzenlVar = null;
            }
        };
        final zzenr zzenrVar4 = zzenr.BYTE_STRING;
        final int i6 = 11;
        final String str4 = "BYTES";
        zziph = new zzeno(str4, i6, zzenrVar4, i) { // from class: com.google.android.gms.internal.ads.zzens
            {
                int i7 = 11;
                int i8 = 2;
                zzenl zzenlVar = null;
            }
        };
        zzipi = new zzeno("UINT32", 12, zzenr.INT, 0);
        zzipj = new zzeno("ENUM", 13, zzenr.ENUM, 0);
        zzipk = new zzeno("SFIXED32", 14, zzenr.INT, 5);
        zzipl = new zzeno("SFIXED64", 15, zzenr.LONG, 1);
        zzipm = new zzeno("SINT32", 16, zzenr.INT, 0);
        zzipn = new zzeno("SINT64", 17, zzenr.LONG, 0);
        zzipq = new zzeno[]{zziow, zziox, zzioy, zzioz, zzipa, zzipb, zzipc, zzipd, zzipe, zzipf, zzipg, zziph, zzipi, zzipj, zzipk, zzipl, zzipm, zzipn};
    }

    private zzeno(String str, int i, zzenr zzenrVar, int i2) {
        this.zzipo = zzenrVar;
        this.zzipp = i2;
    }

    public static zzeno[] values() {
        return (zzeno[]) zzipq.clone();
    }

    public final zzenr zzbje() {
        return this.zzipo;
    }

    public final int zzbjf() {
        return this.zzipp;
    }

    /* synthetic */ zzeno(String str, int i, zzenr zzenrVar, int i2, zzenl zzenlVar) {
        this(str, i, zzenrVar, i2);
    }
}

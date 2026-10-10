package com.google.android.gms.internal.measurement;

import com.tendcloud.tenddata.a;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzi' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzlg {
    public static final zzlg zza = new zzlg("DOUBLE", 0, zzln.DOUBLE, 1);
    public static final zzlg zzb = new zzlg("FLOAT", 1, zzln.FLOAT, 5);
    public static final zzlg zzc = new zzlg("INT64", 2, zzln.LONG, 0);
    public static final zzlg zzd = new zzlg("UINT64", 3, zzln.LONG, 0);
    public static final zzlg zze = new zzlg("INT32", 4, zzln.INT, 0);
    public static final zzlg zzf = new zzlg("FIXED64", 5, zzln.LONG, 1);
    public static final zzlg zzg = new zzlg("FIXED32", 6, zzln.INT, 5);
    public static final zzlg zzh = new zzlg("BOOL", 7, zzln.BOOLEAN, 0);
    public static final zzlg zzi;
    public static final zzlg zzj;
    public static final zzlg zzk;
    public static final zzlg zzl;
    public static final zzlg zzm;
    public static final zzlg zzn;
    public static final zzlg zzo;
    public static final zzlg zzp;
    public static final zzlg zzq;
    public static final zzlg zzr;
    private static final /* synthetic */ zzlg[] zzu;
    private final zzln zzs;
    private final int zzt;

    static {
        final int i = 2;
        final int i2 = 3;
        final zzln zzlnVar = zzln.STRING;
        final int i3 = 8;
        final String str = a.MF_STRING;
        zzi = new zzlg(str, i3, zzlnVar, i) { // from class: com.google.android.gms.internal.measurement.zzlj
            {
                int i4 = 8;
                int i5 = 2;
                zzlh zzlhVar = null;
            }
        };
        final zzln zzlnVar2 = zzln.MESSAGE;
        final int i4 = 9;
        final String str2 = "GROUP";
        zzj = new zzlg(str2, i4, zzlnVar2, i2) { // from class: com.google.android.gms.internal.measurement.zzli
            {
                int i5 = 9;
                int i6 = 3;
                zzlh zzlhVar = null;
            }
        };
        final zzln zzlnVar3 = zzln.MESSAGE;
        final int i5 = 10;
        final String str3 = "MESSAGE";
        zzk = new zzlg(str3, i5, zzlnVar3, i) { // from class: com.google.android.gms.internal.measurement.zzll
            {
                int i6 = 10;
                int i7 = 2;
                zzlh zzlhVar = null;
            }
        };
        final zzln zzlnVar4 = zzln.BYTE_STRING;
        final int i6 = 11;
        final String str4 = "BYTES";
        zzl = new zzlg(str4, i6, zzlnVar4, i) { // from class: com.google.android.gms.internal.measurement.zzlk
            {
                int i7 = 11;
                int i8 = 2;
                zzlh zzlhVar = null;
            }
        };
        zzm = new zzlg("UINT32", 12, zzln.INT, 0);
        zzn = new zzlg("ENUM", 13, zzln.ENUM, 0);
        zzo = new zzlg("SFIXED32", 14, zzln.INT, 5);
        zzp = new zzlg("SFIXED64", 15, zzln.LONG, 1);
        zzq = new zzlg("SINT32", 16, zzln.INT, 0);
        zzr = new zzlg("SINT64", 17, zzln.LONG, 0);
        zzu = new zzlg[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr};
    }

    private zzlg(String str, int i, zzln zzlnVar, int i2) {
        this.zzs = zzlnVar;
        this.zzt = i2;
    }

    public static zzlg[] values() {
        return (zzlg[]) zzu.clone();
    }

    public final zzln zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzlg(String str, int i, zzln zzlnVar, int i2, zzlh zzlhVar) {
        this(str, i, zzlnVar, i2);
    }
}

package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlg implements zzjv {
    private static final zzka zzapj = new zzlf();
    private static final int zzaxl = zzpq.zzbl("seig");
    private static final byte[] zzaxm = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long zzaih;
    private final zzpk zzapq;
    private int zzarf;
    private int zzarg;
    private zzjx zzarj;
    private final zzln zzaxn;
    private final SparseArray<zzlh> zzaxo;
    private final zzpk zzaxp;
    private final zzpk zzaxq;
    private final zzpk zzaxr;
    private final zzpo zzaxs;
    private final zzpk zzaxt;
    private final byte[] zzaxu;
    private final Stack<zzku> zzaxv;
    private final LinkedList<zzli> zzaxw;
    private int zzaxx;
    private int zzaxy;
    private long zzaxz;
    private int zzaya;
    private zzpk zzayb;
    private long zzayc;
    private int zzayd;
    private long zzaye;
    private zzlh zzayf;
    private int zzayg;
    private boolean zzayh;
    private zzkg zzayi;
    private zzkg[] zzayj;
    private boolean zzayk;

    public zzlg() {
        this(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzjn zzb(java.util.List<com.google.android.gms.internal.ads.zzkt> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L8:
            if (r3 >= r0) goto Lb9
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzkt r5 = (com.google.android.gms.internal.ads.zzkt) r5
            int r6 = r5.type
            int r7 = com.google.android.gms.internal.ads.zzkr.zzaum
            if (r6 != r7) goto Lb5
            if (r4 != 0) goto L1d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L1d:
            com.google.android.gms.internal.ads.zzpk r5 = r5.zzawi
            byte[] r5 = r5.data
            com.google.android.gms.internal.ads.zzpk r6 = new com.google.android.gms.internal.ads.zzpk
            r6.<init>(r5)
            int r7 = r6.limit()
            r8 = 32
            if (r7 >= r8) goto L30
        L2e:
            r6 = r2
            goto L99
        L30:
            r6.zzbo(r1)
            int r7 = r6.readInt()
            int r8 = r6.zzja()
            int r8 = r8 + 4
            if (r7 == r8) goto L40
            goto L2e
        L40:
            int r7 = r6.readInt()
            int r8 = com.google.android.gms.internal.ads.zzkr.zzaum
            if (r7 == r8) goto L49
            goto L2e
        L49:
            int r7 = r6.readInt()
            int r7 = com.google.android.gms.internal.ads.zzkr.zzaq(r7)
            r8 = 1
            if (r7 <= r8) goto L6d
            r6 = 37
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r6)
            java.lang.String r6 = "Unsupported pssh version: "
            r8.append(r6)
            r8.append(r7)
            java.lang.String r6 = r8.toString()
            java.lang.String r7 = "PsshAtomUtil"
            android.util.Log.w(r7, r6)
            goto L2e
        L6d:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.readLong()
            long r12 = r6.readLong()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L85
            int r7 = r6.zzjf()
            int r7 = r7 << 4
            r6.zzbp(r7)
        L85:
            int r7 = r6.zzjf()
            int r8 = r6.zzja()
            if (r7 == r8) goto L90
            goto L2e
        L90:
            byte[] r8 = new byte[r7]
            r6.zze(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L99:
            if (r6 != 0) goto L9d
            r6 = r2
            goto La1
        L9d:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        La1:
            if (r6 != 0) goto Lab
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto Lb5
        Lab:
            com.google.android.gms.internal.ads.zzjn$zza r7 = new com.google.android.gms.internal.ads.zzjn$zza
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5)
            r4.add(r7)
        Lb5:
            int r3 = r3 + 1
            goto L8
        Lb9:
            if (r4 != 0) goto Lbc
            return r2
        Lbc:
            com.google.android.gms.internal.ads.zzjn r14 = new com.google.android.gms.internal.ads.zzjn
            r14.<init>(r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlg.zzb(java.util.List):com.google.android.gms.internal.ads.zzjn");
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x068b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzeb(long r55) throws com.google.android.gms.internal.ads.zzhv {
        /*
            Method dump skipped, instruction units count: 1782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlg.zzeb(long):void");
    }

    private final void zzhb() {
        this.zzaxx = 0;
        this.zzaya = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final boolean zza(zzjy zzjyVar) throws InterruptedException, IOException {
        return zzlo.zzd(zzjyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzc(long j, long j2) {
        int size = this.zzaxo.size();
        for (int i = 0; i < size; i++) {
            this.zzaxo.valueAt(i).reset();
        }
        this.zzaxw.clear();
        this.zzayd = 0;
        this.zzaxv.clear();
        zzhb();
    }

    private zzlg(int i) {
        this(0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zza(zzjx zzjxVar) {
        this.zzarj = zzjxVar;
    }

    private zzlg(int i, zzpo zzpoVar) {
        this(0, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0272 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0271 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x05cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x05c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c5 A[LOOP:6: B:68:0x01c5->B:70:0x01cb, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e1  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzjv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzjy r26, com.google.android.gms.internal.ads.zzkb r27) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlg.zza(com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzkb):int");
    }

    private zzlg(int i, zzpo zzpoVar, zzln zzlnVar) {
        this.flags = i;
        this.zzaxs = null;
        this.zzaxn = null;
        this.zzaxt = new zzpk(16);
        this.zzapq = new zzpk(zzpf.zzbjr);
        this.zzaxp = new zzpk(5);
        this.zzaxq = new zzpk();
        this.zzaxr = new zzpk(1);
        this.zzaxu = new byte[16];
        this.zzaxv = new Stack<>();
        this.zzaxw = new LinkedList<>();
        this.zzaxo = new SparseArray<>();
        this.zzaih = -9223372036854775807L;
        this.zzaye = -9223372036854775807L;
        zzhb();
    }

    private static void zza(zzpk zzpkVar, int i, zzlp zzlpVar) throws zzhv {
        zzpkVar.zzbo(i + 8);
        int iZzar = zzkr.zzar(zzpkVar.readInt());
        if ((iZzar & 1) == 0) {
            boolean z = (iZzar & 2) != 0;
            int iZzjf = zzpkVar.zzjf();
            int i2 = zzlpVar.zzaxc;
            if (iZzjf == i2) {
                Arrays.fill(zzlpVar.zzbav, 0, iZzjf, z);
                zzlpVar.zzaw(zzpkVar.zzja());
                zzpkVar.zze(zzlpVar.zzbay.data, 0, zzlpVar.zzbax);
                zzlpVar.zzbay.zzbo(0);
                zzlpVar.zzbaz = false;
                return;
            }
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(iZzjf);
            sb.append(", ");
            sb.append(i2);
            throw new zzhv(sb.toString());
        }
        throw new zzhv("Overriding TrackEncryptionBox parameters is unsupported.");
    }
}

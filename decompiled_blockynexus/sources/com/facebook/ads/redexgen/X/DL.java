package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DL {
    public static String[] A0D;
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final CM A0C;

    static {
        A00();
    }

    public static void A00() {
        A0D = new String[]{"AytN1i9iULWpAtR2eIfx7QogEUuyUUX4", "EimBg0", "4eNGQSgLmn9gvaK14R8kSqnFmk3YDtSi", "2fyuIcJ7pz76VyZl9SMNa1chyaGQvScm", "P7Bhpggufyl3vqAGq89SAtaTbaXWozcC", "R5XBsX91lZ7HUyZ9KaLj5rOllXZCV26j", "kcg4Z6bP9bO4onTQZ6Z5ctV", "10vbbYYZLuUPLbeNO2JvVvesRy5vOtek"};
    }

    public DL(CM cm) {
        this.A0C = cm;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void A01(int i) {
        boolean z = this.A0A;
        this.A0C.ACy(this.A04, z ? 1 : 0, (int) (this.A01 - this.A03), i, null);
    }

    public final void A02() {
        this.A07 = false;
        this.A06 = false;
        this.A05 = false;
        this.A09 = false;
        this.A0B = false;
    }

    public final void A03(long j, int i) {
        if (this.A0B && this.A06) {
            this.A0A = this.A08;
            String[] strArr = A0D;
            if (strArr[1].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[7] = "hh10uoQ2wjGgTUsUevn281NORx98TkB1";
            strArr2[7] = "hh10uoQ2wjGgTUsUevn281NORx98TkB1";
            this.A0B = false;
            return;
        }
        if (!this.A05 && !this.A06) {
            return;
        }
        if (this.A09) {
            A01(i + ((int) (j - this.A01)));
        }
        this.A03 = this.A01;
        this.A04 = this.A02;
        this.A09 = true;
        this.A0A = this.A08;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A04(long r7, int r9, int r10, long r11) {
        /*
            r6 = this;
            r2 = 0
            r6.A06 = r2
            r6.A05 = r2
            r6.A02 = r11
            r6.A00 = r2
            r6.A01 = r7
            r4 = 1
            r0 = 32
            if (r10 < r0) goto L48
            boolean r0 = r6.A0B
            if (r0 != 0) goto L1d
            boolean r0 = r6.A09
            if (r0 == 0) goto L1d
            r6.A01(r9)
            r6.A09 = r2
        L1d:
            r0 = 34
            if (r10 > r0) goto L48
            boolean r5 = r6.A0B
            r5 = r5 ^ r4
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.DL.A0D
            r0 = 2
            r1 = r3[r0]
            r0 = 3
            r3 = r3[r0]
            r0 = 16
            char r1 = r1.charAt(r0)
            char r0 = r3.charAt(r0)
            if (r1 == r0) goto L84
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.DL.A0D
            java.lang.String r1 = "wqfZZQZmQi2aSzTJgSnfuEG5zpWvg4YI"
            r0 = 2
            r3[r0] = r1
            java.lang.String r1 = "uUijDIjLUkfNDtGFhTuIbp3J3vWPjHax"
            r0 = 3
            r3[r0] = r1
            r6.A05 = r5
            r6.A0B = r4
        L48:
            r4 = 16
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.DL.A0D
            r0 = 2
            r1 = r3[r0]
            r0 = 3
            r3 = r3[r0]
            r0 = 16
            char r1 = r1.charAt(r0)
            char r0 = r3.charAt(r0)
            if (r1 == r0) goto L7f
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.DL.A0D
            java.lang.String r1 = "VgXbI0fWsc6LBLXRTGKiMc1TRthchDi6"
            r0 = 7
            r3[r0] = r1
            java.lang.String r1 = "VgXbI0fWsc6LBLXRTGKiMc1TRthchDi6"
            r0 = 7
            r3[r0] = r1
            if (r10 < r4) goto L82
        L6c:
            r0 = 21
            if (r10 > r0) goto L82
            r0 = 1
        L71:
            r6.A08 = r0
            boolean r0 = r6.A08
            if (r0 != 0) goto L7b
            r0 = 9
            if (r10 > r0) goto L7c
        L7b:
            r2 = 1
        L7c:
            r6.A07 = r2
            return
        L7f:
            if (r10 < r4) goto L82
            goto L6c
        L82:
            r0 = 0
            goto L71
        L84:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DL.A04(long, int, int, long):void");
    }

    public final void A05(byte[] bArr, int i, int i2) {
        if (this.A07) {
            int i3 = this.A00;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                this.A06 = (bArr[i4] & 128) != 0;
                this.A07 = false;
                return;
            }
            int i5 = i3 + (i2 - i);
            if (A0D[0].charAt(24) != 'E') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[0] = "OWSyVtAwrfkSOzobpeDsxETSEBQPa9qP";
            strArr[0] = "OWSyVtAwrfkSOzobpeDsxETSEBQPa9qP";
            this.A00 = i5;
        }
    }
}

package com.facebook.ads.redexgen.X;

import java.io.Writer;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class LF extends Writer {
    public static String[] A03;
    public int A00;
    public char[] A01 = new char[1024];
    public final LE A02;

    static {
        A01();
    }

    public static void A01() {
        A03 = new String[]{"m3VYVt1tyYlWEg8H2HS3pUr0VsrhpbIN", "rEdvzR", "IUQqTrakmjCy7RtoUebGZ8YLkwuKbv7t", "x1ufNW", "e7NtJ1", "AK7iWzpXctzvcUrQA38QQTSmPkrm2HP", "25DCnOqD1cr08G9nl6wTfczykol7NaSA", "0bM1VBntYb2o4FFsMu8yzxmwObMsLmHM"};
    }

    public LF(LE le) {
        this.A02 = le;
    }

    private void A00() {
        this.A02.AC5(new String(this.A01, 0, this.A00));
        this.A00 = 0;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        flush();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        if (this.A00 > 0) {
            A00();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void write(char[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r3 = r7
        L1:
            int r4 = r7 + r8
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.LF.A03
            r0 = 3
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L1b
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1b:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.LF.A03
            java.lang.String r1 = "5m1TKypG4e5yu"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "5m1TKypG4e5yu"
            r0 = 5
            r2[r0] = r1
            if (r3 >= r4) goto L45
            char r1 = r6[r3]
            r0 = 10
            if (r1 == r0) goto L36
            int r2 = r5.A00
            char[] r1 = r5.A01
            int r0 = r1.length
            if (r2 != r0) goto L3c
        L36:
            r5.A00()
        L39:
            int r3 = r3 + 1
            goto L1
        L3c:
            char r0 = r6[r3]
            r1[r2] = r0
            int r0 = r2 + 1
            r5.A00 = r0
            goto L39
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LF.write(char[], int, int):void");
    }
}

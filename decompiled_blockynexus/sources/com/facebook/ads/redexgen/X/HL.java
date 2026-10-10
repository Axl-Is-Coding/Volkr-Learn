package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class HL extends IOException {
    public final int A00;
    public final HG A01;

    public HL(IOException iOException, HG hg, int i) {
        super(iOException);
        this.A01 = hg;
        this.A00 = i;
    }

    public HL(String str, HG hg, int i) {
        super(str);
        this.A01 = hg;
        this.A00 = i;
    }

    public HL(String str, IOException iOException, HG hg, int i) {
        super(str, iOException);
        this.A01 = hg;
        this.A00 = i;
    }
}

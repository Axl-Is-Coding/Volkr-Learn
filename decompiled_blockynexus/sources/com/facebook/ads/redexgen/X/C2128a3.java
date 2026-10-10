package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2128a3 implements LE {
    public final Collection<String> A00;

    public C2128a3() {
        this.A00 = new ArrayList();
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void AC5(String str) {
        this.A00.add(str);
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void flush() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String line : this.A00) {
            sb.append(line);
            sb.append('\n');
        }
        return sb.toString();
    }
}

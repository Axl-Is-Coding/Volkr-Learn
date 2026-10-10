package com.facebook.ads.redexgen.X;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class S5<K, V> extends C2O<K, V> {
    public final /* synthetic */ S6 A00;

    public S5(S6 s6) {
        this.A00 = s6;
    }

    @Override // com.facebook.ads.redexgen.X.C2O
    public final int A05() {
        return ((C2R) this.A00).A00;
    }

    @Override // com.facebook.ads.redexgen.X.C2O
    public final int A06(Object obj) {
        return this.A00.A09(obj);
    }

    @Override // com.facebook.ads.redexgen.X.C2O
    public final int A07(Object obj) {
        return this.A00.A08(obj);
    }

    @Override // com.facebook.ads.redexgen.X.C2O
    public final Object A08(int i, int i2) {
        return this.A00.A02[(i << 1) + i2];
    }

    @Override // com.facebook.ads.redexgen.X.C2O
    public final V A09(int i, V v) {
        V value = this.A00.A0D(i, v);
        return value;
    }

    @Override // com.facebook.ads.redexgen.X.C2O
    public final Map<K, V> A0B() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.C2O
    public final void A0E() {
        this.A00.clear();
    }

    @Override // com.facebook.ads.redexgen.X.C2O
    public final void A0F(int i) {
        this.A00.A0B(i);
    }

    @Override // com.facebook.ads.redexgen.X.C2O
    public final void A0G(K k, V v) {
        this.A00.put(k, v);
    }
}

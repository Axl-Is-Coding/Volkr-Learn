package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.25, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass25 implements Serializable {
    public static final long serialVersionUID = -3209129042070173126L;
    public AnonymousClass25 A00;
    public final int A01;
    public final String A02;

    @Nullable
    public final String A03;
    public final List<AnonymousClass25> A04;

    public AnonymousClass25(int i, @Nullable String str, String str2) {
        this.A04 = new ArrayList();
        this.A01 = i;
        this.A03 = str;
        this.A02 = str2;
    }

    public AnonymousClass25(String str) {
        this(0, null, str);
    }

    private void A00(AnonymousClass25 anonymousClass25) {
        this.A00 = anonymousClass25;
    }

    public final int A01() {
        return this.A01;
    }

    public final AnonymousClass25 A02() {
        return this.A00;
    }

    @Nullable
    public final String A03() {
        return this.A02;
    }

    public final String A04() {
        return this.A03;
    }

    public final List<AnonymousClass25> A05() {
        return this.A04;
    }

    public final void A06(AnonymousClass25 anonymousClass25) {
        anonymousClass25.A00(this);
        this.A04.add(anonymousClass25);
    }
}

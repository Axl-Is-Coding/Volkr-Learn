package com.facebook.ads.redexgen.X;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Os, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1837Os extends AnonymousClass42<C1799Ng> {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    @Nullable
    public InterfaceC1767Lz A04;
    public String A05;
    public List<ON> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AnonymousClass15 A08;
    public final AnonymousClass77 A09;
    public final C2026Wb A0A;
    public final J5 A0B;
    public final LQ A0C;
    public final C1838Ot A0D;
    public final C1849Pe A0E;

    public C1837Os(C2026Wb c2026Wb, List<ON> list, AnonymousClass15 anonymousClass15, J5 j5, AnonymousClass77 anonymousClass77, C1849Pe c1849Pe, LQ lq, InterfaceC1767Lz interfaceC1767Lz, String str, int i, int i2, int i3, int i4, C1838Ot c1838Ot) {
        this.A0A = c2026Wb;
        this.A0B = j5;
        this.A09 = anonymousClass77;
        this.A0E = c1849Pe;
        this.A0C = lq;
        this.A04 = interfaceC1767Lz;
        this.A08 = anonymousClass15;
        this.A06 = list;
        this.A00 = i;
        this.A03 = i4;
        this.A05 = str;
        this.A01 = i3;
        this.A02 = i2;
        this.A0D = c1838Ot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C1799Ng A07(ViewGroup viewGroup, int i) {
        return new C1799Ng(O2.A00(new C1806Nn(this.A0A, this.A0B, this.A04, this.A08, null, this.A0E, this.A0C).A0H(), this.A03, this.A05, this.A0D), this.A07, this.A0E, this.A00, this.A01, this.A02, this.A06.size(), this.A0A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0F(C1799Ng c1799Ng, int i) {
        c1799Ng.A0m(this.A06.get(i), this.A0B, this.A09, this.A0C, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    public final int A0E() {
        return this.A06.size();
    }
}

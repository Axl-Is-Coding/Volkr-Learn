package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1806Nn {

    @Nullable
    public View A02;

    @Nullable
    public AbstractC1762Lu A03;

    @Nullable
    public C1638Gs A04;
    public final View A05;
    public final AnonymousClass15 A06;
    public final C2026Wb A07;
    public final J5 A08;
    public final LQ A09;
    public final InterfaceC1767Lz A0A;
    public final C1849Pe A0B;
    public int A01 = 0;
    public int A00 = 1;

    public C1806Nn(C2026Wb c2026Wb, J5 j5, InterfaceC1767Lz interfaceC1767Lz, AnonymousClass15 anonymousClass15, View view, C1849Pe c1849Pe, LQ lq) {
        this.A07 = c2026Wb;
        this.A08 = j5;
        this.A0A = interfaceC1767Lz;
        this.A06 = anonymousClass15;
        this.A05 = view;
        this.A0B = c1849Pe;
        this.A09 = lq;
    }

    public final C1806Nn A0C(int i) {
        this.A00 = i;
        return this;
    }

    public final C1806Nn A0D(int i) {
        this.A01 = i;
        return this;
    }

    public final C1806Nn A0E(View view) {
        this.A02 = view;
        return this;
    }

    public final C1806Nn A0F(AbstractC1762Lu abstractC1762Lu) {
        this.A03 = abstractC1762Lu;
        return this;
    }

    public final C1806Nn A0G(C1638Gs c1638Gs) {
        this.A04 = c1638Gs;
        return this;
    }

    public final C1807No A0H() {
        return new C1807No(this);
    }
}

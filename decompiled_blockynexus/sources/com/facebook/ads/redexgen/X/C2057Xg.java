package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2057Xg implements BF {
    public final C2063Xm A00 = new C2063Xm();
    public final C2065Xo A01 = new C2065Xo();
    public final InterfaceC1502At[] A02;

    public C2057Xg(InterfaceC1502At... interfaceC1502AtArr) {
        this.A02 = (InterfaceC1502At[]) Arrays.copyOf(interfaceC1502AtArr, interfaceC1502AtArr.length + 2);
        InterfaceC1502At[] interfaceC1502AtArr2 = this.A02;
        interfaceC1502AtArr2[interfaceC1502AtArr.length] = this.A00;
        interfaceC1502AtArr2[interfaceC1502AtArr.length + 1] = this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.BF
    public final AF A3R(AF af) {
        this.A00.A0C(af.A02);
        return new AF(this.A01.A02(af.A01), this.A01.A01(af.A00), af.A02);
    }

    @Override // com.facebook.ads.redexgen.X.BF
    public final InterfaceC1502At[] A5X() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.BF
    public final long A6e(long j) {
        return this.A01.A03(j);
    }

    @Override // com.facebook.ads.redexgen.X.BF
    public final long A76() {
        return this.A00.A0B();
    }
}

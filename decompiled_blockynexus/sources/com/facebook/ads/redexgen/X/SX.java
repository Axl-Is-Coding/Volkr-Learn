package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class SX implements InterfaceC13434d {
    public final /* synthetic */ EI A00;

    public SX(EI ei) {
        this.A00 = ei;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13434d
    public final void AC6(C4W c4w, AnonymousClass49 anonymousClass49, AnonymousClass49 anonymousClass492) {
        this.A00.A1o(c4w, anonymousClass49, anonymousClass492);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13434d
    public final void AC8(C4W c4w, @NonNull AnonymousClass49 anonymousClass49, @Nullable AnonymousClass49 anonymousClass492) {
        this.A00.A0r.A0d(c4w);
        this.A00.A1p(c4w, anonymousClass49, anonymousClass492);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13434d
    public final void ACA(C4W c4w, @NonNull AnonymousClass49 anonymousClass49, @NonNull AnonymousClass49 anonymousClass492) {
        c4w.A0a(false);
        if (this.A00.A0C) {
            if (this.A00.A05.A0L(c4w, c4w, anonymousClass49, anonymousClass492)) {
                this.A00.A1O();
            }
        } else {
            if (!this.A00.A05.A0K(c4w, anonymousClass49, anonymousClass492)) {
                return;
            }
            this.A00.A1O();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13434d
    public final void ADw(C4W c4w) {
        this.A00.A06.A1E(c4w.A0H, this.A00.A0r);
    }
}

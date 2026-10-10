package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Za, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2103Za implements F8 {
    public XX A00;
    public AZ A01;
    public Object A02;
    public final ArrayList<F7> A04 = new ArrayList<>(1);
    public final FJ A03 = new FJ();

    public abstract void A02();

    public abstract void A03(XX xx, boolean z);

    public final FJ A00(@Nullable F6 f6) {
        return this.A03.A03(0, f6, 0L);
    }

    public final void A01(AZ az, @Nullable Object obj) {
        this.A01 = az;
        this.A02 = obj;
        Iterator<F7> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().ABG(this, az, obj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.F8
    public final void A3F(Handler handler, FM fm) {
        this.A03.A08(handler, fm);
    }

    @Override // com.facebook.ads.redexgen.X.F8
    public final void AC4(XX xx, boolean z, F7 f7) {
        XX xx2 = this.A00;
        C1662Hr.A03(xx2 == null || xx2 == xx);
        this.A04.add(f7);
        if (this.A00 == null) {
            this.A00 = xx;
            A03(xx, z);
        } else {
            AZ az = this.A01;
            if (az == null) {
                return;
            }
            f7.ABG(this, az, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.F8
    public final void ACd(F7 f7) {
        this.A04.remove(f7);
        if (this.A04.isEmpty()) {
            this.A00 = null;
            this.A01 = null;
            this.A02 = null;
            A02();
        }
    }

    @Override // com.facebook.ads.redexgen.X.F8
    public final void ACf(FM fm) {
        this.A03.A0E(fm);
    }
}

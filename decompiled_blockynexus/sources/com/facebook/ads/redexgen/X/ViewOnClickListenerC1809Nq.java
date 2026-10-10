package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1809Nq implements View.OnClickListener {
    public static String[] A01;
    public final /* synthetic */ C9Q A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"c2PEJ6DOqpui9EPvmckbHNLd48C", "0LubsyKGJKKePfKATMceGef14XY86Ri5", "M6oVByKNfKe8LZIrCewzhyGONHgeYcNo", "g1oo9eCM7RcmOvTxZ1VejNMrbdbCR0G4", "3al8rHdAj04D", "Lmo63BJo3ocNRJpk0", "u0Zxd4kfnWeayuGPbNnNq6ZbpiAglx3D", "JRUzdnx3lrNIQCskW6e2Avl8V"};
    }

    public ViewOnClickListenerC1809Nq(C9Q c9q) {
        this.A00 = c9q;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A07 = false;
            this.A00.A0C();
        } catch (Throwable th) {
            if (A01[3].charAt(5) != 'e') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "oQ6hKoRa6K50vxrlE5lU8mLQHveYoJVv";
            strArr[1] = "5HqmMGmqvKeUZ55y8iy1lLJbe1y4dd8I";
            KL.A00(th, this);
        }
    }
}

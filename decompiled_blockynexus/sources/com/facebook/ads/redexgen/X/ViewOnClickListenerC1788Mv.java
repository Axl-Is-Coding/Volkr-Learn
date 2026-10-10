package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1788Mv implements View.OnClickListener {
    public static String[] A02;
    public final /* synthetic */ C1771Md A00;
    public final /* synthetic */ XO A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"9sVCZE1JzKyNlgcXamStOEuF7vpp11q7", "2ezkH3kSqCf8dvr0XQnySHd1TgVVvlpb", "j6uQAgvGWfRMr40VSzlVsWkcoISldlVB", "dNEMzbO6BFzdIEcJ0MNYA8UShcXW2fNX", "CiFQ7cnsU8a2IY039", "of093nELJxDtvmpwlx40Sj96vTqfYWfZ", "89mnR6KKQKsitukE0pK0FSEAWYYgI9MC", "iqJuIXwOIBXLoaWKOF5L6veUHjclhPcL"};
    }

    public ViewOnClickListenerC1788Mv(XO xo, C1771Md c1771Md) {
        this.A01 = xo;
        this.A00 = c1771Md;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0A.A83();
        } catch (Throwable th) {
            KL.A00(th, this);
            String[] strArr = A02;
            if (strArr[7].charAt(23) == strArr[1].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "erh4HILEwUj6GeiKdMF57q4cd8pDAg7o";
            strArr2[3] = "erh4HILEwUj6GeiKdMF57q4cd8pDAg7o";
        }
    }
}

package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1779Mm implements View.OnClickListener {
    public static String[] A01;
    public final /* synthetic */ XR A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"KnJgliGO", "VwHKKtvbMk7FPKbBmIqapgeuC2T6fwds", "wENtEeepoPFkxQkEwI5qJp4A5OxzxToD", "COqx4q9kDUbjFrhSKPpHQyyB6JO5bBDL", "v63", "lzTgDb46XsVjhse8XoOOStoy8Mg7tCsc", "1yL2I4AIQTHR8fVHiYQ7c9e8uwPzvL3", "TX4RO1m5K"};
    }

    public ViewOnClickListenerC1779Mm(XR xr) {
        this.A00 = xr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0A.A7K();
        } catch (Throwable th) {
            String[] strArr = A01;
            if (strArr[3].charAt(11) != strArr[5].charAt(11)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "zPAJp5EfhF2KrfBUqv";
            strArr2[0] = "zPAJp5EfhF2KrfBUqv";
            KL.A00(th, this);
        }
    }
}

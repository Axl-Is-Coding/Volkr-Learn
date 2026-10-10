package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1778Mk implements View.OnClickListener {
    public static String[] A02;
    public final /* synthetic */ C1771Md A00;
    public final /* synthetic */ XR A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"Oq", "EvGClE7if1wWI664DgGuGJMVxIj5MmF8", "WEj5b", "ZnP49bXAxkKFgNqp8", "Y2wBPaH57L9Gttlp", "AMrJJ9So27w7KiYttAq3AFMsZzT3RVfH", "8te6O8WI5P7ERWBX", "5xXH0hCktOzz8vKUWRcLVJoUpm5lTBxe"};
    }

    public ViewOnClickListenerC1778Mk(XR xr, C1771Md c1771Md) {
        this.A01 = xr;
        this.A00 = c1771Md;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0A.AAV(AnonymousClass23.A05);
        } catch (Throwable th) {
            if (A02[5].charAt(20) == 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "snOHg";
            strArr[2] = "snOHg";
            KL.A00(th, this);
        }
    }
}

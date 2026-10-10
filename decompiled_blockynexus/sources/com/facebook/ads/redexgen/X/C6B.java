package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.SystemClock;
import android.view.OrientationEventListener;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6B {

    @Nullable
    public static OrientationEventListener A02;
    public static String[] A03;
    public final AnonymousClass69 A00;
    public final EnumC13936c A01;

    static {
        A01();
    }

    public static void A01() {
        A03 = new String[]{"ciYSwpO57ig7", "AgXvWM7vBAP276b3F", "h3L2uX2266ICJ0F8mxeOzYeo", "sn1Bi96p4g3FJ3lBwfTgs4qOj566", "nEyUaJreiz", "9f6cxckTFidZYnVMHRSclm", "9nbfinSPxnf3N791gNAhDrqxfgbV", "EACetWGUN5dpVn0xkHaZeeKDOZ"};
    }

    public C6B(AnonymousClass69 anonymousClass69, EnumC13936c enumC13936c) {
        this.A00 = anonymousClass69;
        this.A01 = enumC13936c;
    }

    public final synchronized void A02() {
        if (A02 != null) {
            A02.disable();
            A02 = null;
        }
    }

    public final synchronized void A03(final Context context) {
        final C14026l c14026l;
        if (A02 != null) {
            String[] strArr = A03;
            if (strArr[7].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[7] = "WLHhaS1yyOUNNZKQvAoQ3Zw3xj";
            strArr2[1] = "prMYx6h4YCDadOhBb";
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        String packageName = context == null ? "" : context.getPackageName();
        if (this.A01 == EnumC13936c.A0G) {
            c14026l = null;
        } else {
            c14026l = new C14026l(packageName);
        }
        final int i = 3;
        A02 = new OrientationEventListener(context, i) { // from class: com.facebook.ads.redexgen.X.6A
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i2) {
                this.A01.A00.A02(new WP(jElapsedRealtime, c14026l, i2), AnonymousClass68.A0A);
            }
        };
        A02.enable();
    }
}

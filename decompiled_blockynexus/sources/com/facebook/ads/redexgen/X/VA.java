package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class VA implements C6Y {
    public static String[] A01;
    public final /* synthetic */ VC A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"wdcki9TayB0epgOAqgPZ60vGLzXQskFg", "eaUsA8pmkvwqM9uF8kH4nQuKK9Zu7ymc", "2dfJX", "k6tMd5tlxlmCEJMQTJf7pwLJqfV91j3Q", "YVwPmyUK2b9QSHLRAwsi84oHRZQXtzOF", "hpSXL0XJUd77PKoaf1", "iaFmBfogLFf9YiLH80pKK2KW3oFuZo4T", "28ANuaZ3OB7zLgtTtX"};
    }

    public VA(VC vc) {
        this.A00 = vc;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 16) {
            return this.A00.A08(EnumC14006j.A05);
        }
        if (this.A00.A00 == null) {
            VC vc = this.A00;
            String[] strArr = A01;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "xEd7j65KlJaDHlrOXF5qOqVEOzAiF9i5";
            strArr2[0] = "xEd7j65KlJaDHlrOXF5qOqVEOzAiF9i5";
            return vc.A08(EnumC14006j.A07);
        }
        VC vc2 = this.A00;
        return vc2.A0G(vc2.A00.isKeyguardLocked());
    }
}

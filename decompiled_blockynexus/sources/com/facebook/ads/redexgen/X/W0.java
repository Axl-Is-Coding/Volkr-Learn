package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.telephony.TelephonyManager;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class W0 implements C6Y {
    public static String[] A01;
    public final /* synthetic */ W8 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"YvgwWocx1FADdeAzbpsmJqKucTKVrLw8", "IN5yo6alVzQxSBDS0LSAMVLc9G2MRZFn", "HAZTu6IPNZsD1qj0M1i9utr9DJx5S0QZ", "N5cGJfQ0ESKW2WKzc5hPaTPWXOaKWBwf", "tNMXMhxZjOCLmtsXwerOChNpJkA4NIz8", "qe3nCZLHllYVPimtyVQbZz0eRg0vYsPF", "hksQgw", "nUQ4NN4k5WyfvhfMBfttwidjpDAXB5K7"};
    }

    public W0(W8 w8) {
        this.A00 = w8;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC14006j.A07);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            W8 w8 = this.A00;
            return w8.A05(w8.A00.getVoiceNetworkType());
        }
        W8 w82 = this.A00;
        TelephonyManager telephonyManager = w82.A00;
        if (A01[2].charAt(0) == 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "ynGeEoYIomGmDWEGPoJ89qRpE67tUZnz";
        strArr[1] = "ynGeEoYIomGmDWEGPoJ89qRpE67tUZnz";
        return w82.A05(telephonyManager.getNetworkType());
    }
}

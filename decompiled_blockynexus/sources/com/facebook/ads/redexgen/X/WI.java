package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class WI implements C6Y {
    public static byte[] A01;
    public final /* synthetic */ WJ A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{84, 91, 81, 71, 90, 92, 81, 27, 93, 84, 71, 81, 66, 84, 71, 80, 27, 64, 70, 87, 27, 84, 86, 65, 92, 90, 91, 27, 96, 102, 119, 106, 102, 97, 116, 97, 112, 28, ci.n, 17, 17, 26, 28, 11, 26, 27};
    }

    public WI(WJ wj) {
        this.A00 = wj;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        Intent intent = this.A00.A00.registerReceiver(null, new IntentFilter(A00(0, 37, 55)));
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            return this.A00.A0G(extras.getBoolean(A00(37, 9, 125)));
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}

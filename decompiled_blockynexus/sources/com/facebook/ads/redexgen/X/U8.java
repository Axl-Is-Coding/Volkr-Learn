package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class U8 extends C6P {
    public static byte[] A01;
    public final AudioManager A00;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{-22, -2, -19, -14, -8};
    }

    public U8(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = (AudioManager) context.getSystemService(A04(0, 5, 104));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC14046n A03(HashMap<Integer, U7> map) {
        return new WS(SystemClock.elapsedRealtime(), A03(), map, EnumC14036m.A06);
    }

    public final C6Y A0H() {
        return new U5(this);
    }

    public final C6Y A0I() {
        return new U2(this);
    }

    public final C6Y A0J() {
        return new U3(this);
    }

    public final C6Y A0K() {
        return new U4(this);
    }

    public final C6Y A0L(List<C6X> list) {
        return new U6(this, list);
    }
}

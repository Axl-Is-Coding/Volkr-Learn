package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.analytics.pro.ci;
import java.io.Serializable;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.13, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass13 extends BroadcastReceiver {
    public static byte[] A03;
    public static String[] A04;
    public Context A00;
    public C14679j A01;
    public boolean A02 = false;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{25, 3, ci.m, ci.k, 78, 6, 1, 3, 5, 2, ci.m, ci.m, 11, 78, 1, 4, 19, 78, 9, ci.l, 20, 5, 18, 19, 20, 9, 20, 9, 1, 12, 78, 4, 9, 19, ci.n, 12, 1, 25, 5, 4, 19, 31, 29, 94, 22, 17, 19, 21, 18, 31, 31, 27, 94, 17, 20, 3, 94, 25, 30, 4, 21, 2, 3, 4, 25, 4, 25, 17, 28, 94, 20, 25, 3, 0, 28, 17, 9, 21, 20, 74, 18, 1, 18, 25, 3, 81, 68, 83, 71, 78, 83, 76, 98, 85, 64, 98, 77, 72, 66, 74, 83, 70, 81, 69, 76, 81, 78, 96, 87, 66, 96, 79, 74, 64, 72, 25, 45, 50, Utf8.REPLACEMENT_BYTE, 62, 52, 18, 53, 47, 62, 41, 40, 47, 50, 47, 58, 55, 30, 45, 62, 53, 47, 2, 29, ci.n, 17, 27, 61, 26, 0, 17, 6, 7, 0, 29, 0, 21, 24, 49, 2, 17, 26, 0, 78};
    }

    public static void A02() {
        A04 = new String[]{"X1IVw5mZrPwWgp59pDL9aLZ3Fov3W2Wm", "N1AsLxATz8LfRIPBbwS0prqi9bKFNGwZ", "KvfN8PD7zJtQDsMeVTqT5dRzLvhiPQFs", "CwJ4sBopjGul5sxVyPsrv7O0APgi12j8", "riYYfsMk5nddhbnpPSj9znzkTr5bDpPf", "Be1xHvNUMQ0R9QZ", "t7JwnvsmbbV8km6q46", "oSYhwD14tF3vT8zAS1lFRiV2H2FAfEUD"};
    }

    public AnonymousClass13(C14679j c14679j, Context context) {
        this.A01 = c14679j;
        this.A00 = context;
    }

    public final void A03() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(40, 40, 17) + this.A01.getUniqueId());
        intentFilter.addAction(A00(137, 22, 21) + this.A01.getUniqueId());
        intentFilter.addAction(A00(100, 16, 66) + this.A01.getUniqueId());
        C2E.A00(this.A00).A07(this, intentFilter);
    }

    public final void A04() {
        try {
            C2E.A00(this.A00).A06(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String[] strArrSplit = intent.getAction().split(A00(0, 1, 66));
        if (strArrSplit.length != 2 || !strArrSplit[1].equals(this.A01.getUniqueId())) {
            return;
        }
        if (strArrSplit[0].equals(A00(1, 39, 1))) {
            if (this.A01.getListener() != null) {
                this.A01.getListener().A9m();
                this.A01.getListener().ABh();
                return;
            }
            return;
        }
        String str = strArrSplit[0];
        if (A04[2].charAt(17) != 'T') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[7] = "czH1g8WXqBVBzZgoSLVA20jYFFcQLh15";
        strArr[7] = "czH1g8WXqBVBzZgoSLVA20jYFFcQLh15";
        if (str.equals(A00(116, 21, 58))) {
            Serializable serializableExtra = intent.getSerializableExtra(A00(80, 5, 22));
            if (serializableExtra instanceof IM) {
                if (this.A01.getListener() != null) {
                    this.A01.getListener().A9s();
                    this.A01.getListener().ABh();
                }
                if (this.A02) {
                    this.A01.A0V(1);
                } else {
                    this.A01.A0V(((IM) serializableExtra).A01());
                }
                this.A01.setVisibility(0);
                this.A01.A0Y(EnumC1834Op.A05, 1);
                return;
            }
            if (serializableExtra instanceof C1711Js) {
                if (this.A01.getListener() == null) {
                    return;
                }
                M7 listener = this.A01.getListener();
                if (A04[4].charAt(15) != 'p') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A04;
                strArr2[0] = "WizhEabCQfIhxCPZxjxQrLo8096TZ2te";
                strArr2[0] = "WizhEabCQfIhxCPZxjxQrLo8096TZ2te";
                listener.A9w();
                return;
            }
            if (serializableExtra instanceof C1709Jq) {
                if (this.A01.getListener() == null) {
                    return;
                }
                this.A01.getListener().A9x();
                return;
            }
            if (serializableExtra instanceof C7l) {
                if (this.A01.getListener() != null) {
                    this.A01.getListener().A9T();
                }
                this.A02 = true;
                return;
            }
            if (serializableExtra instanceof C1703Jk) {
                if (this.A01.getListener() != null) {
                    M7 listener2 = this.A01.getListener();
                    if (A04[5].length() != 15) {
                        String[] strArr3 = A04;
                        strArr3[5] = "OhpiyJuLhpOH2Z5";
                        strArr3[5] = "OhpiyJuLhpOH2Z5";
                        listener2.AAj();
                    } else {
                        String[] strArr4 = A04;
                        strArr4[1] = "rjxpcIZarLCWG40Y5u8euDt94bevKfNO";
                        strArr4[1] = "rjxpcIZarLCWG40Y5u8euDt94bevKfNO";
                        listener2.AAj();
                    }
                }
                this.A02 = false;
                return;
            }
            if (!(serializableExtra instanceof C14257j) || this.A01.getListener() == null) {
                return;
            }
            this.A01.getListener().onPause();
            return;
        }
        if (!strArrSplit[0].equals(A00(85, 15, 64))) {
            return;
        }
        this.A01.A0i();
    }
}

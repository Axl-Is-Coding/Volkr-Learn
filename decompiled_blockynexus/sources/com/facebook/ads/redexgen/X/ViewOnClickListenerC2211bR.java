package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2211bR implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, AnonymousClass85 {
    public static byte[] A02;
    public final C2026Wb A00;
    public final /* synthetic */ C2213bT A01;

    static {
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{43, ci.l, 74, 9, 11, 4, 4, 5, 30, 74, 8, ci.m, 74, 9, 6, 3, 9, 1, ci.m, ci.l, 74, 8, ci.m, 12, 5, 24, ci.m, 74, 3, 30, 74, 3, 25, 74, 28, 3, ci.m, 29, ci.m, ci.l, 68, 66, 109, 104, 98, 106, 114, 33, 105, 96, 113, 113, 100, 111, 100, 101, 33, 117, 110, 110, 33, 103, 96, 114, 117, 47, 20, ci.n, 19, 39, 54, 59, 55, 60, 49, 55, 28, 55, 38, 37, 61, 32, 57, 56, 25, 86, 2, 25, 3, 21, 30, 86, 18, 23, 2, 23, 86, 4, 19, 21, 25, 4, 18, 19, 18, 90, 86, 6, 26, 19, 23, 5, 19, 86, 19, 24, 5, 3, 4, 19, 86, 2, 25, 3, 21, 30, 86, 19, 0, 19, 24, 2, 5, 86, 4, 19, 23, 21, 30, 86, 2, 30, 19, 86, 23, 18, 86, 32, 31, 19, 1, 86, 20, ci.m, 86, 4, 19, 2, 3, 4, 24, 31, 24, 17, 86, ci.n, 23, 26, 5, 19, 86, 31, ci.n, 86, ci.m, 25, 3, 86, 31, 24, 2, 19, 4, 21, 19, 6, 2, 86, 2, 30, 19, 86, 19, 0, 19, 24, 2, 88, 33, 39, 60, 94, 68, 89};
    }

    public ViewOnClickListenerC2211bR(C2213bT c2213bT, C2026Wb c2026Wb) {
        this.A01 = c2213bT;
        this.A00 = c2026Wb;
    }

    public /* synthetic */ ViewOnClickListenerC2211bR(C2213bT c2213bT, C2026Wb c2026Wb, C2205bK c2205bK) {
        this(c2213bT, c2026Wb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01() {
        Map<String, String> mapA06 = new NQ().A04(this.A01.A0N).A03(this.A01.A0b).A06();
        if (this.A01.A0H != null) {
            mapA06.put(A00(201, 3, 11), String.valueOf(this.A01.A0H.A04()));
        }
        if (this.A01.A0S) {
            mapA06.put(A00(198, 3, 116), String.valueOf(this.A01.A0S));
        }
        return mapA06;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(Map<String, String> map) {
        if (this.A01.A0W != null) {
            this.A01.A0W.A0Z(map);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass85
    public final C2026Wb A5N() {
        return this.A00;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            boolean zA09 = this.A01.A0b.A09();
            String strA00 = A00(66, 17, 105);
            if (!zA09) {
                Log.e(strA00, A00(83, 115, 77));
            }
            int iA0E = C1693Iy.A0E(this.A01.A0Y);
            if (iA0E < 0 || this.A01.A0b.A04() >= iA0E) {
                if (this.A01.A0b.A0A(this.A01.A0Y)) {
                    if (this.A01.A0W != null) {
                        this.A01.A0W.A0a(A01());
                        return;
                    }
                    return;
                } else {
                    if (C1693Iy.A0z(this.A01.A0Y)) {
                        if (this.A01.A0W != null) {
                            this.A01.A0W.A0d(A01());
                        }
                        L1.A00(new JN(this), new JO(this), C1728Kk.A00());
                        return;
                    }
                    A05(A01());
                    return;
                }
            }
            if (!this.A01.A0b.A08()) {
                Log.e(strA00, A00(0, 41, 81));
            } else {
                Log.e(strA00, A00(41, 25, 58));
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.A01.A03 == null || this.A01.A0K == null) {
            return false;
        }
        this.A01.A0K.setBounds(0, 0, this.A01.A03.getWidth(), this.A01.A03.getHeight());
        this.A01.A0K.A0E(!this.A01.A0K.A0F());
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.A01.A0b.A07(motionEvent, this.A01.A03, view);
        return this.A01.A02 != null && this.A01.A02.onTouch(view, motionEvent);
    }
}

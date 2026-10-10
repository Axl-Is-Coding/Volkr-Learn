package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.ThreadSafe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5q, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ThreadSafe
@SuppressLint({"StaticFieldLeak"})
public final class C13825q {
    public static C6Z A06;
    public static byte[] A07;
    public static String[] A08;
    public static final AtomicReference<C13825q> A09;
    public C13845s A00;
    public C6K A01;
    public final Context A02;
    public final C13815p A03;
    public final AtomicReference<AnonymousClass65> A04 = new AtomicReference<>();
    public final AtomicReference<TR> A05 = new AtomicReference<>();

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{99, 101, 116, 127, 25, 20, 92, 90, 114, 109, 113};
    }

    public static void A02() {
        A08 = new String[]{"eZKmHpMMDfaoBqW8nqrxEoXtMavqlqNM", "AtFM24PyHDF8", "75v22abHTVt154frUD1Ye4KyqdVteY4i", "Q1X3dzo1KUJ0DHl8HY6jDpMlStfBjogW", "z2ZYiDayfErc", "35EgzrmLPkhoCqMLba9eqfKFMV7fawsP", "opJsobvHgIMCHkez4yG45JKspLs2PehX", "oVaFSOpmfGo5v5TJJzClDpDAWRdHWsbi"};
    }

    static {
        A02();
        A01();
        A09 = new AtomicReference<>();
    }

    public C13825q(Context context, C13815p c13815p, C6Z c6z) {
        this.A02 = context;
        this.A03 = c13815p;
        this.A01 = new C6K(this.A02, this.A03);
        if (this.A04.get() == null && C14136w.A0F(c6z)) {
            A03(c6z);
        }
    }

    private synchronized void A03(C6Z c6z) {
        if (this.A04.get() == null) {
            AnonymousClass61.A03(this.A03.A0Z());
            TR tr = new TR(this.A03, this.A01);
            this.A05.set(tr);
            this.A00 = new C13845s();
            this.A00.A00(tr);
            if (this.A01.A06() && C14136w.A0F(c6z)) {
                tr.A06(c6z);
            }
            A06 = c6z;
            this.A00.A01(c6z);
            this.A04.set(AnonymousClass65.A00(this.A02, this.A03));
        }
    }

    private boolean A04(C6Z c6z) {
        if (C14136w.A0F(c6z)) {
            A03(c6z);
        }
        if (c6z.equals(A06)) {
            return false;
        }
        A06 = c6z;
        C13845s c13845s = this.A00;
        if (c13845s != null) {
            c13845s.A01(c6z);
        }
        if (A08[0].charAt(4) == 't') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[2] = "al3lqCaa3X6BhafyoLSdmdZ2qZ9PyUcx";
        strArr[2] = "al3lqCaa3X6BhafyoLSdmdZ2qZ9PyUcx";
        return true;
    }

    private boolean A05(String str, EnumC13946d enumC13946d) {
        if (!C14136w.A0F(A06) || this.A04.get() == null) {
            return false;
        }
        C6K c6k = this.A01;
        if (c6k != null) {
            c6k.A05(EnumC13926b.A02, A06, str, enumC13946d);
            return true;
        }
        return true;
    }

    @SuppressLint({"CatchGeneralException"})
    public final void A06(MotionEvent motionEvent) {
        try {
            if (this.A04.get() == null) {
                return;
            }
            this.A04.get().A06(motionEvent);
        } catch (Throwable th) {
            AnonymousClass61.A04(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final synchronized boolean A07(String str) {
        EnumC13946d enumC13946dA00;
        String string;
        if (str != null) {
            if (!str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject(A00(0, 2, 69));
                    if (jSONObject != null) {
                        zA04 = jSONObject.has(A00(6, 2, 106)) ? false | A04(C6Z.A00(jSONObject.getInt(A00(6, 2, 106)))) : false;
                        JSONArray jSONArray = jSONObject.getJSONArray(A00(2, 2, 83));
                        if (jSONObject.has(A00(8, 3, 69))) {
                            enumC13946dA00 = EnumC13946d.A00(jSONObject.getInt(A00(8, 3, 69)));
                        } else {
                            enumC13946dA00 = EnumC13946d.A04;
                        }
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            if (jSONObject2.has(A00(4, 2, 52)) && (string = jSONObject2.getString(A00(4, 2, 52))) != null && !string.isEmpty()) {
                                C14136w.A0C(this.A03, EnumC13885w.A04.A02(), string);
                                zA04 |= A05(string, enumC13946dA00);
                            }
                        }
                    } else {
                        return false;
                    }
                } catch (JSONException unused) {
                } catch (Throwable th) {
                    AnonymousClass61.A04(th);
                }
                return zA04;
            }
        }
        return false;
    }
}

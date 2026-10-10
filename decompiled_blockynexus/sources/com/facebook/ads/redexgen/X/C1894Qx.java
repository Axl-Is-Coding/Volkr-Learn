package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1894Qx implements C0R {
    public static byte[] A06;
    public static String[] A07;
    public final C1896Qz A00;
    public final AtomicReference<String> A04 = new AtomicReference<>();
    public final AtomicReference<String> A03 = new AtomicReference<>();
    public final AtomicReference<EnumC12410c> A05 = new AtomicReference<>();
    public final UUID A01 = UUID.randomUUID();
    public final AtomicInteger A02 = new AtomicInteger(1);

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{5, 22, ci.k, ci.k, 6, ci.m, 60, 109, 126, 101, 101, 110, 103, 84, 120, 110, 122};
        String[] strArr = A07;
        if (strArr[7].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[2] = "yQ17NavN7ZSoq7zHySEgN4tR7loqT";
        strArr2[2] = "yQ17NavN7ZSoq7zHySEgN4tR7loqT";
    }

    public static void A03() {
        A07 = new String[]{"nHMpSWMsnsV7ze4k7TMdpo8w7eAhh5yl", "NZIGXtqvLJqJvnsqDFZQPtZx", "Ad1TvQCscaWcF7stMWLl9lRlqQAvL", "Ujq4dS9mEeqxvShJwD8UISSMYbM", "6D9", "oL3lqgBhSNj2gXyheQdgS3kbnnn96fNg", "3X2AVVUyUAfxSvaFg1Rh03BQkiDduKF9", "x5OfLFoNyht1tsSSgvPC5bYcCNR"};
    }

    public C1894Qx(C1896Qz c1896Qz) {
        this.A00 = c1896Qz;
    }

    private final void A04(JSONObject jSONObject) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            try {
                jSONObject.put(A01(7, 10, 84), this.A02.getAndIncrement());
            } catch (Throwable th) {
                KL.A00(th, this);
                return;
            }
        } catch (JSONException unused) {
        }
        C0X.A0F.A06(this.A01).A02(jSONObject);
        String str = this.A04.get();
        if (!TextUtils.isEmpty(str)) {
            C0X.A0R.A06(str).A02(jSONObject);
        }
        String str2 = this.A03.get();
        if (!TextUtils.isEmpty(str2)) {
            C0X.A0Q.A06(str2).A02(jSONObject);
        }
        EnumC12410c enumC12410c = this.A05.get();
        if (enumC12410c != null) {
            C0X.A0E.A06(enumC12410c).A02(jSONObject);
        }
    }

    public final void A05(C0T c0t, C0W... c0wArr) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (C0W c0w : c0wArr) {
                c0w.A02(jSONObject);
            }
            A04(jSONObject);
            this.A00.A00().A8J(c0t, jSONObject);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2R(String str, int i) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0R, C0X.A0H.A06(Integer.valueOf(i)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2S(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0S, C0X.A0L.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2T(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0T, C0X.A0L.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2U(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0U, C0X.A0L.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2V(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0V, C0X.A0L.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2W(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0W, C0X.A0L.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2X(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0X, C0X.A0L.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2Y() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0i, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2Z() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0Y, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2a() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0v, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2b() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0w, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2c(boolean z) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0Z, C0X.A02.A06(Boolean.valueOf(z)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2d(long j, int i, String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0x, C0X.A0G.A06(Integer.valueOf(i)), C0X.A0M.A06(str), C0X.A0K.A06(Long.valueOf(j)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2e() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0z, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2f() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0y, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2g() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A10, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2h(long j) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A11, C0X.A0K.A06(Long.valueOf(j)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2i(C0Q c0q) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1s, C0X.A01.A06(c0q));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2j(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.set(str);
            A05(C0T.A0a, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2k() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0b, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2l() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0c, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2m(long j, int i, String str, boolean z) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0d, C0X.A0K.A06(Long.valueOf(j)), C0X.A0G.A06(Integer.valueOf(i)), C0X.A0M.A06(str), C0X.A0A.A06(Boolean.valueOf(z)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2n(long j) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0e, C0X.A0K.A06(Long.valueOf(j)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2o(boolean z) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A18, C0X.A0D.A06(Boolean.valueOf(z)));
        } catch (Throwable th) {
            String[] strArr = A07;
            if (strArr[7].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[6] = "gK8mXYwR0ckPpFtcTSNh6868pPwacmBZ";
            strArr2[6] = "gK8mXYwR0ckPpFtcTSNh6868pPwacmBZ";
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2p() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A19, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2q() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1C, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2r(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1D, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2s() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1E, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2t() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1F, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2u() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1G, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2v(int i) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1H, C0X.A0H.A06(Integer.valueOf(i)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2w() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1I, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2x() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1L, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2y() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1J, new C0W[0]);
        } catch (Throwable th) {
            if (A07[6].charAt(19) != 'h') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[6] = "TXE2cMU86vxtF7wI18ThzZXaU0uTRMLS";
            strArr[6] = "TXE2cMU86vxtF7wI18ThzZXaU0uTRMLS";
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2z(int i) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1K, C0X.A0H.A06(Integer.valueOf(i)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A30() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1M, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A31(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1N, C0X.A0O.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A32() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1O, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A33() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1P, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A34() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1Q, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A35() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1R, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A36(int i) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1S, C0X.A0H.A06(Integer.valueOf(i)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A37() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1T, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A38(int i) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1U, C0X.A0H.A06(Integer.valueOf(i)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A39() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1u, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
            if (A07[4].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[6] = "VZoNBueTz9dHgRCK2oHhqd2tucTd08Xg";
            strArr[6] = "VZoNBueTz9dHgRCK2oHhqd2tucTd08Xg";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A3A() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1v, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A3B(C0Q c0q) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1r, C0X.A01.A06(c0q));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A3C(int i) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1t, C0X.A0I.A06(Integer.valueOf(i)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A3D() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1w, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A3v(long j) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0g, C0X.A0K.A06(Long.valueOf(j)));
        } catch (Throwable th) {
            KL.A00(th, this);
            if (A07[0].charAt(15) != 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[1] = "iGvSb1Hz3BIwYRP6JXvlZVW4";
            strArr[1] = "iGvSb1Hz3BIwYRP6JXvlZVW4";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A3w(long j) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0h, C0X.A0K.A06(Long.valueOf(j)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A41() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0j, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4V() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0k, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4W() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0o, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4X(boolean z) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0f, C0X.A09.A06(Boolean.valueOf(z)));
        } catch (Throwable th) {
            if (A07[1].length() == 19) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[5] = "sws4bQbg9GprWoTPEe05ZlT1gMn94mHS";
            strArr[5] = "sws4bQbg9GprWoTPEe05ZlT1gMn94mHS";
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4Y(int i, String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0p, C0X.A0G.A06(Integer.valueOf(i)), C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4Z(boolean z) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0n, C0X.A04.A06(Boolean.valueOf(z)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4a() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0r, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4b() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0s, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4c() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0t, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4d() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A0u, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4r(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1X, C0X.A0O.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4s() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1Y, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4t(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1Z, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4u(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1a, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4v(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1b, C0X.A0O.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4w(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1d, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4x(long j) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1e, C0X.A0K.A06(Long.valueOf(j)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4y(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1f, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A7U() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1g, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A7V(boolean z) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1h, C0X.A08.A06(Boolean.valueOf(z)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A7W() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1i, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A7X(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1j, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A7Y() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1k, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A7Z() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1l, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A7a(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1m, C0X.A0N.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A8F(int i, String str) throws Throwable {
        if (KL.A02(this) || i < 11000 || i > 11099) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                StringBuilder sb = new StringBuilder();
                String message = A01(0, 7, 60);
                sb.append(message);
                String message2 = C0X.A0O.getName();
                sb.append(message2);
                String message3 = sb.toString();
                jSONObject.put(message3, str);
            } catch (JSONException unused) {
            }
            A04(jSONObject);
            this.A00.A00().A8U(i, jSONObject);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A8p(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A12, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A8q(int i) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A13, C0X.A0I.A06(Integer.valueOf(i)));
        } catch (Throwable th) {
            KL.A00(th, this);
            if (A07[4].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[1] = "n4mJfQKCjkVGyNTXc44lq1NfZCr";
            strArr[1] = "n4mJfQKCjkVGyNTXc44lq1NfZCr";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A8s() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A14, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
            if (A07[5].charAt(28) == 'u') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[0] = "A3lONLTCXWx4KhpkbRCT5RNlo5C8otzX";
            strArr[0] = "A3lONLTCXWx4KhpkbRCT5RNlo5C8otzX";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ACU(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A16, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ACV() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A17, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADO(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A04.set(str);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADQ(EnumC12410c enumC12410c) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A05.set(enumC12410c);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADz() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1B, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE0() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1x, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE1() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1y, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE2() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1z, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE3() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A20, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE4(boolean z) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A21, C0X.A03.A06(Boolean.valueOf(z)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE5() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A22, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE6() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A23, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE7(int i, @Nullable String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A24, C0X.A0G.A06(Integer.valueOf(i)), C0X.A0M.A06(str));
        } catch (Throwable th) {
            if (A07[0].charAt(15) != 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[2] = "2PKYVe8Qgwv7j3CDJ6bxblARvZgyh";
            strArr[2] = "2PKYVe8Qgwv7j3CDJ6bxblARvZgyh";
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE8(boolean z) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A25, C0X.A07.A06(Boolean.valueOf(z)));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE9() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A26, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AEA(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A27, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AEB() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A28, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AEC(int i) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A29, C0X.A0J.A06(Integer.valueOf(i)));
        } catch (Throwable th) {
            String[] strArr = A07;
            if (strArr[7].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[2] = "bm6dbMytZvpqzg8D3QKVLEJHQj3Ec";
            strArr2[2] = "bm6dbMytZvpqzg8D3QKVLEJHQj3Ec";
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AEH(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1V, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AEI(String str) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1W, C0X.A0M.A06(str));
        } catch (Throwable th) {
            KL.A00(th, this);
            if (A07[1].length() == 19) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[5] = "ivuB5Sydf2jbsPKu7So7nbx7xRGWOHbH";
            strArr[5] = "ivuB5Sydf2jbsPKu7So7nbx7xRGWOHbH";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final String getId() throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return this.A01.toString();
        } catch (Throwable th) {
            KL.A00(th, this);
            return null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void unregisterView() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A05(C0T.A1A, new C0W[0]);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

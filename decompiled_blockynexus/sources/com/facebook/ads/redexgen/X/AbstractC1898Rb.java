package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"HardcodedIPAddressUse"})
public abstract class AbstractC1898Rb implements K5 {
    public static byte[] A0E;
    public static String[] A0F;
    public static final Handler A0G;
    public static final C12560r A0H = null;

    @SuppressLint({"StaticFieldLeak"})
    public static final K6 A0I = null;
    public static final String A0J;
    public View A00;

    @Nullable
    public InterfaceC12510m A01;
    public InterfaceC12510m A02;
    public C14498q A05;
    public K3 A06;
    public AbstractC12520n A07;
    public final C12741j A08;
    public final J5 A09;
    public final C12560r A0A;
    public final K6 A0B;
    public final C2026Wb A0C;
    public volatile boolean A0D;
    public long A04 = -1;

    @Nullable
    public String A03 = null;

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0E = new byte[]{75, 110, 107, 122, 126, 111, 120, 42, 110, 101, 111, 121, 42, 100, 101, 126, 42, 111, 114, 99, 121, 126, 78, 107, 110, 127, 123, 106, 125, 47, 102, 124, 47, 97, 122, 99, 99, 47, 96, 97, 47, 124, 123, 110, 125, 123, 78, 107, 62, 25, 17, 20, 29, 28, 88, 12, 23, 88, 17, 22, 17, 12, 17, 25, 20, 17, 2, 29, 88, 59, 23, 23, 19, 17, 29, 53, 25, 22, 25, 31, 29, 10, 86, 34, 3, 76, 1, 3, 30, 9, 76, ci.k, 8, 76, ci.m, ci.k, 2, 8, 5, 8, ci.k, 24, 9, 31, 66, 88, 125, 96, 97, 104, 47, 110, 107, 110, 127, 123, 106, 125, 47, 123, 118, 127, 106, 33, 42, 47, 107, 42, 39, 57, 46, 42, 47, 50, 107, 56, Utf8.REPLACEMENT_BYTE, 42, 57, Utf8.REPLACEMENT_BYTE, 46, 47, 76, 93, 68, 44, 59, 91, 94, 75, 94, 49, 52, 33, 52, 10, 56, 58, 49, 48, 57, 10, 33, 44, 37, 48, 29, 28, 31, ci.n, 23, ci.n, ci.k, ci.n, 22, 23, 74, 65, 76, 93, 86, 95, 91, 74, 75, 112, 70, 75, 75, 64, 88, 71, 92, 65, 64, 67, 75, 64, 90, ci.l, 71, 93, ci.l, 75, 67, 94, 90, 87, 37, 49, 38, 50, 54, 38, 45, 32, 58, 28, 32, 34, 51, 51, 42, 45, 36, 115, 112, 126, 123, 64, 107, 118, 114, 122, 64, 114, 108, 48, 44, 33, 35, 37, 45, 37, 46, 52, 9, 36, 7, ci.n, 4, 0, ci.n, 6, 1, 33, 28, 24, ci.n, 20, 3, 23, 19, 3, 21, 18, 57, ci.m, 2};
    }

    public static void A0B() {
        A0F = new String[]{"4yJhIog9RzpC9w4XHjq79o6hmz2pMXrt", "bLneqHgNlbzxjE", "P7gevZ65hMGDm5VmgpkLcWEi46YxYduR", "Pajg2XTKXpS0pN0AoGLcPnQoa2IWF6Z7", "YyJRdl3XxpBTstTmsw", "OvgbPt0JG7dlaj99kqPbJKVmb9CPKTVr", "21VbiQWRKHmC0d4xB3zoTsbqXtN2ZOxw", "Q3Y9mBD7X4l0uaedlY7FP5X0xCsXbtIX"};
    }

    public abstract void A0N();

    public abstract void A0Q(InterfaceC12510m interfaceC12510m, C14498q c14498q, C14478o c14478o, Map<String, Object> map);

    static {
        A0B();
        A0A();
        LZ.A02();
        A0J = AbstractC1898Rb.class.getSimpleName();
        A0G = new Handler(Looper.getMainLooper());
    }

    public AbstractC1898Rb(C2026Wb c2026Wb, C12741j c12741j) {
        this.A0C = c2026Wb;
        this.A08 = c12741j;
        K6 k6 = A0I;
        if (k6 != null) {
            this.A0B = k6;
        } else {
            this.A0B = new K6(this.A0C);
        }
        this.A0B.A0R(this);
        C12560r c12560r = A0H;
        if (c12560r != null) {
            this.A0A = c12560r;
        } else {
            this.A0A = new C12560r();
        }
        if (C1693Iy.A0j(this.A0C)) {
            try {
                CookieManager.getInstance();
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(this.A0C);
                }
            } catch (Exception e2) {
                Log.w(A0J, A08(48, 35, 112), e2);
            }
        }
        DynamicLoaderFactory.makeLoader(this.A0C).getInitApi().onAdLoadInvoked(this.A0C);
        this.A09 = c2026Wb.A06();
        this.A0C.A0A().A4W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        this.A01 = null;
        C14498q c14498q = this.A05;
        C14478o c14478oA04 = c14498q.A04();
        String strA08 = A08(0, 0, 73);
        if (c14478oA04 == null) {
            C1697Jd error = C1697Jd.A02(AdErrorType.NO_FILL, strA08);
            this.A0C.A0A().A4Y(error.A04().getErrorCode(), A08(83, 22, 100));
            this.A07.A0F(error);
            return;
        }
        String strA03 = c14478oA04.A03();
        InterfaceC12510m interfaceC12510mA00 = this.A0A.A00(c14498q.A05().A0D());
        if (interfaceC12510mA00 == null) {
            this.A0C.A04().A8H(A08(142, 3, 37), C8Y.A0P, new C8Z(A08(0, 22, 2), strA03));
            A0O();
            return;
        }
        AdPlacementType adapterType = this.A08.A00();
        if (adapterType != interfaceC12510mA00.A6p()) {
            C1697Jd error2 = C1697Jd.A02(AdErrorType.INTERNAL_ERROR, strA08);
            this.A0C.A0A().A4Y(error2.A04().getErrorCode(), A08(105, 19, 7));
            this.A07.A0F(error2);
            return;
        }
        this.A01 = interfaceC12510mA00;
        C14508r c14508rA05 = c14498q.A05();
        JSONObject jSONObjectA06 = c14478oA04.A06();
        if (jSONObjectA06 != null) {
            String[] strArr = A0F;
            if (strArr[0].charAt(1) == strArr[5].charAt(1)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[4] = "xCRhnlDAhS4MFpckcT";
            strArr2[1] = "gHgyVSON2W8zeI";
            String strOptString = jSONObjectA06.optString(A08(259, 10, 110));
            this.A0C.A0A().ADO(strOptString);
            this.A0C.A08(strOptString);
            C2027Wc sdkContext = AnonymousClass86.A00();
            if (sdkContext != null) {
                sdkContext.A08(strOptString);
            }
            if (A0F[2].charAt(5) != 'Z') {
                String[] strArr3 = A0F;
                strArr3[6] = "8Wq26Ceqv565ijof1GdoYggHtr98JF3l";
                strArr3[6] = "8Wq26Ceqv565ijof1GdoYggHtr98JF3l";
                A0E(jSONObjectA06.optJSONObject(A08(208, 17, 28)));
            } else {
                String[] strArr4 = A0F;
                strArr4[4] = "ECm89W61U2RjXtlAFB";
                strArr4[1] = "vfVrRI5o8HJ5sJ";
                String errorMessage = A08(208, 17, 75);
                A0E(jSONObjectA06.optJSONObject(errorMessage));
            }
        }
        HashMap map = new HashMap();
        map.put(A08(147, 4, 55), jSONObjectA06);
        map.put(A08(166, 10, 113), c14508rA05);
        map.put(A08(237, 11, 72), this.A08.A08);
        map.put(A08(248, 11, 125), Long.valueOf(c14508rA05.A0C()));
        map.put(A08(151, 15, 93), c14478oA04.A04());
        if (this.A06 == null) {
            String strA082 = A08(188, 20, 38);
            C1697Jd c1697JdA02 = C1697Jd.A02(AdErrorType.UNKNOWN_ERROR, strA082);
            this.A0C.A0A().A4Y(c1697JdA02.A04().getErrorCode(), strA082);
            this.A07.A0F(c1697JdA02);
            return;
        }
        A0Q(interfaceC12510mA00, c14498q, c14478oA04, map);
    }

    private final void A0D(@Nullable String str, @Nullable AdExperienceType adExperienceType) {
        this.A0C.A0A().A4Z(str != null);
        this.A04 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 17) {
            A9p(new C1697Jd(AdErrorType.API_NOT_SUPPORTED, A08(0, 0, 73)));
            return;
        }
        try {
            this.A06 = this.A08.A01(this.A0C, new C1707Jo(this.A0C, str, this.A08.A08, this.A08.A07), adExperienceType);
            if (A0F[6].charAt(21) == '6') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[4] = "3q2wB1pMY3UXfOrLgu";
            strArr[1] = "CsXqAZILgfX2KA";
            this.A0B.A0Q(this.A06);
        } catch (C1698Je e2) {
            A9p(C1697Jd.A03(e2));
        }
    }

    private void A0E(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            this.A03 = jSONObject.optString(A08(176, 12, 39));
            C12580t.A0H(jSONObject);
        }
    }

    public final long A0F() {
        C14498q c14498q = this.A05;
        if (c14498q != null) {
            return c14498q.A03();
        }
        return -1L;
    }

    public final Handler A0G() {
        return A0G;
    }

    public final C14508r A0H() {
        C14498q c14498q = this.A05;
        if (c14498q == null) {
            return null;
        }
        return c14498q.A05();
    }

    @Nullable
    public final String A0I() {
        InterfaceC12510m interfaceC12510m = this.A02;
        if (interfaceC12510m == null) {
            return null;
        }
        return interfaceC12510m.A5q();
    }

    public final void A0J() {
        this.A0C.A0A().A2h(LP.A01(this.A04));
        if (this.A02 == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(A08(225, 12, 23), LP.A04(this.A04));
        new JC(this.A02.A5q(), this.A09).A03(JB.A08, map);
    }

    public final void A0K() {
        InterfaceC12510m interfaceC12510m = this.A02;
        String strA08 = A08(142, 3, 37);
        if (interfaceC12510m == null) {
            String strA082 = A08(22, 26, 7);
            this.A0C.A04().A8H(strA08, C8Y.A0F, new C8Z(strA082));
            AdErrorType adErrorType = AdErrorType.INTERNAL_ERROR;
            this.A0C.A0A().A4Y(adErrorType.getErrorCode(), strA082);
            this.A07.A0F(C1697Jd.A02(adErrorType, adErrorType.getDefaultErrorMessage()));
            this.A0C.A0A().A4b();
            return;
        }
        if (this.A0D) {
            String strA083 = A08(124, 18, 67);
            this.A0C.A04().A8H(strA08, C8Y.A0C, new C8Z(strA083));
            AdErrorType adErrorType2 = AdErrorType.AD_ALREADY_STARTED;
            this.A0C.A0A().A4Y(adErrorType2.getErrorCode(), strA083);
            this.A07.A0F(C1697Jd.A02(adErrorType2, adErrorType2.getDefaultErrorMessage()));
            this.A0C.A0A().A4a();
            return;
        }
        if (!TextUtils.isEmpty(this.A02.A5q())) {
            this.A09.A8Y(this.A02.A5q());
        }
        this.A0C.A0A().A4c();
        this.A0D = true;
        A0N();
    }

    public final void A0L() {
        A0W(false);
    }

    public final void A0M() {
        String str = this.A03;
        if (str != null) {
            C12580t.A0E(str);
        }
    }

    public final synchronized void A0O() {
        A0G.post(new RZ(this));
    }

    public final void A0P(InterfaceC12510m interfaceC12510m) {
        if (interfaceC12510m != null) {
            interfaceC12510m.onDestroy();
        }
    }

    public final void A0R(AbstractC12520n abstractC12520n) {
        this.A07 = abstractC12520n;
    }

    public void A0S(@Nullable String str) {
        A0D(str, null);
    }

    public final void A0T(@Nullable String str) {
        A0S(str);
    }

    public final void A0U(@Nullable String str, @Nullable AdExperienceType adExperienceType) {
        A0D(str, adExperienceType);
    }

    public final void A0V(Map<String, Object> map) {
        this.A0C.A0A().A4V();
        Object obj = map.get(A08(147, 4, 55));
        if (obj instanceof JSONObject) {
            String strOptString = ((JSONObject) obj).optString(A08(145, 2, 71));
            if (!TextUtils.isEmpty(strOptString)) {
                new JC(strOptString, this.A09).A03(JB.A04, null);
            }
        }
    }

    public final void A0W(boolean z) {
        if (!z && !this.A0D) {
            return;
        }
        this.A0C.A0A().A4d();
        A0P(this.A02);
        this.A00 = null;
        this.A0D = false;
    }

    public final boolean A0X() {
        C14498q c14498q = this.A05;
        return c14498q == null || c14498q.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.K5
    public final synchronized void A9p(C1697Jd c1697Jd) {
        A0G().post(new C1897Ra(this, c1697Jd));
    }

    @Override // com.facebook.ads.redexgen.X.K5
    public final synchronized void ABM(C2166ag c2166ag) {
        A0G().post(new RY(this, c2166ag));
    }
}

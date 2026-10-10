package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13604u implements AudienceNetworkActivityApi, Repairable {
    public static byte[] A0P;
    public static String[] A0Q;
    public int A00;
    public int A02;
    public long A03;
    public long A04;
    public Intent A05;
    public RelativeLayout A06;
    public JC A07;
    public KC A08;

    @Nullable
    public M0 A09;
    public MZ A0A;
    public NO A0B;

    @Nullable
    public OS A0C;
    public String A0D;
    public String A0E;

    @Nullable
    public String A0F;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public final AudienceNetworkActivity A0L;
    public final AudienceNetworkActivityApi A0M;
    public final C2026Wb A0N;
    public final List<InterfaceC13584s> A0O = new ArrayList();
    public int A01 = -1;
    public boolean A0G = false;

    static {
        A08();
        A07();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0P, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 111);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0P = new byte[]{-37, 7, 40, 37, 56, 42, 55, 80, 67, 68, 78, 71, 2, 86, 81, 2, 75, 80, 72, 71, 84, 2, 88, 75, 71, 89, 54, 91, 82, 71, 2, 72, 84, 81, 79, 2, 75, 80, 86, 71, 80, 86, 2, 81, 84, 2, 85, 67, 88, 71, 70, 43, 80, 85, 86, 67, 80, 69, 71, 53, 86, 67, 86, 71, -24, -11, -26, -24, -22, -5, -16, -3, -16, -5, 0, -10, -1, -4, -8, 1, 7, -25, 2, -2, -8, 1, -44, -32, -34, -97, -41, -46, -44, -42, -45, -32, -32, -36, -97, -46, -43, -28, -97, -46, -43, -29, -42, -31, -32, -29, -27, -38, -33, -40, -97, -73, -70, -65, -70, -60, -71, -48, -78, -75, -48, -61, -74, -63, -64, -61, -59, -70, -65, -72, -48, -73, -67, -64, -56, 1, ci.k, 11, -52, 4, -1, 1, 3, 0, ci.k, ci.k, 9, -52, -1, 2, 17, -52, 7, 12, 18, 3, ci.n, 17, 18, 7, 18, 7, -1, 10, -52, -1, 1, 18, 7, 20, 7, 18, 23, -3, 2, 3, 17, 18, ci.n, ci.k, 23, 3, 2, -32, -20, -22, -85, -29, -34, -32, -30, -33, -20, -20, -24, -85, -34, -31, -16, -85, -26, -21, -15, -30, -17, -16, -15, -26, -15, -26, -34, -23, -85, -31, -26, -16, -22, -26, -16, -16, -30, -31, ci.m, 27, 25, -38, 18, ci.k, ci.m, 17, ci.l, 27, 27, 23, -38, ci.k, ci.n, 31, -38, 21, 26, 32, 17, 30, 31, 32, 21, 32, 21, ci.k, 24, -38, ci.n, 21, 31, 28, 24, ci.k, 37, 17, ci.n, -23, -11, -13, -76, -20, -25, -23, -21, -24, -11, -11, -15, -76, -25, -22, -7, -76, -17, -12, -6, -21, -8, -7, -6, -17, -6, -17, -25, -14, -76, -21, -8, -8, -11, -8, ci.n, 28, 26, -37, 19, ci.l, ci.n, 18, ci.m, 28, 28, 24, -37, ci.l, 17, 32, -37, 22, 27, 33, 18, 31, 32, 33, 22, 33, 22, ci.l, 25, -37, 19, 22, 27, 22, 32, 21, 12, ci.l, ci.n, 33, 22, 35, 22, 33, 38, 54, 66, 64, 1, 57, 52, 54, 56, 53, 66, 66, 62, 1, 52, 55, 70, 1, 60, 65, 71, 56, 69, 70, 71, 60, 71, 60, 52, Utf8.REPLACEMENT_BYTE, 1, 60, 64, 67, 69, 56, 70, 70, 60, 66, 65, 1, Utf8.REPLACEMENT_BYTE, 66, 58, 58, 56, 55, 77, 94, 77, 86, 92, 49, 38, 51, 41, 56, 40, 38, 53, 42, 69, 61, 60, 65, 57, 76, 65, 71, 70, 28, 57, 76, 57, 18, ci.l, 3, 5, 7, ci.m, 7, ci.n, 22, -21, 6, -7, -8, -5, -3, -5, -22, -14, -3, 87, 89, 76, 75, 76, 77, 80, 85, 76, 75, 54, 89, 80, 76, 85, 91, 72, 91, 80, 86, 85, 50, 76, 96, 78, 65, 77, 81, 65, 79, 80, 48, 69, 73, 65, -7, -15, -17, -10, -57, -20, -6, -21, -8, -39, -21, -23, -11, -12, -22, -7, 45, 40, 24, 40, 43, 34, 30, 39, 45, 26, 45, 34, 40, 39, -11, -18, -23, -15, -11, -27, -55, -28, 58, 45, 41, 59, 24, 61, 52, 41};
    }

    public static void A08() {
        A0Q = new String[]{"6hyfNvrTK6t0uOk4ZUiKTcly4lO9QIT3", "Cx5XWQG9gTlQcsVl0OO6K9WlulTSTZ", "4fLDdlgMQ2q", "AM05mUF2qaDkDYU3MyDNTK", "rN7iVf06fBiMXo1UDWoI2bEJDxOmVmjv", "9bqAz3M9pAQkcUJXzFdGLS", "1D1uNCEUmAwDpqE", "h0QQnxfLOYpp7kAK6sPhgGYv8wQTA65G"};
    }

    public C13604u(AudienceNetworkActivity audienceNetworkActivity, AudienceNetworkActivityApi audienceNetworkActivityApi) {
        this.A0L = audienceNetworkActivity;
        this.A0M = audienceNetworkActivityApi;
        this.A0N = AnonymousClass50.A01(audienceNetworkActivity);
        this.A0N.A0C(this);
    }

    @Nullable
    private M0 A01(Intent intent) {
        C13574r c13574r = new C13574r(this, intent, this.A0N.A06(), this.A0N, null);
        if (this.A08 == null) {
            return null;
        }
        switch (this.A08) {
            case A05:
                return c13574r.A0B(this.A06);
            case A0B:
                return c13574r.A09();
            case A0A:
                return c13574r.A0A();
            case A02:
                return c13574r.A02();
            case A09:
                M0 m0A08 = c13574r.A08();
                if (A0Q[1].length() != 0) {
                    String[] strArr = A0Q;
                    strArr[1] = "wwrXZHO6We2";
                    strArr[1] = "wwrXZHO6We2";
                    return m0A08;
                }
                String[] strArr2 = A0Q;
                strArr2[1] = "bd05r2lrBXgQHiU8zhW56DndFWzJq";
                strArr2[1] = "bd05r2lrBXgQHiU8zhW56DndFWzJq";
                return m0A08;
            case A07:
                return c13574r.A06();
            case A06:
                M0 m0A05 = c13574r.A05();
                if (A0Q[2].length() == 25) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A0Q;
                strArr3[7] = "st3v0TpfdqXoPWlO02nQcse4uCAIapoF";
                strArr3[7] = "st3v0TpfdqXoPWlO02nQcse4uCAIapoF";
                return m0A05;
            case A08:
                return c13574r.A07();
            case A03:
                M0 m0A03 = c13574r.A03();
                if (A0Q[7].charAt(27) == 'B') {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0Q;
                strArr4[1] = "x";
                strArr4[1] = "x";
                return m0A03;
            case A04:
                return c13574r.A04();
            default:
                return null;
        }
    }

    private void A05() {
        String str = this.A0F;
        if (str != null) {
            this.A0C = OR.A01(this.A0N, str);
            if (this.A0C != null) {
                this.A06.addView(this.A0C, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void A06() {
        if (!this.A0J) {
            if (A0H()) {
                A0E(EnumC1836Or.A03.A02());
            } else {
                A0E(A04(139, 48, 47));
            }
            this.A0J = true;
        }
    }

    private void A09(Intent intent) {
        if (C1693Iy.A0r(this.A0L)) {
            KC kc = this.A08;
            KC kc2 = KC.A02;
            if (A0Q[2].length() == 25) {
                throw new RuntimeException();
            }
            String[] strArr = A0Q;
            strArr[1] = "ROWUzhbvPevH2";
            strArr[1] = "ROWUzhbvPevH2";
            if (kc != kc2 && Build.VERSION.SDK_INT >= 18) {
                this.A0B = new NO();
                this.A0B.A0D(intent.getStringExtra(A04(419, 11, 51)));
                this.A0B.A0C(this.A0L.getPackageName());
                long longExtra = intent.getLongExtra(A04(462, 11, 109), 0L);
                if (longExtra != 0) {
                    this.A0B.A0A(longExtra);
                }
                TextView textView = new TextView(this.A0L);
                textView.setText(A04(1, 5, 84));
                textView.setTextColor(-1);
                LX.A0P(textView, Color.argb(160, 0, 0, 0));
                textView.setPadding(5, 5, 5, 5);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12, -1);
                layoutParams.addRule(11, -1);
                textView.setLayoutParams(layoutParams);
                ViewOnLongClickListenerC13594t viewOnLongClickListenerC13594t = new ViewOnLongClickListenerC13594t(this);
                textView.setOnLongClickListener(viewOnLongClickListenerC13594t);
                this.A06.setOnLongClickListener(viewOnLongClickListenerC13594t);
                this.A06.getOverlay().add(this.A0B);
            }
        }
    }

    private void A0A(Intent intent, @Nullable Bundle bundle) {
        String strA04 = A04(511, 8, 85);
        String strA042 = A04(503, 8, 17);
        String strA043 = A04(438, 24, 120);
        if (bundle != null) {
            Bundle adnwSavedStateBundle = C1725Kh.A02(bundle, DynamicLoaderImpl.class.getClassLoader());
            this.A01 = adnwSavedStateBundle.getInt(strA043, -1);
            this.A0D = adnwSavedStateBundle.getString(strA042);
            this.A08 = (KC) adnwSavedStateBundle.getSerializable(strA04);
            return;
        }
        this.A01 = intent.getIntExtra(strA043, -1);
        this.A0D = intent.getStringExtra(strA042);
        this.A08 = (KC) intent.getSerializableExtra(strA04);
        this.A02 = intent.getIntExtra(A04(473, 16, 23), 0) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0E(java.lang.String r6) {
        /*
            r5 = this;
            r2 = 345(0x159, float:4.83E-43)
            r1 = 47
            r0 = 100
            java.lang.String r0 = A04(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            r4 = 1
            if (r0 != 0) goto L1d
            com.facebook.ads.redexgen.X.Or r0 = com.facebook.ads.redexgen.X.EnumC1836Or.A0A
            java.lang.String r0 = r0.A02()
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L1f
        L1d:
            r5.A0I = r4
        L1f:
            r2 = 265(0x109, float:3.71E-43)
            r1 = 35
            r0 = 23
            java.lang.String r0 = A04(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L5a
            com.facebook.ads.redexgen.X.Or r0 = com.facebook.ads.redexgen.X.EnumC1836Or.A09
            java.lang.String r3 = r0.A02()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C13604u.A0Q
            r0 = 6
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 15
            if (r1 == r0) goto L48
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L48:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C13604u.A0Q
            java.lang.String r1 = "BsUqgJlN3izr4734FAkiK4"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "DZ4pb9dksBh2p0w2isnwDh"
            r0 = 3
            r2[r0] = r1
            boolean r0 = r3.equals(r6)
            if (r0 == 0) goto L5c
        L5a:
            r5.A0H = r4
        L5c:
            r2 = 86
            r1 = 53
            r0 = 2
            java.lang.String r0 = A04(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L71
            r0 = 9
            r5.finish(r0)
            return
        L71:
            r2 = 300(0x12c, float:4.2E-43)
            r1 = 45
            r0 = 62
            java.lang.String r0 = A04(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L87
            r0 = 10
            r5.finish(r0)
            return
        L87:
            r0 = 0
            r5.A0G(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C13604u.A0E(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(String str, C1P c1p) {
        if (this.A09 == null) {
            return;
        }
        if (this.A0A == null) {
            C2026Wb c2026Wb = this.A0N;
            this.A0A = C1768Ma.A02(c2026Wb, c2026Wb.A06(), str, c1p, this.A09, new C1933Sm(this));
            this.A0A.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        LX.A0M(this.A0A);
        LX.A0X(this.A06);
        this.A06.addView(this.A0A);
        this.A0A.A0J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(String str, @Nullable AnonymousClass98 anonymousClass98) {
        Intent intent = new Intent(str + A04(0, 1, 50) + this.A0D);
        if (anonymousClass98 != null) {
            intent.putExtra(A04(392, 5, 121), anonymousClass98);
        }
        C2E.A00(this.A0L).A08(intent);
    }

    private boolean A0H() {
        return this.A08 == KC.A0B || this.A08 == KC.A0A;
    }

    public final AudienceNetworkActivity A0I() {
        return this.A0L;
    }

    public final C2026Wb A0J() {
        return this.A0N;
    }

    @VisibleForTesting
    public final void A0K() {
        if (A0H()) {
            A0E(EnumC1836Or.A09.A02());
        } else {
            A0E(A04(265, 35, 23));
        }
    }

    public final void A0L(InterfaceC13584s interfaceC13584s) {
        this.A0O.add(interfaceC13584s);
    }

    public final void A0M(InterfaceC13584s interfaceC13584s) {
        this.A0O.remove(interfaceC13584s);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void finish(int i) {
        this.A0N.A0A().A2R(String.valueOf(A0I().hashCode()), i);
        if (this.A0L.isFinishing()) {
            return;
        }
        if (C1693Iy.A16(this.A0N) && !this.A0I && !this.A0H) {
            this.A0N.A0A().A8s();
            A0K();
        }
        if (A0H() && !this.A0G) {
            A0E(EnumC1836Or.A05.A02());
        } else {
            A0E(A04(187, 39, 14));
        }
        A06();
        this.A0M.finish(i);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onActivityResult(int i, int i2, Intent intent) {
        XM.A09(i, i2, intent);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onBackPressed() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.A03 += jCurrentTimeMillis - this.A04;
        this.A04 = jCurrentTimeMillis;
        if (this.A03 > this.A02) {
            boolean shouldIntercept = false;
            Iterator<InterfaceC13584s> it = this.A0O.iterator();
            while (it.hasNext()) {
                if (it.next().A7i()) {
                    shouldIntercept = true;
                }
            }
            if (!shouldIntercept) {
                this.A0M.onBackPressed();
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onConfigurationChanged(Configuration configuration) {
        M0 m0 = this.A09;
        if (m0 instanceof C2071Xu) {
            C2071Xu c2071Xu = (C2071Xu) m0;
            String[] strArr = A0Q;
            if (strArr[0].charAt(26) != strArr[4].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Q;
            strArr2[2] = "hDbrw";
            strArr2[2] = "hDbrw";
            c2071Xu.onConfigurationChanged(configuration);
        }
        if (this.A00 != configuration.orientation) {
            HashMap map = new HashMap();
            int i = configuration.orientation;
            String strA04 = A04(489, 14, 74);
            if (i == 1) {
                map.put(strA04, A04(430, 8, 26));
            } else {
                map.put(strA04, A04(397, 9, 86));
            }
            this.A07.A03(JB.A0K, map);
            this.A00 = configuration.orientation;
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onCreate(@Nullable Bundle bundle) {
        LZ.A02();
        this.A05 = C1725Kh.A01(this.A0L.getIntent(), DynamicLoaderImpl.class.getClassLoader());
        C2026Wb c2026WbA03 = C1725Kh.A03(this.A05);
        if (c2026WbA03 != null) {
            this.A0N.A0B(c2026WbA03.A0A());
            C2026Wb c2026Wb = this.A0N;
            String[] strArr = A0Q;
            if (strArr[0].charAt(26) != strArr[4].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Q;
            strArr2[6] = "7njofUp2AYjKONZ";
            strArr2[6] = "7njofUp2AYjKONZ";
            c2026Wb.A08(c2026WbA03.A07());
        }
        this.A0N.A0A().A2S(String.valueOf(A0I().hashCode()));
        this.A0L.requestWindowFeature(1);
        this.A0L.getWindow().setFlags(1024, 1024);
        this.A06 = new RelativeLayout(this.A0L);
        LX.A0P(this.A06, 0);
        this.A0L.setContentView(this.A06, new RelativeLayout.LayoutParams(-1, -1));
        A0A(this.A05, bundle);
        this.A09 = A01(this.A05);
        M0 m0 = this.A09;
        if (m0 == null) {
            this.A0N.A04().A8H(A04(64, 11, 24), C8Y.A02, new C8Z(A04(6, 58, 115)));
            A0K();
            finish(7);
            return;
        }
        m0.A85(this.A05, bundle, this);
        A0E(A04(226, 39, 61));
        this.A04 = System.currentTimeMillis();
        this.A0F = this.A05.getStringExtra(A04(406, 13, 105));
        A05();
        A09(this.A05);
        this.A00 = this.A0L.getResources().getConfiguration().orientation;
        String strA04 = A04(75, 11, 36);
        if (bundle != null) {
            this.A0E = bundle.getString(strA04);
        } else {
            this.A0E = this.A05.getStringExtra(strA04);
        }
        this.A07 = new JC(this.A0E, this.A0N.A06());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r4 = this;
            com.facebook.ads.redexgen.X.Wb r0 = r4.A0N
            com.facebook.ads.redexgen.X.0R r1 = r0.A0A()
            com.facebook.ads.AudienceNetworkActivity r0 = r4.A0I()
            int r0 = r0.hashCode()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.A2T(r0)
            r4.A06()
            android.widget.RelativeLayout r0 = r4.A06
            if (r0 == 0) goto L1f
            r0.removeAllViews()
        L1f:
            com.facebook.ads.redexgen.X.M0 r0 = r4.A09
            if (r0 == 0) goto L4f
            r0.onDestroy()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C13604u.A0Q
            r0 = 0
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L40
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L40:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C13604u.A0Q
            java.lang.String r1 = "BK5JyIukG"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "BK5JyIukG"
            r0 = 1
            r2[r0] = r1
            r0 = 0
            r4.A09 = r0
        L4f:
            com.facebook.ads.redexgen.X.NO r3 = r4.A0B
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C13604u.A0Q
            r0 = 0
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L98
            if (r3 == 0) goto L74
        L67:
            com.facebook.ads.AudienceNetworkActivity r0 = r4.A0L
            boolean r0 = com.facebook.ads.redexgen.X.C1693Iy.A0r(r0)
            if (r0 == 0) goto L74
            com.facebook.ads.redexgen.X.NO r0 = r4.A0B
            r0.A08()
        L74:
            com.facebook.ads.redexgen.X.MZ r3 = r4.A0A
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C13604u.A0Q
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 25
            if (r1 == r0) goto L95
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C13604u.A0Q
            java.lang.String r1 = "rHb3ILEFnyWtMYiOwcguj0"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "XKBHK5KZoSEcfbvzOM5yLt"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L94
        L91:
            r3.A0I()
        L94:
            return
        L95:
            if (r3 == 0) goto L94
            goto L91
        L98:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C13604u.A0Q
            java.lang.String r1 = "VoJV9dI9dal5KZ60JkB8i5Bpps"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "VoJV9dI9dal5KZ60JkB8i5Bpps"
            r0 = 2
            r2[r0] = r1
            if (r3 == 0) goto L74
            goto L67
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C13604u.onDestroy():void");
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onPause() {
        this.A0N.A0A().A2U(String.valueOf(A0I().hashCode()));
        this.A03 += System.currentTimeMillis() - this.A04;
        M0 m0 = this.A09;
        if (m0 != null) {
            m0.AAh(false);
            if (!this.A0L.isFinishing()) {
                this.A07.A03(JB.A0E, null);
                this.A0K = true;
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onResume() {
        this.A0N.A0A().A2V(String.valueOf(A0I().hashCode()));
        this.A04 = System.currentTimeMillis();
        M0 m0 = this.A09;
        if (m0 != null) {
            m0.AB4(false);
            if (this.A0K) {
                this.A07.A03(JB.A0F, null);
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        M0 m0 = this.A09;
        if (m0 != null) {
            m0.ACz(bundle2);
        }
        bundle2.putInt(A04(438, 24, 120), this.A01);
        bundle2.putString(A04(503, 8, 17), this.A0D);
        bundle2.putString(A04(75, 11, 36), this.A0E);
        bundle2.putSerializable(A04(511, 8, 85), this.A08);
        C1725Kh.A09(bundle, bundle2);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onStart() {
        this.A0N.A0A().A2W(String.valueOf(A0I().hashCode()));
        int i = this.A01;
        if (i != -1) {
            C1758Lq.A03(this.A0L, i, this.A0N);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onStop() {
        this.A0N.A0A().A2X(String.valueOf(A0I().hashCode()));
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C13775l.A03(null, motionEvent);
        return this.A0M.onTouchEvent(motionEvent);
    }

    @Override // com.facebook.ads.internal.api.Repairable
    public final void repair(Throwable th) {
        A0K();
        finish(5);
    }
}

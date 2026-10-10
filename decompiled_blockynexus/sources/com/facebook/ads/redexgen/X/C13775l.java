package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ThreadSafe
public final class C13775l {
    public static byte[] A00;
    public static String[] A01;
    public static final AtomicReference<C13825q> A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[4].charAt(15) != 'H') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "ewynTuX5etTUvRbKneAORAXWy6m3gfja";
            strArr[0] = "MEXbvG7De7lT0m7kyXT3Vo2bJU5t0LAQ";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 28);
            i4++;
        }
    }

    public static void A01() {
        A00 = new byte[]{60, 40, 57, 52, 56, 51, 62, 56, 2, 51, 56, 41, 42, 50, 47, 54, 115, 57, 56, 37, 45, 47, 36, 47, 56, 35, 41};
    }

    public static void A02() {
        A01 = new String[]{"r7c1s5U0efOStYGowMowhUbuYlQTG1Tt", "4N5luf2P5Kce0fziMzoENYJ9JUsEy4RG", "Zwxj", "L2KmiKnie6D54jPyz7fJn9CofNiJStjg", "Reipc3PbxUqE4G7HYurM4m8tamMVkuwI", "qFHCxa5Kyhox8u", "zslT757DGHQcDkpTRw1DlpZ4hqoBSQOy", "oFLB5GUqllb2V05SIM"};
    }

    static {
        A02();
        A01();
        A02 = new AtomicReference<>();
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A03(@Nullable Activity activity, MotionEvent motionEvent) {
        C13825q c13825q;
        try {
            if (C13785m.A0Q(activity) && (c13825q = A02.get()) != null) {
                c13825q.A06(motionEvent);
            }
        } catch (Throwable th) {
            C2027Wc c2027WcA00 = AnonymousClass86.A00();
            if (c2027WcA00 != null) {
                c2027WcA00.A04().A8H(A00(20, 7, 86), C8Y.A10, new C8Z(th));
            }
        }
    }

    public static void A04(Context context) {
        if (!(context instanceof Application)) {
            return;
        }
        C1728Kk.A06(new TN());
    }

    public static void A05(C2027Wc c2027Wc, @Nullable String str) {
        ExecutorC1744Lc.A06.execute(new TK(c2027Wc, str));
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A06(C2027Wc c2027Wc, String str) {
        if (!C13785m.A0Q(c2027Wc)) {
            return;
        }
        if (A02.get() == null && C14136w.A0F(C14136w.A03(str))) {
            A05(c2027Wc, str);
            return;
        }
        C13825q c13825q = A02.get();
        if (c13825q != null) {
            ExecutorC1744Lc.A06.execute(new TL(c13825q, str, c2027Wc));
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.facebook.ads.redexgen.X.5o] */
    @SuppressLint({"CatchGeneralException"})
    public static synchronized void A08(C2027Wc c2027Wc, @Nullable String str) {
        try {
            if (A02.get() != null) {
                return;
            }
            if (C13785m.A0Q(c2027Wc)) {
                TP tp = new TP(c2027Wc);
                TO to = new TO(c2027Wc);
                C13815p c13815pA0J = new Object() { // from class: com.facebook.ads.redexgen.X.5o
                    public double A00;
                    public float A01;
                    public int A02;
                    public int A03;
                    public int A04;
                    public int A05;
                    public int A06;
                    public long A07;
                    public long A08;
                    public long A09;
                    public InterfaceC13905y A0A;
                    public C5z A0B;
                    public AnonymousClass60 A0C;
                    public EnumC13936c A0D;
                    public InterfaceC14056o A0E;
                    public InterfaceC14066p A0F;
                    public Class A0G;

                    @Nullable
                    public String A0H;

                    @Nullable
                    public String A0I;
                    public String A0J;
                    public HashMap<Integer, Integer> A0K;
                    public Map<Integer, String> A0L;
                    public ScheduledExecutorService A0M;
                    public boolean A0N;

                    public final C13805o A00(double d2) {
                        this.A00 = d2;
                        return this;
                    }

                    public final C13805o A01(float f2) {
                        this.A01 = f2;
                        return this;
                    }

                    public final C13805o A02(int i) {
                        this.A02 = i;
                        return this;
                    }

                    public final C13805o A03(int i) {
                        this.A03 = i;
                        return this;
                    }

                    public final C13805o A04(int i) {
                        this.A04 = i;
                        return this;
                    }

                    public final C13805o A05(int i) {
                        this.A05 = i;
                        return this;
                    }

                    public final C13805o A06(int i) {
                        this.A06 = i;
                        return this;
                    }

                    public final C13805o A07(long j) {
                        this.A07 = j;
                        return this;
                    }

                    public final C13805o A08(long j) {
                        this.A08 = j;
                        return this;
                    }

                    public final C13805o A09(InterfaceC13905y interfaceC13905y) {
                        this.A0A = interfaceC13905y;
                        return this;
                    }

                    public final C13805o A0A(C5z c5z) {
                        this.A0B = c5z;
                        return this;
                    }

                    public final C13805o A0B(AnonymousClass60 anonymousClass60) {
                        this.A0C = anonymousClass60;
                        return this;
                    }

                    public final C13805o A0C(EnumC13936c enumC13936c) {
                        this.A0D = enumC13936c;
                        return this;
                    }

                    public final C13805o A0D(Class cls) {
                        this.A0G = cls;
                        return this;
                    }

                    public final C13805o A0E(@Nullable String str2) {
                        this.A0I = str2;
                        return this;
                    }

                    public final C13805o A0F(String str2) {
                        this.A0J = str2;
                        return this;
                    }

                    public final C13805o A0G(HashMap<Integer, Integer> circularBufferLengthMap) {
                        this.A0K = circularBufferLengthMap;
                        return this;
                    }

                    public final C13805o A0H(Map map) {
                        this.A0L = map;
                        return this;
                    }

                    public final C13805o A0I(boolean z) {
                        this.A0N = z;
                        return this;
                    }

                    public final C13815p A0J() {
                        C13815p c13815p = new C13815p();
                        c13815p.A0J = this.A0N;
                        c13815p.A02 = this.A04;
                        c13815p.A0G = this.A0K;
                        c13815p.A01 = this.A03;
                        c13815p.A00 = this.A02;
                        c13815p.A04 = this.A06;
                        c13815p.A0F = this.A0J;
                        c13815p.A07 = this.A0B;
                        c13815p.A06 = this.A0A;
                        double unused = C13815p.A0K = this.A00;
                        c13815p.A09 = this.A0D;
                        c13815p.A0H = this.A0L;
                        c13815p.A03 = this.A05;
                        c13815p.A0C = this.A0G;
                        c13815p.A08 = this.A0C;
                        float unused2 = C13815p.A0L = this.A01;
                        long unused3 = C13815p.A0N = this.A08;
                        long unused4 = C13815p.A0M = this.A07;
                        c13815p.A05 = this.A09;
                        c13815p.A0B = this.A0F;
                        c13815p.A0A = this.A0E;
                        c13815p.A0I = this.A0M;
                        c13815p.A0D = this.A0H;
                        c13815p.A0E = this.A0I;
                        return c13815p;
                    }
                }.A0I(true).A04(C13785m.A05(c2027Wc)).A02(C13785m.A03(c2027Wc)).A03(C13785m.A04(c2027Wc)).A06(C13785m.A07(c2027Wc)).A0G(C13785m.A0M()).A0A(tp).A09(to.A01()).A00(C13785m.A01(c2027Wc)).A0C(EnumC13936c.A0G).A0F(C13785m.A0D(c2027Wc)).A0H(C13785m.A0N(c2027Wc)).A05(C13785m.A06(c2027Wc)).A0D(Build.class).A01(C13785m.A02(c2027Wc)).A08(C13785m.A09(c2027Wc)).A07(C13785m.A08(c2027Wc)).A0B(to).A0E(A00(0, 20, 65)).A0J();
                if (C13785m.A0R(c2027Wc)) {
                    A04(c2027Wc.getApplicationContext());
                }
                C13825q c13825q = new C13825q(c2027Wc, c13815pA0J, C13785m.A0A(c2027Wc));
                if (str != null) {
                    c13825q.A07(str);
                }
                A02.set(c13825q);
            }
        } finally {
        }
    }
}

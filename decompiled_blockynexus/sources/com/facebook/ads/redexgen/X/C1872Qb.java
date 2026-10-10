package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.dynamiclayout.DynamicFullScreenAdView$AdFormatType;
import com.facebook.proguard.annotations.DoNotStrip;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1872Qb extends FrameLayout implements M0 {
    public static byte[] A0M;
    public static String[] A0N;
    public long A00;
    public InterfaceC13584s A01;

    @Nullable
    public C13604u A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final AnonymousClass15 A06;
    public final AnonymousClass77 A07;
    public final C2026Wb A08;
    public final J5 A09;
    public final JC A0A;
    public final LL A0B;
    public final LQ A0C;
    public final InterfaceC1767Lz A0D;
    public final MU A0E;
    public final NG A0F;
    public final O3 A0G;

    @DoNotStrip
    public final AbstractC1848Pd A0H;
    public final C1849Pe A0I;
    public final String A0J;
    public final LinkedList<O7> A0K;
    public final JSONObject A0L;

    static {
        A0F();
        A0E();
    }

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0M, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        A0M = new byte[]{-83, 116, 108, 110, 108, 110, 115, -96, -106, -92, -95, -101, -106, 123, -96, -90, -105, -92, -104, -109, -107, -105, -117, -114, 124, -113, -102, -103, -100, -98, -109, -104, -111, 112, -109, -104, -109, -99, -110, -113, -114, 82, 81, 79, -99, 81, 83, 101, -92, -89, -107, -88, -77, -78, -75, -73, -84, -79, -86, -106, -73, -92, -75, -73, -88, -89, 107, 106, 104, -74, 106, 108, 126, 19, 18, -27, 7, 24, ci.k, 26, ci.k, 24, 29, -12, 5, 25, 23, 9, 8, -52, -53, -55, 23, -53, -51, -33, -87, -88, 123, -99, -82, -93, -80, -93, -82, -77, -116, -97, -83, -81, -89, -97, -98, 98, 97, 95, -83, 97, 99, 117, 23, 9, 24, -27, 25, 24, 12, -17, 9, 29, -52, -53, -55, 23, -53, -48, -53, -55, 23, -53, -51, -33, -40, -54, -39, -89, -58, -40, -54, -101, -103, -90, -40, -40, -54, -39, -40, -115, -116, -118, -40, -116, -111, -116, -118, -40, -116, -114, -19, -32, -36, -18, -55, -36, -40, -37, -16, -53, -26, -54, -33, -26, -18, -97, -98, -100, -22, -98, -96, -78};
    }

    public static void A0F() {
        A0N = new String[]{"Ky6zrcoV7NYtZpO3AnBVhERgUe61TP4A", VipSubscribeStatus.SUBSCRIPTION_RESTARTED, "MIS71VG0t7feKobdqgnq1TwubiJ1N09z", "nEwmQOfqxRkjYDAAu8TY0n89Pulsb82", "nm6mhrtocmSPL4qM7u9wOkkvqXPHcra", "ADTrDSFqqVysA22fSklmKPGMwsWvvDiN", "oNlgPu", "28CTXOUAXLtNi6XFaROwO0buCKC9QIVi"};
    }

    public C1872Qb(C2026Wb c2026Wb, J5 j5, InterfaceC1767Lz interfaceC1767Lz, AnonymousClass15 anonymousClass15, MU mu, @DynamicFullScreenAdView$AdFormatType int i) {
        super(c2026Wb);
        this.A01 = new C1877Qg(this);
        this.A0K = new LinkedList<>();
        this.A0C = new LQ();
        this.A0H = new C1876Qf(this);
        this.A05 = true;
        this.A04 = false;
        this.A03 = true;
        this.A00 = -1L;
        this.A08 = c2026Wb;
        this.A09 = j5;
        this.A0D = interfaceC1767Lz;
        this.A06 = anonymousClass15;
        this.A0E = mu;
        this.A0J = UUID.randomUUID().toString();
        this.A07 = new AnonymousClass77(this.A08);
        this.A0A = new JC(this.A06.A0Q(), this.A09);
        this.A0G = new O3(anonymousClass15.A0U(), this.A06.A0M().A0E().A08(), i);
        this.A0L = OB.A01(this.A08, this.A06.A0Y(), this.A07, this.A0A, this.A0G);
        this.A0F = new C1873Qc(this, this.A08);
        LX.A0J(IntConstant.PERMISSION_STORAGE_DOWNLOAD, this.A0F);
        this.A0I = new C1849Pe(this.A0F, 1, new WeakReference(this.A0H), this.A08);
        this.A0I.A0Y(this.A06.A0G());
        this.A0I.A0Z(this.A06.A0H());
        this.A0B = new LL(this);
        this.A0B.A05(LK.A03);
    }

    private void A0D() {
        OE oeA0B = new OC(this.A08, this.A06.A0M().A0F(), this.A06.A0O()).A08(this.A06.A0L().A01()).A0B();
        addView(oeA0B, new FrameLayout.LayoutParams(-1, -1));
        oeA0B.A04(new C1874Qd(this));
    }

    @SuppressLint({"AddJavascriptInterface"})
    private final void A0G() {
        if (Build.VERSION.SDK_INT > 16) {
            this.A0F.addJavascriptInterface(new OA(this, this.A09, this.A0G, this.A0J, this.A06.A0Q()), A0B(6, 16, 9));
        }
        C1877Qg c1877Qg = null;
        this.A0A.A03(JB.A0O, null);
        String strA0L = this.A07.A0L(this.A06.A0R());
        this.A0F.loadUrl(strA0L);
        this.A08.A0A().A4v(strA0L);
        this.A00 = System.currentTimeMillis();
        A0I(new O7(A0B(120, 22, 123), new String[]{this.A0J, A0B(1, 5, 21)}, c1877Qg));
        A0I(new O7(A0B(142, 26, 60), new String[]{Base64.encodeToString(this.A0L.toString().getBytes(), 0).replace(A0B(0, 1, 122), A0B(0, 0, 58)), this.A0J}, c1877Qg));
        addView(this.A0F, new FrameLayout.LayoutParams(-1, -1));
        this.A0D.A3L(this, new RelativeLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 19) {
            this.A0B.A05(LK.A04);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public synchronized void A0H() {
        if (this.A04) {
            while (!this.A0K.isEmpty()) {
                this.A0A.A03(JB.A0L, null);
                O7 o7Poll = this.A0K.poll();
                if (o7Poll != null) {
                    this.A0F.evaluateJavascript(String.format(Locale.US, o7Poll.A00, o7Poll.A01), null);
                    this.A08.A0A().A4r(o7Poll.A00);
                }
            }
        }
        if (A0N[7].charAt(0) != '2') {
            throw new RuntimeException();
        }
        String[] strArr = A0N;
        strArr[3] = "FeIxfQNnXPZcrYn4QimnFDA0mG56MnR";
        strArr[4] = "d3TO3pXgE4BX38jvHVYJktmxh6UMTtF";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A0I(O7 o7) {
        this.A0K.offer(o7);
        A0H();
    }

    private void A0L(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new NX(this.A08, this.A0E.A5p(), this.A0I, this.A0C, this.A09, this.A0D).A08(this.A06.A0Q(), str, new HashMap());
    }

    public final void A0O() {
        C13604u c13604u = this.A02;
        if (c13604u == null) {
            return;
        }
        c13604u.finish(4);
    }

    public final void A0P() {
        this.A05 = true;
    }

    public final void A0Q() {
        this.A05 = false;
    }

    public final void A0R() {
        A0L(this.A06.A0M().A0G().A04());
    }

    public final void A0S() {
        this.A0D.A3s(this.A0E.A5M());
        new C1820Ob(this.A08, this.A0E, this.A06.A0V(), this.A0D).A06();
    }

    public final void A0T() {
        new Handler(Looper.getMainLooper()).post(new C1875Qe(this));
    }

    public final void A0U() {
        this.A0I.A0W();
    }

    public final void A0V(String str) {
        A0L(str);
    }

    public final void A0W(Map<String, String> map) {
        this.A09.A8G(this.A06.A0Q(), new NQ(map).A04(this.A0I).A06());
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void A85(Intent intent, @Nullable Bundle bundle, C13604u c13604u) {
        c13604u.A0L(this.A01);
        this.A02 = c13604u;
        A0G();
        if (this.A06.A0M().A0O()) {
            A0D();
        } else {
            if (TextUtils.isEmpty(this.A06.A0M().A0E().A08())) {
                return;
            }
            A0I(new O7(A0B(168, 22, 78), new String[]{this.A0J}, null));
        }
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AAh(boolean z) {
        C1877Qg c1877Qg = null;
        if (z) {
            A0I(new O7(A0B(48, 25, 26), new String[]{this.A0J}, c1877Qg));
        } else {
            A0I(new O7(A0B(73, 23, 123), new String[]{this.A0J}, c1877Qg));
        }
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AB4(boolean z) {
        if (this.A03) {
            this.A03 = false;
            return;
        }
        C1877Qg c1877Qg = null;
        if (A0N[1].length() == 11) {
            throw new RuntimeException();
        }
        String[] strArr = A0N;
        strArr[5] = "5WCDyt3aDRAQqvSthuq2O6x8YHnGvtvN";
        strArr[5] = "5WCDyt3aDRAQqvSthuq2O6x8YHnGvtvN";
        if (z) {
            A0I(new O7(A0B(22, 26, 1), new String[]{this.A0J}, c1877Qg));
        } else {
            A0I(new O7(A0B(96, 24, 17), new String[]{this.A0J}, c1877Qg));
        }
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void ACz(Bundle bundle) {
    }

    public C2026Wb getAdContextWrapper() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void onDestroy() {
        this.A0B.A03();
        this.A09.A8E(this.A06.A0Q(), new NQ().A03(this.A0C).A04(this.A0I).A06());
        this.A01 = null;
        this.A02 = null;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(InterfaceC1767Lz interfaceC1767Lz) {
    }
}

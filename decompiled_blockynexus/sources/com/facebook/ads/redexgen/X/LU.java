package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class LU extends RelativeLayout implements InterfaceC1847Pc, InterfaceC1828Oj, InterfaceC1845Pa {
    public static String[] A0D;
    public static final C1713Ju A0E;
    public static final C1703Jk A0F;
    public static final JA A0G;
    public static final IE A0H;
    public static final ID A0I;
    public static final I0 A0J;
    public static final C1660Hp A0K;
    public static final C1655Hk A0L;
    public int A00;
    public JC A01;
    public C1832On A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final Handler A06;
    public final Handler A07;
    public final View.OnTouchListener A08;
    public final C2026Wb A09;
    public final AnonymousClass99<C9A, AnonymousClass98> A0A;
    public final List<InterfaceC1835Oq> A0B;
    public final PZ A0C;

    public static void A0H() {
        A0D = new String[]{"bTF0mPynjITMPKd7AWnGFE0wjuUHqGk", "NLuteA0O4hImypGMVaagZ7KROvpQko", "vHIsSgA1dNPe0TxNLDw8T5r", "Tu3OEd7", "fTm", "FLX2LFKD3Z9kyRG7iyj3Ajj18EKg1", "ES7oyLysdjBWPeOJZDQ9P8Sn", "e8"};
    }

    static {
        A0H();
        A0G = new JA();
        A0E = new C1713Ju();
        A0H = new IE();
        A0I = new ID();
        A0F = new C1703Jk();
        A0J = new I0();
        A0L = new C1655Hk();
        A0K = new C1660Hp();
    }

    public LU(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A0B = new ArrayList();
        this.A06 = new Handler();
        this.A07 = new Handler();
        this.A0A = new AnonymousClass99<>();
        this.A05 = true;
        this.A00 = 200;
        this.A08 = new ViewOnTouchListenerC1826Oh(this);
        this.A09 = c2026Wb;
        if (A0P(c2026Wb)) {
            this.A0C = new G2(c2026Wb);
        } else {
            this.A0C = new G1(c2026Wb);
        }
        A0F();
    }

    public LU(C2026Wb c2026Wb, AttributeSet attributeSet) {
        super(c2026Wb, attributeSet);
        this.A0B = new ArrayList();
        this.A06 = new Handler();
        this.A07 = new Handler();
        this.A0A = new AnonymousClass99<>();
        this.A05 = true;
        this.A00 = 200;
        this.A08 = new ViewOnTouchListenerC1826Oh(this);
        this.A09 = c2026Wb;
        if (A0P(c2026Wb)) {
            this.A0C = new G2(c2026Wb, attributeSet);
        } else {
            this.A0C = new G1(c2026Wb, attributeSet);
        }
        A0F();
    }

    public LU(C2026Wb c2026Wb, AttributeSet attributeSet, int i) {
        super(c2026Wb, attributeSet, i);
        this.A0B = new ArrayList();
        this.A06 = new Handler();
        this.A07 = new Handler();
        this.A0A = new AnonymousClass99<>();
        this.A05 = true;
        this.A00 = 200;
        this.A08 = new ViewOnTouchListenerC1826Oh(this);
        this.A09 = c2026Wb;
        if (A0P(c2026Wb)) {
            this.A0C = new G2(c2026Wb, attributeSet, i);
        } else {
            this.A0C = new G1(c2026Wb, attributeSet, i);
        }
        A0F();
    }

    public static /* synthetic */ C1703Jk A0B() {
        C1703Jk c1703Jk = A0F;
        if (A0D[1].length() != 30) {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[2] = "s0JISK";
        strArr[2] = "s0JISK";
        return c1703Jk;
    }

    public static /* synthetic */ JA A0C() {
        JA ja = A0G;
        if (A0D[0].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[6] = "XnBln0F0zo0j2g49JSScdoR2";
        strArr[6] = "XnBln0F0zo0j2g49JSScdoR2";
        return ja;
    }

    private void A0F() {
        this.A09.A0A().A2u();
        this.A0C.setRequestedVolume(1.0f);
        this.A0C.setVideoStateChangeListener(this);
        this.A02 = new C1832On(this.A09, this.A0C);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
        setOnTouchListener(this.A08);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G() {
        this.A06.postDelayed(new MH(this), this.A00);
    }

    private final void A0I() {
        for (InterfaceC1835Oq plugin : this.A0B) {
            if (plugin instanceof AbstractC1716Jx) {
                A0N((AbstractC1716Jx) plugin);
            }
            plugin.A86(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0J(JB jb) {
        JC jc = this.A01;
        if (jc == null) {
            return;
        }
        jc.A03(jb, null);
    }

    private void A0M(InterfaceC1835Oq interfaceC1835Oq) {
        if (interfaceC1835Oq instanceof AbstractC1716Jx) {
            A0O((AbstractC1716Jx) interfaceC1835Oq);
        }
        interfaceC1835Oq.ADt(this);
    }

    private void A0N(AbstractC1716Jx abstractC1716Jx) {
        if (abstractC1716Jx.getParent() == null) {
            if (abstractC1716Jx instanceof C7Q) {
                this.A02.A01(abstractC1716Jx);
            } else {
                addView(abstractC1716Jx);
            }
        }
    }

    private void A0O(AbstractC1716Jx abstractC1716Jx) {
        if (abstractC1716Jx instanceof C7Q) {
            this.A02.A02(abstractC1716Jx);
        } else {
            LX.A0M(abstractC1716Jx);
        }
    }

    private boolean A0P(C2026Wb c2026Wb) {
        if (G2.A0A()) {
            boolean zA1g = C1693Iy.A1g(c2026Wb);
            if (A0D[2].length() == 19) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[0] = "Y2Yi8VJKipCio7lj7Ydrs3ww6YI9yuS";
            strArr[0] = "Y2Yi8VJKipCio7lj7Ydrs3ww6YI9yuS";
            if (zA1g) {
                return true;
            }
        }
        return false;
    }

    public final void A0S() {
        this.A0C.setVideoStateChangeListener(null);
        this.A0C.destroy();
    }

    public final void A0T() {
        if (A0f()) {
            return;
        }
        this.A0C.A7L();
    }

    public final void A0U() {
        Iterator<InterfaceC1835Oq> it = this.A0B.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0D[0].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[0] = "GYUlZXdJo7nruMh2UHaMalRUd7rYm0D";
            strArr[0] = "GYUlZXdJo7nruMh2UHaMalRUd7rYm0D";
            if (zHasNext) {
                InterfaceC1835Oq plugin = it.next();
                A0M(plugin);
            } else {
                this.A0B.clear();
                String[] strArr2 = A0D;
                if (strArr2[4].length() != strArr2[3].length()) {
                    String[] strArr3 = A0D;
                    strArr3[4] = "dBG";
                    strArr3[3] = "pEPub8w";
                    return;
                }
                return;
            }
        }
    }

    public final void A0V(int i) {
        this.A06.removeCallbacksAndMessages(null);
        this.A0C.seekTo(i);
    }

    public final void A0W(int i) {
        this.A0C.ADh(i);
    }

    public final void A0X(EnumC1830Ol enumC1830Ol) {
        this.A07.post(new LV(this));
        this.A0C.ADX(enumC1830Ol.A02());
    }

    public final void A0Y(EnumC1834Op enumC1834Op, int i) {
        if (this.A03 && this.A0C.getState() == EnumC1846Pb.A06) {
            this.A03 = false;
        }
        this.A0C.ADb(enumC1834Op, i);
    }

    public final void A0Z(InterfaceC1835Oq interfaceC1835Oq) {
        this.A0B.add(interfaceC1835Oq);
    }

    public final void A0a(InterfaceC1835Oq interfaceC1835Oq) {
        this.A0B.remove(interfaceC1835Oq);
        A0M(interfaceC1835Oq);
    }

    public final void A0b(boolean z, int i) {
        if (A0f()) {
            return;
        }
        this.A0C.ABq(z, i);
    }

    public final void A0c(boolean z, boolean z2, int i) {
        this.A05 = z2;
        A0b(z, i);
    }

    public final boolean A0d() {
        return this.A0C.A7S();
    }

    public final boolean A0e() {
        return getVolume() == WheelView.DividerConfig.FILL;
    }

    public final boolean A0f() {
        return getState() == EnumC1846Pb.A05;
    }

    public final boolean A0g() {
        return A0f() && this.A0C.A7v();
    }

    public final boolean A0h() {
        return getState() == EnumC1846Pb.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1828Oj
    public final boolean A7p() {
        return A0P(this.A09);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1828Oj
    public final boolean A7r() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1847Pc
    public final void AAQ() {
        A0b(true, 4);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1847Pc
    public final void AAR() {
        A0Y(EnumC1834Op.A05, 6);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1847Pc
    public final void ABC(int i, int i2) {
        this.A07.post(new MF(this, i, i2));
        A0G();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1847Pc
    public final void ABg(EnumC1846Pb enumC1846Pb) {
        int currentPositionInMillis = getCurrentPositionInMillis();
        this.A07.post(new MG(this, enumC1846Pb, getDuration(), currentPositionInMillis));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1828Oj
    public int getCurrentPositionInMillis() {
        return this.A0C.getCurrentPosition();
    }

    public int getDuration() {
        return this.A0C.getDuration();
    }

    @NonNull
    public AnonymousClass99<C9A, AnonymousClass98> getEventBus() {
        return this.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1828Oj
    public long getInitialBufferTime() {
        return this.A0C.getInitialBufferTime();
    }

    public EnumC1846Pb getState() {
        return this.A0C.getState();
    }

    public Handler getStateHandler() {
        return this.A07;
    }

    public TextureView getTextureView() {
        return (TextureView) this.A0C;
    }

    public int getVideoHeight() {
        return this.A0C.getVideoHeight();
    }

    public int getVideoProgressReportIntervalMs() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1828Oj
    public EnumC1834Op getVideoStartReason() {
        return this.A0C.getStartReason();
    }

    public View getVideoView() {
        return this.A02;
    }

    public int getVideoWidth() {
        return this.A0C.getVideoWidth();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1828Oj
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1828Oj
    public float getVolume() {
        return this.A0C.getVolume();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.A0A.A03(A0K);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.A0A.A03(A0L);
        super.onDetachedFromWindow();
    }

    public void setControlsAnchorView(View view) {
        PZ pz = this.A0C;
        if (pz != null) {
            pz.setControlsAnchorView(view);
        }
    }

    public void setFunnelLoggingHandler(JC jc) {
        this.A01 = jc;
    }

    public void setIsFullScreen(boolean z) {
        this.A04 = z;
        this.A0C.setFullScreen(z);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(@Nullable String str) {
        this.A0C.setVideoMPD(str);
    }

    public void setVideoProgressReportIntervalMs(int i) {
        this.A00 = i;
    }

    public void setVideoURI(@Nullable Uri uri) {
        if (uri == null) {
            A0U();
        } else {
            A0I();
            this.A0C.setup(uri);
        }
        this.A03 = false;
    }

    public void setVideoURI(@Nullable String str) {
        this.A09.A0A().A31(str);
        setVideoURI(str != null ? Uri.parse(str) : null);
    }

    public void setVolume(float f2) {
        if (f2 == 1.0f) {
            A0J(JB.A0b);
            this.A09.A0A().A35();
        } else {
            A0J(JB.A0a);
            this.A09.A0A().A34();
        }
        this.A0C.setRequestedVolume(f2);
        AnonymousClass99<C9A, AnonymousClass98> eventBus = getEventBus();
        if (A0D[2].length() == 19) {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[2] = "etD2zaPMct9y2wbR2YehsJmmTem";
        strArr[2] = "etD2zaPMct9y2wbR2YehsJmmTem";
        eventBus.A03(A0J);
    }
}

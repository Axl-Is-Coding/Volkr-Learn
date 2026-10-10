package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1878Qh extends AbstractC1803Nk {
    public RelativeLayout A00;
    public MK A01;
    public InterfaceC1817Ny A02;
    public C1838Ot A03;
    public OQ A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final Paint A08;
    public final Path A09;
    public final RectF A0A;
    public final C2026Wb A0B;
    public final AbstractC1714Jv A0C;
    public final AbstractC1708Jp A0D;
    public final AbstractC1696Jb A0E;
    public final J8 A0F;
    public final AbstractC1661Hq A0G;
    public final String A0H;
    public static final int A0J = (int) (LX.A01 * 1.0f);
    public static final int A0K = (int) (LX.A01 * 4.0f);
    public static final int A0I = (int) (LX.A01 * 6.0f);

    public abstract void A0g(C2026Wb c2026Wb);

    public AbstractC1878Qh(C1807No c1807No, boolean z, String str, C1838Ot c1838Ot) {
        super(c1807No, z);
        this.A09 = new Path();
        this.A0A = new RectF();
        this.A0G = new AbstractC1661Hq() { // from class: com.facebook.ads.redexgen.X.97
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(I0 i0) {
                this.A00.A03.A0Z().setVolume(this.A00.getVideoView().getVolume());
            }
        };
        this.A0C = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.8n
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                this.A00.A03.A0X().ABX(((Integer) this.A00.getTag(-1593835536)).intValue());
            }
        };
        this.A0E = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.8m
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                this.A00.A03.A0Y().ABe(this.A00);
            }
        };
        this.A0D = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.8l
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C14257j c14257j) {
                this.A00.A03.A0Y().ABd(this.A00);
            }
        };
        this.A0F = new J8() { // from class: com.facebook.ads.redexgen.X.8k
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(JA ja) {
                this.A00.A07 = true;
                this.A00.A01();
            }
        };
        this.A03 = c1838Ot;
        this.A0H = str;
        this.A0B = c1807No.A05();
        setGravity(17);
        int i = A0J;
        setPadding(i, 0, i, i);
        LX.A0P(this, 0);
        setUpView(this.A0B);
        this.A08 = new Paint();
        this.A08.setColor(-16777216);
        this.A08.setStyle(Paint.Style.FILL);
        this.A08.setAlpha(16);
        this.A08.setAntiAlias(true);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (this.A02 == null) {
            return;
        }
        if ((A0j() && this.A07) || (!A0j() && this.A06)) {
            this.A02.A9A();
        }
    }

    private void A02(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        LX.A0N(view);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public boolean A0M() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final boolean A0b() {
        return false;
    }

    public final void A0d() {
        if (A0j()) {
            this.A04.A01();
        }
    }

    public final void A0e() {
        if (A0j()) {
            A0f();
            this.A04.A05(EnumC1834Op.A03);
        }
    }

    public final void A0f() {
        float volume = this.A03.A0Z().getVolume();
        if (A0j() && volume != this.A04.getVolume()) {
            this.A04.setVolume(volume);
        }
    }

    public final void A0h(Map<String, String> map) {
        this.A04.A02();
        if (A0j()) {
            this.A04.A04(getAdEventManager(), this.A0H, map);
        }
    }

    public final boolean A0i() {
        return A0j() && this.A04.A06();
    }

    public final boolean A0j() {
        return this.A05;
    }

    public final RelativeLayout getMediaContainer() {
        return this.A00;
    }

    public final OQ getVideoView() {
        return this.A04;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.A09.reset();
        this.A0A.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, getWidth(), getHeight());
        Path path = this.A09;
        RectF rectF = this.A0A;
        int i = A0I;
        path.addRoundRect(rectF, i, i, Path.Direction.CW);
        canvas.drawPath(this.A09, this.A08);
        this.A0A.set(A0J, WheelView.DividerConfig.FILL, getWidth() - A0J, getHeight() - A0J);
        Path path2 = this.A09;
        RectF rectF2 = this.A0A;
        int i2 = A0K;
        path2.addRoundRect(rectF2, i2, i2, Path.Direction.CW);
        canvas.clipPath(this.A09);
        super.onDraw(canvas);
    }

    public void setAdTitleAndDescription(String str, String str2) {
        getTitleDescContainer().A02(str, str2, null, true, false);
    }

    public void setCTAInfo(C1H c1h, Map<String, String> map) {
        getCtaButton().setCta(c1h, this.A0H, map);
    }

    public void setImageUrl(String str) {
        this.A01.setVisibility(0);
        this.A04.setVisibility(8);
        new AsyncTaskC2037Wm(this.A01, this.A0B).A05().A07(new C1879Qi(this)).A08(str);
    }

    public void setIsVideo(boolean z) {
        this.A05 = z;
    }

    public void setOnAssetsLoadedListener(InterfaceC1817Ny interfaceC1817Ny) {
        this.A02 = interfaceC1817Ny;
    }

    public void setUpImageView(C2026Wb c2026Wb) {
        this.A01 = new MK(c2026Wb);
        A02(this.A01);
    }

    public void setUpMediaContainer(C2026Wb c2026Wb) {
        this.A00 = new RelativeLayout(c2026Wb);
        A02(this.A00);
    }

    public void setUpVideoView(C2026Wb c2026Wb) {
        this.A04 = new OQ(c2026Wb, new JC(this.A0H, getAdEventManager()));
        A02(this.A04);
    }

    private void setUpView(C2026Wb c2026Wb) {
        setUpImageView(c2026Wb);
        setUpVideoView(c2026Wb);
        setUpMediaContainer(c2026Wb);
        this.A00.addView(this.A01);
        this.A00.addView(this.A04);
        A0g(c2026Wb);
    }

    public void setVideoPlaceholderUrl(String str) {
        this.A04.setPlaceholderUrl(str);
    }

    public void setVideoUrl(String str) {
        this.A01.setVisibility(8);
        this.A04.setVisibility(0);
        this.A04.setVideoURI(str);
        this.A04.A03(this.A0G);
        this.A04.A03(this.A0C);
        this.A04.A03(this.A0E);
        this.A04.A03(this.A0D);
        this.A04.A03(this.A0F);
    }
}

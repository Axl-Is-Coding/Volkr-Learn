package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import java.util.Arrays;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1803Nk extends RelativeLayout {
    public static byte[] A08;
    public static final int A09;
    public static final int A0A;
    public C1G A00;
    public boolean A01;
    public boolean A02;
    public final C2026Wb A03;
    public final J5 A04;
    public final ViewOnClickListenerC2033Wi A05;
    public final C1800Nh A06;
    public final C1807No A07;

    public static String A0I(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0J() {
        A08 = new byte[]{81, 93, 95, 28, 84, 83, 81, 87, 80, 93, 93, 89, 28, 83, 86, 65, 28, 91, 92, 70, 87, 64, 65, 70, 91, 70, 91, 83, 94, 28, 81, 94, 91, 81, 89, 87, 86};
    }

    public abstract boolean A0b();

    static {
        A0J();
        A09 = (int) (LX.A01 * 16.0f);
        A0A = (int) (LX.A01 * 28.0f);
    }

    public AbstractC1803Nk(C1807No c1807No, boolean z) {
        C1G c1gA00;
        super(c1807No.A05());
        this.A01 = false;
        this.A07 = c1807No;
        this.A03 = c1807No.A05();
        this.A04 = c1807No.A06();
        if (c1807No.A00() == 1) {
            c1gA00 = c1807No.A04().A0L().A01();
        } else {
            c1gA00 = c1807No.A04().A0L().A00();
        }
        this.A00 = c1gA00;
        this.A02 = z;
        this.A05 = new ViewOnClickListenerC2033Wi(c1807No.A05(), A0I(0, 37, 59), this.A00, c1807No.A06(), c1807No.A09(), c1807No.A0B(), c1807No.A07());
        this.A05.setRoundedCornersEnabled(A0N());
        this.A05.setViewShowsOverMedia(A0M());
        LX.A0J(1001, this.A05);
        this.A06 = new C1800Nh(this.A03, this.A00, this.A02, A0O(), A0P());
        LX.A0N(this.A06);
        if (C1693Iy.A1N(this.A03)) {
            this.A06.setDescriptionVisibility(8);
        }
    }

    public void A0K(C7l c7l) {
        this.A01 = true;
    }

    public void A0L(C14247i c14247i) {
    }

    public boolean A0M() {
        return true;
    }

    public boolean A0N() {
        return true;
    }

    public boolean A0O() {
        return true;
    }

    public boolean A0P() {
        return true;
    }

    public void A0V() {
    }

    public void A0W() {
    }

    public void A0X() {
    }

    public void A0Y() {
    }

    public void A0Z() {
    }

    public void A0a(AnonymousClass18 anonymousClass18, String str, double d2, @Nullable Bundle bundle) {
        this.A06.A02(anonymousClass18.A0F().A05(), anonymousClass18.A0F().A01(), null, false, !A0b() && d2 > 0.0d && d2 < 1.0d);
        this.A05.setCta(anonymousClass18.A0G(), str, new HashMap());
    }

    public boolean A0c(boolean z) {
        return false;
    }

    public C2026Wb getAdContextWrapper() {
        return this.A03;
    }

    public J5 getAdEventManager() {
        return this.A04;
    }

    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        return 0;
    }

    public C1G getColors() {
        return this.A00;
    }

    public ViewOnClickListenerC2033Wi getCtaButton() {
        return this.A05;
    }

    public C1800Nh getTitleDescContainer() {
        return this.A06;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        C1G c1gA00;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            c1gA00 = this.A07.A04().A0L().A01();
        } else {
            c1gA00 = this.A07.A04().A0L().A00();
        }
        this.A00 = c1gA00;
        this.A05.setViewShowsOverMedia(A0M());
        this.A05.setUpButtonColors(this.A00);
        this.A06.A01(this.A00, this.A02);
    }
}

package com.facebook.ads.redexgen.X;

import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Handler;
import android.view.View;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(12)
public final class HK implements InterfaceC1835Oq {
    public static String[] A0B;
    public View A00;

    @Nullable
    public LU A01;

    @Nullable
    public P1 A02;
    public boolean A03;
    public final Handler A04;
    public final AbstractC1714Jv A05;
    public final AbstractC1708Jp A06;
    public final AbstractC1696Jb A07;
    public final I2 A08;
    public final boolean A09;
    public final boolean A0A;

    static {
        A06();
    }

    public static void A06() {
        A0B = new String[]{"82Zz8oCZg8zkkbzw8opl2Yz4CtrF2SDp", "9Qv", "sj5N5SmrmBRQmWue5o8rJw6ys3alFtJa", "lBA7odrZYL425", "CSSBUKaIJSWMhqfJuWGnuyX4cipoTk5I", "IDQP5gLMbSSnC18VVbdsGZXvkzghwpNg", "Yf1MSxzKxHs57zUlY7hI2xykX4pHUq1P", "T3bn0lMwtbok5v0PvXD6574OGDOrX6LS"};
    }

    public HK(View view, P1 p1, boolean z) {
        this(view, p1, z, false);
    }

    public HK(View view, @Nullable P1 p1, boolean z, boolean z2) {
        this.A06 = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.7X
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C14257j c14257j) {
                this.A00.A07(1, 0);
            }
        };
        this.A07 = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.7U
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                if (!this.A00.A03) {
                    return;
                }
                if (this.A00.A02 == P1.A03 || this.A00.A09) {
                    this.A00.A02 = null;
                    this.A00.A05();
                } else {
                    this.A00.A07(0, 8);
                }
            }
        };
        this.A05 = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.7T
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                if (this.A00.A02 == P1.A04) {
                    return;
                }
                this.A00.A00.setAlpha(1.0f);
                this.A00.A00.setVisibility(0);
            }
        };
        this.A08 = new C7S(this);
        this.A03 = true;
        this.A04 = new Handler();
        this.A09 = z;
        this.A0A = z2;
        A09(view, p1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        this.A00.animate().alpha(WheelView.DividerConfig.FILL).setDuration(500L).setListener(new P0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i, int i2) {
        this.A04.removeCallbacksAndMessages(null);
        this.A00.clearAnimation();
        this.A00.setAlpha(i);
        this.A00.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(AnimatorListenerAdapter animatorListenerAdapter) {
        this.A00.setVisibility(0);
        this.A00.animate().alpha(1.0f).setDuration(500L).setListener(animatorListenerAdapter);
    }

    private final void A09(View view, P1 p1) {
        this.A02 = p1;
        this.A00 = view;
        this.A00.clearAnimation();
        if (p1 == P1.A04) {
            this.A00.setAlpha(WheelView.DividerConfig.FILL);
            String[] strArr = A0B;
            if (strArr[5].charAt(26) == strArr[0].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[5] = "3OWa54Sl5zOXBo6RskK22JrE4LW5JWKj";
            strArr2[0] = "lt7hksMEFpJVhV2333OBcIopOVPW9bfy";
            this.A00.setVisibility(8);
            return;
        }
        this.A00.setAlpha(1.0f);
        this.A00.setVisibility(0);
    }

    public final void A0G() {
        this.A03 = false;
        A08(null);
    }

    public final boolean A0H() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void A86(LU lu) {
        this.A01 = lu;
        lu.getEventBus().A04(this.A06, this.A07, this.A08, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void ADt(LU lu) {
        A07(1, 0);
        lu.getEventBus().A05(this.A05, this.A08, this.A07, this.A06);
        this.A01 = null;
    }
}

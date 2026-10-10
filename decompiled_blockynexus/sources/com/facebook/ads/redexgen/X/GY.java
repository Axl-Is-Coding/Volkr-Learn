package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GY implements PB {
    public static String[] A05;

    @Nullable
    public ViewPropertyAnimator A00;
    public PA A01 = PA.A05;
    public final int A02;
    public final View A03;
    public final boolean A04;

    static {
        A04();
    }

    public static void A04() {
        A05 = new String[]{"hBpWhHnhmL5X5T638nUqTTajkmWXq0Jo", "NpDFSQumXtRd9HWL09JYgYkJkV27cWXf", "AxBlHN1IgfTmgBmsQuewVQ8cZkGbRxm7", "auJ8KOWij5XUc2OVh7MwLzJgAA213fGo", "l76sAXRLIUx67IYksgmFi2YoLkAbbgnJ", "1g5g87wiu8KgxwL4MK6lukjj0pQl5xRt", "P6OmLQzTnVk1JPGEjhdY9fnbkCpMcnWe", "QfRSCgXdOTNJYzcBVbNAL0t7GjPIPusf"};
    }

    public GY(View view, int i, boolean z) {
        this.A02 = i;
        this.A03 = view;
        this.A04 = z;
    }

    private void A05(boolean z) {
        this.A01 = PA.A04;
        if (this.A04) {
            LX.A0O(this.A03);
        }
        String[] strArr = A05;
        if (strArr[4].charAt(27) != strArr[2].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[0] = "iTCONHrR5nymrEIlx0VHUpGctJrwflIU";
        strArr2[0] = "iTCONHrR5nymrEIlx0VHUpGctJrwflIU";
        if (!z) {
            this.A03.setAlpha(1.0f);
            this.A01 = PA.A03;
        } else {
            this.A00 = this.A03.animate().alpha(1.0f).setDuration(this.A02).setListener(new PF(this));
        }
    }

    private void A06(boolean z) {
        this.A01 = PA.A06;
        if (z) {
            this.A00 = this.A03.animate().alpha(WheelView.DividerConfig.FILL).setDuration(this.A02).setListener(new PG(this));
            return;
        }
        View view = this.A03;
        if (A05[3].charAt(11) != 'U') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[1] = "Va1KnH22vapH99C3A8HUoUYkLtllReKa";
        strArr[1] = "Va1KnH22vapH99C3A8HUoUYkLtllReKa";
        view.setAlpha(WheelView.DividerConfig.FILL);
        this.A01 = PA.A05;
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final void A3O(boolean z, boolean z2) {
        if (z2) {
            A06(z);
        } else {
            A05(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final PA A78() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final void cancel() {
        this.A03.clearAnimation();
        ViewPropertyAnimator viewPropertyAnimator = this.A00;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }
}

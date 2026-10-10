package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LL implements View.OnSystemUiVisibilityChangeListener {
    public int A00;

    @Nullable
    public Window A01;
    public final View A03;
    public LK A02 = LK.A03;
    public final Runnable A04 = new Zz(this);

    public LL(View view) {
        this.A03 = view;
        this.A03.setOnSystemUiVisibilityChangeListener(this);
    }

    private void A00(int i, boolean z) {
        Window window = this.A01;
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= i;
        } else {
            attributes.flags &= i ^ (-1);
        }
        this.A01.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(boolean z) {
        if (LK.A03.equals(this.A02)) {
            return;
        }
        int i = 3840;
        if (!z) {
            i = 3840 | 7;
        }
        Handler handler = this.A03.getHandler();
        if (handler != null && z) {
            handler.removeCallbacks(this.A04);
            handler.postDelayed(this.A04, 2000L);
        }
        this.A03.setSystemUiVisibility(i);
    }

    public final void A03() {
        this.A01 = null;
    }

    public final void A04(Window window) {
        this.A01 = window;
    }

    public final void A05(LK lk) {
        this.A02 = lk;
        if (LJ.A00[this.A02.ordinal()] != 1) {
            A00(67108864, false);
            A00(134217728, false);
            this.A03.setSystemUiVisibility(0);
        } else {
            A00(67108864, true);
            A00(134217728, true);
            A02(false);
        }
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        int i2 = this.A00 ^ i;
        this.A00 = i;
        if ((i2 & 2) != 0 && (i & 2) == 0) {
            A02(true);
        }
    }
}

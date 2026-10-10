package com.facebook.ads.redexgen.X;

import android.view.View;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class P3 implements View.OnClickListener {
    public final /* synthetic */ HI A00;

    public P3(HI hi) {
        this.A00 = hi;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A03.A03(JB.A0Z, null);
            this.A00.A02.A0A().A33();
            if (this.A00.A00 != null) {
                if (this.A00.A08()) {
                    this.A00.A00.setVolume(1.0f);
                } else {
                    this.A00.A00.setVolume(WheelView.DividerConfig.FILL);
                }
                this.A00.A0A();
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

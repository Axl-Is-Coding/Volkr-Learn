package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ViewOnClickListenerC2033Wi extends NZ implements View.OnClickListener {

    @Nullable
    public String A00;

    @Nullable
    public String A01;
    public final NX A02;
    public final Map<String, String> A03;

    public ViewOnClickListenerC2033Wi(C2026Wb c2026Wb, String str, C1G c1g, J5 j5, InterfaceC1767Lz interfaceC1767Lz, C1849Pe c1849Pe, LQ lq) {
        super(c2026Wb, c1g);
        this.A03 = new HashMap();
        this.A02 = new NX(c2026Wb, str, c1849Pe, lq, j5, interfaceC1767Lz);
        setOnClickListener(this);
        LX.A0J(1001, this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.A00) && !TextUtils.isEmpty(this.A01)) {
                this.A02.A08(this.A00, this.A01, this.A03);
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    public void setCta(C1H c1h, String str, Map<String, String> map) {
        setCta(c1h, str, map, null);
    }

    public void setCta(C1H c1h, String str, Map<String, String> map, @Nullable NW nw) {
        this.A00 = str;
        this.A01 = c1h.A04();
        Map<String, String> extraData = this.A03;
        extraData.putAll(map);
        this.A02.A07(nw);
        String strA03 = c1h.A03();
        if (TextUtils.isEmpty(strA03) || TextUtils.isEmpty(this.A01)) {
            setVisibility(8);
        } else {
            setText(strA03);
        }
    }

    public void setIsInAppBrowser(boolean z) {
        this.A02.A09(z);
    }
}

package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1784Mr extends LinearLayout {
    public static final int A03 = (int) (LX.A01 * 40.0f);
    public static final int A04 = (int) (LX.A01 * 20.0f);
    public static final int A05 = (int) (LX.A01 * 10.0f);
    public final AnonymousClass25 A00;
    public final C2026Wb A01;
    public final InterfaceC1769Mb A02;

    public C1784Mr(C2026Wb c2026Wb, AnonymousClass25 anonymousClass25, InterfaceC1769Mb interfaceC1769Mb, EnumC1747Lf enumC1747Lf) {
        this(c2026Wb, anonymousClass25, interfaceC1769Mb, null, enumC1747Lf);
    }

    public C1784Mr(C2026Wb c2026Wb, AnonymousClass25 anonymousClass25, InterfaceC1769Mb interfaceC1769Mb, @Nullable String str, EnumC1747Lf enumC1747Lf) {
        super(c2026Wb);
        this.A01 = c2026Wb;
        this.A00 = anonymousClass25;
        this.A02 = interfaceC1769Mb;
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            View viewA01 = A01(str);
            viewA01.setPadding(0, 0, 0, 0);
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            LX.A0P(view, -10459280);
            addView(viewA01, layoutParams);
            addView(view);
        }
        if (!TextUtils.isEmpty(this.A00.A03())) {
            View viewA00 = A00(enumC1747Lf, this.A00.A03());
            int i = A05;
            viewA00.setPadding(0, i, 0, i);
            addView(viewA00, layoutParams);
        }
        ViewGroup viewGroupA02 = A02();
        viewGroupA02.setPadding(0, A05, 0, 0);
        addView(viewGroupA02, layoutParams);
    }

    private View A00(EnumC1747Lf enumC1747Lf, String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        int i = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 16;
        imageView.setImageBitmap(C1748Lg.A01(enumC1747Lf));
        TextView textView = new TextView(getContext());
        LX.A0b(textView, true, 14);
        textView.setTextColor(-10459280);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        textView.setText(str);
        textView.setPadding(A05, 0, 0, 0);
        textView.setFocusable(true);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private View A01(String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        imageView.setImageBitmap(C1748Lg.A01(EnumC1747Lf.BACK_ARROW));
        int i = A05;
        imageView.setPadding(0, i, i * 2, i);
        int i2 = A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        imageView.setOnClickListener(new ViewOnClickListenerC1782Mp(this));
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(str);
        LX.A0b(textView, true, 16);
        textView.setTextColor(-14934495);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, A03, 0);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private ViewGroup A02() {
        C1790Mx c1790Mx = new C1790Mx(this.A01);
        for (AnonymousClass25 anonymousClass25 : this.A00.A05()) {
            C1771Md c1771Md = new C1771Md(this.A01);
            c1771Md.setData(anonymousClass25.A04(), null);
            c1771Md.setOnClickListener(new ViewOnClickListenerC1783Mq(this, c1771Md, anonymousClass25));
            c1790Mx.addView(c1771Md);
        }
        return c1790Mx;
    }
}

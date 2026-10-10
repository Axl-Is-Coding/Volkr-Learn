package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import com.just.agentweb.WebIndicator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BannerExpressBackupView extends BackupView {
    private static i[] h = {new i(1, 6.6666665f, WebIndicator.DO_END_ANIMATION_DURATION, 90), new i(1, 6.4f, 640, 100), new i(1, 4.0f, WebIndicator.DO_END_ANIMATION_DURATION, 150), new i(2, 1.2f, WebIndicator.DO_END_ANIMATION_DURATION, 500), new i(3, 1.5f, WebIndicator.DO_END_ANIMATION_DURATION, 400), new i(3, 2.0f, WebIndicator.DO_END_ANIMATION_DURATION, 300), new i(3, 2.3076923f, WebIndicator.DO_END_ANIMATION_DURATION, 260), new i(3, 1.7783505f, 690, 388)};
    private View i;
    private NativeExpressView j;
    private b.a.a.a.a.a.b k;
    private int l;

    public BannerExpressBackupView(Context context) {
        super(context);
        this.l = 1;
        this.f6266a = context;
    }

    private void b() {
        i iVarA = a(this.j.getExpectExpressWidth(), this.j.getExpectExpressHeight());
        if (this.j.getExpectExpressWidth() <= 0 || this.j.getExpectExpressHeight() <= 0) {
            this.f6271f = ac.c(this.f6266a);
            this.g = Float.valueOf(this.f6271f / iVarA.f6313b).intValue();
        } else if (this.j.getExpectExpressWidth() > this.j.getExpectExpressHeight()) {
            this.f6271f = ac.c(this.f6266a, this.j.getExpectExpressHeight() * iVarA.f6313b);
            this.g = ac.c(this.f6266a, this.j.getExpectExpressHeight());
        } else {
            this.f6271f = ac.c(this.f6266a, this.j.getExpectExpressWidth());
            this.g = ac.c(this.f6266a, this.j.getExpectExpressWidth() / iVarA.f6313b);
        }
        int i = this.f6271f;
        if (i > 0 && i > ac.c(this.f6266a)) {
            this.f6271f = ac.c(this.f6266a);
            this.g = Float.valueOf(this.g * (ac.c(this.f6266a) / this.f6271f)).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f6271f, this.g);
        }
        layoutParams.width = this.f6271f;
        layoutParams.height = this.g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        int i2 = iVarA.f6312a;
        if (i2 == 1) {
            e();
            return;
        }
        if (i2 == 2) {
            d();
        } else if (i2 == 3) {
            c();
        } else {
            e();
        }
    }

    private void c() {
        this.i = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_banner_layout3"), (ViewGroup) this, true);
        View viewFindViewById = this.i.findViewById(t.e(this.f6266a, "tt_bu_close"));
        ImageView imageView = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_icon"));
        TextView textView = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView2 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_name"));
        TextView textView4 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_download"));
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        int iA = (int) ac.a(this.f6266a, 15.0f);
        ac.a(viewFindViewById, iA, iA, iA, iA);
        a(imageView);
        d.a(this.f6266a).a(this.f6267b.y().a(), imageView2);
        textView3.setText(getNameOrSource());
        textView.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        textView2.setText(getDescription());
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView4.setText(this.f6267b.I());
        }
        a((View) this, false);
        a((View) textView4, true);
    }

    private void d() {
        this.i = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_banner_layout2"), (ViewGroup) this, true);
        View viewFindViewById = this.i.findViewById(t.e(this.f6266a, "tt_bu_close"));
        ImageView imageView = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_icon"));
        TextView textView = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView2 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_download"));
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        int iA = (int) ac.a(this.f6266a, 15.0f);
        ac.a(viewFindViewById, iA, iA, iA, iA);
        a(imageView);
        d.a(this.f6266a).a(this.f6267b.y().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView3.setText(this.f6267b.I());
        }
        a((View) this, false);
        a((View) textView3, true);
    }

    private void e() {
        this.i = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_banner_layout1"), (ViewGroup) this, true);
        View viewFindViewById = this.i.findViewById(t.e(this.f6266a, "tt_bu_close"));
        ImageView imageView = (ImageView) this.i.findViewById(t.e(this.f6266a, "tt_bu_icon"));
        TextView textView = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_title"));
        TextView textView2 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.i.findViewById(t.e(this.f6266a, "tt_bu_score_bar"));
        TextView textView3 = (TextView) this.i.findViewById(t.e(this.f6266a, "tt_bu_download"));
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        d.a(this.f6266a).a(this.f6267b.y().a(), imageView);
        textView.setText(getTitle());
        if (!TextUtils.isEmpty(this.f6267b.I())) {
            textView3.setText(this.f6267b.I());
        }
        int iD = this.f6267b.K() != null ? this.f6267b.K().d() : 4;
        textView2.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iD)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iD);
        tTRatingBar.setStarImageWidth(ac.c(this.f6266a, 15.0f));
        tTRatingBar.setStarImageHeight(ac.c(this.f6266a, 14.0f));
        tTRatingBar.setStarImagePadding(ac.c(this.f6266a, 4.0f));
        tTRatingBar.a();
        a((View) this, false);
        a((View) textView3, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, f fVar) {
        NativeExpressView nativeExpressView = this.j;
        if (nativeExpressView != null) {
            nativeExpressView.a(i, fVar);
        }
    }

    void a(h hVar, NativeExpressView nativeExpressView, b.a.a.a.a.a.b bVar) {
        setBackgroundColor(-1);
        this.f6267b = hVar;
        this.j = nativeExpressView;
        this.k = bVar;
        this.f6270e = "banner_ad";
        this.j.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void a(ImageView imageView) {
        d.a(this.f6266a).a(this.f6267b.B().get(0).a(), imageView);
    }

    private i a(int i, int i2) {
        try {
            float fFloatValue = Float.valueOf(i).floatValue() / Float.valueOf(i2).floatValue();
            i iVar = h[0];
            i iVar2 = iVar;
            float f2 = Float.MAX_VALUE;
            for (i iVar3 : h) {
                float fAbs = Math.abs(iVar3.f6313b - fFloatValue);
                if (fAbs <= f2) {
                    iVar2 = iVar3;
                    f2 = fAbs;
                }
            }
            return iVar2;
        } catch (Throwable unused) {
            return h[0];
        }
    }
}

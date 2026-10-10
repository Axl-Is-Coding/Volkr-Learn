package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: loaded from: classes.dex */
public class FullRewardExpressBackupView extends BackupView {
    private View h;
    private NativeExpressView i;
    private FrameLayout j;
    private b.a.a.a.a.a.b k;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.f6266a = context;
    }

    private void b() {
        this.f6271f = ac.c(this.f6266a, this.i.getExpectExpressWidth());
        this.g = ac.c(this.f6266a, this.i.getExpectExpressWidth());
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
        this.f6267b.i();
        c();
    }

    private void c() {
        this.h = LayoutInflater.from(this.f6266a).inflate(t.f(this.f6266a, "tt_backup_full_reward"), (ViewGroup) this, true);
        this.j = (FrameLayout) this.h.findViewById(t.e(this.f6266a, "tt_bu_video_container"));
        this.j.removeAllViews();
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar, NativeExpressView nativeExpressView, b.a.a.a.a.a.b bVar) {
        o.b("FullRewardExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f6267b = hVar;
        this.i = nativeExpressView;
        this.k = bVar;
        if (ab.c(this.f6267b.M()) == 7) {
            this.f6270e = "rewarded_video";
        } else {
            this.f6270e = "fullscreen_interstitial_ad";
        }
        b();
        this.i.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    public FrameLayout getVideoContainer() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        NativeExpressView nativeExpressView = this.i;
        if (nativeExpressView != null) {
            nativeExpressView.a(i, fVar);
        }
    }
}

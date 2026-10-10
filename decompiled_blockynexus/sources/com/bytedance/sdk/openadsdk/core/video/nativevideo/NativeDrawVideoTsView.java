package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    private boolean n;

    public NativeDrawVideoTsView(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        super(context, hVar);
        this.n = false;
        setOnClickListener(this);
    }

    private void e() {
        ac.a((View) this.f6497e, 0);
        ac.a((View) this.f6498f, 0);
        ac.a((View) this.h, 8);
    }

    private void j() {
        g();
        RelativeLayout relativeLayout = this.f6497e;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            } else {
                com.bytedance.sdk.openadsdk.g.d.a(getContext()).a(this.f6493a.v().g(), this.f6498f);
            }
        }
        e();
    }

    public void a(Bitmap bitmap, int i) {
        com.bytedance.sdk.openadsdk.core.h.b().a(bitmap);
        this.j = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void c() {
        this.f6496d = false;
        this.i = "draw_ad";
        o.h().s(String.valueOf(ab.d(this.f6493a.M())));
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void d() {
        if (this.n) {
            super.d();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.g;
        if (imageView != null && imageView.getVisibility() == 0) {
            ac.f(this.f6497e);
        }
        d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ImageView imageView = this.g;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        ImageView imageView = this.g;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            j();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.n = z;
    }
}

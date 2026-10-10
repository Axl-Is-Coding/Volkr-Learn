package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: loaded from: classes.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    private boolean n;

    public ExpressVideoView(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        super(context, hVar, false, str);
        this.n = false;
        if ("draw_ad".equals(str)) {
            this.n = true;
        }
        setOnClickListener(this);
    }

    private void j() {
        ac.a((View) this.f6497e, 0);
        ac.a((View) this.f6498f, 0);
        ac.a((View) this.h, 8);
    }

    private void k() {
        g();
        RelativeLayout relativeLayout = this.f6497e;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            } else {
                com.bytedance.sdk.openadsdk.g.d.a(getContext()).a(this.f6493a.v().g(), this.f6498f);
            }
        }
        j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void a(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void c() {
        this.f6496d = false;
        o.h().s(String.valueOf(ab.d(this.f6493a.M())));
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void d() {
        if (this.n) {
            super.d();
        }
    }

    public void e() {
        ImageView imageView = this.h;
        if (imageView != null) {
            ac.a((View) imageView, 8);
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
            k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        ImageView imageView = this.g;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            k();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.n = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f6494b;
        if (cVar != null) {
            cVar.f(z);
        }
    }

    public void setShowAdInteractionView(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVarU;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f6494b;
        if (cVar == null || (hVarU = cVar.u()) == null) {
            return;
        }
        hVarU.d(z);
    }
}

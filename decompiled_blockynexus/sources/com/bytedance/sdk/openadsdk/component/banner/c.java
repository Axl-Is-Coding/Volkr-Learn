package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.d.h;

/* JADX INFO: compiled from: BannerCellView.java */
/* JADX INFO: loaded from: classes.dex */
class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f5831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f5833c;

    public c(Context context) {
        super(context);
        this.f5832b = context;
        c();
    }

    private void c() {
        this.f5831a = new ImageView(this.f5832b);
        this.f5831a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f5831a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f5831a);
    }

    h a() {
        return this.f5833c;
    }

    void b() {
        this.f5831a.setImageBitmap(null);
        setOnClickListener(null);
        this.f5833c = null;
    }

    void a(h hVar) {
        this.f5833c = hVar;
    }

    void a(Bitmap bitmap) {
        this.f5831a.setImageBitmap(bitmap);
    }
}

package com.sandboxol.gamedetail.view.dialog.marioguide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.k;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BannerAdapter extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f18147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f18148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnImageClickListener f18149c;

    public interface OnImageClickListener {
        void onClick();
    }

    public BannerAdapter(Context context, List<String> list, OnImageClickListener onImageClickListener) {
        this.f18147a = context;
        this.f18148b = list;
        this.f18149c = onImageClickListener;
    }

    public /* synthetic */ void a(View view) {
        OnImageClickListener onImageClickListener = this.f18149c;
        if (onImageClickListener != null) {
            onImageClickListener.onClick();
        }
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(this.f18147a);
        k kVarC = com.bumptech.glide.c.c(this.f18147a);
        List<String> list = this.f18148b;
        kVarC.mo55load(list.get(i % list.size())).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.gamedetail.view.dialog.marioguide.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18158a.a(view);
            }
        });
        viewGroup.addView(imageView);
        return imageView;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}

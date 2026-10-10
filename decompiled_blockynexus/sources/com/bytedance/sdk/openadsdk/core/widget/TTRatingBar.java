package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: loaded from: classes.dex */
public class TTRatingBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f6575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f6576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f6577f;
    private Drawable g;
    private Drawable h;
    private Drawable i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6572a = 5;
        this.f6573b = 0;
        this.f6574c = 0;
        setOrientation(0);
        this.g = t.c(context, "tt_star_empty_bg");
        this.h = t.c(context, "tt_star_full_bg");
        this.i = t.c(context, "tt_star_empty_bg");
        this.f6575d = ac.c(context, 15.0f);
        this.f6576e = ac.c(context, 15.0f);
        this.f6577f = ac.c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f6575d), Math.round(this.f6576e)));
        imageView.setPadding(0, 0, Math.round(this.f6577f), 0);
        return imageView;
    }

    public void a() {
        removeAllViews();
        for (int i = 0; i < getStarFillNum(); i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i2 = 0; i2 < getStarHalfNum(); i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i3 = 0; i3 < getStarEmptyNum(); i3++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }

    public Drawable getStarEmptyDrawable() {
        return this.g;
    }

    public int getStarEmptyNum() {
        return this.f6574c;
    }

    public Drawable getStarFillDrawable() {
        return this.h;
    }

    public int getStarFillNum() {
        return this.f6572a;
    }

    public Drawable getStarHalfDrawable() {
        return this.i;
    }

    public int getStarHalfNum() {
        return this.f6573b;
    }

    public float getStarImageHeight() {
        return this.f6576e;
    }

    public float getStarImagePadding() {
        return this.f6577f;
    }

    public float getStarImageWidth() {
        return this.f6575d;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.g = drawable;
    }

    public void setStarEmptyNum(int i) {
        this.f6574c = i;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.h = drawable;
    }

    public void setStarFillNum(int i) {
        this.f6572a = i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.i = drawable;
    }

    public void setStarHalfNum(int i) {
        this.f6573b = i;
    }

    public void setStarImageHeight(float f2) {
        this.f6576e = f2;
    }

    public void setStarImagePadding(float f2) {
        this.f6577f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f6575d = f2;
    }
}

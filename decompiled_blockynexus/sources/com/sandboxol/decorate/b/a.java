package com.sandboxol.decorate.b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressUpDownAnim.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f16973a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f16974b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f16975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16978f;

    public a(View view, int i) {
        this.f16977e = 2;
        this.f16975c = view;
        this.f16977e = i;
        setDuration(250L);
        this.f16976d = view.getContext().getResources().getDimensionPixelOffset(R.dimen.dress_shop_margin);
        this.f16978f = view.getContext().getResources().getDimensionPixelOffset(R.dimen.dress_shop_margin_top);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (this.f16975c.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16975c.getLayoutParams();
            if (this.f16977e == f16973a) {
                layoutParams.setMargins(0, (int) (this.f16978f + (f2 * this.f16976d)), 0, 0);
            } else {
                layoutParams.setMargins(0, (int) (this.f16978f + ((1.0f - f2) * this.f16976d)), 0, 0);
            }
            this.f16975c.setLayoutParams(layoutParams);
            return;
        }
        if (this.f16975c.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f16975c.getLayoutParams();
            if (this.f16977e == f16973a) {
                layoutParams2.setMargins(0, (int) (this.f16978f + (f2 * this.f16976d)), 0, 0);
            } else {
                layoutParams2.setMargins(0, (int) (this.f16978f + ((1.0f - f2) * this.f16976d)), 0, 0);
            }
            this.f16975c.setLayoutParams(layoutParams2);
        }
    }
}

package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f13666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextInputLayout.b f13667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AnimatorSet f13668f;
    private ValueAnimator g;

    g(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f13666d = new C2233a(this);
        this.f13667e = new C2234b(this);
    }

    private void d() {
        ValueAnimator valueAnimatorC = c();
        ValueAnimator valueAnimatorA = a(WheelView.DividerConfig.FILL, 1.0f);
        this.f13668f = new AnimatorSet();
        this.f13668f.playTogether(valueAnimatorC, valueAnimatorA);
        this.f13668f.addListener(new C2235c(this));
        this.g = a(1.0f, WheelView.DividerConfig.FILL);
        this.g.addListener(new C2236d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Editable editable) {
        return editable.length() > 0;
    }

    private ValueAnimator c() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f13084d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new C2238f(this));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.textfield.t
    void a() {
        this.f13683a.setEndIconDrawable(androidx.appcompat.a.a.a.b(this.f13684b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f13683a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.f13683a.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate$3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13652a.f13683a.getEditText().setText((CharSequence) null);
            }
        });
        this.f13683a.addOnEditTextAttachedListener(this.f13667e);
        d();
    }

    private ValueAnimator a(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f13081a);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new C2237e(this));
        return valueAnimatorOfFloat;
    }
}

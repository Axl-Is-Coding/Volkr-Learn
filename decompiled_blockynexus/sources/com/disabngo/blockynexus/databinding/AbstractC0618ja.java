package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.fragment.main.MainFragmentViewModel;
import com.disabngo.blockynexus.view.widget.ScaleFrameLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ja, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentHeader1Binding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0618ja extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScaleFrameLayout f8460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScaleFrameLayout f8461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScaleFrameLayout f8462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScaleFrameLayout f8463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f8464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected MainFragmentViewModel f8465f;

    protected AbstractC0618ja(Object obj, View view, int i, ScaleFrameLayout scaleFrameLayout, ScaleFrameLayout scaleFrameLayout2, ScaleFrameLayout scaleFrameLayout3, ScaleFrameLayout scaleFrameLayout4, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.f8460a = scaleFrameLayout;
        this.f8461b = scaleFrameLayout2;
        this.f8462c = scaleFrameLayout3;
        this.f8463d = scaleFrameLayout4;
        this.f8464e = constraintLayout;
    }

    public abstract void a(MainFragmentViewModel mainFragmentViewModel);
}

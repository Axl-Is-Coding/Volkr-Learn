package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.fragment.main.MainFragmentViewModel;
import com.disabngo.blockynexus.view.widget.ScaleRelativeLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.la, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentHeader2Binding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0640la extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f8538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f8539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f8540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f8541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ScaleRelativeLayout f8542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScaleRelativeLayout f8543f;
    public final ScaleRelativeLayout g;
    public final ScaleRelativeLayout h;
    protected MainFragmentViewModel i;
    protected com.disabngo.blockynexus.view.activity.main.nc j;

    protected AbstractC0640la(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ScaleRelativeLayout scaleRelativeLayout, ScaleRelativeLayout scaleRelativeLayout2, ScaleRelativeLayout scaleRelativeLayout3, ScaleRelativeLayout scaleRelativeLayout4) {
        super(obj, view, i);
        this.f8538a = imageView;
        this.f8539b = imageView2;
        this.f8540c = imageView3;
        this.f8541d = imageView4;
        this.f8542e = scaleRelativeLayout;
        this.f8543f = scaleRelativeLayout2;
        this.g = scaleRelativeLayout3;
        this.h = scaleRelativeLayout4;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.main.nc ncVar);

    public abstract void a(MainFragmentViewModel mainFragmentViewModel);
}

package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.fragment.more.MoreViewModel;
import com.disabngo.blockynexus.view.widget.MeItemView;

/* JADX INFO: compiled from: FragmentMoreBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class He extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xk f7518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f7519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f7520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f7521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f7522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f7523f;
    public final MeItemView g;
    public final RelativeLayout h;
    protected MoreViewModel i;

    protected He(Object obj, View view, int i, xk xkVar, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, MeItemView meItemView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f7518a = xkVar;
        setContainedBinding(this.f7518a);
        this.f7519b = imageView;
        this.f7520c = linearLayout;
        this.f7521d = linearLayout2;
        this.f7522e = linearLayout3;
        this.f7523f = linearLayout4;
        this.g = meItemView;
        this.h = relativeLayout;
    }

    public abstract void a(MoreViewModel moreViewModel);
}

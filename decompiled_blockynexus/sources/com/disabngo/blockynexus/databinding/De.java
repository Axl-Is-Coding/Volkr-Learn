package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.fragment.main.MainFragmentViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* JADX INFO: compiled from: FragmentMainBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class De extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppBarLayout f7380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC0618ja f7381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC0640la f7382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0662na f7383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Toolbar f7384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CollapsingToolbarLayout f7385f;
    protected MainFragmentViewModel g;
    protected com.disabngo.blockynexus.view.activity.main.nc h;

    protected De(Object obj, View view, int i, AppBarLayout appBarLayout, AbstractC0618ja abstractC0618ja, AbstractC0640la abstractC0640la, AbstractC0662na abstractC0662na, Toolbar toolbar, CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.f7380a = appBarLayout;
        this.f7381b = abstractC0618ja;
        setContainedBinding(this.f7381b);
        this.f7382c = abstractC0640la;
        setContainedBinding(this.f7382c);
        this.f7383d = abstractC0662na;
        setContainedBinding(this.f7383d);
        this.f7384e = toolbar;
        this.f7385f = collapsingToolbarLayout;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.main.nc ncVar);

    public abstract void a(MainFragmentViewModel mainFragmentViewModel);
}

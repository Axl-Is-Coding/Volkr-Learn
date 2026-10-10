package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.scrap.ScrapBagViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogScrapBagBinding extends ViewDataBinding {
    public final ImageView ivClose;
    protected ScrapBagViewModel mViewModel;
    public final TabLayout tlTab;
    public final TextView tvTitle;
    public final TextView tvValue;
    public final TextView tvValueRight;
    public final View v;
    public final ViewPager vpContent;

    protected BaseDialogScrapBagBinding(Object obj, View view, int i, ImageView imageView, TabLayout tabLayout, TextView textView, TextView textView2, TextView textView3, View view2, ViewPager viewPager) {
        super(obj, view, i);
        this.ivClose = imageView;
        this.tlTab = tabLayout;
        this.tvTitle = textView;
        this.tvValue = textView2;
        this.tvValueRight = textView3;
        this.v = view2;
        this.vpContent = viewPager;
    }

    public static BaseDialogScrapBagBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogScrapBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public ScrapBagViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(ScrapBagViewModel scrapBagViewModel);

    @Deprecated
    public static BaseDialogScrapBagBinding bind(View view, Object obj) {
        return (BaseDialogScrapBagBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_scrap_bag);
    }

    @Deprecated
    public static BaseDialogScrapBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogScrapBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_scrap_bag, viewGroup, z, obj);
    }

    public static BaseDialogScrapBagBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogScrapBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogScrapBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_scrap_bag, null, false, obj);
    }
}

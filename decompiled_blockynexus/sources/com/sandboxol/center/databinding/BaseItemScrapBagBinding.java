package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.scrap.ScrapBagItemViewModel;
import com.sandboxol.center.view.widget.ScrapLevelImageView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseItemScrapBagBinding extends ViewDataBinding {
    public final ScrapLevelImageView ivScrap;
    protected ScrapBagItemViewModel mViewModel;

    protected BaseItemScrapBagBinding(Object obj, View view, int i, ScrapLevelImageView scrapLevelImageView) {
        super(obj, view, i);
        this.ivScrap = scrapLevelImageView;
    }

    public static BaseItemScrapBagBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseItemScrapBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public ScrapBagItemViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(ScrapBagItemViewModel scrapBagItemViewModel);

    @Deprecated
    public static BaseItemScrapBagBinding bind(View view, Object obj) {
        return (BaseItemScrapBagBinding) ViewDataBinding.bind(obj, view, R.layout.base_item_scrap_bag);
    }

    @Deprecated
    public static BaseItemScrapBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseItemScrapBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_item_scrap_bag, viewGroup, z, obj);
    }

    public static BaseItemScrapBagBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseItemScrapBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseItemScrapBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_item_scrap_bag, null, false, obj);
    }
}

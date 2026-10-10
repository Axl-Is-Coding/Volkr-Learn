package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.scrap.ScrapBagPageViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseContentScrapBagPageBinding extends ViewDataBinding {
    protected ScrapBagPageViewModel mScrapBagPageViewModel;

    protected BaseContentScrapBagPageBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static BaseContentScrapBagPageBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseContentScrapBagPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public ScrapBagPageViewModel getScrapBagPageViewModel() {
        return this.mScrapBagPageViewModel;
    }

    public abstract void setScrapBagPageViewModel(ScrapBagPageViewModel scrapBagPageViewModel);

    @Deprecated
    public static BaseContentScrapBagPageBinding bind(View view, Object obj) {
        return (BaseContentScrapBagPageBinding) ViewDataBinding.bind(obj, view, R.layout.base_content_scrap_bag_page);
    }

    @Deprecated
    public static BaseContentScrapBagPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseContentScrapBagPageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_content_scrap_bag_page, viewGroup, z, obj);
    }

    public static BaseContentScrapBagPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseContentScrapBagPageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseContentScrapBagPageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_content_scrap_bag_page, null, false, obj);
    }
}

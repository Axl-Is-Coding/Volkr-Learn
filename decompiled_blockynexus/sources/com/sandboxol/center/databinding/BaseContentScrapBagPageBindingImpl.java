package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.view.dialog.scrap.ScrapBagListModel;
import com.sandboxol.center.view.dialog.scrap.ScrapBagPageViewModel;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;
import me.tatarka.bindingcollectionadapter2.k;

/* JADX INFO: loaded from: classes3.dex */
public class BaseContentScrapBagPageBindingImpl extends BaseContentScrapBagPageBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final PageRecyclerView mboundView1;
    private final TextView mboundView2;

    public BaseContentScrapBagPageBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, sIncludes, sViewsWithIds));
    }

    private boolean onChangeScrapBagPageViewModel(ScrapBagPageViewModel scrapBagPageViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeScrapBagPageViewModelIsNoData(ObservableField<Boolean> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ScrapBagListModel scrapBagListModel;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ScrapBagPageViewModel scrapBagPageViewModel = this.mScrapBagPageViewModel;
        long j2 = j & 7;
        ScrapBagListModel scrapBagListModel2 = null;
        if (j2 != 0) {
            ObservableField<Boolean> observableField = scrapBagPageViewModel != null ? scrapBagPageViewModel.isNoData : null;
            updateRegistration(1, observableField);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if (j2 != 0) {
                j |= zSafeUnbox ? 16L : 8L;
            }
            int i2 = zSafeUnbox ? 0 : 8;
            if ((j & 5) != 0 && scrapBagPageViewModel != null) {
                scrapBagListModel2 = scrapBagPageViewModel.listModel;
            }
            i = i2;
            scrapBagListModel = scrapBagListModel2;
        } else {
            scrapBagListModel = null;
            i = 0;
        }
        if ((j & 5) != 0) {
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.mboundView1, null, scrapBagListModel, k.a(4), false, false, false, 0, 0, false, null);
        }
        if ((j & 7) != 0) {
            this.mboundView2.setVisibility(i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeScrapBagPageViewModel((ScrapBagPageViewModel) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeScrapBagPageViewModelIsNoData((ObservableField) obj, i2);
    }

    @Override // com.sandboxol.center.databinding.BaseContentScrapBagPageBinding
    public void setScrapBagPageViewModel(ScrapBagPageViewModel scrapBagPageViewModel) {
        updateRegistration(0, scrapBagPageViewModel);
        this.mScrapBagPageViewModel = scrapBagPageViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.ScrapBagPageViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ScrapBagPageViewModel != i) {
            return false;
        }
        setScrapBagPageViewModel((ScrapBagPageViewModel) obj);
        return true;
    }

    private BaseContentScrapBagPageBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (FrameLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (PageRecyclerView) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (TextView) objArr[2];
        this.mboundView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.binding.adapter.ScrapLevelViewBindingAdapter;
import com.sandboxol.center.entity.ScrapInfoInBackpack;
import com.sandboxol.center.view.dialog.scrap.ScrapBagItemViewModel;
import com.sandboxol.center.view.widget.ScrapLevelImageView;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class BaseItemScrapBagBindingImpl extends BaseItemScrapBagBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public BaseItemScrapBagBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModel(ScrapBagItemViewModel scrapBagItemViewModel, int i) {
        if (i == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i != BR.item) {
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
        String str;
        ReplyCommand replyCommand;
        int scrapLevel;
        int scrapType;
        int amount;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ScrapBagItemViewModel scrapBagItemViewModel = this.mViewModel;
        long j2 = 7 & j;
        String scrapPic = null;
        if (j2 != 0) {
            replyCommand = ((j & 5) == 0 || scrapBagItemViewModel == null) ? null : scrapBagItemViewModel.onClickCommand;
            ScrapInfoInBackpack item = scrapBagItemViewModel != null ? scrapBagItemViewModel.getItem() : null;
            if (item != null) {
                scrapPic = item.getScrapPic();
                amount = item.getAmount();
                scrapType = item.getScrapType();
                scrapLevel = item.getScrapLevel();
            } else {
                scrapLevel = 0;
                amount = 0;
                scrapType = 0;
            }
            str = "x" + amount;
        } else {
            str = null;
            replyCommand = null;
            scrapLevel = 0;
            scrapType = 0;
        }
        if (j2 != 0) {
            ScrapLevelViewBindingAdapter.setScrapImageViewNum(this.ivScrap, scrapLevel);
            ScrapLevelViewBindingAdapter.setScrapImageViewType(this.ivScrap, scrapType);
            ScrapLevelViewBindingAdapter.setScrapImageViewUrl(this.ivScrap, scrapPic);
            ScrapLevelViewBindingAdapter.setScrapImageViewNumStatus(this.ivScrap, 1, str);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.ivScrap, replyCommand, false, 0);
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
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((ScrapBagItemViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((ScrapBagItemViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.center.databinding.BaseItemScrapBagBinding
    public void setViewModel(ScrapBagItemViewModel scrapBagItemViewModel) {
        updateRegistration(0, scrapBagItemViewModel);
        this.mViewModel = scrapBagItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private BaseItemScrapBagBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ScrapLevelImageView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.ivScrap.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

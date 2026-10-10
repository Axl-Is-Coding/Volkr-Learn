package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.view.dialog.ScrapRewardDescriptionDialog;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogScrapRewardDescBindingLandImpl extends BaseDialogScrapRewardDescBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public BaseDialogScrapRewardDescBindingLandImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModelIsGameProcess(ObservableField<Boolean> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelRewardDescription(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelRewardName(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelValue(ObservableField<Integer> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0181  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.databinding.BaseDialogScrapRewardDescBindingLandImpl.executeBindings():void");
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
            this.mDirtyFlags = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelIsGameProcess((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelValue((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeViewModelRewardDescription((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeViewModelRewardName((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((ScrapRewardDescriptionDialog) obj);
        return true;
    }

    @Override // com.sandboxol.center.databinding.BaseDialogScrapRewardDescBinding
    public void setViewModel(ScrapRewardDescriptionDialog scrapRewardDescriptionDialog) {
        this.mViewModel = scrapRewardDescriptionDialog;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private BaseDialogScrapRewardDescBindingLandImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (View) objArr[1], (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[6], (View) objArr[7], (View) objArr[3]);
        this.mDirtyFlags = -1L;
        this.bgView.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.tvDesc.setTag(null);
        this.tvRewardName.setTag(null);
        this.tvValue.setTag(null);
        this.tvValueRight.setTag(null);
        this.vBank.setTag(null);
        this.vLine.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

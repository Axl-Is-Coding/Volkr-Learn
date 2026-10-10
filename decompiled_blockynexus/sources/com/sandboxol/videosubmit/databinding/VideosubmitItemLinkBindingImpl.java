package com.sandboxol.videosubmit.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.d;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.view.dialog.signupinfo.LinkItemViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitItemLinkBindingImpl extends VideosubmitItemLinkBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;

    public VideosubmitItemLinkBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModel(LinkItemViewModel linkItemViewModel, int i) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LinkItemViewModel linkItemViewModel = this.mViewModel;
        String item = null;
        long j2 = j & 7;
        if (j2 != 0 && linkItemViewModel != null) {
            item = linkItemViewModel.getItem();
        }
        if (j2 != 0) {
            e.a(this.mboundView1, item);
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
        return onChangeViewModel((LinkItemViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((LinkItemViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitItemLinkBinding
    public void setViewModel(LinkItemViewModel linkItemViewModel) {
        updateRegistration(0, linkItemViewModel);
        this.mViewModel = linkItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private VideosubmitItemLinkBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (TextView) objArr[1];
        this.mboundView1.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

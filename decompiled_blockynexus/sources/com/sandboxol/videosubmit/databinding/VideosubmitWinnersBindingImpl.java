package com.sandboxol.videosubmit.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel;
import com.sandboxol.videosubmit.view.activity.WinnersAdapter;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitWinnersBindingImpl extends VideosubmitWinnersBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.v_content_1st_title, 2);
    }

    public VideosubmitWinnersBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, sIncludes, sViewsWithIds));
    }

    private boolean onChangeVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelWinnerAdapter(ObservableField<WinnersAdapter> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
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
        VideoSubmitViewModel videoSubmitViewModel = this.mVideoSubmitViewModel;
        long j2 = j & 7;
        WinnersAdapter winnersAdapter = null;
        if (j2 != 0) {
            ObservableField<WinnersAdapter> observableField = videoSubmitViewModel != null ? videoSubmitViewModel.winnerAdapter : null;
            updateRegistration(0, observableField);
            if (observableField != null) {
                winnersAdapter = observableField.get();
            }
        }
        if (j2 != 0) {
            this.rvWinners.setAdapter(winnersAdapter);
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
            return onChangeVideoSubmitViewModelWinnerAdapter((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVideoSubmitViewModel((VideoSubmitViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.videoSubmitViewModel != i) {
            return false;
        }
        setVideoSubmitViewModel((VideoSubmitViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitWinnersBinding
    public void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel) {
        updateRegistration(1, videoSubmitViewModel);
        this.mVideoSubmitViewModel = videoSubmitViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.videoSubmitViewModel);
        super.requestRebind();
    }

    private VideosubmitWinnersBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (RecyclerView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.rvWinners.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

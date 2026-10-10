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
import com.sandboxol.videosubmit.view.activity.GamesAdapter;
import com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitGamesBindingImpl extends VideosubmitGamesBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.tv_content_games, 2);
    }

    public VideosubmitGamesBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, sIncludes, sViewsWithIds));
    }

    private boolean onChangeVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelGamesAdapter(ObservableField<GamesAdapter> observableField, int i) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        VideoSubmitViewModel videoSubmitViewModel = this.mVideoSubmitViewModel;
        long j2 = j & 7;
        GamesAdapter gamesAdapter = null;
        if (j2 != 0) {
            ObservableField<GamesAdapter> observableField = videoSubmitViewModel != null ? videoSubmitViewModel.gamesAdapter : null;
            updateRegistration(1, observableField);
            if (observableField != null) {
                gamesAdapter = observableField.get();
            }
        }
        if (j2 != 0) {
            this.rvGames.setAdapter(gamesAdapter);
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
            return onChangeVideoSubmitViewModel((VideoSubmitViewModel) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVideoSubmitViewModelGamesAdapter((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.videoSubmitViewModel != i) {
            return false;
        }
        setVideoSubmitViewModel((VideoSubmitViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitGamesBinding
    public void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel) {
        updateRegistration(0, videoSubmitViewModel);
        this.mVideoSubmitViewModel = videoSubmitViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.videoSubmitViewModel);
        super.requestRebind();
    }

    private VideosubmitGamesBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (RecyclerView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.rvGames.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

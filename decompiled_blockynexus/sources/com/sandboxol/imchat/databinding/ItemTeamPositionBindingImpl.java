package com.sandboxol.imchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.d;
import com.sandboxol.imchat.BR;
import com.sandboxol.imchat.entity.TeamPositionInfo;
import com.sandboxol.imchat.ui.fragment.team.TeamPositionItemViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class ItemTeamPositionBindingImpl extends ItemTeamPositionBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final TextView mboundView2;

    public ItemTeamPositionBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModel(TeamPositionItemViewModel teamPositionItemViewModel, int i) {
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
        String teamNumber;
        boolean zIsShowEmptyPosition;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TeamPositionItemViewModel teamPositionItemViewModel = this.mViewModel;
        long j2 = j & 7;
        int i = 0;
        if (j2 != 0) {
            TeamPositionInfo item = teamPositionItemViewModel != null ? teamPositionItemViewModel.getItem() : null;
            if (item != null) {
                zIsShowEmptyPosition = item.isShowEmptyPosition();
                teamNumber = item.getTeamNumber();
            } else {
                teamNumber = null;
                zIsShowEmptyPosition = false;
            }
            if (j2 != 0) {
                j |= zIsShowEmptyPosition ? 16L : 8L;
            }
            if (!zIsShowEmptyPosition) {
                i = 8;
            }
        } else {
            teamNumber = null;
        }
        if ((j & 7) != 0) {
            this.ivHead.setVisibility(i);
            e.a(this.mboundView2, teamNumber);
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
        return onChangeViewModel((TeamPositionItemViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((TeamPositionItemViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.imchat.databinding.ItemTeamPositionBinding
    public void setViewModel(TeamPositionItemViewModel teamPositionItemViewModel) {
        updateRegistration(0, teamPositionItemViewModel);
        this.mViewModel = teamPositionItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private ItemTeamPositionBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.ivHead.setTag(null);
        this.mboundView0 = (RelativeLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (TextView) objArr[2];
        this.mboundView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

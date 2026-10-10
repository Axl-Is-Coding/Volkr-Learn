package com.sandboxol.imchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.imchat.BR;
import com.sandboxol.imchat.ui.fragment.team.TeamAddItemViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class ItemTeamAddBindingImpl extends ItemTeamAddBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;

    public ItemTeamAddBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTeamAddItemViewModel(TeamAddItemViewModel teamAddItemViewModel, int i) {
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
        TeamAddItemViewModel teamAddItemViewModel = this.mTeamAddItemViewModel;
        ReplyCommand replyCommand = null;
        long j2 = j & 3;
        if (j2 != 0 && teamAddItemViewModel != null) {
            replyCommand = teamAddItemViewModel.onClickAdd;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.mboundView1, replyCommand, false, 0);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeTeamAddItemViewModel((TeamAddItemViewModel) obj, i2);
    }

    @Override // com.sandboxol.imchat.databinding.ItemTeamAddBinding
    public void setTeamAddItemViewModel(TeamAddItemViewModel teamAddItemViewModel) {
        updateRegistration(0, teamAddItemViewModel);
        this.mTeamAddItemViewModel = teamAddItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.TeamAddItemViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.TeamAddItemViewModel != i) {
            return false;
        }
        setTeamAddItemViewModel((TeamAddItemViewModel) obj);
        return true;
    }

    private ItemTeamAddBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (LinearLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (ImageView) objArr[1];
        this.mboundView1.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

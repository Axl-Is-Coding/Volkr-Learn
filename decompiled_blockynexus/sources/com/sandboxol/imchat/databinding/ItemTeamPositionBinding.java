package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.ui.fragment.team.TeamPositionItemViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ItemTeamPositionBinding extends ViewDataBinding {
    public final ImageView ivHead;
    protected TeamPositionItemViewModel mViewModel;

    protected ItemTeamPositionBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.ivHead = imageView;
    }

    public static ItemTeamPositionBinding bind(View view) {
        return bind(view, e.a());
    }

    public static ItemTeamPositionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public TeamPositionItemViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(TeamPositionItemViewModel teamPositionItemViewModel);

    @Deprecated
    public static ItemTeamPositionBinding bind(View view, Object obj) {
        return (ItemTeamPositionBinding) ViewDataBinding.bind(obj, view, R.layout.item_team_position);
    }

    @Deprecated
    public static ItemTeamPositionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTeamPositionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_team_position, viewGroup, z, obj);
    }

    public static ItemTeamPositionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static ItemTeamPositionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTeamPositionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_team_position, null, false, obj);
    }
}

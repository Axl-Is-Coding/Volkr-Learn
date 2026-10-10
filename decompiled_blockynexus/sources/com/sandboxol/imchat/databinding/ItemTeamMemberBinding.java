package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ItemTeamMemberBinding extends ViewDataBinding {
    public final ImageView ivHead;
    public final ImageView ivRemove;
    public final RelativeLayout rlGroup;
    public final TextView tvNickName;
    public final TextView tvPlaying;

    protected ItemTeamMemberBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivHead = imageView;
        this.ivRemove = imageView2;
        this.rlGroup = relativeLayout;
        this.tvNickName = textView;
        this.tvPlaying = textView2;
    }

    public static ItemTeamMemberBinding bind(View view) {
        return bind(view, e.a());
    }

    public static ItemTeamMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static ItemTeamMemberBinding bind(View view, Object obj) {
        return (ItemTeamMemberBinding) ViewDataBinding.bind(obj, view, R.layout.item_team_member);
    }

    @Deprecated
    public static ItemTeamMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTeamMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_team_member, viewGroup, z, obj);
    }

    public static ItemTeamMemberBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static ItemTeamMemberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTeamMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_team_member, null, false, obj);
    }
}

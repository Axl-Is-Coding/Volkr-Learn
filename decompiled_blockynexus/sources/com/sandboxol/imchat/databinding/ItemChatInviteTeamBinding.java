package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.widget.RoundImageView;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ItemChatInviteTeamBinding extends ViewDataBinding {
    public final ImageView ivBg;
    public final ImageView ivBgImg;
    public final ImageView ivChat;
    public final ImageView ivGoto;
    public final RoundImageView ivKickOut;
    public final ImageView ivLeftPoint;
    public final ImageView ivRightPoint;
    public final RelativeLayout rlNotExit;
    public final TextView tvCaptain;
    public final TextView tvGame;
    public final TextView tvTitle;

    protected ItemChatInviteTeamBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RoundImageView roundImageView, ImageView imageView5, ImageView imageView6, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.ivBg = imageView;
        this.ivBgImg = imageView2;
        this.ivChat = imageView3;
        this.ivGoto = imageView4;
        this.ivKickOut = roundImageView;
        this.ivLeftPoint = imageView5;
        this.ivRightPoint = imageView6;
        this.rlNotExit = relativeLayout;
        this.tvCaptain = textView;
        this.tvGame = textView2;
        this.tvTitle = textView3;
    }

    public static ItemChatInviteTeamBinding bind(View view) {
        return bind(view, e.a());
    }

    public static ItemChatInviteTeamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static ItemChatInviteTeamBinding bind(View view, Object obj) {
        return (ItemChatInviteTeamBinding) ViewDataBinding.bind(obj, view, R.layout.item_chat_invite_team);
    }

    @Deprecated
    public static ItemChatInviteTeamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatInviteTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_invite_team, viewGroup, z, obj);
    }

    public static ItemChatInviteTeamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static ItemChatInviteTeamBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatInviteTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_invite_team, null, false, obj);
    }
}

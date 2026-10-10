package com.disabngo.blockynexus.e.b.Q;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.config.ChatSharedConstant;

/* JADX INFO: compiled from: NewFriendViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f9407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f9408c = new i();

    public j(Context context) {
        this.f9406a = context;
        this.f9407b = new h(context, R.string.chat_no_new_friend);
        SharedUtils.putInt(context, ChatSharedConstant.UNREAD_SYSTEM_COUNT, 0);
        Messenger.getDefault().send(Integer.valueOf(SharedUtils.getInt(BaseApplication.getContext(), ChatSharedConstant.UNREAD_SYSTEM_COUNT)), "token.chat.new.friend");
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_RESET_NEW_NUM);
    }
}

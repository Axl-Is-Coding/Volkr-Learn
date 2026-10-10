package com.sandboxol.imchat.module;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.config.ChatMessageToken;
import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes4.dex */
public class GroupCardPlugin implements IPluginModule {
    Conversation.ConversationType conversationType;
    String targetId;

    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return b.c(context, R.mipmap.group_card);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public String obtainTitle(Context context) {
        return context.getString(R.string.group_card);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        this.conversationType = rongExtension.getConversationType();
        this.targetId = rongExtension.getTargetId();
        Messenger.getDefault().send(rongExtension, ChatMessageToken.TOKEN_SEND_GROUP_CARD);
    }
}

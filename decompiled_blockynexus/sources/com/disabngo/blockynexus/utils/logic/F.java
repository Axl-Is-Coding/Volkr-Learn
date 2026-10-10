package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import android.view.View;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.view.activity.webview.WebViewActivity;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.c.P;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.imchat.config.ChatMessageToken;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class F implements RongIM.ConversationClickListener {
    F() {
    }

    @Override // io.rong.imkit.RongIM.ConversationClickListener
    public boolean onMessageClick(Context context, View view, Message message) {
        return false;
    }

    @Override // io.rong.imkit.RongIM.ConversationClickListener
    public boolean onMessageLinkClick(Context context, String str, Message message) {
        List<String> whitelistLink = AppInfoCenter.newInstance().getAppConfig().getWhitelistLink();
        if (whitelistLink == null || whitelistLink.isEmpty()) {
            return false;
        }
        Iterator<String> it = whitelistLink.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                WebViewActivity.a(context, str);
                return true;
            }
        }
        return false;
    }

    @Override // io.rong.imkit.RongIM.ConversationClickListener
    public boolean onMessageLongClick(Context context, View view, Message message) {
        if (message.getConversationType() != Conversation.ConversationType.GROUP || message.getTargetId().equals(String.valueOf(TribeCenter.newInstance().tribeClanId.get()))) {
            N.u();
            return false;
        }
        if (!com.disabngo.blockynexus.d.y.b().b(Long.valueOf(message.getTargetId()).longValue(), Long.valueOf(RongIM.getInstance().getCurrentUserId()).longValue())) {
            N.u();
            return false;
        }
        if (message.getSenderUserId().equals(RongIM.getInstance().getCurrentUserId())) {
            N.u();
            return false;
        }
        N.r();
        return false;
    }

    @Override // io.rong.imkit.RongIM.ConversationClickListener
    public boolean onUserPortraitClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo, String str) {
        if (userInfo == null) {
            return true;
        }
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (userInfo.getUserId() != null && !"".equals(userInfo.getUserId()) && !"0".equals(userInfo.getUserId())) {
            if (conversationType == Conversation.ConversationType.PRIVATE) {
                if (!userInfo.getUserId().equals(String.valueOf(32L)) && !userInfo.getUserId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))) {
                    Long lValueOf = 0L;
                    try {
                        lValueOf = Long.valueOf(Long.parseLong(userInfo.getUserId()));
                    } catch (NumberFormatException e3) {
                        e3.printStackTrace();
                    }
                    P.newInstance().a(lValueOf.longValue(), new E(this, context, lValueOf));
                }
            } else if (conversationType == Conversation.ConversationType.GROUP) {
                if (str.equals(String.valueOf(TribeCenter.newInstance().tribeClanId.get()))) {
                    if (!userInfo.getUserId().equals(String.valueOf(32L)) && !userInfo.getUserId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))) {
                        com.disabngo.blockynexus.e.b.x.J.a(context, (Friend) null, new FriendActivityIntentInfo(Long.parseLong(userInfo.getUserId()), 3));
                    }
                } else if (!userInfo.getUserId().equals(String.valueOf(32L)) && !userInfo.getUserId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))) {
                    com.disabngo.blockynexus.e.b.x.J.a(context, (Friend) null, new FriendActivityIntentInfo(Long.parseLong(userInfo.getUserId()), 2));
                }
            } else if (conversationType == Conversation.ConversationType.CHATROOM) {
                if (!userInfo.getUserId().equals(String.valueOf(32L)) && !userInfo.getUserId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))) {
                    long jValueOf = 0L;
                    try {
                        jValueOf = Long.valueOf(Long.parseLong(userInfo.getUserId()));
                    } catch (NumberFormatException e4) {
                        e4.printStackTrace();
                    }
                    Messenger.getDefault().send(jValueOf, ChatMessageToken.START_PARTY_FRIEND_INFO_DIALOG);
                }
            } else if (!userInfo.getUserId().equals(String.valueOf(32L)) && !userInfo.getUserId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))) {
                com.disabngo.blockynexus.e.b.x.J.a(context, (Friend) null, new FriendActivityIntentInfo(Long.parseLong(userInfo.getUserId()), 2));
            }
            return true;
        }
        return true;
    }

    @Override // io.rong.imkit.RongIM.ConversationClickListener
    public boolean onUserPortraitLongClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo, String str) {
        return false;
    }
}

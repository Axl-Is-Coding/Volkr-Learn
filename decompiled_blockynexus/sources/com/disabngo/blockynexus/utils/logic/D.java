package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import android.util.Log;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.message.provider.InviteGroupChatMessageProvider;
import com.disabngo.blockynexus.message.provider.ScrapHelpProvider;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.message.entity.CollectExchangeMessage;
import com.sandboxol.imchat.message.entity.HelpMessage;
import com.sandboxol.imchat.message.entity.InviteGroupChatMesssage;
import com.sandboxol.imchat.message.entity.InviteTeamMessage;
import com.sandboxol.imchat.message.entity.ScrapAskHelpMessage;
import com.sandboxol.imchat.message.entity.ScrapHelpMessage;
import com.sandboxol.imchat.message.entity.StarCodeUserMessage;
import com.sandboxol.imchat.message.entity.SubVipMessage;
import com.sandboxol.imchat.message.provider.HelpMessageProvider;
import com.sandboxol.imchat.receiver.MyReceiveMessageListener;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class D extends RongIMClient.ConnectCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10520a;

    D(Context context) {
        this.f10520a = context;
    }

    @Override // io.rong.imlib.RongIMClient.ConnectCallback
    public void onDatabaseOpened(RongIMClient.DatabaseOpenStatus databaseOpenStatus) {
    }

    @Override // io.rong.imlib.RongIMClient.ConnectCallback
    public void onError(RongIMClient.ConnectionErrorCode connectionErrorCode) {
        if (connectionErrorCode == RongIMClient.ConnectionErrorCode.RC_CONN_TOKEN_INCORRECT) {
            if (N.f10531a < 5) {
                N.b();
                new com.disabngo.blockynexus.e.b.o.v().a(this.f10520a);
            }
            Log.d("RongIM_connect", "--onTokenIncorrect");
        }
        Log.d("RongIM_connect", "--onError" + connectionErrorCode);
    }

    @Override // io.rong.imlib.RongIMClient.ConnectCallback
    public void onSuccess(String str) {
        int unused = N.f10531a = 0;
        RongIM.registerMessageType(InviteTeamMessage.class);
        RongIM.registerMessageType(HelpMessage.class);
        RongIM.registerMessageType(InviteGroupChatMesssage.class);
        RongIM.registerMessageType(StarCodeUserMessage.class);
        RongIM.registerMessageType(ScrapHelpMessage.class);
        RongIM.registerMessageType(ScrapAskHelpMessage.class);
        RongIM.registerMessageType(CollectExchangeMessage.class);
        RongIM.registerMessageType(SubVipMessage.class);
        RongIM.registerMessageTemplate(new com.disabngo.blockynexus.message.provider.h(AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get(), AccountCenter.newInstance().picUrl.get(), AccountCenter.newInstance().nickName.get()));
        final Context context = this.f10520a;
        RongIM.registerMessageTemplate(new HelpMessageProvider(new HelpMessageProvider.onClickListener() { // from class: com.disabngo.blockynexus.utils.logic.d
            @Override // com.sandboxol.imchat.message.provider.HelpMessageProvider.onClickListener
            public final void onClick() {
                Context context2 = context;
                TemplateUtils.startTemplate(context2, com.disabngo.blockynexus.e.b.J.f.class, context2.getString(R.string.me_help));
            }
        }));
        final Context context2 = this.f10520a;
        RongIM.registerMessageTemplate(new InviteGroupChatMessageProvider(new InviteGroupChatMessageProvider.OnClickListener() { // from class: com.disabngo.blockynexus.utils.logic.c
            @Override // com.disabngo.blockynexus.message.provider.InviteGroupChatMessageProvider.OnClickListener
            public final void onClick(long j) {
                this.f10535a.a(context2, j);
            }
        }));
        RongIM.registerMessageTemplate(new ScrapHelpProvider(new ScrapHelpProvider.OnClickListener() { // from class: com.disabngo.blockynexus.utils.logic.RongIMLogic$3$2
            @Override // com.disabngo.blockynexus.message.provider.ScrapHelpProvider.OnClickListener
            public void onClick(String str2) {
            }
        }));
        RongIM.registerMessageTemplate(new com.disabngo.blockynexus.message.provider.k());
        RongIM.setOnReceiveMessageListener(new MyReceiveMessageListener());
        RongIM.getInstance().enableNewComingMessageIcon(true);
        RongIM.getInstance().enableUnreadMessageIcon(true);
        N.s();
        Messenger.getDefault().sendNoMsg("token.init.rong.cloud");
        Log.d("RongIM_connect", "--onSuccess" + str);
    }

    public /* synthetic */ void a(Context context, long j) {
        GroupChatApi.getGroupInfo(context, j, new C(this, context, j));
    }
}

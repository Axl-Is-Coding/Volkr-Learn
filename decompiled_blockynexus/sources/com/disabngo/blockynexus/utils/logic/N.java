package com.disabngo.blockynexus.utils.logic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.C0509f;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.TribeMember;
import com.sandboxol.imchat.message.entity.HelpMessage;
import com.sandboxol.imchat.message.entity.InviteGroupChatMesssage;
import com.sandboxol.imchat.message.entity.InviteTeamMessage;
import com.sandboxol.imchat.message.entity.ScrapAskHelpMessage;
import com.sandboxol.imchat.message.entity.ScrapHelpMessage;
import com.sandboxol.imchat.module.MyExtensionModule;
import com.sandboxol.imchat.utils.ChatDbHelper;
import io.rong.common.RLog;
import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.IExtensionModule;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongExtensionManager;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongMessageItemLongClickActionManager;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import io.rong.message.TextMessage;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes.dex */
public class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f10531a;

    static /* synthetic */ int b() {
        int i = f10531a;
        f10531a = i + 1;
        return i;
    }

    public static void f() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIMClient.getInstance().clearMessagesUnreadStatus(Conversation.ConversationType.PRIVATE, String.valueOf(32L), new J());
    }

    public static void g() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().setSendMessageListener(null);
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 19 && RongIM.getInstance().getCurrentConnectionStatus() == RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED;
    }

    public static void i() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().setGroupMembersProvider(new RongIM.IGroupMembersProvider() { // from class: com.disabngo.blockynexus.utils.logic.l
            @Override // io.rong.imkit.RongIM.IGroupMembersProvider
            public final void getGroupMembers(String str, RongIM.IGroupMemberCallback iGroupMemberCallback) {
                N.a(str, iGroupMemberCallback);
            }
        });
    }

    public static void j() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        Messenger.getDefault().register(N.class, "message_load_so", new w());
        BaseApplication.getThreadPool().setName("load_rongIM_so");
        BaseApplication.getThreadPool().execute(new B());
    }

    public static void k() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.setGroupInfoProvider(new RongIM.GroupInfoProvider() { // from class: com.disabngo.blockynexus.utils.logic.j
            @Override // io.rong.imkit.RongIM.GroupInfoProvider
            public final Group getGroupInfo(String str) {
                return N.a(str);
            }
        }, true);
    }

    public static void l() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.setGroupUserInfoProvider(new RongIM.GroupUserInfoProvider() { // from class: com.disabngo.blockynexus.utils.logic.i
            @Override // io.rong.imkit.RongIM.GroupUserInfoProvider
            public final GroupUserInfo getGroupUserInfo(String str, String str2) {
                return N.a(str, str2);
            }
        }, true);
    }

    public static void m() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() { // from class: com.disabngo.blockynexus.utils.logic.m
            @Override // io.rong.imkit.RongIM.UserInfoProvider
            public final UserInfo getUserInfo(String str) {
                return ChatDbHelper.findUserInfo(str);
            }
        }, true);
    }

    public static void n() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.setConversationClickListener(new F());
    }

    public static void o() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        SharedUtils.remove(BaseApplication.getContext(), StringConstant.RONG_CHAT_TOKEN_EXPIRY_TIME);
        RongIM.getInstance().logout();
    }

    public static void p() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        try {
            RongIM.getInstance().setCurrentUserInfo(w());
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (NoClassDefFoundError e3) {
            e3.printStackTrace();
        }
    }

    public static void q() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.setConversationListBehaviorListener(new I());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r() {
        RongMessageItemLongClickActionManager.getInstance().addMessageItemLongClickAction(com.disabngo.blockynexus.d.y.b().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s() {
        RongIM.getInstance().addUnReadMessageCountChangedObserver(new IUnReadMessageObserver() { // from class: com.disabngo.blockynexus.utils.logic.k
            @Override // io.rong.imkit.manager.IUnReadMessageObserver
            public final void onCountChanged(int i) {
                Messenger.getDefault().send(Integer.valueOf(i), MessageToken.TOKEN_CHAT_UNREAD_MESSAGE_COUNT);
            }
        }, Conversation.ConversationType.PRIVATE);
        RongIM.getInstance().addUnReadMessageCountChangedObserver(new IUnReadMessageObserver() { // from class: com.disabngo.blockynexus.utils.logic.b
            @Override // io.rong.imkit.manager.IUnReadMessageObserver
            public final void onCountChanged(int i) {
                Messenger.getDefault().send(Integer.valueOf(i), MessageToken.TOKEN_GROUP_CHAT_RED_POINT);
            }
        }, Conversation.ConversationType.GROUP);
    }

    private static UserInfo t() {
        return new UserInfo(AccountCenter.newInstance().userId.get() + "", AccountCenter.newInstance().nickName.get() + "", Uri.parse(AccountCenter.newInstance().picUrl.get() == null ? "null" : AccountCenter.newInstance().picUrl.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u() {
        if (RongMessageItemLongClickActionManager.getInstance().getMessageItemLongClickActions().contains(com.disabngo.blockynexus.d.y.b().c())) {
            RongMessageItemLongClickActionManager.getInstance().removeMessageItemLongClickAction(com.disabngo.blockynexus.d.y.b().c());
        }
    }

    private static void v() {
        IExtensionModule next;
        List<IExtensionModule> extensionModules = RongExtensionManager.getInstance().getExtensionModules();
        if (extensionModules != null) {
            Iterator<IExtensionModule> it = extensionModules.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (next instanceof DefaultExtensionModule) {
                        break;
                    }
                }
            }
            if (next != null) {
                RongExtensionManager.getInstance().unregisterExtensionModule(next);
                RongExtensionManager.getInstance().registerExtensionModule(new MyExtensionModule());
            }
        }
    }

    private static UserInfo w() {
        return new UserInfo(String.valueOf(AccountCenter.newInstance().userId.get()), AccountCenter.newInstance().nickName.get(), Uri.parse(AccountCenter.newInstance().picUrl.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) {
        try {
            if (com.sandboxol.messager.b.a.a(context.getApplicationContext()).contains(":BlockmanGo")) {
                return;
            }
            b("navna02.cn.ronghub.com", "up.qbox.me");
            RongIM.init(context, "ik1qhw0919fap");
            v();
            Log.d("RongIM_init", "--onSuccess");
        } catch (Exception | VerifyError e2) {
            e2.printStackTrace();
        }
    }

    private static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            RongIMClient.setServerInfo(str, str2);
        } else {
            RLog.e("setServerInfo", "setServerInfo naviServer should not be null.");
            throw new IllegalArgumentException("naviServer should not be null.");
        }
    }

    public static void c(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        ReportDataAdapter.onEvent(context, EventConstant.ENTER_CLAN_CHAT);
        RongIM.getInstance().startGroupChat(context, String.valueOf(TribeCenter.newInstance().tribeClanId.get()), TribeCenter.newInstance().getTribeNameText());
    }

    public static void a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (RongIM.getInstance() == null) {
            RongIM.init(BaseApplication.getApp());
        }
        if (context.getApplicationInfo().packageName.equals(com.sandboxol.messager.b.a.a(context))) {
            RongIM.connect(str, new D(context));
        }
    }

    public static void c(Context context, String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().removeConversation(Conversation.ConversationType.PRIVATE, str, new r(context));
    }

    public static void b(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().setSendMessageListener(new o(context, new String[]{""}, new int[]{0}, new long[1]));
    }

    static /* synthetic */ Group a(String str) {
        int iA = com.disabngo.blockynexus.d.y.b().a(str);
        if (iA == 0) {
            return new Group(String.valueOf(TribeCenter.newInstance().tribeClanId.get()), TribeCenter.newInstance().getTribeNameText(), TribeCenter.newInstance().tribeHead.get() != null ? Uri.parse(TribeCenter.newInstance().tribeHead.get()) : null);
        }
        if (iA != 1) {
            if (iA != 2) {
                return null;
            }
            com.disabngo.blockynexus.d.y.b().a(Long.valueOf(str).longValue());
            return new Group(str, "", null);
        }
        String strC = com.disabngo.blockynexus.d.y.b().c(Long.valueOf(str).longValue());
        if (com.disabngo.blockynexus.d.y.b().d(Long.valueOf(str).longValue()) != null && !"".equals(com.disabngo.blockynexus.d.y.b().d(Long.valueOf(str).longValue()))) {
            uri = Uri.parse(com.disabngo.blockynexus.d.y.b().d(Long.valueOf(str).longValue()));
        }
        return new Group(str, strC, uri);
    }

    public static void b(Context context, String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().removeConversation(Conversation.ConversationType.PRIVATE, str, new s(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(TextMessage textMessage, String[] strArr, int[] iArr, long[] jArr) {
        if (strArr[0].equals(textMessage.getContent())) {
            iArr[0] = iArr[0] + 1;
        } else {
            strArr[0] = textMessage.getContent();
            iArr[0] = 0;
        }
        if (iArr[0] > 2) {
            if (iArr[0] == 3) {
                jArr[0] = System.currentTimeMillis();
            } else {
                if (System.currentTimeMillis() - jArr[0] < 10000) {
                    AppToastUtils.showShortNegativeTipToast(BaseApplication.getContext(), BaseApplication.getContext().getString(R.string.group_cant_send_same_msg));
                    return true;
                }
                iArr[0] = 0;
            }
        }
        return false;
    }

    public static void a(long j, String str, String str2) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().refreshGroupInfoCache(new Group(String.valueOf(j), str, Uri.parse(str2)));
    }

    public static void a(long j, long j2, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 19 && str != null) {
            String strValueOf = TextUtils.isEmpty(str) ? String.valueOf(j2) : str;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            UserInfo userInfo = new UserInfo(String.valueOf(j2), strValueOf, Uri.parse(str2));
            RongIM.getInstance().refreshGroupUserInfoCache(new GroupUserInfo(String.valueOf(j), String.valueOf(j2), str));
            RongIM.getInstance().refreshUserInfoCache(userInfo);
        }
    }

    public static void a(String str, boolean z, RongIMClient.ResultCallback<Boolean> resultCallback) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().setConversationToTop(Conversation.ConversationType.GROUP, str, z, resultCallback);
    }

    static /* synthetic */ GroupUserInfo a(String str, String str2) {
        Long lValueOf = 0L;
        if (com.disabngo.blockynexus.d.y.b().a(str) == 0) {
            try {
                lValueOf = Long.valueOf(str2);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            TribeMember tribeMemberA = C0509f.a().a(lValueOf.longValue());
            if (tribeMemberA != null && tribeMemberA.getNickName() != null) {
                return new GroupUserInfo(str, str2, tribeMemberA.getNickName());
            }
            return new GroupUserInfo(str, str2, "");
        }
        try {
            lValueOf = Long.valueOf(str2);
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
        }
        String strE = com.disabngo.blockynexus.d.y.b().e(lValueOf.longValue());
        if (TextUtils.isEmpty(strE)) {
            return new GroupUserInfo(str, str2, str2);
        }
        return new GroupUserInfo(str, str2, strE);
    }

    public static void a(Context context, GroupInfo groupInfo, String str, boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        InviteGroupChatMesssage inviteGroupChatMesssage = new InviteGroupChatMesssage();
        inviteGroupChatMesssage.setGroupId(groupInfo.getGroupId());
        inviteGroupChatMesssage.setUserId(Long.parseLong(str));
        inviteGroupChatMesssage.setMsg(context.getString(R.string.welcome_in, groupInfo.getGroupName()));
        RongIM.getInstance().sendMessage(z ? Conversation.ConversationType.PRIVATE : Conversation.ConversationType.GROUP, str, inviteGroupChatMesssage, context.getString(R.string.welcome_in, groupInfo.getGroupName()), "app:groupChatCard", new K(context));
    }

    public static void a(Context context, ScrapHelpMessage scrapHelpMessage, String str, boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        Conversation.ConversationType conversationType = z ? Conversation.ConversationType.PRIVATE : Conversation.ConversationType.GROUP;
        RongIM.getInstance().sendMessage(conversationType, str, scrapHelpMessage, context.getString(R.string.scrap_help_tips) + scrapHelpMessage.getScrapName(), "app:scrapHelp", new L());
    }

    public static void a(Context context, ScrapAskHelpMessage scrapAskHelpMessage, String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().sendMessage(Conversation.ConversationType.PRIVATE, str, scrapAskHelpMessage, context.getString(R.string.scrap_ask_help_summery_2, AccountCenter.newInstance().nickName.get(), scrapAskHelpMessage.getScrapName()), "app:scrapAskHelp", new M());
    }

    public static void a(Context context, long j) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().sendMessage(Message.obtain(String.valueOf(j), Conversation.ConversationType.PRIVATE, TextMessage.obtain(BaseApplication.getContext().getString(R.string.friend_agree_friend_message))), null, null, new C0980n());
    }

    public static void a(final long j) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        Observable.timer(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.disabngo.blockynexus.utils.logic.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                RongIM.getInstance().sendMessage(Conversation.ConversationType.PRIVATE, String.valueOf(j), new HelpMessage(), "", "app:help", new p());
            }
        });
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT < 19 || activity == null || activity.isFinishing()) {
            return;
        }
        SharedUtils.remove(activity, StringConstant.RONG_CHAT_TOKEN_EXPIRY_TIME);
        RongIM.getInstance().logout();
    }

    public static void a(Long l) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().removeConversation(Conversation.ConversationType.GROUP, String.valueOf(l), new q());
    }

    public static void a(Context context, String str, String str2, boolean z, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (context == null || TextUtils.isEmpty(str) || AppInfoCenter.newInstance().isNowParty()) {
            if (context != null) {
                AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.inner_error));
            }
        } else {
            if (RongContext.getInstance() == null) {
                AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.inner_error));
                return;
            }
            if (!com.disabngo.blockynexus.d.y.b().i(Long.valueOf(str).longValue())) {
                com.disabngo.blockynexus.d.y.b().a(Long.valueOf(str).longValue());
            }
            com.disabngo.blockynexus.d.y.b().j(Long.valueOf(str).longValue());
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + context.getApplicationInfo().packageName).buildUpon().appendPath("conversation").appendPath(Conversation.ConversationType.GROUP.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).build());
            intent.putExtra("isTribe", z);
            intent.putExtra("memberNum", i);
            context.startActivity(intent);
            ReportDataAdapter.onEvent(context, EventConstant.ENTER_GROUP_CHAT);
        }
    }

    public static void a(String str, String str2, Uri uri) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().refreshUserInfoCache(new UserInfo(str, str2, uri));
    }

    public static void a(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        ReportDataAdapter.onEvent(context, EventConstant.ENTER_PRIVATE_CHAT);
        SandboxReportManager.onEvent(ReportEvent.NEW_CHAT_CHATPAGE, ReportEventType.NEW_USER_BEHAVIOR, "app");
        RongIM.getInstance().startPrivateChat(context, str, str2);
    }

    public static void a(Context context, String str, String str2, boolean z, String str3) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (context == null || TextUtils.isEmpty(str) || AppInfoCenter.newInstance().isNowParty()) {
            if (context != null) {
                AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.inner_error));
            }
        } else if (RongContext.getInstance() == null) {
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.inner_error));
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + context.getApplicationInfo().packageName).buildUpon().appendPath("conversation").appendPath(Conversation.ConversationType.CHATROOM.getName().toLowerCase(Locale.US)).appendQueryParameter("isTeam", String.valueOf(z)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).appendQueryParameter("gameMessage", str3).build());
            intent.putExtra("createIfNotExist", true);
            context.startActivity(intent);
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, String str3) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (context == null || TextUtils.isEmpty(str) || AppInfoCenter.newInstance().isNowParty()) {
            if (context != null) {
                AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.inner_error));
            }
        } else if (RongContext.getInstance() == null) {
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.inner_error));
        } else {
            DressManager.onPauseByGroupView();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + context.getApplicationInfo().packageName).buildUpon().appendPath("party").appendPath(Conversation.ConversationType.CHATROOM.getName().toLowerCase(Locale.US)).appendQueryParameter("isTeam", String.valueOf(z)).appendQueryParameter("isGameDetail", String.valueOf(z2)).appendQueryParameter("targetId", str).appendQueryParameter("title", str2).appendQueryParameter("gameMessage", str3).build());
            intent.putExtra("createIfNotExist", true);
            context.startActivity(intent);
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK);
    }

    public static void a(Context context, boolean z, String str, GameMassage gameMassage) {
        if (Build.VERSION.SDK_INT >= 19 && RongIM.getInstance() != null) {
            InviteTeamMessage inviteTeamMessage = new InviteTeamMessage(gameMassage.getGameName(), gameMassage.getGameType(), gameMassage.getGamePic(), AccountCenter.newInstance().picUrl.get(), gameMassage.getCaptainId(), gameMassage.getCaptainName(), gameMassage.getChatRoomId(), gameMassage.getTeamId(), EngineEnv.getEngineVersion(gameMassage.getIsNewEngine(), gameMassage.getIsUgc()), gameMassage.getRoomName(), gameMassage.getMaxMember(), gameMassage.getMemberCount(), gameMassage.getTeamCount(), gameMassage.getTeamType(), gameMassage.getPsid(), gameMassage.getIsNewEngine(), gameMassage.getIsUgc());
            inviteTeamMessage.setUserInfo(t());
            RongIM.getInstance().sendMessage(z ? Conversation.ConversationType.GROUP : Conversation.ConversationType.PRIVATE, str, inviteTeamMessage, "inviteTeamMsg", AccountCenter.newInstance().nickName.get() + context.getString(R.string.invite_join_team), new t());
        }
    }

    public static void a(com.disabngo.blockynexus.interfaces.c cVar) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().removeNotificationQuietHours(new u(cVar));
    }

    public static void a(String str, int i, com.disabngo.blockynexus.interfaces.c cVar) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        RongIM.getInstance().setNotificationQuietHours(str, i, new v(cVar));
    }

    public static void a(Conversation.ConversationType conversationType, String str, boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        try {
            if (RongIM.getInstance() != null) {
                if (z) {
                    RongIM.getInstance().setConversationNotificationStatus(conversationType, str, Conversation.ConversationNotificationStatus.DO_NOT_DISTURB, new x(str));
                } else {
                    RongIM.getInstance().setConversationNotificationStatus(conversationType, str, Conversation.ConversationNotificationStatus.NOTIFY, new y(str));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void a(String str, RongIM.IGroupMemberCallback iGroupMemberCallback) {
        try {
            if (String.valueOf(TribeCenter.newInstance().tribeClanId.get()).equals(str)) {
                C0509f.a().a(new z(iGroupMemberCallback));
            } else {
                iGroupMemberCallback.onGetGroupMembersResult(com.disabngo.blockynexus.d.y.b().h(Long.valueOf(str).longValue()));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

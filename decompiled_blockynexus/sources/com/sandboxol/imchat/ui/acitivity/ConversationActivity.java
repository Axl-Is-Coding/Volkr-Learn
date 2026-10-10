package com.sandboxol.imchat.ui.acitivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.F;
import com.facebook.internal.ServerProtocol;
import com.google.gson.j;
import com.just.agentweb.DefaultWebClient;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.web.FriendPublicApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.config.BroadcastConstant;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.config.ChatStringConstant;
import com.sandboxol.imchat.entity.GroupNameModify;
import com.sandboxol.imchat.ui.dialog.GroupNoticeDialog;
import com.sandboxol.imchat.ui.dialog.TeamDialog;
import com.sandboxol.imchat.ui.fragment.ConversationFragmentEx;
import com.sandboxol.imchat.ui.fragment.team.TeamFragment;
import com.sandboxol.imchat.ui.widget.LoadingDialog;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.fragment.UriFragment;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imlib.MessageTag;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.UserInfo;
import io.rong.imlib.typingmessage.TypingStatus;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public class ConversationActivity extends BaseActivity implements View.OnClickListener {
    public static final int SET_TARGET_ID_TITLE = 0;
    public static final int SET_TEXT_TYPING_TITLE = 1;
    public static final int SET_VOICE_TYPING_TITLE = 2;
    private static final String TAG = "ConversationActivity";
    private FrameLayout fl_team_game;
    private ConversationFragmentEx fragment;
    private ImageView iv_arrow;
    private RelativeLayout layout_announce;
    private Conversation.ConversationType mConversationType;
    private LoadingDialog mDialog;
    private Handler mHandler;
    private Button mRightButton;
    private String mTargetId;
    private SharedPreferences sp;
    private String title;
    private TextView tvFriendStatus;
    private TextView tv_announce;
    private final String TextTypingTitle = "对方正在输入...";
    private final String VoiceTypingTitle = "对方正在讲话...";
    private boolean isTribeGroup = true;
    private int memberNum = 0;
    private int outsideMsgNum = 0;

    static /* synthetic */ Context access$1700(ConversationActivity conversationActivity) {
        conversationActivity.getContext();
        return conversationActivity;
    }

    static /* synthetic */ int access$1908(ConversationActivity conversationActivity) {
        int i = conversationActivity.outsideMsgNum;
        conversationActivity.outsideMsgNum = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterActivity() {
        String string = this.sp.getString("loginToken", "");
        if (string.equals(StringConstant.PARTY_GAME_CATEGORY_DEFAULT)) {
            Log.e(TAG, "push2");
        } else {
            Log.e(TAG, "push3");
            reconnect(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterFragment(Conversation.ConversationType conversationType, String str) {
        if (RongContext.getInstance() == null) {
            return;
        }
        this.fragment = new ConversationFragmentEx();
        this.fragment.setUri(Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon().appendPath("conversation").appendPath(conversationType.getName().toLowerCase()).appendQueryParameter("targetId", str).build());
        F fA = getSupportFragmentManager().a();
        fA.a(R.id.rong_content, this.fragment);
        fA.b();
    }

    private void enterSettingActivity() {
        Conversation.ConversationType conversationType = this.mConversationType;
        if (conversationType == Conversation.ConversationType.PUBLIC_SERVICE || conversationType == Conversation.ConversationType.APP_PUBLIC_SERVICE) {
            RongIM.getInstance().startPublicServiceProfile(this, this.mConversationType, this.mTargetId);
            return;
        }
        this.mTargetId = ((UriFragment) getSupportFragmentManager().e().get(0)).getUri().getQueryParameter("targetId");
        if (TextUtils.isEmpty(this.mTargetId)) {
            ToastUtils.showShortToast(this.mContext, "讨论组尚未创建成功");
        }
        Intent intent = null;
        Conversation.ConversationType conversationType2 = this.mConversationType;
        if (conversationType2 == Conversation.ConversationType.GROUP || conversationType2 == Conversation.ConversationType.PRIVATE || conversationType2 != Conversation.ConversationType.DISCUSSION) {
            intent.putExtra("TargetId", this.mTargetId);
        }
    }

    private void enterTeamGame(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        if (intent.getData().getQueryParameter("isTeam") == null) {
            this.fl_team_game.setVisibility(8);
            return;
        }
        this.fl_team_game.setVisibility(0);
        setHeadRightButtonVisibility(4);
        AppInfoCenter.newInstance().setNowParty(true);
        if (intent.getData().getQueryParameter("gameMessage") == null) {
            return;
        }
        try {
            GameMassage gameMassage = (GameMassage) new j().a(intent.getData().getQueryParameter("gameMessage"), GameMassage.class);
            RongIM.getInstance().joinChatRoom(this.mTargetId, -1, null);
            TeamFragment teamFragment = new TeamFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(ChatStringConstant.GAME_MESSAGE_OBJ, gameMassage);
            teamFragment.setArguments(bundle);
            F fA = getSupportFragmentManager().a();
            fA.a(R.id.fl_team_game, teamFragment);
            fA.b();
        } catch (Exception e2) {
            ToastUtils.showLongToast(this, R.string.team_create_failure);
            finish();
            Messenger.getDefault().send(e2.toString(), ChatMessageToken.TOKEN_CHAT_UPLOAD_ENTER_TEAM_WRONG);
        }
    }

    private Context getContext() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStatusDesc(int i) {
        return i == 30 ? BaseApplication.getContext().getString(com.sandboxol.center.R.string.base_friend_status_offline) : i == 10 ? BaseApplication.getContext().getString(com.sandboxol.center.R.string.base_friend_status_online) : (i == 20 || i == 15) ? BaseApplication.getContext().getString(com.sandboxol.center.R.string.base_friend_status_gaming) : BaseApplication.getContext().getString(com.sandboxol.center.R.string.base_friend_status_offline);
    }

    private void getUnReadCount() {
        getContext();
        this.outsideMsgNum = SharedUtils.getInt(this, SharedConstant.KEY_ALL_UNREAD_COUNT, 0);
        RongIM.getInstance().getUnreadCount(this.mConversationType, this.mTargetId, new RongIMClient.ResultCallback<Integer>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.19
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Integer num) {
                ConversationActivity.this.outsideMsgNum -= num.intValue();
                if (ConversationActivity.this.outsideMsgNum <= 0) {
                    ConversationActivity.this.outsideMsgNum = 0;
                } else {
                    ConversationActivity conversationActivity = ConversationActivity.this;
                    conversationActivity.setOutsideNum(conversationActivity.outsideMsgNum);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hintKbTwo() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (!inputMethodManager.isActive() || getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, "token.refresh.group.name", GroupNameModify.class, new Action1<GroupNameModify>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.14
            @Override // rx.functions.Action1
            public void call(GroupNameModify groupNameModify) {
                if (ConversationActivity.this.mTargetId.equals(String.valueOf(groupNameModify.getGroupId()))) {
                    ConversationActivity.this.title = TextEllipsizeUtil.ellipsizeString(20, groupNameModify.getGroupName(), TextEllipsizeUtil.SignLib.END_POINT);
                    ConversationActivity conversationActivity = ConversationActivity.this;
                    conversationActivity.setGroupActionBar(conversationActivity.mTargetId);
                }
            }
        });
        Messenger.getDefault().register(this, "token.refresh.group.list", RefreshMsg.class, new Action1<RefreshMsg>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.15
            @Override // rx.functions.Action1
            public void call(RefreshMsg refreshMsg) {
                ConversationActivity.this.finish();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_REFRESH_GROUP_NUM, GroupNameModify.class, new Action1<GroupNameModify>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.16
            @Override // rx.functions.Action1
            public void call(GroupNameModify groupNameModify) {
                if (ConversationActivity.this.mTargetId.equals(String.valueOf(groupNameModify.getGroupId()))) {
                    ConversationActivity.this.memberNum = (int) groupNameModify.getMemberSize();
                    ConversationActivity conversationActivity = ConversationActivity.this;
                    conversationActivity.setGroupActionBar(conversationActivity.mTargetId);
                }
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_SHOW_GROUP_NOTICE_DIALOG, String.class, new Action1<String>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.17
            @Override // rx.functions.Action1
            public void call(String str) {
                String[] strArrSplit = str.split(SharedConstant.KEY_GROUP_NOTICE_SPLIT);
                String str2 = strArrSplit[0];
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 1; i < strArrSplit.length; i++) {
                    try {
                        arrayList.add(strArrSplit[i]);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                ConversationActivity conversationActivity = ConversationActivity.this;
                ConversationActivity.access$1700(conversationActivity);
                new GroupNoticeDialog(conversationActivity).setNotice(str2).setPics(arrayList).show();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_ADD_OUTSIDE_NUM, String.class, new Action1<String>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.18
            @Override // rx.functions.Action1
            public void call(String str) {
                if (!ConversationActivity.this.mConversationType.equals(Conversation.ConversationType.GROUP) || ConversationActivity.this.isTribeGroup || str.equals(ConversationActivity.this.mTargetId)) {
                    return;
                }
                ConversationActivity.access$1908(ConversationActivity.this);
                if (ConversationActivity.this.outsideMsgNum <= 0) {
                    ConversationActivity.this.outsideMsgNum = 0;
                } else {
                    ConversationActivity conversationActivity = ConversationActivity.this;
                    conversationActivity.setOutsideNum(conversationActivity.outsideMsgNum);
                }
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.EXIT_PARTY, new Action0() { // from class: com.sandboxol.imchat.ui.acitivity.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18770a.finish();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CLOSE_CHAT_ACTIVITY, new Action0() { // from class: com.sandboxol.imchat.ui.acitivity.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18770a.finish();
            }
        });
    }

    private void isPushMessage(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        if (!intent.getData().getScheme().equals("rong") || intent.getData().getQueryParameter("isFromPush") == null) {
            if (!RongIM.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED)) {
                enterFragment(this.mConversationType, this.mTargetId);
                return;
            }
            LoadingDialog loadingDialog = this.mDialog;
            if (loadingDialog != null && !loadingDialog.isShowing() && !isFinishing()) {
                this.mDialog.show();
            }
            new Handler().postDelayed(new Runnable() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    if (ConversationActivity.this.isFinishing()) {
                        return;
                    }
                    ConversationActivity.this.enterActivity();
                }
            }, 300L);
            return;
        }
        if (intent.getData().getQueryParameter("isFromPush").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            LoadingDialog loadingDialog2 = this.mDialog;
            if (loadingDialog2 != null && !loadingDialog2.isShowing() && !isFinishing()) {
                this.mDialog.show();
            }
            enterActivity();
            return;
        }
        if (!RongIM.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED)) {
            if (intent.getData().getPath().contains("conversation/system")) {
                finish();
                return;
            } else {
                enterFragment(this.mConversationType, this.mTargetId);
                return;
            }
        }
        LoadingDialog loadingDialog3 = this.mDialog;
        if (loadingDialog3 != null && !loadingDialog3.isShowing() && !isFinishing()) {
            this.mDialog.show();
        }
        if (intent.getData().getPath().contains("conversation/system")) {
            finish();
        } else {
            enterActivity();
        }
    }

    private void reconnect(String str) {
        RongIM.connect(str, new RongIMClient.ConnectCallback() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.8
            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onDatabaseOpened(RongIMClient.DatabaseOpenStatus databaseOpenStatus) {
            }

            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onError(RongIMClient.ConnectionErrorCode connectionErrorCode) {
                Log.e(ConversationActivity.TAG, "---onError--" + connectionErrorCode);
                if (ConversationActivity.this.mDialog != null && !ConversationActivity.this.isFinishing()) {
                    ConversationActivity.this.mDialog.dismiss();
                }
                ConversationActivity conversationActivity = ConversationActivity.this;
                conversationActivity.enterFragment(conversationActivity.mConversationType, ConversationActivity.this.mTargetId);
            }

            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onSuccess(String str2) {
                Log.i(ConversationActivity.TAG, "---onSuccess--" + str2);
                Log.e(ConversationActivity.TAG, "ConversationActivity push");
                if (ConversationActivity.this.mDialog != null && !ConversationActivity.this.isFinishing()) {
                    ConversationActivity.this.mDialog.dismiss();
                }
                ConversationActivity conversationActivity = ConversationActivity.this;
                conversationActivity.enterFragment(conversationActivity.mConversationType, ConversationActivity.this.mTargetId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActionBarTitle(Conversation.ConversationType conversationType, String str) {
        if (conversationType == null) {
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.PRIVATE)) {
            setPrivateActionBar(str);
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.GROUP)) {
            setGroupActionBar(str);
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.DISCUSSION)) {
            setDiscussionActionBar(str);
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.CHATROOM)) {
            setTitle(this.title);
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.SYSTEM)) {
            setTitle(R.string.de_actionbar_system);
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.APP_PUBLIC_SERVICE)) {
            setAppPublicServiceActionBar(str);
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.PUBLIC_SERVICE)) {
            setPublicServiceActionBar(str);
        } else if (conversationType.equals(Conversation.ConversationType.CUSTOMER_SERVICE)) {
            setTitle(R.string.main_customer);
        } else {
            setTitle(R.string.de_actionbar_sub_defult);
        }
    }

    private void setAnnounceListener() {
        ConversationFragmentEx conversationFragmentEx = this.fragment;
        if (conversationFragmentEx != null) {
            conversationFragmentEx.setOnShowAnnounceBarListener(new ConversationFragmentEx.OnShowAnnounceListener() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.6
                @Override // com.sandboxol.imchat.ui.fragment.ConversationFragmentEx.OnShowAnnounceListener
                public void onShowAnnounceView(String str, final String str2) {
                    ConversationActivity.this.layout_announce.setVisibility(0);
                    ConversationActivity.this.tv_announce.setText(str);
                    ConversationActivity.this.layout_announce.setClickable(false);
                    if (TextUtils.isEmpty(str2)) {
                        ConversationActivity.this.iv_arrow.setVisibility(8);
                        return;
                    }
                    ConversationActivity.this.iv_arrow.setVisibility(0);
                    ConversationActivity.this.layout_announce.setClickable(true);
                    ConversationActivity.this.layout_announce.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            String lowerCase = str2.toLowerCase();
                            if (TextUtils.isEmpty(lowerCase)) {
                                return;
                            }
                            if (!lowerCase.startsWith("http") && !lowerCase.startsWith("https")) {
                                lowerCase = DefaultWebClient.HTTP_SCHEME + lowerCase;
                            }
                            Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
                            intent.setPackage(view.getContext().getPackageName());
                            intent.putExtra("url", lowerCase);
                            view.getContext().startActivity(intent);
                        }
                    });
                }
            });
        }
    }

    private void setAppPublicServiceActionBar(String str) {
        if (str == null) {
            return;
        }
        RongIM.getInstance().getPublicServiceProfile(Conversation.PublicServiceType.APP_PUBLIC_SERVICE, str, new RongIMClient.ResultCallback<PublicServiceProfile>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.9
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(PublicServiceProfile publicServiceProfile) {
                ConversationActivity.this.setTitle(publicServiceProfile.getName());
            }
        });
    }

    private void setDiscussionActionBar(String str) {
        if (str != null) {
            RongIM.getInstance().getDiscussion(str, new RongIMClient.ResultCallback<Discussion>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.11
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    if (errorCode.equals(RongIMClient.ErrorCode.NOT_IN_DISCUSSION)) {
                        ConversationActivity.this.setTitle("不在讨论组中");
                        ConversationActivity.this.supportInvalidateOptionsMenu();
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Discussion discussion) {
                    ConversationActivity.this.setTitle(discussion.getName());
                }
            });
        } else {
            setTitle("讨论组");
        }
    }

    private void setFriendStatus() {
        if (TextUtils.isEmpty(this.mTargetId)) {
            return;
        }
        boolean z = true;
        for (int i = 0; i < this.mTargetId.length(); i++) {
            if (!Character.isDigit(this.mTargetId.charAt(i))) {
                z = false;
            }
        }
        if (z) {
            FriendPublicApi.getFriendStatus(Long.parseLong(this.mTargetId), new OnResponseListener<Integer>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.5
                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onError(int i2, String str) {
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onServerError(int i2) {
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onSuccess(Integer num) {
                    ConversationActivity conversationActivity = ConversationActivity.this;
                    if (conversationActivity.mTitle == null || conversationActivity.tvFriendStatus == null) {
                        return;
                    }
                    ConversationActivity.this.mTitle.setTypeface(Typeface.DEFAULT, 1);
                    ConversationActivity.this.tvFriendStatus.setVisibility(0);
                    ConversationActivity.this.tvFriendStatus.setText(ConversationActivity.this.getStatusDesc(num.intValue()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupActionBar(String str) {
        if (TextUtils.isEmpty(this.title)) {
            setTitle(str);
            return;
        }
        if (this.isTribeGroup) {
            setTitle(this.title);
            return;
        }
        setTitle(this.title + "(" + this.memberNum + ")");
    }

    private void setPrivateActionBar(String str) {
        UserInfo userInfo;
        if (TextUtils.isEmpty(this.title)) {
            setTitle(str);
            return;
        }
        if (!this.title.equals("null")) {
            setTitle(this.title);
        } else {
            if (TextUtils.isEmpty(str) || (userInfo = RongUserInfoManager.getInstance().getUserInfo(str)) == null) {
                return;
            }
            setTitle(userInfo.getName());
        }
    }

    private void setPublicServiceActionBar(String str) {
        if (str == null) {
            return;
        }
        RongIM.getInstance().getPublicServiceProfile(Conversation.PublicServiceType.PUBLIC_SERVICE, str, new RongIMClient.ResultCallback<PublicServiceProfile>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.10
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(PublicServiceProfile publicServiceProfile) {
                ConversationActivity.this.setTitle(publicServiceProfile.getName());
            }
        });
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.sandboxol.imchat.ui.acitivity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getIntent() == null || getIntent().getData() == null) {
            return;
        }
        if (getIntent().getData().getQueryParameter("isTeam") != null) {
            new TeamDialog(this).setListener(new TeamDialog.OnTeamBackDialogClickListener() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.13
                @Override // com.sandboxol.imchat.ui.dialog.TeamDialog.OnTeamBackDialogClickListener
                public void onClick() {
                    AppInfoCenter.newInstance().setNowParty(false);
                    ConversationActivity.this.sendBroadcast(new Intent(BroadcastConstant.RongCloudChatOnLeft));
                    ConversationActivity.this.finish();
                }
            }).show();
        } else {
            sendBroadcast(new Intent(BroadcastConstant.RongCloudChatOnLeft));
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        enterSettingActivity();
    }

    @Override // com.sandboxol.imchat.ui.acitivity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @TargetApi(23)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.conversation);
        this.sp = getSharedPreferences("config", 0);
        this.mDialog = new LoadingDialog(this);
        this.layout_announce = (RelativeLayout) findViewById(R.id.ll_annouce);
        this.iv_arrow = (ImageView) findViewById(R.id.iv_announce_arrow);
        this.layout_announce.setVisibility(8);
        this.tv_announce = (TextView) findViewById(R.id.tv_announce_msg);
        this.fl_team_game = (FrameLayout) findViewById(R.id.fl_team_game);
        this.tvFriendStatus = (TextView) findViewById(R.id.tv_status);
        this.mRightButton = getHeadRightButton();
        Intent intent = getIntent();
        if (intent == null || intent.getData() == null) {
            return;
        }
        initMessenger();
        this.mTargetId = intent.getData().getQueryParameter("targetId");
        String str = this.mTargetId;
        if (str == null || !str.equals("10000")) {
            try {
                this.mConversationType = Conversation.ConversationType.valueOf(intent.getData().getLastPathSegment().toUpperCase(Locale.US));
                this.title = intent.getData().getQueryParameter("title");
                this.memberNum = intent.getIntExtra("memberNum", 0);
                this.isTribeGroup = intent.getBooleanExtra("isTribe", true);
                setActionBarTitle(this.mConversationType, this.mTargetId);
                if (this.mConversationType.equals(Conversation.ConversationType.GROUP)) {
                    this.mRightButton.setBackground(getResources().getDrawable(R.drawable.icon2_menu));
                    if (!this.isTribeGroup) {
                        this.mRightButton.setBackground(getResources().getDrawable(R.drawable.btn_group_right));
                        this.mRightButton.setVisibility(0);
                        getUnReadCount();
                    }
                } else if ((this.mConversationType.equals(Conversation.ConversationType.PRIVATE) | this.mConversationType.equals(Conversation.ConversationType.PUBLIC_SERVICE)) || this.mConversationType.equals(Conversation.ConversationType.DISCUSSION)) {
                    this.mRightButton.setBackground(getResources().getDrawable(R.drawable.icon1_menu));
                } else {
                    this.mRightButton.setVisibility(8);
                    this.mRightButton.setClickable(false);
                }
                if (!this.mConversationType.equals(Conversation.ConversationType.GROUP) || this.isTribeGroup) {
                    this.mRightButton.setOnClickListener(this);
                } else {
                    this.mRightButton.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Messenger.getDefault().send(ConversationActivity.this.mTargetId, ChatMessageToken.TOKEN_START_GROUP_INFO);
                        }
                    });
                    this.mBtnLeft.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ConversationActivity.this.finish();
                        }
                    });
                }
                if (this.mConversationType.equals(Conversation.ConversationType.PRIVATE)) {
                    setFriendStatus();
                }
                enterTeamGame(intent);
                isPushMessage(intent);
                if (this.mConversationType.equals(Conversation.ConversationType.CUSTOMER_SERVICE)) {
                    setAnnounceListener();
                }
                this.mHandler = new Handler(new Handler.Callback() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.3
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        int i = message.what;
                        if (i == 0) {
                            ConversationActivity conversationActivity = ConversationActivity.this;
                            conversationActivity.setActionBarTitle(conversationActivity.mConversationType, ConversationActivity.this.mTargetId);
                        } else if (i == 1) {
                            ConversationActivity.this.setTitle("对方正在输入...");
                        } else if (i == 2) {
                            ConversationActivity.this.setTitle("对方正在讲话...");
                        }
                        return true;
                    }
                });
                RongIMClient.setTypingStatusListener(new RongIMClient.TypingStatusListener() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.4
                    @Override // io.rong.imlib.RongIMClient.TypingStatusListener
                    public void onTypingStatusChanged(Conversation.ConversationType conversationType, String str2, Collection<TypingStatus> collection) {
                        if (conversationType.equals(ConversationActivity.this.mConversationType) && str2.equals(ConversationActivity.this.mTargetId)) {
                            if (collection.size() <= 0) {
                                ConversationActivity.this.mHandler.sendEmptyMessage(0);
                                return;
                            }
                            String typingContentType = collection.iterator().next().getTypingContentType();
                            MessageTag messageTag = (MessageTag) TextMessage.class.getAnnotation(MessageTag.class);
                            MessageTag messageTag2 = (MessageTag) VoiceMessage.class.getAnnotation(MessageTag.class);
                            if (typingContentType.equals(messageTag.value())) {
                                ConversationActivity.this.mHandler.sendEmptyMessage(1);
                            } else if (typingContentType.equals(messageTag2.value())) {
                                ConversationActivity.this.mHandler.sendEmptyMessage(2);
                            }
                        }
                    }
                });
                Messenger.getDefault().sendNoMsg("token.group.chat.action.bar");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_REFRESH_CONVERSATION_STATE);
        RongIMClient.setTypingStatusListener(null);
        Messenger.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override // com.sandboxol.imchat.ui.acitivity.BaseActivity
    public void onHeadLeftButtonClick(View view) {
        ConversationFragmentEx conversationFragmentEx = this.fragment;
        if (conversationFragmentEx == null || conversationFragmentEx.onBackPressed()) {
            return;
        }
        if (this.fragment.isLocationSharing()) {
            this.fragment.showQuitLocationSharingDialog(this);
            return;
        }
        if (getIntent() == null || getIntent().getData() == null) {
            return;
        }
        if (getIntent().getData().getQueryParameter("isTeam") != null) {
            new TeamDialog(this).setListener(new TeamDialog.OnTeamBackDialogClickListener() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationActivity.12
                @Override // com.sandboxol.imchat.ui.dialog.TeamDialog.OnTeamBackDialogClickListener
                public void onClick() {
                    AppInfoCenter.newInstance().setNowParty(false);
                    ConversationActivity.this.sendBroadcast(new Intent(BroadcastConstant.RongCloudChatOnLeft));
                    ConversationActivity.this.hintKbTwo();
                    ConversationActivity.this.finish();
                }
            }).show();
            return;
        }
        sendBroadcast(new Intent(BroadcastConstant.RongCloudChatOnLeft));
        hintKbTwo();
        finish();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ConversationFragmentEx conversationFragmentEx;
        if (4 != keyEvent.getKeyCode() || (conversationFragmentEx = this.fragment) == null || conversationFragmentEx.onBackPressed()) {
            return false;
        }
        finish();
        return false;
    }
}

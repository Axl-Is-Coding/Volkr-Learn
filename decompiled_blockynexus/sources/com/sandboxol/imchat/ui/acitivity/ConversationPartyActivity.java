package com.sandboxol.imchat.ui.acitivity;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.F;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.internal.ServerProtocol;
import com.google.gson.j;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.common.widget.AutoHorizontalRecyclerView;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.adapter.QuickChatAdapter;
import com.sandboxol.imchat.config.BroadcastConstant;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.config.ChatStringConstant;
import com.sandboxol.imchat.ui.dialog.TeamDialog;
import com.sandboxol.imchat.ui.fragment.ConversationFragmentEx;
import com.sandboxol.imchat.ui.fragment.party.PartyChatDialog;
import com.sandboxol.imchat.ui.fragment.partydress.PartyDressFragment;
import com.sandboxol.imchat.ui.widget.LoadingDialog;
import com.sandboxol.imchat.utils.RongIMLogic;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import java.util.Locale;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public class ConversationPartyActivity extends BaseActivity implements DialogInterface.OnDismissListener, View.OnClickListener {
    private static final String TAG = "ConversationPartyActivity";
    private QuickChatAdapter adapter;
    private Button btnChat;
    private Button btnStart;
    private FrameLayout fl_team_game;
    private ConversationFragmentEx fragment;
    private boolean isCaptain;
    private boolean isConnectSuccess;
    private String isGameDetail = "";
    private boolean isShowing;
    private Conversation.ConversationType mConversationType;
    private LoadingDialog mDialog;
    private String mTargetId;
    private AutoHorizontalRecyclerView recyclerView;
    private RelativeLayout rlBottom;
    private SharedPreferences sp;
    private String title;
    private View vShadow;

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyPage() {
        AppInfoCenter.newInstance().setNowParty(false);
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_REFRESH_CONVERSATION_STATE);
        RongIMClient.setTypingStatusListener(null);
        Messenger.getDefault().unregister(this);
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
        Uri uriBuild = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon().appendPath("conversation").appendPath(conversationType.getName().toLowerCase()).appendQueryParameter("targetId", str).build();
        this.fragment.setUri(uriBuild);
        Log.e("enterActivity", uriBuild.toString());
        F fA = getSupportFragmentManager().a();
        fA.a(R.id.rong_content, this.fragment);
        fA.b();
    }

    private void enterTeamGame(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        if (intent.getData().getQueryParameter("isTeam") == null) {
            this.fl_team_game.setVisibility(8);
            ToastUtils.showLongToast(this, R.string.imchat_party_enter_failed);
            finish();
            return;
        }
        this.fl_team_game.setVisibility(0);
        setHeadRightButtonVisibility(4);
        if (intent.getData().getQueryParameter("gameMessage") == null) {
            ToastUtils.showLongToast(this, R.string.imchat_party_enter_failed);
            finish();
            return;
        }
        try {
            GameMassage gameMassage = (GameMassage) new j().a(intent.getData().getQueryParameter("gameMessage"), GameMassage.class);
            RongIM.getInstance().joinChatRoom(this.mTargetId, -1, null);
            PartyDressFragment partyDressFragment = new PartyDressFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(ChatStringConstant.GAME_MESSAGE_OBJ, gameMassage);
            bundle.putBoolean("isGameDetail", TextUtils.equals(this.isGameDetail, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            partyDressFragment.setArguments(bundle);
            F fA = getSupportFragmentManager().a();
            fA.a(R.id.fl_team_game, partyDressFragment);
            fA.b();
        } catch (Exception e2) {
            ToastUtils.showLongToast(this, R.string.imchat_party_enter_failed);
            finish();
            Messenger.getDefault().send(e2.toString(), ChatMessageToken.TOKEN_CHAT_UPLOAD_ENTER_TEAM_WRONG);
        }
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
        Messenger.getDefault().register(this, "token.refresh.group.list", RefreshMsg.class, new Action1<RefreshMsg>() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationPartyActivity.7
            @Override // rx.functions.Action1
            public void call(RefreshMsg refreshMsg) {
                ConversationPartyActivity.this.finish();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.IS_PARTY_CAPTAIN, Boolean.class, new Action1() { // from class: com.sandboxol.imchat.ui.acitivity.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18768a.isCaptain(((Boolean) obj).booleanValue());
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.EXIT_PARTY, new Action0() { // from class: com.sandboxol.imchat.ui.acitivity.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18769a.finish();
            }
        });
        Messenger.getDefault().register(this, MessageToken.REFRESH_QUICK_IN_TEXT, Integer.class, new Action1() { // from class: com.sandboxol.imchat.ui.acitivity.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18767a.a((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isCaptain(boolean z) {
        this.isCaptain = z;
        this.rlBottom.setVisibility(0);
        if (z) {
            this.vShadow.setVisibility(8);
            this.recyclerView.setVisibility(8);
            this.btnStart.setVisibility(0);
        } else {
            this.vShadow.setVisibility(0);
            this.recyclerView.setVisibility(0);
            this.btnStart.setVisibility(8);
        }
    }

    private void isPushMessage(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        if (!intent.getData().getScheme().equals("rong") || intent.getData().getQueryParameter("isFromPush") == null) {
            if (!RongIM.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED)) {
                enterFragment(this.mConversationType, this.mTargetId);
                this.isConnectSuccess = true;
                return;
            }
            LoadingDialog loadingDialog = this.mDialog;
            if (loadingDialog != null && !loadingDialog.isShowing() && !isFinishing()) {
                this.mDialog.show();
            }
            new Handler().postDelayed(new Runnable() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationPartyActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ConversationPartyActivity.this.isFinishing()) {
                        return;
                    }
                    ConversationPartyActivity.this.enterActivity();
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
            enterFragment(this.mConversationType, this.mTargetId);
            return;
        }
        LoadingDialog loadingDialog3 = this.mDialog;
        if (loadingDialog3 == null || loadingDialog3.isShowing() || isFinishing()) {
            return;
        }
        this.mDialog.show();
    }

    private void reconnect(String str) {
        RongIM.connect(str, new RongIMClient.ConnectCallback() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationPartyActivity.2
            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onDatabaseOpened(RongIMClient.DatabaseOpenStatus databaseOpenStatus) {
            }

            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onError(RongIMClient.ConnectionErrorCode connectionErrorCode) {
                Log.e(ConversationPartyActivity.TAG, "---onError--" + connectionErrorCode);
                if (ConversationPartyActivity.this.mDialog != null && !ConversationPartyActivity.this.isFinishing()) {
                    ConversationPartyActivity.this.mDialog.dismiss();
                }
                ConversationPartyActivity conversationPartyActivity = ConversationPartyActivity.this;
                conversationPartyActivity.enterFragment(conversationPartyActivity.mConversationType, ConversationPartyActivity.this.mTargetId);
                Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_CONNECT_CHAT);
            }

            @Override // io.rong.imlib.RongIMClient.ConnectCallback
            public void onSuccess(String str2) {
                Log.i(ConversationPartyActivity.TAG, "---onSuccess--" + str2);
                Log.e(ConversationPartyActivity.TAG, "ConversationActivity push");
                if (ConversationPartyActivity.this.mDialog != null && !ConversationPartyActivity.this.isFinishing()) {
                    ConversationPartyActivity.this.mDialog.dismiss();
                }
                ConversationPartyActivity conversationPartyActivity = ConversationPartyActivity.this;
                conversationPartyActivity.enterFragment(conversationPartyActivity.mConversationType, ConversationPartyActivity.this.mTargetId);
                Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_CONNECT_CHAT);
            }
        });
    }

    private void setActionBarTitle(Conversation.ConversationType conversationType, String str) {
        if (conversationType == null) {
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.CHATROOM)) {
            setTitle(this.title);
        } else {
            setTitle(R.string.de_actionbar_sub_defult);
        }
    }

    public /* synthetic */ void a(Integer num) {
        this.adapter.notifyChange(num.intValue());
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // com.sandboxol.imchat.ui.acitivity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getIntent() == null || getIntent().getData() == null) {
            return;
        }
        if (getIntent().getData().getQueryParameter("isTeam") != null) {
            new TeamDialog(this).setListener(new TeamDialog.OnTeamBackDialogClickListener() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationPartyActivity.6
                @Override // com.sandboxol.imchat.ui.dialog.TeamDialog.OnTeamBackDialogClickListener
                public void onClick() {
                    AppInfoCenter.newInstance().setNowParty(false);
                    ConversationPartyActivity.this.finish();
                    if (AccountCenter.newInstance().hasPassword.get().booleanValue() || AccountCenter.newInstance().userId.get().longValue() == 0 || TextUtils.isEmpty(ConversationPartyActivity.this.title) || ConversationPartyActivity.this.title.startsWith(AccountCenter.newInstance().nickName.get())) {
                        return;
                    }
                    IntentUtils.startPasswordSettingDialog(ConversationPartyActivity.this, false);
                }
            }).show();
        } else {
            sendBroadcast(new Intent(BroadcastConstant.RongCloudChatOnLeft));
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_chat) {
            RongIM.getInstance().quitChatRoom(this.mTargetId, new RongIMClient.OperationCallback() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationPartyActivity.4
                @Override // io.rong.imlib.RongIMClient.Callback
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.Callback
                public void onSuccess() {
                    if (ConversationPartyActivity.this.isShowing) {
                        ConversationPartyActivity conversationPartyActivity = ConversationPartyActivity.this;
                        PartyChatDialog.newInstance(conversationPartyActivity, conversationPartyActivity.mConversationType, ConversationPartyActivity.this.mTargetId, ConversationPartyActivity.this.isConnectSuccess, ConversationPartyActivity.this.isCaptain).show(ConversationPartyActivity.this.getSupportFragmentManager(), "111");
                    }
                }
            });
        } else if (view.getId() == R.id.btn_start) {
            Messenger.getDefault().sendNoMsg(ChatMessageToken.START_PARTY_GAME);
        }
    }

    @Override // com.sandboxol.imchat.ui.acitivity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @TargetApi(23)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.conversation_party);
        getWindow().setSoftInputMode(32);
        this.sp = getSharedPreferences("config", 0);
        this.mDialog = new LoadingDialog(this);
        this.fl_team_game = (FrameLayout) findViewById(R.id.fl_team_game);
        this.btnChat = (Button) findViewById(R.id.btn_chat);
        this.vShadow = findViewById(R.id.v_shadow);
        this.btnStart = (Button) findViewById(R.id.btn_start);
        this.recyclerView = (AutoHorizontalRecyclerView) findViewById(R.id.rv_quick_chat);
        this.rlBottom = (RelativeLayout) findViewById(R.id.rl_bottom);
        this.btnChat.setOnClickListener(this);
        this.btnStart.setOnClickListener(this);
        Intent intent = getIntent();
        if (intent == null || intent.getData() == null) {
            return;
        }
        initMessenger();
        this.mTargetId = intent.getData().getQueryParameter("targetId");
        this.mConversationType = Conversation.ConversationType.valueOf(intent.getData().getLastPathSegment().toUpperCase(Locale.US));
        this.title = intent.getData().getQueryParameter("title");
        this.isGameDetail = intent.getData().getQueryParameter("isGameDetail");
        setActionBarTitle(this.mConversationType, this.mTargetId);
        this.adapter = new QuickChatAdapter(this, this.mTargetId, QuickChatAdapter.TYPE_QUICK_CHAT_LIST);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAdapter(this.adapter);
        enterTeamGame(intent);
        isPushMessage(intent);
        RongIMLogic.initSendMessageListener(this);
        RongIMLogic.initUserPortraitClick();
        Messenger.getDefault().sendNoMsg("token.group.chat.action.bar");
        AppInfoCenter.newInstance().setNowParty(true);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        RongIM.getInstance().joinChatRoom(this.mTargetId, -1, new RongIMClient.OperationCallback() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationPartyActivity.8
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                ConversationPartyActivity conversationPartyActivity = ConversationPartyActivity.this;
                conversationPartyActivity.enterFragment(conversationPartyActivity.mConversationType, ConversationPartyActivity.this.mTargetId);
            }
        });
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
            new TeamDialog(this).setListener(new TeamDialog.OnTeamBackDialogClickListener() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationPartyActivity.5
                @Override // com.sandboxol.imchat.ui.dialog.TeamDialog.OnTeamBackDialogClickListener
                public void onClick() {
                    AppInfoCenter.newInstance().setNowParty(false);
                    ConversationPartyActivity.this.hintKbTwo();
                    ConversationPartyActivity.this.finish();
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

    @Override // com.sandboxol.imchat.ui.acitivity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isShowing = false;
        if (isFinishing()) {
            RongIM.getInstance().quitChatRoom(this.mTargetId, new RongIMClient.OperationCallback() { // from class: com.sandboxol.imchat.ui.acitivity.ConversationPartyActivity.3
                @Override // io.rong.imlib.RongIMClient.Callback
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.Callback
                public void onSuccess() {
                    ConversationPartyActivity.this.destroyPage();
                }
            });
        }
    }

    @Override // com.sandboxol.imchat.ui.acitivity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.isShowing = true;
    }
}

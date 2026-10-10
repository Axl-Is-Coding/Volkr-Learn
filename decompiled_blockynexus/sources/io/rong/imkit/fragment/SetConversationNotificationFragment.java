package io.rong.imkit.fragment;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.Event;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes5.dex */
public class SetConversationNotificationFragment extends BaseSettingFragment {
    private static final String TAG = "SetConversationNotificationFragment";

    public static SetConversationNotificationFragment newInstance() {
        return new SetConversationNotificationFragment();
    }

    @Override // io.rong.imkit.fragment.BaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected void initData() {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().getEventBus().register(this);
        }
        RongIM.getInstance().getConversationNotificationStatus(getConversationType(), getTargetId(), new RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus>() { // from class: io.rong.imkit.fragment.SetConversationNotificationFragment.1
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                SetConversationNotificationFragment setConversationNotificationFragment = SetConversationNotificationFragment.this;
                setConversationNotificationFragment.setSwitchBtnStatus(!setConversationNotificationFragment.getSwitchBtnStatus());
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Conversation.ConversationNotificationStatus conversationNotificationStatus) {
                if (conversationNotificationStatus != null) {
                    SetConversationNotificationFragment.this.setSwitchBtnStatus(conversationNotificationStatus != Conversation.ConversationNotificationStatus.DO_NOT_DISTURB);
                }
            }
        });
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().getEventBus().unregister(this);
        }
        super.onDestroy();
    }

    public void onEventMainThread(Event.ConversationNotificationEvent conversationNotificationEvent) {
        if (conversationNotificationEvent != null && conversationNotificationEvent.getTargetId().equals(getTargetId()) && conversationNotificationEvent.getConversationType().getValue() == getConversationType().getValue()) {
            setSwitchBtnStatus(conversationNotificationEvent.getStatus() == Conversation.ConversationNotificationStatus.NOTIFY);
        }
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected void onSettingItemClick(View view) {
        RLog.i(TAG, "onSettingItemClick, " + view.toString());
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected int setSwitchBtnVisibility() {
        return 0;
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected boolean setSwitchButtonEnabled() {
        return true;
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected String setTitle() {
        return getString(R.string.rc_setting_conversation_notify);
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected void toggleSwitch(boolean z) {
        Conversation.ConversationNotificationStatus conversationNotificationStatus = z ? Conversation.ConversationNotificationStatus.NOTIFY : Conversation.ConversationNotificationStatus.DO_NOT_DISTURB;
        if (getConversationType() == null || TextUtils.isEmpty(getTargetId())) {
            RLog.e(TAG, "SetConversationNotificationFragment Arguments is null");
        } else {
            RongIM.getInstance().setConversationNotificationStatus(getConversationType(), getTargetId(), conversationNotificationStatus, new RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus>() { // from class: io.rong.imkit.fragment.SetConversationNotificationFragment.2
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    SetConversationNotificationFragment setConversationNotificationFragment = SetConversationNotificationFragment.this;
                    setConversationNotificationFragment.setSwitchBtnStatus(!setConversationNotificationFragment.getSwitchBtnStatus());
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Conversation.ConversationNotificationStatus conversationNotificationStatus2) {
                    RLog.i(SetConversationNotificationFragment.TAG, "SetConversationNotificationFragment onSuccess--");
                }
            });
        }
    }
}

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
public class SetConversationToTopFragment extends BaseSettingFragment {
    private static String TAG = "SetConversationToTopFragment";

    @Override // io.rong.imkit.fragment.BaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected void initData() {
        if (RongContext.getInstance() != null) {
            RongContext.getInstance().getEventBus().register(this);
        }
        RongIM.getInstance().getConversation(getConversationType(), getTargetId(), new RongIMClient.ResultCallback<Conversation>() { // from class: io.rong.imkit.fragment.SetConversationToTopFragment.1
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Conversation conversation) {
                if (conversation != null) {
                    SetConversationToTopFragment.this.setSwitchBtnStatus(conversation.isTop());
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

    public void onEventMainThread(Event.ConversationTopEvent conversationTopEvent) {
        if (conversationTopEvent != null && conversationTopEvent.getTargetId().equals(getTargetId()) && conversationTopEvent.getConversationType().getValue() == getConversationType().getValue()) {
            setSwitchBtnStatus(conversationTopEvent.isTop());
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
        return getString(R.string.rc_setting_set_top);
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected void toggleSwitch(boolean z) {
        if (getConversationType() == null || TextUtils.isEmpty(getTargetId())) {
            RLog.e(TAG, "toggleSwitch() args is null");
        } else {
            RongIM.getInstance().setConversationToTop(getConversationType(), getTargetId(), z, null);
        }
    }
}

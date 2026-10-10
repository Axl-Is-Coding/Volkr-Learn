package io.rong.imkit.fragment;

import android.os.Message;
import android.view.View;
import android.widget.Toast;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.widget.AlterDialogFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes5.dex */
public class ClearConversationMsgFragment extends BaseSettingFragment implements AlterDialogFragment.AlterDialogBtnListener {
    private Conversation conversation;

    @Override // io.rong.imkit.fragment.BaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected void initData() {
    }

    @Override // io.rong.imkit.widget.AlterDialogFragment.AlterDialogBtnListener
    public void onDialogNegativeClick(AlterDialogFragment alterDialogFragment) {
        alterDialogFragment.dismiss();
    }

    @Override // io.rong.imkit.widget.AlterDialogFragment.AlterDialogBtnListener
    public void onDialogPositiveClick(AlterDialogFragment alterDialogFragment) {
        if (this.conversation == null) {
            return;
        }
        RongIM.getInstance().clearMessages(this.conversation.getConversationType(), this.conversation.getTargetId(), new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.fragment.ClearConversationMsgFragment.1
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                Toast.makeText(ClearConversationMsgFragment.this.getActivity(), ClearConversationMsgFragment.this.getString(R.string.rc_setting_clear_msg_fail), 0).show();
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Boolean bool) {
                Toast.makeText(ClearConversationMsgFragment.this.getActivity(), ClearConversationMsgFragment.this.getString(R.string.rc_setting_clear_msg_success), 0).show();
            }
        });
        RongIM.getInstance().clearTextMessageDraft(this.conversation.getConversationType(), this.conversation.getTargetId(), null);
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected void onSettingItemClick(View view) {
        this.conversation = new Conversation();
        this.conversation.setConversationType(getConversationType());
        this.conversation.setTargetId(getTargetId());
        AlterDialogFragment alterDialogFragmentNewInstance = AlterDialogFragment.newInstance(getString(R.string.rc_setting_name), getString(R.string.rc_setting_clear_msg_prompt), getString(R.string.rc_dialog_cancel), getString(R.string.rc_dialog_ok));
        alterDialogFragmentNewInstance.setOnAlterDialogBtnListener(this);
        alterDialogFragmentNewInstance.show(getFragmentManager());
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected int setSwitchBtnVisibility() {
        return 8;
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected boolean setSwitchButtonEnabled() {
        return false;
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected String setTitle() {
        return getString(R.string.rc_setting_clear_msg_name);
    }

    @Override // io.rong.imkit.fragment.BaseSettingFragment
    protected void toggleSwitch(boolean z) {
    }
}

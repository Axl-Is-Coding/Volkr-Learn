package io.rong.imkit.widget.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.Event;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.recallEdit.RecallEditCountDownCallBack;
import io.rong.imkit.recallEdit.RecallEditManager;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.UserInfo;
import io.rong.message.RecallNotificationMessage;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, messageContent = RecallNotificationMessage.class, showPortrait = false, showProgress = false, showSummaryWithName = false, showWarning = false)
public class RecallMessageItemProvider extends IContainerItemProvider.MessageProvider<RecallNotificationMessage> {
    public static final String TAG = "RecallMessageItemProvider";

    private static class RecallEditCountDownListener implements RecallEditCountDownCallBack {
        private WeakReference<ViewHolder> mHolder;

        public RecallEditCountDownListener(ViewHolder viewHolder) {
            this.mHolder = new WeakReference<>(viewHolder);
        }

        @Override // io.rong.imkit.recallEdit.RecallEditCountDownCallBack
        public void onFinish(String str) {
            ViewHolder viewHolder = this.mHolder.get();
            if (viewHolder == null || !str.equals(viewHolder.messageId)) {
                return;
            }
            viewHolder.editTextView.setVisibility(8);
        }
    }

    private static class ViewHolder {
        TextView contentTextView;
        TextView editTextView;
        String messageId;

        private ViewHolder() {
        }
    }

    private String getInformation(RecallNotificationMessage recallNotificationMessage) {
        String operatorId = recallNotificationMessage.getOperatorId();
        if (TextUtils.isEmpty(operatorId)) {
            RLog.e(TAG, "RecallMessageItemProvider bindView - operatorId is empty");
            return RongIM.getInstance().getApplicationContext().getString(R.string.rc_recalled_a_message);
        }
        if (recallNotificationMessage.isAdmin()) {
            return RongIM.getInstance().getApplicationContext().getString(R.string.rc_admin_recalled_message);
        }
        if (operatorId.equals(RongIM.getInstance().getCurrentUserId())) {
            return RongIM.getInstance().getApplicationContext().getString(R.string.rc_you_recalled_a_message);
        }
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(operatorId);
        if (userInfo == null || userInfo.getName() == null) {
            return operatorId + RongIM.getInstance().getApplicationContext().getString(R.string.rc_recalled_a_message);
        }
        return userInfo.getName() + RongIM.getInstance().getApplicationContext().getString(R.string.rc_recalled_a_message);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(RecallNotificationMessage recallNotificationMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_information_notification_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.contentTextView = (TextView) viewInflate.findViewById(R.id.rc_msg);
        viewHolder.contentTextView.setMovementMethod(LinkMovementMethod.getInstance());
        viewHolder.editTextView = (TextView) viewInflate.findViewById(R.id.rc_edit);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, RecallNotificationMessage recallNotificationMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemLongClick(View view, int i, RecallNotificationMessage recallNotificationMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, RecallNotificationMessage recallNotificationMessage, final UIMessage uIMessage) {
        Object tag = view.getTag();
        if (!(tag instanceof ViewHolder) || recallNotificationMessage == null) {
            return;
        }
        ViewHolder viewHolder = (ViewHolder) tag;
        viewHolder.contentTextView.setText(getInformation(recallNotificationMessage));
        long integer = view.getContext().getResources().getInteger(R.integer.rc_message_recall_edit_interval);
        long jCurrentTimeMillis = System.currentTimeMillis() - recallNotificationMessage.getRecallActionTime();
        if (!TextUtils.isEmpty(viewHolder.messageId)) {
            RecallEditManager.getInstance().cancelCountDown(viewHolder.messageId);
        }
        viewHolder.messageId = String.valueOf(uIMessage.getMessageId());
        if (recallNotificationMessage.getRecallActionTime() > 0) {
            long j = integer * 1000;
            if (jCurrentTimeMillis < j) {
                viewHolder.editTextView.setVisibility(0);
                RecallEditManager.getInstance().startCountDown(uIMessage.getMessage(), j - jCurrentTimeMillis, new RecallEditCountDownListener(viewHolder));
                viewHolder.editTextView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.provider.RecallMessageItemProvider.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        EventBus.getDefault().post(new Event.RecallMessageEditClickEvent(uIMessage.getMessage()));
                    }
                });
                return;
            }
        }
        viewHolder.editTextView.setVisibility(8);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, RecallNotificationMessage recallNotificationMessage) {
        if (recallNotificationMessage != null) {
            return new SpannableString(getInformation(recallNotificationMessage));
        }
        return null;
    }
}

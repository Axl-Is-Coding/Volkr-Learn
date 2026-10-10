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
import io.rong.imkit.R;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.message.InformationNotificationMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, messageContent = InformationNotificationMessage.class, showPortrait = false, showProgress = false, showSummaryWithName = false, showWarning = false)
public class InfoNotificationMsgItemProvider extends IContainerItemProvider.MessageProvider<InformationNotificationMessage> {

    private static class ViewHolder {
        TextView contentTextView;

        private ViewHolder() {
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(InformationNotificationMessage informationNotificationMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_information_notification_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.contentTextView = (TextView) viewInflate.findViewById(R.id.rc_msg);
        viewHolder.contentTextView.setMovementMethod(LinkMovementMethod.getInstance());
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, InformationNotificationMessage informationNotificationMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemLongClick(View view, int i, InformationNotificationMessage informationNotificationMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, InformationNotificationMessage informationNotificationMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (informationNotificationMessage == null || TextUtils.isEmpty(informationNotificationMessage.getMessage())) {
            return;
        }
        viewHolder.contentTextView.setText(informationNotificationMessage.getMessage());
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, InformationNotificationMessage informationNotificationMessage) {
        if (informationNotificationMessage == null || TextUtils.isEmpty(informationNotificationMessage.getMessage())) {
            return null;
        }
        return new SpannableString(informationNotificationMessage.getMessage());
    }
}

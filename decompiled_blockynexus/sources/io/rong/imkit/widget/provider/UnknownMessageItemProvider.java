package io.rong.imkit.widget.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UnknownMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, messageContent = UnknownMessage.class, showPortrait = false, showSummaryWithName = false, showWarning = false)
public class UnknownMessageItemProvider extends IContainerItemProvider.MessageProvider<MessageContent> {

    private static class ViewHolder {
        TextView contentTextView;

        private ViewHolder() {
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, MessageContent messageContent, UIMessage uIMessage) {
        ((ViewHolder) view.getTag()).contentTextView.setText(R.string.rc_message_unknown);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, MessageContent messageContent) {
        return new SpannableString(context.getResources().getString(R.string.rc_message_unknown));
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(MessageContent messageContent) {
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
    public void onItemClick(View view, int i, MessageContent messageContent, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemLongClick(View view, int i, MessageContent messageContent, UIMessage uIMessage) {
    }
}

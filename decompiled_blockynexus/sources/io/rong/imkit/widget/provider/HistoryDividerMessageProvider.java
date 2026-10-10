package io.rong.imkit.widget.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.message.HistoryDividerMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, messageContent = HistoryDividerMessage.class, showPortrait = false, showProgress = false, showSummaryWithName = false)
public class HistoryDividerMessageProvider extends IContainerItemProvider.MessageProvider<HistoryDividerMessage> {

    private static class ViewHolder {
        TextView contentTextView;

        private ViewHolder() {
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(HistoryDividerMessage historyDividerMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_new_message_divider, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.contentTextView = (TextView) viewInflate.findViewById(R.id.tv_divider_message);
        viewHolder.contentTextView.setMovementMethod(LinkMovementMethod.getInstance());
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, HistoryDividerMessage historyDividerMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemLongClick(View view, int i, HistoryDividerMessage historyDividerMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, HistoryDividerMessage historyDividerMessage, UIMessage uIMessage) {
        ((ViewHolder) view.getTag()).contentTextView.setText(historyDividerMessage.getContent());
    }
}

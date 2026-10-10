package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Message;
import io.rong.message.RichContentMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = RichContentMessage.class, showReadState = true)
public class RichContentMessageItemProvider extends IContainerItemProvider.MessageProvider<RichContentMessage> {

    private static class ViewHolder {
        TextView content;
        AsyncImageView img;
        RelativeLayout mLayout;
        TextView title;

        private ViewHolder() {
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(RichContentMessage richContentMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_rich_content_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.title = (TextView) viewInflate.findViewById(R.id.rc_title);
        viewHolder.content = (TextView) viewInflate.findViewById(R.id.rc_content);
        viewHolder.img = (AsyncImageView) viewInflate.findViewById(R.id.rc_img);
        viewHolder.mLayout = (RelativeLayout) viewInflate.findViewById(R.id.rc_layout);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, RichContentMessage richContentMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.title.setText(richContentMessage.getTitle());
        viewHolder.content.setText(richContentMessage.getContent());
        if (richContentMessage.getImgUrl() != null) {
            viewHolder.img.setResource(richContentMessage.getImgUrl(), 0);
        }
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.mLayout.setBackgroundResource(R.drawable.rc_ic_bubble_right_file);
        } else {
            viewHolder.mLayout.setBackgroundResource(R.drawable.rc_ic_bubble_left_file);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, RichContentMessage richContentMessage, UIMessage uIMessage) {
        Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
        intent.addFlags(268435456);
        intent.putExtra("url", richContentMessage.getUrl());
        intent.setPackage(view.getContext().getPackageName());
        view.getContext().startActivity(intent);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, RichContentMessage richContentMessage) {
        return new SpannableString(context.getResources().getString(R.string.rc_message_content_rich_text));
    }
}

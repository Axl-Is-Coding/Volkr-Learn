package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.message.PublicServiceRichContentMessage;
import io.rong.message.RichContentItem;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, messageContent = PublicServiceRichContentMessage.class, showPortrait = false, showSummaryWithName = false)
public class PublicServiceRichContentMessageProvider extends IContainerItemProvider.MessageProvider<PublicServiceRichContentMessage> {
    private final String TAG = PublicServiceRichContentMessageProvider.class.getSimpleName();

    public static class ViewHolder {
        public TextView description;
        public AsyncImageView imageView;
        public TextView time;
        public TextView title;
    }

    private String formatDate(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(PublicServiceRichContentMessage publicServiceRichContentMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_public_service_rich_content_message, (ViewGroup) null);
        viewHolder.title = (TextView) viewInflate.findViewById(R.id.rc_title);
        viewHolder.time = (TextView) viewInflate.findViewById(R.id.rc_time);
        viewHolder.description = (TextView) viewInflate.findViewById(R.id.rc_content);
        viewHolder.imageView = (AsyncImageView) viewInflate.findViewById(R.id.rc_img);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(RongUtils.getScreenWidth() - RongUtils.dip2px(32.0f), -2));
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, PublicServiceRichContentMessage publicServiceRichContentMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        PublicServiceRichContentMessage publicServiceRichContentMessage2 = (PublicServiceRichContentMessage) uIMessage.getContent();
        if (publicServiceRichContentMessage2.getMessage() != null) {
            viewHolder.title.setText(publicServiceRichContentMessage2.getMessage().getTitle());
            viewHolder.description.setText(publicServiceRichContentMessage2.getMessage().getDigest());
            viewHolder.imageView.setResource(publicServiceRichContentMessage2.getMessage().getImageUrl(), 0);
        }
        viewHolder.time.setText(formatDate(uIMessage.getReceivedTime(), "MM月dd日 HH:mm"));
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, PublicServiceRichContentMessage publicServiceRichContentMessage, UIMessage uIMessage) {
        String url;
        RichContentItem message = publicServiceRichContentMessage.getMessage();
        if (message != null) {
            url = message.getUrl();
        } else {
            RLog.e(this.TAG, "onItemClick RichContentItem is Null");
            url = "";
        }
        Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
        intent.setPackage(view.getContext().getPackageName());
        intent.putExtra("url", url);
        view.getContext().startActivity(intent);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, PublicServiceRichContentMessage publicServiceRichContentMessage) {
        if (publicServiceRichContentMessage != null && publicServiceRichContentMessage.getMessage() != null) {
            return new SpannableString(publicServiceRichContentMessage.getMessage().getTitle());
        }
        RLog.e(this.TAG, "The content of the message is null! Check your message content!");
        return new SpannableString("");
    }
}

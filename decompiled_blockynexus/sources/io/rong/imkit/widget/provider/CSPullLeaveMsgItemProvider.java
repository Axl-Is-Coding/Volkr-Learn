package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.activity.CSLeaveMessageActivity;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.CustomServiceConfig;
import io.rong.message.CSPullLeaveMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, messageContent = CSPullLeaveMessage.class, showPortrait = false, showProgress = false, showSummaryWithName = false, showWarning = false)
public class CSPullLeaveMsgItemProvider extends IContainerItemProvider.MessageProvider<CSPullLeaveMessage> {

    class Clickable extends ClickableSpan implements View.OnClickListener {
        private final View.OnClickListener mListener;

        public Clickable(View.OnClickListener onClickListener) {
            this.mListener = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.view.View.OnClickListener
        public void onClick(View view) {
            this.mListener.onClick(view);
        }
    }

    private static class ViewHolder {
        TextView contentTextView;

        private ViewHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLeaveMessageClicked(View view, UIMessage uIMessage) {
        if (uIMessage.getCsConfig() != null && uIMessage.getCsConfig().leaveMessageConfigType.equals(CustomServiceConfig.CSLeaveMessageType.WEB)) {
            Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
            intent.setPackage(view.getContext().getPackageName());
            intent.addFlags(268435456);
            if (uIMessage.getCsConfig().uri != null) {
                intent.putExtra("url", uIMessage.getCsConfig().uri.toString());
            }
            view.getContext().startActivity(intent);
            return;
        }
        if (uIMessage.getCsConfig() != null) {
            Intent intent2 = new Intent(view.getContext(), (Class<?>) CSLeaveMessageActivity.class);
            intent2.putExtra("targetId", uIMessage.getTargetId());
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("itemList", uIMessage.getCsConfig().leaveMessageNativeInfo);
            intent2.putExtras(bundle);
            view.getContext().startActivity(intent2);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(CSPullLeaveMessage cSPullLeaveMessage) {
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
    public void onItemClick(View view, int i, CSPullLeaveMessage cSPullLeaveMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemLongClick(View view, int i, CSPullLeaveMessage cSPullLeaveMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, CSPullLeaveMessage cSPullLeaveMessage, final UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (cSPullLeaveMessage != null) {
            String content = cSPullLeaveMessage.getContent();
            if (TextUtils.isEmpty(content)) {
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = view.getResources().getString(R.string.rc_cs_leave_message);
            int iIndexOf = content.indexOf(string);
            if (iIndexOf >= 0) {
                SpannableString spannableString = new SpannableString(content.substring(iIndexOf, string.length() + iIndexOf));
                spannableString.setSpan(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.rc_voice_color)), 0, spannableString.length(), 33);
                spannableString.setSpan(new Clickable(new View.OnClickListener() { // from class: io.rong.imkit.widget.provider.CSPullLeaveMsgItemProvider.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        CSPullLeaveMsgItemProvider.this.onLeaveMessageClicked(view2, uIMessage);
                    }
                }), 0, spannableString.length(), 17);
                String strSubstring = content.substring(0, iIndexOf);
                String strSubstring2 = content.substring(iIndexOf + string.length());
                if (strSubstring.endsWith(" ")) {
                    spannableStringBuilder.append((CharSequence) strSubstring).append((CharSequence) spannableString).append((CharSequence) strSubstring2);
                } else {
                    spannableStringBuilder.append((CharSequence) strSubstring).append((CharSequence) " ").append((CharSequence) spannableString).append((CharSequence) strSubstring2);
                }
            } else {
                spannableStringBuilder.append((CharSequence) content);
            }
            viewHolder.contentTextView.setText(spannableStringBuilder);
        }
    }
}

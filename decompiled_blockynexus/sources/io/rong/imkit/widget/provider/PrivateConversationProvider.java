package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.resend.ResendManager;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utils.RongDateUtils;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import io.rong.message.RecallNotificationMessage;

/* JADX INFO: loaded from: classes5.dex */
@ConversationProviderTag(conversationType = "private", portraitPosition = 1)
public class PrivateConversationProvider implements IContainerItemProvider.ConversationProvider<UIConversation> {
    private static final String TAG = "PrivateConversationProvider";

    protected class ViewHolder {
        public TextView content;
        public ImageView notificationBlockImage;
        public ImageView readStatus;
        public TextView time;
        public TextView title;

        protected ViewHolder() {
        }
    }

    private void handleCommonContent(final ViewHolder viewHolder, UIConversation uIConversation) {
        if (viewHolder.content.getWidth() <= 60 || uIConversation.getConversationContent() == null) {
            final Spannable conversationContent = uIConversation.getConversationContent();
            viewHolder.content.post(new Runnable() { // from class: io.rong.imkit.widget.provider.PrivateConversationProvider.3
                @Override // java.lang.Runnable
                public void run() {
                    CharSequence charSequence;
                    if (viewHolder.content.getWidth() <= 60 || (charSequence = conversationContent) == null) {
                        viewHolder.content.setText(conversationContent);
                    } else {
                        viewHolder.content.setText(TextUtils.ellipsize(charSequence, viewHolder.content.getPaint(), viewHolder.content.getWidth() - 60, TextUtils.TruncateAt.END), TextView.BufferType.SPANNABLE);
                    }
                }
            });
        } else {
            viewHolder.content.setText(TextUtils.ellipsize(uIConversation.getConversationContent(), viewHolder.content.getPaint(), viewHolder.content.getWidth() - 60, TextUtils.TruncateAt.END), TextView.BufferType.SPANNABLE);
        }
    }

    private void handleDraftContent(final ViewHolder viewHolder, final View view, final UIConversation uIConversation) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final String string = view.getContext().getString(R.string.rc_message_content_draft);
        if (viewHolder.content.getWidth() <= 60) {
            viewHolder.content.post(new Runnable() { // from class: io.rong.imkit.widget.provider.PrivateConversationProvider.2
                @Override // java.lang.Runnable
                public void run() {
                    if (viewHolder.content.getWidth() > 60) {
                        CharSequence charSequenceEllipsize = TextUtils.ellipsize(string + " " + uIConversation.getDraft(), viewHolder.content.getPaint(), viewHolder.content.getWidth() - 60, TextUtils.TruncateAt.END);
                        SpannableString spannableString = new SpannableString(charSequenceEllipsize);
                        int length = string.length();
                        if (length > charSequenceEllipsize.length()) {
                            length = charSequenceEllipsize.length();
                        }
                        spannableString.setSpan(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.rc_draft_color)), 0, length, 33);
                        spannableStringBuilder.append((CharSequence) spannableString);
                    } else {
                        SpannableString spannableString2 = new SpannableString(string + " " + uIConversation.getDraft());
                        spannableString2.setSpan(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.rc_draft_color)), 0, string.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString2);
                    }
                    AndroidEmoji.ensure(spannableStringBuilder);
                    viewHolder.content.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                }
            });
            return;
        }
        CharSequence charSequenceEllipsize = TextUtils.ellipsize(string + " " + uIConversation.getDraft(), viewHolder.content.getPaint(), viewHolder.content.getWidth() - 60, TextUtils.TruncateAt.END);
        SpannableString spannableString = new SpannableString(charSequenceEllipsize);
        int length = string.length();
        if (length > charSequenceEllipsize.length()) {
            length = charSequenceEllipsize.length();
        }
        spannableString.setSpan(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.rc_draft_color)), 0, length, 33);
        spannableStringBuilder.append((CharSequence) spannableString);
        AndroidEmoji.ensure(spannableStringBuilder);
        viewHolder.content.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    private void handleMentionedContent(final ViewHolder viewHolder, final View view, final UIConversation uIConversation) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final String string = view.getContext().getString(R.string.rc_message_content_mentioned);
        if (viewHolder.content.getWidth() <= 60) {
            viewHolder.content.post(new Runnable() { // from class: io.rong.imkit.widget.provider.PrivateConversationProvider.1
                @Override // java.lang.Runnable
                public void run() {
                    if (viewHolder.content.getWidth() > 60) {
                        CharSequence charSequenceEllipsize = TextUtils.ellipsize(string + " " + ((Object) uIConversation.getConversationContent()), viewHolder.content.getPaint(), viewHolder.content.getWidth() - 40, TextUtils.TruncateAt.END);
                        SpannableString spannableString = new SpannableString(charSequenceEllipsize);
                        int length = string.length();
                        if (length > charSequenceEllipsize.length()) {
                            length = charSequenceEllipsize.length();
                        }
                        spannableString.setSpan(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.rc_mentioned_color)), 0, length, 33);
                        spannableStringBuilder.append((CharSequence) spannableString);
                    } else {
                        SpannableString spannableString2 = new SpannableString(string + " " + ((Object) uIConversation.getConversationContent()));
                        spannableString2.setSpan(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.rc_mentioned_color)), 0, string.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString2);
                    }
                    AndroidEmoji.ensure(spannableStringBuilder);
                    viewHolder.content.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                }
            });
            return;
        }
        CharSequence charSequenceEllipsize = TextUtils.ellipsize(string + " " + ((Object) uIConversation.getConversationContent()), viewHolder.content.getPaint(), viewHolder.content.getWidth() - 60, TextUtils.TruncateAt.END);
        SpannableString spannableString = new SpannableString(charSequenceEllipsize);
        int length = string.length();
        if (length > charSequenceEllipsize.length()) {
            length = charSequenceEllipsize.length();
        }
        spannableString.setSpan(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.rc_mentioned_color)), 0, length, 33);
        spannableStringBuilder.append((CharSequence) spannableString);
        AndroidEmoji.ensure(spannableStringBuilder);
        viewHolder.content.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public Uri getPortraitUri(String str) {
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(str);
        if (userInfo == null) {
            return null;
        }
        return userInfo.getPortraitUri();
    }

    public Spannable getSummary(UIConversation uIConversation) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public String getTitle(String str) {
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(str);
        return userInfo == null ? str : userInfo.getName();
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_base_conversation, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.title = (TextView) viewInflate.findViewById(R.id.rc_conversation_title);
        viewHolder.time = (TextView) viewInflate.findViewById(R.id.rc_conversation_time);
        viewHolder.content = (TextView) viewInflate.findViewById(R.id.rc_conversation_content);
        viewHolder.notificationBlockImage = (ImageView) viewInflate.findViewById(R.id.rc_conversation_msg_block);
        viewHolder.readStatus = (ImageView) viewInflate.findViewById(R.id.rc_conversation_status);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public void bindView(View view, int i, UIConversation uIConversation) {
        boolean z;
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (uIConversation == null) {
            viewHolder.title.setText((CharSequence) null);
            viewHolder.time.setText((CharSequence) null);
            viewHolder.content.setText((CharSequence) null);
            return;
        }
        viewHolder.title.setText(uIConversation.getUIConversationTitle());
        viewHolder.time.setText(RongDateUtils.getConversationListFormatDate(uIConversation.getUIConversationTime(), view.getContext()));
        if (!TextUtils.isEmpty(uIConversation.getDraft()) || uIConversation.getMentionedFlag()) {
            if (uIConversation.getMentionedFlag()) {
                handleMentionedContent(viewHolder, view, uIConversation);
            } else {
                handleDraftContent(viewHolder, view, uIConversation);
            }
            viewHolder.readStatus.setVisibility(8);
        } else {
            try {
                z = view.getResources().getBoolean(R.bool.rc_read_receipt);
            } catch (Resources.NotFoundException e2) {
                RLog.e(TAG, "rc_read_receipt not configure in rc_config.xml");
                e2.printStackTrace();
                z = false;
            }
            if (z) {
                if (uIConversation.getSentStatus() == Message.SentStatus.READ && uIConversation.getConversationSenderId().equals(RongIM.getInstance().getCurrentUserId()) && !(uIConversation.getMessageContent() instanceof RecallNotificationMessage)) {
                    viewHolder.readStatus.setVisibility(0);
                } else {
                    viewHolder.readStatus.setVisibility(8);
                }
            }
            handleCommonContent(viewHolder, uIConversation);
        }
        ProviderTag messageProviderTag = (RongContext.getInstance() == null || uIConversation.getMessageContent() == null) ? null : RongContext.getInstance().getMessageProviderTag(uIConversation.getMessageContent().getClass());
        if (uIConversation.getSentStatus() == null || !((uIConversation.getSentStatus() == Message.SentStatus.FAILED || uIConversation.getSentStatus() == Message.SentStatus.SENDING) && messageProviderTag != null && messageProviderTag.showWarning() && uIConversation.getConversationSenderId() != null && uIConversation.getConversationSenderId().equals(RongIM.getInstance().getCurrentUserId()) && TextUtils.isEmpty(uIConversation.getDraft()))) {
            viewHolder.content.setCompoundDrawables(null, null, null, null);
        } else {
            int width = BitmapFactory.decodeResource(view.getResources(), R.drawable.rc_conversation_list_msg_send_failure).getWidth();
            Drawable drawable = (uIConversation.getSentStatus() == Message.SentStatus.FAILED && TextUtils.isEmpty(uIConversation.getDraft())) ? ResendManager.getInstance().needResend(uIConversation.getLatestMessageId()) ? view.getContext().getResources().getDrawable(R.drawable.rc_conversation_list_msg_sending) : view.getContext().getResources().getDrawable(R.drawable.rc_conversation_list_msg_send_failure) : (uIConversation.getSentStatus() == Message.SentStatus.SENDING && TextUtils.isEmpty(uIConversation.getDraft())) ? view.getContext().getResources().getDrawable(R.drawable.rc_conversation_list_msg_sending) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, width, width);
                viewHolder.content.setCompoundDrawablePadding(10);
                viewHolder.content.setCompoundDrawables(drawable, null, null, null);
            }
        }
        Conversation.ConversationNotificationStatus notificationStatus = uIConversation.getNotificationStatus();
        if (notificationStatus == null || !notificationStatus.equals(Conversation.ConversationNotificationStatus.DO_NOT_DISTURB)) {
            viewHolder.notificationBlockImage.setVisibility(8);
        } else {
            viewHolder.notificationBlockImage.setVisibility(0);
        }
    }
}

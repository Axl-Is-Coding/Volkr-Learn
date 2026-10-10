package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.utils.TextViewUtils;
import io.rong.imkit.widget.ILinkClickListener;
import io.rong.imkit.widget.LinkTextViewMovementMethod;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.TextMessage;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = TextMessage.class, showReadState = true)
public class TextMessageItemProvider extends IContainerItemProvider.MessageProvider<TextMessage> {
    private static final String TAG = "TextMessageItemProvider";
    private static final int TAG_MESSAGE_ID = -1;

    private static class DestructListener implements RongIMClient.DestructCountDownTimerListener {
        private WeakReference<ViewHolder> mHolder;
        private UIMessage mUIMessage;

        public DestructListener(ViewHolder viewHolder, UIMessage uIMessage) {
            this.mHolder = new WeakReference<>(viewHolder);
            this.mUIMessage = uIMessage;
        }

        @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
        public void onStop(String str) {
            ViewHolder viewHolder;
            if (this.mUIMessage.getUId().equals(str) && (viewHolder = this.mHolder.get()) != null && str.equals(viewHolder.receiverFire.getTag())) {
                viewHolder.receiverFireText.setVisibility(8);
                viewHolder.receiverFireImg.setVisibility(0);
                this.mUIMessage.setUnDestructTime(null);
            }
        }

        @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
        public void onTick(long j, String str) {
            ViewHolder viewHolder;
            if (this.mUIMessage.getUId().equals(str) && (viewHolder = this.mHolder.get()) != null && str.equals(viewHolder.receiverFire.getTag())) {
                viewHolder.receiverFireText.setVisibility(0);
                viewHolder.receiverFireImg.setVisibility(8);
                String strValueOf = String.valueOf(Math.max(j, 1L));
                viewHolder.receiverFireText.setText(strValueOf);
                this.mUIMessage.setUnDestructTime(strValueOf);
            }
        }

        public void setHolder(ViewHolder viewHolder) {
            this.mHolder = new WeakReference<>(viewHolder);
        }

        public void setUIMessage(UIMessage uIMessage) {
            this.mUIMessage = uIMessage;
        }
    }

    private static class ViewHolder {
        TextView message;
        FrameLayout receiverFire;
        ImageView receiverFireImg;
        TextView receiverFireText;
        FrameLayout sendFire;
        TextView unRead;

        private ViewHolder() {
        }
    }

    private void bindFireView(View view, int i, TextMessage textMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.sendFire.setVisibility(0);
            viewHolder.receiverFire.setVisibility(8);
            viewHolder.unRead.setVisibility(8);
            viewHolder.message.setVisibility(0);
            processTextView(view, i, textMessage, uIMessage, viewHolder.message);
            return;
        }
        viewHolder.sendFire.setVisibility(8);
        viewHolder.receiverFire.setVisibility(0);
        DestructManager.getInstance().addListener(uIMessage.getUId(), new DestructListener(viewHolder, uIMessage), TAG);
        if (uIMessage.getMessage().getReadTime() <= 0) {
            viewHolder.unRead.setVisibility(0);
            viewHolder.message.setVisibility(8);
            viewHolder.receiverFireText.setVisibility(8);
            viewHolder.receiverFireImg.setVisibility(0);
            return;
        }
        viewHolder.unRead.setVisibility(8);
        viewHolder.message.setVisibility(0);
        viewHolder.receiverFireText.setVisibility(0);
        viewHolder.receiverFireText.setText(TextUtils.isEmpty(uIMessage.getUnDestructTime()) ? DestructManager.getInstance().getUnFinishTime(uIMessage.getUId()) : uIMessage.getUnDestructTime());
        viewHolder.receiverFireImg.setVisibility(8);
        processTextView(view, i, textMessage, uIMessage, viewHolder.message);
        DestructManager.getInstance().startDestruct(uIMessage.getMessage());
    }

    private void processTextView(final View view, int i, TextMessage textMessage, final UIMessage uIMessage, final TextView textView) {
        textView.setTag(Integer.valueOf(uIMessage.getMessageId()));
        if (uIMessage.getContentSpannable() == null) {
            uIMessage.setContentSpannable(TextViewUtils.getSpannable(textMessage.getContent(), new TextViewUtils.RegularCallBack() { // from class: io.rong.imkit.widget.provider.TextMessageItemProvider.1
                @Override // io.rong.imkit.utils.TextViewUtils.RegularCallBack
                public void finish(final SpannableStringBuilder spannableStringBuilder) {
                    if (textView.getTag().equals(Integer.valueOf(uIMessage.getMessageId()))) {
                        textView.post(new Runnable() { // from class: io.rong.imkit.widget.provider.TextMessageItemProvider.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                uIMessage.setContentSpannable(spannableStringBuilder);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                textView.setText(uIMessage.getContentSpannable());
                            }
                        });
                    }
                }
            }));
        }
        textView.setText(uIMessage.getContentSpannable());
        textView.setMovementMethod(new LinkTextViewMovementMethod(new ILinkClickListener() { // from class: io.rong.imkit.widget.provider.TextMessageItemProvider.2
            @Override // io.rong.imkit.widget.ILinkClickListener
            public boolean onLinkClick(String str) {
                RongIM.ConversationBehaviorListener conversationBehaviorListener = RongContext.getInstance().getConversationBehaviorListener();
                RongIM.ConversationClickListener conversationClickListener = RongContext.getInstance().getConversationClickListener();
                boolean zOnMessageLinkClick = conversationBehaviorListener != null ? conversationBehaviorListener.onMessageLinkClick(view.getContext(), str) : conversationClickListener != null ? conversationClickListener.onMessageLinkClick(view.getContext(), str, uIMessage.getMessage()) : false;
                if (!(conversationBehaviorListener == null && conversationClickListener == null) && zOnMessageLinkClick) {
                    return zOnMessageLinkClick;
                }
                String lowerCase = str.toLowerCase();
                if (!lowerCase.startsWith("http") && !lowerCase.startsWith("https")) {
                    return zOnMessageLinkClick;
                }
                Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
                intent.setPackage(view.getContext().getPackageName());
                intent.putExtra("url", str);
                view.getContext().startActivity(intent);
                return true;
            }
        }));
        textView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.provider.TextMessageItemProvider.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                view.performClick();
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.widget.provider.TextMessageItemProvider.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return view.performLongClick();
            }
        });
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(TextMessage textMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_destruct_text_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.message = (TextView) viewInflate.findViewById(android.R.id.text1);
        viewHolder.unRead = (TextView) viewInflate.findViewById(R.id.tv_unread);
        viewHolder.sendFire = (FrameLayout) viewInflate.findViewById(R.id.fl_send_fire);
        viewHolder.receiverFire = (FrameLayout) viewInflate.findViewById(R.id.fl_receiver_fire);
        viewHolder.receiverFireImg = (ImageView) viewInflate.findViewById(R.id.iv_receiver_fire);
        viewHolder.receiverFireText = (TextView) viewInflate.findViewById(R.id.tv_receiver_fire);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, TextMessage textMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.receiverFire.setTag(uIMessage.getUId());
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_right);
        } else {
            viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_left);
        }
        if (textMessage.isDestruct()) {
            bindFireView(view, i, textMessage, uIMessage);
            return;
        }
        viewHolder.sendFire.setVisibility(8);
        viewHolder.receiverFire.setVisibility(8);
        viewHolder.unRead.setVisibility(8);
        viewHolder.message.setVisibility(0);
        processTextView(view, i, textMessage, uIMessage, viewHolder.message);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, TextMessage textMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (textMessage == null || !textMessage.isDestruct() || uIMessage.getMessage().getReadTime() > 0) {
            return;
        }
        viewHolder.unRead.setVisibility(8);
        viewHolder.message.setVisibility(0);
        viewHolder.receiverFireText.setVisibility(0);
        viewHolder.receiverFireImg.setVisibility(8);
        processTextView(view, i, textMessage, uIMessage, viewHolder.message);
        DestructManager.getInstance().startDestruct(uIMessage.getMessage());
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, TextMessage textMessage) {
        if (textMessage == null) {
            return null;
        }
        if (textMessage.isDestruct()) {
            return new SpannableString(context.getString(R.string.rc_message_content_burn));
        }
        String content = textMessage.getContent();
        if (content == null) {
            return null;
        }
        if (content.length() > 100) {
            content = content.substring(0, 100);
        }
        return new SpannableString(AndroidEmoji.ensure(content));
    }
}

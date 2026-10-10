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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.utils.TextViewUtils;
import io.rong.imkit.widget.ILinkClickListener;
import io.rong.imkit.widget.LinkTextViewMovementMethod;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.TextMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class EvaluateTextMessageItemProvider extends IContainerItemProvider.MessageProvider<TextMessage> {
    private static final String TAG = "EvaluateTextMessageItemProvider";

    private static class ViewHolder {
        ImageView iv_complete;
        ImageView iv_no;
        ImageView iv_yes;
        RelativeLayout layout_praise;
        boolean longClick;
        TextView message;
        TextView tv_prompt;

        private ViewHolder() {
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(TextMessage textMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_text_message_evaluate, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.message = (TextView) viewInflate.findViewById(R.id.evaluate_text);
        viewHolder.tv_prompt = (TextView) viewInflate.findViewById(R.id.tv_prompt);
        viewHolder.iv_yes = (ImageView) viewInflate.findViewById(R.id.iv_yes);
        viewHolder.iv_no = (ImageView) viewInflate.findViewById(R.id.iv_no);
        viewHolder.iv_complete = (ImageView) viewInflate.findViewById(R.id.iv_complete);
        viewHolder.layout_praise = (RelativeLayout) viewInflate.findViewById(R.id.layout_praise);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, TextMessage textMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(final View view, final int i, final TextMessage textMessage, final UIMessage uIMessage) {
        final ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            view.setBackgroundResource(R.drawable.rc_ic_bubble_right);
        } else {
            view.setBackgroundResource(R.drawable.rc_ic_bubble_left);
        }
        if (uIMessage.getEvaluated()) {
            viewHolder.iv_yes.setVisibility(8);
            viewHolder.iv_no.setVisibility(8);
            viewHolder.iv_complete.setVisibility(0);
            viewHolder.tv_prompt.setText("感谢您的评价");
        } else {
            viewHolder.iv_yes.setVisibility(0);
            viewHolder.iv_no.setVisibility(0);
            viewHolder.iv_complete.setVisibility(8);
            viewHolder.tv_prompt.setText("您对我的回答");
        }
        viewHolder.iv_yes.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.provider.EvaluateTextMessageItemProvider.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String strOptString;
                String extra = ((TextMessage) uIMessage.getContent()).getExtra();
                if (TextUtils.isEmpty(extra)) {
                    strOptString = "";
                } else {
                    try {
                        strOptString = new JSONObject(extra).optString("sid");
                    } catch (JSONException e2) {
                        RLog.e(EvaluateTextMessageItemProvider.TAG, "bindView", e2);
                        strOptString = "";
                    }
                }
                RongIMClient.getInstance().evaluateCustomService(uIMessage.getSenderUserId(), true, strOptString);
                viewHolder.iv_complete.setVisibility(0);
                viewHolder.iv_yes.setVisibility(8);
                viewHolder.iv_no.setVisibility(8);
                viewHolder.tv_prompt.setText("感谢您的评价");
                uIMessage.setEvaluated(true);
            }
        });
        viewHolder.iv_no.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.provider.EvaluateTextMessageItemProvider.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String strOptString;
                String extra = ((TextMessage) uIMessage.getContent()).getExtra();
                if (TextUtils.isEmpty(extra)) {
                    strOptString = "";
                } else {
                    try {
                        strOptString = new JSONObject(extra).optString("sid");
                    } catch (JSONException e2) {
                        RLog.e(EvaluateTextMessageItemProvider.TAG, "bindView", e2);
                        strOptString = "";
                    }
                }
                RongIMClient.getInstance().evaluateCustomService(uIMessage.getSenderUserId(), false, strOptString);
                viewHolder.iv_complete.setVisibility(0);
                viewHolder.iv_yes.setVisibility(8);
                viewHolder.iv_no.setVisibility(8);
                viewHolder.tv_prompt.setText("感谢您的评价");
                uIMessage.setEvaluated(true);
            }
        });
        final TextView textView = viewHolder.message;
        if (uIMessage.getContentSpannable() == null) {
            uIMessage.setContentSpannable(TextViewUtils.getSpannable(textMessage.getContent(), new TextViewUtils.RegularCallBack() { // from class: io.rong.imkit.widget.provider.EvaluateTextMessageItemProvider.3
                @Override // io.rong.imkit.utils.TextViewUtils.RegularCallBack
                public void finish(SpannableStringBuilder spannableStringBuilder) {
                    uIMessage.setContentSpannable(spannableStringBuilder);
                    if (textView.getTag().equals(Integer.valueOf(uIMessage.getMessageId()))) {
                        textView.post(new Runnable() { // from class: io.rong.imkit.widget.provider.EvaluateTextMessageItemProvider.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                textView.setText(uIMessage.getContentSpannable());
                            }
                        });
                    }
                }
            }));
        }
        textView.setText(uIMessage.getContentSpannable());
        viewHolder.message.setClickable(true);
        viewHolder.message.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.provider.EvaluateTextMessageItemProvider.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        viewHolder.message.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.widget.provider.EvaluateTextMessageItemProvider.5
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                EvaluateTextMessageItemProvider.this.onItemLongClick(view, i, textMessage, uIMessage);
                return false;
            }
        });
        viewHolder.message.setMovementMethod(new LinkTextViewMovementMethod(new ILinkClickListener() { // from class: io.rong.imkit.widget.provider.EvaluateTextMessageItemProvider.6
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
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, TextMessage textMessage) {
        String content;
        if (textMessage == null || (content = textMessage.getContent()) == null) {
            return null;
        }
        if (content.length() > 100) {
            content = content.substring(0, 100);
        }
        return new SpannableString(AndroidEmoji.ensure(content));
    }
}

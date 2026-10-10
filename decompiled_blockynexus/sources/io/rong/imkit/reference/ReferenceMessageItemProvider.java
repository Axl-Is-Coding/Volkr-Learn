package io.rong.imkit.reference;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.activity.FilePreviewActivity;
import io.rong.imkit.activity.PicturePagerActivity;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.tools.RongWebviewActivity;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utils.TextViewUtils;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.ILinkClickListener;
import io.rong.imkit.widget.LinkTextViewMovementMethod;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import io.rong.message.FileMessage;
import io.rong.message.ImageMessage;
import io.rong.message.ReferenceMessage;
import io.rong.message.RichContentMessage;
import io.rong.message.TextMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = ReferenceMessage.class, showProgress = false, showReadState = true)
public class ReferenceMessageItemProvider extends IContainerItemProvider.MessageProvider<ReferenceMessage> {
    private static final String TAG = "ReferenceMessageItemProvider";

    private static class ViewHolder {
        LinearLayout containerView;
        TextView referenceContent;
        TextView referenceFileName;
        View referenceHorizontalMark;
        AsyncImageView referenceImg;
        TextView referenceName;
        TextView referenceSendContent;
        View referenceVerticalMark;

        private ViewHolder() {
        }
    }

    private String getDisplayName(UIMessage uIMessage, String str) {
        GroupUserInfo groupUserInfo;
        if (uIMessage.getSenderUserId() == null) {
            return null;
        }
        if (uIMessage.getConversationType().equals(Conversation.ConversationType.GROUP) && (groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(uIMessage.getTargetId(), str)) != null) {
            return groupUserInfo.getNickname();
        }
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(str);
        if (userInfo != null) {
            return userInfo.getName();
        }
        return null;
    }

    private void setFileType(final View view, ViewHolder viewHolder, int i, ReferenceMessage referenceMessage, final UIMessage uIMessage) {
        viewHolder.referenceContent.setOnClickListener(null);
        if (referenceMessage == null || referenceMessage.getReferenceContent() == null) {
            return;
        }
        viewHolder.referenceContent.setOnClickListener(null);
        String str = view.getContext().getString(R.string.rc_search_file_prefix) + ' ' + ((FileMessage) referenceMessage.getReferenceContent()).getName();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.rc_reference_text_link_color)), 0, str.length(), 33);
        AndroidEmoji.ensure(spannableStringBuilder);
        viewHolder.referenceFileName.setText(spannableStringBuilder);
        viewHolder.referenceFileName.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(view2.getContext(), FilePreviewActivity.class);
                    intent.setPackage(view2.getContext().getPackageName());
                    intent.putExtra("FileMessage", (FileMessage) ((ReferenceMessage) uIMessage.getMessage().getContent()).getReferenceContent());
                    intent.putExtra("Message", uIMessage.getMessage());
                    intent.putExtra("Progress", uIMessage.getProgress());
                    view2.getContext().startActivity(intent);
                } catch (Exception e2) {
                    RLog.e(ReferenceMessageItemProvider.TAG, "exception: " + e2);
                }
            }
        });
        viewHolder.referenceFileName.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return view.performLongClick();
            }
        });
        viewHolder.referenceSendContent.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return view.performLongClick();
            }
        });
    }

    private void setImageType(final View view, ViewHolder viewHolder, int i, ReferenceMessage referenceMessage, final UIMessage uIMessage) {
        Uri mediaUrl = null;
        viewHolder.referenceContent.setOnClickListener(null);
        if (referenceMessage == null || referenceMessage.getReferenceContent() == null) {
            return;
        }
        ImageMessage imageMessage = (ImageMessage) referenceMessage.getReferenceContent();
        if (imageMessage.getThumUri() != null) {
            mediaUrl = imageMessage.getThumUri();
        } else if (imageMessage.getLocalPath() != null) {
            mediaUrl = imageMessage.getLocalPath();
        } else if (imageMessage.getMediaUrl() != null) {
            mediaUrl = imageMessage.getMediaUrl();
        }
        if (mediaUrl != null) {
            viewHolder.referenceImg.setResource(imageMessage.getThumUri());
        }
        viewHolder.referenceImg.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    Intent intent = new Intent(view2.getContext(), (Class<?>) PicturePagerActivity.class);
                    intent.setPackage(view2.getContext().getPackageName());
                    intent.putExtra("message", uIMessage.getMessage());
                    view2.getContext().startActivity(intent);
                } catch (Exception e2) {
                    RLog.e(ReferenceMessageItemProvider.TAG, "setImageType", e2);
                }
            }
        });
        viewHolder.referenceImg.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return view.performLongClick();
            }
        });
        viewHolder.referenceSendContent.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.10
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return view.performLongClick();
            }
        });
    }

    private void setMovementMethod(final View view, final UIMessage uIMessage, TextView textView) {
        textView.setMovementMethod(new LinkTextViewMovementMethod(new ILinkClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.1
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

    private void setReferenceContentAction(final View view, ViewHolder viewHolder, int i, ReferenceMessage referenceMessage, UIMessage uIMessage) {
        viewHolder.referenceContent.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return view.performLongClick();
            }
        });
        viewHolder.referenceSendContent.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.12
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return view.performLongClick();
            }
        });
        viewHolder.referenceContent.setMovementMethod(new LinkTextViewMovementMethod(new ILinkClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.13
            @Override // io.rong.imkit.widget.ILinkClickListener
            public boolean onLinkClick(String str) {
                String lowerCase = str.toLowerCase();
                if (!lowerCase.startsWith("http") && !lowerCase.startsWith("https")) {
                    return false;
                }
                Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
                intent.setPackage(view.getContext().getPackageName());
                intent.putExtra("url", str);
                view.getContext().startActivity(intent);
                return true;
            }
        }));
    }

    private void setReferenceType(View view, ViewHolder viewHolder, int i, ReferenceMessage referenceMessage, UIMessage uIMessage) {
        viewHolder.referenceContent.setOnClickListener(null);
        if (referenceMessage == null || referenceMessage.getReferenceContent() == null || !(referenceMessage.getReferenceContent() instanceof TextMessage)) {
            return;
        }
        setTextContent(viewHolder.referenceContent, uIMessage, ((TextMessage) referenceMessage.getReferenceContent()).getContent(), false);
        setReferenceContentAction(view, viewHolder, i, referenceMessage, uIMessage);
    }

    private void setRichType(final View view, ViewHolder viewHolder, int i, ReferenceMessage referenceMessage, UIMessage uIMessage) {
        viewHolder.referenceContent.setOnClickListener(null);
        if (referenceMessage == null || referenceMessage.getReferenceContent() == null) {
            return;
        }
        viewHolder.referenceContent.setOnClickListener(null);
        final RichContentMessage richContentMessage = (RichContentMessage) referenceMessage.getReferenceContent();
        String str = view.getContext().getString(R.string.rc_reference_link) + ' ' + richContentMessage.getTitle();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.rc_reference_text_link_color)), 0, str.length(), 33);
        AndroidEmoji.ensure(spannableStringBuilder);
        viewHolder.referenceContent.setText(spannableStringBuilder);
        viewHolder.referenceContent.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    Intent intent = new Intent(view2.getContext(), (Class<?>) RongWebviewActivity.class);
                    intent.setPackage(view2.getContext().getPackageName());
                    intent.putExtra("url", richContentMessage.getUrl());
                    view2.getContext().startActivity(intent);
                } catch (Exception e2) {
                    RLog.e(ReferenceMessageItemProvider.TAG, "exception: " + e2);
                }
            }
        });
        viewHolder.referenceContent.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return view.performLongClick();
            }
        });
        viewHolder.referenceSendContent.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return view.performLongClick();
            }
        });
    }

    private void setTextContent(final TextView textView, final UIMessage uIMessage, String str, boolean z) {
        textView.setTag(Integer.valueOf(uIMessage.getMessageId()));
        if (z) {
            if (uIMessage.getContentSpannable() == null) {
                uIMessage.setContentSpannable(TextViewUtils.getSpannable(str, new TextViewUtils.RegularCallBack() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.14
                    @Override // io.rong.imkit.utils.TextViewUtils.RegularCallBack
                    public void finish(SpannableStringBuilder spannableStringBuilder) {
                        uIMessage.setContentSpannable(spannableStringBuilder);
                        if (textView.getTag().equals(Integer.valueOf(uIMessage.getMessageId()))) {
                            textView.post(new Runnable() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.14.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                    textView.setText(uIMessage.getContentSpannable());
                                }
                            });
                        }
                    }
                }));
            }
            textView.setText(uIMessage.getContentSpannable());
        } else {
            if (uIMessage.getReferenceContentSpannable() == null) {
                uIMessage.setReferenceContentSpannable(TextViewUtils.getSpannable(str, new TextViewUtils.RegularCallBack() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.15
                    @Override // io.rong.imkit.utils.TextViewUtils.RegularCallBack
                    public void finish(SpannableStringBuilder spannableStringBuilder) {
                        uIMessage.setReferenceContentSpannable(spannableStringBuilder);
                        if (textView.getTag().equals(Integer.valueOf(uIMessage.getMessageId()))) {
                            textView.post(new Runnable() { // from class: io.rong.imkit.reference.ReferenceMessageItemProvider.15.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                                    textView.setText(uIMessage.getReferenceContentSpannable());
                                }
                            });
                        }
                    }
                }));
            }
            textView.setText(uIMessage.getReferenceContentSpannable());
        }
    }

    private void setTextType(View view, ViewHolder viewHolder, int i, ReferenceMessage referenceMessage, UIMessage uIMessage) {
        viewHolder.referenceContent.setOnClickListener(null);
        if (referenceMessage == null || referenceMessage.getReferenceContent() == null || !(referenceMessage.getReferenceContent() instanceof TextMessage)) {
            return;
        }
        setTextContent(viewHolder.referenceContent, uIMessage, ((TextMessage) referenceMessage.getReferenceContent()).getContent(), false);
        setReferenceContentAction(view, viewHolder, i, referenceMessage, uIMessage);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_message_reference, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.containerView = (LinearLayout) viewInflate;
        viewHolder.referenceName = (TextView) viewInflate.findViewById(R.id.rc_msg_tv_reference_name);
        viewHolder.referenceFileName = (TextView) viewInflate.findViewById(R.id.rc_msg_tv_reference_file_name);
        viewHolder.referenceContent = (TextView) viewInflate.findViewById(R.id.rc_msg_tv_reference_content);
        viewHolder.referenceSendContent = (TextView) viewInflate.findViewById(R.id.rc_msg_tv_reference_send_content);
        viewHolder.referenceImg = (AsyncImageView) viewInflate.findViewById(R.id.rc_msg_iv_reference);
        viewHolder.referenceVerticalMark = viewInflate.findViewById(R.id.rc_reference_vertical_mark);
        viewHolder.referenceHorizontalMark = viewInflate.findViewById(R.id.rc_reference_horizontal_mark);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, ReferenceMessage referenceMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, ReferenceMessage referenceMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.referenceName.setText("");
        viewHolder.referenceContent.setText("");
        viewHolder.referenceSendContent.setText("");
        viewHolder.referenceSendContent.setVisibility(0);
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.containerView.setBackgroundResource(R.drawable.rc_ic_bubble_right);
            Drawable drawableC = b.c(view.getContext(), R.drawable.rc_shape_bg_vertical_bar);
            if (drawableC == null) {
                return;
            }
            drawableC.mutate();
            int iA = b.a(view.getContext(), R.color.rc_reference_sent_mark_bg);
            if (drawableC instanceof ShapeDrawable) {
                ((ShapeDrawable) drawableC).getPaint().setColor(iA);
            } else if (drawableC instanceof GradientDrawable) {
                ((GradientDrawable) drawableC).setColor(iA);
            }
            viewHolder.referenceVerticalMark.setBackground(drawableC);
            viewHolder.referenceHorizontalMark.setBackgroundColor(view.getResources().getColor(R.color.rc_reference_sent_mark_bg));
            viewHolder.referenceName.setTextColor(b.a(view.getContext(), R.color.rc_reference_sent_title));
        } else {
            viewHolder.containerView.setBackgroundResource(R.drawable.rc_ic_bubble_left);
            viewHolder.referenceVerticalMark.setBackgroundResource(R.drawable.rc_shape_bg_vertical_bar);
            viewHolder.referenceHorizontalMark.setBackgroundColor(view.getResources().getColor(R.color.rc_reference_received_mark_bg));
            viewHolder.referenceName.setTextColor(b.a(view.getContext(), R.color.rc_reference_received_title));
        }
        if (referenceMessage.getUserId() != null) {
            viewHolder.referenceName.setText(getDisplayName(uIMessage, referenceMessage.getUserId()));
        }
        if (referenceMessage.getEditSendText() != null) {
            setTextContent(viewHolder.referenceSendContent, uIMessage, referenceMessage.getEditSendText(), true);
            setMovementMethod(view, uIMessage, viewHolder.referenceSendContent);
        }
        if (referenceMessage.getReferenceContent() == null) {
            return;
        }
        if (referenceMessage.getReferenceContent() instanceof TextMessage) {
            setTextType(view, viewHolder, i, referenceMessage, uIMessage);
            viewHolder.referenceContent.setVisibility(0);
            viewHolder.referenceContent.setMaxLines(Integer.MAX_VALUE);
            viewHolder.referenceImg.setVisibility(8);
            viewHolder.referenceFileName.setVisibility(8);
            setMovementMethod(view, uIMessage, viewHolder.referenceContent);
            return;
        }
        if (referenceMessage.getReferenceContent() instanceof ImageMessage) {
            setImageType(view, viewHolder, i, referenceMessage, uIMessage);
            viewHolder.referenceContent.setVisibility(8);
            viewHolder.referenceImg.setVisibility(0);
            viewHolder.referenceFileName.setVisibility(8);
            return;
        }
        if (referenceMessage.getReferenceContent() instanceof FileMessage) {
            setFileType(view, viewHolder, i, referenceMessage, uIMessage);
            viewHolder.referenceContent.setVisibility(8);
            viewHolder.referenceImg.setVisibility(8);
            viewHolder.referenceFileName.setVisibility(0);
            return;
        }
        if (referenceMessage.getReferenceContent() instanceof RichContentMessage) {
            setRichType(view, viewHolder, i, referenceMessage, uIMessage);
            viewHolder.referenceContent.setVisibility(0);
            viewHolder.referenceContent.setMaxLines(3);
            viewHolder.referenceContent.setEllipsize(TextUtils.TruncateAt.END);
            viewHolder.referenceImg.setVisibility(8);
            viewHolder.referenceFileName.setVisibility(8);
            return;
        }
        if (!(referenceMessage.getReferenceContent() instanceof ReferenceMessage)) {
            viewHolder.referenceContent.setVisibility(0);
            viewHolder.referenceContent.setText(R.string.rc_message_unknown);
            viewHolder.referenceImg.setVisibility(8);
            viewHolder.referenceFileName.setVisibility(8);
            return;
        }
        setReferenceType(view, viewHolder, i, referenceMessage, uIMessage);
        viewHolder.referenceContent.setVisibility(0);
        viewHolder.referenceContent.setMaxLines(Integer.MAX_VALUE);
        viewHolder.referenceImg.setVisibility(8);
        viewHolder.referenceFileName.setVisibility(8);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(ReferenceMessage referenceMessage) {
        return new SpannableString(AndroidEmoji.ensure(referenceMessage.getEditSendText()));
    }
}

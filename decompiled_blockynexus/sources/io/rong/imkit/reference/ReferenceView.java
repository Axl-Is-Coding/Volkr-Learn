package io.rong.imkit.reference;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.b;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.activity.FilePreviewActivity;
import io.rong.imkit.activity.PicturePagerActivity;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;
import io.rong.message.FileMessage;
import io.rong.message.ImageMessage;
import io.rong.message.ReferenceMessage;
import io.rong.message.RichContentMessage;
import io.rong.message.TextMessage;

/* JADX INFO: loaded from: classes5.dex */
public class ReferenceView extends FrameLayout {
    private static final int DEFAULT_MAX_HEIGHT = 238;
    private static final String TAG = "ConversationFragment";
    private CancelListener cancelListener;
    private AsyncImageView imgReferenceContent;
    private int maxHeight;
    private TextView tvReferenceContent;
    private TextView tvReferenceName;

    public interface CancelListener {
        void cancelClick();
    }

    public ReferenceView(Context context) {
        super(context);
        this.maxHeight = 238;
        init();
    }

    private SpannableStringBuilder createSpan(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        AndroidEmoji.ensure(spannableStringBuilder);
        return spannableStringBuilder;
    }

    private String getDisplayName(UIMessage uIMessage) {
        GroupUserInfo groupUserInfo;
        if (uIMessage.getSenderUserId() == null) {
            return null;
        }
        if (uIMessage.getConversationType().equals(Conversation.ConversationType.GROUP) && (groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(uIMessage.getTargetId(), uIMessage.getSenderUserId())) != null) {
            return groupUserInfo.getNickname();
        }
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(uIMessage.getSenderUserId());
        if (userInfo != null) {
            return userInfo.getName();
        }
        return null;
    }

    private void init() {
        FrameLayout.inflate(getContext(), R.layout.rc_view_reference, this);
        ImageButton imageButton = (ImageButton) findViewById(R.id.rc_view_iv_reference_cancel);
        this.tvReferenceName = (TextView) findViewById(R.id.rc_view_tv_reference_name);
        this.tvReferenceContent = (TextView) findViewById(R.id.rc_view_tv_reference_content);
        this.imgReferenceContent = (AsyncImageView) findViewById(R.id.rc_view_iv_reference_content);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.reference.ReferenceView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ReferenceView.this.cancelListener != null) {
                    ReferenceView.this.cancelListener.cancelClick();
                }
            }
        });
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReferenceView);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R.styleable.ReferenceView_RCMaxHeight) {
                this.maxHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, 238);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private ReferenceMessage makeFileMessage(final UIMessage uIMessage) {
        final FileMessage fileMessage = (FileMessage) uIMessage.getContent();
        if (uIMessage.getSenderUserId() == null || fileMessage.getFileUrl() == null) {
            return null;
        }
        this.tvReferenceName.setText(getDisplayName(uIMessage));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.rc_reference_file) + ' ' + fileMessage.getName());
        AndroidEmoji.ensure(spannableStringBuilder);
        this.tvReferenceContent.setText(spannableStringBuilder);
        this.tvReferenceContent.setTextColor(b.a(getContext(), R.color.rc_reference_text_link_color));
        this.tvReferenceContent.setVisibility(0);
        this.imgReferenceContent.setVisibility(8);
        this.tvReferenceContent.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.reference.ReferenceView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(view.getContext(), FilePreviewActivity.class);
                    intent.setPackage(view.getContext().getPackageName());
                    intent.putExtra("FileMessage", fileMessage);
                    intent.putExtra("Message", uIMessage.getMessage());
                    intent.putExtra("Progress", uIMessage.getProgress());
                    view.getContext().startActivity(intent);
                } catch (Exception e2) {
                    RLog.e("ConversationFragment", "exception: " + e2);
                }
            }
        });
        return ReferenceMessage.obtainMessage(uIMessage.getSenderUserId(), uIMessage.getContent());
    }

    private ReferenceMessage makeImageMessage(final UIMessage uIMessage) {
        ImageMessage imageMessage = (ImageMessage) uIMessage.getContent();
        if (uIMessage.getSenderUserId() == null || imageMessage.getRemoteUri() == null) {
            return null;
        }
        this.tvReferenceName.setText(getDisplayName(uIMessage));
        this.tvReferenceContent.setVisibility(8);
        this.imgReferenceContent.setVisibility(0);
        this.imgReferenceContent.setResource(imageMessage.getThumUri());
        this.imgReferenceContent.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.reference.ReferenceView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(view.getContext(), (Class<?>) PicturePagerActivity.class);
                    intent.setPackage(view.getContext().getPackageName());
                    intent.putExtra("message", uIMessage.getMessage());
                    view.getContext().startActivity(intent);
                } catch (Exception e2) {
                    RLog.e("ConversationFragment", "exception: " + e2);
                }
            }
        });
        return ReferenceMessage.obtainMessage(uIMessage.getSenderUserId(), uIMessage.getContent());
    }

    private ReferenceMessage makeReferenceMessage(UIMessage uIMessage) {
        ReferenceMessage referenceMessage = (ReferenceMessage) uIMessage.getContent();
        if (uIMessage.getSenderUserId() == null) {
            return null;
        }
        this.tvReferenceName.setText(getDisplayName(uIMessage));
        setTextContent(this.tvReferenceContent, createSpan(referenceMessage.getEditSendText()));
        this.tvReferenceContent.setTextColor(b.a(getContext(), R.color.rc_reference_normal_text_color));
        this.tvReferenceContent.setVisibility(0);
        this.imgReferenceContent.setVisibility(8);
        return ReferenceMessage.obtainMessage(uIMessage.getSenderUserId(), TextMessage.obtain(referenceMessage.getEditSendText()));
    }

    private ReferenceMessage makeRichContentMessage(UIMessage uIMessage) {
        RichContentMessage richContentMessage = (RichContentMessage) uIMessage.getContent();
        if (uIMessage.getSenderUserId() == null || richContentMessage.getTitle() == null || richContentMessage.getUrl() == null) {
            return null;
        }
        this.tvReferenceName.setText(getDisplayName(uIMessage));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.rc_reference_link) + ' ' + richContentMessage.getTitle());
        AndroidEmoji.ensure(spannableStringBuilder);
        this.tvReferenceContent.setText(spannableStringBuilder);
        this.tvReferenceContent.setTextColor(b.a(getContext(), R.color.rc_reference_text_link_color));
        this.tvReferenceContent.setVisibility(0);
        this.imgReferenceContent.setVisibility(8);
        return ReferenceMessage.obtainMessage(uIMessage.getSenderUserId(), uIMessage.getContent());
    }

    private ReferenceMessage makeTextMessage(UIMessage uIMessage) {
        TextMessage textMessage = (TextMessage) uIMessage.getContent();
        if (uIMessage.getSenderUserId() == null || textMessage.getContent() == null) {
            return null;
        }
        this.tvReferenceName.setText(getDisplayName(uIMessage));
        setTextContent(this.tvReferenceContent, createSpan(textMessage.getContent()));
        this.tvReferenceContent.setTextColor(b.a(getContext(), R.color.rc_reference_normal_text_color));
        this.tvReferenceContent.setVisibility(0);
        this.imgReferenceContent.setVisibility(8);
        return ReferenceMessage.obtainMessage(uIMessage.getSenderUserId(), uIMessage.getContent());
    }

    private void setTextContent(final TextView textView, final SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        if (getHandler() == null || length <= 500) {
            textView.setText(spannableStringBuilder);
        } else {
            getHandler().postDelayed(new Runnable() { // from class: io.rong.imkit.reference.ReferenceView.4
                @Override // java.lang.Runnable
                public void run() {
                    textView.setText(spannableStringBuilder);
                }
            }, 50L);
        }
    }

    public void clearReference() {
        this.tvReferenceName.setText("");
        this.tvReferenceContent.setText("");
        this.imgReferenceContent.setImageDrawable(null);
        setVisibility(8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        this.maxHeight = (int) getResources().getDimension(R.dimen.rc_reference_dimen_size_103);
        if (mode == 1073741824 && size > (i5 = this.maxHeight)) {
            size = i5;
        }
        if (mode == 0 && size > (i4 = this.maxHeight)) {
            size = i4;
        }
        if (mode == Integer.MIN_VALUE && size > (i3 = this.maxHeight)) {
            size = i3;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setCancelListener(CancelListener cancelListener) {
        this.cancelListener = cancelListener;
    }

    public ReferenceMessage setMessageContent(UIMessage uIMessage) {
        TextView textView = this.tvReferenceContent;
        if (textView != null) {
            textView.setOnClickListener(null);
        }
        if (uIMessage == null) {
            return null;
        }
        if (uIMessage.getContent() instanceof TextMessage) {
            return makeTextMessage(uIMessage);
        }
        if (uIMessage.getContent() instanceof ImageMessage) {
            return makeImageMessage(uIMessage);
        }
        if (uIMessage.getContent() instanceof FileMessage) {
            return makeFileMessage(uIMessage);
        }
        if (uIMessage.getContent() instanceof RichContentMessage) {
            return makeRichContentMessage(uIMessage);
        }
        if (uIMessage.getContent() instanceof ReferenceMessage) {
            return makeReferenceMessage(uIMessage);
        }
        return null;
    }

    public ReferenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxHeight = 238;
        initAttrs(context, attributeSet);
        init();
    }
}

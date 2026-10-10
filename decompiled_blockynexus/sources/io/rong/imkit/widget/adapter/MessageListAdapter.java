package io.rong.imkit.widget.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.dialog.BurnHintDialog;
import io.rong.imkit.mention.RongMentionManager;
import io.rong.imkit.model.ConversationKey;
import io.rong.imkit.model.Event;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.resend.ResendManager;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.utils.RongDateUtils;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.DebouncedOnClickListener;
import io.rong.imkit.widget.ProviderContainerView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.destruct.DestructionTaskManager;
import io.rong.imlib.location.message.RealTimeLocationJoinMessage;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.ReadReceiptInfo;
import io.rong.imlib.model.UnknownMessage;
import io.rong.imlib.model.UserInfo;
import io.rong.message.GIFMessage;
import io.rong.message.GroupNotificationMessage;
import io.rong.message.HistoryDividerMessage;
import io.rong.message.ImageMessage;
import io.rong.message.InformationNotificationMessage;
import io.rong.message.RecallNotificationMessage;
import io.rong.message.SightMessage;
import io.rong.message.TextMessage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class MessageListAdapter extends BaseAdapter<UIMessage> {
    private static final String TAG = "MessageListAdapter";
    private static long readReceiptRequestInterval = 120;
    private boolean isShowCheckbox;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemHandlerListener mOnItemHandlerListener;
    private OnMessageCheckedChanged messageCheckedChanged;
    private OnSelectedCountDidExceed selectedCountDidExceed;
    boolean evaForRobot = false;
    boolean robotMode = true;
    protected boolean timeGone = false;
    private int maxMessageSelectedCount = -1;

    private abstract class NoDoubleClickListener implements View.OnClickListener {
        public static final int MIN_CLICK_DELAY_TIME = 500;
        public long lastClickTime;

        private NoDoubleClickListener() {
            this.lastClickTime = 0L;
        }

        public abstract void onNoDoubleClick(View view);
    }

    public interface OnItemHandlerListener {
        void onMessageClick(int i, Message message, View view);

        void onReadReceiptStateClick(Message message);

        boolean onWarningViewClick(int i, Message message, View view);
    }

    public interface OnMessageCheckedChanged {
        void onCheckedEnable(boolean z);
    }

    public interface OnSelectedCountDidExceed {
        void onSelectedCountDidExceed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public class ViewHolder {
        public LinearLayout checkboxLayout;
        public ProviderContainerView contentView;
        public ViewGroup layout;
        public RelativeLayout layoutItem;
        public AsyncImageView leftIconView;
        public CheckBox message_check;
        public TextView nameView;
        public ProgressBar progressBar;
        public TextView readReceipt;
        public TextView readReceiptRequest;
        public TextView readReceiptStatus;
        public AsyncImageView rightIconView;
        public TextView sentStatus;
        public TextView time;
        public ImageView warning;

        protected ViewHolder() {
        }
    }

    public MessageListAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        try {
            if (RongContext.getInstance() != null) {
                readReceiptRequestInterval = context.getResources().getInteger(R.integer.rc_read_receipt_request_interval);
            } else {
                RLog.e(TAG, "SDK isn't init, use default readReceiptRequestInterval. Please refer to http://support.rongcloud.cn/kb/Mjc2 about how to init.");
            }
        } catch (Resources.NotFoundException e2) {
            RLog.e(TAG, "MessageListAdapter rc_read_receipt_request_interval not configure in rc_config.xml", e2);
        }
    }

    private void bindViewClickEvent(final View view, View view2, final int i, final UIMessage uIMessage) {
        final ViewHolder viewHolder = (ViewHolder) view.getTag();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (MessageListAdapter.this.isShowCheckbox()) {
                    boolean z = !uIMessage.isChecked();
                    if (MessageListAdapter.this.maxMessageSelectedCount != -1 && MessageListAdapter.this.getCheckedMessage().size() >= MessageListAdapter.this.maxMessageSelectedCount && z) {
                        if (MessageListAdapter.this.selectedCountDidExceed != null) {
                            MessageListAdapter.this.selectedCountDidExceed.onSelectedCountDidExceed();
                        }
                    } else {
                        uIMessage.setChecked(z);
                        viewHolder.message_check.setChecked(z);
                        if (MessageListAdapter.this.messageCheckedChanged != null) {
                            MessageListAdapter.this.messageCheckedChanged.onCheckedEnable(MessageListAdapter.this.getCheckedMessage().size() > 0);
                        }
                    }
                }
            }
        };
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                if (!MessageListAdapter.this.isShowCheckbox() || motionEvent.getAction() != 1) {
                    return false;
                }
                boolean z = !uIMessage.isChecked();
                if (MessageListAdapter.this.maxMessageSelectedCount != -1 && MessageListAdapter.this.getCheckedMessage().size() >= MessageListAdapter.this.maxMessageSelectedCount && z) {
                    if (MessageListAdapter.this.selectedCountDidExceed != null) {
                        MessageListAdapter.this.selectedCountDidExceed.onSelectedCountDidExceed();
                    }
                    return true;
                }
                uIMessage.setChecked(z);
                viewHolder.message_check.setChecked(z);
                if (MessageListAdapter.this.messageCheckedChanged != null) {
                    MessageListAdapter.this.messageCheckedChanged.onCheckedEnable(MessageListAdapter.this.getCheckedMessage().size() > 0);
                }
                return true;
            }
        };
        NoDoubleClickListener noDoubleClickListener = new NoDoubleClickListener() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                if (timeInMillis - this.lastClickTime > 500) {
                    this.lastClickTime = timeInMillis;
                    onNoDoubleClick(view3);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.rong.imkit.widget.adapter.MessageListAdapter.NoDoubleClickListener
            public void onNoDoubleClick(View view3) {
                if (RongContext.getInstance().getConversationBehaviorListener() != null) {
                    if (RongContext.getInstance().getConversationBehaviorListener().onMessageClick(MessageListAdapter.this.mContext, view3, uIMessage.getMessage())) {
                        return;
                    }
                } else if (RongContext.getInstance().getConversationClickListener() != null && RongContext.getInstance().getConversationClickListener().onMessageClick(MessageListAdapter.this.mContext, view3, uIMessage.getMessage())) {
                    return;
                }
                if (MessageListAdapter.this.mOnItemHandlerListener != null) {
                    MessageListAdapter.this.mOnItemHandlerListener.onMessageClick(i, uIMessage.getMessage(), view3);
                }
                IContainerItemProvider.MessageProvider evaluateProvider = MessageListAdapter.this.getNeedEvaluate(uIMessage) ? RongContext.getInstance().getEvaluateProvider() : RongContext.getInstance().getMessageTemplate(uIMessage.getContent().getClass());
                if (evaluateProvider != null) {
                    UIMessage uIMessage2 = uIMessage;
                    if (uIMessage2 != null && uIMessage2.getContent() != null && uIMessage.getContent().isDestruct() && uIMessage.getMessageDirection().equals(Message.MessageDirection.RECEIVE) && !BurnHintDialog.isFirstClick(view3.getContext())) {
                        EventBus.getDefault().post(new Event.ShowDurnDialogEvent());
                        return;
                    }
                    int i2 = i;
                    UIMessage uIMessage3 = uIMessage;
                    evaluateProvider.onItemClick(view3, i2, uIMessage3 != null ? uIMessage3.getContent() : null, uIMessage);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view3) {
                if (MessageListAdapter.this.isShowCheckbox()) {
                    return true;
                }
                if (RongContext.getInstance().getConversationBehaviorListener() != null) {
                    if (RongContext.getInstance().getConversationBehaviorListener().onMessageLongClick(MessageListAdapter.this.mContext, view3, uIMessage.getMessage())) {
                        return true;
                    }
                } else if (RongContext.getInstance().getConversationClickListener() != null && RongContext.getInstance().getConversationClickListener().onMessageLongClick(MessageListAdapter.this.mContext, view3, uIMessage.getMessage())) {
                    return true;
                }
                IContainerItemProvider.MessageProvider evaluateProvider = MessageListAdapter.this.getNeedEvaluate(uIMessage) ? RongContext.getInstance().getEvaluateProvider() : RongContext.getInstance().getMessageTemplate(uIMessage.getContent().getClass());
                if (evaluateProvider != null) {
                    evaluateProvider.onItemLongClick(view3, i, uIMessage.getContent(), uIMessage);
                }
                return true;
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                UserInfo userInfo = uIMessage.getUserInfo();
                if (!TextUtils.isEmpty(uIMessage.getSenderUserId())) {
                    if (userInfo == null) {
                        userInfo = RongUserInfoManager.getInstance().getUserInfo(uIMessage.getSenderUserId());
                    }
                    if (userInfo == null) {
                        userInfo = new UserInfo(uIMessage.getSenderUserId(), null, null);
                    }
                }
                if (RongContext.getInstance().getConversationBehaviorListener() != null) {
                    RongContext.getInstance().getConversationBehaviorListener().onUserPortraitClick(MessageListAdapter.this.mContext, uIMessage.getConversationType(), userInfo);
                } else if (RongContext.getInstance().getConversationClickListener() != null) {
                    RongContext.getInstance().getConversationClickListener().onUserPortraitClick(MessageListAdapter.this.mContext, uIMessage.getConversationType(), userInfo, uIMessage.getTargetId());
                }
            }
        };
        View.OnLongClickListener onLongClickListener2 = new View.OnLongClickListener() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view3) {
                GroupUserInfo groupUserInfo;
                UserInfo userInfo = uIMessage.getUserInfo();
                if (!TextUtils.isEmpty(uIMessage.getSenderUserId())) {
                    if (userInfo == null) {
                        userInfo = RongUserInfoManager.getInstance().getUserInfo(uIMessage.getSenderUserId());
                    }
                    if (userInfo == null) {
                        userInfo = new UserInfo(uIMessage.getSenderUserId(), null, null);
                    }
                }
                if (uIMessage.getConversationType().equals(Conversation.ConversationType.GROUP) && (groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(uIMessage.getTargetId(), uIMessage.getSenderUserId())) != null && !TextUtils.isEmpty(groupUserInfo.getNickname()) && userInfo != null) {
                    userInfo.setName(groupUserInfo.getNickname());
                }
                if (!uIMessage.getMessageDirection().equals(Message.MessageDirection.SEND)) {
                    Object conversationListener = RongContext.getInstance().getConversationListener();
                    if ((conversationListener == null || ((!(conversationListener instanceof RongIM.ConversationClickListener) || !((RongIM.ConversationClickListener) conversationListener).onUserPortraitLongClick(MessageListAdapter.this.mContext, uIMessage.getConversationType(), userInfo, uIMessage.getTargetId())) && (!(conversationListener instanceof RongIM.ConversationBehaviorListener) || !((RongIM.ConversationBehaviorListener) conversationListener).onUserPortraitLongClick(MessageListAdapter.this.mContext, uIMessage.getConversationType(), userInfo)))) && view.getContext().getResources().getBoolean(R.bool.rc_enable_mentioned_message) && (uIMessage.getConversationType().equals(Conversation.ConversationType.GROUP) || uIMessage.getConversationType().equals(Conversation.ConversationType.DISCUSSION))) {
                        RongMentionManager.getInstance().mentionMember(uIMessage.getConversationType(), uIMessage.getTargetId(), uIMessage.getSenderUserId());
                    }
                } else {
                    if (RongContext.getInstance().getConversationBehaviorListener() != null) {
                        return RongContext.getInstance().getConversationBehaviorListener().onUserPortraitLongClick(MessageListAdapter.this.mContext, uIMessage.getConversationType(), userInfo);
                    }
                    if (RongContext.getInstance().getConversationClickListener() != null) {
                        return RongContext.getInstance().getConversationClickListener().onUserPortraitLongClick(MessageListAdapter.this.mContext, uIMessage.getConversationType(), userInfo, uIMessage.getTargetId());
                    }
                }
                return true;
            }
        };
        if (isShowCheckbox() && allowShowCheckButton(uIMessage.getMessage())) {
            view.setOnClickListener(onClickListener);
            view2.setOnTouchListener(onTouchListener);
            viewHolder.rightIconView.setOnClickListener(onClickListener);
            viewHolder.leftIconView.setOnClickListener(onClickListener);
        } else {
            view2.setOnClickListener(noDoubleClickListener);
            view2.setOnLongClickListener(onLongClickListener);
            viewHolder.rightIconView.setOnClickListener(onClickListener2);
            viewHolder.leftIconView.setOnClickListener(onClickListener2);
            viewHolder.rightIconView.setOnLongClickListener(onLongClickListener2);
            viewHolder.leftIconView.setOnLongClickListener(onLongClickListener2);
        }
        viewHolder.warning.setOnClickListener(new DebouncedOnClickListener() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.7
            @Override // io.rong.imkit.widget.DebouncedOnClickListener
            public void onDebouncedClick(View view3) {
                if (MessageListAdapter.this.getItemHandlerListener() != null) {
                    MessageListAdapter.this.getItemHandlerListener().onWarningViewClick(i, uIMessage.getMessage(), view3);
                }
            }
        });
    }

    public boolean allowReadReceiptRequest(Message message) {
        return (message == null || message.getContent() == null || !(message.getContent() instanceof TextMessage)) ? false : true;
    }

    protected boolean allowShowCheckButton(Message message) {
        MessageContent content;
        if (message == null || (content = message.getContent()) == null) {
            return true;
        }
        return ((content instanceof InformationNotificationMessage) || (content instanceof UnknownMessage) || (content instanceof GroupNotificationMessage) || (content instanceof RecallNotificationMessage) || (content instanceof RealTimeLocationJoinMessage)) ? false : true;
    }

    public List<Message> getCheckedMessage() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getCount(); i++) {
            UIMessage item = getItem(i);
            if (item.isChecked()) {
                arrayList.add(item.getMessage());
            }
        }
        return arrayList;
    }

    protected OnItemHandlerListener getItemHandlerListener() {
        return this.mOnItemHandlerListener;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) == null) {
            return -1L;
        }
        return r3.getMessageId();
    }

    protected boolean getNeedEvaluate(UIMessage uIMessage) {
        String strOptString;
        if (uIMessage == null || uIMessage.getConversationType() == null || !uIMessage.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE)) {
            return false;
        }
        String strOptString2 = "";
        if (uIMessage.getContent() instanceof TextMessage) {
            String extra = ((TextMessage) uIMessage.getContent()).getExtra();
            if (TextUtils.isEmpty(extra)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(extra);
                strOptString = jSONObject.optString("robotEva");
                try {
                    strOptString2 = jSONObject.optString("sid");
                } catch (JSONException unused) {
                }
            } catch (JSONException unused2) {
                strOptString = "";
            }
        } else {
            strOptString = "";
        }
        return uIMessage.getMessageDirection() == Message.MessageDirection.RECEIVE && (uIMessage.getContent() instanceof TextMessage) && this.evaForRobot && this.robotMode && !TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && !uIMessage.getIsHistoryMessage();
    }

    public int getPositionBySendTime(long j) {
        for (int i = 0; i < getCount(); i++) {
            if (getItem(i).getSentTime() > j) {
                return i;
            }
        }
        return getCount();
    }

    public boolean isShowCheckbox() {
        return this.isShowCheckbox;
    }

    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    protected View newView(Context context, int i, ViewGroup viewGroup) {
        View viewInflate = this.mInflater.inflate(R.layout.rc_item_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.leftIconView = (AsyncImageView) findViewById(viewInflate, R.id.rc_left);
        viewHolder.rightIconView = (AsyncImageView) findViewById(viewInflate, R.id.rc_right);
        viewHolder.nameView = (TextView) findViewById(viewInflate, R.id.rc_title);
        viewHolder.contentView = (ProviderContainerView) findViewById(viewInflate, R.id.rc_content);
        viewHolder.layout = (ViewGroup) findViewById(viewInflate, R.id.rc_layout);
        viewHolder.progressBar = (ProgressBar) findViewById(viewInflate, R.id.rc_progress);
        viewHolder.warning = (ImageView) findViewById(viewInflate, R.id.rc_warning);
        viewHolder.readReceipt = (TextView) findViewById(viewInflate, R.id.rc_read_receipt);
        viewHolder.readReceiptRequest = (TextView) findViewById(viewInflate, R.id.rc_read_receipt_request);
        viewHolder.readReceiptStatus = (TextView) findViewById(viewInflate, R.id.rc_read_receipt_status);
        viewHolder.message_check = (CheckBox) findViewById(viewInflate, R.id.message_check);
        viewHolder.checkboxLayout = (LinearLayout) findViewById(viewInflate, R.id.ll_message_check);
        viewHolder.time = (TextView) findViewById(viewInflate, R.id.rc_time);
        viewHolder.sentStatus = (TextView) findViewById(viewInflate, R.id.rc_sent_status);
        viewHolder.layoutItem = (RelativeLayout) findViewById(viewInflate, R.id.rc_layout_item_message);
        this.timeGone = viewHolder.time.getVisibility() == 8;
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    public void setEvaluateForRobot(boolean z) {
        this.evaForRobot = z;
    }

    protected void setGravity(View view, int i) {
        ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = i;
    }

    public void setMaxMessageSelectedCount(int i) {
        this.maxMessageSelectedCount = i;
    }

    public void setMessageCheckedChanged(OnMessageCheckedChanged onMessageCheckedChanged) {
        this.messageCheckedChanged = onMessageCheckedChanged;
    }

    public void setOnItemHandlerListener(OnItemHandlerListener onItemHandlerListener) {
        this.mOnItemHandlerListener = onItemHandlerListener;
    }

    public void setRobotMode(boolean z) {
        this.robotMode = z;
    }

    public void setSelectedCountDidExceed(OnSelectedCountDidExceed onSelectedCountDidExceed) {
        this.selectedCountDidExceed = onSelectedCountDidExceed;
    }

    public void setShowCheckbox(boolean z) {
        this.isShowCheckbox = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    public void bindView(View view, int i, final UIMessage uIMessage) {
        IContainerItemProvider.MessageProvider messageTemplate;
        ProviderTag messageProviderTag;
        final View viewInflate;
        boolean z;
        boolean z2;
        if (uIMessage == null) {
            return;
        }
        final ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder == null) {
            RLog.e(TAG, "view holder is null !");
            return;
        }
        if (getNeedEvaluate(uIMessage)) {
            messageTemplate = RongContext.getInstance().getEvaluateProvider();
            messageProviderTag = RongContext.getInstance().getMessageProviderTag(uIMessage.getContent().getClass());
        } else {
            if (RongContext.getInstance() == null || uIMessage.getContent() == null) {
                RLog.e(TAG, "Message is null !");
                return;
            }
            messageTemplate = RongContext.getInstance().getMessageTemplate(uIMessage.getContent().getClass());
            if (messageTemplate == null) {
                messageTemplate = RongContext.getInstance().getMessageTemplate(UnknownMessage.class);
                messageProviderTag = RongContext.getInstance().getMessageProviderTag(UnknownMessage.class);
            } else {
                messageProviderTag = RongContext.getInstance().getMessageProviderTag(uIMessage.getContent().getClass());
            }
            if (messageTemplate == null) {
                RLog.e(TAG, uIMessage.getObjectName() + " message provider not found !");
                return;
            }
        }
        if (uIMessage.getContent() != null && uIMessage.getContent().isDestruct() && uIMessage.getMessage() != null && uIMessage.getMessage().getReadTime() > 0 && uIMessage.getMessage().getContent() != null) {
            if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
                DestructManager.getInstance().deleteMessage(uIMessage.getMessage());
                remove(i);
                notifyDataSetChanged();
                return;
            } else if ((System.currentTimeMillis() - uIMessage.getMessage().getReadTime()) / 1000 >= uIMessage.getMessage().getContent().getDestructTime()) {
                DestructionTaskManager.getInstance().deleteMessage(uIMessage.getMessage());
                remove(i);
                notifyDataSetChanged();
                return;
            }
        }
        try {
            viewInflate = viewHolder.contentView.inflate(messageTemplate);
        } catch (Exception e2) {
            RLog.e(TAG, "bindView contentView inflate error", e2);
            messageTemplate = RongContext.getInstance().getMessageTemplate(UnknownMessage.class);
            messageProviderTag = RongContext.getInstance().getMessageProviderTag(UnknownMessage.class);
            viewInflate = viewHolder.contentView.inflate(messageTemplate);
        }
        messageTemplate.bindView(viewInflate, i, uIMessage);
        if (messageProviderTag == null) {
            RLog.e(TAG, "Can not find ProviderTag for " + uIMessage.getObjectName());
            return;
        }
        if (messageProviderTag.hide()) {
            viewHolder.contentView.setVisibility(8);
            viewHolder.time.setVisibility(8);
            viewHolder.nameView.setVisibility(8);
            viewHolder.leftIconView.setVisibility(8);
            viewHolder.rightIconView.setVisibility(8);
            viewHolder.layoutItem.setVisibility(8);
            viewHolder.layoutItem.setPadding(0, 0, 0, 0);
        } else {
            viewHolder.contentView.setVisibility(0);
            viewHolder.layoutItem.setVisibility(0);
            viewHolder.layoutItem.setPadding(RongUtils.dip2px(8.0f), RongUtils.dip2px(6.0f), RongUtils.dip2px(8.0f), RongUtils.dip2px(6.0f));
        }
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            if (messageProviderTag.showPortrait()) {
                viewHolder.rightIconView.setVisibility(0);
                viewHolder.leftIconView.setVisibility(8);
            } else {
                viewHolder.leftIconView.setVisibility(8);
                viewHolder.rightIconView.setVisibility(8);
            }
            if (messageProviderTag.centerInHorizontal()) {
                setGravity(viewHolder.layout, 17);
                viewHolder.contentView.containerViewCenter();
                viewHolder.nameView.setGravity(1);
                viewHolder.contentView.setBackgroundColor(0);
            } else {
                setGravity(viewHolder.layout, 5);
                viewHolder.contentView.containerViewRight();
                viewHolder.nameView.setGravity(5);
            }
            try {
                z = this.mContext.getResources().getBoolean(R.bool.rc_read_receipt);
            } catch (Resources.NotFoundException e3) {
                RLog.e(TAG, "bindView rc_read_receipt not configure in rc_config.xml", e3);
                z = false;
            }
            if (uIMessage.getSentStatus() == Message.SentStatus.SENDING) {
                if (messageProviderTag.showProgress()) {
                    viewHolder.progressBar.setVisibility(0);
                } else {
                    viewHolder.progressBar.setVisibility(8);
                }
                viewHolder.warning.setVisibility(8);
                viewHolder.readReceipt.setVisibility(8);
            } else if (uIMessage.getSentStatus() == Message.SentStatus.FAILED) {
                if (ResendManager.getInstance().needResend(uIMessage.getMessageId())) {
                    if ((uIMessage.getMessage().getContent() instanceof ImageMessage) || (uIMessage.getMessage().getContent() instanceof GIFMessage) || (uIMessage.getMessage().getContent() instanceof SightMessage)) {
                        viewHolder.progressBar.setVisibility(8);
                    } else {
                        viewHolder.progressBar.setVisibility(0);
                    }
                    viewHolder.warning.setVisibility(8);
                } else {
                    viewHolder.progressBar.setVisibility(8);
                    viewHolder.warning.setVisibility(0);
                }
                viewHolder.readReceipt.setVisibility(8);
            } else if (uIMessage.getSentStatus() != Message.SentStatus.SENT && z && uIMessage.getSentStatus() == Message.SentStatus.READ) {
                viewHolder.progressBar.setVisibility(8);
                viewHolder.warning.setVisibility(8);
                if (uIMessage.getConversationType().equals(Conversation.ConversationType.PRIVATE) && messageProviderTag.showReadState()) {
                    viewHolder.readReceipt.setVisibility(0);
                } else {
                    viewHolder.readReceipt.setVisibility(8);
                }
            } else {
                viewHolder.progressBar.setVisibility(8);
                viewHolder.warning.setVisibility(8);
                viewHolder.readReceipt.setVisibility(8);
            }
            viewHolder.readReceiptRequest.setVisibility(8);
            viewHolder.readReceiptStatus.setVisibility(8);
            if (z && RongContext.getInstance().isReadReceiptConversationType(uIMessage.getConversationType()) && (uIMessage.getConversationType().equals(Conversation.ConversationType.GROUP) || uIMessage.getConversationType().equals(Conversation.ConversationType.DISCUSSION))) {
                if (allowReadReceiptRequest(uIMessage.getMessage()) && !TextUtils.isEmpty(uIMessage.getUId())) {
                    int i2 = i + 1;
                    while (true) {
                        if (i2 >= getCount()) {
                            z2 = true;
                            break;
                        } else {
                            if (getItem(i2).getMessageDirection() == Message.MessageDirection.SEND) {
                                z2 = false;
                                break;
                            }
                            i2++;
                        }
                    }
                    if ((System.currentTimeMillis() - RongIMClient.getInstance().getDeltaTime()) - uIMessage.getSentTime() < readReceiptRequestInterval * 1000 && z2 && (uIMessage.getReadReceiptInfo() == null || !uIMessage.getReadReceiptInfo().isReadReceiptMessage())) {
                        viewHolder.readReceiptRequest.setVisibility(0);
                    }
                }
                if (allowReadReceiptRequest(uIMessage.getMessage()) && uIMessage.getReadReceiptInfo() != null && uIMessage.getReadReceiptInfo().isReadReceiptMessage()) {
                    if (uIMessage.getReadReceiptInfo().getRespondUserIdList() != null) {
                        viewHolder.readReceiptStatus.setText(String.format(viewInflate.getResources().getString(R.string.rc_read_receipt_status), Integer.valueOf(uIMessage.getReadReceiptInfo().getRespondUserIdList().size())));
                    } else {
                        viewHolder.readReceiptStatus.setText(String.format(viewInflate.getResources().getString(R.string.rc_read_receipt_status), 0));
                    }
                    viewHolder.readReceiptStatus.setVisibility(0);
                }
            }
            viewHolder.nameView.setVisibility(8);
            viewHolder.readReceiptRequest.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    RongIMClient.getInstance().sendReadReceiptRequest(uIMessage.getMessage(), new RongIMClient.OperationCallback() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.8.1
                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                            RLog.e(MessageListAdapter.TAG, "sendReadReceiptRequest failed, errorCode = " + errorCode);
                        }

                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onSuccess() {
                            ReadReceiptInfo readReceiptInfo = uIMessage.getReadReceiptInfo();
                            if (readReceiptInfo == null) {
                                readReceiptInfo = new ReadReceiptInfo();
                                uIMessage.setReadReceiptInfo(readReceiptInfo);
                            }
                            readReceiptInfo.setIsReadReceiptMessage(true);
                            AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                            viewHolder.readReceiptStatus.setText(String.format(viewInflate.getResources().getString(R.string.rc_read_receipt_status), 0));
                            viewHolder.readReceiptRequest.setVisibility(8);
                            viewHolder.readReceiptStatus.setVisibility(0);
                        }
                    });
                }
            });
            viewHolder.readReceiptStatus.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.adapter.MessageListAdapter.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (MessageListAdapter.this.mOnItemHandlerListener != null) {
                        MessageListAdapter.this.mOnItemHandlerListener.onReadReceiptStateClick(uIMessage.getMessage());
                    }
                }
            });
            if (!messageProviderTag.showWarning()) {
                viewHolder.warning.setVisibility(8);
            }
        } else {
            if (messageProviderTag.showPortrait()) {
                viewHolder.rightIconView.setVisibility(8);
                viewHolder.leftIconView.setVisibility(0);
            } else {
                viewHolder.leftIconView.setVisibility(8);
                viewHolder.rightIconView.setVisibility(8);
            }
            if (messageProviderTag.centerInHorizontal()) {
                setGravity(viewHolder.layout, 17);
                viewHolder.contentView.containerViewCenter();
                viewHolder.nameView.setGravity(1);
                viewHolder.contentView.setBackgroundColor(0);
            } else {
                setGravity(viewHolder.layout, 3);
                viewHolder.contentView.containerViewLeft();
                viewHolder.nameView.setGravity(3);
            }
            viewHolder.progressBar.setVisibility(8);
            viewHolder.warning.setVisibility(8);
            viewHolder.readReceipt.setVisibility(8);
            viewHolder.readReceiptRequest.setVisibility(8);
            viewHolder.readReceiptStatus.setVisibility(8);
            viewHolder.nameView.setVisibility(0);
            if (uIMessage.getConversationType() == Conversation.ConversationType.PRIVATE || !messageProviderTag.showSummaryWithName() || uIMessage.getConversationType() == Conversation.ConversationType.PUBLIC_SERVICE || uIMessage.getConversationType() == Conversation.ConversationType.APP_PUBLIC_SERVICE) {
                viewHolder.nameView.setVisibility(8);
            } else {
                UserInfo userInfo = uIMessage.getUserInfo();
                if (uIMessage.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE) && uIMessage.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                    if (userInfo == null && uIMessage.getMessage() != null && uIMessage.getMessage().getContent() != null) {
                        userInfo = uIMessage.getMessage().getContent().getUserInfo();
                    }
                    if (userInfo != null) {
                        viewHolder.nameView.setText(userInfo.getName());
                    } else {
                        viewHolder.nameView.setText(uIMessage.getSenderUserId());
                    }
                } else if (uIMessage.getConversationType() == Conversation.ConversationType.GROUP) {
                    GroupUserInfo groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(uIMessage.getTargetId(), uIMessage.getSenderUserId());
                    if (groupUserInfo == null || TextUtils.isEmpty(groupUserInfo.getNickname())) {
                        if (userInfo == null) {
                            userInfo = RongUserInfoManager.getInstance().getUserInfo(uIMessage.getSenderUserId());
                        }
                        if (userInfo == null) {
                            viewHolder.nameView.setText(uIMessage.getSenderUserId());
                        } else {
                            viewHolder.nameView.setText(userInfo.getName());
                        }
                    } else {
                        viewHolder.nameView.setText(groupUserInfo.getNickname());
                    }
                } else {
                    if (userInfo == null) {
                        userInfo = RongUserInfoManager.getInstance().getUserInfo(uIMessage.getSenderUserId());
                    }
                    if (userInfo == null) {
                        viewHolder.nameView.setText(uIMessage.getSenderUserId());
                    } else {
                        viewHolder.nameView.setText(userInfo.getName());
                    }
                }
            }
        }
        if (viewHolder.rightIconView.getVisibility() == 0) {
            UserInfo userInfo2 = uIMessage.getUserInfo();
            if (uIMessage.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE) && uIMessage.getUserInfo() != null && uIMessage.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                Uri portraitUri = userInfo2 != null ? userInfo2.getPortraitUri() : null;
                viewHolder.rightIconView.setAvatar(portraitUri != null ? portraitUri.toString() : null, 0);
            } else if ((uIMessage.getConversationType().equals(Conversation.ConversationType.PUBLIC_SERVICE) || uIMessage.getConversationType().equals(Conversation.ConversationType.APP_PUBLIC_SERVICE)) && uIMessage.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                if (userInfo2 != null) {
                    Uri portraitUri2 = userInfo2.getPortraitUri();
                    viewHolder.rightIconView.setAvatar(portraitUri2 != null ? portraitUri2.toString() : null, 0);
                } else {
                    Uri portraitUri3 = RongContext.getInstance().getPublicServiceInfoFromCache(ConversationKey.obtain(uIMessage.getTargetId(), uIMessage.getConversationType()).getKey()).getPortraitUri();
                    viewHolder.rightIconView.setAvatar(portraitUri3 != null ? portraitUri3.toString() : null, 0);
                }
            } else if (!TextUtils.isEmpty(uIMessage.getSenderUserId())) {
                if (userInfo2 == null) {
                    userInfo2 = RongUserInfoManager.getInstance().getUserInfo(uIMessage.getSenderUserId());
                }
                if (userInfo2 == null || userInfo2.getPortraitUri() == null) {
                    viewHolder.rightIconView.setAvatar(null, 0);
                } else {
                    viewHolder.rightIconView.setAvatar(userInfo2.getPortraitUri().toString(), 0);
                }
            }
        } else if (viewHolder.leftIconView.getVisibility() == 0) {
            UserInfo userInfo3 = uIMessage.getUserInfo();
            if (uIMessage.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE) && uIMessage.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                if (userInfo3 == null && uIMessage.getMessage() != null && uIMessage.getMessage().getContent() != null) {
                    userInfo3 = uIMessage.getMessage().getContent().getUserInfo();
                }
                if (userInfo3 != null) {
                    Uri portraitUri4 = userInfo3.getPortraitUri();
                    viewHolder.leftIconView.setAvatar(portraitUri4 != null ? portraitUri4.toString() : null, R.drawable.rc_cs_default_portrait);
                }
            } else if ((uIMessage.getConversationType().equals(Conversation.ConversationType.PUBLIC_SERVICE) || uIMessage.getConversationType().equals(Conversation.ConversationType.APP_PUBLIC_SERVICE)) && uIMessage.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                if (userInfo3 != null) {
                    Uri portraitUri5 = userInfo3.getPortraitUri();
                    viewHolder.leftIconView.setAvatar(portraitUri5 != null ? portraitUri5.toString() : null, 0);
                } else {
                    ConversationKey conversationKeyObtain = ConversationKey.obtain(uIMessage.getTargetId(), uIMessage.getConversationType());
                    PublicServiceProfile publicServiceInfoFromCache = conversationKeyObtain != null ? RongContext.getInstance().getPublicServiceInfoFromCache(conversationKeyObtain.getKey()) : null;
                    if (publicServiceInfoFromCache == null || publicServiceInfoFromCache.getPortraitUri() == null) {
                        viewHolder.leftIconView.setAvatar(null, 0);
                    } else {
                        viewHolder.leftIconView.setAvatar(publicServiceInfoFromCache.getPortraitUri().toString(), 0);
                    }
                }
            } else if (!TextUtils.isEmpty(uIMessage.getSenderUserId())) {
                if (userInfo3 == null) {
                    userInfo3 = RongUserInfoManager.getInstance().getUserInfo(uIMessage.getSenderUserId());
                }
                if (userInfo3 == null || userInfo3.getPortraitUri() == null) {
                    viewHolder.leftIconView.setAvatar(null, 0);
                } else {
                    viewHolder.leftIconView.setAvatar(userInfo3.getPortraitUri().toString(), 0);
                }
            }
        }
        bindViewClickEvent(view, viewInflate, i, uIMessage);
        if (messageProviderTag.hide()) {
            viewHolder.time.setVisibility(8);
            return;
        }
        if (!this.timeGone) {
            viewHolder.time.setText(RongDateUtils.getConversationFormatDate(uIMessage.getSentTime(), viewInflate.getContext()));
            if (i == 0) {
                if (uIMessage.getMessage() == null || uIMessage.getMessage().getContent() == null || !(uIMessage.getMessage().getContent() instanceof HistoryDividerMessage)) {
                    viewHolder.time.setVisibility(0);
                } else {
                    viewHolder.time.setVisibility(8);
                }
            } else if (RongDateUtils.isShowChatTime(uIMessage.getSentTime(), getItem(i - 1).getSentTime(), 180)) {
                viewHolder.time.setVisibility(0);
            } else {
                viewHolder.time.setVisibility(8);
            }
        }
        if (isShowCheckbox() && allowShowCheckButton(uIMessage.getMessage())) {
            viewHolder.checkboxLayout.setVisibility(0);
            viewHolder.message_check.setFocusable(false);
            viewHolder.message_check.setClickable(false);
            viewHolder.message_check.setChecked(uIMessage.isChecked());
        } else {
            viewHolder.checkboxLayout.setVisibility(8);
            uIMessage.setChecked(false);
        }
        OnMessageCheckedChanged onMessageCheckedChanged = this.messageCheckedChanged;
        if (onMessageCheckedChanged != null) {
            onMessageCheckedChanged.onCheckedEnable(getCheckedMessage().size() > 0);
        }
    }
}

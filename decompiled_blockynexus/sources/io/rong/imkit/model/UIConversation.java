package io.rong.imkit.model;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import io.rong.common.LibStorageUtils;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.MessageTag;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.UserInfo;
import io.rong.message.VoiceMessage;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class UIConversation implements Parcelable {
    public static final Parcelable.Creator<UIConversation> CREATOR = new Parcelable.Creator<UIConversation>() { // from class: io.rong.imkit.model.UIConversation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UIConversation createFromParcel(Parcel parcel) {
            return new UIConversation();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UIConversation[] newArray(int i) {
            return new UIConversation[i];
        }
    };
    private Spannable conversationContent;
    private long conversationTime;
    private String conversationTitle;
    private Conversation.ConversationType conversationType;
    private String draft;
    private String extra;
    private boolean extraFlag;
    private Map<String, Integer> gatheredConversations;
    private boolean isGathered;
    private boolean isMentioned;
    private boolean isTop;
    private int latestMessageId;
    private Context mContext;
    private UnreadRemindType mUnreadType;
    private MessageContent messageContent;
    private Set<String> nicknameIds;
    private Conversation.ConversationNotificationStatus notificationBlockStatus;
    private Uri portrait;
    private Message.ReceivedStatus receivedStatus;
    private String senderId;
    private UserInfo senderUserInfo;
    private Message.SentStatus sentStatus;
    private long syncReadReceiptTime;
    private String targetId;
    private int unReadMessageCount;

    public enum UnreadRemindType {
        NO_REMIND,
        REMIND_ONLY,
        REMIND_WITH_COUNTING
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildContent(Context context, UserInfo userInfo) {
        GroupUserInfo groupUserInfo;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.messageContent == null) {
            spannableStringBuilder.append((CharSequence) "");
        } else {
            ProviderTag messageProviderTag = RongContext.getInstance().getMessageProviderTag(this.messageContent.getClass());
            IContainerItemProvider.MessageProvider messageTemplate = RongContext.getInstance().getMessageTemplate(this.messageContent.getClass());
            if (messageProviderTag == null || messageTemplate == null) {
                spannableStringBuilder.append((CharSequence) "");
            } else {
                Spannable contentSummary = null;
                Context context2 = this.mContext;
                if (context2 != null && (contentSummary = messageTemplate.getContentSummary(context2, this.messageContent)) == null) {
                    contentSummary = messageTemplate.getSummary(UIMessage.obtain(Message.obtain(this.targetId, this.conversationType, this.messageContent)));
                }
                boolean zShowSummaryWithName = messageProviderTag.showSummaryWithName();
                String currentUserId = RongIM.getInstance().getCurrentUserId();
                if (contentSummary == null) {
                    spannableStringBuilder.append((CharSequence) "");
                } else {
                    if (this.messageContent instanceof VoiceMessage) {
                        boolean zIsListened = this.receivedStatus.isListened();
                        if (this.senderId.equals(currentUserId) || zIsListened) {
                            contentSummary.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.rc_text_color_secondary)), 0, contentSummary.length(), 33);
                        } else {
                            contentSummary.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.rc_voice_color)), 0, contentSummary.length(), 33);
                        }
                    }
                    if (this.isGathered) {
                        spannableStringBuilder.append((CharSequence) String.format("%s: ", RongContext.getInstance().getConversationTemplate(this.conversationType.getName()).getTitle(this.targetId))).append((CharSequence) contentSummary);
                    } else if (!TextUtils.isEmpty(this.draft) && !this.isMentioned) {
                        spannableStringBuilder.append((CharSequence) this.draft);
                    } else if (this.senderId.equals(currentUserId)) {
                        spannableStringBuilder.append((CharSequence) contentSummary);
                    } else {
                        String name = userInfo != null ? userInfo.getName() : this.senderId;
                        if ((this.conversationType.equals(Conversation.ConversationType.GROUP) || this.conversationType.equals(Conversation.ConversationType.DISCUSSION)) && zShowSummaryWithName) {
                            if (this.conversationType.equals(Conversation.ConversationType.GROUP) && (groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(this.targetId, this.senderId)) != null && !TextUtils.isEmpty(groupUserInfo.getNickname())) {
                                name = groupUserInfo.getNickname();
                            }
                            spannableStringBuilder.append((CharSequence) String.format("%s: ", name)).append((CharSequence) contentSummary);
                        } else {
                            spannableStringBuilder.append((CharSequence) contentSummary);
                        }
                    }
                }
            }
        }
        this.conversationContent = spannableStringBuilder;
    }

    private String filterConversationPortrait(String str) {
        return !TextUtils.isEmpty(str) ? str.toLowerCase().startsWith(LibStorageUtils.FILE) ? new File(str.substring(7)).exists() ? str : "" : str.toLowerCase().startsWith("http") ? str : "" : "";
    }

    public static UIConversation obtain(Context context, Message message, boolean z) {
        String title;
        Uri portraitUri;
        UIConversation uIConversation = new UIConversation(context);
        Conversation.ConversationType conversationType = message.getConversationType();
        String targetId = message.getTargetId();
        if (z) {
            title = RongContext.getInstance().getGatheredConversationTitle(context, conversationType);
            portraitUri = null;
        } else {
            title = RongContext.getInstance().getConversationTemplate(conversationType.getName()).getTitle(targetId);
            portraitUri = RongContext.getInstance().getConversationTemplate(conversationType.getName()).getPortraitUri(targetId);
        }
        Conversation.ConversationNotificationStatus conversationNotifyStatusFromCache = RongContext.getInstance().getConversationNotifyStatusFromCache(ConversationKey.obtain(targetId, conversationType));
        uIConversation.updateConversation(context, message, z);
        uIConversation.conversationTitle = title;
        if (conversationNotifyStatusFromCache == null) {
            conversationNotifyStatusFromCache = Conversation.ConversationNotificationStatus.NOTIFY;
        }
        uIConversation.notificationBlockStatus = conversationNotifyStatusFromCache;
        uIConversation.portrait = portraitUri;
        if (conversationType.equals(Conversation.ConversationType.GROUP)) {
            GroupUserInfo groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(message.getTargetId(), message.getSenderUserId());
            UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
            if (groupUserInfo == null || userInfo == null) {
                uIConversation.senderUserInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
            } else {
                uIConversation.senderUserInfo = new UserInfo(message.getSenderUserId(), groupUserInfo.getNickname(), userInfo.getPortraitUri());
                uIConversation.nicknameIds.add(message.getSenderUserId());
            }
        } else if ((conversationType.equals(Conversation.ConversationType.APP_PUBLIC_SERVICE) || conversationType.equals(Conversation.ConversationType.PUBLIC_SERVICE)) && targetId.equals(message.getSenderUserId())) {
            ConversationKey conversationKeyObtain = ConversationKey.obtain(targetId, conversationType);
            PublicServiceProfile publicServiceInfoFromCache = conversationKeyObtain != null ? RongContext.getInstance().getPublicServiceInfoFromCache(conversationKeyObtain.getKey()) : null;
            if (publicServiceInfoFromCache != null) {
                uIConversation.senderUserInfo = new UserInfo(targetId, publicServiceInfoFromCache.getName(), publicServiceInfoFromCache.getPortraitUri());
            }
        } else {
            uIConversation.senderUserInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
        }
        uIConversation.senderId = message.getSenderUserId();
        uIConversation.gatheredConversations.put(message.getConversationType().getName() + message.getTargetId(), 0);
        return uIConversation;
    }

    public void addNickname(String str) {
        this.nicknameIds.add(str);
    }

    public void clearLastMessage() {
        this.messageContent = null;
        this.latestMessageId = 0;
        this.conversationContent = null;
        this.unReadMessageCount = 0;
        this.isMentioned = false;
        this.sentStatus = Message.SentStatus.DESTROYED;
    }

    public void clearUnRead(Conversation.ConversationType conversationType, String str) {
        if (!this.isGathered) {
            this.unReadMessageCount = 0;
            this.isMentioned = false;
            return;
        }
        this.gatheredConversations.put(conversationType.getName() + str, 0);
        this.unReadMessageCount = 0;
        Iterator<Integer> it = this.gatheredConversations.values().iterator();
        while (it.hasNext()) {
            this.unReadMessageCount += it.next().intValue();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Spannable getConversationContent() {
        return this.conversationContent;
    }

    public boolean getConversationGatherState() {
        return this.isGathered;
    }

    public String getConversationSenderId() {
        return this.senderId;
    }

    public String getConversationTargetId() {
        return this.targetId;
    }

    public Conversation.ConversationType getConversationType() {
        return this.conversationType;
    }

    public String getDraft() {
        return this.draft;
    }

    public String getExtra() {
        return this.extra;
    }

    public boolean getExtraFlag() {
        return this.extraFlag;
    }

    public Uri getIconUrl() {
        return this.portrait;
    }

    public int getLatestMessageId() {
        return this.latestMessageId;
    }

    public boolean getMentionedFlag() {
        return this.isMentioned;
    }

    public MessageContent getMessageContent() {
        return this.messageContent;
    }

    public Conversation.ConversationNotificationStatus getNotificationStatus() {
        return this.notificationBlockStatus;
    }

    public Message.SentStatus getSentStatus() {
        return this.sentStatus;
    }

    public long getSyncReadReceiptTime() {
        return this.syncReadReceiptTime;
    }

    public long getUIConversationTime() {
        return this.conversationTime;
    }

    public String getUIConversationTitle() {
        return this.conversationTitle;
    }

    public int getUnReadMessageCount() {
        return this.unReadMessageCount;
    }

    public UnreadRemindType getUnReadType() {
        return this.mUnreadType;
    }

    public boolean hasNickname(String str) {
        return this.nicknameIds.contains(str);
    }

    public boolean isTop() {
        return this.isTop;
    }

    public void removeNickName(String str) {
        this.nicknameIds.remove(str);
    }

    public void setConversationContent(Spannable spannable) {
        this.conversationContent = spannable;
    }

    public void setConversationGatherState(boolean z) {
        this.isGathered = z;
    }

    public void setConversationSenderId(String str) {
        this.senderId = str;
    }

    public void setConversationTargetId(String str) {
        this.targetId = str;
    }

    public void setConversationType(Conversation.ConversationType conversationType) {
        this.conversationType = conversationType;
    }

    public void setDraft(String str) {
        this.draft = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setExtraFlag(boolean z) {
        this.extraFlag = z;
    }

    public void setIconUrl(Uri uri) {
        this.portrait = uri;
    }

    public void setLatestMessageId(int i) {
        this.latestMessageId = i;
    }

    public void setMentionedFlag(boolean z) {
        this.isMentioned = z;
    }

    public void setMessageContent(MessageContent messageContent) {
        this.messageContent = messageContent;
    }

    public void setNotificationStatus(Conversation.ConversationNotificationStatus conversationNotificationStatus) {
        this.notificationBlockStatus = conversationNotificationStatus;
    }

    public void setSentStatus(Message.SentStatus sentStatus) {
        this.sentStatus = sentStatus;
    }

    public void setSyncReadReceiptTime(long j) {
        this.syncReadReceiptTime = j;
    }

    public void setTop(boolean z) {
        this.isTop = z;
    }

    public void setUIConversationTime(long j) {
        this.conversationTime = j;
    }

    public void setUIConversationTitle(String str) {
        this.conversationTitle = str;
    }

    public void setUnReadMessageCount(int i) {
        this.unReadMessageCount = i;
    }

    public void setUnreadType(UnreadRemindType unreadRemindType) {
        this.mUnreadType = unreadRemindType;
    }

    public void updateConversation(Context context, Message message, boolean z) {
        if (context == null) {
            return;
        }
        MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
        MentionedInfo mentionedInfo = message.getContent().getMentionedInfo();
        boolean z2 = false;
        boolean z3 = mentionedInfo != null && ((mentionedInfo.getType().equals(MentionedInfo.MentionedType.ALL) && !message.getSenderUserId().equals(RongIMClient.getInstance().getCurrentUserId())) || (mentionedInfo.getType().equals(MentionedInfo.MentionedType.PART) && mentionedInfo.getMentionedUserIdList() != null && mentionedInfo.getMentionedUserIdList().contains(RongIMClient.getInstance().getCurrentUserId())));
        this.conversationType = message.getConversationType();
        this.targetId = message.getTargetId();
        this.receivedStatus = message.getReceivedStatus();
        if (message.getSentTime() > this.syncReadReceiptTime) {
            this.sentStatus = message.getSentStatus();
        }
        this.conversationTime = message.getSentTime();
        this.isGathered = z;
        this.messageContent = message.getContent();
        this.latestMessageId = message.getMessageId();
        this.isMentioned = !z && (this.isMentioned || z3);
        if (messageTag != null && (messageTag.flag() & 3) == 3 && message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
            z2 = true;
        }
        if (z2 && !message.getReceivedStatus().isRead()) {
            this.unReadMessageCount++;
        }
        if (z && z2) {
            String str = this.conversationType.getName() + this.targetId;
            if (this.gatheredConversations.keySet().contains(str)) {
                Integer num = this.gatheredConversations.get(str);
                if (num != null) {
                    this.gatheredConversations.put(str, Integer.valueOf(num.intValue() + 1));
                }
            } else {
                this.gatheredConversations.put(str, 1);
            }
        }
        if (!message.getSenderUserId().equals(this.senderId)) {
            if (this.conversationType.equals(Conversation.ConversationType.GROUP)) {
                GroupUserInfo groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(message.getTargetId(), message.getSenderUserId());
                UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
                if (groupUserInfo == null || userInfo == null) {
                    this.senderUserInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
                } else {
                    this.senderUserInfo = new UserInfo(message.getSenderUserId(), groupUserInfo.getNickname(), userInfo.getPortraitUri());
                    this.nicknameIds.add(message.getSenderUserId());
                }
            } else if ((this.conversationType.equals(Conversation.ConversationType.APP_PUBLIC_SERVICE) || this.conversationType.equals(Conversation.ConversationType.PUBLIC_SERVICE)) && this.targetId.equals(message.getSenderUserId())) {
                ConversationKey conversationKeyObtain = ConversationKey.obtain(this.targetId, this.conversationType);
                PublicServiceProfile publicServiceInfoFromCache = conversationKeyObtain != null ? RongContext.getInstance().getPublicServiceInfoFromCache(conversationKeyObtain.getKey()) : null;
                if (publicServiceInfoFromCache != null) {
                    this.senderUserInfo = new UserInfo(this.targetId, publicServiceInfoFromCache.getName(), publicServiceInfoFromCache.getPortraitUri());
                }
            } else {
                this.senderUserInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
            }
            this.senderId = message.getSenderUserId();
        }
        buildContent(context, this.senderUserInfo);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    private UIConversation(Context context) {
        this.mUnreadType = UnreadRemindType.REMIND_WITH_COUNTING;
        this.mContext = context;
        this.nicknameIds = new HashSet();
        this.gatheredConversations = new HashMap();
    }

    private UIConversation() {
        this.mUnreadType = UnreadRemindType.REMIND_WITH_COUNTING;
        this.nicknameIds = new HashSet();
        this.gatheredConversations = new HashMap();
    }

    public static UIConversation obtain(Context context, Conversation conversation, boolean z) {
        UIConversation uIConversation = new UIConversation(context);
        uIConversation.gatheredConversations.put(conversation.getConversationType().getName() + conversation.getTargetId(), 0);
        uIConversation.updateConversation(context, conversation, z);
        return uIConversation;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateConversation(android.content.Context r7, io.rong.imlib.model.Conversation r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.model.UIConversation.updateConversation(android.content.Context, io.rong.imlib.model.Conversation, boolean):void");
    }

    public void updateConversation(Context context, UserInfo userInfo) {
        if (context == null) {
            return;
        }
        if (this.isGathered) {
            this.conversationTitle = RongContext.getInstance().getGatheredConversationTitle(context, this.conversationType);
            buildContent(context, userInfo);
            return;
        }
        if (!this.conversationType.equals(Conversation.ConversationType.GROUP) && !this.conversationType.equals(Conversation.ConversationType.DISCUSSION)) {
            if (this.conversationType == Conversation.ConversationType.ENCRYPTED) {
                if (this.targetId.endsWith(userInfo.getUserId())) {
                    this.conversationTitle = userInfo.getName();
                    buildContent(context, userInfo);
                    return;
                }
                return;
            }
            if (userInfo.getUserId().equals(this.targetId)) {
                this.conversationTitle = userInfo.getName();
                this.portrait = userInfo.getPortraitUri();
                buildContent(context, userInfo);
                return;
            }
            return;
        }
        if (this.senderId == null || !userInfo.getUserId().equals(this.senderId)) {
            return;
        }
        this.senderUserInfo = userInfo;
        buildContent(context, userInfo);
    }

    public void updateConversation(Context context, Group group) {
        if (context == null) {
            return;
        }
        if (this.isGathered) {
            this.conversationTitle = RongContext.getInstance().getGatheredConversationTitle(context, this.conversationType);
            buildContent(context, this.senderUserInfo);
        } else if (this.conversationType.equals(Conversation.ConversationType.GROUP) && group.getId().equals(this.targetId)) {
            this.conversationTitle = group.getName();
            this.portrait = group.getPortraitUri();
        }
    }

    public void updateConversation(Context context, Discussion discussion) {
        if (context == null) {
            return;
        }
        if (this.isGathered) {
            this.conversationTitle = RongContext.getInstance().getGatheredConversationTitle(context, this.conversationType);
            buildContent(context, this.senderUserInfo);
        } else if (this.conversationType.equals(Conversation.ConversationType.DISCUSSION) && discussion.getId().equals(this.targetId)) {
            this.conversationTitle = discussion.getName();
        }
    }

    public void updateConversation(Context context, GroupUserInfo groupUserInfo) {
        if (context == null) {
            return;
        }
        UserInfo userInfo = new UserInfo(groupUserInfo.getUserId(), groupUserInfo.getNickname(), this.portrait);
        addNickname(groupUserInfo.getUserId());
        this.senderUserInfo = new UserInfo(groupUserInfo.getUserId(), groupUserInfo.getNickname(), null);
        buildContent(context, userInfo);
    }
}

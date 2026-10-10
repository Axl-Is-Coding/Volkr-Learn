package io.rong.imkit;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imkit.model.ConversationKey;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessagePushConfig;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.UserInfo;
import io.rong.message.RecallNotificationMessage;
import io.rong.push.RongPushClient;
import io.rong.push.common.PushCacheHelper;
import io.rong.push.notification.PushNotificationMessage;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class RongNotificationManager {
    private static final String TAG = "RongNotificationManager";
    private static RongNotificationManager sS = new RongNotificationManager();
    Context mContext;
    ConcurrentHashMap<String, Message> messageMap = new ConcurrentHashMap<>();

    private RongNotificationManager() {
    }

    public static RongNotificationManager getInstance() {
        if (sS == null) {
            sS = new RongNotificationManager();
        }
        return sS;
    }

    private boolean isMentionedMessage(Message message) {
        MentionedInfo mentionedInfo = message.getContent().getMentionedInfo();
        if (mentionedInfo == null) {
            return false;
        }
        if (mentionedInfo.getType().equals(MentionedInfo.MentionedType.ALL)) {
            return true;
        }
        return mentionedInfo.getType().equals(MentionedInfo.MentionedType.PART) && mentionedInfo.getMentionedUserIdList() != null && mentionedInfo.getMentionedUserIdList().contains(RongIMClient.getInstance().getCurrentUserId());
    }

    private PushNotificationMessage transformToPushMessage(Message message, String str, String str2, String str3) {
        PushNotificationMessage pushNotificationMessage = new PushNotificationMessage();
        MessagePushConfig messagePushConfig = message.getMessagePushConfig();
        boolean z = false;
        if (messagePushConfig != null) {
            if (messagePushConfig.isForceShowDetailContent() || PushCacheHelper.getInstance().getPushContentShowStatus(this.mContext)) {
                if (TextUtils.isEmpty(messagePushConfig.getPushContent())) {
                    if ((message.getContent() instanceof RecallNotificationMessage) && message.getConversationType().equals(Conversation.ConversationType.PRIVATE)) {
                        str = this.mContext.getString(R.string.rc_recalled_a_message).trim();
                    }
                    pushNotificationMessage.setPushContent(str);
                } else {
                    pushNotificationMessage.setPushContent(messagePushConfig.getPushContent());
                }
                z = true;
            } else {
                pushNotificationMessage.setPushContent(this.mContext.getString(R.string.rc_receive_new_message));
            }
            if (messagePushConfig.getAndroidConfig() != null) {
                String notificationId = messagePushConfig.getAndroidConfig().getNotificationId();
                if (!TextUtils.isEmpty(notificationId)) {
                    pushNotificationMessage.setNotificationId(notificationId);
                }
                pushNotificationMessage.setChannelIdHW(messagePushConfig.getAndroidConfig().getChannelIdHW());
                pushNotificationMessage.setChannelIdMi(messagePushConfig.getAndroidConfig().getChannelIdMi());
                pushNotificationMessage.setChannelIdOPPO(messagePushConfig.getAndroidConfig().getChannelIdOPPO());
            }
            if (!TextUtils.isEmpty(messagePushConfig.getPushTitle())) {
                pushNotificationMessage.setPushTitle(messagePushConfig.getPushTitle());
            }
            if (!TextUtils.isEmpty(messagePushConfig.getPushData())) {
                pushNotificationMessage.setPushData(messagePushConfig.getPushData());
            }
        } else if (PushCacheHelper.getInstance().getPushContentShowStatus(this.mContext)) {
            if ((message.getContent() instanceof RecallNotificationMessage) && message.getConversationType().equals(Conversation.ConversationType.PRIVATE)) {
                str = this.mContext.getString(R.string.rc_recalled_a_message).trim();
            }
            pushNotificationMessage.setPushContent(str);
            z = true;
        } else {
            pushNotificationMessage.setPushContent(this.mContext.getString(R.string.rc_receive_new_message));
        }
        if (message.getContent() instanceof RecallNotificationMessage) {
            pushNotificationMessage.setObjectName("RC:RcNtf");
        } else {
            pushNotificationMessage.setObjectName(message.getObjectName());
        }
        pushNotificationMessage.setShowDetail(z);
        pushNotificationMessage.setConversationType(RongPushClient.ConversationType.setValue(message.getConversationType().getValue()));
        pushNotificationMessage.setTargetId(message.getTargetId());
        pushNotificationMessage.setTargetUserName(str2);
        pushNotificationMessage.setSenderId(message.getSenderUserId());
        pushNotificationMessage.setSenderName(str3);
        pushNotificationMessage.setPushFlag("false");
        pushNotificationMessage.setToId(RongIMClient.getInstance().getCurrentUserId());
        pushNotificationMessage.setSourceType(PushNotificationMessage.PushSourceType.LOCAL_MESSAGE);
        pushNotificationMessage.setPushId(message.getUId());
        return pushNotificationMessage;
    }

    public void init(Context context) {
        this.mContext = context;
        this.messageMap.clear();
        if (RongContext.getInstance().getEventBus().isRegistered(this)) {
            return;
        }
        RongContext.getInstance().getEventBus().register(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onEventMainThread(UserInfo userInfo) {
        String name;
        String string;
        Conversation.ConversationType[] conversationTypeArr = {Conversation.ConversationType.PRIVATE, Conversation.ConversationType.GROUP, Conversation.ConversationType.DISCUSSION, Conversation.ConversationType.CUSTOMER_SERVICE, Conversation.ConversationType.CHATROOM, Conversation.ConversationType.SYSTEM};
        RLog.i(TAG, "onEventMainThread. userInfo" + userInfo);
        for (Conversation.ConversationType conversationType : conversationTypeArr) {
            String key = ConversationKey.obtain(userInfo.getUserId(), conversationType).getKey();
            if (this.messageMap.containsKey(key)) {
                Message message = this.messageMap.get(key);
                Spannable contentSummary = RongContext.getInstance().getMessageTemplate(message.getContent().getClass()).getContentSummary(this.mContext, message.getContent());
                this.messageMap.remove(key);
                if (conversationType.equals(Conversation.ConversationType.GROUP)) {
                    Group groupInfo = RongUserInfoManager.getInstance().getGroupInfo(message.getTargetId());
                    GroupUserInfo groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(message.getTargetId(), message.getSenderUserId());
                    if (groupInfo == null) {
                        RLog.e(TAG, "onEventMainThread userInfo : groupInfo is null, return directly");
                        return;
                    }
                    name = groupInfo.getName();
                    String nickname = groupUserInfo != null ? groupUserInfo.getNickname() : "";
                    if (TextUtils.isEmpty(nickname) && userInfo != null) {
                        nickname = userInfo.getName();
                        RLog.d(TAG, "onReceiveMessageFromApp the nickName of group user is null");
                    }
                    if (!isMentionedMessage(message)) {
                        string = nickname + " : " + contentSummary.toString();
                    } else if (TextUtils.isEmpty(message.getContent().getMentionedInfo().getMentionedContent())) {
                        string = this.mContext.getString(R.string.rc_message_content_mentioned) + nickname + " : " + contentSummary.toString();
                    } else {
                        string = message.getContent().getMentionedInfo().getMentionedContent();
                    }
                } else if (conversationType.equals(Conversation.ConversationType.DISCUSSION)) {
                    Discussion discussionInfo = RongUserInfoManager.getInstance().getDiscussionInfo(message.getTargetId());
                    name = discussionInfo != null ? discussionInfo.getName() : "";
                    if (!isMentionedMessage(message)) {
                        string = userInfo.getName() + " : " + contentSummary.toString();
                    } else if (TextUtils.isEmpty(message.getContent().getMentionedInfo().getMentionedContent())) {
                        string = this.mContext.getString(R.string.rc_message_content_mentioned) + userInfo.getName() + " : " + contentSummary.toString();
                    } else {
                        string = message.getContent().getMentionedInfo().getMentionedContent();
                    }
                } else if (conversationType.equals(Conversation.ConversationType.ENCRYPTED)) {
                    name = userInfo.getName();
                    string = this.mContext.getString(R.string.rc_receive_new_message);
                } else {
                    name = userInfo.getName();
                    string = contentSummary.toString();
                }
                if (TextUtils.isEmpty(name)) {
                    return;
                } else {
                    RongPushClient.sendNotification(this.mContext, transformToPushMessage(message, string, name, ""));
                }
            }
        }
    }

    public void onReceiveMessageFromApp(Message message) {
        onReceiveMessageFromApp(message, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onReceiveMessageFromApp(Message message, int i) {
        PublicServiceProfile publicServiceInfoFromCache;
        String mentionedContent;
        String string;
        Conversation.ConversationType conversationType = message.getConversationType();
        IContainerItemProvider.MessageProvider messageTemplate = RongContext.getInstance().getMessageTemplate(message.getContent().getClass());
        if (messageTemplate == null) {
            return;
        }
        Spannable contentSummary = messageTemplate.getContentSummary(this.mContext, message.getContent());
        ConversationKey conversationKeyObtain = ConversationKey.obtain(message.getTargetId(), message.getConversationType());
        if (conversationKeyObtain == null) {
            RLog.e(TAG, "onReceiveMessageFromApp targetKey is null");
        }
        RLog.i(TAG, "onReceiveMessageFromApp. conversationType:" + conversationType);
        if (contentSummary == null) {
            RLog.e(TAG, "onReceiveMessageFromApp Content is null. Return directly.");
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.PRIVATE) || conversationType.equals(Conversation.ConversationType.CUSTOMER_SERVICE) || conversationType.equals(Conversation.ConversationType.CHATROOM) || conversationType.equals(Conversation.ConversationType.SYSTEM)) {
            UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(message.getTargetId());
            String name = (message.getMessagePushConfig() == null || TextUtils.isEmpty(message.getMessagePushConfig().getPushTitle())) ? userInfo != null ? userInfo.getName() : null : message.getMessagePushConfig().getPushTitle();
            if (!TextUtils.isEmpty(name)) {
                RongPushClient.sendNotification(this.mContext, transformToPushMessage(message, contentSummary.toString(), name, name), i);
                return;
            }
            if (conversationKeyObtain != null) {
                this.messageMap.put(conversationKeyObtain.getKey(), message);
            }
            RLog.e(TAG, "No popup notification cause of the sender name is null, please set UserInfoProvider");
            return;
        }
        if (conversationType.equals(Conversation.ConversationType.GROUP)) {
            Group groupInfo = RongUserInfoManager.getInstance().getGroupInfo(message.getTargetId());
            UserInfo userInfo2 = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
            GroupUserInfo groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(message.getTargetId(), message.getSenderUserId());
            String name2 = groupInfo != null ? groupInfo.getName() : null;
            String nickname = groupUserInfo != null ? groupUserInfo.getNickname() : "";
            if (TextUtils.isEmpty(nickname) && userInfo2 != null) {
                nickname = userInfo2.getName();
                RLog.d(TAG, "onReceiveMessageFromApp the nickName of group user is null");
            }
            if (TextUtils.isEmpty(name2) || TextUtils.isEmpty(nickname)) {
                if (TextUtils.isEmpty(name2) && conversationKeyObtain != null) {
                    this.messageMap.put(conversationKeyObtain.getKey(), message);
                }
                if (TextUtils.isEmpty(nickname)) {
                    ConversationKey conversationKeyObtain2 = ConversationKey.obtain(message.getSenderUserId(), conversationType);
                    if (conversationKeyObtain2 != null) {
                        this.messageMap.put(conversationKeyObtain2.getKey(), message);
                    } else {
                        RLog.e(TAG, "onReceiveMessageFromApp senderKey is null");
                    }
                }
                RLog.e(TAG, "No popup notification cause of the sender name is null, please set UserInfoProvider");
                return;
            }
            if (isMentionedMessage(message)) {
                if (TextUtils.isEmpty(message.getContent().getMentionedInfo().getMentionedContent())) {
                    string = this.mContext.getString(R.string.rc_message_content_mentioned) + nickname + " : " + contentSummary.toString();
                } else {
                    string = message.getContent().getMentionedInfo().getMentionedContent();
                }
            } else if (message.getContent() instanceof RecallNotificationMessage) {
                string = contentSummary.toString();
            } else {
                string = nickname + " : " + contentSummary.toString();
            }
            RongPushClient.sendNotification(this.mContext, transformToPushMessage(message, string, name2, ""), i);
            return;
        }
        if (!conversationType.equals(Conversation.ConversationType.DISCUSSION)) {
            if (conversationType.equals(Conversation.ConversationType.PUBLIC_SERVICE) || conversationType.getName().equals(Conversation.PublicServiceType.APP_PUBLIC_SERVICE.getName())) {
                String name3 = (conversationKeyObtain == null || (publicServiceInfoFromCache = RongContext.getInstance().getPublicServiceInfoFromCache(conversationKeyObtain.getKey())) == null) ? null : publicServiceInfoFromCache.getName();
                if (!TextUtils.isEmpty(name3)) {
                    RongPushClient.sendNotification(this.mContext, transformToPushMessage(message, contentSummary.toString(), name3, ""), i);
                    return;
                }
                if (conversationKeyObtain != null) {
                    this.messageMap.put(conversationKeyObtain.getKey(), message);
                }
                RLog.e(TAG, "No popup notification cause of the sender name is null, please set UserInfoProvider");
                return;
            }
            if (conversationType.equals(Conversation.ConversationType.ENCRYPTED)) {
                String[] strArrSplit = message.getTargetId().split(";;;");
                if (strArrSplit.length < 2) {
                    RLog.e(TAG, "Error targetId for encrypted conversation.");
                    return;
                }
                String str = strArrSplit[1];
                UserInfo userInfo3 = RongUserInfoManager.getInstance().getUserInfo(str);
                if (userInfo3 != null && !TextUtils.isEmpty(userInfo3.getName())) {
                    RongPushClient.sendNotification(this.mContext, transformToPushMessage(message, this.mContext.getString(R.string.rc_receive_new_message), userInfo3.getName(), userInfo3.getName()), i);
                    return;
                }
                ConversationKey conversationKeyObtain3 = ConversationKey.obtain(str, message.getConversationType());
                if (conversationKeyObtain3 != null) {
                    this.messageMap.put(conversationKeyObtain3.getKey(), message);
                }
                RLog.e(TAG, "No popup notification cause of the sender name is null, please set UserInfoProvider");
                return;
            }
            return;
        }
        Discussion discussionInfo = RongUserInfoManager.getInstance().getDiscussionInfo(message.getTargetId());
        UserInfo userInfo4 = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
        String name4 = discussionInfo != null ? discussionInfo.getName() : null;
        String name5 = userInfo4 != null ? userInfo4.getName() : "";
        if (TextUtils.isEmpty(name4) || TextUtils.isEmpty(name5)) {
            if (TextUtils.isEmpty(name4) && conversationKeyObtain != null) {
                this.messageMap.put(conversationKeyObtain.getKey(), message);
            }
            if (TextUtils.isEmpty(name5)) {
                ConversationKey conversationKeyObtain4 = ConversationKey.obtain(message.getSenderUserId(), conversationType);
                if (conversationKeyObtain4 != null) {
                    this.messageMap.put(conversationKeyObtain4.getKey(), message);
                } else {
                    RLog.e(TAG, "onReceiveMessageFromApp senderKey is null");
                }
            }
            RLog.e(TAG, "No popup notification cause of the sender name is null, please set UserInfoProvider");
            return;
        }
        if (!isMentionedMessage(message)) {
            mentionedContent = name5 + " : " + contentSummary.toString();
        } else if (TextUtils.isEmpty(message.getContent().getMentionedInfo().getMentionedContent())) {
            mentionedContent = this.mContext.getString(R.string.rc_message_content_mentioned) + name5 + " : " + contentSummary.toString();
        } else {
            mentionedContent = message.getContent().getMentionedInfo().getMentionedContent();
        }
        RongPushClient.sendNotification(this.mContext, transformToPushMessage(message, mentionedContent, name4, ""), i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onEventMainThread(Group group) {
        String key = ConversationKey.obtain(group.getId(), Conversation.ConversationType.GROUP).getKey();
        RLog.i(TAG, "onEventMainThread. groupInfo" + group);
        if (this.messageMap.containsKey(key)) {
            Message message = this.messageMap.get(key);
            Spannable contentSummary = RongContext.getInstance().getMessageTemplate(message.getContent().getClass()).getContentSummary(this.mContext, message.getContent());
            this.messageMap.remove(key);
            UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
            if (userInfo != null) {
                String name = userInfo.getName();
                if (TextUtils.isEmpty(name)) {
                    RLog.e(TAG, "onEventMainThread Group : userName is empty, return directly");
                    return;
                }
                RongPushClient.sendNotification(this.mContext, transformToPushMessage(message, name + " : " + contentSummary.toString(), group.getName(), ""));
                return;
            }
            RLog.e(TAG, "onEventMainThread Group : userInfo is null, return directly");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onEventMainThread(Discussion discussion) {
        String name;
        String key = ConversationKey.obtain(discussion.getId(), Conversation.ConversationType.DISCUSSION).getKey();
        if (this.messageMap.containsKey(key)) {
            Message message = this.messageMap.get(key);
            Spannable contentSummary = RongContext.getInstance().getMessageTemplate(message.getContent().getClass()).getContentSummary(this.mContext, message.getContent());
            this.messageMap.remove(key);
            UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
            if (userInfo != null) {
                name = userInfo.getName();
                if (TextUtils.isEmpty(name)) {
                    return;
                }
            } else {
                name = "";
            }
            RongPushClient.sendNotification(this.mContext, transformToPushMessage(message, name + " : " + contentSummary.toString(), discussion.getName(), ""));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onEventMainThread(PublicServiceProfile publicServiceProfile) {
        String key = ConversationKey.obtain(publicServiceProfile.getTargetId(), publicServiceProfile.getConversationType()).getKey();
        if (this.messageMap.containsKey(key)) {
            Message message = this.messageMap.get(key);
            RongPushClient.sendNotification(this.mContext, transformToPushMessage(message, RongContext.getInstance().getMessageTemplate(message.getContent().getClass()).getContentSummary(this.mContext, message.getContent()).toString(), publicServiceProfile.getName(), ""));
            this.messageMap.remove(key);
        }
    }
}

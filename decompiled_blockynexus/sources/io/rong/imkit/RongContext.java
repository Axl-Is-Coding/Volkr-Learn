package io.rong.imkit;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imageloader.cache.disc.impl.ext.LruDiskCache;
import io.rong.imageloader.cache.disc.naming.Md5FileNameGenerator;
import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.ImageLoaderConfiguration;
import io.rong.imageloader.core.download.ImageDownloader;
import io.rong.imageloader.utils.L;
import io.rong.imageloader.utils.StorageUtils;
import io.rong.imkit.RongIM;
import io.rong.imkit.cache.RongCache;
import io.rong.imkit.cache.RongCacheWrap;
import io.rong.imkit.model.ConversationInfo;
import io.rong.imkit.model.ConversationKey;
import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.Event;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utils.RongAuthImageDownloader;
import io.rong.imkit.utils.StringUtils;
import io.rong.imkit.widget.provider.AppServiceConversationProvider;
import io.rong.imkit.widget.provider.CustomerServiceConversationProvider;
import io.rong.imkit.widget.provider.DiscussionConversationProvider;
import io.rong.imkit.widget.provider.EncryptedConversationProvider;
import io.rong.imkit.widget.provider.EvaluateTextMessageItemProvider;
import io.rong.imkit.widget.provider.GroupConversationProvider;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imkit.widget.provider.PrivateConversationProvider;
import io.rong.imkit.widget.provider.PublicServiceConversationProvider;
import io.rong.imkit.widget.provider.SystemConversationProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.SavePathUtils;
import io.rong.imlib.common.WeakValueHashMap;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.UserInfo;
import io.rong.push.RongPushClient;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class RongContext {
    private static final int NOTIFICATION_CACHE_MAX_COUNT = 64;
    private static final String TAG = "RongContext";
    private static ImageDownloader imageDownloader;
    private EvaluateTextMessageItemProvider evaluateTextMessageItemProvider;
    private ExecutorService executorService;
    private boolean isShowNewMessageState;
    private boolean isShowUnreadMessageState;
    private boolean isUserInfoAttached;
    private EventBus mBus;
    private RongIM.ConversationBehaviorListener mConversationBehaviorListener;
    private RongIM.ConversationClickListener mConversationClickListener;
    private RongIM.ConversationListBehaviorListener mConversationListBehaviorListener;
    private Map<String, IContainerItemProvider.ConversationProvider> mConversationProviderMap;
    private Map<String, ConversationProviderTag> mConversationTagMap;
    private List<String> mCurrentConversationList;
    private UserInfo mCurrentUserInfo;
    private RongIM.GroupInfoProvider mGroupProvider;
    private RongIM.GroupUserInfoProvider mGroupUserInfoProvider;
    private Handler mHandler;
    private RongIM.LocationProvider mLocationProvider;
    private RongIM.OnSelectMemberListener mMemberSelectListener;
    private RongCache<String, Conversation.ConversationNotificationStatus> mNotificationCache;
    private RongIM.OnSendMessageListener mOnSendMessageListener;
    private Map<Class<? extends MessageContent>, ProviderTag> mProviderMap;
    private RongIM.PublicServiceBehaviorListener mPublicServiceBehaviorListener;
    private IPublicServiceMenuClickListener mPublicServiceMenuClickListener;
    private RongIM.PublicServiceProfileProvider mPublicServiceProfileProvider;
    private List<Conversation.ConversationType> mReadReceiptConversationTypeList;
    private RongIM.RequestPermissionsListener mRequestPermissionsListener;
    private Map<Class<? extends MessageContent>, IContainerItemProvider.MessageProvider> mTemplateMap;
    private RongIM.UserInfoProvider mUserInfoProvider;
    private Map<Class<? extends MessageContent>, IContainerItemProvider.MessageProvider> mWeakTemplateMap;
    private Uri notificationSound;

    /* JADX INFO: renamed from: io.rong.imkit.RongContext$1, reason: invalid class name */
    class AnonymousClass1 extends RongCacheWrap<String, Conversation.ConversationNotificationStatus> {
        Vector<String> mRequests;

        AnonymousClass1(RongContext rongContext, int i) {
            super(rongContext, i);
            this.mRequests = new Vector<>();
        }

        @Override // io.rong.imkit.cache.RongCacheWrap
        public Conversation.ConversationNotificationStatus obtainValue(final String str) {
            if (TextUtils.isEmpty(str) || this.mRequests.contains(str)) {
                return null;
            }
            this.mRequests.add(str);
            RongContext.this.mHandler.post(new Runnable() { // from class: io.rong.imkit.RongContext.1.1
                @Override // java.lang.Runnable
                public void run() {
                    final ConversationKey conversationKeyObtain = ConversationKey.obtain(str);
                    if (conversationKeyObtain != null) {
                        RongIM.getInstance().getConversationNotificationStatus(conversationKeyObtain.getType(), conversationKeyObtain.getTargetId(), new RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus>() { // from class: io.rong.imkit.RongContext.1.1.1
                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onError(RongIMClient.ErrorCode errorCode) {
                                RunnableC02091 runnableC02091 = RunnableC02091.this;
                                AnonymousClass1.this.mRequests.remove(str);
                            }

                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onSuccess(Conversation.ConversationNotificationStatus conversationNotificationStatus) {
                                RunnableC02091 runnableC02091 = RunnableC02091.this;
                                AnonymousClass1.this.mRequests.remove(str);
                                RunnableC02091 runnableC020912 = RunnableC02091.this;
                                AnonymousClass1.this.put(str, conversationNotificationStatus);
                                AnonymousClass1.this.getContext().getEventBus().post(new Event.ConversationNotificationEvent(conversationKeyObtain.getTargetId(), conversationKeyObtain.getType(), conversationNotificationStatus));
                            }
                        });
                    }
                }
            });
            return null;
        }
    }

    /* JADX INFO: renamed from: io.rong.imkit.RongContext$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$rong$imlib$model$Conversation$ConversationType = new int[Conversation.ConversationType.values().length];

        static {
            try {
                $SwitchMap$io$rong$imlib$model$Conversation$ConversationType[Conversation.ConversationType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$Conversation$ConversationType[Conversation.ConversationType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$Conversation$ConversationType[Conversation.ConversationType.DISCUSSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$Conversation$ConversationType[Conversation.ConversationType.CHATROOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$Conversation$ConversationType[Conversation.ConversationType.CUSTOMER_SERVICE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$Conversation$ConversationType[Conversation.ConversationType.SYSTEM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$Conversation$ConversationType[Conversation.ConversationType.APP_PUBLIC_SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$rong$imlib$model$Conversation$ConversationType[Conversation.ConversationType.PUBLIC_SERVICE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private static class Holder {
        static RongContext sInstance = new RongContext(null);

        private Holder() {
        }
    }

    /* synthetic */ RongContext(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static RongContext getInstance() {
        return Holder.sInstance;
    }

    private void initCache() {
        this.mNotificationCache = new AnonymousClass1(this, 64);
    }

    public static void setImageLoaderDownloader(ImageDownloader imageDownloader2) {
        imageDownloader = imageDownloader2;
    }

    public void clearConversationNotifyStatusCache() {
        this.mNotificationCache.clear();
    }

    public void executorBackground(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.executorService.execute(runnable);
    }

    public RongIM.ConversationBehaviorListener getConversationBehaviorListener() {
        return this.mConversationBehaviorListener;
    }

    public RongIM.ConversationClickListener getConversationClickListener() {
        return this.mConversationClickListener;
    }

    public RongIM.ConversationListBehaviorListener getConversationListBehaviorListener() {
        return this.mConversationListBehaviorListener;
    }

    public Object getConversationListener() {
        RongIM.ConversationClickListener conversationClickListener = this.mConversationClickListener;
        if (conversationClickListener != null) {
            return conversationClickListener;
        }
        RongIM.ConversationBehaviorListener conversationBehaviorListener = this.mConversationBehaviorListener;
        if (conversationBehaviorListener != null) {
            return conversationBehaviorListener;
        }
        return null;
    }

    public Conversation.ConversationNotificationStatus getConversationNotifyStatusFromCache(ConversationKey conversationKey) {
        if (conversationKey == null || conversationKey.getKey() == null) {
            return null;
        }
        return this.mNotificationCache.get(conversationKey.getKey());
    }

    public ConversationProviderTag getConversationProviderTag(String str) {
        if (this.mConversationProviderMap.containsKey(str)) {
            return this.mConversationTagMap.get(str);
        }
        throw new RuntimeException("the conversation type hasn't been registered!");
    }

    public IContainerItemProvider.ConversationProvider getConversationTemplate(String str) {
        return this.mConversationProviderMap.get(str);
    }

    public List<ConversationInfo> getCurrentConversationList() {
        ArrayList arrayList = new ArrayList();
        int size = this.mCurrentConversationList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                ConversationKey conversationKeyObtain = ConversationKey.obtain(this.mCurrentConversationList.get(i));
                arrayList.add(ConversationInfo.obtain(conversationKeyObtain.getType(), conversationKeyObtain.getTargetId()));
            }
        }
        return arrayList;
    }

    public UserInfo getCurrentUserInfo() {
        UserInfo userInfo = this.mCurrentUserInfo;
        if (userInfo != null) {
            return userInfo;
        }
        return null;
    }

    ImageLoaderConfiguration getDefaultConfig(Context context) {
        File file;
        String internalCachePath = FileUtils.getInternalCachePath(context, "image");
        if (TextUtils.isEmpty(internalCachePath)) {
            file = StorageUtils.getOwnCacheDirectory(context, context.getPackageName() + "/cache/image/");
        } else {
            file = new File(internalCachePath);
        }
        try {
            ImageLoaderConfiguration.Builder builderDefaultDisplayImageOptions = new ImageLoaderConfiguration.Builder(context).threadPoolSize(3).threadPriority(3).denyCacheImageMultipleSizesInMemory().diskCache(new LruDiskCache(file, new Md5FileNameGenerator(), 0L)).defaultDisplayImageOptions(DisplayImageOptions.createSimple());
            if (imageDownloader != null) {
                builderDefaultDisplayImageOptions.imageDownloader(imageDownloader);
            } else {
                builderDefaultDisplayImageOptions.imageDownloader(new RongAuthImageDownloader(context));
            }
            ImageLoaderConfiguration imageLoaderConfigurationBuild = !SavePathUtils.isSavePathEmpty() ? builderDefaultDisplayImageOptions.build(SavePathUtils.getSavePath()) : builderDefaultDisplayImageOptions.build();
            L.writeLogs(false);
            return imageLoaderConfigurationBuild;
        } catch (IOException unused) {
            RLog.i(TAG, "Use default ImageLoader config.");
            return !SavePathUtils.isSavePathEmpty() ? ImageLoaderConfiguration.createDefault(context, SavePathUtils.getSavePath()) : ImageLoaderConfiguration.createDefault(context);
        }
    }

    public Discussion getDiscussionInfoFromCache(String str) {
        return RongUserInfoManager.getInstance().getDiscussionInfo(str);
    }

    public EvaluateTextMessageItemProvider getEvaluateProvider() {
        if (this.evaluateTextMessageItemProvider == null) {
            this.evaluateTextMessageItemProvider = new EvaluateTextMessageItemProvider();
        }
        return this.evaluateTextMessageItemProvider;
    }

    public EventBus getEventBus() {
        return this.mBus;
    }

    public String getGatheredConversationTitle(Context context, Conversation.ConversationType conversationType) {
        switch (AnonymousClass2.$SwitchMap$io$rong$imlib$model$Conversation$ConversationType[conversationType.ordinal()]) {
            case 1:
                return context.getString(R.string.rc_conversation_list_my_private_conversation);
            case 2:
                return context.getString(R.string.rc_conversation_list_my_group);
            case 3:
                return context.getString(R.string.rc_conversation_list_my_discussion);
            case 4:
                return context.getString(R.string.rc_conversation_list_my_chatroom);
            case 5:
                return context.getString(R.string.rc_conversation_list_my_customer_service);
            case 6:
                return context.getString(R.string.rc_conversation_list_system_conversation);
            case 7:
                return context.getString(R.string.rc_conversation_list_app_public_service);
            case 8:
                return context.getString(R.string.rc_conversation_list_public_service);
            default:
                System.err.print("It's not the default conversation type!!");
                return "";
        }
    }

    public Group getGroupInfoFromCache(String str) {
        if (str != null) {
            return RongUserInfoManager.getInstance().getGroupInfo(str);
        }
        return null;
    }

    public RongIM.GroupInfoProvider getGroupInfoProvider() {
        return this.mGroupProvider;
    }

    public GroupUserInfo getGroupUserInfoFromCache(String str, String str2) {
        return RongUserInfoManager.getInstance().getGroupUserInfo(str, str2);
    }

    public RongIM.GroupUserInfoProvider getGroupUserInfoProvider() {
        return this.mGroupUserInfoProvider;
    }

    public RongIM.LocationProvider getLocationProvider() {
        return this.mLocationProvider;
    }

    public RongIM.OnSelectMemberListener getMemberSelectListener() {
        return this.mMemberSelectListener;
    }

    public ProviderTag getMessageProviderTag(Class<? extends MessageContent> cls) {
        return this.mProviderMap.get(cls);
    }

    public IContainerItemProvider.MessageProvider getMessageTemplate(Class<? extends MessageContent> cls) {
        IContainerItemProvider.MessageProvider messageProvider = this.mWeakTemplateMap.get(cls);
        if (messageProvider == null) {
            try {
                if (this.mTemplateMap == null || this.mTemplateMap.get(cls) == null) {
                    RLog.e(TAG, "The template of message can't be null. type :" + cls);
                } else {
                    IContainerItemProvider.MessageProvider messageProvider2 = (IContainerItemProvider.MessageProvider) this.mTemplateMap.get(cls).clone();
                    try {
                        this.mWeakTemplateMap.put(cls, messageProvider2);
                        messageProvider = messageProvider2;
                    } catch (CloneNotSupportedException e2) {
                        e = e2;
                        messageProvider = messageProvider2;
                        RLog.e(TAG, "getMessageTemplate", e);
                    }
                }
            } catch (CloneNotSupportedException e3) {
                e = e3;
            }
        }
        return messageProvider;
    }

    public boolean getNewMessageState() {
        return this.isShowNewMessageState;
    }

    public Uri getNotificationSound() {
        return this.notificationSound;
    }

    public RongIM.OnSendMessageListener getOnSendMessageListener() {
        return this.mOnSendMessageListener;
    }

    public RongIM.PublicServiceBehaviorListener getPublicServiceBehaviorListener() {
        return this.mPublicServiceBehaviorListener;
    }

    public PublicServiceProfile getPublicServiceInfoFromCache(String str) {
        String arg1 = StringUtils.getArg1(str);
        int i = Integer.parseInt(StringUtils.getArg2(str));
        return RongUserInfoManager.getInstance().getPublicServiceProfile(i == Conversation.PublicServiceType.PUBLIC_SERVICE.getValue() ? Conversation.PublicServiceType.PUBLIC_SERVICE : i == Conversation.PublicServiceType.APP_PUBLIC_SERVICE.getValue() ? Conversation.PublicServiceType.APP_PUBLIC_SERVICE : null, arg1);
    }

    public IPublicServiceMenuClickListener getPublicServiceMenuClickListener() {
        return this.mPublicServiceMenuClickListener;
    }

    public RongIM.PublicServiceProfileProvider getPublicServiceProfileProvider() {
        return this.mPublicServiceProfileProvider;
    }

    public RongIM.RequestPermissionsListener getRequestPermissionListener() {
        return this.mRequestPermissionsListener;
    }

    public boolean getUnreadMessageState() {
        return this.isShowUnreadMessageState;
    }

    public boolean getUserInfoAttachedState() {
        return this.isUserInfoAttached;
    }

    public UserInfo getUserInfoFromCache(String str) {
        if (str != null) {
            return RongUserInfoManager.getInstance().getUserInfo(str);
        }
        return null;
    }

    RongIM.UserInfoProvider getUserInfoProvider() {
        return this.mUserInfoProvider;
    }

    void initRegister() {
        registerConversationTemplate(new PrivateConversationProvider());
        registerConversationTemplate(new GroupConversationProvider());
        registerConversationTemplate(new DiscussionConversationProvider());
        registerConversationTemplate(new SystemConversationProvider());
        registerConversationTemplate(new CustomerServiceConversationProvider());
        registerConversationTemplate(new AppServiceConversationProvider());
        registerConversationTemplate(new PublicServiceConversationProvider());
        registerConversationTemplate(new EncryptedConversationProvider());
    }

    public boolean isReadReceiptConversationType(Conversation.ConversationType conversationType) {
        List<Conversation.ConversationType> list = this.mReadReceiptConversationTypeList;
        if (list != null) {
            return list.contains(conversationType);
        }
        RLog.d(TAG, "isReadReceiptConversationType mReadReceiptConversationTypeList is null");
        return false;
    }

    public void registerConversationInfo(ConversationInfo conversationInfo) {
        ConversationKey conversationKeyObtain;
        if (conversationInfo == null || (conversationKeyObtain = ConversationKey.obtain(conversationInfo.getTargetId(), conversationInfo.getConversationType())) == null || this.mCurrentConversationList.contains(conversationKeyObtain.getKey())) {
            return;
        }
        this.mCurrentConversationList.add(conversationKeyObtain.getKey());
    }

    public void registerConversationTemplate(IContainerItemProvider.ConversationProvider conversationProvider) {
        ConversationProviderTag conversationProviderTag = (ConversationProviderTag) conversationProvider.getClass().getAnnotation(ConversationProviderTag.class);
        if (conversationProviderTag == null) {
            throw new RuntimeException("No ConversationProviderTag added with your provider!");
        }
        this.mConversationProviderMap.put(conversationProviderTag.conversationType(), conversationProvider);
        this.mConversationTagMap.put(conversationProviderTag.conversationType(), conversationProviderTag);
    }

    public void registerMessageTemplate(IContainerItemProvider.MessageProvider messageProvider) {
        ProviderTag providerTag = (ProviderTag) messageProvider.getClass().getAnnotation(ProviderTag.class);
        if (providerTag == null) {
            throw new RuntimeException("ProviderTag not def MessageContent type");
        }
        this.mTemplateMap.put(providerTag.messageContent(), messageProvider);
        this.mProviderMap.put(providerTag.messageContent(), providerTag);
    }

    public void removeConversationNotifyStatusFromCache(ConversationKey conversationKey) {
        this.mNotificationCache.remove(conversationKey.getKey());
    }

    public void setConversationBehaviorListener(RongIM.ConversationBehaviorListener conversationBehaviorListener) {
        this.mConversationBehaviorListener = conversationBehaviorListener;
    }

    public void setConversationClickListener(RongIM.ConversationClickListener conversationClickListener) {
        this.mConversationClickListener = conversationClickListener;
    }

    public void setConversationListBehaviorListener(RongIM.ConversationListBehaviorListener conversationListBehaviorListener) {
        this.mConversationListBehaviorListener = conversationListBehaviorListener;
    }

    public void setConversationNotifyStatusToCache(ConversationKey conversationKey, Conversation.ConversationNotificationStatus conversationNotificationStatus) {
        this.mNotificationCache.put(conversationKey.getKey(), conversationNotificationStatus);
    }

    public void setCurrentUserInfo(UserInfo userInfo) {
        this.mCurrentUserInfo = userInfo;
        if (userInfo == null || TextUtils.isEmpty(userInfo.getUserId())) {
            return;
        }
        RongUserInfoManager.getInstance().setUserInfo(userInfo);
    }

    void setGetGroupInfoProvider(RongIM.GroupInfoProvider groupInfoProvider, boolean z) {
        this.mGroupProvider = groupInfoProvider;
        RongUserInfoManager.getInstance().setIsCacheGroupInfo(z);
    }

    public void setGetUserInfoProvider(RongIM.UserInfoProvider userInfoProvider, boolean z) {
        this.mUserInfoProvider = userInfoProvider;
        RongUserInfoManager.getInstance().setIsCacheUserInfo(z);
    }

    public void setGroupUserInfoProvider(RongIM.GroupUserInfoProvider groupUserInfoProvider, boolean z) {
        this.mGroupUserInfoProvider = groupUserInfoProvider;
        RongUserInfoManager.getInstance().setIsCacheGroupUserInfo(z);
    }

    public void setLocationProvider(RongIM.LocationProvider locationProvider) {
        this.mLocationProvider = locationProvider;
    }

    public void setNotificationSound(Uri uri) {
        this.notificationSound = uri;
        RongPushClient.setNotifiationSound(uri);
    }

    public void setOnMemberSelectListener(RongIM.OnSelectMemberListener onSelectMemberListener) {
        this.mMemberSelectListener = onSelectMemberListener;
    }

    public void setOnSendMessageListener(RongIM.OnSendMessageListener onSendMessageListener) {
        this.mOnSendMessageListener = onSendMessageListener;
    }

    public void setPublicServiceBehaviorListener(RongIM.PublicServiceBehaviorListener publicServiceBehaviorListener) {
        this.mPublicServiceBehaviorListener = publicServiceBehaviorListener;
    }

    public void setPublicServiceMenuClickListener(IPublicServiceMenuClickListener iPublicServiceMenuClickListener) {
        this.mPublicServiceMenuClickListener = iPublicServiceMenuClickListener;
    }

    public void setPublicServiceProfileProvider(RongIM.PublicServiceProfileProvider publicServiceProfileProvider) {
        this.mPublicServiceProfileProvider = publicServiceProfileProvider;
    }

    void setReadReceiptConversationTypeList(Conversation.ConversationType... conversationTypeArr) {
        if (conversationTypeArr == null) {
            RLog.d(TAG, "setReadReceiptConversationTypeList parameter is null");
            return;
        }
        this.mReadReceiptConversationTypeList.clear();
        for (Conversation.ConversationType conversationType : conversationTypeArr) {
            this.mReadReceiptConversationTypeList.add(conversationType);
        }
    }

    public void setRequestPermissionListener(RongIM.RequestPermissionsListener requestPermissionsListener) {
        this.mRequestPermissionsListener = requestPermissionsListener;
    }

    public void setUserInfoAttachedState(boolean z) {
        this.isUserInfoAttached = z;
    }

    public void showNewMessageIcon(boolean z) {
        this.isShowNewMessageState = z;
    }

    public void showUnreadMessageIcon(boolean z) {
        this.isShowUnreadMessageState = z;
    }

    public void unregisterConversationInfo(ConversationInfo conversationInfo) {
        ConversationKey conversationKeyObtain;
        if (conversationInfo == null || (conversationKeyObtain = ConversationKey.obtain(conversationInfo.getTargetId(), conversationInfo.getConversationType())) == null || this.mCurrentConversationList.size() <= 0) {
            return;
        }
        this.mCurrentConversationList.remove(conversationKeyObtain.getKey());
    }

    private RongContext() {
        this.mBus = EventBus.getDefault();
        this.mHandler = new Handler();
        this.mTemplateMap = new HashMap();
        this.mWeakTemplateMap = new WeakValueHashMap();
        this.mProviderMap = new HashMap();
        this.mConversationProviderMap = new HashMap();
        this.mConversationTagMap = new HashMap();
        this.mCurrentConversationList = new ArrayList();
        this.mReadReceiptConversationTypeList = new ArrayList();
        this.mReadReceiptConversationTypeList.add(Conversation.ConversationType.PRIVATE);
        initCache();
        this.executorService = Executors.newSingleThreadExecutor();
    }
}

package io.rong.imkit.userInfoCache;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tendcloud.tenddata.ab;
import io.rong.common.RLog;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.cache.RongCache;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.utils.StringUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.UserInfo;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RongUserInfoManager implements Handler.Callback {
    private static final int DISCUSSION_CACHE_MAX_COUNT = 16;
    private static final int EVENT_CLEAR_CACHE = 12;
    private static final int EVENT_GET_DISCUSSION = 5;
    private static final int EVENT_GET_GROUP_INFO = 3;
    private static final int EVENT_GET_GROUP_USER_INFO = 4;
    private static final int EVENT_GET_USER_INFO = 2;
    private static final int EVENT_LOGOUT = 11;
    private static final int EVENT_UPDATE_DISCUSSION = 10;
    private static final int EVENT_UPDATE_GROUP_INFO = 9;
    private static final int EVENT_UPDATE_GROUP_USER_INFO = 8;
    private static final int EVENT_UPDATE_USER_INFO = 7;
    private static final int GROUP_CACHE_MAX_COUNT = 128;
    private static final String GROUP_PREFIX = "groups";
    private static final int PUBLIC_ACCOUNT_CACHE_MAX_COUNT = 64;
    private static final String TAG = "RongUserInfoManager";
    private static final int USER_CACHE_MAX_COUNT = 256;
    private String mAppKey;
    private IRongCacheListener mCacheListener;
    private Context mContext;
    private RongCache<String, RongConversationInfo> mDiscussionCache;
    private RongCache<String, RongConversationInfo> mGroupCache;
    private RongCache<String, GroupUserInfo> mGroupUserInfoCache;
    private boolean mInitialized;
    private boolean mIsCacheGroupInfo;
    private boolean mIsCacheGroupUserInfo;
    private boolean mIsCacheUserInfo;
    private RongCache<String, PublicServiceProfile> mPublicServiceProfileCache;
    private RongCache<String, String> mRequestCache;
    private RongDatabaseDao mRongDatabaseDao;
    private String mUserId;
    private RongCache<String, UserInfo> mUserInfoCache;
    private Handler mWorkHandler;

    private static class SingletonHolder {
        static RongUserInfoManager sInstance = new RongUserInfoManager();

        private SingletonHolder() {
        }
    }

    private void clearUserInfoCache() {
        RongCache<String, UserInfo> rongCache = this.mUserInfoCache;
        if (rongCache != null) {
            rongCache.clear();
        }
        RongCache<String, RongConversationInfo> rongCache2 = this.mDiscussionCache;
        if (rongCache2 != null) {
            rongCache2.clear();
        }
        RongCache<String, RongConversationInfo> rongCache3 = this.mGroupCache;
        if (rongCache3 != null) {
            rongCache3.clear();
        }
        RongCache<String, GroupUserInfo> rongCache4 = this.mGroupUserInfoCache;
        if (rongCache4 != null) {
            rongCache4.clear();
        }
        RongCache<String, PublicServiceProfile> rongCache5 = this.mPublicServiceProfileCache;
        if (rongCache5 != null) {
            rongCache5.clear();
        }
        this.mRequestCache.clear();
    }

    public static RongUserInfoManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private void insertUserInfoInDB(UserInfo userInfo) {
        RongDatabaseDao rongDatabaseDao = this.mRongDatabaseDao;
        if (rongDatabaseDao != null) {
            rongDatabaseDao.insertUserInfo(userInfo);
        }
    }

    private UserInfo putUserInfoInCache(UserInfo userInfo) {
        RongCache<String, UserInfo> rongCache = this.mUserInfoCache;
        if (rongCache != null) {
            return rongCache.put(userInfo.getUserId(), userInfo);
        }
        return null;
    }

    private void putUserInfoInDB(UserInfo userInfo) {
        RongDatabaseDao rongDatabaseDao = this.mRongDatabaseDao;
        if (rongDatabaseDao != null) {
            rongDatabaseDao.putUserInfo(userInfo);
        }
    }

    public List<UserInfo> getAllUserInfo() {
        RLog.i(TAG, "getAllUserInfo");
        RongDatabaseDao rongDatabaseDao = this.mRongDatabaseDao;
        if (rongDatabaseDao != null) {
            return rongDatabaseDao.getAllUserInfo();
        }
        RLog.i(TAG, "mRongDatabaseDao is null");
        return null;
    }

    public Discussion getDiscussionInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        RongConversationInfo rongConversationInfo = this.mDiscussionCache.get(str);
        if (rongConversationInfo != null) {
            return new Discussion(rongConversationInfo.getId(), rongConversationInfo.getName());
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 5;
        messageObtain.obj = str;
        this.mWorkHandler.sendMessage(messageObtain);
        return null;
    }

    public Group getGroupInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        RLog.i(TAG, "getGroupInfo : " + str);
        if (!this.mIsCacheGroupInfo) {
            IRongCacheListener iRongCacheListener = this.mCacheListener;
            if (iRongCacheListener != null) {
                return iRongCacheListener.getGroupInfo(str);
            }
            return null;
        }
        RongConversationInfo rongConversationInfo = this.mGroupCache.get(str);
        if (rongConversationInfo != null) {
            return new Group(rongConversationInfo.getId(), rongConversationInfo.getName(), rongConversationInfo.getUri());
        }
        if (this.mRequestCache.get(str) != null) {
            return null;
        }
        this.mRequestCache.put(str, str);
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = str;
        this.mWorkHandler.sendMessage(messageObtain);
        if (this.mWorkHandler.hasMessages(12)) {
            return null;
        }
        this.mWorkHandler.sendEmptyMessageDelayed(12, ab.R);
        return null;
    }

    public GroupUserInfo getGroupUserInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        RLog.d(TAG, "getGroupUserInfo : " + str + ", " + str2);
        String key = StringUtils.getKey(str, str2);
        if (!this.mIsCacheGroupUserInfo) {
            IRongCacheListener iRongCacheListener = this.mCacheListener;
            if (iRongCacheListener != null) {
                return iRongCacheListener.getGroupUserInfo(str, str2);
            }
            return null;
        }
        GroupUserInfo groupUserInfo = this.mGroupUserInfoCache.get(key);
        if (groupUserInfo == null) {
            if (this.mRequestCache.get(key) != null) {
                return null;
            }
            this.mRequestCache.put(key, key);
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.obj = key;
            this.mWorkHandler.sendMessage(messageObtain);
            if (!this.mWorkHandler.hasMessages(12)) {
                this.mWorkHandler.sendEmptyMessageDelayed(12, ab.R);
            }
        }
        return groupUserInfo;
    }

    public PublicServiceProfile getPublicServiceProfile(final Conversation.PublicServiceType publicServiceType, final String str) {
        if (publicServiceType == null || TextUtils.isEmpty(str)) {
            return null;
        }
        final String key = StringUtils.getKey(publicServiceType.getValue() + "", str);
        PublicServiceProfile publicServiceProfile = this.mPublicServiceProfileCache.get(key);
        if (publicServiceProfile == null) {
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imkit.userInfoCache.RongUserInfoManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (RongContext.getInstance() == null || RongContext.getInstance().getPublicServiceProfileProvider() == null) {
                        RongIM.getInstance().getPublicServiceProfile(publicServiceType, str, new RongIMClient.ResultCallback<PublicServiceProfile>() { // from class: io.rong.imkit.userInfoCache.RongUserInfoManager.2.1
                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onError(RongIMClient.ErrorCode errorCode) {
                            }

                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onSuccess(PublicServiceProfile publicServiceProfile2) {
                                if (publicServiceProfile2 != null) {
                                    RongUserInfoManager.this.mPublicServiceProfileCache.put(key, publicServiceProfile2);
                                    if (RongUserInfoManager.this.mCacheListener != null) {
                                        RongUserInfoManager.this.mCacheListener.onPublicServiceProfileUpdated(publicServiceProfile2);
                                    }
                                }
                            }
                        });
                        return;
                    }
                    PublicServiceProfile publicServiceProfile2 = RongContext.getInstance().getPublicServiceProfileProvider().getPublicServiceProfile(publicServiceType, str);
                    if (publicServiceProfile2 != null) {
                        RongUserInfoManager.this.mPublicServiceProfileCache.put(key, publicServiceProfile2);
                        if (RongUserInfoManager.this.mCacheListener != null) {
                            RongUserInfoManager.this.mCacheListener.onPublicServiceProfileUpdated(publicServiceProfile2);
                        }
                    }
                }
            });
        }
        return publicServiceProfile;
    }

    public UserInfo getUserInfo(String str) {
        RLog.i(TAG, "getUserInfo : " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsCacheUserInfo) {
            IRongCacheListener iRongCacheListener = this.mCacheListener;
            if (iRongCacheListener != null) {
                return iRongCacheListener.getUserInfo(str);
            }
            return null;
        }
        UserInfo userInfo = this.mUserInfoCache.get(str);
        if (userInfo == null) {
            if (this.mRequestCache.get(str) != null) {
                return null;
            }
            this.mRequestCache.put(str, str);
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.obj = str;
            this.mWorkHandler.sendMessage(messageObtain);
            if (!this.mWorkHandler.hasMessages(12)) {
                this.mWorkHandler.sendEmptyMessageDelayed(12, ab.R);
            }
        }
        return userInfo;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03ba  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r10) {
        /*
            Method dump skipped, instruction units count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.userInfoCache.RongUserInfoManager.handleMessage(android.os.Message):boolean");
    }

    public void init(Context context, String str, IRongCacheListener iRongCacheListener) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "init, appkey is null.");
            return;
        }
        if (this.mInitialized) {
            RLog.d(TAG, "has been init, no need init again");
            return;
        }
        this.mContext = context;
        this.mAppKey = str;
        this.mCacheListener = iRongCacheListener;
        this.mInitialized = true;
    }

    public void setDiscussionInfo(Discussion discussion) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 10;
        messageObtain.obj = discussion;
        this.mWorkHandler.sendMessage(messageObtain);
    }

    public void setGroupInfo(Group group) {
        if (this.mIsCacheGroupInfo) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 9;
            messageObtain.obj = group;
            this.mWorkHandler.sendMessage(messageObtain);
            return;
        }
        IRongCacheListener iRongCacheListener = this.mCacheListener;
        if (iRongCacheListener != null) {
            iRongCacheListener.onGroupUpdated(group);
        }
    }

    public void setGroupUserInfo(GroupUserInfo groupUserInfo) {
        if (this.mIsCacheGroupUserInfo) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 8;
            messageObtain.obj = groupUserInfo;
            this.mWorkHandler.sendMessage(messageObtain);
            return;
        }
        IRongCacheListener iRongCacheListener = this.mCacheListener;
        if (iRongCacheListener != null) {
            iRongCacheListener.onGroupUserInfoUpdated(groupUserInfo);
        }
    }

    public void setIsCacheGroupInfo(boolean z) {
        this.mIsCacheGroupInfo = z;
    }

    public void setIsCacheGroupUserInfo(boolean z) {
        this.mIsCacheGroupUserInfo = z;
    }

    public void setIsCacheUserInfo(boolean z) {
        this.mIsCacheUserInfo = z;
    }

    public void setPublicServiceProfile(PublicServiceProfile publicServiceProfile) {
        IRongCacheListener iRongCacheListener;
        PublicServiceProfile publicServiceProfilePut = this.mPublicServiceProfileCache.put(StringUtils.getKey(publicServiceProfile.getConversationType().getValue() + "", publicServiceProfile.getTargetId()), publicServiceProfile);
        if ((publicServiceProfilePut == null || !((publicServiceProfilePut.getName() == null || publicServiceProfile.getName() == null || publicServiceProfilePut.getName().equals(publicServiceProfile.getName())) && (publicServiceProfilePut.getPortraitUri() == null || publicServiceProfile.getPortraitUri() == null || publicServiceProfilePut.getPortraitUri().toString().equals(publicServiceProfile.getPortraitUri().toString())))) && (iRongCacheListener = this.mCacheListener) != null) {
            iRongCacheListener.onPublicServiceProfileUpdated(publicServiceProfile);
        }
    }

    public void setUserInfo(UserInfo userInfo) {
        if (this.mIsCacheUserInfo) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 7;
            messageObtain.obj = userInfo;
            this.mWorkHandler.sendMessage(messageObtain);
            return;
        }
        IRongCacheListener iRongCacheListener = this.mCacheListener;
        if (iRongCacheListener != null) {
            iRongCacheListener.onUserInfoUpdated(userInfo);
        }
    }

    public void uninit() {
        RLog.i(TAG, "uninit");
        this.mWorkHandler.sendEmptyMessage(11);
    }

    private RongUserInfoManager() {
        this.mIsCacheUserInfo = true;
        this.mIsCacheGroupInfo = true;
        this.mIsCacheGroupUserInfo = true;
        this.mUserInfoCache = new RongCache<>(256);
        this.mGroupUserInfoCache = new RongCache<>(256);
        this.mGroupCache = new RongCache<>(128);
        this.mDiscussionCache = new RongCache<>(16);
        this.mRequestCache = new RongCache<>(64);
        this.mPublicServiceProfileCache = new RongCache<>(64);
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mWorkHandler = new Handler(handlerThread.getLooper(), this);
        this.mInitialized = false;
    }
}

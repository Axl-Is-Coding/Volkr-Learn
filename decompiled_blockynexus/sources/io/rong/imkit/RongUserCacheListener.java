package io.rong.imkit;

import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.userInfoCache.IRongCacheListener;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.UserInfo;

/* JADX INFO: loaded from: classes5.dex */
public class RongUserCacheListener implements IRongCacheListener {
    @Override // io.rong.imkit.userInfoCache.IRongCacheListener
    public Group getGroupInfo(String str) {
        if (RongContext.getInstance().getGroupInfoProvider() != null) {
            return RongContext.getInstance().getGroupInfoProvider().getGroupInfo(str);
        }
        return null;
    }

    @Override // io.rong.imkit.userInfoCache.IRongCacheListener
    public GroupUserInfo getGroupUserInfo(String str, String str2) {
        if (RongContext.getInstance().getGroupUserInfoProvider() != null) {
            return RongContext.getInstance().getGroupUserInfoProvider().getGroupUserInfo(str, str2);
        }
        return null;
    }

    @Override // io.rong.imkit.userInfoCache.IRongCacheListener
    public UserInfo getUserInfo(String str) {
        if (RongContext.getInstance().getUserInfoProvider() != null) {
            return RongContext.getInstance().getUserInfoProvider().getUserInfo(str);
        }
        return null;
    }

    @Override // io.rong.imkit.userInfoCache.IRongCacheListener
    public void onDiscussionUpdated(Discussion discussion) {
        if (discussion != null) {
            RongContext.getInstance().getEventBus().post(discussion);
        }
    }

    @Override // io.rong.imkit.userInfoCache.IRongCacheListener
    public void onGroupUpdated(Group group) {
        if (group != null) {
            RongContext.getInstance().getEventBus().post(group);
        }
    }

    @Override // io.rong.imkit.userInfoCache.IRongCacheListener
    public void onGroupUserInfoUpdated(GroupUserInfo groupUserInfo) {
        if (groupUserInfo != null) {
            RongContext.getInstance().getEventBus().post(groupUserInfo);
        }
    }

    @Override // io.rong.imkit.userInfoCache.IRongCacheListener
    public void onPublicServiceProfileUpdated(PublicServiceProfile publicServiceProfile) {
        if (publicServiceProfile != null) {
            RongContext.getInstance().getEventBus().post(publicServiceProfile);
        }
    }

    @Override // io.rong.imkit.userInfoCache.IRongCacheListener
    public void onUserInfoUpdated(UserInfo userInfo) {
        if (userInfo != null) {
            RongContext.getInstance().getEventBus().post(userInfo);
        }
    }
}

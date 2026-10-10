package com.sandboxol.common.utils;

import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.messenger.Messenger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class GroupUtilsProxy {
    private static GroupUtilsProxy instance;
    private long tribeId;
    private List<String> urls;
    private long userId;
    private Map<Long, List<String>> urlLib = new HashMap();
    private Map<Long, Boolean> isOfficial = new HashMap();
    private Map<Long, Long> ownerIds = new HashMap();
    private Map<Long, List<Long>> adminIds = new HashMap();

    private GroupUtilsProxy() {
    }

    public static GroupUtilsProxy getInstance() {
        if (instance == null) {
            synchronized (GroupUtilsProxy.class) {
                if (instance == null) {
                    instance = new GroupUtilsProxy();
                }
            }
        }
        return instance;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    public long getUserId() {
        return this.userId;
    }

    public boolean isGroup(long j) {
        return j != this.tribeId;
    }

    public boolean isOfficial(long j) {
        if (this.isOfficial.keySet().contains(Long.valueOf(j))) {
            return this.isOfficial.get(Long.valueOf(j)).booleanValue();
        }
        return false;
    }

    public boolean judgeAdmin(long j, long j2) {
        return this.adminIds.keySet().contains(Long.valueOf(j)) && this.adminIds.get(Long.valueOf(j)).contains(Long.valueOf(j2));
    }

    public boolean judgeOwner(long j, long j2) {
        return this.ownerIds.keySet().contains(Long.valueOf(j)) && this.ownerIds.get(Long.valueOf(j)).longValue() == j2;
    }

    public void setOfficial(long j, boolean z) {
        this.isOfficial.put(Long.valueOf(j), Boolean.valueOf(z));
    }

    public void setTribeId(long j) {
        this.tribeId = j;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void storeAdminId(long j, List<Long> list) {
        if (this.adminIds.keySet().contains(Long.valueOf(j))) {
            this.adminIds.remove(Long.valueOf(j));
        }
        this.adminIds.put(Long.valueOf(j), list);
        Messenger.getDefault().sendNoMsg(CommonMessageToken.TOKEN_REFRESH_MESSAGE_LIST);
    }

    public void storeOwnerId(long j, long j2) {
        if (this.ownerIds.keySet().contains(Long.valueOf(j))) {
            this.ownerIds.remove(Long.valueOf(j));
        }
        this.ownerIds.put(Long.valueOf(j), Long.valueOf(j2));
    }

    public void storeUrls(long j, List<String> list) {
        if (this.urlLib.keySet().contains(Long.valueOf(j))) {
            this.urlLib.remove(Long.valueOf(j));
        }
        this.urlLib.put(Long.valueOf(j), list);
    }

    public List<String> getUrls(long j) {
        return this.urlLib.get(Long.valueOf(j));
    }
}

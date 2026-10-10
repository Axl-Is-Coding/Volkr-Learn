package io.rong.imkit.utils;

import android.os.Handler;
import android.os.HandlerThread;
import io.rong.common.RLog;
import io.rong.imkit.RongContext;
import io.rong.imlib.model.MessageContent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class MessageProviderUserInfoHelper {
    private static final String TAG = "MessageProviderUserInfoHelper";
    private Handler mUserInfoHandler;
    private ConcurrentHashMap<MessageContent, List<String>> mMessageIdUserIdsMap = new ConcurrentHashMap<>();
    private ArrayList<String> cacheUserIds = new ArrayList<>();

    private static class MessageProviderUserInfoHelperHolder {
        private static MessageProviderUserInfoHelper instance = new MessageProviderUserInfoHelper();

        private MessageProviderUserInfoHelperHolder() {
        }
    }

    MessageProviderUserInfoHelper() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mUserInfoHandler = new Handler(handlerThread.getLooper());
    }

    public static MessageProviderUserInfoHelper getInstance() {
        return MessageProviderUserInfoHelperHolder.instance;
    }

    public synchronized boolean isCacheUserId(String str) {
        return this.cacheUserIds.contains(str);
    }

    public boolean isRequestGetUserInfo() {
        return !this.mMessageIdUserIdsMap.isEmpty();
    }

    public void notifyMessageUpdate(final String str) {
        this.mUserInfoHandler.postDelayed(new Runnable() { // from class: io.rong.imkit.utils.MessageProviderUserInfoHelper.1
            @Override // java.lang.Runnable
            public void run() {
                MessageProviderUserInfoHelper.this.removeCacheUserId(str);
            }
        }, 500L);
        for (Map.Entry<MessageContent, List<String>> entry : this.mMessageIdUserIdsMap.entrySet()) {
            List<String> value = entry.getValue();
            if (value != null) {
                value.remove(str);
                if (value.isEmpty()) {
                    RongContext.getInstance().getEventBus().post(entry.getKey());
                    this.mMessageIdUserIdsMap.remove(entry.getKey());
                    RLog.d(TAG, "notifyMessageUpdate --notify--" + entry.getKey().toString());
                } else {
                    RLog.d(TAG, "notifyMessageUpdate --wait--" + str);
                }
            }
        }
    }

    public void registerMessageUserInfo(MessageContent messageContent, String str) {
        RLog.i(TAG, "registerMessageUserInfo userId:" + str);
        List<String> arrayList = this.mMessageIdUserIdsMap.get(messageContent);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mMessageIdUserIdsMap.put(messageContent, arrayList);
        }
        if (!arrayList.contains(str)) {
            arrayList.add(str);
        }
        setCacheUserId(str);
    }

    synchronized void removeCacheUserId(String str) {
        this.cacheUserIds.remove(str);
    }

    synchronized void setCacheUserId(String str) {
        if (!this.cacheUserIds.contains(str)) {
            this.cacheUserIds.add(str);
        }
    }
}

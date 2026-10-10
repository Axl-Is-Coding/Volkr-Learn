package io.rong.common;

import android.text.TextUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ExpansionUtils {
    private static final int EXPANSION_SINGLE_MAX_COUNT = 20;
    private static final String TAG = "ExpansionUtils";

    public static RongIMClient.ErrorCode filterSendMessage(Message message) {
        Map<String, String> expansion = message.getExpansion();
        if (!message.isCanIncludeExpansion()) {
            if (expansion == null || expansion.size() <= 0) {
                return null;
            }
            RLog.e(TAG, "filterSendMessage : isCanIncludeExpansion is false, but expansion is not null!");
            return RongIMClient.ErrorCode.RC_MESSAGE_CANT_EXPAND;
        }
        if (message.getConversationType() != Conversation.ConversationType.PRIVATE && message.getConversationType() != Conversation.ConversationType.GROUP) {
            RLog.e(TAG, "filterSendMessage : only private or group support expansion!");
            return RongIMClient.ErrorCode.RC_MESSAGE_CANT_EXPAND;
        }
        if (judgeKVExceedLimit(expansion) || judgeExpansionExceedLimitSingleMsg(expansion)) {
            RLog.e(TAG, "filterSendMessage : key exceeds 32 bytes or value exceeds 64 bytes !");
            return RongIMClient.ErrorCode.RC_MSG_EXPANSION_SIZE_LIMIT_EXCEED;
        }
        if (!judgeKVIllegality(expansion)) {
            return null;
        }
        RLog.e(TAG, "filterSendMessage : key contains illegal characters!");
        return RongIMClient.ErrorCode.PARAMETER_ERROR;
    }

    private static boolean judgeExpansionExceedLimitSingleMsg(Map<String, String> map) {
        return map != null && map.size() > 20;
    }

    public static boolean judgeKVExceedLimit(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ((!TextUtils.isEmpty(key) && key.length() > 32) || (!TextUtils.isEmpty(value) && value.length() > 64)) {
                RLog.e(TAG, "key exceeds 32 bytes or value exceeds 64 bytes !");
                return true;
            }
        }
        return false;
    }

    public static boolean judgeKVIllegality(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getKey().matches("^[A-Za-z0-9+_=-]+$")) {
                RLog.e(TAG, "key contains illegal characters!");
                return true;
            }
        }
        return false;
    }
}

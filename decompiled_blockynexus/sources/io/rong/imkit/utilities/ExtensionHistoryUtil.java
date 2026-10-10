package io.rong.imkit.utilities;

import android.content.Context;
import io.rong.imlib.common.SharedPreferencesUtils;
import io.rong.imlib.model.Conversation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ExtensionHistoryUtil {
    private static final String EMOJI_POS = "EMOJI_POS";
    private static final String EXTENSION_BAR_STATE = "EXTENSION_BAR_STATE";
    private static boolean enableHistory;
    private static List<Conversation.ConversationType> sExceptConversationTypes = new ArrayList();

    public enum ExtensionBarState {
        NORMAL,
        VOICE
    }

    public static void addExceptConversationType(Conversation.ConversationType conversationType) {
        sExceptConversationTypes.add(conversationType);
    }

    public static int getEmojiPosition(Context context, String str) {
        if (!enableHistory) {
            return 0;
        }
        return SharedPreferencesUtils.get(context, KitCommonDefine.RONG_KIT_SP_CONFIG, 0).getInt(str + EMOJI_POS, 0);
    }

    public static ExtensionBarState getExtensionBarState(Context context, String str, Conversation.ConversationType conversationType) {
        if (!enableHistory || sExceptConversationTypes.contains(conversationType)) {
            return ExtensionBarState.NORMAL;
        }
        return ExtensionBarState.valueOf(SharedPreferencesUtils.get(context, KitCommonDefine.RONG_KIT_SP_CONFIG, 0).getString(str + EXTENSION_BAR_STATE, ExtensionBarState.NORMAL.toString()));
    }

    public static void setEmojiPosition(Context context, String str, int i) {
        if (enableHistory) {
            SharedPreferencesUtils.get(context, KitCommonDefine.RONG_KIT_SP_CONFIG, 0).edit().putInt(str + EMOJI_POS, i).commit();
        }
    }

    public static void setEnableHistory(boolean z) {
        enableHistory = z;
    }

    public static void setExtensionBarState(Context context, String str, Conversation.ConversationType conversationType, ExtensionBarState extensionBarState) {
        if (!enableHistory || sExceptConversationTypes.contains(conversationType)) {
            return;
        }
        SharedPreferencesUtils.get(context, KitCommonDefine.RONG_KIT_SP_CONFIG, 0).edit().putString(str + EXTENSION_BAR_STATE, extensionBarState.toString()).commit();
    }
}

package io.rong.imkit.widget.provider;

import android.net.Uri;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imlib.model.UserInfo;

/* JADX INFO: loaded from: classes5.dex */
@ConversationProviderTag(conversationType = "encrypted", portraitPosition = 1)
public class EncryptedConversationProvider extends PrivateConversationProvider {
    private static final String TAG = "EncryptedConversationProvider";

    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public Uri getPortraitUri(String str) {
        return Uri.parse(String.format("drawable://%d", Integer.valueOf(R.drawable.rc_encrypted_conversation_portrait)));
    }

    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public String getTitle(String str) {
        String[] strArrSplit = str.split(";;;");
        String str2 = strArrSplit.length >= 2 ? strArrSplit[1] : null;
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(str2);
        if (userInfo == null) {
            RLog.i(TAG, "targetId: " + str + ", userId: " + str2);
        }
        return userInfo == null ? str : userInfo.getName();
    }
}

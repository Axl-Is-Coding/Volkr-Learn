package com.sandboxol.imchat.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.sandboxol.greendao.c.P;
import com.sandboxol.greendao.c.ma;
import com.sandboxol.greendao.c.ra;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.PartyMemberInfo;
import com.sandboxol.greendao.entity.TribeMember;
import io.rong.imlib.model.UserInfo;

/* JADX INFO: loaded from: classes4.dex */
public class ChatDbHelper {
    public static UserInfo findUserInfo(String str) {
        try {
            if (str.contains("-")) {
                return null;
            }
            Long lValueOf = 0L;
            try {
                lValueOf = Long.valueOf(str);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            Friend friendA = P.newInstance().a(lValueOf.longValue());
            if (friendA != null) {
                String alias = friendA.getAlias();
                if (TextUtils.isEmpty(alias)) {
                    return new UserInfo(String.valueOf(friendA.getUserId()), friendA.getNickName(), friendA.getPicUrl() == null ? null : Uri.parse(friendA.getPicUrl()));
                }
                return new UserInfo(String.valueOf(friendA.getUserId()), alias, friendA.getPicUrl() == null ? null : Uri.parse(friendA.getPicUrl()));
            }
            TribeMember tribeMemberA = ra.newInstance().a(lValueOf.longValue());
            if (tribeMemberA != null) {
                return new UserInfo(String.valueOf(tribeMemberA.getUserId()), tribeMemberA.getNickName(), tribeMemberA.getHeadPic() == null ? null : Uri.parse(tribeMemberA.getHeadPic()));
            }
            PartyMemberInfo partyMemberInfoA = ma.newInstance().a(lValueOf.longValue());
            if (partyMemberInfoA != null) {
                return new UserInfo(String.valueOf(partyMemberInfoA.getUserId()), partyMemberInfoA.getNickName(), partyMemberInfoA.getPicUrl() == null ? null : Uri.parse(partyMemberInfoA.getPicUrl()));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }
}

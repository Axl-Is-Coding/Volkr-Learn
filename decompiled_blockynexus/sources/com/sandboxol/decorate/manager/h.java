package com.sandboxol.decorate.manager;

import android.content.Context;
import android.os.Bundle;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.fragment.dress.Y;

/* JADX INFO: compiled from: DressActivityManger.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static void a(Context context) {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_TRANS_TO_DRESS);
        Bundle bundle = new Bundle();
        bundle.putBoolean("otherEntrances", true);
        TemplateUtils.startTemplate(context, Y.class, context.getString(R.string.decorate_dress_shop), bundle);
    }
}

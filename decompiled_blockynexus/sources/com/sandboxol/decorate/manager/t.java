package com.sandboxol.decorate.manager;

import android.os.CountDownTimer;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;
import java.util.Iterator;

/* JADX INFO: compiled from: UserDressInfoHolder.java */
/* JADX INFO: loaded from: classes3.dex */
class t extends CountDownTimer {
    t(long j, long j2) {
        super(j, j2);
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        Iterator<Long> it = v.a().f17213b.keySet().iterator();
        while (it.hasNext()) {
            Messenger.getDefault().send(v.a().c(it.next().longValue()), MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}

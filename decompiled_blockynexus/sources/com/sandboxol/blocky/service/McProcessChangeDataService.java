package com.sandboxol.blocky.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.game.c;

/* JADX INFO: loaded from: classes.dex */
public class McProcessChangeDataService extends Service {
    private final c.a mBinder = new c.a() { // from class: com.sandboxol.blocky.service.McProcessChangeDataService.1
        @Override // com.sandboxol.game.c
        public void doHeartBeat() {
            Log.e("ProcessChange", "doHeartBeat");
        }

        @Override // com.sandboxol.game.c
        public void onDataReport(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                Messenger.getDefault().send(str, GameMessageToken.TOKEN_EVENT_MAIN_EVENT);
                Log.e("jni_onDataReport", String.format("mainEvent %s", str));
                return;
            }
            Messenger.getDefault().send(str + "," + str2, GameMessageToken.TOKEN_EVENT_MAIN_EVENT);
            Log.e("jni_onDataReport", String.format("mainEvent %s childEvent %s", str, str2));
        }

        @Override // com.sandboxol.game.c
        public void onErrorReport(String str) {
            Messenger.getDefault().send(str, GameMessageToken.TOKEN_ERROR_MAIN_ERROR);
            Log.e("jni_onErrorReport", String.format("msg %s", str));
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}

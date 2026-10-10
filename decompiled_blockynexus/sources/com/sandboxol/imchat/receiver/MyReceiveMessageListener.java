package com.sandboxol.imchat.receiver;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.SharedUtils;
import io.rong.imlib.RongIMClient;

/* JADX INFO: loaded from: classes4.dex */
public class MyReceiveMessageListener implements RongIMClient.OnReceiveMessageListener {
    private static final String AGREE_INTO_CLAN = "AgreeIntoClan";
    private static final String APP_TEAM = "app:team";
    private static final String BET_UPDATE_RESULT = "betUpdateResult";
    private static final String COLLECT_EXCHANGE = "cu:collectExchange";
    private static final String DELETE_FRIEND = "Delete";
    private static final String INTEGRAL_REWARD = "integralReward";
    private static final String JOIN_GROUP_CHAT = "joinGroupChat";
    private static final String NOTIFY_GROUP = "RC:GrpNtf";
    private static final String RC_CONTACTNTF = "RC:ContactNtf";
    private static final String RC_GIFMSG = "RC:GIFMsg";
    private static final String RC_IMGMSG = "RC:ImgMsg";
    private static final String RC_INFO_NTF = "RC:InfoNtf";
    private static final String RC_TXTMSG = "RC:TxtMsg";
    private static final String RC_VCMSG = "RC:VcMsg";
    private static final String REMOVE_FROM_CLAN = "RemoveFromClan";
    private static final String REQUEST_INTO_CLAN = "RequestIntoClan";
    private static final String STAR_CODE = "cu:videoStar";
    private static final String SUB_NOTIFY = "cu:SubNotify";
    private static final String TASK_FINISHED = "taskFinished";
    private long time;

    private void songOrShake() {
        Vibrator vibrator;
        if (System.currentTimeMillis() - this.time > 1000) {
            this.time = System.currentTimeMillis();
            if (SharedUtils.getBoolean(BaseApplication.getContext(), "is_sound", true)) {
                Uri defaultUri = RingtoneManager.getDefaultUri(2);
                Ringtone ringtone = null;
                if (defaultUri != null) {
                    try {
                        ringtone = RingtoneManager.getRingtone(BaseApplication.getContext(), defaultUri);
                    } catch (Throwable th) {
                        ReportDataAdapter.onError(BaseApplication.getContext(), th);
                    }
                    if (ringtone != null && !ringtone.isPlaying()) {
                        ringtone.play();
                    }
                }
            }
            if (!SharedUtils.getBoolean(BaseApplication.getContext(), "is_shake", true) || (vibrator = (Vibrator) BaseApplication.getContext().getSystemService("vibrator")) == null || vibrator.hasVibrator()) {
                return;
            }
            vibrator.vibrate(500L);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c5  */
    @Override // io.rong.imlib.RongIMClient.OnReceiveMessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onReceived(io.rong.imlib.model.Message r14, int r15) {
        /*
            Method dump skipped, instruction units count: 1086
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.imchat.receiver.MyReceiveMessageListener.onReceived(io.rong.imlib.model.Message, int):boolean");
    }
}

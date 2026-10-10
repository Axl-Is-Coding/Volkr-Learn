package io.rong.imkit.notification;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongNotificationManager;
import io.rong.imkit.model.ConversationInfo;
import io.rong.imkit.utils.NotificationUtil;
import io.rong.imkit.utils.SystemUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.Message;
import io.rong.message.RecallNotificationMessage;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class MessageNotificationManager {
    private static final int SOUND_INTERVAL = 3000;
    private static final String TAG = "MessageNotificationManager";
    private long lastSoundTime = 0;
    MediaPlayer mediaPlayer;
    private int spanTime;
    private String startTime;

    private static class SingletonHolder {
        static final MessageNotificationManager instance = new MessageNotificationManager();

        private SingletonHolder() {
        }
    }

    public static MessageNotificationManager getInstance() {
        return SingletonHolder.instance;
    }

    private boolean isInConversationPager(String str, Conversation.ConversationType conversationType) {
        boolean z;
        Iterator<ConversationInfo> it = RongContext.getInstance().getCurrentConversationList().iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            ConversationInfo next = it.next();
            if (str.equals(next.getTargetId()) && conversationType == next.getConversationType()) {
                z = true;
            }
        } while (!z);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notify(Context context, Message message, int i) {
        boolean zIsInBackground = SystemUtils.isInBackground(context);
        RLog.d(TAG, "isInBackground:" + zIsInBackground);
        if (message.getConversationType() == Conversation.ConversationType.CHATROOM) {
            return;
        }
        if (zIsInBackground) {
            RongNotificationManager.getInstance().onReceiveMessageFromApp(message, i);
            return;
        }
        if (isInConversationPager(message.getTargetId(), message.getConversationType()) || i != 0 || System.currentTimeMillis() - this.lastSoundTime <= 3000 || (message.getContent() instanceof RecallNotificationMessage) || message.getObjectName().equals("RCJrmf:RpOpendMsg")) {
            return;
        }
        if (!context.getResources().getBoolean(R.bool.rc_sound_in_foreground)) {
            RLog.d(TAG, "message sound is disabled in rc_config.xml");
            return;
        }
        this.lastSoundTime = System.currentTimeMillis();
        int ringerMode = NotificationUtil.getRingerMode(context);
        if (ringerMode != 0) {
            if (ringerMode != 1) {
                sound();
            }
            vibrate(context);
        }
    }

    private void sound() {
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        if (RongContext.getInstance().getNotificationSound() != null && !TextUtils.isEmpty(RongContext.getInstance().getNotificationSound().toString())) {
            defaultUri = RongContext.getInstance().getNotificationSound();
        }
        try {
            if (this.mediaPlayer != null) {
                this.mediaPlayer.stop();
                this.mediaPlayer.reset();
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
            this.mediaPlayer = new MediaPlayer();
            this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: io.rong.imkit.notification.MessageNotificationManager.2
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (mediaPlayer != null) {
                        try {
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                            mediaPlayer.release();
                        } catch (Exception e2) {
                            RLog.e(MessageNotificationManager.TAG, "sound", e2);
                        }
                    }
                    MessageNotificationManager messageNotificationManager = MessageNotificationManager.this;
                    if (messageNotificationManager.mediaPlayer != null) {
                        messageNotificationManager.mediaPlayer = null;
                    }
                }
            });
            this.mediaPlayer.setAudioStreamType(2);
            this.mediaPlayer.setDataSource(RongIM.getInstance().getApplicationContext(), defaultUri);
            this.mediaPlayer.prepare();
            this.mediaPlayer.start();
        } catch (Exception e2) {
            RLog.e(TAG, "sound", e2);
            if (this.mediaPlayer != null) {
                this.mediaPlayer = null;
            }
        }
    }

    private void vibrate(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(new long[]{0, 200, 250, 200}, -1);
        }
    }

    public void clearNotificationQuietHours() {
        this.startTime = null;
        this.spanTime = 0;
    }

    public int getNotificationQuietHoursSpanTime() {
        return this.spanTime;
    }

    public String getNotificationQuietHoursStartTime() {
        return this.startTime;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isInQuietTime() {
        /*
            r9 = this;
            java.lang.String r0 = r9.startTime
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != 0) goto L3e
            java.lang.String r0 = r9.startTime
            java.lang.String r4 = ":"
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L3e
            java.lang.String r0 = r9.startTime
            java.lang.String[] r0 = r0.split(r4)
            int r4 = r0.length     // Catch: java.lang.NumberFormatException -> L33
            r5 = 3
            if (r4 < r5) goto L3e
            r4 = r0[r2]     // Catch: java.lang.NumberFormatException -> L33
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L33
            r5 = r0[r1]     // Catch: java.lang.NumberFormatException -> L34
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L34
            r6 = 2
            r0 = r0[r6]     // Catch: java.lang.NumberFormatException -> L35
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L35
            goto L41
        L33:
            r4 = -1
        L34:
            r5 = -1
        L35:
            java.lang.String r0 = "MessageNotificationManager"
            java.lang.String r6 = "getConversationNotificationStatus NumberFormatException"
            io.rong.common.RLog.e(r0, r6)
            r0 = -1
            goto L41
        L3e:
            r0 = -1
            r4 = -1
            r5 = -1
        L41:
            if (r4 == r3) goto L9b
            if (r5 == r3) goto L9b
            if (r0 != r3) goto L48
            goto L9b
        L48:
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            r7 = 11
            r6.set(r7, r4)
            r4 = 12
            r6.set(r4, r5)
            r4 = 13
            r6.set(r4, r0)
            long r4 = r6.getTimeInMillis()
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            int r7 = r9.spanTime
            int r7 = r7 * 60
            int r7 = r7 * 1000
            long r7 = (long) r7
            long r4 = r4 + r7
            r0.setTimeInMillis(r4)
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            r5 = 5
            int r7 = r4.get(r5)
            int r8 = r0.get(r5)
            if (r7 != r8) goto L8c
            boolean r3 = r4.after(r6)
            if (r3 == 0) goto L8a
            boolean r0 = r4.before(r0)
            if (r0 == 0) goto L8a
            goto L8b
        L8a:
            r1 = 0
        L8b:
            return r1
        L8c:
            boolean r2 = r4.before(r6)
            if (r2 == 0) goto L9a
            r0.add(r5, r3)
            boolean r0 = r4.before(r0)
            return r0
        L9a:
            return r1
        L9b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.notification.MessageNotificationManager.isInQuietTime():boolean");
    }

    public void notifyIfNeed(final Context context, final Message message, final int i) {
        if (message.getContent().getMentionedInfo() != null) {
            MentionedInfo mentionedInfo = message.getContent().getMentionedInfo();
            if (mentionedInfo.getType().equals(MentionedInfo.MentionedType.ALL) || (mentionedInfo.getType().equals(MentionedInfo.MentionedType.PART) && mentionedInfo.getMentionedUserIdList() != null && mentionedInfo.getMentionedUserIdList().contains(RongIMClient.getInstance().getCurrentUserId()))) {
                notify(context, message, i);
                return;
            }
        }
        if (isInQuietTime()) {
            RLog.d(TAG, "in quiet time, don't notify.");
        } else if (message.getConversationType().equals(Conversation.ConversationType.ENCRYPTED)) {
            getInstance().notify(context, message, i);
        } else {
            RongIM.getInstance().getConversationNotificationStatus(message.getConversationType(), message.getTargetId(), new RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus>() { // from class: io.rong.imkit.notification.MessageNotificationManager.1
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Conversation.ConversationNotificationStatus conversationNotificationStatus) {
                    if (conversationNotificationStatus.equals(Conversation.ConversationNotificationStatus.NOTIFY)) {
                        MessageNotificationManager.getInstance().notify(context, message, i);
                    }
                }
            });
        }
    }

    public void setNotificationQuietHours(String str, int i) {
        this.spanTime = i;
        this.startTime = str;
    }
}

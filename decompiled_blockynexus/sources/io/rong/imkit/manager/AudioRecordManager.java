package io.rong.imkit.manager;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.just.agentweb.WebIndicator;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.SavePathUtils;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.typingmessage.TypingMessageManager;
import io.rong.message.HQVoiceMessage;
import io.rong.message.VoiceMessage;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class AudioRecordManager implements Handler.Callback {
    private static final int RC_SAMPLE_RATE_16000 = 16000;
    private static final int RC_SAMPLE_RATE_8000 = 8000;
    private static final String TAG = "AudioRecordManager";
    private static final String VOICE_PATH = "/voice/";
    private int RECORD_INTERVAL;
    IAudioState cancelState;
    private long destructTime;
    IAudioState idleState;
    private boolean isDestruct;
    private AudioManager.OnAudioFocusChangeListener mAfChangeListener;
    private AudioManager mAudioManager;
    private Uri mAudioPath;
    private Context mContext;
    private Conversation.ConversationType mConversationType;
    private IAudioState mCurAudioState;
    private Handler mHandler;
    private MediaRecorder mMediaRecorder;
    private PopupWindow mRecordWindow;
    private View mRootView;
    private ImageView mStateIV;
    private TextView mStateTV;
    private String mTargetId;
    private TextView mTimerTV;
    IAudioState recordState;
    IAudioState sendingState;
    private long smStartRecTime;
    IAudioState timerState;

    class CancelState extends IAudioState {
        CancelState() {
        }

        @Override // io.rong.imkit.manager.IAudioState
        void handleMessage(AudioStateMessage audioStateMessage) {
            RLog.d(AudioRecordManager.TAG, CancelState.class.getSimpleName() + " handleMessage : " + audioStateMessage.what);
            int i = audioStateMessage.what;
            if (i != 1) {
                if (i == 4) {
                    AudioRecordManager.this.setRecordingView();
                    AudioRecordManager audioRecordManager = AudioRecordManager.this;
                    audioRecordManager.mCurAudioState = audioRecordManager.recordState;
                    AudioRecordManager.this.sendEmptyMessage(2);
                    return;
                }
                if (i == 5 || i == 6) {
                    AudioRecordManager.this.stopRec();
                    AudioRecordManager.this.destroyView();
                    AudioRecordManager.this.deleteAudioFile();
                    AudioRecordManager audioRecordManager2 = AudioRecordManager.this;
                    audioRecordManager2.mCurAudioState = audioRecordManager2.idleState;
                    AudioRecordManager.this.idleState.enter();
                    return;
                }
                if (i != 7) {
                    return;
                }
                int iIntValue = ((Integer) audioStateMessage.obj).intValue();
                if (iIntValue > 0) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 8;
                    messageObtain.obj = Integer.valueOf(iIntValue - 1);
                    AudioRecordManager.this.mHandler.sendMessageDelayed(messageObtain, 1000L);
                    return;
                }
                AudioRecordManager.this.mHandler.postDelayed(new Runnable() { // from class: io.rong.imkit.manager.AudioRecordManager.CancelState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioRecordManager.this.stopRec();
                        AudioRecordManager.this.sendAudioFile();
                        AudioRecordManager.this.destroyView();
                    }
                }, 500L);
                AudioRecordManager audioRecordManager3 = AudioRecordManager.this;
                audioRecordManager3.mCurAudioState = audioRecordManager3.idleState;
                AudioRecordManager.this.idleState.enter();
            }
        }
    }

    class IdleState extends IAudioState {
        public IdleState() {
            RLog.d(AudioRecordManager.TAG, "IdleState");
        }

        @Override // io.rong.imkit.manager.IAudioState
        void enter() {
            super.enter();
            if (AudioRecordManager.this.mHandler != null) {
                AudioRecordManager.this.mHandler.removeMessages(7);
                AudioRecordManager.this.mHandler.removeMessages(8);
                AudioRecordManager.this.mHandler.removeMessages(2);
            }
        }

        @Override // io.rong.imkit.manager.IAudioState
        void handleMessage(AudioStateMessage audioStateMessage) {
            RLog.d(AudioRecordManager.TAG, "IdleState handleMessage : " + audioStateMessage.what);
            if (audioStateMessage.what != 1) {
                return;
            }
            AudioRecordManager audioRecordManager = AudioRecordManager.this;
            audioRecordManager.initView(audioRecordManager.mRootView);
            AudioRecordManager.this.setRecordingView();
            AudioRecordManager.this.startRec();
            AudioRecordManager.this.smStartRecTime = SystemClock.elapsedRealtime();
            AudioRecordManager audioRecordManager2 = AudioRecordManager.this;
            audioRecordManager2.mCurAudioState = audioRecordManager2.recordState;
            AudioRecordManager.this.sendEmptyMessage(2);
        }
    }

    class RecordState extends IAudioState {
        RecordState() {
        }

        @Override // io.rong.imkit.manager.IAudioState
        void handleMessage(AudioStateMessage audioStateMessage) {
            RLog.d(AudioRecordManager.TAG, RecordState.class.getSimpleName() + " handleMessage : " + audioStateMessage.what);
            int i = audioStateMessage.what;
            if (i == 2) {
                AudioRecordManager.this.audioDBChanged();
                AudioRecordManager.this.mHandler.sendEmptyMessageDelayed(2, 150L);
                return;
            }
            if (i == 3) {
                AudioRecordManager.this.setCancelView();
                AudioRecordManager audioRecordManager = AudioRecordManager.this;
                audioRecordManager.mCurAudioState = audioRecordManager.cancelState;
                return;
            }
            if (i == 5) {
                final boolean zCheckAudioTimeLength = AudioRecordManager.this.checkAudioTimeLength();
                Object obj = audioStateMessage.obj;
                boolean zBooleanValue = obj != null ? ((Boolean) obj).booleanValue() : false;
                if (zCheckAudioTimeLength && !zBooleanValue) {
                    AudioRecordManager.this.mStateIV.setImageResource(R.drawable.rc_ic_volume_wraning);
                    AudioRecordManager.this.mStateTV.setText(R.string.rc_voice_short);
                    AudioRecordManager.this.mHandler.removeMessages(2);
                }
                if (!zBooleanValue && AudioRecordManager.this.mHandler != null) {
                    AudioRecordManager.this.mHandler.postDelayed(new Runnable() { // from class: io.rong.imkit.manager.AudioRecordManager.RecordState.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioStateMessage audioStateMessageObtain = AudioStateMessage.obtain();
                            audioStateMessageObtain.what = 9;
                            audioStateMessageObtain.obj = Boolean.valueOf(!zCheckAudioTimeLength);
                            AudioRecordManager.this.sendMessage(audioStateMessageObtain);
                        }
                    }, 500L);
                    AudioRecordManager audioRecordManager2 = AudioRecordManager.this;
                    audioRecordManager2.mCurAudioState = audioRecordManager2.sendingState;
                    return;
                }
                AudioRecordManager.this.stopRec();
                if (!zCheckAudioTimeLength && zBooleanValue) {
                    AudioRecordManager.this.sendAudioFile();
                }
                AudioRecordManager.this.destroyView();
                AudioRecordManager audioRecordManager3 = AudioRecordManager.this;
                audioRecordManager3.mCurAudioState = audioRecordManager3.idleState;
                return;
            }
            if (i == 6) {
                AudioRecordManager.this.stopRec();
                AudioRecordManager.this.destroyView();
                AudioRecordManager.this.deleteAudioFile();
                AudioRecordManager audioRecordManager4 = AudioRecordManager.this;
                audioRecordManager4.mCurAudioState = audioRecordManager4.idleState;
                AudioRecordManager.this.idleState.enter();
                return;
            }
            if (i != 7) {
                return;
            }
            int iIntValue = ((Integer) audioStateMessage.obj).intValue();
            AudioRecordManager.this.setTimeoutView(iIntValue);
            AudioRecordManager audioRecordManager5 = AudioRecordManager.this;
            audioRecordManager5.mCurAudioState = audioRecordManager5.timerState;
            if (iIntValue < 0) {
                AudioRecordManager.this.mHandler.postDelayed(new Runnable() { // from class: io.rong.imkit.manager.AudioRecordManager.RecordState.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioRecordManager.this.stopRec();
                        AudioRecordManager.this.sendAudioFile();
                        AudioRecordManager.this.destroyView();
                    }
                }, 500L);
                AudioRecordManager audioRecordManager6 = AudioRecordManager.this;
                audioRecordManager6.mCurAudioState = audioRecordManager6.idleState;
            } else {
                Message messageObtain = Message.obtain();
                messageObtain.what = 8;
                messageObtain.obj = Integer.valueOf(iIntValue - 1);
                AudioRecordManager.this.mHandler.sendMessageDelayed(messageObtain, 1000L);
            }
        }
    }

    class SendingState extends IAudioState {
        SendingState() {
        }

        @Override // io.rong.imkit.manager.IAudioState
        void handleMessage(AudioStateMessage audioStateMessage) {
            RLog.d(AudioRecordManager.TAG, "SendingState handleMessage " + audioStateMessage.what);
            if (audioStateMessage.what != 9) {
                return;
            }
            AudioRecordManager.this.stopRec();
            if (((Boolean) audioStateMessage.obj).booleanValue()) {
                AudioRecordManager.this.sendAudioFile();
            }
            AudioRecordManager.this.destroyView();
            AudioRecordManager audioRecordManager = AudioRecordManager.this;
            audioRecordManager.mCurAudioState = audioRecordManager.idleState;
        }
    }

    static class SingletonHolder {
        static AudioRecordManager sInstance = new AudioRecordManager();

        SingletonHolder() {
        }
    }

    class TimerState extends IAudioState {
        TimerState() {
        }

        @Override // io.rong.imkit.manager.IAudioState
        void handleMessage(AudioStateMessage audioStateMessage) {
            RLog.d(AudioRecordManager.TAG, TimerState.class.getSimpleName() + " handleMessage : " + audioStateMessage.what);
            int i = audioStateMessage.what;
            if (i == 3) {
                AudioRecordManager.this.setCancelView();
                AudioRecordManager audioRecordManager = AudioRecordManager.this;
                audioRecordManager.mCurAudioState = audioRecordManager.cancelState;
                return;
            }
            if (i == 5) {
                AudioRecordManager.this.mHandler.postDelayed(new Runnable() { // from class: io.rong.imkit.manager.AudioRecordManager.TimerState.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioRecordManager.this.stopRec();
                        AudioRecordManager.this.sendAudioFile();
                        AudioRecordManager.this.destroyView();
                    }
                }, 500L);
                AudioRecordManager audioRecordManager2 = AudioRecordManager.this;
                audioRecordManager2.mCurAudioState = audioRecordManager2.idleState;
                AudioRecordManager.this.idleState.enter();
                return;
            }
            if (i == 6) {
                AudioRecordManager.this.stopRec();
                AudioRecordManager.this.destroyView();
                AudioRecordManager.this.deleteAudioFile();
                AudioRecordManager audioRecordManager3 = AudioRecordManager.this;
                audioRecordManager3.mCurAudioState = audioRecordManager3.idleState;
                AudioRecordManager.this.idleState.enter();
                return;
            }
            if (i != 7) {
                return;
            }
            int iIntValue = ((Integer) audioStateMessage.obj).intValue();
            if (iIntValue < 0) {
                AudioRecordManager.this.mHandler.postDelayed(new Runnable() { // from class: io.rong.imkit.manager.AudioRecordManager.TimerState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioRecordManager.this.stopRec();
                        AudioRecordManager.this.sendAudioFile();
                        AudioRecordManager.this.destroyView();
                    }
                }, 500L);
                AudioRecordManager audioRecordManager4 = AudioRecordManager.this;
                audioRecordManager4.mCurAudioState = audioRecordManager4.idleState;
            } else {
                Message messageObtain = Message.obtain();
                messageObtain.what = 8;
                messageObtain.obj = Integer.valueOf(iIntValue - 1);
                AudioRecordManager.this.mHandler.sendMessageDelayed(messageObtain, 1000L);
                AudioRecordManager.this.setTimeoutView(iIntValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void audioDBChanged() {
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        if (mediaRecorder != null) {
            int maxAmplitude = 0;
            try {
                maxAmplitude = mediaRecorder.getMaxAmplitude() / WebIndicator.DO_END_ANIMATION_DURATION;
            } catch (IllegalStateException unused) {
                RLog.e(TAG, "audioDBChanged IllegalStateException");
            }
            switch (maxAmplitude / 5) {
                case 0:
                    this.mStateIV.setImageResource(R.drawable.rc_ic_volume_1);
                    break;
                case 1:
                    this.mStateIV.setImageResource(R.drawable.rc_ic_volume_2);
                    break;
                case 2:
                    this.mStateIV.setImageResource(R.drawable.rc_ic_volume_3);
                    break;
                case 3:
                    this.mStateIV.setImageResource(R.drawable.rc_ic_volume_4);
                    break;
                case 4:
                    this.mStateIV.setImageResource(R.drawable.rc_ic_volume_5);
                    break;
                case 5:
                    this.mStateIV.setImageResource(R.drawable.rc_ic_volume_6);
                    break;
                case 6:
                    this.mStateIV.setImageResource(R.drawable.rc_ic_volume_7);
                    break;
                default:
                    this.mStateIV.setImageResource(R.drawable.rc_ic_volume_8);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkAudioTimeLength() {
        return SystemClock.elapsedRealtime() - this.smStartRecTime < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteAudioFile() {
        RLog.d(TAG, "deleteAudioFile");
        Uri uri = this.mAudioPath;
        if (uri != null) {
            File file = new File(uri.getPath());
            if (!file.exists() || file.delete()) {
                return;
            }
            RLog.e(TAG, "deleteAudioFile delete file failed. path :" + this.mAudioPath.getPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyView() {
        RLog.d(TAG, "destroyView");
        if (this.mRecordWindow != null) {
            this.mHandler.removeMessages(7);
            this.mHandler.removeMessages(8);
            this.mHandler.removeMessages(2);
            this.mRecordWindow.dismiss();
            this.mRecordWindow = null;
            this.mStateIV = null;
            this.mStateTV = null;
            this.mTimerTV = null;
            this.mContext = null;
            this.mRootView = null;
        }
    }

    public static AudioRecordManager getInstance() {
        return SingletonHolder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(View view) {
        View viewInflate = LayoutInflater.from(view.getContext()).inflate(R.layout.rc_wi_vo_popup, (ViewGroup) null);
        this.mStateIV = (ImageView) viewInflate.findViewById(R.id.rc_audio_state_image);
        this.mStateTV = (TextView) viewInflate.findViewById(R.id.rc_audio_state_text);
        this.mTimerTV = (TextView) viewInflate.findViewById(R.id.rc_audio_timer);
        this.mRecordWindow = new PopupWindow(viewInflate, -1, -1);
        this.mRecordWindow.showAtLocation(view, 17, 0, 0);
        this.mRecordWindow.setFocusable(true);
        this.mRecordWindow.setOutsideTouchable(false);
        this.mRecordWindow.setTouchable(false);
    }

    private void muteAudioFocus(AudioManager audioManager, boolean z) {
        if (Build.VERSION.SDK_INT < 8) {
            RLog.d(TAG, "muteAudioFocus Android 2.1 and below can not stop music");
            return;
        }
        if (audioManager == null) {
            RLog.e(TAG, "audioManager is null");
        } else if (z) {
            audioManager.requestAudioFocus(this.mAfChangeListener, 3, 2);
        } else {
            audioManager.abandonAudioFocus(this.mAfChangeListener);
            this.mAfChangeListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAudioFile() {
        RLog.d(TAG, "sendAudioFile path = " + this.mAudioPath);
        Uri uri = this.mAudioPath;
        if (uri != null) {
            File file = new File(uri.getPath());
            if (!file.exists() || file.length() == 0) {
                RLog.e(TAG, "sendAudioFile fail cause of file length 0 or audio permission denied");
                return;
            }
            int iElapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.smStartRecTime)) / 1000;
            if (RongIM.getInstance().getVoiceMessageType() != RongIM.VoiceMessageType.HighQuality) {
                Uri uri2 = this.mAudioPath;
                int i = this.RECORD_INTERVAL;
                if (iElapsedRealtime > i) {
                    iElapsedRealtime = i;
                }
                VoiceMessage voiceMessageObtain = VoiceMessage.obtain(uri2, iElapsedRealtime);
                if (this.isDestruct) {
                    voiceMessageObtain.setDestructTime(this.destructTime);
                }
                RongIM.getInstance().sendMessage(io.rong.imlib.model.Message.obtain(this.mTargetId, this.mConversationType, voiceMessageObtain), this.isDestruct ? this.mContext.getString(R.string.rc_message_content_burn) : null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.manager.AudioRecordManager.4
                    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                    public void onAttached(io.rong.imlib.model.Message message) {
                    }

                    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                    public void onError(io.rong.imlib.model.Message message, RongIMClient.ErrorCode errorCode) {
                    }

                    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                    public void onSuccess(io.rong.imlib.model.Message message) {
                    }
                });
                return;
            }
            Uri uri3 = this.mAudioPath;
            int i2 = this.RECORD_INTERVAL;
            if (iElapsedRealtime > i2) {
                iElapsedRealtime = i2;
            }
            HQVoiceMessage hQVoiceMessageObtain = HQVoiceMessage.obtain(uri3, iElapsedRealtime);
            if (this.isDestruct) {
                hQVoiceMessageObtain.setDestructTime(this.destructTime);
            }
            RongIM.getInstance().sendMediaMessage(io.rong.imlib.model.Message.obtain(this.mTargetId, this.mConversationType, hQVoiceMessageObtain), this.isDestruct ? this.mContext.getString(R.string.rc_message_content_burn) : null, (String) null, new IRongCallback.ISendMediaMessageCallback() { // from class: io.rong.imkit.manager.AudioRecordManager.3
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(io.rong.imlib.model.Message message) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
                public void onCanceled(io.rong.imlib.model.Message message) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(io.rong.imlib.model.Message message, RongIMClient.ErrorCode errorCode) {
                    RLog.d(AudioRecordManager.TAG, "onError = " + errorCode.toString());
                }

                @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
                public void onProgress(io.rong.imlib.model.Message message, int i3) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(io.rong.imlib.model.Message message) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCancelView() {
        RLog.d(TAG, "setCancelView");
        if (this.mRecordWindow != null) {
            this.mTimerTV.setVisibility(8);
            this.mStateIV.setVisibility(0);
            this.mStateIV.setImageResource(R.drawable.rc_ic_volume_cancel);
            this.mStateTV.setVisibility(0);
            this.mStateTV.setText(R.string.rc_voice_cancel);
            this.mStateTV.setBackgroundResource(R.drawable.rc_corner_voice_style);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecordingView() {
        RLog.d(TAG, "setRecordingView");
        if (this.mRecordWindow != null) {
            this.mStateIV.setVisibility(0);
            this.mStateIV.setImageResource(R.drawable.rc_ic_volume_1);
            this.mStateTV.setVisibility(0);
            this.mStateTV.setText(R.string.rc_voice_rec);
            this.mStateTV.setBackgroundResource(android.R.color.transparent);
            this.mTimerTV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeoutView(int i) {
        if (i <= 0) {
            if (this.mRecordWindow != null) {
                this.mStateIV.setVisibility(0);
                this.mStateIV.setImageResource(R.drawable.rc_ic_volume_wraning);
                this.mStateTV.setText(R.string.rc_voice_too_long);
                this.mStateTV.setBackgroundResource(android.R.color.transparent);
                this.mTimerTV.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mRecordWindow != null) {
            this.mStateIV.setVisibility(8);
            this.mStateTV.setVisibility(0);
            this.mStateTV.setText(R.string.rc_voice_rec);
            this.mStateTV.setBackgroundResource(android.R.color.transparent);
            this.mTimerTV.setText(String.format("%s", Integer.valueOf(i)));
            this.mTimerTV.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRec() {
        RLog.d(TAG, "startRec");
        try {
            muteAudioFocus(this.mAudioManager, true);
            this.mAudioManager.setMode(0);
            this.mMediaRecorder = new MediaRecorder();
            try {
                Resources resources = this.mContext.getResources();
                int integer = resources.getInteger(resources.getIdentifier("rc_audio_encoding_bit_rate", "integer", this.mContext.getPackageName()));
                int integer2 = resources.getInteger(resources.getIdentifier("rc_audio_wb_encoding_bit_rate", "integer", this.mContext.getPackageName()));
                int integer3 = resources.getInteger(resources.getIdentifier("rc_audio_aac_encoding_bit_rate", "integer", this.mContext.getPackageName()));
                if (RongIM.getInstance().getVoiceMessageType() == RongIM.VoiceMessageType.HighQuality) {
                    this.mMediaRecorder.setAudioSamplingRate(44100);
                    this.mMediaRecorder.setAudioEncodingBitRate(integer3);
                } else {
                    this.mMediaRecorder.setAudioSamplingRate(RongIM.getInstance().getSamplingRate());
                    if (RongIM.getInstance().getSamplingRate() == 8000) {
                        this.mMediaRecorder.setAudioEncodingBitRate(integer);
                    } else {
                        this.mMediaRecorder.setAudioEncodingBitRate(integer2);
                    }
                }
            } catch (Resources.NotFoundException e2) {
                RLog.e(TAG, "startRec", e2);
            }
            this.mMediaRecorder.setAudioChannels(1);
            this.mMediaRecorder.setAudioSource(1);
            if (RongIM.getInstance().getVoiceMessageType() == RongIM.VoiceMessageType.HighQuality) {
                this.mMediaRecorder.setOutputFormat(2);
                if (Build.VERSION.SDK_INT >= 28) {
                    this.mMediaRecorder.setAudioEncoder(4);
                } else {
                    this.mMediaRecorder.setAudioEncoder(3);
                }
            } else if (RongIM.getInstance().getSamplingRate() == 8000) {
                this.mMediaRecorder.setOutputFormat(3);
                this.mMediaRecorder.setAudioEncoder(1);
            } else {
                this.mMediaRecorder.setOutputFormat(4);
                this.mMediaRecorder.setAudioEncoder(2);
            }
            this.mAudioPath = Uri.fromFile(new File(SavePathUtils.getSavePath(this.mContext.getCacheDir()), System.currentTimeMillis() + "temp.voice"));
            this.mMediaRecorder.setOutputFile(this.mAudioPath.getPath());
            this.mMediaRecorder.prepare();
            this.mMediaRecorder.start();
            Message messageObtain = Message.obtain();
            messageObtain.what = 7;
            messageObtain.obj = 10;
            this.mHandler.sendMessageDelayed(messageObtain, (this.RECORD_INTERVAL * 1000) - 10000);
        } catch (Exception e3) {
            RLog.e(TAG, "startRec", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRec() {
        RLog.d(TAG, "stopRec");
        try {
            muteAudioFocus(this.mAudioManager, false);
            if (this.mMediaRecorder != null) {
                this.mMediaRecorder.stop();
                this.mMediaRecorder.release();
                this.mMediaRecorder = null;
            }
        } catch (Exception e2) {
            RLog.e(TAG, "stopRec", e2);
        }
    }

    public void continueRecord() {
        sendEmptyMessage(4);
    }

    public void destroyRecord() {
        AudioStateMessage audioStateMessage = new AudioStateMessage();
        audioStateMessage.obj = true;
        audioStateMessage.what = 5;
        sendMessage(audioStateMessage);
    }

    public int getMaxVoiceDuration() {
        return this.RECORD_INTERVAL;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        RLog.i(TAG, "handleMessage " + message.what);
        int i = message.what;
        if (i == 2) {
            sendEmptyMessage(2);
            return false;
        }
        if (i == 7) {
            AudioStateMessage audioStateMessageObtain = AudioStateMessage.obtain();
            audioStateMessageObtain.what = message.what;
            audioStateMessageObtain.obj = message.obj;
            sendMessage(audioStateMessageObtain);
            return false;
        }
        if (i != 8) {
            return false;
        }
        AudioStateMessage audioStateMessageObtain2 = AudioStateMessage.obtain();
        audioStateMessageObtain2.what = 7;
        audioStateMessageObtain2.obj = message.obj;
        sendMessage(audioStateMessageObtain2);
        return false;
    }

    void sendEmptyMessage(int i) {
        AudioStateMessage audioStateMessageObtain = AudioStateMessage.obtain();
        audioStateMessageObtain.what = i;
        this.mCurAudioState.handleMessage(audioStateMessageObtain);
    }

    void sendMessage(AudioStateMessage audioStateMessage) {
        this.mCurAudioState.handleMessage(audioStateMessage);
    }

    public void setMaxVoiceDuration(int i) {
        this.RECORD_INTERVAL = i;
    }

    public void startRecord(View view, Conversation.ConversationType conversationType, String str, boolean z, long j) {
        if (view == null) {
            return;
        }
        this.mRootView = view;
        this.mContext = view.getContext().getApplicationContext();
        this.mConversationType = conversationType;
        this.mTargetId = str;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService(LibStorageUtils.AUDIO);
        this.isDestruct = z;
        this.destructTime = j;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.mAfChangeListener;
        if (onAudioFocusChangeListener != null) {
            this.mAudioManager.abandonAudioFocus(onAudioFocusChangeListener);
            this.mAfChangeListener = null;
        }
        this.mAfChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: io.rong.imkit.manager.AudioRecordManager.2
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i) {
                RLog.d(AudioRecordManager.TAG, "OnAudioFocusChangeListener " + i);
                if (i == -1) {
                    AudioRecordManager.this.mAudioManager.abandonAudioFocus(AudioRecordManager.this.mAfChangeListener);
                    AudioRecordManager.this.mAfChangeListener = null;
                    AudioRecordManager.this.mHandler.post(new Runnable() { // from class: io.rong.imkit.manager.AudioRecordManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AudioRecordManager.this.sendEmptyMessage(6);
                        }
                    });
                }
            }
        };
        sendEmptyMessage(1);
        if (TypingMessageManager.getInstance().isShowMessageTyping()) {
            RongIMClient.getInstance().sendTypingStatus(conversationType, str, "RC:VcMsg");
        }
    }

    public void stopRecord() {
        sendEmptyMessage(5);
    }

    public void willCancelRecord() {
        sendEmptyMessage(3);
    }

    @TargetApi(21)
    private AudioRecordManager() {
        this.RECORD_INTERVAL = 60;
        this.idleState = new IdleState();
        this.recordState = new RecordState();
        this.sendingState = new SendingState();
        this.cancelState = new CancelState();
        this.timerState = new TimerState();
        RLog.d(TAG, TAG);
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        if (Build.VERSION.SDK_INT < 21) {
            try {
                ((TelephonyManager) RongIM.getInstance().getApplicationContext().getSystemService("phone")).listen(new PhoneStateListener() { // from class: io.rong.imkit.manager.AudioRecordManager.1
                    @Override // android.telephony.PhoneStateListener
                    public void onCallStateChanged(int i, String str) {
                        if (i != 0 && i == 1) {
                            AudioRecordManager.this.sendEmptyMessage(6);
                        }
                        super.onCallStateChanged(i, str);
                    }
                }, 32);
            } catch (Exception e2) {
                RLog.e(TAG, TAG, e2);
            }
        }
        IAudioState iAudioState = this.idleState;
        this.mCurAudioState = iAudioState;
        iAudioState.enter();
    }
}

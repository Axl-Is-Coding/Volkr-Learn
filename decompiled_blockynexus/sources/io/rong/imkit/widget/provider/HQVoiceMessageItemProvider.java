package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.manager.AudioPlayManager;
import io.rong.imkit.manager.AudioRecordManager;
import io.rong.imkit.manager.IAudioPlayListener;
import io.rong.imkit.model.Event;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.NetUtils;
import io.rong.imlib.model.Message;
import io.rong.message.HQVoiceMessage;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = HQVoiceMessage.class, showReadState = true)
public class HQVoiceMessageItemProvider extends IContainerItemProvider.MessageProvider<HQVoiceMessage> {
    private static final String TAG = "HQVoiceMessageItemProvider";

    private static class DestructListener implements RongIMClient.DestructCountDownTimerListener {
        private WeakReference<ViewHolder> mHolder;
        private UIMessage mUIMessage;

        DestructListener(ViewHolder viewHolder, UIMessage uIMessage) {
            this.mHolder = new WeakReference<>(viewHolder);
            this.mUIMessage = uIMessage;
        }

        @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
        public void onStop(String str) {
            ViewHolder viewHolder;
            if (this.mUIMessage.getUId().equals(str) && (viewHolder = this.mHolder.get()) != null && str.equals(viewHolder.receiverFire.getTag())) {
                viewHolder.receiverFireText.setVisibility(8);
                viewHolder.receiverFireImg.setVisibility(0);
                this.mUIMessage.setUnDestructTime(null);
            }
        }

        @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
        public void onTick(long j, String str) {
            ViewHolder viewHolder;
            if (this.mUIMessage.getUId().equals(str) && (viewHolder = this.mHolder.get()) != null && str.equals(viewHolder.receiverFire.getTag())) {
                viewHolder.receiverFireText.setVisibility(0);
                viewHolder.receiverFireImg.setVisibility(8);
                String strValueOf = String.valueOf(Math.max(j, 1L));
                viewHolder.receiverFireText.setText(strValueOf);
                this.mUIMessage.setUnDestructTime(strValueOf);
            }
        }
    }

    private static class ViewHolder {
        ImageView downloadError;
        ProgressBar downloadProcessing;
        ImageView img;
        TextView left;
        FrameLayout receiverFire;
        ImageView receiverFireImg;
        TextView receiverFireText;
        TextView right;
        FrameLayout sendFire;
        ImageView unread;

        private ViewHolder() {
        }
    }

    private class VoiceMessagePlayListener implements IAudioPlayListener {
        private Context context;
        private ViewHolder holder;
        private boolean listened;
        private UIMessage message;

        VoiceMessagePlayListener(Context context, UIMessage uIMessage, ViewHolder viewHolder, boolean z) {
            this.context = context;
            this.message = uIMessage;
            this.holder = viewHolder;
            this.listened = z;
        }

        @Override // io.rong.imkit.manager.IAudioPlayListener
        public void onComplete(Uri uri) {
            Event.PlayAudioEvent playAudioEventObtain = Event.PlayAudioEvent.obtain();
            playAudioEventObtain.messageId = this.message.getMessageId();
            if (this.message.isListening() && this.message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                try {
                    playAudioEventObtain.continuously = this.context.getResources().getBoolean(R.bool.rc_play_audio_continuous);
                } catch (Resources.NotFoundException e2) {
                    RLog.e(HQVoiceMessageItemProvider.TAG, "VoiceMessagePlayListener.onComplete", e2);
                }
            }
            if (playAudioEventObtain.continuously && !this.message.getContent().isDestruct()) {
                EventBus.getDefault().post(playAudioEventObtain);
            }
            this.message.setListening(false);
            HQVoiceMessageItemProvider.this.setLayout(this.context, this.holder, this.message, false);
            if (this.message.getContent().isDestruct() && this.message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                DestructManager.getInstance().startDestruct(this.message.getMessage());
            }
        }

        @Override // io.rong.imkit.manager.IAudioPlayListener
        public void onStart(Uri uri) {
            UIMessage uIMessage = this.message;
            uIMessage.continuePlayAudio = false;
            uIMessage.setListening(true);
            this.message.getReceivedStatus().setListened();
            RongIMClient.getInstance().setMessageReceivedStatus(this.message.getMessageId(), this.message.getReceivedStatus(), null);
            HQVoiceMessageItemProvider.this.setLayout(this.context, this.holder, this.message, true);
            EventBus.getDefault().post(new Event.AudioListenedEvent(this.message.getMessage()));
            if (this.message.getContent().isDestruct() && this.message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                DestructManager.getInstance().stopDestruct(this.message.getMessage());
                EventBus.getDefault().post(new Event.changeDestructionReadTimeEvent(this.message.getMessage()));
            }
        }

        @Override // io.rong.imkit.manager.IAudioPlayListener
        public void onStop(Uri uri) {
            if (this.message.getContent() instanceof HQVoiceMessage) {
                this.message.setListening(false);
                HQVoiceMessageItemProvider.this.setLayout(this.context, this.holder, this.message, false);
                if (this.message.getContent().isDestruct() && this.message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                    DestructManager.getInstance().startDestruct(this.message.getMessage());
                }
            }
        }
    }

    private void downloadHQVoiceMsg(final View view, final UIMessage uIMessage, final ViewHolder viewHolder, final boolean z) {
        RongIM.getInstance().downloadMediaMessage(uIMessage.getMessage(), new IRongCallback.IDownloadMediaMessageCallback() { // from class: io.rong.imkit.widget.provider.HQVoiceMessageItemProvider.1
            @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
            public void onCanceled(Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                RLog.d(HQVoiceMessageItemProvider.TAG, "playOrDownloadHQVoiceMsg onError");
                viewHolder.downloadError.setVisibility(0);
                viewHolder.downloadProcessing.setVisibility(8);
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
            public void onProgress(Message message, int i) {
                viewHolder.downloadProcessing.setVisibility(0);
            }

            @Override // io.rong.imlib.IRongCallback.IDownloadMediaMessageCallback
            public void onSuccess(Message message) {
                RLog.d(HQVoiceMessageItemProvider.TAG, "playOrDownloadHQVoiceMsg onSuccess");
                viewHolder.downloadError.setVisibility(8);
                viewHolder.downloadProcessing.setVisibility(8);
                HQVoiceMessageItemProvider.this.playHQVoiceMessage(view, (HQVoiceMessage) message.getContent(), uIMessage, viewHolder, z);
            }
        });
    }

    private boolean isFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playHQVoiceMessage(View view, HQVoiceMessage hQVoiceMessage, UIMessage uIMessage, ViewHolder viewHolder, boolean z) {
        viewHolder.unread.setVisibility(8);
        AudioPlayManager.getInstance().startPlay(view.getContext(), hQVoiceMessage.getLocalPath(), new VoiceMessagePlayListener(view.getContext(), uIMessage, viewHolder, z));
    }

    private void playOrDownloadHQVoiceMsg(View view, HQVoiceMessage hQVoiceMessage, UIMessage uIMessage, ViewHolder viewHolder, boolean z) {
        boolean z2 = hQVoiceMessage.getLocalPath() == null || TextUtils.isEmpty(hQVoiceMessage.getLocalPath().toString());
        if (uIMessage.getMessageDirection() == Message.MessageDirection.RECEIVE) {
            z2 = hQVoiceMessage.getLocalPath() == null || TextUtils.isEmpty(hQVoiceMessage.getLocalPath().toString()) || !isFileExists(hQVoiceMessage.getLocalPath().toString());
        }
        if (z2) {
            downloadHQVoiceMsg(view, uIMessage, viewHolder, z);
        } else {
            playHQVoiceMessage(view, hQVoiceMessage, uIMessage, viewHolder, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayout(Context context, ViewHolder viewHolder, UIMessage uIMessage, boolean z) {
        HQVoiceMessage hQVoiceMessage = (HQVoiceMessage) uIMessage.getContent();
        float f2 = context.getResources().getDisplayMetrics().density;
        int i = (int) ((70 * f2) + 0.5f);
        viewHolder.img.getLayoutParams().width = i + (((((int) ((204 * f2) + 0.5f)) - i) / AudioRecordManager.getInstance().getMaxVoiceDuration()) * hQVoiceMessage.getDuration());
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.left.setText(String.format("%s\"", Integer.valueOf(hQVoiceMessage.getDuration())));
            viewHolder.left.setVisibility(0);
            viewHolder.right.setVisibility(8);
            viewHolder.unread.setVisibility(8);
            viewHolder.downloadError.setVisibility(8);
            viewHolder.downloadProcessing.setVisibility(8);
            viewHolder.img.setScaleType(ImageView.ScaleType.FIT_END);
            viewHolder.img.setBackgroundResource(R.drawable.rc_ic_bubble_right);
            AnimationDrawable animationDrawable = (AnimationDrawable) context.getResources().getDrawable(R.drawable.rc_an_voice_sent);
            if (z) {
                viewHolder.img.setImageDrawable(animationDrawable);
                if (animationDrawable != null) {
                    animationDrawable.start();
                    return;
                }
                return;
            }
            ImageView imageView = viewHolder.img;
            imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.rc_ic_voice_sent));
            if (animationDrawable != null) {
                animationDrawable.stop();
                return;
            }
            return;
        }
        viewHolder.right.setText(String.format("%s\"", Integer.valueOf(hQVoiceMessage.getDuration())));
        viewHolder.right.setVisibility(0);
        viewHolder.left.setVisibility(8);
        RLog.d(TAG, "message.getExtra() = " + uIMessage.getExtra());
        viewHolder.downloadProcessing.setVisibility(0);
        viewHolder.downloadError.setVisibility(8);
        if (((HQVoiceMessage) uIMessage.getContent()).getLocalPath() != null) {
            viewHolder.downloadProcessing.setVisibility(8);
            viewHolder.downloadError.setVisibility(8);
        } else if (!NetUtils.isNetWorkAvailable(context)) {
            viewHolder.downloadError.setVisibility(0);
            viewHolder.downloadProcessing.setVisibility(8);
        }
        if (uIMessage.getReceivedStatus().isListened() || ((HQVoiceMessage) uIMessage.getContent()).getLocalPath() == null) {
            viewHolder.unread.setVisibility(8);
        } else {
            viewHolder.unread.setVisibility(0);
        }
        viewHolder.img.setBackgroundResource(R.drawable.rc_ic_bubble_left);
        AnimationDrawable animationDrawable2 = (AnimationDrawable) context.getResources().getDrawable(R.drawable.rc_an_voice_receive);
        if (z) {
            viewHolder.img.setImageDrawable(animationDrawable2);
            if (animationDrawable2 != null) {
                animationDrawable2.start();
            }
        } else {
            ImageView imageView2 = viewHolder.img;
            imageView2.setImageDrawable(imageView2.getResources().getDrawable(R.drawable.rc_ic_voice_receive));
            if (animationDrawable2 != null) {
                animationDrawable2.stop();
            }
        }
        viewHolder.img.setScaleType(ImageView.ScaleType.FIT_START);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(HQVoiceMessage hQVoiceMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_hq_voice_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.left = (TextView) viewInflate.findViewById(R.id.rc_left);
        viewHolder.right = (TextView) viewInflate.findViewById(R.id.rc_right);
        viewHolder.img = (ImageView) viewInflate.findViewById(R.id.rc_img);
        viewHolder.unread = (ImageView) viewInflate.findViewById(R.id.rc_voice_unread);
        viewHolder.downloadError = (ImageView) viewInflate.findViewById(R.id.rc_voice_download_error);
        viewHolder.downloadProcessing = (ProgressBar) viewInflate.findViewById(R.id.rc_download_progress);
        viewHolder.sendFire = (FrameLayout) viewInflate.findViewById(R.id.fl_send_fire);
        viewHolder.receiverFire = (FrameLayout) viewInflate.findViewById(R.id.fl_receiver_fire);
        viewHolder.receiverFireImg = (ImageView) viewInflate.findViewById(R.id.iv_receiver_fire);
        viewHolder.receiverFireText = (TextView) viewInflate.findViewById(R.id.tv_receiver_fire);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, HQVoiceMessage hQVoiceMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.receiverFire.setTag(uIMessage.getUId());
        if (!hQVoiceMessage.isDestruct()) {
            viewHolder.sendFire.setVisibility(8);
            viewHolder.receiverFire.setVisibility(8);
        } else if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.sendFire.setVisibility(0);
            viewHolder.receiverFire.setVisibility(8);
        } else {
            viewHolder.sendFire.setVisibility(8);
            viewHolder.receiverFire.setVisibility(0);
            DestructManager.getInstance().addListener(uIMessage.getUId(), new DestructListener(viewHolder, uIMessage), TAG);
            if (uIMessage.getMessage().getReadTime() > 0) {
                viewHolder.receiverFireText.setVisibility(0);
                viewHolder.receiverFireImg.setVisibility(8);
                viewHolder.receiverFireText.setText(TextUtils.isEmpty(uIMessage.getUnDestructTime()) ? DestructManager.getInstance().getUnFinishTime(uIMessage.getUId()) : uIMessage.getUnDestructTime());
                DestructManager.getInstance().startDestruct(uIMessage.getMessage());
            } else {
                viewHolder.receiverFireText.setVisibility(8);
                viewHolder.receiverFireImg.setVisibility(0);
            }
        }
        if (uIMessage.continuePlayAudio) {
            Uri playingUri = AudioPlayManager.getInstance().getPlayingUri();
            if (playingUri == null || !playingUri.equals(hQVoiceMessage.getLocalPath())) {
                AudioPlayManager.getInstance().startPlay(view.getContext(), hQVoiceMessage.getLocalPath(), new VoiceMessagePlayListener(view.getContext(), uIMessage, viewHolder, uIMessage.getMessage().getReceivedStatus().isListened()));
                return;
            }
            return;
        }
        Uri playingUri2 = AudioPlayManager.getInstance().getPlayingUri();
        if (playingUri2 == null || !playingUri2.equals(hQVoiceMessage.getLocalPath())) {
            setLayout(view.getContext(), viewHolder, uIMessage, false);
        } else {
            setLayout(view.getContext(), viewHolder, uIMessage, true);
            AudioPlayManager.getInstance().setPlayListener(new VoiceMessagePlayListener(view.getContext(), uIMessage, viewHolder, uIMessage.getMessage().getReceivedStatus().isListened()));
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, HQVoiceMessage hQVoiceMessage, UIMessage uIMessage) {
        if (hQVoiceMessage == null) {
            return;
        }
        RLog.d(TAG, "Item index:" + i + " content.getLocalPath():" + hQVoiceMessage.getLocalPath());
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (AudioPlayManager.getInstance().isPlaying()) {
            if (AudioPlayManager.getInstance().getPlayingUri().equals(hQVoiceMessage.getLocalPath())) {
                AudioPlayManager.getInstance().stopPlay();
                return;
            }
            AudioPlayManager.getInstance().stopPlay();
        }
        if (AudioPlayManager.getInstance().isInNormalMode(view.getContext()) || !AudioPlayManager.getInstance().isInVOIPMode(view.getContext())) {
            playOrDownloadHQVoiceMsg(view, hQVoiceMessage, uIMessage, viewHolder, uIMessage.getMessage().getReceivedStatus().isListened());
        } else {
            Toast.makeText(view.getContext(), view.getContext().getString(R.string.rc_voip_occupying), 0).show();
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, HQVoiceMessage hQVoiceMessage) {
        if (hQVoiceMessage.isDestruct()) {
            return new SpannableString(context.getString(R.string.rc_message_content_burn));
        }
        return new SpannableString(context.getString(R.string.rc_message_content_voice));
    }
}

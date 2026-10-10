package io.rong.imkit.widget.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.manager.AudioPlayManager;
import io.rong.imkit.manager.AudioRecordManager;
import io.rong.imkit.manager.IAudioPlayListener;
import io.rong.imkit.model.Event;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.VoiceMessage;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = VoiceMessage.class, showReadState = true)
public class VoiceMessageItemProvider extends IContainerItemProvider.MessageProvider<VoiceMessage> {
    private static final String TAG = "VoiceMessageItemProvider";

    private static class DestructListener implements RongIMClient.DestructCountDownTimerListener {
        private WeakReference<ViewHolder> mHolder;
        private UIMessage mUIMessage;

        public DestructListener(ViewHolder viewHolder, UIMessage uIMessage) {
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

        public VoiceMessagePlayListener(Context context, UIMessage uIMessage, ViewHolder viewHolder, boolean z) {
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
                    e2.printStackTrace();
                }
            }
            if (playAudioEventObtain.continuously && !this.message.getContent().isDestruct()) {
                EventBus.getDefault().post(playAudioEventObtain);
            }
            this.message.setListening(false);
            VoiceMessageItemProvider.this.setLayout(this.context, this.holder, this.message, false);
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
            VoiceMessageItemProvider.this.setLayout(this.context, this.holder, this.message, true);
            EventBus.getDefault().post(new Event.AudioListenedEvent(this.message.getMessage()));
            if (this.message.getContent().isDestruct() && this.message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                DestructManager.getInstance().stopDestruct(this.message.getMessage());
            }
        }

        @Override // io.rong.imkit.manager.IAudioPlayListener
        public void onStop(Uri uri) {
            if (this.message.getContent() instanceof VoiceMessage) {
                this.message.setListening(false);
                VoiceMessageItemProvider.this.setLayout(this.context, this.holder, this.message, false);
                if (this.message.getContent().isDestruct() && this.message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                    DestructManager.getInstance().startDestruct(this.message.getMessage());
                }
            }
        }
    }

    public VoiceMessageItemProvider(Context context) {
    }

    @TargetApi(8)
    private boolean muteAudioFocus(Context context, boolean z) {
        boolean z2 = false;
        if (context == null) {
            RLog.d(TAG, "muteAudioFocus context is null.");
            return false;
        }
        if (Build.VERSION.SDK_INT < 8) {
            RLog.d(TAG, "muteAudioFocus Android 2.1 and below can not stop music");
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(LibStorageUtils.AUDIO);
        if (!z ? audioManager.abandonAudioFocus(null) == 1 : audioManager.requestAudioFocus(null, 3, 2) == 1) {
            z2 = true;
        }
        RLog.d(TAG, "muteAudioFocus pauseMusic bMute=" + z + " result=" + z2);
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayout(Context context, ViewHolder viewHolder, UIMessage uIMessage, boolean z) {
        VoiceMessage voiceMessage = (VoiceMessage) uIMessage.getContent();
        float f2 = context.getResources().getDisplayMetrics().density;
        int i = (int) ((70 * f2) + 0.5f);
        viewHolder.img.getLayoutParams().width = i + (((((int) ((204 * f2) + 0.5f)) - i) / AudioRecordManager.getInstance().getMaxVoiceDuration()) * voiceMessage.getDuration());
        if (uIMessage.getMessageDirection() != Message.MessageDirection.SEND) {
            viewHolder.right.setText(String.format("%s\"", Integer.valueOf(voiceMessage.getDuration())));
            viewHolder.right.setVisibility(0);
            viewHolder.left.setVisibility(8);
            if (uIMessage.getReceivedStatus().isListened()) {
                viewHolder.unread.setVisibility(8);
            } else {
                viewHolder.unread.setVisibility(0);
            }
            viewHolder.img.setBackgroundResource(R.drawable.rc_ic_bubble_left);
            AnimationDrawable animationDrawable = (AnimationDrawable) context.getResources().getDrawable(R.drawable.rc_an_voice_receive);
            if (z) {
                viewHolder.img.setImageDrawable(animationDrawable);
                if (animationDrawable != null) {
                    animationDrawable.start();
                }
            } else {
                ImageView imageView = viewHolder.img;
                imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.rc_ic_voice_receive));
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
            }
            viewHolder.img.setScaleType(ImageView.ScaleType.FIT_START);
            return;
        }
        viewHolder.left.setText(String.format("%s\"", Integer.valueOf(voiceMessage.getDuration())));
        viewHolder.left.setVisibility(0);
        viewHolder.right.setVisibility(8);
        viewHolder.unread.setVisibility(8);
        viewHolder.img.setScaleType(ImageView.ScaleType.FIT_END);
        viewHolder.img.setBackgroundResource(R.drawable.rc_ic_bubble_right);
        AnimationDrawable animationDrawable2 = (AnimationDrawable) context.getResources().getDrawable(R.drawable.rc_an_voice_sent);
        if (z) {
            viewHolder.img.setImageDrawable(animationDrawable2);
            if (animationDrawable2 != null) {
                animationDrawable2.start();
                return;
            }
            return;
        }
        ImageView imageView2 = viewHolder.img;
        imageView2.setImageDrawable(imageView2.getResources().getDrawable(R.drawable.rc_ic_voice_sent));
        if (animationDrawable2 != null) {
            animationDrawable2.stop();
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(VoiceMessage voiceMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_voice_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.left = (TextView) viewInflate.findViewById(R.id.rc_left);
        viewHolder.right = (TextView) viewInflate.findViewById(R.id.rc_right);
        viewHolder.img = (ImageView) viewInflate.findViewById(R.id.rc_img);
        viewHolder.unread = (ImageView) viewInflate.findViewById(R.id.rc_voice_unread);
        viewHolder.sendFire = (FrameLayout) viewInflate.findViewById(R.id.fl_send_fire);
        viewHolder.receiverFire = (FrameLayout) viewInflate.findViewById(R.id.fl_receiver_fire);
        viewHolder.receiverFireImg = (ImageView) viewInflate.findViewById(R.id.iv_receiver_fire);
        viewHolder.receiverFireText = (TextView) viewInflate.findViewById(R.id.tv_receiver_fire);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, VoiceMessage voiceMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.receiverFire.setTag(uIMessage.getUId());
        if (!voiceMessage.isDestruct()) {
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
            if (playingUri == null || !playingUri.equals(voiceMessage.getUri())) {
                AudioPlayManager.getInstance().startPlay(view.getContext(), voiceMessage.getUri(), new VoiceMessagePlayListener(view.getContext(), uIMessage, viewHolder, uIMessage.getMessage().getReceivedStatus().isListened()));
                return;
            }
            return;
        }
        Uri playingUri2 = AudioPlayManager.getInstance().getPlayingUri();
        if (playingUri2 == null || !playingUri2.equals(voiceMessage.getUri())) {
            setLayout(view.getContext(), viewHolder, uIMessage, false);
        } else {
            setLayout(view.getContext(), viewHolder, uIMessage, true);
            AudioPlayManager.getInstance().setPlayListener(new VoiceMessagePlayListener(view.getContext(), uIMessage, viewHolder, uIMessage.getMessage().getReceivedStatus().isListened()));
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, VoiceMessage voiceMessage, UIMessage uIMessage) {
        RLog.d(TAG, "Item index:" + i);
        if (voiceMessage == null) {
            return;
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (AudioPlayManager.getInstance().isPlaying()) {
            if (AudioPlayManager.getInstance().getPlayingUri().equals(voiceMessage.getUri())) {
                AudioPlayManager.getInstance().stopPlay();
                return;
            }
            AudioPlayManager.getInstance().stopPlay();
        }
        if (!AudioPlayManager.getInstance().isInNormalMode(view.getContext()) && AudioPlayManager.getInstance().isInVOIPMode(view.getContext())) {
            Toast.makeText(view.getContext(), view.getContext().getString(R.string.rc_voip_occupying), 0).show();
            return;
        }
        viewHolder.unread.setVisibility(8);
        AudioPlayManager.getInstance().startPlay(view.getContext(), voiceMessage.getUri(), new VoiceMessagePlayListener(view.getContext(), uIMessage, viewHolder, uIMessage.getMessage().getReceivedStatus().isListened()));
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, VoiceMessage voiceMessage) {
        if (voiceMessage.isDestruct()) {
            return new SpannableString(context.getString(R.string.rc_message_content_burn));
        }
        return new SpannableString(context.getString(R.string.rc_message_content_voice));
    }
}

package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.resend.ResendManager;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.ImageMessage;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = ImageMessage.class, showProgress = false, showReadState = true)
public class ImageMessageItemProvider extends IContainerItemProvider.MessageProvider<ImageMessage> {
    private static final String TAG = "ImageMessageItemProvider";

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
        TextView clickHint;
        FrameLayout fireView;
        AsyncImageView img;
        TextView message;
        FrameLayout receiverFire;
        ImageView receiverFireImg;
        TextView receiverFireText;
        FrameLayout sendFire;

        private ViewHolder() {
        }
    }

    private void bindFireView(View view, int i, ImageMessage imageMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.img.setVisibility(8);
        viewHolder.fireView.setVisibility(0);
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.sendFire.setVisibility(0);
            viewHolder.receiverFire.setVisibility(8);
            viewHolder.fireView.setBackgroundResource(R.drawable.rc_ic_bubble_no_right);
            Drawable drawable = view.getContext().getResources().getDrawable(R.drawable.rc_fire_sender_album);
            drawable.setBounds(0, 0, RongUtils.dip2px(31.0f), RongUtils.dip2px(26.0f));
            viewHolder.clickHint.setCompoundDrawables(null, drawable, null, null);
            viewHolder.clickHint.setTextColor(Color.parseColor("#FFFFFF"));
            return;
        }
        viewHolder.sendFire.setVisibility(8);
        viewHolder.receiverFire.setVisibility(0);
        viewHolder.fireView.setBackgroundResource(R.drawable.rc_ic_bubble_no_left);
        Drawable drawable2 = view.getContext().getResources().getDrawable(R.drawable.rc_fire_receiver_album);
        drawable2.setBounds(0, 0, RongUtils.dip2px(31.0f), RongUtils.dip2px(26.0f));
        viewHolder.clickHint.setCompoundDrawables(null, drawable2, null, null);
        viewHolder.clickHint.setTextColor(Color.parseColor("#F4B50B"));
        DestructManager.getInstance().addListener(uIMessage.getUId(), new DestructListener(viewHolder, uIMessage), TAG);
        if (uIMessage.getMessage().getReadTime() <= 0) {
            viewHolder.receiverFireText.setVisibility(8);
            viewHolder.receiverFireImg.setVisibility(0);
        } else {
            viewHolder.receiverFireText.setVisibility(0);
            viewHolder.receiverFireImg.setVisibility(8);
            viewHolder.receiverFireText.setText(TextUtils.isEmpty(uIMessage.getUnDestructTime()) ? DestructManager.getInstance().getUnFinishTime(uIMessage.getUId()) : uIMessage.getUnDestructTime());
            DestructManager.getInstance().startDestruct(uIMessage.getMessage());
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(ImageMessage imageMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_image_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.message = (TextView) viewInflate.findViewById(R.id.rc_msg);
        viewHolder.img = (AsyncImageView) viewInflate.findViewById(R.id.rc_img);
        viewHolder.fireView = (FrameLayout) viewInflate.findViewById(R.id.rc_destruct_click);
        viewHolder.sendFire = (FrameLayout) viewInflate.findViewById(R.id.fl_send_fire);
        viewHolder.receiverFire = (FrameLayout) viewInflate.findViewById(R.id.fl_receiver_fire);
        viewHolder.receiverFireImg = (ImageView) viewInflate.findViewById(R.id.iv_receiver_fire);
        viewHolder.receiverFireText = (TextView) viewInflate.findViewById(R.id.tv_receiver_fire);
        viewHolder.clickHint = (TextView) viewInflate.findViewById(R.id.rc_destruct_click_hint);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, ImageMessage imageMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.receiverFire.setTag(uIMessage.getUId());
        if (imageMessage.isDestruct()) {
            bindFireView(view, i, imageMessage, uIMessage);
            return;
        }
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            view.setBackgroundResource(R.drawable.rc_ic_bubble_no_right);
        } else {
            view.setBackgroundResource(R.drawable.rc_ic_bubble_no_left);
        }
        viewHolder.sendFire.setVisibility(8);
        viewHolder.receiverFire.setVisibility(8);
        viewHolder.fireView.setVisibility(8);
        viewHolder.img.setVisibility(0);
        viewHolder.img.setResource(imageMessage.getThumUri());
        int progress = uIMessage.getProgress();
        Message.SentStatus sentStatus = uIMessage.getSentStatus();
        if (sentStatus == null || ((!sentStatus.equals(Message.SentStatus.SENDING) || progress >= 100) && !(sentStatus.equals(Message.SentStatus.FAILED) && ResendManager.getInstance().needResend(uIMessage.getMessageId())))) {
            viewHolder.message.setVisibility(8);
            return;
        }
        viewHolder.message.setText(progress + "%");
        viewHolder.message.setVisibility(0);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, ImageMessage imageMessage, UIMessage uIMessage) {
        if (imageMessage != null) {
            Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_PICTUREPAGERVIEW);
            intent.setPackage(view.getContext().getPackageName());
            intent.putExtra("message", uIMessage.getMessage());
            view.getContext().startActivity(intent);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, ImageMessage imageMessage) {
        if (imageMessage.isDestruct()) {
            return new SpannableString(context.getString(R.string.rc_message_content_burn));
        }
        return new SpannableString(context.getString(R.string.rc_message_content_image));
    }
}

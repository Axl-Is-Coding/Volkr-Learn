package io.rong.imkit.widget.provider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.manager.SendMediaManager;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.resend.ResendManager;
import io.rong.imkit.utilities.OptionsPopupDialog;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.utils.RongOperationPermissionUtils;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.CircleProgressView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.SightMessage;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = SightMessage.class, showProgress = false, showReadState = true)
public class SightMessageItemProvider extends IContainerItemProvider.MessageProvider<SightMessage> {
    private static final String TAG = "Sight-SightMessageItemProvider";

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
        ProgressBar compressProgress;
        TextView duration;
        FrameLayout fireView;
        CircleProgressView loadingProgress;
        FrameLayout message;
        RelativeLayout operationButton;
        ImageView operationIcon;
        FrameLayout receiverFire;
        ImageView receiverFireImg;
        TextView receiverFireText;
        FrameLayout sendFire;
        ImageView tagImg;
        AsyncImageView thumbImg;

        private ViewHolder() {
        }
    }

    private String getSightDuration(int i) {
        if (i <= 0) {
            return "00:00";
        }
        int i2 = i / 60;
        if (i2 < 60) {
            return unitFormat(i2) + ":" + unitFormat(i % 60);
        }
        int i3 = i2 / 60;
        if (i3 > 99) {
            return "99:59:59";
        }
        int i4 = i2 % 60;
        return unitFormat(i3) + ":" + unitFormat(i4) + ":" + unitFormat((i - (i3 * 3600)) - (i4 * 60));
    }

    private void handleSendingView(final UIMessage uIMessage, final ViewHolder viewHolder) {
        final Message.SentStatus sentStatus = uIMessage.getSentStatus();
        if (sentStatus.equals(Message.SentStatus.SENDING)) {
            viewHolder.operationButton.setVisibility(0);
            viewHolder.operationIcon.setImageResource(R.drawable.rc_file_icon_cancel);
        } else if (sentStatus.equals(Message.SentStatus.CANCELED)) {
            viewHolder.operationButton.setVisibility(0);
            viewHolder.operationIcon.setImageResource(R.drawable.rc_ic_warning);
        } else {
            viewHolder.operationButton.setVisibility(8);
        }
        viewHolder.operationButton.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.provider.SightMessageItemProvider.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (sentStatus.equals(Message.SentStatus.SENDING)) {
                    RongIM.getInstance().cancelSendMediaMessage(uIMessage.getMessage(), new RongIMClient.OperationCallback() { // from class: io.rong.imkit.widget.provider.SightMessageItemProvider.2.1
                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onSuccess() {
                            viewHolder.operationButton.setVisibility(0);
                            viewHolder.operationIcon.setImageResource(R.drawable.rc_ic_warning);
                            viewHolder.tagImg.setVisibility(0);
                            viewHolder.loadingProgress.setVisibility(8);
                            viewHolder.compressProgress.setVisibility(8);
                        }
                    });
                } else if (uIMessage.getSentStatus().equals(Message.SentStatus.CANCELED)) {
                    RongIM.getInstance().deleteMessages(new int[]{uIMessage.getMessageId()}, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.widget.provider.SightMessageItemProvider.2.2
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Boolean bool) {
                            if (bool.booleanValue()) {
                                uIMessage.getMessage().setMessageId(0);
                                RongIM.getInstance().sendMediaMessage(uIMessage.getMessage(), (String) null, (String) null, (IRongCallback.ISendMediaMessageCallback) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private boolean isSightDownloaded(SightMessage sightMessage) {
        if (sightMessage.getLocalPath() == null || TextUtils.isEmpty(sightMessage.getLocalPath().toString())) {
            return false;
        }
        String string = sightMessage.getLocalPath().toString();
        if (string.startsWith("file://")) {
            string = string.substring(7);
        }
        return new File(string).exists();
    }

    private String unitFormat(int i) {
        if (i < 0 || i >= 10) {
            return "" + i;
        }
        return "0" + i;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(SightMessage sightMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_sight_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.operationButton = (RelativeLayout) viewInflate.findViewById(R.id.rc_sight_operation);
        viewHolder.operationIcon = (ImageView) viewInflate.findViewById(R.id.rc_sight_operation_icon);
        viewHolder.message = (FrameLayout) viewInflate.findViewById(R.id.rc_message);
        viewHolder.compressProgress = (ProgressBar) viewInflate.findViewById(R.id.compressVideoBar);
        viewHolder.loadingProgress = (CircleProgressView) viewInflate.findViewById(R.id.rc_sight_progress);
        viewHolder.thumbImg = (AsyncImageView) viewInflate.findViewById(R.id.rc_sight_thumb);
        viewHolder.tagImg = (ImageView) viewInflate.findViewById(R.id.rc_sight_tag);
        viewHolder.duration = (TextView) viewInflate.findViewById(R.id.rc_sight_duration);
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
    public void bindView(View view, int i, SightMessage sightMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.receiverFire.setTag(uIMessage.getUId());
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_no_right);
            viewHolder.duration.setPadding(0, 0, (int) view.getContext().getResources().getDimension(R.dimen.rc_dimen_size_12), 0);
        } else {
            viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_no_left);
            viewHolder.duration.setPadding(0, 0, (int) view.getContext().getResources().getDimension(R.dimen.rc_dimen_size_6), 0);
        }
        int progress = uIMessage.getProgress();
        Message.SentStatus sentStatus = uIMessage.getSentStatus();
        if (sightMessage.isDestruct()) {
            viewHolder.fireView.setVisibility(0);
            viewHolder.thumbImg.setVisibility(8);
            if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
                viewHolder.sendFire.setVisibility(0);
                viewHolder.receiverFire.setVisibility(8);
                viewHolder.fireView.setBackgroundResource(R.drawable.rc_ic_bubble_no_right);
                Drawable drawable = view.getContext().getResources().getDrawable(R.drawable.rc_destruct_video_play);
                drawable.setBounds(0, 0, RongUtils.dip2px(22.0f), RongUtils.dip2px(22.0f));
                viewHolder.clickHint.setCompoundDrawables(null, drawable, null, null);
                viewHolder.clickHint.setTextColor(Color.parseColor("#FFFFFF"));
                viewHolder.duration.setTextColor(Color.parseColor("#FFFFFF"));
            } else {
                viewHolder.sendFire.setVisibility(8);
                viewHolder.receiverFire.setVisibility(0);
                viewHolder.fireView.setBackgroundResource(R.drawable.rc_ic_bubble_no_left);
                Drawable drawable2 = view.getContext().getResources().getDrawable(R.drawable.rc_icon_fire_video_play);
                drawable2.setBounds(0, 0, RongUtils.dip2px(22.0f), RongUtils.dip2px(22.0f));
                viewHolder.clickHint.setCompoundDrawables(null, drawable2, null, null);
                viewHolder.clickHint.setTextColor(Color.parseColor("#F4B50B"));
                viewHolder.duration.setTextColor(Color.parseColor("#F4B50B"));
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
        } else {
            viewHolder.sendFire.setVisibility(8);
            viewHolder.receiverFire.setVisibility(8);
            viewHolder.fireView.setVisibility(8);
            viewHolder.thumbImg.setVisibility(0);
            viewHolder.thumbImg.setResource(sightMessage.getThumbUri());
            viewHolder.duration.setTextColor(Color.parseColor("#FFFFFF"));
        }
        viewHolder.duration.setText(getSightDuration(sightMessage.getDuration()));
        if (progress > 0 && progress < 100) {
            viewHolder.loadingProgress.setProgress(progress, true);
            viewHolder.tagImg.setVisibility(8);
            viewHolder.loadingProgress.setVisibility(0);
            viewHolder.compressProgress.setVisibility(8);
            return;
        }
        if (sentStatus.equals(Message.SentStatus.SENDING)) {
            viewHolder.tagImg.setVisibility(8);
            viewHolder.loadingProgress.setVisibility(8);
            viewHolder.compressProgress.setVisibility(0);
        } else if (sentStatus.equals(Message.SentStatus.FAILED) && ResendManager.getInstance().needResend(uIMessage.getMessageId())) {
            viewHolder.tagImg.setVisibility(8);
            viewHolder.loadingProgress.setVisibility(8);
            viewHolder.compressProgress.setVisibility(0);
        } else {
            viewHolder.tagImg.setVisibility(0);
            viewHolder.loadingProgress.setVisibility(8);
            viewHolder.compressProgress.setVisibility(8);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, SightMessage sightMessage, UIMessage uIMessage) {
        if (sightMessage == null || !RongOperationPermissionUtils.isMediaOperationPermit(view.getContext())) {
            return;
        }
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        if (!PermissionCheckUtil.checkPermissions(view.getContext(), strArr)) {
            PermissionCheckUtil.requestPermissions((Activity) view.getContext(), strArr, 100);
            return;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("rong").authority(view.getContext().getPackageName()).appendPath("sight").appendPath("player");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(builder.build().toString()));
        intent.setPackage(view.getContext().getPackageName());
        intent.putExtra("SightMessage", sightMessage);
        intent.putExtra("Message", uIMessage.getMessage());
        intent.putExtra("Progress", uIMessage.getProgress());
        if (intent.resolveActivity(view.getContext().getPackageManager()) != null) {
            view.getContext().startActivity(intent);
        } else {
            Toast.makeText(view.getContext(), "Sight Module does not exist.", 0).show();
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemLongClick(View view, int i, SightMessage sightMessage, final UIMessage uIMessage) {
        if (uIMessage.getMessage().getSentStatus().getValue() < Message.SentStatus.SENT.getValue()) {
            OptionsPopupDialog.newInstance(view.getContext(), new String[]{view.getContext().getResources().getString(R.string.rc_dialog_item_message_delete)}).setOptionsPopupDialogListener(new OptionsPopupDialog.OnOptionsItemClickedListener() { // from class: io.rong.imkit.widget.provider.SightMessageItemProvider.1
                @Override // io.rong.imkit.utilities.OptionsPopupDialog.OnOptionsItemClickedListener
                public void onOptionsItemClicked(int i2) {
                    if (i2 == 0) {
                        SendMediaManager.getInstance().cancelSendingMedia(uIMessage.getConversationType(), uIMessage.getTargetId(), uIMessage.getMessageId());
                        RongIM.getInstance().cancelSendMediaMessage(uIMessage.getMessage(), null);
                        RongIM.getInstance().deleteMessages(new int[]{uIMessage.getMessageId()}, null);
                    }
                }
            }).show();
        } else {
            super.onItemLongClick(view, i, sightMessage, uIMessage);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, SightMessage sightMessage) {
        if (sightMessage.isDestruct()) {
            return new SpannableString(context.getString(R.string.rc_message_content_burn));
        }
        return new SpannableString(context.getResources().getString(R.string.rc_message_content_sight));
    }
}

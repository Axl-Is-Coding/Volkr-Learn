package io.rong.imkit.widget.provider;

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
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.target.Target;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.resend.ResendManager;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.CircleProgressView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.GIFMessage;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = GIFMessage.class, showProgress = false, showReadState = true)
public class GIFMessageItemProvider extends IContainerItemProvider.MessageProvider<GIFMessage> {
    private static final String TAG = "GIFMessageItemProvider";

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
        ImageView downLoadFailed;
        FrameLayout fireView;
        AsyncImageView img;
        TextView length;
        CircleProgressView loadingProgress;
        ProgressBar preProgress;
        FrameLayout receiverFire;
        ImageView receiverFireImg;
        TextView receiverFireText;
        FrameLayout sendFire;
        ImageView startDownLoad;

        private ViewHolder() {
        }
    }

    private boolean checkPermission(Context context) {
        return PermissionCheckUtil.checkPermissions(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void downLoad(Message message, ViewHolder viewHolder) {
        viewHolder.preProgress.setVisibility(0);
        RongIM.getInstance().downloadMediaMessage(message, null);
    }

    private String formatSize(long j) {
        if (j > 1048576) {
            return (Math.round((j / 1048576.0f) * 100.0f) / 100.0f) + "M";
        }
        if (j <= 1024) {
            return j + "B";
        }
        return (Math.round((j / 1024.0f) * 100.0f) / 100.0f) + "KB";
    }

    private int[] getParamsValue(Context context, int i, int i2) {
        int iRound;
        int iDip2px = dip2px(context, 120.0f);
        int iDip2px2 = dip2px(context, 80.0f);
        if (i > iDip2px) {
            iRound = Math.round(i2 / (i / iDip2px));
            if (iRound >= iDip2px2) {
                iDip2px2 = iRound;
            }
        } else if (i < iDip2px2) {
            iRound = Math.round(i2 * (i / iDip2px2));
            if (iRound < iDip2px2) {
                iRound = iDip2px2;
            }
            iDip2px = iDip2px2;
            iDip2px2 = iRound;
        } else {
            iDip2px = Math.round(i2);
            iDip2px2 = Math.round(i);
        }
        return new int[]{iDip2px, iDip2px2};
    }

    private void loadGif(View view, Uri uri, ViewHolder viewHolder) {
        c.c(view.getContext()).asGif().diskCacheStrategy(p.f4584d).mo46load(uri.getPath()).listener(new e<GifDrawable>() { // from class: io.rong.imkit.widget.provider.GIFMessageItemProvider.1
            @Override // com.bumptech.glide.request.e
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<GifDrawable> target, boolean z) {
                return false;
            }

            @Override // com.bumptech.glide.request.e
            public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z) {
                return false;
            }
        }).into(viewHolder.img);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(GIFMessage gIFMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_gif_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.img = (AsyncImageView) viewInflate.findViewById(R.id.rc_img);
        viewHolder.preProgress = (ProgressBar) viewInflate.findViewById(R.id.rc_pre_progress);
        viewHolder.loadingProgress = (CircleProgressView) viewInflate.findViewById(R.id.rc_gif_progress);
        viewHolder.startDownLoad = (ImageView) viewInflate.findViewById(R.id.rc_start_download);
        viewHolder.downLoadFailed = (ImageView) viewInflate.findViewById(R.id.rc_download_failed);
        viewHolder.length = (TextView) viewInflate.findViewById(R.id.rc_length);
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
    public void bindView(View view, int i, GIFMessage gIFMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.receiverFire.setTag(uIMessage.getUId());
        viewHolder.startDownLoad.setVisibility(8);
        viewHolder.downLoadFailed.setVisibility(8);
        viewHolder.preProgress.setVisibility(8);
        viewHolder.loadingProgress.setVisibility(8);
        viewHolder.length.setVisibility(8);
        int[] paramsValue = getParamsValue(view.getContext(), gIFMessage.getWidth(), gIFMessage.getHeight());
        viewHolder.img.setLayoutParam(paramsValue[0], paramsValue[1]);
        viewHolder.img.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.def_gif_bg));
        int progress = uIMessage.getProgress();
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            Message.SentStatus sentStatus = uIMessage.getSentStatus();
            if ((progress > 0 && progress < 100) || (sentStatus.equals(Message.SentStatus.FAILED) && ResendManager.getInstance().needResend(uIMessage.getMessageId()))) {
                viewHolder.loadingProgress.setProgress(progress, true);
                viewHolder.loadingProgress.setVisibility(0);
                viewHolder.preProgress.setVisibility(8);
            } else if (sentStatus.equals(Message.SentStatus.SENDING)) {
                viewHolder.loadingProgress.setVisibility(8);
            } else if (progress == -1) {
                viewHolder.loadingProgress.setVisibility(8);
                viewHolder.preProgress.setVisibility(8);
                viewHolder.downLoadFailed.setVisibility(0);
                viewHolder.length.setVisibility(0);
            } else {
                viewHolder.loadingProgress.setVisibility(8);
                viewHolder.preProgress.setVisibility(8);
            }
        } else if (!uIMessage.getReceivedStatus().isDownload()) {
            viewHolder.loadingProgress.setVisibility(8);
            viewHolder.preProgress.setVisibility(8);
            viewHolder.length.setVisibility(8);
            viewHolder.startDownLoad.setVisibility(8);
            if (progress == -1) {
                viewHolder.downLoadFailed.setVisibility(0);
                viewHolder.length.setVisibility(0);
                viewHolder.length.setText(formatSize(gIFMessage.getGifDataSize()));
            }
        } else if (progress > 0 && progress < 100) {
            viewHolder.loadingProgress.setProgress(progress, true);
            viewHolder.loadingProgress.setVisibility(0);
            viewHolder.preProgress.setVisibility(8);
            viewHolder.startDownLoad.setVisibility(8);
        } else if (progress == 100) {
            viewHolder.loadingProgress.setVisibility(8);
            viewHolder.preProgress.setVisibility(8);
            viewHolder.length.setVisibility(8);
            viewHolder.startDownLoad.setVisibility(8);
        } else if (progress == -1) {
            viewHolder.loadingProgress.setVisibility(8);
            viewHolder.preProgress.setVisibility(8);
            viewHolder.downLoadFailed.setVisibility(0);
            viewHolder.length.setVisibility(0);
            viewHolder.startDownLoad.setVisibility(8);
        } else {
            viewHolder.loadingProgress.setVisibility(8);
            viewHolder.preProgress.setVisibility(0);
            viewHolder.length.setVisibility(0);
            viewHolder.startDownLoad.setVisibility(8);
        }
        if (!gIFMessage.isDestruct()) {
            viewHolder.receiverFire.setVisibility(8);
            viewHolder.sendFire.setVisibility(8);
        } else if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.sendFire.setVisibility(0);
            viewHolder.receiverFire.setVisibility(8);
            viewHolder.fireView.setBackgroundResource(R.drawable.rc_ic_bubble_no_right);
            Drawable drawable = view.getContext().getResources().getDrawable(R.drawable.rc_fire_sender_album);
            drawable.setBounds(0, 0, RongUtils.dip2px(40.0f), RongUtils.dip2px(34.0f));
            viewHolder.clickHint.setCompoundDrawables(null, drawable, null, null);
            viewHolder.clickHint.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            viewHolder.sendFire.setVisibility(8);
            viewHolder.receiverFire.setVisibility(0);
            viewHolder.fireView.setBackgroundResource(R.drawable.rc_ic_bubble_no_left);
            Drawable drawable2 = view.getContext().getResources().getDrawable(R.drawable.rc_fire_receiver_album);
            drawable2.setBounds(0, 0, RongUtils.dip2px(40.0f), RongUtils.dip2px(34.0f));
            viewHolder.clickHint.setCompoundDrawables(null, drawable2, null, null);
            viewHolder.clickHint.setTextColor(Color.parseColor("#F4B50B"));
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
        if (gIFMessage.getLocalPath() != null) {
            if (gIFMessage.isDestruct()) {
                viewHolder.fireView.setVisibility(0);
                viewHolder.img.setVisibility(8);
                return;
            } else {
                viewHolder.fireView.setVisibility(8);
                viewHolder.img.setVisibility(0);
                loadGif(view, gIFMessage.getLocalUri(), viewHolder);
                return;
            }
        }
        if (gIFMessage.getGifDataSize() <= view.getContext().getResources().getInteger(R.integer.rc_gifmsg_auto_download_size) * 1024) {
            if (checkPermission(view.getContext())) {
                if (uIMessage.getReceivedStatus().isDownload()) {
                    return;
                }
                uIMessage.getReceivedStatus().setDownload();
                downLoad(uIMessage.getMessage(), viewHolder);
                return;
            }
            if (progress != -1) {
                viewHolder.startDownLoad.setVisibility(0);
                viewHolder.length.setVisibility(0);
                viewHolder.length.setText(formatSize(gIFMessage.getGifDataSize()));
                return;
            }
            return;
        }
        if (progress > 0 && progress < 100) {
            viewHolder.startDownLoad.setVisibility(8);
            viewHolder.length.setVisibility(0);
            viewHolder.length.setText(formatSize(gIFMessage.getGifDataSize()));
        } else if (progress != -1) {
            viewHolder.startDownLoad.setVisibility(0);
            viewHolder.preProgress.setVisibility(8);
            viewHolder.loadingProgress.setVisibility(8);
            viewHolder.downLoadFailed.setVisibility(8);
            viewHolder.length.setVisibility(0);
            viewHolder.length.setText(formatSize(gIFMessage.getGifDataSize()));
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, GIFMessage gIFMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder.startDownLoad.getVisibility() == 0) {
            viewHolder.startDownLoad.setVisibility(8);
            if (checkPermission(view.getContext())) {
                downLoad(uIMessage.getMessage(), viewHolder);
                return;
            }
            viewHolder.downLoadFailed.setVisibility(0);
            viewHolder.length.setVisibility(0);
            viewHolder.length.setText(formatSize(gIFMessage.getGifDataSize()));
            Toast.makeText(view.getContext(), R.string.rc_ac_file_download_request_permission, 0).show();
            return;
        }
        if (viewHolder.downLoadFailed.getVisibility() == 0) {
            viewHolder.downLoadFailed.setVisibility(8);
            if (checkPermission(view.getContext())) {
                downLoad(uIMessage.getMessage(), viewHolder);
                return;
            }
            viewHolder.downLoadFailed.setVisibility(0);
            viewHolder.length.setVisibility(0);
            viewHolder.length.setText(formatSize(gIFMessage.getGifDataSize()));
            Toast.makeText(view.getContext(), R.string.rc_ac_file_download_request_permission, 0).show();
            return;
        }
        if (viewHolder.preProgress.getVisibility() == 0 || viewHolder.loadingProgress.getVisibility() == 0 || gIFMessage == null) {
            return;
        }
        Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_GIF_VIEW);
        intent.setPackage(view.getContext().getPackageName());
        intent.putExtra("message", uIMessage.getMessage());
        view.getContext().startActivity(intent);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemLongClick(View view, int i, GIFMessage gIFMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder.startDownLoad.getVisibility() == 0 || viewHolder.downLoadFailed.getVisibility() == 0 || viewHolder.loadingProgress.getVisibility() == 0) {
            return;
        }
        super.onItemLongClick(view, i, gIFMessage, uIMessage);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, GIFMessage gIFMessage) {
        if (gIFMessage.isDestruct()) {
            return new SpannableString(context.getString(R.string.rc_message_content_burn));
        }
        return new SpannableString(context.getString(R.string.rc_message_content_image));
    }
}

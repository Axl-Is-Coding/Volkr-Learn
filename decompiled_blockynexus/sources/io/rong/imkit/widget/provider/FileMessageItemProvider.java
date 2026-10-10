package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.resend.ResendManager;
import io.rong.imkit.utils.FileTypeUtils;
import io.rong.imkit.widget.EllipsizeTextView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.FileMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = FileMessage.class, showProgress = false, showReadState = true)
public class FileMessageItemProvider extends IContainerItemProvider.MessageProvider<FileMessage> {
    private static final String TAG = "FileMessageItemProvider";

    private static class ViewHolder {
        RelativeLayout cancelButton;
        TextView canceledMessage;
        EllipsizeTextView fileName;
        TextView fileSize;
        ImageView fileTypeImage;
        ProgressBar fileUploadProgress;
        LinearLayout message;

        private ViewHolder() {
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(FileMessage fileMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_file_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.message = (LinearLayout) viewInflate.findViewById(R.id.rc_message);
        viewHolder.fileTypeImage = (ImageView) viewInflate.findViewById(R.id.rc_msg_iv_file_type_image);
        viewHolder.fileName = (EllipsizeTextView) viewInflate.findViewById(R.id.rc_msg_tv_file_name);
        viewHolder.fileSize = (TextView) viewInflate.findViewById(R.id.rc_msg_tv_file_size);
        viewHolder.fileUploadProgress = (ProgressBar) viewInflate.findViewById(R.id.rc_msg_pb_file_upload_progress);
        viewHolder.cancelButton = (RelativeLayout) viewInflate.findViewById(R.id.rc_btn_cancel);
        viewHolder.canceledMessage = (TextView) viewInflate.findViewById(R.id.rc_msg_canceled);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, FileMessage fileMessage, final UIMessage uIMessage) {
        final ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_right_file);
        } else {
            viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_left_file);
        }
        viewHolder.fileName.setAdaptiveText(fileMessage.getName());
        viewHolder.fileSize.setText(FileTypeUtils.formatFileSize(fileMessage.getSize()));
        viewHolder.fileTypeImage.setImageResource(FileTypeUtils.fileTypeImageId(view.getContext(), fileMessage.getName()));
        if (uIMessage.getSentStatus().equals(Message.SentStatus.SENDING) && uIMessage.getProgress() < 100) {
            viewHolder.fileUploadProgress.setVisibility(0);
            viewHolder.cancelButton.setVisibility(0);
            viewHolder.canceledMessage.setVisibility(4);
            viewHolder.fileUploadProgress.setProgress(uIMessage.getProgress());
        } else if (uIMessage.getSentStatus().equals(Message.SentStatus.FAILED) && ResendManager.getInstance().needResend(uIMessage.getMessageId())) {
            viewHolder.fileUploadProgress.setVisibility(0);
            viewHolder.cancelButton.setVisibility(8);
            viewHolder.canceledMessage.setVisibility(4);
            viewHolder.fileUploadProgress.setProgress(uIMessage.getProgress());
        } else {
            if (uIMessage.getSentStatus().equals(Message.SentStatus.CANCELED)) {
                viewHolder.canceledMessage.setVisibility(0);
            } else {
                viewHolder.canceledMessage.setVisibility(4);
            }
            viewHolder.fileUploadProgress.setVisibility(4);
            viewHolder.cancelButton.setVisibility(8);
        }
        viewHolder.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.provider.FileMessageItemProvider.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RongIM.getInstance().cancelSendMediaMessage(uIMessage.getMessage(), new RongIMClient.OperationCallback() { // from class: io.rong.imkit.widget.provider.FileMessageItemProvider.1.1
                    @Override // io.rong.imlib.RongIMClient.Callback
                    public void onError(RongIMClient.ErrorCode errorCode) {
                    }

                    @Override // io.rong.imlib.RongIMClient.Callback
                    public void onSuccess() {
                        ResendManager.getInstance().removeResendMessage(uIMessage.getMessageId());
                        viewHolder.canceledMessage.setVisibility(0);
                        viewHolder.fileUploadProgress.setVisibility(4);
                        viewHolder.cancelButton.setVisibility(8);
                    }
                });
            }
        });
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, FileMessage fileMessage, UIMessage uIMessage) {
        Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_OPENFILE);
        intent.setPackage(view.getContext().getPackageName());
        intent.putExtra("FileMessage", fileMessage);
        intent.putExtra("Message", uIMessage.getMessage());
        intent.putExtra("Progress", uIMessage.getProgress());
        view.getContext().startActivity(intent);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, FileMessage fileMessage) {
        StringBuilder sb = new StringBuilder();
        String name = fileMessage.getName();
        sb.append(context.getString(R.string.rc_message_content_file));
        sb.append(" ");
        sb.append(name);
        return new SpannableString(sb);
    }
}

package io.rong.imkit.widget.provider;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.message.CombineMessage;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.utils.CombineMessageUtils;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(messageContent = CombineMessage.class, showReadState = true)
public class CombineMessageItemProvider extends IContainerItemProvider.MessageProvider<CombineMessage> {

    private static class ViewHolder {
        LinearLayout message;
        TextView summary;
        TextView title;

        private ViewHolder() {
        }
    }

    private String getTitle(CombineMessage combineMessage) {
        Context applicationContext = RongIM.getInstance().getApplicationContext();
        String string = "";
        if (Conversation.ConversationType.GROUP.equals(combineMessage.getConversationType())) {
            string = applicationContext.getString(R.string.rc_combine_group_chat);
        } else {
            List<String> nameList = combineMessage.getNameList();
            if (nameList == null) {
                return "";
            }
            if (nameList.size() == 1) {
                string = String.format(applicationContext.getString(R.string.rc_combine_the_group_chat_of), nameList.get(0));
            } else if (nameList.size() == 2) {
                string = String.format(applicationContext.getString(R.string.rc_combine_the_group_chat_of), nameList.get(0) + " " + applicationContext.getString(R.string.rc_combine_and) + " " + nameList.get(1));
            }
        }
        return TextUtils.isEmpty(string) ? applicationContext.getString(R.string.rc_combine_chat_history) : string;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(CombineMessage combineMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_combine_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.message = (LinearLayout) viewInflate.findViewById(R.id.rc_message);
        viewHolder.title = (TextView) viewInflate.findViewById(R.id.title);
        viewHolder.summary = (TextView) viewInflate.findViewById(R.id.summary);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, CombineMessage combineMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_right);
        } else {
            viewHolder.message.setBackgroundResource(R.drawable.rc_ic_bubble_left);
        }
        combineMessage.setTitle(getTitle(combineMessage));
        viewHolder.title.setText(combineMessage.getTitle());
        StringBuilder sb = new StringBuilder();
        List<String> summaryList = combineMessage.getSummaryList();
        for (int i2 = 0; i2 < summaryList.size() && i2 < 4; i2++) {
            if (i2 == 0) {
                sb = new StringBuilder(summaryList.get(i2));
            } else {
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                sb.append(summaryList.get(i2));
            }
        }
        viewHolder.summary.setText(sb.toString());
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, CombineMessage combineMessage, UIMessage uIMessage) {
        Uri localPath = combineMessage.getLocalPath();
        String str = "local";
        if ((localPath == null || !new File(localPath.toString().substring(7)).exists()) && combineMessage.getMediaUrl() != null) {
            String combineFilePath = CombineMessageUtils.getInstance().getCombineFilePath(combineMessage.getMediaUrl().toString());
            if (new File(combineFilePath).exists()) {
                localPath = Uri.parse("file://" + combineFilePath);
            } else {
                localPath = combineMessage.getMediaUrl();
                str = "media";
            }
        }
        if (localPath == null) {
            Context context = view.getContext();
            new AlertDialog.Builder(context).setMessage(context.getString(R.string.rc_combine_history_deleted)).setPositiveButton(context.getString(R.string.rc_dialog_ok), (DialogInterface.OnClickListener) null).show();
            return;
        }
        Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_COMBINEWEBVIEW);
        intent.setPackage(view.getContext().getPackageName());
        intent.addFlags(268435456);
        intent.putExtra("messageId", uIMessage.getMessageId());
        intent.putExtra(ShareConstants.MEDIA_URI, localPath.toString());
        intent.putExtra("type", str);
        intent.putExtra("title", combineMessage.getTitle());
        view.getContext().startActivity(intent);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, CombineMessage combineMessage) {
        return new SpannableString(context.getString(R.string.rc_message_content_combine));
    }
}

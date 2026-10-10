package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import io.rong.imkit.R;
import io.rong.imkit.RongMessageItemLongClickActionManager;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utilities.OptionsPopupDialog;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IContainerItemProvider<T> {

    public interface ConversationProvider<T extends Parcelable> extends IContainerItemProvider<T> {
        Uri getPortraitUri(String str);

        String getTitle(String str);
    }

    public static abstract class MessageProvider<K extends MessageContent> implements IContainerItemProvider<UIMessage>, Cloneable {
        public abstract void bindView(View view, int i, K k, UIMessage uIMessage);

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public Spannable getContentSummary(Context context, K k) {
            return getContentSummary(k);
        }

        public abstract Spannable getContentSummary(K k);

        public String getPushContent(Context context, UIMessage uIMessage) {
            UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(uIMessage.getSenderUserId());
            return context.getString(R.string.rc_user_recalled_message, userInfo != null ? userInfo.getName() : "");
        }

        public Spannable getSummary(UIMessage uIMessage) {
            return getContentSummary(uIMessage.getContent());
        }

        public abstract void onItemClick(View view, int i, K k, UIMessage uIMessage);

        public void onItemLongClick(final View view, final int i, K k, final UIMessage uIMessage) {
            final List<MessageItemLongClickAction> messageItemLongClickActions = RongMessageItemLongClickActionManager.getInstance().getMessageItemLongClickActions(uIMessage);
            Collections.sort(messageItemLongClickActions, new Comparator<MessageItemLongClickAction>() { // from class: io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider.1
                @Override // java.util.Comparator
                public int compare(MessageItemLongClickAction messageItemLongClickAction, MessageItemLongClickAction messageItemLongClickAction2) {
                    return messageItemLongClickAction2.priority - messageItemLongClickAction.priority;
                }
            });
            ArrayList arrayList = new ArrayList();
            Iterator<MessageItemLongClickAction> it = messageItemLongClickActions.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getTitle(view.getContext()));
            }
            OptionsPopupDialog optionsPopupDialogListener = OptionsPopupDialog.newInstance(view.getContext(), (String[]) arrayList.toArray(new String[arrayList.size()])).setOptionsPopupDialogListener(new OptionsPopupDialog.OnOptionsItemClickedListener() { // from class: io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider.2
                @Override // io.rong.imkit.utilities.OptionsPopupDialog.OnOptionsItemClickedListener
                public void onOptionsItemClicked(int i2) {
                    if (((MessageItemLongClickAction) messageItemLongClickActions.get(i2)).listener.onMessageItemLongClick(view.getContext(), uIMessage)) {
                        return;
                    }
                    MessageProvider.this.onItemLongClickAction(view, i, uIMessage);
                }
            });
            RongMessageItemLongClickActionManager.getInstance().setLongClickDialog(optionsPopupDialogListener);
            RongMessageItemLongClickActionManager.getInstance().setLongClickMessage(uIMessage.getMessage());
            optionsPopupDialogListener.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    RongMessageItemLongClickActionManager.getInstance().setLongClickDialog(null);
                    RongMessageItemLongClickActionManager.getInstance().setLongClickMessage(null);
                }
            });
            optionsPopupDialogListener.show();
        }

        public void onItemLongClickAction(View view, int i, UIMessage uIMessage) {
        }

        @Override // io.rong.imkit.widget.provider.IContainerItemProvider
        public final void bindView(View view, int i, UIMessage uIMessage) {
            bindView(view, i, uIMessage.getContent(), uIMessage);
        }
    }

    void bindView(View view, int i, T t);

    View newView(Context context, ViewGroup viewGroup);
}

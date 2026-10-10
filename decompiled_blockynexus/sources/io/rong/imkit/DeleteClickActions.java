package io.rong.imkit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import io.rong.imkit.actions.IClickActions;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.model.Message;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DeleteClickActions implements IClickActions {
    @Override // io.rong.imkit.actions.IClickActions
    public Drawable obtainDrawable(Context context) {
        return context.getResources().getDrawable(R.drawable.rc_select_multi_delete);
    }

    @Override // io.rong.imkit.actions.IClickActions
    public void onClick(Fragment fragment) {
        ConversationFragment conversationFragment = (ConversationFragment) fragment;
        List<Message> checkedMessages = conversationFragment.getCheckedMessages();
        if (checkedMessages == null || checkedMessages.size() <= 0) {
            return;
        }
        int[] iArr = new int[checkedMessages.size()];
        for (int i = 0; i < checkedMessages.size(); i++) {
            iArr[i] = checkedMessages.get(i).getMessageId();
        }
        RongIM.getInstance().deleteMessages(iArr, null);
        conversationFragment.resetMoreActionState();
    }
}

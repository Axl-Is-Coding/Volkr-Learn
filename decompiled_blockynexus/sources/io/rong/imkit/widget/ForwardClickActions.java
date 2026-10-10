package io.rong.imkit.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.actions.IClickActions;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imkit.utils.ForwardManager;
import io.rong.imlib.model.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ForwardClickActions implements IClickActions {
    private static final String TAG = "ForwardClickActions";
    private BottomMenuDialog dialog;

    /* JADX INFO: Access modifiers changed from: private */
    public void startSelectConversationActivity(Fragment fragment, int i) {
        ConversationFragment conversationFragment = (ConversationFragment) fragment;
        List<Message> listFilterMessagesList = ForwardManager.filterMessagesList(conversationFragment.getContext(), conversationFragment.getCheckedMessages(), i);
        if (listFilterMessagesList.size() == 0) {
            RLog.e(TAG, "startSelectConversationActivity the size of messages is 0!");
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Iterator<Message> it = listFilterMessagesList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().getMessageId()));
        }
        Intent selectIntentForForward = conversationFragment.getSelectIntentForForward();
        selectIntentForForward.putExtra(FirebaseAnalytics.Param.INDEX, i);
        selectIntentForForward.putIntegerArrayListExtra("messageIds", arrayList);
        conversationFragment.startActivityForResult(selectIntentForForward, 104);
    }

    @Override // io.rong.imkit.actions.IClickActions
    public Drawable obtainDrawable(Context context) {
        return context.getResources().getDrawable(R.drawable.rc_selector_multi_forward);
    }

    @Override // io.rong.imkit.actions.IClickActions
    public void onClick(final Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing()) {
            RLog.e(TAG, "onClick activity is null or finishing.");
            return;
        }
        BottomMenuDialog bottomMenuDialog = this.dialog;
        if (bottomMenuDialog != null && bottomMenuDialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.dialog = new BottomMenuDialog(activity);
        this.dialog.setConfirmListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.ForwardClickActions.1
            @Override // android.view.View.OnClickListener
            @TargetApi(23)
            public void onClick(View view) {
                if (ForwardClickActions.this.dialog != null) {
                    ForwardClickActions.this.dialog.dismiss();
                }
                ForwardClickActions.this.startSelectConversationActivity(fragment, 0);
            }
        });
        this.dialog.setMiddleListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.ForwardClickActions.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForwardClickActions.this.dialog != null) {
                    ForwardClickActions.this.dialog.dismiss();
                }
                ForwardClickActions.this.startSelectConversationActivity(fragment, 1);
            }
        });
        this.dialog.setCancelListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.ForwardClickActions.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForwardClickActions.this.dialog != null) {
                    ForwardClickActions.this.dialog.dismiss();
                }
            }
        });
        this.dialog.show();
    }
}

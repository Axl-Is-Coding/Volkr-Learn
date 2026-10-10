package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0630kb;
import com.disabngo.blockynexus.entity.FriendRequestAdd;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.ra, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApplyFriendDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class DialogC1114ra extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f11676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f11677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AbstractC0630kb f11678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f11679d;

    public DialogC1114ra(Context context, long j, String str) {
        super(context);
        this.f11676a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f11537a.cancel();
            }
        });
        this.f11677b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f11531a.onConfirm();
            }
        });
        this.f11679d = j;
        initView();
        a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfirm() {
        if (this.f11678c != null) {
            FriendRequestAdd friendRequestAdd = new FriendRequestAdd();
            friendRequestAdd.setMsg(this.f11678c.f8510c.getText().toString().trim());
            friendRequestAdd.setFriendId(this.f11679d);
            FriendApi.friendAdd(this.context, friendRequestAdd, new C1113qa(this));
        }
        ReportDataAdapter.onEvent(this.context, EventConstant.FIND_CLICK_ADDFIREND_CF);
        SandboxReportManager.onEvent(ReportEvent.USER_ADD_FRIEND_NUM, ReportEventType.USER_ORDINARY_BEHAVIOR, "android", "1");
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        View currentFocus = getCurrentFocus();
        if (currentFocus instanceof TextView) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        super.dismiss();
    }

    protected void initView() {
        this.f11678c = (AbstractC0630kb) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_apply_friend, (ViewGroup) null, false);
        this.f11678c.a(this);
        setContentView(this.f11678c.getRoot());
    }

    private void a(String str) {
        this.f11678c.f8510c.setText(str);
    }
}

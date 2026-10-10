package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Nc;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeSettingGuideDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Ta extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f11383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11384c;

    public Ta(Context context, boolean z) {
        super(context);
        this.f11383b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.ca
            @Override // rx.functions.Action0
            public final void call() {
                this.f11535a.a();
            }
        });
        this.f11384c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.da
            @Override // rx.functions.Action0
            public final void call() {
                this.f11541a.b();
            }
        });
        a(context);
        this.f11382a = z;
    }

    private void a(Context context) {
        Nc nc = (Nc) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_tribe_setting_guide, (ViewGroup) null, false);
        nc.a(this);
        setContentView(nc.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_SETUP_TIME);
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.sa.b.class, context.getString(R.string.tribe_setting));
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_TRIBE_SETTING_DIALOG);
        dismiss();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog
    public void show() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_TRIBE_SETTING_DIALOG);
        dismiss();
    }
}

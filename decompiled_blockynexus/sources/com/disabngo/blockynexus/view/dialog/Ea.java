package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0642lc;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SizeUtil;
import rx.functions.Action0;

/* JADX INFO: compiled from: SafeSettingGuideDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Ea extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f11282a;

    public Ea(Context context) {
        super(context);
        this.f11282a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.F
            @Override // rx.functions.Action0
            public final void call() {
                this.f11287a.b();
            }
        });
        a(context);
    }

    private void a(Context context) {
        AbstractC0642lc abstractC0642lc = (AbstractC0642lc) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_safe_setting_guide, (ViewGroup) null, false);
        abstractC0642lc.a(this);
        setContentView(abstractC0642lc.getRoot());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) abstractC0642lc.f8546a.getLayoutParams();
        layoutParams.setMargins(0, a() + ((int) SizeUtil.dp2px(context, 60.0f)), 0, 0);
        abstractC0642lc.f8546a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ReportDataAdapter.onEvent(this.context, EventConstant.SAFE_SETUP_TIME);
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ca.c.class, context.getString(R.string.item_view_safe_setting));
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_SAFE_SETTING_DIALOG);
        dismiss();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog
    public void show() {
        super.show();
        ReportDataAdapter.onEvent(this.context, EventConstant.SAFE_GUIDE_TIME);
    }

    private int a() {
        Resources resources = this.context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }
}

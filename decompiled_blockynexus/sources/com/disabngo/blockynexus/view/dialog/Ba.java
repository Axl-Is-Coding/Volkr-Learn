package com.disabngo.blockynexus.view.dialog;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Gb;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;

/* JADX INFO: compiled from: HelpContactDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Ba extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f11263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11265d;

    public Ba(Context context, boolean z) {
        super(context);
        this.f11263b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.w
            @Override // rx.functions.Action0
            public final void call() {
                this.f11710a.a();
            }
        });
        this.f11264c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.v
            @Override // rx.functions.Action0
            public final void call() {
                this.f11690a.b();
            }
        });
        this.f11265d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.C
            @Override // rx.functions.Action0
            public final void call() {
                this.f11269a.dismiss();
            }
        });
        this.f11262a = z;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (!com.disabngo.blockynexus.d.A.a(this.context)) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.no_browser);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(UrlConstant.DISCORD_URL));
            this.context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:blockymods@sandboxol.com"));
        intent.putExtra("android.intent.extra.SUBJECT", this.context.getString(R.string.help_mail_title));
        Context context = this.context;
        context.startActivity(Intent.createChooser(intent, context.getString(R.string.help_select_app)));
    }

    public void initView() {
        Gb gb = (Gb) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_help_contact, (ViewGroup) null, false);
        gb.a(this);
        setContentView(gb.getRoot());
    }
}

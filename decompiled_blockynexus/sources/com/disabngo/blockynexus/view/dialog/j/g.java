package com.disabngo.blockynexus.view.dialog.j;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Pc;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: WeekSignDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<DailySignInfo> f11618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Pc f11619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimationDrawable f11620c;
    private Context context;

    public g(Context context, List<DailySignInfo> list) {
        super(context);
        this.context = context;
        this.f11618a = list;
        initView();
        ReportDataAdapter.onEvent(context, EventConstant.SIGN_IN_TIME);
    }

    private void a() {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.week_sign_dialog_enter_anim);
        animationLoadAnimation.setFillAfter(true);
        this.f11619b.f7767b.startAnimation(animationLoadAnimation);
        c();
    }

    private void b() {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.week_sign_dialog_exit_anim);
        animationLoadAnimation.setFillAfter(true);
        this.f11619b.f7767b.startAnimation(animationLoadAnimation);
        d();
    }

    private void c() {
        if (this.f11620c.isRunning()) {
            return;
        }
        this.f11620c.start();
    }

    private void d() {
        if (this.f11620c.isRunning()) {
            this.f11620c.stop();
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Messenger.getDefault().unregister(this);
        b();
    }

    public void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_CLOSE_WEEK_DIALOG, new Action0() { // from class: com.disabngo.blockynexus.view.dialog.j.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11610a.dismiss();
            }
        });
    }

    public void initView() {
        this.f11619b = (Pc) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_week_sign, (ViewGroup) null, false);
        this.f11619b.a(new l(this.context, this, this.f11618a));
        setContentView(this.f11619b.getRoot());
        this.f11620c = (AnimationDrawable) ((ImageView) findViewById(R.id.iv_point)).getBackground();
        a();
        initMessenger();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        ReportDataAdapter.onEvent(this.context, EventConstant.SIGN_IN_CLOSE, "back");
        b();
    }
}

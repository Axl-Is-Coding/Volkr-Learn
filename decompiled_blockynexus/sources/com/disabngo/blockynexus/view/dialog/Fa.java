package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0686pc;
import com.sandboxol.center.view.dialog.ScrapRewardDescriptionDialog;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.imchat.message.entity.ScrapHelpMessage;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScrapReceiveDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Fa extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RotateAnimation f11288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f11289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScrapHelpMessage f11290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f11292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f11293f;

    /* JADX INFO: compiled from: ScrapReceiveDialog.java */
    public interface a {
        void a();

        void b();
    }

    public Fa(Context context, ScrapHelpMessage scrapHelpMessage, a aVar) {
        super(context);
        this.f11291d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.G
            @Override // rx.functions.Action0
            public final void call() {
                this.f11306a.a();
            }
        });
        this.f11292e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.H
            @Override // rx.functions.Action0
            public final void call() {
                this.f11308a.b();
            }
        });
        this.f11293f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.I
            @Override // rx.functions.Action0
            public final void call() {
                this.f11310a.c();
            }
        });
        this.f11290c = scrapHelpMessage;
        this.f11289b = aVar;
        initView();
    }

    private void animRotate(View view) {
        this.f11288a = new RotateAnimation(WheelView.DividerConfig.FILL, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f11288a.setDuration(5000L);
        this.f11288a.setRepeatCount(-1);
        this.f11288a.setInterpolator(new LinearInterpolator());
        view.startAnimation(this.f11288a);
    }

    public /* synthetic */ void a() {
        a aVar = this.f11289b;
        if (aVar != null) {
            aVar.a();
        }
        dismiss();
    }

    public /* synthetic */ void b() {
        a aVar = this.f11289b;
        if (aVar != null) {
            aVar.b();
        }
        dismiss();
    }

    public /* synthetic */ void c() {
        ScrapHelpMessage scrapHelpMessage = this.f11290c;
        if (scrapHelpMessage != null) {
            new ScrapRewardDescriptionDialog(this.context, scrapHelpMessage.getScrapName(), this.f11290c.getScrapDesc(), this.f11290c.getScrapValue(), true).show();
        }
    }

    public void initView() {
        AbstractC0686pc abstractC0686pc = (AbstractC0686pc) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_scrap_receive, (ViewGroup) null, false);
        abstractC0686pc.a(this);
        setContentView(abstractC0686pc.getRoot());
        animRotate(abstractC0686pc.f8682c);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        RotateAnimation rotateAnimation = this.f11288a;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.f11288a = null;
        }
        super.onDetachedFromWindow();
    }
}

package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.databinding.ObservableField;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0773xc;
import com.sandboxol.center.entity.ScrapRewardComposeInfo;
import com.sandboxol.center.entity.ScrapRewardDetails;
import com.sandboxol.center.view.dialog.ScrapRewardDescriptionDialog;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScrapRewardReceiveDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Qa extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScrapRewardDetails f11350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScrapRewardComposeInfo f11351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f11352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RotateAnimation f11353f;
    public ObservableField<Boolean> g;
    public ObservableField<String> h;
    public ObservableField<String> i;
    public ReplyCommand j;
    public ReplyCommand k;
    public ReplyCommand l;

    /* JADX INFO: compiled from: ScrapRewardReceiveDialog.java */
    public interface a {
        void a();

        void a(String str);
    }

    public Qa(Context context, ScrapRewardDetails scrapRewardDetails, ScrapRewardComposeInfo scrapRewardComposeInfo, int i, int i2, a aVar) {
        super(context);
        this.g = new ObservableField<>();
        this.h = new ObservableField<>();
        this.i = new ObservableField<>();
        this.j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.W
            @Override // rx.functions.Action0
            public final void call() {
                this.f11437a.a();
            }
        });
        this.k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.V
            @Override // rx.functions.Action0
            public final void call() {
                this.f11432a.b();
            }
        });
        this.l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.X
            @Override // rx.functions.Action0
            public final void call() {
                this.f11439a.c();
            }
        });
        this.f11350c = scrapRewardDetails;
        this.f11348a = i2;
        this.f11352e = aVar;
        this.f11351d = scrapRewardComposeInfo;
        this.f11349b = i;
        initView();
        initData();
    }

    private void animRotate(View view) {
        this.f11353f = new RotateAnimation(WheelView.DividerConfig.FILL, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f11353f.setDuration(5000L);
        this.f11353f.setRepeatCount(-1);
        this.f11353f.setInterpolator(new LinearInterpolator());
        view.startAnimation(this.f11353f);
    }

    private void initData() {
        ScrapRewardDetails scrapRewardDetails = this.f11350c;
        if (scrapRewardDetails == null || this.f11351d == null) {
            return;
        }
        boolean z = true;
        if (this.f11349b == 1) {
            this.h.set(scrapRewardDetails.getCardName());
        } else {
            this.h.set(this.f11350c.getCardName() + "x" + this.f11349b);
        }
        if (this.f11351d.getExpire() != 0) {
            this.i.set(this.context.getString(R.string.app_scrap_remind_time_tips) + com.disabngo.blockynexus.d.J.a(this.f11351d.getExpire()));
        }
        ObservableField<Boolean> observableField = this.g;
        if (this.f11351d.getRewardType() != 2 && this.f11351d.getRewardType() != 4) {
            z = false;
        }
        observableField.set(Boolean.valueOf(z));
    }

    public /* synthetic */ void a() {
        a aVar = this.f11352e;
        if (aVar != null) {
            aVar.a();
        }
        dismiss();
    }

    public /* synthetic */ void b() {
        ScrapRewardComposeInfo scrapRewardComposeInfo;
        if (this.f11352e != null && (scrapRewardComposeInfo = this.f11351d) != null && scrapRewardComposeInfo.getGameId() != null) {
            this.f11352e.a(this.f11351d.getGameId());
        }
        dismiss();
    }

    public /* synthetic */ void c() {
        ScrapRewardDetails scrapRewardDetails = this.f11350c;
        if (scrapRewardDetails != null) {
            new ScrapRewardDescriptionDialog(this.context, scrapRewardDetails.getCardName(), this.f11350c.getCardDesc(), this.f11350c.getCardValue(), false).show();
        }
    }

    public void initView() {
        AbstractC0773xc abstractC0773xc = (AbstractC0773xc) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_scrap_reward_receive, (ViewGroup) null, false);
        abstractC0773xc.a(this);
        setContentView(abstractC0773xc.getRoot());
        animRotate(abstractC0773xc.f8964d);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar = this.f11352e;
        if (aVar != null) {
            aVar.a();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        RotateAnimation rotateAnimation = this.f11353f;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.f11353f = null;
        }
        super.onDetachedFromWindow();
    }
}

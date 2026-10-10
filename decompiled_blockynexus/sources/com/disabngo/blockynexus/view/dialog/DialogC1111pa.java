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
import com.disabngo.blockynexus.interfaces.OnViewClickListener;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.pa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AdsRewardDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class DialogC1111pa extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DailySignInfo f11650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.disabngo.blockynexus.databinding.Va f11651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f11652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f11654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f11655f;
    private OnViewClickListener g;

    public DialogC1111pa(Context context, DailySignInfo dailySignInfo) {
        super(context);
        this.f11652c = new ObservableField<>(false);
        this.f11653d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11522a.onConfirm();
            }
        });
        this.f11654e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11446a.a();
            }
        });
        this.f11655f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11522a.onConfirm();
            }
        });
        this.f11650a = dailySignInfo;
        initView();
        animRotate(this.f11651b.f7951a);
        initData();
    }

    private void animRotate(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(WheelView.DividerConfig.FILL, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(5000L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(rotateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfirm() {
        OnViewClickListener onViewClickListener = this.g;
        if (onViewClickListener != null) {
            onViewClickListener.onClick();
        }
        if (isShowing()) {
            cancel();
        }
    }

    public DialogC1111pa a(OnViewClickListener onViewClickListener) {
        this.g = onViewClickListener;
        return this;
    }

    public void initData() {
        this.f11652c.set(true);
    }

    protected void initView() {
        this.f11651b = (com.disabngo.blockynexus.databinding.Va) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_ads_reward, (ViewGroup) null, false);
        this.f11651b.a(this);
        setContentView(this.f11651b.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f11650a.getAdQuantity() <= 0 || !AdsManager.isVideoLoaded()) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.ads_is_loading);
            return;
        }
        AdsManager.showRewardVideo(1);
        if (isShowing()) {
            dismiss();
        }
    }
}

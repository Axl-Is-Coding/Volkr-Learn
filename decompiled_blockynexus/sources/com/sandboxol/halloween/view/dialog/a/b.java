package com.sandboxol.halloween.view.dialog.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.databinding.ObservableField;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.entity.RewardDetailInfo;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: HalloweenRewardDialog.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f18676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f18677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RotateAnimation f18678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f18679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f18680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f18681f;

    public b(Context context, List<RewardDetailInfo> list) {
        super(context);
        this.f18677b = new d();
        this.f18679d = new ObservableField<>();
        this.f18680e = new ObservableField<>();
        this.f18681f = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.dialog.a.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18675a.dismiss();
            }
        });
        initView();
        this.f18676a = new e(context, R.string.no_data, list);
    }

    private void animRotate(View view) {
        this.f18678c = new RotateAnimation(WheelView.DividerConfig.FILL, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f18678c.setDuration(5000L);
        this.f18678c.setRepeatCount(-1);
        this.f18678c.setInterpolator(new LinearInterpolator());
        view.startAnimation(this.f18678c);
    }

    private void initView() {
        com.sandboxol.halloween.b.c cVar = (com.sandboxol.halloween.b.c) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.halloween_dialog_reward, (ViewGroup) null, false);
        cVar.a(this);
        setContentView(cVar.getRoot());
        animRotate(cVar.f18590b);
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f18678c.cancel();
        super.dismiss();
    }
}

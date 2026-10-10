package com.disabngo.blockynexus.e.b.ua;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import java.util.Timer;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeTaskPageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<Long> f10233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f10234c;
    private Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f10235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f10236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Integer> f10237f;
    public ObservableField<Integer> g;
    public ObservableField<Boolean> h;
    public ObservableField<String> i;
    public ReplyCommand j;

    public r(Context context, int i, ObservableField<String> observableField) {
        super(context, Integer.valueOf(i));
        this.f10233b = new ObservableField<>(0L);
        this.f10235d = new i();
        this.f10236e = new ObservableField<>();
        this.f10237f = new ObservableField<>();
        this.g = new ObservableField<>(180);
        this.h = new ObservableField<>(false);
        this.i = new ObservableField<>("round");
        this.j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ua.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f10203a.f();
            }
        });
        this.context = context;
        this.f10232a = i;
        if (i == 0) {
            this.f10234c = new p(context, R.string.tribe_no_task, i, this.g, this.h, this.f10236e, this.f10237f, this.f10233b);
        } else {
            this.f10234c = new p(context, R.string.tribe_no_task, i, this.g, this.h, this.f10236e, this.f10237f, null);
        }
        initMessenger();
        a(context, i, observableField);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this.context, MessageToken.TOKEN_TRIBE_TASK, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.ua.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10204a.a((Integer) obj);
            }
        });
    }

    public /* synthetic */ void f() {
        if (this.f10232a == 0 && TribeCenter.newInstance().tribeRole.get().intValue() == 0) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.tribe_not_elder);
        } else {
            this.f10234c.a(1);
            Messenger.getDefault().send(RefreshMsg.create(), this.f10234c.getRefreshToken());
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public /* synthetic */ void a(Integer num) {
        this.f10234c.a(0);
        if (num.intValue() == this.f10232a) {
            Messenger.getDefault().send(RefreshMsg.create(), this.f10234c.getRefreshToken());
        }
    }

    private void a(Context context, int i, ObservableField<String> observableField) {
        new Timer().schedule(new q(this, i, observableField, context), 1000L, 1000L);
    }
}

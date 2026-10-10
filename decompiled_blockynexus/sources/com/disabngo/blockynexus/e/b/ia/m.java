package com.disabngo.blockynexus.e.b.ia;

import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0721sf;
import com.disabngo.blockynexus.e.b.a.C0812a;
import com.disabngo.blockynexus.e.b.b.C0819f;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.TemplateNewUtils;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: SettingViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f9836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f9837b = new ObservableField<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f9838c = new ObservableField<>("0");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f9839d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f9840e = new ObservableField<>(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9841f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ia.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f9832a.f();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ia.j
        @Override // rx.functions.Action0
        public final void call() {
            this.f9834a.h();
        }
    });
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ia.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9826a.i();
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ia.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f9833a.j();
        }
    });
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ia.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9825a.k();
        }
    });
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ia.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f9830a.p();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ia.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f9831a.u();
        }
    });

    public m(Activity activity, AbstractC0721sf abstractC0721sf) {
        this.f9836a = activity;
        initMessenger();
        l();
        abstractC0721sf.f8798b.setLeftText(activity.getString(R.string.item_view_about, new Object[]{activity.getString(R.string.appName)}));
        m();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_CACHE_REFRESH, new Action0() { // from class: com.disabngo.blockynexus.e.b.ia.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f9827a.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Observable.just(m.class).flatMap(new Func1() { // from class: com.disabngo.blockynexus.e.b.ia.d
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return this.f9828a.a((Class) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new l(this));
    }

    private void m() {
        this.f9840e.set(Boolean.valueOf(SharedUtils.getBoolean((Context) this.f9836a, SharedConstant.IS_CLICK_DISK_SPACE_MANAGE, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        new RxPermissions2((FragmentActivity) this.f9836a).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.e.b.ia.e
            @Override // io.reactivex.b.g
            public final void accept(Object obj) throws Exception {
                this.f9829a.a((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        LoginManager.onSwitchAccount(this.f9836a);
        ReportDataAdapter.onEvent(this.f9836a, EventConstant.CLICK_SWITCH_ACC);
    }

    public /* synthetic */ Observable a(Class cls) {
        return Observable.just(b.h.b.a.g.b(this.f9836a, 0, BaseApplication.getApp().getMetaDataRootPath()));
    }

    public /* synthetic */ void f() {
        Activity activity = this.f9836a;
        TemplateUtils.startTemplate(activity, C0819f.class, activity.getString(R.string.item_view_account_safe));
    }

    public /* synthetic */ void h() {
        Activity activity = this.f9836a;
        TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.Y.f.class, activity.getString(R.string.item_view_reminder));
    }

    public /* synthetic */ void i() {
        Activity activity = this.f9836a;
        TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.V.a.class, activity.getString(R.string.item_view_question));
    }

    public /* synthetic */ void j() {
        new bc().a((Context) this.f9836a, true, false);
    }

    public /* synthetic */ void k() {
        Activity activity = this.f9836a;
        TemplateUtils.startTemplate(activity, C0812a.class, activity.getString(R.string.item_view_about, new Object[]{activity.getString(R.string.appName)}));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public /* synthetic */ void a(Boolean bool) throws Exception {
        if (!bool.booleanValue()) {
            AppToastUtils.showShortNegativeTipToast(this.f9836a, R.string.please_set_write_read_jurisdiction);
            return;
        }
        Activity activity = this.f9836a;
        TemplateNewUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.r.k.class, activity.getString(R.string.app_disk_space_management));
        SharedUtils.putBoolean(this.f9836a, SharedConstant.IS_CLICK_DISK_SPACE_MANAGE, false);
        this.f9840e.set(false);
    }
}

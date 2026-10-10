package com.disabngo.blockynexus.view.activity.searchfriend;

import android.app.Activity;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: SearchFriendViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f11089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f11090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f11091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f11092d = new m();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f11093e = new ObservableField<>("");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f11094f = new ObservableField<>(true);
    public ObservableField<Boolean> g = new ObservableField<>(false);
    public ReplyCommand h = new ReplyCommand(new Action1() { // from class: com.disabngo.blockynexus.view.activity.searchfriend.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11067a.a(obj);
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.searchfriend.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f11066a.f();
        }
    });
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.searchfriend.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f11064a.h();
        }
    });
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.searchfriend.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f11065a.i();
        }
    });

    public q(Activity activity, boolean z) {
        this.f11089a = activity;
        this.f11091c = new p(activity, R.string.searchNoFound, this.f11093e.get(), this.f11094f, z);
        this.f11090b = new s(activity, R.string.friend_search_empty_list, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Messenger.getDefault().send(RefreshMsg.create(), this.f11090b.getRefreshToken());
        ReportDataAdapter.onEvent(this.f11089a, EventConstant.CLICK_CHANGE);
    }

    public /* synthetic */ void a(Object obj) {
        this.f11093e.set(String.valueOf(obj));
        if (obj.toString().length() == 0) {
            this.g.set(false);
        }
    }

    public /* synthetic */ void f() {
        this.f11089a.finish();
    }

    public /* synthetic */ void h() {
        a(this.f11093e.get());
    }

    private void a(String str) {
        if (this.f11094f.get().booleanValue()) {
            this.f11094f.set(false);
            this.g.set(true);
            this.f11091c.a(str);
            ReportDataAdapter.onEvent(this.f11089a, EventConstant.CHAT_CLICK_SEARCH);
            SandboxReportManager.onEvent(ReportEvent.NEW_CHAT_SEARCH, ReportEventType.NEW_USER_BEHAVIOR, "app");
        }
    }
}

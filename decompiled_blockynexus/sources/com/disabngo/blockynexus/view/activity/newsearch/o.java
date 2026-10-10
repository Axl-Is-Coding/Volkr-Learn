package com.disabngo.blockynexus.view.activity.newsearch;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0694q;
import com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.LocalDataRequest;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: SearchFriendViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f11019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AbstractC0694q f11020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f11021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SearchFriendPopupWindow f11022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SearchFriendPopupWindow f11023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f11024f;
    private Map<String, String> g;
    private List<String> h;
    private Map<String, Map<String, String>> i;
    public ObservableField<String> j = new ObservableField<>("");
    public ObservableField<String> k = new ObservableField<>("");
    public ObservableField<Integer> l = new ObservableField<>(0);
    public ObservableField<String> m = new ObservableField<>("");
    public ObservableField<Boolean> n = new ObservableField<>(false);
    public ObservableField<String> o = new ObservableField<>();
    public ObservableField<String> p = new ObservableField<>();
    public ObservableField<String> q = new ObservableField<>();
    public ObservableField<Boolean> r = new ObservableField<>(true);
    public ObservableField<Boolean> s = new ObservableField<>(true);
    public ObservableField<Boolean> t = new ObservableField<>(false);
    public ReplyCommand<Boolean> u = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.newsearch.h
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11008a.a((Boolean) obj);
        }
    });
    public ReplyCommand<Boolean> v = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.newsearch.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11005a.b((Boolean) obj);
        }
    });
    public ReplyCommand w = new ReplyCommand(new Action1() { // from class: com.disabngo.blockynexus.view.activity.newsearch.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11006a.a(obj);
        }
    });
    public ReplyCommand x = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.newsearch.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f11009a.f();
        }
    });
    public ReplyCommand y = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.newsearch.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f11007a.h();
        }
    });
    public ReplyCommand z = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.newsearch.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f11003a.m();
        }
    });
    public ReplyCommand A = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.newsearch.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f11002a.i();
        }
    });
    public ReplyCommand B = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.newsearch.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f11004a.j();
        }
    });

    public o(Activity activity, AbstractC0694q abstractC0694q, boolean z) {
        this.f11019a = activity;
        this.f11020b = abstractC0694q;
        a(z);
    }

    private Integer k() {
        if (this.r.get().booleanValue() && this.s.get().booleanValue()) {
            return 0;
        }
        if (this.r.get().booleanValue()) {
            return 1;
        }
        return this.s.get().booleanValue() ? 2 : 0;
    }

    private void l() {
        this.o.set(this.f11019a.getString(R.string.app_search_friend_language));
        this.p.set(this.f11019a.getString(R.string.app_search_friend_like_play));
        this.q.set(this.f11019a.getString(R.string.search_friend_recommend));
        this.j.set("");
        this.r.set(true);
        this.s.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        l();
        this.t.set(true);
        this.f11021c.a(this.t);
        this.q.set(this.f11019a.getString(R.string.search_friend_recommend));
        ReportDataAdapter.onEvent(this.f11019a, EventConstant.CLICK_CHANGE);
    }

    public /* synthetic */ void f() {
        this.f11019a.finish();
    }

    public /* synthetic */ void h() {
        if (TextUtils.isEmpty(this.j.get())) {
            AppToastUtils.showShortNegativeTipToast(this.f11019a, R.string.dialog_recharge_input_et_not_empty);
        } else {
            a(6, 5);
            this.q.set(this.f11019a.getString(R.string.app_search_friend_search_result));
        }
    }

    public /* synthetic */ void i() {
        c(1);
    }

    public /* synthetic */ void j() {
        c(2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void c(int i) {
        if (i != 1) {
            if (this.f11023e == null && this.i.size() != 0) {
                this.h = new ArrayList(n.a(this.i).values());
                this.f11023e = new SearchFriendPopupWindow(this.f11019a, this.h, 2);
            }
            if (this.f11023e.isShowing()) {
                this.f11023e.dismiss();
                return;
            }
            SearchFriendPopupWindow searchFriendPopupWindow = this.f11023e;
            LinearLayout linearLayout = this.f11020b.f8711c;
            searchFriendPopupWindow.showLocation(linearLayout, linearLayout.getWidth());
            this.f11023e.setOnMoreItemClickListener(new SearchFriendPopupWindow.OnMoreItemClickListener() { // from class: com.disabngo.blockynexus.view.activity.newsearch.SearchFriendViewModel$2
                @Override // com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow.OnMoreItemClickListener
                public void a() {
                }

                @Override // com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow.OnMoreItemClickListener
                public void onClick(int i2, long j) {
                    o oVar = this.f11000a;
                    oVar.p.set((String) oVar.h.get(i2));
                    ObservableField<String> observableField = this.f11000a.p;
                    if (observableField == null || !observableField.get().equals(this.f11000a.f11019a.getString(R.string.app_update_user_all_game))) {
                        o oVar2 = this.f11000a;
                        oVar2.p.set((String) oVar2.h.get(i2));
                        o oVar3 = this.f11000a;
                        oVar3.m.set(n.a((Map<String, Map<String, String>>) oVar3.i, (String) this.f11000a.h.get(i2)));
                    } else {
                        o oVar4 = this.f11000a;
                        oVar4.p.set(oVar4.f11019a.getString(R.string.app_search_friend_like_play));
                        this.f11000a.m.set(null);
                    }
                    this.f11000a.a(5, 4);
                    o oVar5 = this.f11000a;
                    oVar5.q.set(oVar5.f11019a.getString(R.string.app_search_friend_switch_result));
                }
            });
            return;
        }
        if (this.f11022d == null && this.g.size() != 0) {
            n nVar = new n();
            Map<String, String> map = this.g;
            nVar.b(map);
            this.g = map;
            this.f11024f = new ArrayList(this.g.values());
            this.f11022d = new SearchFriendPopupWindow(this.f11019a, this.f11024f, 1);
        }
        if (this.f11022d.isShowing()) {
            this.f11022d.dismiss();
            return;
        }
        SearchFriendPopupWindow searchFriendPopupWindow2 = this.f11022d;
        LinearLayout linearLayout2 = this.f11020b.f8712d;
        searchFriendPopupWindow2.showLocation(linearLayout2, linearLayout2.getWidth());
        this.f11022d.setOnMoreItemClickListener(new SearchFriendPopupWindow.OnMoreItemClickListener() { // from class: com.disabngo.blockynexus.view.activity.newsearch.SearchFriendViewModel$1
            @Override // com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow.OnMoreItemClickListener
            public void a() {
            }

            @Override // com.disabngo.blockynexus.view.dialog.SearchFriendPopupWindow.OnMoreItemClickListener
            public void onClick(int i2, long j) {
                o oVar = this.f10999a;
                oVar.o.set((String) oVar.f11024f.get(i2));
                ObservableField<String> observableField = this.f10999a.o;
                if (observableField == null || !observableField.get().equals(this.f10999a.f11019a.getString(R.string.app_update_user_all_language))) {
                    o oVar2 = this.f10999a;
                    oVar2.o.set((String) oVar2.f11024f.get(i2));
                    o oVar3 = this.f10999a;
                    oVar3.k.set(n.b(oVar3.g, (String) this.f10999a.f11024f.get(i2)));
                } else {
                    o oVar4 = this.f10999a;
                    oVar4.o.set(oVar4.f11019a.getString(R.string.app_search_friend_language));
                    this.f10999a.k.set(null);
                }
                this.f10999a.a(5, 3);
                o oVar5 = this.f10999a;
                oVar5.q.set(oVar5.f11019a.getString(R.string.app_search_friend_switch_result));
            }
        });
    }

    public /* synthetic */ void b(Boolean bool) {
        if (this.n.get().booleanValue()) {
            this.s.set(bool);
            a(5, 2);
            this.q.set(this.f11019a.getString(R.string.app_search_friend_switch_result));
        }
    }

    public /* synthetic */ void a(Boolean bool) {
        if (this.n.get().booleanValue()) {
            this.r.set(bool);
            a(5, 1);
            this.q.set(this.f11019a.getString(R.string.app_search_friend_switch_result));
        }
    }

    private void b(int i) {
        if (i == 1) {
            ReportDataAdapter.onEvent(this.f11019a, EventConstant.CHOSE_FILTER, "Boy");
            return;
        }
        if (i == 2) {
            ReportDataAdapter.onEvent(this.f11019a, EventConstant.CHOSE_FILTER, "Girl");
            return;
        }
        if (i == 3) {
            ReportDataAdapter.onEvent(this.f11019a, EventConstant.CHOSE_FILTER, "Language");
        } else if (i != 4) {
            ReportDataAdapter.onEvent(this.f11019a, EventConstant.CHAT_CLICK_SEARCH);
        } else {
            ReportDataAdapter.onEvent(this.f11019a, EventConstant.CHOSE_FILTER, "Game");
        }
    }

    public /* synthetic */ void a(Object obj) {
        this.j.set(String.valueOf(obj));
        this.f11021c.a(String.valueOf(obj));
    }

    private void a(boolean z) {
        l();
        this.g = LocalDataRequest.getSearchFriendLanguage();
        this.i = LocalDataRequest.getSearchFriendGames();
        this.f11021c = new r(this.f11019a, R.string.app_search_friend_no_search_friend, this.n, this.g, z);
        this.f11020b.f8709a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.disabngo.blockynexus.view.activity.newsearch.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f11001a.a(textView, i, keyEvent);
            }
        });
    }

    public /* synthetic */ boolean a(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        if (TextUtils.isEmpty(this.j.get())) {
            AppToastUtils.showShortNegativeTipToast(this.f11019a, R.string.dialog_recharge_input_et_not_empty);
            return false;
        }
        a(6, 5);
        this.q.set(this.f11019a.getString(R.string.app_search_friend_search_result));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (this.n.get().booleanValue()) {
            this.n.set(false);
            this.f11021c.a(this.k.get(), this.m.get(), k().intValue(), this.j.get(), i, i2);
            b(i2);
            SandboxReportManager.onEvent(ReportEvent.NEW_CHAT_SEARCH, ReportEventType.NEW_USER_BEHAVIOR, "app");
        }
    }
}

package com.disabngo.blockynexus.view.dialog.activity;

import android.app.Activity;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.La;
import com.disabngo.blockynexus.entity.ActivityTaskTitle;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ActivityTaskViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class A extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f11471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<ActivityTaskTitle> f11472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private La f11473c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f11475e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11474d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.activity.k
        @Override // rx.functions.Action0
        public final void call() {
            this.f11489a.f();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x f11476f = new x();
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<u>> g = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.view.dialog.activity.j
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f11488a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });
    public ObservableList<u> h = new ObservableArrayList();
    public ReplyCommand<Integer> i = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.dialog.activity.i
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11487a.b(((Integer) obj).intValue());
        }
    });
    public ObservableField<Integer> j = new ObservableField<>(0);
    private ObservableMap<String, Integer> k = new ObservableArrayMap();

    public A(Activity activity, List<ActivityTaskTitle> list, La la) {
        this.f11471a = activity;
        this.f11472b = list;
        this.f11473c = la;
        initView();
        initData();
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.f11475e != null) {
            this.j.set(Integer.valueOf(i));
            this.f11475e.a(i);
            c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<u> listItemViewModel) {
        gVar.a(294, R.layout.content_activity_task_content_page);
    }

    private void c(int i) {
        DataRecyclerView dataRecyclerView;
        La la = this.f11473c;
        if (la == null || (dataRecyclerView = la.f7637d) == null) {
            return;
        }
        dataRecyclerView.scrollToPosition(i);
    }

    public /* synthetic */ void f() {
        Activity activity = this.f11471a;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f11471a.finish();
    }

    protected void initData() {
        int i = 0;
        for (ActivityTaskTitle activityTaskTitle : this.f11472b) {
            this.k.put(activityTaskTitle.getTitleType(), 0);
            this.h.add(new u(this.f11471a, activityTaskTitle.getContent(), activityTaskTitle.getDateDesc(), activityTaskTitle.getPic(), activityTaskTitle.getTitleType()));
            if (activityTaskTitle.getStatus() == 1) {
                i++;
            }
        }
        Messenger.getDefault().send(Boolean.valueOf(i > 0), MessageToken.TOKEN_ACTIVITY_RED_POINT);
        this.f11475e = new z(this.f11471a, R.string.no_data, this.f11472b, this.j, this.k);
    }

    protected void initMessenger() {
    }

    protected void initView() {
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}

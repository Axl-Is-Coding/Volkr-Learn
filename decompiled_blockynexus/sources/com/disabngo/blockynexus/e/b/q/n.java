package com.disabngo.blockynexus.e.b.q;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.d.C0513j;
import com.disabngo.blockynexus.view.dialog.DialogC1116sa;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: DiskGameManageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10088a;
    public k m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f10089b = new ObservableField<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Long> f10090c = new ObservableField<>(0L);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Long> f10091d = new ObservableField<>(0L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f10092e = new ObservableField<>(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableList<String> f10093f = new ObservableArrayList();
    public ObservableList<GameDiskCacheInfo> g = new ObservableArrayList();
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.q.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f10067a.f();
        }
    });
    public ReplyCommand<Boolean> i = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.q.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10068a.a(((Boolean) obj).booleanValue());
        }
    });
    public ObservableField<Boolean> j = new ObservableField<>(true);
    public ObservableField<Boolean> k = new ObservableField<>(false);
    public C0907h l = new C0907h();
    public ObservableField<Boolean> n = new ObservableField<>(true);
    public ObservableField<Boolean> o = new ObservableField<>(true);

    public n(Context context) {
        this.f10088a = context;
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ObservableList<String> observableList = this.f10093f;
        if (observableList == null || observableList.size() == 0) {
            return;
        }
        ReportDataAdapter.onEvent(this.f10088a, EventConstant.CLEAN_GAME_CLICK);
        this.f10090c.set(0L);
        this.f10091d.set(0L);
        DialogC1116sa dialogC1116sa = new DialogC1116sa(this.f10088a, this.f10090c, this.f10091d, this.f10092e);
        dialogC1116sa.show();
        p.create(new s() { // from class: com.disabngo.blockynexus.e.b.q.b
            @Override // io.reactivex.s
            public final void a(r rVar) throws Exception {
                this.f10066a.a(rVar);
            }
        }).subscribeOn(io.reactivex.f.b.b()).observeOn(io.reactivex.android.b.b.a()).subscribe(new m(this, dialogC1116sa));
    }

    private void initData() {
        this.m = new k(this.f10088a, this.f10093f, this.g, this.n, this.o);
        this.f10093f.addOnListChangedCallback(new l(this));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.k.set(Boolean.valueOf(z));
        if (!z) {
            this.f10093f.clear();
            return;
        }
        ObservableList<GameDiskCacheInfo> observableList = this.g;
        if (observableList == null || observableList.size() <= 0) {
            return;
        }
        for (GameDiskCacheInfo gameDiskCacheInfo : this.g) {
            if (gameDiskCacheInfo != null && !TextUtils.isEmpty(gameDiskCacheInfo.getGameId()) && !this.f10093f.contains(gameDiskCacheInfo.getGameId())) {
                this.f10093f.add(gameDiskCacheInfo.getGameId());
            }
        }
    }

    public /* synthetic */ void a(r rVar) throws Exception {
        ObservableList<GameDiskCacheInfo> observableList;
        ObservableList<String> observableList2 = this.f10093f;
        if (observableList2 != null && observableList2.size() > 0 && (observableList = this.g) != null && observableList.size() > 0) {
            try {
                this.f10092e.set(false);
                long jCurrentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                for (GameDiskCacheInfo gameDiskCacheInfo : this.g) {
                    if (gameDiskCacheInfo != null && !TextUtils.isEmpty(gameDiskCacheInfo.getGameId()) && this.f10093f.contains(gameDiskCacheInfo.getGameId())) {
                        arrayList.add(gameDiskCacheInfo);
                        this.f10090c.set(Long.valueOf(this.f10090c.get().longValue() + gameDiskCacheInfo.getDiskSpaceSize()));
                    }
                }
                this.f10091d.set(this.f10090c.get());
                final Iterator it = arrayList.iterator();
                int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
                ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iAvailableProcessors);
                for (int i = 0; i < iAvailableProcessors; i++) {
                    executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.disabngo.blockynexus.e.b.q.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f10069a.a(it);
                        }
                    });
                }
                executorServiceNewFixedThreadPool.shutdown();
                while (!executorServiceNewFixedThreadPool.isTerminated()) {
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                com.apkfuns.logutils.c.a("clean").d("clean end ----------------------------------: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        rVar.onComplete();
    }

    public /* synthetic */ void a(Iterator it) {
        while (it.hasNext()) {
            try {
                C0513j.a(this.f10088a, (GameDiskCacheInfo) it.next(), this.f10091d);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

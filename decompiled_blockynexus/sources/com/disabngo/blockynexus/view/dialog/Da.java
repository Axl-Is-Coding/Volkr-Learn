package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Mb;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.greendao.entity.Friend;
import java.text.DecimalFormat;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: MapFriendInfoDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Da extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Friend f11275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f11276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f11277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f11278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f11279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f11280f;
    public ObservableField<String> g;
    public ObservableField<Boolean> h;
    public ReplyCommand i;
    public ReplyCommand j;
    public ReplyCommand k;
    public ReplyCommand l;

    public Da(Context context, Friend friend, double d2, boolean z) {
        super(context);
        this.f11277c = new ObservableField<>(false);
        this.f11278d = new ObservableField<>(false);
        this.f11279e = new ObservableField<>("");
        this.f11280f = new ObservableField<>("");
        this.g = new ObservableField<>("");
        this.h = new ObservableField<>(false);
        this.i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.z
            @Override // rx.functions.Action0
            public final void call() {
                this.f11716a.b();
            }
        });
        this.j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.y
            @Override // rx.functions.Action0
            public final void call() {
                this.f11714a.d();
            }
        });
        this.k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.B
            @Override // rx.functions.Action0
            public final void call() {
                this.f11261a.c();
            }
        });
        this.l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.ma
            @Override // rx.functions.Action0
            public final void call() {
                this.f11642a.cancel();
            }
        });
        this.f11275a = friend;
        this.f11276b = d2;
        this.f11277c.set(Boolean.valueOf(z));
        initView();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f11278d.get().booleanValue()) {
            return;
        }
        if (this.f11277c.get().booleanValue()) {
            this.f11277c.set(false);
            this.f11278d.set(true);
        }
        Friend friend = this.f11275a;
        if (friend != null) {
            com.disabngo.blockynexus.e.b.x.J.a(this.context, friend, new FriendActivityIntentInfo(friend.getUserId(), 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f11278d.get().booleanValue()) {
            return;
        }
        if (this.f11277c.get().booleanValue()) {
            this.f11277c.set(false);
            this.f11278d.set(true);
        }
        if (!this.h.get().booleanValue()) {
            this.h.set(true);
            ReportDataAdapter.onEvent(this.context, EventConstant.FIND_CLICK_FELLIPSIS);
        } else {
            Friend friend = this.f11275a;
            if (friend != null) {
                com.disabngo.blockynexus.e.b.x.J.a(this.context, friend, new FriendActivityIntentInfo(friend.getUserId(), 2));
            }
            ReportDataAdapter.onEvent(this.context, EventConstant.FIND_CLICK_SELLIPSIS);
        }
    }

    public void initData() {
        this.f11279e.set(this.context.getString(R.string.friend_km, new DecimalFormat("#0.00").format(this.f11276b)));
        this.f11280f.set(a(this.f11276b) + a());
        a(new OnDataListener() { // from class: com.disabngo.blockynexus.view.dialog.A
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                this.f11254a.a((List) obj);
            }
        });
        ReportDataAdapter.onEvent(this.context, EventConstant.FIND_USERINFO_SUC);
    }

    protected void initView() {
        Mb mb = (Mb) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_map_friend, (ViewGroup) null, false);
        mb.a(this);
        setContentView(mb.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.f11277c.get().booleanValue()) {
            this.f11278d.set(false);
            new DialogC1114ra(this.context, this.f11275a.getUserId(), a(this.f11276b, null)).show();
        }
        ReportDataAdapter.onEvent(this.context, EventConstant.FIND_CLICK_ADDFIREND);
    }

    public /* synthetic */ void a(List list) {
        this.g.set(b((List<String>) list));
    }

    private String a(double d2) {
        if (d2 < 25.0d) {
            if (this.f11275a.getSex() == 1) {
                Context context = this.context;
                return context.getString(R.string.friend_region_1, context.getString(R.string.he));
            }
            Context context2 = this.context;
            return context2.getString(R.string.friend_region_1, context2.getString(R.string.she));
        }
        if (d2 < 50.0d) {
            if (this.f11275a.getSex() == 1) {
                Context context3 = this.context;
                return context3.getString(R.string.friend_region_2, context3.getString(R.string.he));
            }
            Context context4 = this.context;
            return context4.getString(R.string.friend_region_2, context4.getString(R.string.she));
        }
        if (d2 < 200.0d) {
            return this.context.getString(R.string.friend_region_3);
        }
        if (d2 < 1500.0d) {
            return this.context.getString(R.string.friend_region_4);
        }
        return this.context.getString(R.string.friend_region_5);
    }

    private String b(List<String> list) {
        if (list != null) {
            int size = list.size();
            if (size == 0) {
                return this.context.getString(R.string.friend_game_6);
            }
            if (size == 1) {
                return this.context.getString(R.string.friend_game_5, list.get(0));
            }
            if (size == 2) {
                return this.context.getString(R.string.friend_game_4, list.get(0), list.get(1));
            }
            if (size == 3) {
                return this.context.getString(R.string.friend_game_3, list.get(0), list.get(1), list.get(2));
            }
            if (size == 4) {
                return this.context.getString(R.string.friend_game_2);
            }
            if (size != 5) {
                return this.context.getString(R.string.friend_game_6);
            }
            return this.context.getString(R.string.friend_game_1);
        }
        return this.context.getString(R.string.friend_game_6);
    }

    private String a() {
        return (TextUtils.isEmpty(this.f11275a.getLanguage()) || !this.f11275a.getLanguage().equals(CommonHelper.getUserLanguage())) ? "" : this.context.getString(R.string.friend_language, CommonHelper.getLanguageDetail(this.f11275a.getLanguage()));
    }

    private String a(double d2, List<String> list) {
        String string;
        if (d2 < 25.0d) {
            string = this.context.getString(R.string.friend_apply_region_1);
        } else if (d2 < 50.0d) {
            string = this.context.getString(R.string.friend_apply_region_2);
        } else if (d2 < 200.0d) {
            string = this.context.getString(R.string.friend_apply_region_3);
        } else if (d2 < 1500.0d) {
            string = this.context.getString(R.string.friend_apply_region_4);
        } else {
            string = this.context.getString(R.string.friend_apply_region_5);
        }
        return string + ((list == null || list.isEmpty()) ? "" : this.context.getString(R.string.friend_apply_game, list.get(0)));
    }

    private void a(OnDataListener<List<String>> onDataListener) {
        UserApi.getUserLikeGameList(this.context, new Ca(this, onDataListener));
    }
}

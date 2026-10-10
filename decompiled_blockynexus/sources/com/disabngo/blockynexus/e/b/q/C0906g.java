package com.disabngo.blockynexus.e.b.q;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.q.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiskGameManageItemModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0906g extends ListItemViewModel<GameDiskCacheInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableList<String> f10071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f10072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f10073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand<Boolean> f10074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f10075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f10076f;

    public C0906g(Context context, GameDiskCacheInfo gameDiskCacheInfo, ObservableList<String> observableList) {
        super(context, gameDiskCacheInfo);
        this.f10072b = new ObservableField<>(false);
        this.f10073c = new ObservableField<>("");
        this.f10074d = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.q.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10065a.a(((Boolean) obj).booleanValue());
            }
        });
        this.f10075e = 1296000000;
        this.f10076f = 86400000;
        this.f10071a = observableList;
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(boolean z) {
        this.f10072b.set(Boolean.valueOf(z));
        T t = this.item;
        if (t == 0 || TextUtils.isEmpty(((GameDiskCacheInfo) t).getGameId())) {
            return;
        }
        if (!this.f10072b.get().booleanValue()) {
            this.f10071a.remove(((GameDiskCacheInfo) this.item).getGameId());
        } else {
            if (this.f10071a.contains(((GameDiskCacheInfo) this.item).getGameId())) {
                return;
            }
            this.f10071a.add(((GameDiskCacheInfo) this.item).getGameId());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (((GameDiskCacheInfo) this.item).getLastOpenedTime() == 0) {
            this.f10073c.set(this.context.getString(R.string.app_disk_game_last_time_unknown));
            return;
        }
        if (jCurrentTimeMillis - ((GameDiskCacheInfo) this.item).getLastOpenedTime() > 1296000000) {
            this.f10073c.set(this.context.getString(R.string.app_disk_game_last_time_upper_15_days, 15));
        } else if (jCurrentTimeMillis - ((GameDiskCacheInfo) this.item).getLastOpenedTime() < 86400000) {
            this.f10073c.set(this.context.getString(R.string.app_disk_game_last_time_less_1_day, 1));
        } else {
            this.f10073c.set(this.context.getString(R.string.app_disk_game_last_time_1_to_15_days, Long.valueOf((jCurrentTimeMillis - ((GameDiskCacheInfo) this.item).getLastOpenedTime()) / 86400000)));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GameDiskCacheInfo getItem() {
        return (GameDiskCacheInfo) super.getItem();
    }
}

package com.disabngo.blockynexus.view.activity.friends;

import android.content.Context;
import androidx.databinding.ObservableMap;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: FriendGoodsItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class G extends ListItemViewModel<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f10640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableMap<Long, String> f10641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableMap<Long, String> f10642c;

    public G(Context context, SingleDressInfo singleDressInfo, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2) {
        super(context, singleDressInfo);
        this.f10640a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.friends.v
            @Override // rx.functions.Action0
            public final void call() {
                this.f10687a.f();
            }
        });
        if (singleDressInfo.getStatus() == 1) {
            observableMap.put(Long.valueOf(singleDressInfo.getTypeId()), singleDressInfo.getResourceId());
            observableMap2.put(Long.valueOf(singleDressInfo.getTypeId()), singleDressInfo.getIconUrl());
        }
        this.f10641b = observableMap;
        this.f10642c = observableMap2;
    }

    public void f() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public SingleDressInfo getItem() {
        return (SingleDressInfo) super.getItem();
    }
}

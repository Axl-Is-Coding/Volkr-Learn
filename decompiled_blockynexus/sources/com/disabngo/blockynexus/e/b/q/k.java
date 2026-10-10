package com.disabngo.blockynexus.e.b.q;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.greendao.c.fa;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import java.util.List;

/* JADX INFO: compiled from: DiskGameManageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends DataListModel<GameDiskCacheInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableList<String> f10081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableList<GameDiskCacheInfo> f10082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<Boolean> f10083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObservableField<Boolean> f10084d;

    public k(Context context, ObservableList<String> observableList, ObservableList<GameDiskCacheInfo> observableList2, ObservableField<Boolean> observableField, ObservableField<Boolean> observableField2) {
        super(context, R.string.no_data);
        this.f10081a = observableList;
        this.f10082b = observableList2;
        this.f10083c = observableField;
        this.f10084d = observableField2;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_DISK_GAME_MANAGE_LIST;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<GameDiskCacheInfo> listItemViewModel) {
        gVar.a(2, R.layout.item_disk_game_manage);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<GameDiskCacheInfo>> onResponseListener) {
        fa.newInstance().a(new C0909j(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GameDiskCacheInfo> getItemViewModel(GameDiskCacheInfo gameDiskCacheInfo) {
        return new C0906g(this.context, gameDiskCacheInfo, this.f10081a);
    }
}

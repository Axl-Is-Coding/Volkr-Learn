package com.sandboxol.vip.d.a.a;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.vip.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SubscribeBottomListModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class n extends DataListModel<VipProductEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<VipProductEntity> f19062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<VipProductEntity> f19063b;

    public n(Context context, ObservableField<VipProductEntity> observableField) {
        super(context, R.string.no_data);
        this.f19062a = observableField;
    }

    private void a() {
        try {
            List<Integer> vipList = AppInfoCenter.newInstance().getAppConfig().getVipList();
            if (vipList != null && vipList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = vipList.iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    VipProductEntity vipProductEntityA = com.sandboxol.vip.c.a.a(com.sandboxol.vip.c.a.d(iIntValue), iIntValue);
                    if (vipProductEntityA.getLevel() != 0) {
                        arrayList.add(vipProductEntityA);
                    }
                }
                com.google.gson.j jVar = new com.google.gson.j();
                this.f19063b = (List) jVar.a(jVar.a(arrayList), new m(this).getType());
            }
            if (this.f19063b == null || this.f19063b.size() <= 0) {
                return;
            }
            for (int i = 0; i < this.f19063b.size(); i++) {
                if (this.f19063b.get(i) != null && this.f19063b.get(i).getType() != null && !this.f19063b.get(i).getType().equals(this.f19062a.get().getType()) && this.f19063b.get(i).getLevel() == this.f19062a.get().getLevel() && this.f19063b.get(i).getMonth() == this.f19062a.get().getMonth()) {
                    this.f19063b.set(i, this.f19062a.get());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f19063b = new ArrayList();
        }
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return "token.refresh.subscribe.bottom.list";
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<VipProductEntity> listItemViewModel) {
        gVar.a(com.sandboxol.vip.a.f18952b, R.layout.vip_list_item_subscribe_bottom);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<VipProductEntity>> onResponseListener) {
        a();
        onResponseListener.onSuccess(this.f19063b);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<VipProductEntity> getItemViewModel(VipProductEntity vipProductEntity) {
        return new k(this.context, vipProductEntity, this.f19062a);
    }
}

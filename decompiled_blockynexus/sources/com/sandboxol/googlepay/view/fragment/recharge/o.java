package com.sandboxol.googlepay.view.fragment.recharge;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.googlepay.R;
import com.sandboxol.googlepay.entity.RechargeInfo;
import com.sandboxol.vip.entity.VipProductType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: RechargeItem2ListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class o extends DataListModel<RechargeInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<StarCodeUser> f18379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<RechargeInfo> f18380b;

    public o(Context context, ObservableField<StarCodeUser> observableField, int i) {
        super(context, i);
        this.f18380b = new ArrayList();
        this.f18379a = observableField;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<ProductEntity> list) {
        List<RechargeInfo> list2 = this.f18380b;
        if (list2 != null) {
            list2.clear();
        }
        List<VipProductEntity> listB = b();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            RechargeInfo rechargeInfo = new RechargeInfo();
            if (!list.get(i).isFree()) {
                list.get(i).setResourcePic("ic_diamond_" + list.get(i).getId());
            }
            VipProductEntity vipProductEntityA = a(listB, list.get(i).getPrice());
            if (vipProductEntityA != null && !TextUtils.isEmpty(vipProductEntityA.getType()) && VipProductType.SUB.equals(vipProductEntityA.getType())) {
                int level = vipProductEntityA.getLevel();
                if (level == 1) {
                    vipProductEntityA.setResPic("googlepay_ic_vip");
                } else if (level == 2) {
                    vipProductEntityA.setResPic("googlepay_ic_vip_plus");
                } else if (level == 3) {
                    vipProductEntityA.setResPic("googlepay_ic_mvp");
                } else if (level == 4) {
                    vipProductEntityA.setResPic("googlepay_ic_mvp_plus");
                }
                rechargeInfo.setVipProductEntity(vipProductEntityA);
                rechargeInfo.setVip(true);
            }
            rechargeInfo.setFree(list.get(i).isFree());
            rechargeInfo.setProductEntity(list.get(i));
            this.f18380b.add(rechargeInfo);
        }
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getInsertToken() {
        return MessageToken.TOKEN_INSERT_PRODUCT_LIST;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_PRODUCT_LIST;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRemoveToken() {
        return MessageToken.TOKEN_REMOVE_PRODUCT_LIST;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<RechargeInfo> listItemViewModel) {
        if (listItemViewModel.getItem().getVipProductEntity() == null) {
            gVar.a(com.sandboxol.googlepay.a.f18173b, R.layout.item_recharge_2_view);
        } else {
            gVar.a(com.sandboxol.googlepay.a.f18173b, R.layout.googlepay_item_recharge_list_2_view);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<RechargeInfo>> onResponseListener) {
        if (getData().isEmpty()) {
            List<RechargeInfo> listA = a();
            if (!listA.isEmpty()) {
                if (listA.get(0).isFree() && AdsManager.isShowIronAds(this.context, 2, 5)) {
                    listA.remove(0);
                }
                onResponseListener.onSuccess(listA);
            }
        }
        BillingManager.getInstance().productsListAndAdsAndVipList(this.context, new l(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<RechargeInfo> getItemViewModel(RechargeInfo rechargeInfo) {
        return new RechargeItem2ViewModel(this.context, rechargeInfo, this.f18379a);
    }

    private VipProductEntity a(List<VipProductEntity> list, double d2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (VipProductEntity vipProductEntity : list) {
            if (vipProductEntity != null && vipProductEntity.getPrice() == d2) {
                return vipProductEntity;
            }
        }
        return null;
    }

    public void a(List<RechargeInfo> list) {
        SharedUtils.putString(this.context, SharedConstant.BACKUP_DIAMOND_VIP_SUB_INFO, new com.google.gson.j().a(list));
    }

    public List<RechargeInfo> a() {
        String string = SharedUtils.getString(this.context, SharedConstant.BACKUP_DIAMOND_VIP_SUB_INFO, null);
        if (string != null) {
            try {
                return (List) new com.google.gson.j().a(string, new n(this).getType());
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    private List<VipProductEntity> b() {
        List<Integer> vipList = AppInfoCenter.newInstance().getAppConfig().getVipList();
        if (vipList != null && vipList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = vipList.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                VipProductEntity productEntityByVipType = VipManager.getProductEntityByVipType(VipManager.getSubscribeStatus(iIntValue), iIntValue);
                if (productEntityByVipType != null && productEntityByVipType.getLevel() != 0) {
                    arrayList.add(productEntityByVipType);
                }
            }
            try {
                com.google.gson.j jVar = new com.google.gson.j();
                return (List) jVar.a(jVar.a(arrayList), new m(this).getType());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}

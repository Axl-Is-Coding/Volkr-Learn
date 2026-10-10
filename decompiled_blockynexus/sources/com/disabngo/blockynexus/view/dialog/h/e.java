package com.disabngo.blockynexus.view.dialog.h;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: compiled from: ScrapRuleListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends DataListModel<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11594a;

    public e(Context context, int i) {
        super(context, i);
        this.f11594a = "@pic";
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<String> listItemViewModel) {
        if (listItemViewModel != null) {
            String item = listItemViewModel.getItem();
            if (item == null || !item.startsWith("@pic")) {
                gVar.a(2, R.layout.item_scrap_rule_text);
            } else {
                gVar.a(2, R.layout.item_scrap_rule_pic);
            }
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<String>> onResponseListener) {
        ScrapApi.getScrapRule(new d(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<String> getItemViewModel(String str) {
        return new c(this.context, str);
    }
}

package com.sandboxol.center.view.dialog.scrap;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.google.android.material.tabs.TabLayout;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.databinding.BaseDialogScrapBagBinding;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.vm.ViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import me.tatarka.bindingcollectionadapter2.l;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapBagViewModel extends ViewModel {
    private BaseDialogScrapBagBinding binding;
    private Context context;
    private long friendId;
    private boolean isPrivate;
    private OnCloseListener listener;
    private int[] tabsType;
    private final int TAB_COUNT = 5;
    private int[] selectedTabs = {R.mipmap.ic_scrap_bag_tab_all_2, R.mipmap.ic_scrap_bag_tab_game_props_2, R.mipmap.ic_scrap_bag_tab_game_2, R.mipmap.ic_scrap_bag_tab_app_2, R.mipmap.ic_scrap_bag_tab_limit_2};
    private int[] unSelectedTabs = {R.mipmap.ic_scrap_bag_tab_all_1, R.mipmap.ic_scrap_bag_tab_game_props_1, R.mipmap.ic_scrap_bag_tab_game_1, R.mipmap.ic_scrap_bag_tab_app_1, R.mipmap.ic_scrap_bag_tab_limit_1};
    public ObservableField<Boolean> isFromMain = new ObservableField<>(false);
    public ObservableField<Integer> scrapValue = new ObservableField<>(0);
    public ObservableList<ScrapBagPageViewModel> pageItems = new ObservableArrayList();
    public me.tatarka.bindingcollectionadapter2.g<ScrapBagPageViewModel> itemBinding = me.tatarka.bindingcollectionadapter2.g.a(new l() { // from class: com.sandboxol.center.view.dialog.scrap.e
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f16393a.bindView(gVar, i, (ScrapBagPageViewModel) obj);
        }
    });
    public ReplyCommand onCloseCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.scrap.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f16395a.a();
        }
    });

    public interface OnCloseListener {
        void onClose();
    }

    public ScrapBagViewModel(Context context, boolean z, BaseDialogScrapBagBinding baseDialogScrapBagBinding, long j, boolean z2, OnCloseListener onCloseListener) {
        this.context = context;
        this.binding = baseDialogScrapBagBinding;
        this.listener = onCloseListener;
        this.isFromMain.set(Boolean.valueOf(z));
        this.friendId = j;
        this.isPrivate = z2;
        this.tabsType = context.getResources().getIntArray(R.array.scrap_bag_tab_array_type);
        initPageItems();
        this.binding.tlTab.post(new Runnable() { // from class: com.sandboxol.center.view.dialog.scrap.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f16394a.setTabs();
            }
        });
        initScrapBagValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ScrapBagPageViewModel scrapBagPageViewModel) {
        gVar.a(BR.ScrapBagPageViewModel, R.layout.base_content_scrap_bag_page);
    }

    private void initPageItems() {
        for (int i = 0; i < 5; i++) {
            this.pageItems.add(new ScrapBagPageViewModel(this.context, Integer.valueOf(this.tabsType[i]), this.isFromMain, this.friendId, this.isPrivate));
        }
    }

    private void initScrapBagValue() {
        ScrapApi.getScrapBagValue(this.context, new OnResponseListener<Integer>() { // from class: com.sandboxol.center.view.dialog.scrap.ScrapBagViewModel.1
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str) {
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(Integer num) {
                ScrapBagViewModel.this.scrapValue.set(num);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabs() {
        if (this.tabsType.length >= this.binding.tlTab.getTabCount()) {
            for (int i = 0; i < this.binding.tlTab.getTabCount(); i++) {
                TabLayout.f tabAt = this.binding.tlTab.getTabAt(i);
                if (tabAt != null) {
                    tabAt.d(0);
                    tabAt.b(this.unSelectedTabs[i]);
                    if (i == 0) {
                        tabAt.b(this.selectedTabs[i]);
                    }
                }
            }
        }
        this.binding.tlTab.addOnTabSelectedListener(new TabLayout.c() { // from class: com.sandboxol.center.view.dialog.scrap.ScrapBagViewModel.2
            @Override // com.google.android.material.tabs.TabLayout.b
            public void onTabReselected(TabLayout.f fVar) {
            }

            @Override // com.google.android.material.tabs.TabLayout.b
            public void onTabSelected(TabLayout.f fVar) {
                fVar.b(ScrapBagViewModel.this.selectedTabs[fVar.c()]);
            }

            @Override // com.google.android.material.tabs.TabLayout.b
            public void onTabUnselected(TabLayout.f fVar) {
                fVar.b(ScrapBagViewModel.this.unSelectedTabs[fVar.c()]);
            }
        });
    }

    public /* synthetic */ void a() {
        OnCloseListener onCloseListener = this.listener;
        if (onCloseListener != null) {
            onCloseListener.onClose();
        }
    }

    @Override // com.sandboxol.common.base.vm.ViewModel
    public void onResume() {
        super.onResume();
    }
}

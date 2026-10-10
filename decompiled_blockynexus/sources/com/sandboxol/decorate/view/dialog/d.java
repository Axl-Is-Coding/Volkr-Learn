package com.sandboxol.decorate.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.e;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.DressShopGuideConfig;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.SizeUtil;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.c.AbstractC2593s;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import me.tatarka.bindingcollectionadapter2.g;
import me.tatarka.bindingcollectionadapter2.l;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressShopGuideDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, List<DressShopGuideConfig>> f17368a;

    /* JADX INFO: compiled from: DressShopGuideDialog.java */
    public static class a extends ListItemViewModel<DressShopGuideConfig> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DressShopGuideConfig f17369a;

        public a(Context context, DressShopGuideConfig dressShopGuideConfig) {
            super(context, dressShopGuideConfig);
            this.f17369a = dressShopGuideConfig;
        }
    }

    /* JADX INFO: compiled from: DressShopGuideDialog.java */
    public class b extends ViewModel {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AbstractC2593s f17371b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ObservableField<String> f17374e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17370a = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<DressShopGuideConfig> f17372c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ObservableList<ViewModel> f17373d = new ObservableArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g<ListItemViewModel<ViewModel>> f17375f = g.a(new l() { // from class: com.sandboxol.decorate.view.dialog.c
            @Override // me.tatarka.bindingcollectionadapter2.l
            public final void a(g gVar, int i, Object obj) {
                this.f17367a.bindView(gVar, i, (ListItemViewModel) obj);
            }
        });
        public ReplyCommand<Integer> g = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.dialog.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17359a.b(((Integer) obj).intValue());
            }
        });
        public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.dialog.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f17304a.onClose();
            }
        });

        public b(AbstractC2593s abstractC2593s) {
            this.f17374e = new ObservableField<>(((FullScreenDialog) d.this).context.getString(R.string.decorate_dress_shop_guide_dialog_tip));
            this.f17371b = abstractC2593s;
            initView();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i) {
            this.f17371b.f17112a.getChildAt(this.f17370a).setEnabled(false);
            this.f17371b.f17112a.getChildAt(i).setEnabled(true);
            this.f17370a = i;
            this.f17371b.f17113b.setText(this.f17372c.get(i).getTip());
            if (i == this.f17372c.size() - 1) {
                ReportDataAdapter.onEvent(((FullScreenDialog) d.this).context, EventConstant.DRESS_DETAIL_FINAL);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bindView(g gVar, int i, ListItemViewModel<ViewModel> listItemViewModel) {
            gVar.a(com.sandboxol.decorate.c.E, R.layout.content_dress_shop_guide_dialog_page);
        }

        private void initView() {
            String language = Locale.getDefault().getLanguage();
            if (d.this.f17368a != null) {
                this.f17372c = (List) d.this.f17368a.get(language);
                if (this.f17372c == null && d.this.f17368a.get("en") != null) {
                    this.f17372c = (List) d.this.f17368a.get("en");
                }
            }
            this.f17373d.clear();
            List<DressShopGuideConfig> list = this.f17372c;
            if (list != null && list.size() > 0) {
                this.f17371b.f17113b.setText(this.f17372c.get(0).getTip());
                Iterator<DressShopGuideConfig> it = this.f17372c.iterator();
                while (it.hasNext()) {
                    this.f17373d.add(new a(((FullScreenDialog) d.this).context, it.next()));
                }
            }
            for (int i = 0; i < this.f17373d.size(); i++) {
                View view = new View(((FullScreenDialog) d.this).context);
                view.setBackgroundResource(R.drawable.ic_dress_shop_guide_dialog_indicator);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) SizeUtil.dp2px(((FullScreenDialog) d.this).context, 6.0f), (int) SizeUtil.dp2px(((FullScreenDialog) d.this).context, 6.0f));
                view.setEnabled(false);
                if (i != 0) {
                    layoutParams.leftMargin = (int) SizeUtil.dp2px(((FullScreenDialog) d.this).context, 6.0f);
                } else {
                    view.setEnabled(true);
                }
                this.f17371b.f17112a.addView(view, layoutParams);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onClose() {
            d.this.dismiss();
        }
    }

    public d(Context context, Map<String, List<DressShopGuideConfig>> map) {
        super(context);
        this.f17368a = map;
        initView();
    }

    private void initView() {
        super.init(this.context);
        AbstractC2593s abstractC2593s = (AbstractC2593s) e.a(LayoutInflater.from(this.context), R.layout.dialog_dress_shop_guide, (ViewGroup) null, false);
        setContentView(abstractC2593s.getRoot());
        abstractC2593s.a(new b(abstractC2593s));
    }
}

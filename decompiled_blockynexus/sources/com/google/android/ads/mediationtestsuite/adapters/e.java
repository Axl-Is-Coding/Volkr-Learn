package com.google.android.ads.mediationtestsuite.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.dataobjects.Caption;
import com.google.android.ads.mediationtestsuite.viewmodels.CaptionView;
import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;
import com.google.android.ads.mediationtestsuite.viewmodels.f;
import com.google.android.ads.mediationtestsuite.viewmodels.g;
import com.google.android.ads.mediationtestsuite.viewmodels.h;
import com.google.android.ads.mediationtestsuite.viewmodels.i;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ItemsListRecyclerViewAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends RecyclerView.a<RecyclerView.w> implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ListItemViewModel> f12658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<ListItemViewModel> f12659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CharSequence f12660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f12661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f12662e;

    /* JADX INFO: compiled from: ItemsListRecyclerViewAdapter.java */
    public interface a {
        void b(com.google.android.ads.mediationtestsuite.viewmodels.d dVar);
    }

    /* JADX INFO: compiled from: ItemsListRecyclerViewAdapter.java */
    public interface b {
        void a(com.google.android.ads.mediationtestsuite.viewmodels.d dVar);
    }

    public e(List<ListItemViewModel> list, b bVar) {
        this.f12658a = list;
        this.f12659b = list;
        this.f12661d = bVar;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new com.google.android.ads.mediationtestsuite.adapters.b(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.f12659b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemViewType(int i) {
        return this.f12659b.get(i).getViewType().getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        ListItemViewModel.ViewType viewTypeWithValue = ListItemViewModel.ViewType.withValue(getItemViewType(i));
        ListItemViewModel listItemViewModel = this.f12659b.get(i);
        int i2 = d.f12657a[viewTypeWithValue.ordinal()];
        if (i2 == 1) {
            ((com.google.android.ads.mediationtestsuite.viewmodels.b) wVar).a(((com.google.android.ads.mediationtestsuite.viewmodels.c) this.f12659b.get(i)).a());
            return;
        }
        if (i2 == 2) {
            final com.google.android.ads.mediationtestsuite.viewmodels.d dVar = (com.google.android.ads.mediationtestsuite.viewmodels.d) listItemViewModel;
            i iVar = (i) wVar;
            iVar.a().removeAllViewsInLayout();
            Context context = iVar.e().getContext();
            iVar.d().setText(dVar.getTitleText(context));
            iVar.c().setText(dVar.getDetailText(context));
            final CheckBox checkBoxB = iVar.b();
            checkBoxB.setChecked(dVar.isChecked());
            checkBoxB.setVisibility(dVar.shouldShowCheckbox() ? 0 : 8);
            checkBoxB.setEnabled(dVar.shouldEnableCheckbox());
            checkBoxB.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.ads.mediationtestsuite.adapters.ItemsListRecyclerViewAdapter$2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f12652c.f12662e != null) {
                        dVar.setChecked(checkBoxB.isChecked());
                        this.f12652c.f12662e.b(dVar);
                    }
                }
            });
            checkBoxB.setVisibility(dVar.shouldShowCheckbox() ? 0 : 8);
            Iterator<Caption> it = dVar.getCaptions().iterator();
            while (it.hasNext()) {
                iVar.a().addView(new CaptionView(context, it.next()));
            }
            iVar.e().setOnClickListener(new View.OnClickListener() { // from class: com.google.android.ads.mediationtestsuite.adapters.ItemsListRecyclerViewAdapter$3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f12654b.f12661d != null) {
                        this.f12654b.f12661d.a(dVar);
                    }
                }
            });
            return;
        }
        if (i2 == 3) {
            com.google.android.ads.mediationtestsuite.viewmodels.e eVar = (com.google.android.ads.mediationtestsuite.viewmodels.e) wVar;
            f fVar = (f) listItemViewModel;
            eVar.b().setText(fVar.b());
            int iA = fVar.a();
            ImageView imageViewA = eVar.a();
            if (iA < 0) {
                imageViewA.setVisibility(4);
                return;
            } else {
                imageViewA.setImageResource(fVar.a());
                imageViewA.setVisibility(0);
                return;
            }
        }
        if (i2 != 4) {
            return;
        }
        h hVar = (h) wVar;
        Context context2 = hVar.d().getContext();
        g gVar = (g) listItemViewModel;
        hVar.c().setText(gVar.c());
        hVar.a().setText(gVar.a());
        if (gVar.b() == null) {
            hVar.b().setVisibility(8);
            return;
        }
        hVar.b().setVisibility(0);
        hVar.b().setImageResource(gVar.b().getDrawableResourceId());
        androidx.core.widget.g.a(hVar.b(), ColorStateList.valueOf(context2.getResources().getColor(gVar.b().getImageTintColorResId())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        ListItemViewModel.ViewType viewTypeWithValue = ListItemViewModel.ViewType.withValue(i);
        return viewTypeWithValue == ListItemViewModel.ViewType.AD_LOAD ? new com.google.android.ads.mediationtestsuite.viewmodels.b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gmts_view_ad_load, viewGroup, false)) : viewTypeWithValue == ListItemViewModel.ViewType.DETAIL_ITEM ? new i(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gmts_list_item_detail, viewGroup, false)) : viewTypeWithValue == ListItemViewModel.ViewType.HEADER ? new com.google.android.ads.mediationtestsuite.viewmodels.e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gmts_view_section_header, viewGroup, false)) : new h(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gmts_list_ad_unit_info, viewGroup, false));
    }

    public void b() {
        getFilter().filter(this.f12660c);
    }

    public void a(a aVar) {
        this.f12662e = aVar;
    }

    public void a(b bVar) {
        this.f12661d = bVar;
    }
}

package com.google.android.ads.mediationtestsuite.adapters;

import android.widget.Filter;
import com.google.android.ads.mediationtestsuite.dataobjects.Matchable;
import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;
import java.util.ArrayList;

/* JADX INFO: compiled from: ItemsListRecyclerViewAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class b extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f12655a;

    b(e eVar) {
        this.f12655a = eVar;
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        this.f12655a.f12660c = charSequence;
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (charSequence != null && charSequence.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (ListItemViewModel listItemViewModel : this.f12655a.f12658a) {
                if (!(listItemViewModel instanceof Matchable)) {
                    arrayList.add(listItemViewModel);
                } else if (((Matchable) listItemViewModel).matches(charSequence)) {
                    arrayList.add(listItemViewModel);
                }
            }
            filterResults.values = new c(this.f12655a, arrayList);
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Object obj = filterResults.values;
        if (obj instanceof c) {
            this.f12655a.f12659b = ((c) obj).f12656a;
        } else {
            e eVar = this.f12655a;
            eVar.f12659b = eVar.f12658a;
        }
        this.f12655a.notifyDataSetChanged();
    }
}

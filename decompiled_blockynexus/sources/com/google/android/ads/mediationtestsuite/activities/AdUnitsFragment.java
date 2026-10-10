package com.google.android.ads.mediationtestsuite.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.adapters.e;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.android.ads.mediationtestsuite.dataobjects.DataStore;
import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AdUnitsFragment extends Fragment implements OnAdUnitsStateChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Type f12623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RecyclerView f12624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<ListItemViewModel> f12625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.google.android.ads.mediationtestsuite.adapters.e f12626d;

    public enum Type {
        FAILING(1),
        WORKING(2),
        ALL(3);

        private final int val;

        Type(int i) {
            this.val = i;
        }

        public String getTitle(Resources resources) {
            int i = h.f12645a[ordinal()];
            return i != 1 ? i != 2 ? "" : resources.getString(R.string.gmts_working_ad_units) : resources.getString(R.string.gmts_failing_ad_units);
        }

        public int getVal() {
            return this.val;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AdUnit> i() {
        Type type = this.f12623a;
        return type == Type.FAILING ? DataStore.getFailingAdUnits() : type == Type.WORKING ? DataStore.getWorkingAdUnits() : new ArrayList(DataStore.getAdUnits().values());
    }

    @Override // com.google.android.ads.mediationtestsuite.activities.OnAdUnitsStateChangedListener
    public void f() {
        h();
    }

    public Type g() {
        if (this.f12623a == null) {
            int i = getArguments().getInt("type");
            if (Type.FAILING.getVal() == i) {
                this.f12623a = Type.FAILING;
            } else if (Type.WORKING.getVal() == i) {
                this.f12623a = Type.WORKING;
            }
        }
        return this.f12623a;
    }

    public void h() {
        getActivity().runOnUiThread(new g(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        int i = getArguments().getInt("type");
        if (Type.FAILING.getVal() == i) {
            this.f12623a = Type.FAILING;
        } else if (Type.WORKING.getVal() == i) {
            this.f12623a = Type.WORKING;
        } else if (Type.ALL.getVal() == i) {
            this.f12623a = Type.ALL;
        }
        this.f12625c = new ArrayList();
        this.f12624b.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f12626d = new com.google.android.ads.mediationtestsuite.adapters.e(this.f12625c, null);
        this.f12624b.setAdapter(this.f12626d);
        DataStore.addToAdUnitListeners(this);
        if (getActivity() instanceof e.b) {
            this.f12626d.a((e.b) getActivity());
        }
        h();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.gmts_fragment_ad_units, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        DataStore.removeFromListeners(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f12624b = (RecyclerView) view.findViewById(R.id.gmts_recycler);
    }

    public static AdUnitsFragment a(Type type) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", type.getVal());
        AdUnitsFragment adUnitsFragment = new AdUnitsFragment();
        adUnitsFragment.setArguments(bundle);
        return adUnitsFragment;
    }

    public void a(CharSequence charSequence) {
        this.f12626d.getFilter().filter(charSequence);
    }
}

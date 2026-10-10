package com.google.android.ads.mediationtestsuite.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.dataobjects.DataStore;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkDetailActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RecyclerView f12633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NetworkConfig f12634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<ListItemViewModel> f12635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.google.android.ads.mediationtestsuite.adapters.e f12636d;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.gmts_activity_network_detail);
        this.f12633a = (RecyclerView) findViewById(R.id.gmts_recycler);
        this.f12634b = DataStore.getNetworkConfig(getIntent().getIntExtra("network_config", -1));
        setTitle(this.f12634b.getLabel());
        this.f12635c = com.google.android.ads.mediationtestsuite.viewmodels.k.a(this.f12634b);
        this.f12633a.setLayoutManager(new LinearLayoutManager(this));
        this.f12636d = new com.google.android.ads.mediationtestsuite.adapters.e(this.f12635c, null);
        this.f12633a.setAdapter(this.f12636d);
        setTitle(this.f12634b.getLabel());
    }
}

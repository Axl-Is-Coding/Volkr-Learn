package com.google.android.ads.mediationtestsuite.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.j;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.adapters.e;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.android.ads.mediationtestsuite.dataobjects.BatchAdRequestManager;
import com.google.android.ads.mediationtestsuite.dataobjects.DataStore;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.ads.mediationtestsuite.utils.s;
import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AdUnitDetailActivity extends AppCompatActivity implements OnNetworkConfigStateChangedListener, e.a, e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RecyclerView f12615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AdUnit f12616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<ListItemViewModel> f12617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Toolbar f12618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Toolbar f12619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<NetworkConfig> f12620f = new HashSet();
    private com.google.android.ads.mediationtestsuite.adapters.e g;
    private boolean h;
    private BatchAdRequestManager i;

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.i.cancelTesting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        j.a aVar = new j.a(this, R.style.gmts_DialogTheme_FlippedButtonColor);
        aVar.a(R.string.gmts_loading_ads_title);
        aVar.b(R.layout.gmts_dialog_loading);
        aVar.a(false);
        aVar.a(R.string.gmts_button_cancel, new DialogInterface.OnClickListener() { // from class: com.google.android.ads.mediationtestsuite.activities.AdUnitDetailActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AdUnitDetailActivity.this.g();
            }
        });
        androidx.appcompat.app.j jVarA = aVar.a();
        jVarA.show();
        this.i = new BatchAdRequestManager(this, this.f12620f, new d(this, jVarA));
        this.i.beginTesting();
    }

    private void i() {
        this.f12619e.setTitle(getString(R.string.gmts_num_ads_selected, new Object[]{Integer.valueOf(this.f12620f.size())}));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.gmts_activity_ad_unit_detail);
        this.f12618d = (Toolbar) findViewById(R.id.gmts_main_toolbar);
        this.f12619e = (Toolbar) findViewById(R.id.gmts_secondary_toolbar);
        this.f12619e.setNavigationIcon(R.drawable.gmts_quantum_ic_close_white_24);
        this.f12619e.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.google.android.ads.mediationtestsuite.activities.AdUnitDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = AdUnitDetailActivity.this.f12620f.iterator();
                while (it.hasNext()) {
                    ((NetworkConfig) it.next()).setChecked(false);
                }
                AdUnitDetailActivity.this.f12620f.clear();
                AdUnitDetailActivity.b(AdUnitDetailActivity.this.f12618d, AdUnitDetailActivity.this.f12619e);
                AdUnitDetailActivity.this.g.notifyDataSetChanged();
            }
        });
        this.f12619e.inflateMenu(R.menu.gmts_menu_load_ads);
        this.f12619e.setOnMenuItemClickListener(new a(this));
        i();
        setSupportActionBar(this.f12618d);
        this.h = getIntent().getBooleanExtra("search_mode", false);
        this.f12615a = (RecyclerView) findViewById(R.id.gmts_recycler);
        this.f12616b = DataStore.getAdUnit(getIntent().getStringExtra("ad_unit"));
        this.f12617c = com.google.android.ads.mediationtestsuite.viewmodels.k.a(this.f12616b, this.h);
        this.f12615a.setLayoutManager(new LinearLayoutManager(this));
        this.g = new com.google.android.ads.mediationtestsuite.adapters.e(this.f12617c, this);
        this.g.a((e.a) this);
        this.f12615a.setAdapter(this.g);
        if (this.h) {
            this.f12618d.setContentInsetsAbsolute(0, 0);
            getSupportActionBar().a(R.layout.gmts_search_view);
            getSupportActionBar().e(true);
            getSupportActionBar().f(false);
            getSupportActionBar().g(false);
            a((SearchView) getSupportActionBar().g());
        }
        DataStore.addToNetworkConfigListeners(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        if (this.h) {
            return false;
        }
        menuInflater.inflate(R.menu.gmts_menu_search_icon, menu);
        s.a(menu, getResources().getColor(R.color.gmts_dark_text_primary));
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DataStore.removeFromNetworkConfigListeners(this);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        if (menuItem.getItemId() != R.id.gmts_search) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent(this, (Class<?>) AdUnitDetailActivity.class);
        intent.putExtra("search_mode", true);
        intent.putExtra("ad_unit", this.f12616b.getId());
        startActivity(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Toolbar toolbar, Toolbar toolbar2) {
        toolbar.setAlpha(WheelView.DividerConfig.FILL);
        toolbar.setVisibility(0);
        long j = 300;
        toolbar.animate().alpha(1.0f).setDuration(j).setListener(null);
        toolbar2.animate().alpha(WheelView.DividerConfig.FILL).setDuration(j).setListener(new f(toolbar2));
    }

    private void a(SearchView searchView) {
        searchView.setQueryHint(getResources().getString(R.string.gmts_placeholder_search_ad_source));
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(new b(this));
    }

    @Override // com.google.android.ads.mediationtestsuite.activities.OnNetworkConfigStateChangedListener
    public void a(NetworkConfig networkConfig) {
        if (this.f12617c.contains(networkConfig)) {
            this.f12617c.clear();
            this.f12617c.addAll(com.google.android.ads.mediationtestsuite.viewmodels.k.a(this.f12616b, this.h));
            runOnUiThread(new e(this));
        }
    }

    @Override // com.google.android.ads.mediationtestsuite.adapters.e.b
    public void a(com.google.android.ads.mediationtestsuite.viewmodels.d dVar) {
        if (dVar instanceof NetworkConfig) {
            NetworkConfig networkConfig = (NetworkConfig) dVar;
            Intent intent = new Intent(this, (Class<?>) NetworkDetailActivity.class);
            intent.putExtra("network_config", networkConfig.getId());
            startActivityForResult(intent, networkConfig.getId());
        }
    }

    @Override // com.google.android.ads.mediationtestsuite.adapters.e.a
    public void b(com.google.android.ads.mediationtestsuite.viewmodels.d dVar) {
        int size = this.f12620f.size();
        if (dVar instanceof NetworkConfig) {
            if (dVar.isChecked()) {
                this.f12620f.add((NetworkConfig) dVar);
            } else {
                this.f12620f.remove(dVar);
            }
        }
        if (!this.f12620f.isEmpty()) {
            i();
        }
        int size2 = this.f12620f.size();
        if (size == 0 && size2 > 0) {
            b(this.f12619e, this.f12618d);
        } else {
            if (size <= 0 || size2 != 0) {
                return;
            }
            b(this.f12618d, this.f12619e);
        }
    }
}

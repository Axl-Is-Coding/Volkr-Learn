package com.google.android.ads.mediationtestsuite.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.F;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.activities.AdUnitsFragment;
import com.google.android.ads.mediationtestsuite.adapters.e;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.android.gms.actions.SearchIntents;

/* JADX INFO: loaded from: classes.dex */
public class AdUnitsSearchActivity extends AppCompatActivity implements e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdUnitsFragment f12627a;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.gmts_activity_ad_units_search);
        this.f12627a = AdUnitsFragment.a(AdUnitsFragment.Type.ALL);
        F fA = getSupportFragmentManager().a();
        fA.a(R.id.gmts_content_view, this.f12627a, null);
        fA.a();
        a(getIntent());
        Toolbar toolbar = (Toolbar) findViewById(R.id.gmts_toolbar);
        toolbar.setNavigationIcon((Drawable) null);
        setSupportActionBar(toolbar);
        getSupportActionBar().a(R.layout.gmts_search_view);
        getSupportActionBar().e(true);
        getSupportActionBar().f(false);
        getSupportActionBar().g(false);
        a((SearchView) getSupportActionBar().g());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        a(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private void a(SearchView searchView) {
        searchView.setQueryHint(getResources().getString(R.string.gmts_placeholder_search_ad_units));
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(new i(this));
    }

    @Override // com.google.android.ads.mediationtestsuite.adapters.e.b
    public void a(com.google.android.ads.mediationtestsuite.viewmodels.d dVar) {
        Intent intent = new Intent(this, (Class<?>) AdUnitDetailActivity.class);
        intent.putExtra("ad_unit", ((AdUnit) dVar).getId());
        startActivity(intent);
    }

    private void a(Intent intent) {
        if ("android.intent.action.SEARCH".equals(intent.getAction())) {
            this.f12627a.a(intent.getStringExtra(SearchIntents.EXTRA_QUERY));
        }
    }
}

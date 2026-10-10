package com.google.android.ads.mediationtestsuite.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.j;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.ads.mediationtestsuite.MediationTestSuite;
import com.google.android.ads.mediationtestsuite.MediationTestSuiteListener;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.adapters.e;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.android.ads.mediationtestsuite.dataobjects.DataStore;
import com.google.android.ads.mediationtestsuite.utils.logging.AdUnitsViewEvent;
import com.google.android.material.tabs.TabLayout;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class HomeActivity extends AppCompatActivity implements e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewPager f12628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Toolbar f12629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.android.ads.mediationtestsuite.adapters.a f12630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TabLayout f12631d;

    private void g() {
        this.f12628a = (ViewPager) findViewById(R.id.gmts_pager);
        this.f12630c = new com.google.android.ads.mediationtestsuite.adapters.a(getSupportFragmentManager(), this);
        this.f12628a.setAdapter(this.f12630c);
        this.f12628a.addOnPageChangeListener(new j(this));
        this.f12631d = (TabLayout) findViewById(R.id.gmts_tab);
        this.f12631d.setupWithViewPager(this.f12628a);
    }

    private void h() {
        String str = String.format(getString(R.string.gmts_disclaimer_confirmation), String.format("<a href=\"%1$s\">%2$s</a>", "https://support.google.com/admob/answer/9016899", getString(R.string.gmts_disclaimer_link_text)));
        View viewInflate = getLayoutInflater().inflate(R.layout.gmts_dialog_disclaimer, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.gmts_confirmation_text);
        textView.setText(Html.fromHtml(str));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.gmts_checkbox);
        j.a aVar = new j.a(this, R.style.gmts_DialogTheme);
        aVar.a(R.string.gmts_disclaimer_title);
        aVar.b(viewInflate);
        aVar.a(false);
        aVar.b(R.string.gmts_button_agree, new DialogInterface.OnClickListener(this) { // from class: com.google.android.ads.mediationtestsuite.activities.HomeActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DataStore.setDidAcceptDisclaimer(true);
            }
        });
        aVar.a(R.string.gmts_button_cancel, new DialogInterface.OnClickListener() { // from class: com.google.android.ads.mediationtestsuite.activities.HomeActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                HomeActivity.this.finish();
            }
        });
        androidx.appcompat.app.j jVarA = aVar.a();
        jVarA.setOnShowListener(new l(this, checkBox));
        jVarA.show();
    }

    @Override // com.google.android.ads.mediationtestsuite.adapters.e.b
    public void a(com.google.android.ads.mediationtestsuite.viewmodels.d dVar) {
        if (dVar instanceof AdUnit) {
            Intent intent = new Intent(this, (Class<?>) AdUnitDetailActivity.class);
            intent.putExtra("ad_unit", ((AdUnit) dVar).getId());
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        MediationTestSuiteListener listener = MediationTestSuite.getListener();
        if (listener != null) {
            listener.onMediationTestSuiteDismissed();
        }
        super.finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.gmts_activity_home);
        this.f12629b = (Toolbar) findViewById(R.id.gmts_main_toolbar);
        setSupportActionBar(this.f12629b);
        DataStore.initialize(this, getIntent().getStringExtra("app_id"));
        try {
            DataStore.downloadAdUnits();
        } catch (IOException unused) {
            Log.e("gma_test", "IO Exception");
        }
        g();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gmts_menu_search_icon, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.gmts_search) {
            return super.onOptionsItemSelected(menuItem);
        }
        com.google.android.ads.mediationtestsuite.utils.logging.e.a(new AdUnitsViewEvent(AdUnitsViewEvent.ViewType.SEARCH), this);
        startActivity(new Intent(this, (Class<?>) AdUnitsSearchActivity.class));
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataStore.getDidAcceptDisclaimer()) {
            return;
        }
        h();
    }
}

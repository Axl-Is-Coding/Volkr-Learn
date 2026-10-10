package me.iwf.photopicker;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.F;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.fragment.ImagePagerFragment;

/* JADX INFO: loaded from: classes5.dex */
public class PhotoPickerActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private me.iwf.photopicker.fragment.c f22881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImagePagerFragment f22882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MenuItem f22883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22884d = 9;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f22885e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f22886f = false;
    private ArrayList<String> g = null;

    public PhotoPickerActivity g() {
        return this;
    }

    public void h() {
        if (this.f22885e) {
            me.iwf.photopicker.fragment.c cVar = this.f22881a;
            if (cVar == null || !cVar.isResumed()) {
                ImagePagerFragment imagePagerFragment = this.f22882b;
                if (imagePagerFragment == null || !imagePagerFragment.isResumed()) {
                    return;
                }
                this.f22883c.setEnabled(true);
                return;
            }
            List<String> listE = this.f22881a.h().e();
            int size = listE == null ? 0 : listE.size();
            this.f22883c.setEnabled(size > 0);
            if (this.f22884d > 1) {
                this.f22883c.setTitle(getString(R.string.__picker_done_with_count, new Object[]{Integer.valueOf(size), Integer.valueOf(this.f22884d)}));
            } else {
                this.f22883c.setTitle(getString(R.string.__picker_done));
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ImagePagerFragment imagePagerFragment = this.f22882b;
        if (imagePagerFragment == null || !imagePagerFragment.isVisible()) {
            super.onBackPressed();
        } else if (getSupportFragmentManager().c() > 0) {
            getSupportFragmentManager().f();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra("SHOW_CAMERA", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("SHOW_GIF", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("PREVIEW_ENABLED", true);
        a(booleanExtra2);
        setContentView(R.layout.__picker_activity_photo_picker);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        setTitle(R.string.__picker_title);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.d(true);
        if (Build.VERSION.SDK_INT >= 21) {
            supportActionBar.a(25.0f);
        }
        this.f22884d = getIntent().getIntExtra("MAX_COUNT", 9);
        int intExtra = getIntent().getIntExtra("column", 3);
        this.g = getIntent().getStringArrayListExtra("ORIGINAL_PHOTOS");
        this.f22881a = (me.iwf.photopicker.fragment.c) getSupportFragmentManager().a("tag");
        if (this.f22881a == null) {
            this.f22881a = me.iwf.photopicker.fragment.c.a(booleanExtra, booleanExtra2, booleanExtra3, intExtra, this.f22884d, this.g);
            F fA = getSupportFragmentManager().a();
            fA.b(R.id.container, this.f22881a, "tag");
            fA.a();
            getSupportFragmentManager().b();
        }
        this.f22881a.h().a(new e(this));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f22885e) {
            return false;
        }
        getMenuInflater().inflate(R.menu.__picker_menu_picker, menu);
        this.f22883c = menu.findItem(R.id.done);
        ArrayList<String> arrayList = this.g;
        if (arrayList == null || arrayList.size() <= 0) {
            this.f22883c.setEnabled(false);
        } else {
            this.f22883c.setEnabled(true);
            this.f22883c.setTitle(getString(R.string.__picker_done_with_count, new Object[]{Integer.valueOf(this.g.size()), Integer.valueOf(this.f22884d)}));
        }
        this.f22885e = true;
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        ImagePagerFragment imagePagerFragment;
        if (menuItem.getItemId() == 16908332) {
            super.onBackPressed();
            return true;
        }
        if (menuItem.getItemId() != R.id.done) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent();
        me.iwf.photopicker.fragment.c cVar = this.f22881a;
        ArrayList<String> arrayListF = cVar != null ? cVar.h().f() : null;
        if (arrayListF.size() <= 0 && (imagePagerFragment = this.f22882b) != null && imagePagerFragment.isResumed()) {
            arrayListF = this.f22882b.h();
        }
        if (arrayListF != null && arrayListF.size() > 0) {
            intent.putStringArrayListExtra("SELECTED_PHOTOS", arrayListF);
            setResult(-1, intent);
            finish();
        }
        return true;
    }

    public void a(ImagePagerFragment imagePagerFragment) {
        this.f22882b = imagePagerFragment;
        F fA = getSupportFragmentManager().a();
        fA.b(R.id.container, this.f22882b);
        fA.a((String) null);
        fA.a();
    }

    public void a(boolean z) {
        this.f22886f = z;
    }
}

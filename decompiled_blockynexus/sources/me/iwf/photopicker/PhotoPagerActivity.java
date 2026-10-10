package me.iwf.photopicker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.j;
import androidx.appcompat.widget.Toolbar;
import com.facebook.places.model.PlaceFields;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import me.iwf.photopicker.fragment.ImagePagerFragment;

/* JADX INFO: loaded from: classes5.dex */
public class PhotoPagerActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImagePagerFragment f22872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ActionBar f22873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22874c;

    public void g() {
        ActionBar actionBar = this.f22873b;
        if (actionBar != null) {
            actionBar.a(getString(R.string.__picker_image_index, new Object[]{Integer.valueOf(this.f22872a.j().getCurrentItem() + 1), Integer.valueOf(this.f22872a.i().size())}));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("SELECTED_PHOTOS", this.f22872a.i());
        setResult(-1, intent);
        finish();
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.__picker_activity_photo_pager);
        int intExtra = getIntent().getIntExtra("current_item", 0);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(PlaceFields.PHOTOS_PROFILE);
        this.f22874c = getIntent().getBooleanExtra("show_delete", true);
        if (this.f22872a == null) {
            this.f22872a = (ImagePagerFragment) getSupportFragmentManager().a(R.id.photoPagerFragment);
        }
        this.f22872a.b(stringArrayListExtra, intExtra);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.f22873b = getSupportActionBar();
        ActionBar actionBar = this.f22873b;
        if (actionBar != null) {
            actionBar.d(true);
            g();
            if (Build.VERSION.SDK_INT >= 21) {
                this.f22873b.a(25.0f);
            }
        }
        this.f22872a.j().addOnPageChangeListener(new c(this));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!this.f22874c) {
            return true;
        }
        getMenuInflater().inflate(R.menu.__picker_menu_preview, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        if (menuItem.getItemId() != R.id.delete) {
            return super.onOptionsItemSelected(menuItem);
        }
        final int iG = this.f22872a.g();
        final String str = this.f22872a.i().get(iG);
        Snackbar snackbarA = Snackbar.a(this.f22872a.getView(), R.string.__picker_deleted_a_photo, 0);
        if (this.f22872a.i().size() <= 1) {
            j.a aVar = new j.a(this);
            aVar.a(R.string.__picker_confirm_to_delete);
            aVar.b(R.string.__picker_yes, new DialogInterface.OnClickListener() { // from class: me.iwf.photopicker.PhotoPagerActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    PhotoPagerActivity.this.f22872a.i().remove(iG);
                    PhotoPagerActivity.this.f22872a.j().getAdapter().notifyDataSetChanged();
                    PhotoPagerActivity.this.onBackPressed();
                }
            });
            aVar.a(R.string.__picker_cancel, new DialogInterface.OnClickListener() { // from class: me.iwf.photopicker.PhotoPagerActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            aVar.c();
        } else {
            snackbarA.n();
            this.f22872a.i().remove(iG);
            this.f22872a.j().getAdapter().notifyDataSetChanged();
        }
        snackbarA.a(R.string.__picker_undo, new View.OnClickListener() { // from class: me.iwf.photopicker.PhotoPagerActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PhotoPagerActivity.this.f22872a.i().size() > 0) {
                    PhotoPagerActivity.this.f22872a.i().add(iG, str);
                } else {
                    PhotoPagerActivity.this.f22872a.i().add(str);
                }
                PhotoPagerActivity.this.f22872a.j().getAdapter().notifyDataSetChanged();
                PhotoPagerActivity.this.f22872a.j().setCurrentItem(iG, true);
            }
        });
        return true;
    }
}

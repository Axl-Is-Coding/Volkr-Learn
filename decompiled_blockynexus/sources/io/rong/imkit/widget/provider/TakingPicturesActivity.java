package io.rong.imkit.widget.provider;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.core.content.FileProvider;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.message.utils.BitmapUtil;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TakingPicturesActivity extends Activity implements View.OnClickListener {
    private static int COMPRESSED_SIZE = 1080;
    private static final int REQUEST_CAMERA = 2;
    private static final String TAG = "TakingPicturesActivity";
    private ImageView mImage;
    private Uri mSavedPicUri;

    private void startCamera() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdirs();
        }
        File file = new File(externalStoragePublicDirectory, System.currentTimeMillis() + ".jpg");
        this.mSavedPicUri = Uri.fromFile(file);
        RLog.d(TAG, "startCamera output pic uri =" + this.mSavedPicUri);
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        List<ResolveInfo> listQueryIntentActivities = getPackageManager().queryIntentActivities(intent, 65536);
        try {
            Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + getString(R.string.rc_authorities_fileprovider), file);
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                String str = it.next().activityInfo.packageName;
                grantUriPermission(str, uriForFile, 2);
                grantUriPermission(str, uriForFile, 1);
            }
            intent.putExtra("output", uriForFile);
            intent.addCategory("android.intent.category.DEFAULT");
            try {
                startActivityForResult(intent, 2);
            } catch (SecurityException unused) {
                Log.e(TAG, "REQUEST_CAMERA SecurityException!!!");
            }
        } catch (Exception unused2) {
            throw new RuntimeException("Please check IMKit Manifest FileProvider config.");
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        RLog.d(TAG, "onActivityResult resultCode = " + i2 + ", intent=" + intent);
        if (i2 != -1) {
            finish();
            return;
        }
        if (i == 2) {
            Uri uri = this.mSavedPicUri;
            if (uri != null) {
                try {
                    this.mImage.setImageBitmap(BitmapUtil.getNewResizedBitmap(this, uri, 1080));
                } catch (IOException e2) {
                    RLog.e(TAG, "onActivityResult", e2);
                }
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!new File(this.mSavedPicUri.getPath()).exists()) {
            finish();
        }
        if (view.getId() != R.id.rc_send) {
            if (view.getId() == R.id.rc_back) {
                finish();
            }
        } else {
            if (this.mSavedPicUri != null) {
                Intent intent = new Intent();
                intent.setData(this.mSavedPicUri);
                setResult(-1, intent);
            }
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.rc_ac_camera);
        Button button = (Button) findViewById(R.id.rc_back);
        Button button2 = (Button) findViewById(R.id.rc_send);
        this.mImage = (ImageView) findViewById(R.id.rc_img);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        RLog.d(TAG, "onCreate savedInstanceState : " + bundle);
        try {
            Resources resources = getApplicationContext().getResources();
            COMPRESSED_SIZE = resources.getInteger(resources.getIdentifier("rc_image_size", "integer", getApplicationContext().getPackageName()));
        } catch (Exception e2) {
            RLog.e(TAG, "onCreate", e2);
        }
        if (bundle == null) {
            startCamera();
            return;
        }
        String string = bundle.getString("photo_uri");
        if (string != null) {
            this.mSavedPicUri = Uri.parse(string);
            try {
                this.mImage.setImageBitmap(BitmapUtil.getNewResizedBitmap(this, this.mSavedPicUri, COMPRESSED_SIZE));
            } catch (IOException e3) {
                RLog.e(TAG, "onCreate", e3);
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        Log.e(TAG, "onRestoreInstanceState");
        this.mSavedPicUri = Uri.parse(bundle.getString("photo_uri"));
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Log.e(TAG, "onSaveInstanceState");
        bundle.putString("photo_uri", this.mSavedPicUri.toString());
        super.onSaveInstanceState(bundle);
    }
}

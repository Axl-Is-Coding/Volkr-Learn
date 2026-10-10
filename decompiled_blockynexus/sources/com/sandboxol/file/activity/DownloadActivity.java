package com.sandboxol.file.activity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.sandboxol.file.R;
import com.sandboxol.file.c.d;
import com.sandboxol.file.e.i;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.UnzipInfo;
import com.sandboxol.file.entity.VerifyInfo;
import com.sandboxol.file.g.f;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadActivity extends AppCompatActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Button f17540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.sandboxol.file.a.b f17541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17542c = "https://ks3-cn-shanghai.ksyun.com/sandbox-region/blockman-so/release_seoul/res_v4.406.0.0_60.zip";

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            com.sandboxol.file.b.a aVar = new com.sandboxol.file.b.a();
            aVar.a(new DownloadInfo().setUrl(this.f17542c).setAutoStart(true));
            aVar.a(new c(this));
            d dVar = new d(aVar);
            com.sandboxol.file.b.c cVar = new com.sandboxol.file.b.c();
            cVar.a(new VerifyInfo().setFileName(this.f17542c.split("/")[this.f17542c.split("/").length - 1]).setFileDir(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + "/").setCode("64bab7710fe781885618fc1308b98b76"));
            cVar.a(new b(this));
            f fVar = new f(this, cVar);
            com.sandboxol.file.b.b bVar = new com.sandboxol.file.b.b();
            bVar.a(new UnzipInfo().setFromDir(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + "/").setToDir(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + "/").setZipName(this.f17542c.split("/")[this.f17542c.split("/").length - 1]));
            bVar.a(new a(this));
            fVar.a(new i(this, bVar));
            dVar.a(fVar);
            this.f17541b = dVar;
            this.f17541b.d();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_download);
        this.f17540a = (Button) findViewById(R.id.button);
        this.f17540a.setOnClickListener(this);
    }

    public void onDelete(View view) {
        com.sandboxol.file.a.b bVar = this.f17541b;
        if (bVar != null) {
            bVar.a();
            return;
        }
        com.sandboxol.file.b.a aVar = new com.sandboxol.file.b.a();
        aVar.a(new DownloadInfo().setUrl(this.f17542c).setAutoStart(true));
        new d(aVar).a();
    }

    public void onStop(View view) {
        com.sandboxol.file.a.b bVar = this.f17541b;
        if (bVar != null) {
            bVar.e();
        }
    }
}

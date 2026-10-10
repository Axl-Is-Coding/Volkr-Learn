package com.disabngo.blockynexus.view.dialog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: loaded from: classes2.dex */
public class FiveStarsDialog extends AppCompatActivity implements View.OnClickListener {
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.llCancel) {
            finish();
            return;
        }
        if (id == R.id.llFiveStar) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UrlConstant.PLAY_STORE_URL)));
            SharedUtils.putBoolean(this, "is.has.market.rate", true);
            ReportDataAdapter.onEvent(this, EventConstant.CLICK_FIVESTAR);
            finish();
            return;
        }
        if (id != R.id.llSend) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:Blockymods@sandboxol.com"));
        intent.putExtra("android.intent.extra.CC", new String[]{"Blockymods@sandboxol.com"});
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.five_stars_email_title));
        intent.putExtra("android.intent.extra.TEXT", "");
        startActivity(Intent.createChooser(intent, getString(R.string.five_stars_email_choose)));
        SharedUtils.putBoolean(this, "is.has.market.rate", true);
        ReportDataAdapter.onEvent(this, EventConstant.CLICK_NOTGOOD);
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.disabngo.blockynexus.databinding.Za za = (com.disabngo.blockynexus.databinding.Za) androidx.databinding.e.a(this, R.layout.dialog_app_five_stars);
        za.f8083d.setOnClickListener(this);
        za.f8084e.setOnClickListener(this);
        za.f8085f.setOnClickListener(this);
    }
}

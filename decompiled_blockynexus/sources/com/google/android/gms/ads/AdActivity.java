package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaqy;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzwm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class AdActivity extends Activity {

    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";

    @KeepForSdk
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzaqy zzacp;

    private final void zzdq() {
        zzaqy zzaqyVar = this.zzacp;
        if (zzaqyVar != null) {
            try {
                zzaqyVar.zzdq();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzacp.onActivityResult(i, i2, intent);
        } catch (Exception e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        boolean zZzut = true;
        try {
            if (this.zzacp != null) {
                zZzut = this.zzacp.zzut();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        if (zZzut) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzacp.zzad(ObjectWrapper.wrap(configuration));
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzacp = zzwm.zzpu().zzb(this);
        zzaqy zzaqyVar = this.zzacp;
        if (zzaqyVar == null) {
            zzbbq.zze("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzaqyVar.onCreate(bundle);
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        try {
            if (this.zzacp != null) {
                this.zzacp.onDestroy();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        try {
            if (this.zzacp != null) {
                this.zzacp.onPause();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        try {
            if (this.zzacp != null) {
                this.zzacp.onRestart();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        try {
            if (this.zzacp != null) {
                this.zzacp.onResume();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzacp != null) {
                this.zzacp.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        try {
            if (this.zzacp != null) {
                this.zzacp.onStart();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStop() {
        try {
            if (this.zzacp != null) {
                this.zzacp.onStop();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        zzdq();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        zzdq();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdq();
    }
}

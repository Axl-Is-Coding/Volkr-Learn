package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface> {

    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;

    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";

    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    final Handler zza;
    private ConnectionResult zzaa;
    private boolean zzab;
    private volatile com.google.android.gms.common.internal.zzc zzac;

    @VisibleForTesting
    protected ConnectionProgressReportCallbacks zzb;

    @VisibleForTesting
    protected AtomicInteger zzc;
    private int zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    private volatile String zzj;

    @VisibleForTesting
    private zzk zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private T zzs;
    private final ArrayList<zzc<?>> zzt;
    private zzd zzu;
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;
    private static final Feature[] zzd = new Feature[0];

    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    @KeepForSdk
    public interface BaseConnectionCallbacks {

        @KeepForSdk
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;

        @KeepForSdk
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        @KeepForSdk
        void onConnected(Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    @KeepForSdk
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    @KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public void onReportServiceBinding(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.onConnectionFailed(connectionResult);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    @KeepForSdk
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    private abstract class zza extends zzc<Boolean> {
        private final int zza;
        private final Bundle zzb;

        protected zza(int i, Bundle bundle) {
            super(true);
            this.zza = i;
            this.zzb = bundle;
        }

        protected abstract void zza(ConnectionResult connectionResult);

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        protected final /* synthetic */ void zza(Boolean bool) {
            if (bool == null) {
                BaseGmsClient.this.zza(1, (IInterface) null);
                return;
            }
            int i = this.zza;
            if (i == 0) {
                if (zza()) {
                    return;
                }
                BaseGmsClient.this.zza(1, (IInterface) null);
                zza(new ConnectionResult(8, null));
                return;
            }
            if (i == 10) {
                BaseGmsClient.this.zza(1, (IInterface) null);
                throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), BaseGmsClient.this.getStartServiceAction(), BaseGmsClient.this.getServiceDescriptor()));
            }
            BaseGmsClient.this.zza(1, (IInterface) null);
            Bundle bundle = this.zzb;
            zza(new ConnectionResult(this.zza, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
        }

        protected abstract boolean zza();

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        protected final void zzb() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    final class zzb extends com.google.android.gms.internal.common.zzi {
        public zzb(Looper looper) {
            super(looper);
        }

        private static void zza(Message message) {
            zzc zzcVar = (zzc) message.obj;
            zzcVar.zzb();
            zzcVar.zzd();
        }

        private static boolean zzb(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (BaseGmsClient.this.zzc.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                    return;
                }
                return;
            }
            int i = message.what;
            if ((i == 1 || i == 7 || ((i == 4 && !BaseGmsClient.this.enableLocalFallback()) || message.what == 5)) && !BaseGmsClient.this.isConnecting()) {
                zza(message);
                return;
            }
            int i2 = message.what;
            if (i2 == 4) {
                BaseGmsClient.this.zzaa = new ConnectionResult(message.arg2);
                if (BaseGmsClient.this.zzc() && !BaseGmsClient.this.zzab) {
                    BaseGmsClient.this.zza(3, (IInterface) null);
                    return;
                }
                ConnectionResult connectionResult = BaseGmsClient.this.zzaa != null ? BaseGmsClient.this.zzaa : new ConnectionResult(8);
                BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
                return;
            }
            if (i2 == 5) {
                ConnectionResult connectionResult2 = BaseGmsClient.this.zzaa != null ? BaseGmsClient.this.zzaa : new ConnectionResult(8);
                BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult2);
                BaseGmsClient.this.onConnectionFailed(connectionResult2);
                return;
            }
            if (i2 == 3) {
                Object obj = message.obj;
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult3);
                BaseGmsClient.this.onConnectionFailed(connectionResult3);
                return;
            }
            if (i2 == 6) {
                BaseGmsClient.this.zza(5, (IInterface) null);
                if (BaseGmsClient.this.zzw != null) {
                    BaseGmsClient.this.zzw.onConnectionSuspended(message.arg2);
                }
                BaseGmsClient.this.onConnectionSuspended(message.arg2);
                BaseGmsClient.this.zza(5, 1, (IInterface) null);
                return;
            }
            if (i2 == 2 && !BaseGmsClient.this.isConnected()) {
                zza(message);
                return;
            }
            if (zzb(message)) {
                ((zzc) message.obj).zzc();
                return;
            }
            int i3 = message.what;
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i3);
            Log.wtf("GmsClient", sb.toString(), new Exception());
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    protected abstract class zzc<TListener> {
        private TListener zza;
        private boolean zzb = false;

        public zzc(TListener tlistener) {
            this.zza = tlistener;
        }

        protected abstract void zza(TListener tlistener);

        protected abstract void zzb();

        public final void zzc() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.zza;
                if (this.zzb) {
                    String strValueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(strValueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    zza(tlistener);
                } catch (RuntimeException e2) {
                    zzb();
                    throw e2;
                }
            } else {
                zzb();
            }
            synchronized (this) {
                this.zzb = true;
            }
            zzd();
        }

        public final void zzd() {
            zze();
            synchronized (BaseGmsClient.this.zzt) {
                BaseGmsClient.this.zzt.remove(this);
            }
        }

        public final void zze() {
            synchronized (this) {
                this.zza = null;
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    @VisibleForTesting
    public final class zzd implements ServiceConnection {
        private final int zza;

        public zzd(int i) {
            this.zza = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker zzaVar;
            if (iBinder == null) {
                BaseGmsClient.this.zza(16);
                return;
            }
            synchronized (BaseGmsClient.this.zzq) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                if (iBinder == null) {
                    zzaVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    zzaVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGmsServiceBroker)) ? new IGmsServiceBroker.Stub.zza(iBinder) : (IGmsServiceBroker) iInterfaceQueryLocalInterface;
                }
                baseGmsClient.zzr = zzaVar;
            }
            BaseGmsClient.this.zza(0, (Bundle) null, this.zza);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.zzq) {
                BaseGmsClient.this.zzr = null;
            }
            Handler handler = BaseGmsClient.this.zza;
            handler.sendMessage(handler.obtainMessage(6, this.zza, 1));
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    @VisibleForTesting
    public static final class zze extends IGmsCallbacks.zza {
        private BaseGmsClient zza;
        private final int zzb;

        public zze(BaseGmsClient baseGmsClient, int i) {
            this.zza = baseGmsClient;
            this.zzb = i;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
            Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zza.onPostInitHandler(i, iBinder, bundle, this.zzb);
            this.zza = null;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void zza(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void zza(int i, IBinder iBinder, com.google.android.gms.common.internal.zzc zzcVar) {
            Preconditions.checkNotNull(this.zza, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(zzcVar);
            this.zza.zza(zzcVar);
            onPostInitComplete(i, iBinder, zzcVar.zza);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @KeepForSdk
    protected BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
        Preconditions.checkNotNull(baseConnectionCallbacks);
        Preconditions.checkNotNull(baseOnConnectionFailedListener);
        this(context, looper, gmsClientSupervisor, googleApiAvailabilityLight, i, baseConnectionCallbacks, baseOnConnectionFailedListener, str);
    }

    private final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    private final boolean zzb() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc() {
        if (this.zzab || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int iIsGooglePlayServicesAvailable = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
        if (iIsGooglePlayServicesAvailable == 0) {
            connect(new LegacyClientCallbackAdapter());
        } else {
            zza(1, (IInterface) null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), iIsGooglePlayServicesAvailable, null);
        }
    }

    @KeepForSdk
    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzb = connectionProgressReportCallbacks;
        zza(2, (IInterface) null);
    }

    @KeepForSdk
    protected abstract T createServiceInterface(IBinder iBinder);

    @KeepForSdk
    public void disconnect(String str) {
        this.zzj = str;
        disconnect();
    }

    @KeepForSdk
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzp) {
            i = this.zzv;
            t = this.zzs;
        }
        synchronized (this.zzq) {
            iGmsServiceBroker = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzg > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.zzg;
            String str2 = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(str2);
            printWriterAppend.println(sb.toString());
        }
        if (this.zzf > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.zze;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i2 != 3) {
                printWriter.append((CharSequence) String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzf;
            String str3 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(str3);
            printWriterAppend2.println(sb2.toString());
        }
        if (this.zzi > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzh));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzi;
            String str4 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(str4).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(str4);
            printWriterAppend3.println(sb3.toString());
        }
    }

    @KeepForSdk
    protected boolean enableLocalFallback() {
        return false;
    }

    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @KeepForSdk
    public Feature[] getApiFeatures() {
        return zzd;
    }

    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        com.google.android.gms.common.internal.zzc zzcVar = this.zzac;
        if (zzcVar == null) {
            return null;
        }
        return zzcVar.zzb;
    }

    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    @KeepForSdk
    public final Context getContext() {
        return this.zzl;
    }

    @KeepForSdk
    public String getEndpointPackageName() {
        zzk zzkVar;
        if (!isConnected() || (zzkVar = this.zzk) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return zzkVar.zzb();
    }

    @KeepForSdk
    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @KeepForSdk
    public String getLastDisconnectMessage() {
        return this.zzj;
    }

    @KeepForSdk
    protected String getLocalStartServiceAction() {
        return null;
    }

    @KeepForSdk
    public final Looper getLooper() {
        return this.zzm;
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @KeepForSdk
    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzy);
        getServiceRequest.zza = this.zzl.getPackageName();
        getServiceRequest.zzd = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzc = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            getServiceRequest.zze = getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
            if (iAccountAccessor != null) {
                getServiceRequest.zzb = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zze = getAccount();
        }
        getServiceRequest.zzf = zzd;
        getServiceRequest.zzg = getApiFeatures();
        try {
            synchronized (this.zzq) {
                if (this.zzr != null) {
                    this.zzr.getService(new zze(this, this.zzc.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            triggerConnectionSuspended(3);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzc.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzc.get());
        }
    }

    @KeepForSdk
    protected Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    @KeepForSdk
    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.zzp) {
            if (this.zzv == 5) {
                throw new DeadObjectException();
            }
            checkConnected();
            Preconditions.checkState(this.zzs != null, "Client is connected but service is null");
            t = this.zzs;
        }
        return t;
    }

    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            if (this.zzr == null) {
                return null;
            }
            return this.zzr.asBinder();
        }
    }

    @KeepForSdk
    protected abstract String getServiceDescriptor();

    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @KeepForSdk
    protected abstract String getStartServiceAction();

    @KeepForSdk
    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @KeepForSdk
    protected boolean getUseDynamicLookup() {
        return false;
    }

    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 2 || this.zzv == 3;
        }
        return z;
    }

    @KeepForSdk
    protected void onConnectedLocked(T t) {
        this.zzg = System.currentTimeMillis();
    }

    @KeepForSdk
    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzh = connectionResult.getErrorCode();
        this.zzi = System.currentTimeMillis();
    }

    @KeepForSdk
    protected void onConnectionSuspended(int i) {
        this.zze = i;
        this.zzf = System.currentTimeMillis();
    }

    @KeepForSdk
    protected void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
    }

    @KeepForSdk
    void onSetConnectState(int i, T t) {
    }

    @KeepForSdk
    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(6, this.zzc.get(), i));
    }

    @VisibleForTesting
    @KeepForSdk
    protected void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzb = connectionProgressReportCallbacks;
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(3, this.zzc.get(), i, pendingIntent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(com.google.android.gms.common.internal.zzc zzcVar) {
        this.zzac = zzcVar;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    protected final class zzf extends zza {
        private final IBinder zza;

        public zzf(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zza = iBinder;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        protected final void zza(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        protected final boolean zza() {
            try {
                String interfaceDescriptor = this.zza.getInterfaceDescriptor();
                if (!BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String serviceDescriptor = BaseGmsClient.this.getServiceDescriptor();
                    StringBuilder sb = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(serviceDescriptor);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface iInterfaceCreateServiceInterface = BaseGmsClient.this.createServiceInterface(this.zza);
                if (iInterfaceCreateServiceInterface == null || !(BaseGmsClient.this.zza(2, 4, iInterfaceCreateServiceInterface) || BaseGmsClient.this.zza(3, 4, iInterfaceCreateServiceInterface))) {
                    return false;
                }
                BaseGmsClient.this.zzaa = null;
                Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                if (BaseGmsClient.this.zzw == null) {
                    return true;
                }
                BaseGmsClient.this.zzw.onConnected(connectionHint);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i, T t) {
        zzk zzkVar;
        Preconditions.checkArgument((i == 4) == (t != null));
        synchronized (this.zzp) {
            this.zzv = i;
            this.zzs = t;
            onSetConnectState(i, t);
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (this.zzu != null && this.zzk != null) {
                        String strZza = this.zzk.zza();
                        String strZzb = this.zzk.zzb();
                        StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 70 + String.valueOf(strZzb).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(strZza);
                        sb.append(" on ");
                        sb.append(strZzb);
                        Log.e("GmsClient", sb.toString());
                        this.zzn.zza(this.zzk.zza(), this.zzk.zzb(), this.zzk.zzc(), this.zzu, zza(), this.zzk.zzd());
                        this.zzc.incrementAndGet();
                    }
                    this.zzu = new zzd(this.zzc.get());
                    if (this.zzv == 3 && getLocalStartServiceAction() != null) {
                        zzkVar = new zzk(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false);
                    } else {
                        zzkVar = new zzk(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup());
                    }
                    this.zzk = zzkVar;
                    if (this.zzk.zzd() && getMinApkVersion() < 17895000) {
                        String strValueOf = String.valueOf(this.zzk.zza());
                        throw new IllegalStateException(strValueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(strValueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                    }
                    if (!this.zzn.zza(new GmsClientSupervisor.zza(this.zzk.zza(), this.zzk.zzb(), this.zzk.zzc(), this.zzk.zzd()), this.zzu, zza())) {
                        String strZza2 = this.zzk.zza();
                        String strZzb2 = this.zzk.zzb();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(strZza2).length() + 34 + String.valueOf(strZzb2).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(strZza2);
                        sb2.append(" on ");
                        sb2.append(strZzb2);
                        Log.e("GmsClient", sb2.toString());
                        zza(16, (Bundle) null, this.zzc.get());
                    }
                } else if (i == 4) {
                    onConnectedLocked(t);
                }
            } else if (this.zzu != null) {
                this.zzn.zza(this.zzk.zza(), this.zzk.zzb(), this.zzk.zzc(), this.zzu, zza(), this.zzk.zzd());
                this.zzu = null;
            }
        }
    }

    @KeepForSdk
    public void disconnect() {
        this.zzc.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i = 0; i < size; i++) {
                this.zzt.get(i).zze();
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zza(1, (IInterface) null);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    protected final class zzg extends zza {
        public zzg(int i, Bundle bundle) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        protected final void zza(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.enableLocalFallback() && BaseGmsClient.this.zzc()) {
                BaseGmsClient.this.zza(16);
            } else {
                BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
            }
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        protected final boolean zza() {
            BaseGmsClient.this.zzb.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    @VisibleForTesting
    @KeepForSdk
    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzm = looper;
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zza = new zzb(looper);
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }

    @VisibleForTesting
    @KeepForSdk
    protected BaseGmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zza = handler;
        this.zzm = handler.getLooper();
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zza(int i, int i2, T t) {
        synchronized (this.zzp) {
            if (this.zzv != i) {
                return false;
            }
            zza(i2, t);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i) {
        int i2;
        if (zzb()) {
            i2 = 5;
            this.zzab = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(i2, this.zzc.get(), 16));
    }

    protected final void zza(int i, Bundle bundle, int i2) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(i, null)));
    }
}

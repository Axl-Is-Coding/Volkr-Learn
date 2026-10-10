package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class DynamiteModule {
    private static Boolean zza = null;
    private static zzk zzb = null;
    private static zzm zzc = null;
    private static String zzd = null;
    private static int zze = -1;
    private final Context zzi;
    private static final ThreadLocal<zza> zzf = new ThreadLocal<>();
    private static final VersionPolicy.zzb zzg = new com.google.android.gms.dynamite.zzb();

    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new com.google.android.gms.dynamite.zza();

    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzd();

    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzc();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzf();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzh();
    private static final VersionPolicy zzh = new zzg();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    @KeepForSdk
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, com.google.android.gms.dynamite.zzb zzbVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, com.google.android.gms.dynamite.zzb zzbVar) {
            this(str, th);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public interface VersionPolicy {

        /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
        public static class zza {
            public int zza = 0;
            public int zzb = 0;
            public int zzc = 0;
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
        public interface zzb {
            int zza(Context context, String str);

            int zza(Context context, String str, boolean z) throws LoadingException;
        }

        zza zza(Context context, String str, zzb zzbVar) throws LoadingException;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    private static class zza {
        public Cursor zza;

        private zza() {
        }

        /* synthetic */ zza(com.google.android.gms.dynamite.zzb zzbVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    private static class zzb implements VersionPolicy.zzb {
        private final int zza;
        private final int zzb = 0;

        public zzb(int i, int i2) {
            this.zza = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        public final int zza(Context context, String str) {
            return this.zza;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
        public final int zza(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzi = context;
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(sb.toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String strValueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(strValueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String strValueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", strValueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(strValueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    @KeepForSdk
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        zza zzaVar = zzf.get();
        com.google.android.gms.dynamite.zzb zzbVar = null;
        zza zzaVar2 = new zza(zzbVar);
        zzf.set(zzaVar2);
        try {
            VersionPolicy.zza zzaVarZza = versionPolicy.zza(context, str, zzg);
            int i = zzaVarZza.zza;
            int i2 = zzaVarZza.zzb;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            Log.i("DynamiteModule", sb.toString());
            if (zzaVarZza.zzc == 0 || ((zzaVarZza.zzc == -1 && zzaVarZza.zza == 0) || (zzaVarZza.zzc == 1 && zzaVarZza.zzb == 0))) {
                int i3 = zzaVarZza.zza;
                int i4 = zzaVarZza.zzb;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i3);
                sb2.append(" and remote version is ");
                sb2.append(i4);
                sb2.append(Consts.DOT);
                throw new LoadingException(sb2.toString(), zzbVar);
            }
            if (zzaVarZza.zzc == -1) {
                DynamiteModule dynamiteModuleZza = zza(context, str);
                Cursor cursor = zzaVar2.zza;
                if (cursor != null) {
                    cursor.close();
                }
                zzf.set(zzaVar);
                return dynamiteModuleZza;
            }
            if (zzaVarZza.zzc != 1) {
                int i5 = zzaVarZza.zzc;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i5);
                throw new LoadingException(sb3.toString(), zzbVar);
            }
            try {
                DynamiteModule dynamiteModuleZza2 = zza(context, str, zzaVarZza.zzb);
                Cursor cursor2 = zzaVar2.zza;
                if (cursor2 != null) {
                    cursor2.close();
                }
                zzf.set(zzaVar);
                return dynamiteModuleZza2;
            } catch (LoadingException e2) {
                String strValueOf = String.valueOf(e2.getMessage());
                Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to load remote module: ".concat(strValueOf) : new String("Failed to load remote module: "));
                if (zzaVarZza.zza == 0 || versionPolicy.zza(context, str, new zzb(zzaVarZza.zza, 0)).zzc != -1) {
                    throw new LoadingException("Remote load failed. No local fallback found.", e2, zzbVar);
                }
                DynamiteModule dynamiteModuleZza3 = zza(context, str);
                Cursor cursor3 = zzaVar2.zza;
                if (cursor3 != null) {
                    cursor3.close();
                }
                zzf.set(zzaVar);
                return dynamiteModuleZza3;
            }
        } catch (Throwable th) {
            Cursor cursor4 = zzaVar2.zza;
            if (cursor4 != null) {
                cursor4.close();
            }
            zzf.set(zzaVar);
            throw th;
        }
    }

    public static int zza(Context context, String str, boolean z) {
        Field declaredField;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zza;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String strValueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(strValueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    zza(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int iZzc = zzc(context, str, z);
                                if (zzd != null && !zzd.isEmpty()) {
                                    ClassLoader delegateLastClassLoader = Build.VERSION.SDK_INT >= 29 ? new DelegateLastClassLoader(zzd, ClassLoader.getSystemClassLoader()) : new zzi(zzd, ClassLoader.getSystemClassLoader());
                                    zza(delegateLastClassLoader);
                                    declaredField.set(null, delegateLastClassLoader);
                                    zza = Boolean.TRUE;
                                    return iZzc;
                                }
                                return iZzc;
                            } catch (LoadingException unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        zza = bool;
                    }
                }
                if (!bool.booleanValue()) {
                    return zzb(context, str, z);
                }
                try {
                    return zzc(context, str, z);
                } catch (LoadingException e3) {
                    String strValueOf2 = String.valueOf(e3.getMessage());
                    Log.w("DynamiteModule", strValueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf2) : new String("Failed to retrieve remote module version: "));
                    return 0;
                }
            }
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw th;
        }
    }

    private static int zzb(Context context, String str, boolean z) {
        zzk zzkVarZza = zza(context);
        if (zzkVarZza == null) {
            return 0;
        }
        try {
            if (zzkVarZza.zzb() >= 2) {
                return zzkVarZza.zzb(ObjectWrapper.wrap(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return zzkVarZza.zza(ObjectWrapper.wrap(context), str, z);
        } catch (RemoteException e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int zzc(android.content.Context r8, java.lang.String r9, boolean r10) throws java.lang.Throwable {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            int r10 = r8.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r8 == 0) goto L83
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 == 0) goto L83
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 <= 0) goto L7d
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.dynamite.DynamiteModule.zzd = r1     // Catch: java.lang.Throwable -> L7a
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L7a
            if (r1 < 0) goto L67
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.dynamite.DynamiteModule.zze = r1     // Catch: java.lang.Throwable -> L7a
        L67:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7a
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r10 = com.google.android.gms.dynamite.DynamiteModule.zzf     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$zza r10 = (com.google.android.gms.dynamite.DynamiteModule.zza) r10     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r10 == 0) goto L7d
            android.database.Cursor r1 = r10.zza     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r1 != 0) goto L7d
            r10.zza = r8     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r8 = r0
            goto L7d
        L7a:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7a
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L7d:
            if (r8 == 0) goto L82
            r8.close()
        L82:
            return r9
        L83:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L92:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lae
        L96:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L9f
        L9b:
            r8 = move-exception
            goto Lae
        L9d:
            r8 = move-exception
            r9 = r0
        L9f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto La4
            throw r8     // Catch: java.lang.Throwable -> Lac
        La4:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lac
            throw r10     // Catch: java.lang.Throwable -> Lac
        Lac:
            r8 = move-exception
            r0 = r9
        Lae:
            if (r0 == 0) goto Lb3
            r0.close()
        Lb3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean):int");
    }

    @KeepForSdk
    public final Context getModuleContext() {
        return this.zzi;
    }

    @KeepForSdk
    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzi.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String strValueOf = String.valueOf(str);
            throw new LoadingException(strValueOf.length() != 0 ? "Failed to instantiate module class: ".concat(strValueOf) : new String("Failed to instantiate module class: "), e2, null);
        }
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws RemoteException, LoadingException {
        zzm zzmVar;
        IObjectWrapper iObjectWrapperZza;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzmVar = zzc;
        }
        com.google.android.gms.dynamite.zzb zzbVar = null;
        if (zzmVar != null) {
            zza zzaVar = zzf.get();
            if (zzaVar != null && zzaVar.zza != null) {
                Context applicationContext = context.getApplicationContext();
                Cursor cursor = zzaVar.zza;
                ObjectWrapper.wrap(null);
                if (zza().booleanValue()) {
                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                    iObjectWrapperZza = zzmVar.zzb(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
                } else {
                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                    iObjectWrapperZza = zzmVar.zza(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
                }
                Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapperZza);
                if (context2 != null) {
                    return new DynamiteModule(context2);
                }
                throw new LoadingException("Failed to get module context", zzbVar);
            }
            throw new LoadingException("No result cursor", zzbVar);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", zzbVar);
    }

    private static DynamiteModule zza(Context context, String str) {
        String strValueOf = String.valueOf(str);
        Log.i("DynamiteModule", strValueOf.length() != 0 ? "Selected local version of ".concat(strValueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule zza(Context context, String str, int i) throws LoadingException {
        Boolean bool;
        IObjectWrapper iObjectWrapperZza;
        com.google.android.gms.dynamite.zzb zzbVar = null;
        try {
            synchronized (DynamiteModule.class) {
                bool = zza;
            }
            if (bool != null) {
                if (bool.booleanValue()) {
                    return zzb(context, str, i);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i);
                Log.i("DynamiteModule", sb.toString());
                zzk zzkVarZza = zza(context);
                if (zzkVarZza != null) {
                    if (zzkVarZza.zzb() >= 2) {
                        iObjectWrapperZza = zzkVarZza.zzb(ObjectWrapper.wrap(context), str, i);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        iObjectWrapperZza = zzkVarZza.zza(ObjectWrapper.wrap(context), str, i);
                    }
                    if (ObjectWrapper.unwrap(iObjectWrapperZza) != null) {
                        return new DynamiteModule((Context) ObjectWrapper.unwrap(iObjectWrapperZza));
                    }
                    throw new LoadingException("Failed to load remote module.", zzbVar);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", zzbVar);
            }
            throw new LoadingException("Failed to determine which loading route to use.", zzbVar);
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, zzbVar);
        } catch (LoadingException e3) {
            throw e3;
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw new LoadingException("Failed to load remote module.", th, zzbVar);
        }
    }

    private static zzk zza(Context context) {
        zzk zzjVar;
        synchronized (DynamiteModule.class) {
            if (zzb != null) {
                return zzb;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzjVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (iInterfaceQueryLocalInterface instanceof zzk) {
                        zzjVar = (zzk) iInterfaceQueryLocalInterface;
                    } else {
                        zzjVar = new zzj(iBinder);
                    }
                }
                if (zzjVar != null) {
                    zzb = zzjVar;
                    return zzjVar;
                }
            } catch (Exception e2) {
                String strValueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(strValueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    private static Boolean zza() {
        Boolean boolValueOf;
        synchronized (DynamiteModule.class) {
            boolValueOf = Boolean.valueOf(zze >= 2);
        }
        return boolValueOf;
    }

    private static void zza(ClassLoader classLoader) throws LoadingException {
        zzm zzlVar;
        com.google.android.gms.dynamite.zzb zzbVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzlVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (iInterfaceQueryLocalInterface instanceof zzm) {
                    zzlVar = (zzm) iInterfaceQueryLocalInterface;
                } else {
                    zzlVar = new zzl(iBinder);
                }
            }
            zzc = zzlVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, zzbVar);
        }
    }
}

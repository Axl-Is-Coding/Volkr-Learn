package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.web.http.HttpCode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zztu {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz<zza, C0119zza> implements zzell {
        private static final zza zzbvz;
        private static volatile zzelw<zza> zzel;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zztu$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class C0119zza extends zzejz.zzb<zza, C0119zza> implements zzell {
            private C0119zza() {
                super(zza.zzbvz);
            }

            /* synthetic */ C0119zza(zztt zzttVar) {
                this();
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public enum zzb implements zzeke {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_FAILED_TO_LOAD_INVALID_REQUEST(100),
            AD_FAILED_TO_LOAD_NETWORK_ERROR(101),
            AD_FAILED_TO_LOAD_TIMEOUT(102),
            AD_FAILED_TO_LOAD_CANCELLED(103),
            AD_FAILED_TO_LOAD_NO_ERROR(104),
            AD_FAILED_TO_LOAD_NOT_FOUND(105),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(IntConstant.PERMISSION_STORAGE_DOWNLOAD),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(1004),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(HttpCode.PASSWORD_NOT_SET),
            REQUEST_FAILED_TO_RENDER(HttpCode.THIRD_PART_ACCOUNT_ALREADY_BIND_OTHER_USER),
            REQUEST_IS_PREFETCH(1100),
            REQUEST_SAVED_TO_CACHE(1101),
            REQUEST_LOADED_FROM_CACHE(1102),
            REQUEST_PREFETCH_INTERCEPTED(1103),
            REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED(1104),
            REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED(1105),
            NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED(1106),
            NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED(1107),
            REQUEST_FAILED_TO_LOAD_FROM_CACHE(1108),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(10001),
            ANDROID_WEBVIEW_CRASH(com.sandboxol.common.config.HttpCode.UN_KNOW),
            OFFLINE_UPLOAD(10003),
            DELAY_PAGE_LOAD_CANCELLED_AD(10004);

            private static final zzekd<zzb> zzes = new zztv();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.ads.zzeke
            public final int zzv() {
                return this.value;
            }
        }

        static {
            zza zzaVar = new zza();
            zzbvz = zzaVar;
            zzejz.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zztt zzttVar = null;
            switch (zztt.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0119zza(zzttVar);
                case 3:
                    return zzejz.zza(zzbvz, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbvz;
                case 5:
                    zzelw<zza> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzbvz);
                                zzel = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}

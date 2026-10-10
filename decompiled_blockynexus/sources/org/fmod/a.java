package org.fmod;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MediaCodec.java */
/* JADX INFO: loaded from: classes5.dex */
class a implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaCodec f23548a;

    a(MediaCodec mediaCodec) {
        this.f23548a = mediaCodec;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getName().equals("readAt")) {
            return Integer.valueOf(MediaCodec.fmodReadAt(this.f23548a.mCodecPtr, ((Long) objArr[0]).longValue(), (byte[]) objArr[1], 0, ((Integer) objArr[2]).intValue()));
        }
        if (method.getName().equals("getSize")) {
            return Long.valueOf(MediaCodec.fmodGetSize(this.f23548a.mCodecPtr));
        }
        if (method.getName().equals("close")) {
            return null;
        }
        Log.w("fmod", "MediaCodec::DataSource::invoke : Unrecognised method found: " + method.getName());
        return null;
    }
}

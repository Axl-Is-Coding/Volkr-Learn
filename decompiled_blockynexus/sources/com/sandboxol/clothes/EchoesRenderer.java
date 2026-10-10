package com.sandboxol.clothes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.sandboxol.clothes.BlockGLSurfaceView;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes3.dex */
public class EchoesRenderer implements BlockGLSurfaceView.Renderer {
    private GL10 gl10;
    private Context mContext;
    private EchoesHandler mMainHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean m_bInitOK;
    private int mWidth = 0;
    private int mHeight = 0;

    static {
        com.getkeepsafe.relinker.b.a(BaseApplication.getContext(), "c++_shared");
        com.getkeepsafe.relinker.b.a(BaseApplication.getContext(), "ClothesPreview");
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public EchoesRenderer(Context context) {
        this.mContext = context;
        EchoesHelper.init(context);
    }

    private static native void nativeAddActorDisplay(String str);

    private static native void nativeChangeAction(int i);

    private static native void nativeChangeActorSize(float f2, float f3);

    private static native int nativeChangeBackgroundImage(String str);

    private static native int nativeChangeDefaultIdle(int i);

    private static native int nativeChangeDefaultIdleOtherPlayer(int i, String str);

    private static native void nativeChangeMode(int i, int i2);

    private static native void nativeChangeName(String str);

    private static native void nativeChangeOnGameState(String str, boolean z);

    private static native void nativeChangeParts(String str, String str2);

    private static native void nativeChangePartsOtherPlayer(String str, String str2, String str3);

    private static native void nativeChangePartyOwner(String str);

    private static native int nativeChangePosition(float f2, float f3, float f4);

    private static native void nativeChangeSex(int i);

    private static native void nativeChangeSexOtherPlayer(int i, String str);

    private static native void nativeChangeSkinColor(float f2, float f3, float f4, float f5);

    private static native void nativeChangeSkinColorOtherPlayer(float f2, float f3, float f4, float f5, String str);

    private static native void nativeChangeVipLevel(int i);

    private static native void nativeChangeVipLevelOtherPlayer(int i, String str);

    private static native void nativeChat(String str, String str2);

    private static native void nativeCheckResource(int i, String str, String str2);

    public static native int nativeCheckVersion(String str);

    private static native void nativeDeleteActorDisplay(String str);

    public static native int nativeGetCurrentDownloadSize();

    public static native float nativeGetDownloadPercent();

    public static native int nativeGetDownloadState();

    public static native String nativeGetLocalVersion();

    public static native String nativeGetServerVersion();

    public static native int nativeGetTotalDownloadSize();

    public static native void nativeInit(String str, String str2, int i, int i2, int i3);

    private static native boolean nativeKeyDown(int i);

    private static native void nativeOnDestroy();

    private static native void nativeOnGetPhoneType(String str);

    private static native void nativeOnPause();

    private static native void nativeOnResume();

    private static native void nativeOnSurfaceChanged(int i, int i2);

    private static native void nativeReloadActor();

    private static native void nativeRender();

    private static native void nativeTouchesBegin(int i, float f2, float f3);

    private static native void nativeTouchesCancel(int[] iArr, float[] fArr, float[] fArr2);

    private static native void nativeTouchesEnd(int i, float f2, float f3);

    private static native void nativeTouchesMove(int[] iArr, float[] fArr, float[] fArr2);

    public static native int nativeUpdateFiles();

    public void SetMainHandler(EchoesHandler echoesHandler) {
        this.mMainHandler = echoesHandler;
    }

    public /* synthetic */ void a() {
        Log.w("InitClothes", "opengl invalid. " + ((Activity) this.mContext).getLocalClassName() + " finish.");
        ReportDataAdapter.onEvent(this.mContext, "opengl_context_not_valid", "initClothes");
        ((Activity) this.mContext).finish();
    }

    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public void handleActionCancel(int[] iArr, float[] fArr, float[] fArr2) {
        nativeTouchesCancel(iArr, fArr, fArr2);
    }

    public void handleActionDown(int i, float f2, float f3) {
        nativeTouchesBegin(i, f2, f3);
    }

    public void handleActionMove(int[] iArr, float[] fArr, float[] fArr2) {
        nativeTouchesMove(iArr, fArr, fArr2);
    }

    public void handleActionUp(int i, float f2, float f3) {
        nativeTouchesEnd(i, f2, f3);
    }

    public void handleAddActorDisplay(String str) {
        nativeAddActorDisplay(str);
    }

    public void handleChangeAction(int i) {
        nativeChangeAction(i);
    }

    public void handleChangeActorSize(float f2, float f3) {
        nativeChangeActorSize(f2, f3);
    }

    public void handleChangeBackgroundImage(String str) {
        nativeChangeBackgroundImage(str);
    }

    public void handleChangeDefaultIdle(int i) {
        nativeChangeDefaultIdle(i);
    }

    public void handleChangeMode(int i, int i2) {
        nativeChangeMode(i, i2);
    }

    public void handleChangeName(String str) {
        nativeChangeName(str);
    }

    public void handleChangeOnGameState(String str, boolean z) {
        nativeChangeOnGameState(str, z);
    }

    public void handleChangeParts(String str, String str2) {
        nativeChangeParts(str, str2);
    }

    public void handleChangePartsOtherPlayer(String str, String str2, String str3) {
        nativeChangePartsOtherPlayer(str, str2, str3);
    }

    public void handleChangePartyOwner(String str) {
        nativeChangePartyOwner(str);
    }

    public void handleChangePosition(float f2, float f3, float f4) {
        nativeChangePosition(f2, f3, f4);
    }

    public void handleChangeSex(int i) {
        nativeChangeSex(i);
    }

    public void handleChangeSexOtherPlayer(int i, String str) {
        nativeChangeSexOtherPlayer(i, str);
    }

    public void handleChangeSkinColor(float f2, float f3, float f4, float f5) {
        nativeChangeSkinColor(f2, f3, f4, f5);
    }

    public void handleChangeSkinColorOtherPlayer(float f2, float f3, float f4, float f5, String str) {
        nativeChangeSkinColorOtherPlayer(f2, f3, f4, f5, str);
    }

    public void handleChangeVipLevel(int i) {
        nativeChangeVipLevel(i);
    }

    public void handleChangeVipLevelOtherPlayer(int i, String str) {
        nativeChangeVipLevelOtherPlayer(i, str);
    }

    public void handleChat(String str, String str2) {
        nativeChat(str, str2);
    }

    public void handleCheckResource(int i, String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        nativeCheckResource(i, str, str2);
    }

    public void handleDefaultIdleOtherPlayer(int i, String str) {
        nativeChangeDefaultIdleOtherPlayer(i, str);
    }

    public void handleDeleteActorDisplay(String str) {
        nativeDeleteActorDisplay(str);
    }

    public boolean handleInitGame(String str, String str2, int i, int i2, int i3) {
        try {
            if (!isGLValid() && !((Activity) this.mContext).isFinishing()) {
                ((Activity) this.mContext).runOnUiThread(new Runnable() { // from class: com.sandboxol.clothes.U
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16780a.a();
                    }
                });
                return false;
            }
            nativeInit(str, str2, i, i2, i3);
            this.mWidth = i;
            this.mHeight = i2;
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void handleKeyDown(int i) {
        nativeKeyDown(i);
    }

    public void handleOnDestroy() {
        nativeOnDestroy();
    }

    public void handleOnPause() {
        nativeOnPause();
    }

    public void handleOnResume() {
        nativeOnResume();
    }

    public void handleReloadActor() {
        nativeReloadActor();
    }

    public void handleSurfaceChanged(int i, int i2) {
        if (i != this.mWidth || this.mHeight != i2) {
            nativeOnSurfaceChanged(i, i2);
        }
        this.mWidth = i;
        this.mHeight = i2;
    }

    public boolean isGLValid() {
        GL10 gl10 = this.gl10;
        return (gl10 == null || gl10.glGetString(7938) == null) ? false : true;
    }

    public boolean isInitOk() {
        return this.m_bInitOK;
    }

    @Override // com.sandboxol.clothes.BlockGLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        try {
            this.gl10 = gl10;
            if (this.m_bInitOK) {
                nativeRender();
            }
        } catch (Exception unused) {
            System.out.println("gl thread exception");
        }
    }

    @Override // com.sandboxol.clothes.BlockGLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    @Override // com.sandboxol.clothes.BlockGLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.m_bInitOK = false;
        this.gl10 = gl10;
        if (this.mMainHandler != null) {
            Message message = new Message();
            message.what = 4;
            this.mMainHandler.sendMessage(message);
        }
    }

    public void setInitOK(boolean z) {
        this.m_bInitOK = z;
    }

    public void setScreenWidthAndHeight(int i, int i2) {
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
    }
}

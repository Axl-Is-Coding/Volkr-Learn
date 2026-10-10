package com.sandboxol.blockmango;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.os.Message;
import android.text.TextUtils;
import com.sandboxol.blockmango.EchoesHandler;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.game.AbstractEngineEnv;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.messager.MessagerClient;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class EchoesRenderer implements GLSurfaceView.Renderer {
    public static final int FRIEND_OPERATION_TYPE_AGREE_ADD_FRIEND = 3;
    public static final int FRIEND_OPERATION_TYPE_AGREE_ADD_FRIEND_FAILURE = 10000;
    public static final int FRIEND_OPERATION_TYPE_IS_FRIEND = 2;
    public static final int FRIEND_OPERATION_TYPE_NO_FRIEND = 1;
    public static final int FRIEND_OPERATION_TYPE_REQUEST_ADD_FRIEND = 4;
    public static final int FRIEND_OPERATION_TYPE_REQUEST_ADD_FRIEND_FAILURE = 10001;
    private static final String LOGTAG = "EchoesRenderer";
    private GL10 gl10;
    private boolean isTakePicture;
    private LoadingDialog loadingDialog;
    private Context mContext;
    private EchoesHandler mMainHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean m_bInitOK;
    private boolean m_bIsUpdating;
    private String picResUrlOrPath;
    boolean mIsActive = false;
    private int mWidth = 0;
    private int mHeight = 0;
    private AbstractEngineEnv engineEnv = EngineEnv.getInstance(EngineEnv.getCurUseEngineTypeInGame());

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public EchoesRenderer(final Context context) {
        this.mContext = context;
        MessagerClient.getIns().registerMsg1(EchoesRenderer.class, GameMessageToken.TOKEN_GAME_SCREEN_SHOT, new com.sandboxol.messager.a.b() { // from class: com.sandboxol.blockmango.Wa
            @Override // com.sandboxol.messager.a.b
            public final void onCall(com.sandboxol.messager.a.f fVar) {
                this.f16136a.a(context, fVar);
            }
        });
    }

    private Bitmap createBitmapFromGLSurface(int i, int i2, int i3, int i4, GL10 gl10) {
        int i5 = i3 * i4;
        int[] iArr = new int[i5];
        int[] iArr2 = new int[i5];
        IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
        intBufferWrap.position(0);
        try {
            gl10.glReadPixels(i, i2, i3, i4, 6408, 5121, intBufferWrap);
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = i6 * i3;
                int i8 = ((i4 - i6) - 1) * i3;
                for (int i9 = 0; i9 < i3; i9++) {
                    int i10 = iArr[i7 + i9];
                    iArr2[i8 + i9] = (i10 & (-16711936)) | ((i10 << 16) & 16711680) | ((i10 >> 16) & 255);
                }
            }
            return Bitmap.createBitmap(iArr2, i3, i4, Bitmap.Config.ARGB_8888);
        } catch (GLException unused) {
            return null;
        }
    }

    public static native int getPing();

    private static native void nativeBuyActionResult(int i, int i2);

    public static native int nativeCheckVersion(String str);

    private static native void nativeConnectServer(String str, int i, String str2);

    private static native void nativeExitGame();

    public static native int nativeGetCurrentDownloadSize();

    public static native float nativeGetDownloadPercent();

    public static native int nativeGetDownloadState();

    public static native int nativeGetFps();

    public static native String nativeGetLocalVersion();

    public static native int nativeGetRaknetPing();

    public static native String nativeGetServerVersion();

    public static native int nativeGetTotalDownloadSize();

    public static native void nativeHideRechargeBtn();

    public static native void nativeInit(float f2, String str, String str2, String str3, int i, int i2);

    public static native void nativeInitGame(float f2, String str, long j, String str2, String str3, int i, long j2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, int i3, String str11, boolean z, boolean z2);

    public static native void nativeInitGame(float f2, String str, long j, String str2, String str3, int i, long j2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i2, int i3, int i4, int i5, int i6, String str13);

    private static native boolean nativeKeyDown(int i);

    private static native boolean nativeKeyUp(int i);

    public static native void nativeOnCloseAd(int i);

    public static native void nativeOnDestroy();

    private static native void nativeOnFriendOperationForAppHttpResult(int i, long j);

    public static native void nativeOnGameActionTrigger(int i, String str);

    private static native void nativeOnGetPhoneType(String str);

    private static native void nativeOnPause();

    public static native void nativeOnRechargeResult(int i, int i2);

    private static native void nativeOnResetGameResult(int i);

    private static native void nativeOnResume();

    private static native void nativeOnSurfaceChanged(int i, int i2);

    private static native void nativeOnVoiceOperationResult(int i, int i2, String str);

    public static native void nativeOnWatchAdResult(int i, String str, int i2);

    public static native void nativeOnWatchAdSuccess(int i);

    private static native void nativeRender();

    private static native void nativeSetUserInfo(String str, String str2, long j);

    public static native void nativeStartLocalServer(String str);

    private static native void nativeTouchesBegin(int i, float f2, float f3);

    private static native void nativeTouchesCancel(int[] iArr, float[] fArr, float[] fArr2);

    private static native void nativeTouchesEnd(int i, float f2, float f3);

    private static native void nativeTouchesMove(int[] iArr, float[] fArr, float[] fArr2);

    public static native int nativeUpdateFiles();

    public static native void nativeUseProp(String str);

    public void SetMainHandler(EchoesHandler echoesHandler) {
        this.mMainHandler = echoesHandler;
    }

    public /* synthetic */ void a(final Context context, com.sandboxol.messager.a.f fVar) {
        this.isTakePicture = true;
        this.picResUrlOrPath = fVar.c(StringConstant.KEY_SCREEN_SHOT_SHOW_URL_OR_PATH);
        if (this.loadingDialog == null) {
            Context context2 = this.mContext;
            if (context2 instanceof Activity) {
                ((Activity) context2).runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.Va
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16130a.a(context);
                    }
                });
            }
        }
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

    public void handleBuyActionResult(int i, int i2) {
        nativeBuyActionResult(i, i2);
    }

    public void handleCloseAd(int i) {
        nativeOnCloseAd(i);
    }

    public void handleConnectServer(String str, int i, String str2) {
        nativeConnectServer(str, i, str2);
    }

    public void handleExitGame() {
        nativeExitGame();
    }

    public void handleGameActionTrigger(int i, String str) {
        nativeOnGameActionTrigger(i, str);
    }

    public void handleHideRechargeBtn() {
        nativeHideRechargeBtn();
    }

    public void handleInitGame(float f2, String str, String str2, String str3, int i, int i2) {
        nativeInit(f2, str, str2, str3, i, i2);
        nativeOnGetPhoneType(b.h.b.a.n.a());
    }

    public void handleInitLocalServer(String str) {
        nativeStartLocalServer(str);
    }

    public void handleKeyDown(int i) {
        nativeKeyDown(i);
    }

    public void handleKeyUp(int i) {
        nativeKeyUp(i);
    }

    public void handleNativeSetUserInfo(String str, String str2, long j) {
        nativeSetUserInfo(str, str2, j);
    }

    public void handleOnDestroy() {
        nativeOnDestroy();
    }

    public void handleOnFriendOperationForAppHttpResult(int i, long j) {
        nativeOnFriendOperationForAppHttpResult(i, j);
    }

    public void handleOnNativeResetGameResult(int i) {
        nativeOnResetGameResult(i);
    }

    public void handleOnPause() {
        nativeOnPause();
    }

    public void handleOnResume() {
        nativeOnResume();
    }

    public void handleRechargeResult(int i, int i2) {
        nativeOnRechargeResult(i, i2);
    }

    public void handleSurfaceChanged(int i, int i2) {
        if (i != this.mWidth && this.mHeight != i2) {
            nativeOnSurfaceChanged(i, i2);
        }
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void handleUseProp(String str) {
        nativeUseProp(str);
    }

    public void handleVoiceOperationResult(int i, int i2, String str) {
        nativeOnVoiceOperationResult(i, i2, str);
    }

    public void handleWatchAdResult(int i, String str, int i2) {
        nativeOnWatchAdResult(i, str, i2);
    }

    public void handleWatchAdSuccess(int i) {
        nativeOnWatchAdSuccess(i);
    }

    public boolean isGLValid() {
        GL10 gl10 = this.gl10;
        return (gl10 == null || gl10.glGetString(7938) == null) ? false : true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        this.gl10 = gl10;
        try {
            if (this.m_bIsUpdating) {
                Message message = new Message();
                message.what = 7;
                message.obj = new EchoesHandler.UpdateDownloadMessage((int) (nativeGetDownloadPercent() * 100.0f), 100, nativeGetDownloadState());
                this.mMainHandler.sendMessage(message);
            }
            if (this.m_bInitOK) {
                nativeRender();
            }
            if (this.isTakePicture) {
                this.isTakePicture = false;
                CaptureBitmapHelper.captureBitmap(this.mContext, TextUtils.isEmpty(this.picResUrlOrPath) ? ShotScreenUtils.getShotScreenBitmap(gl10, this.mScreenWidth, this.mScreenHeight) : ShotScreenUtils.res2bitmap(this.picResUrlOrPath), this.picResUrlOrPath, new Action0() { // from class: com.sandboxol.blockmango.Ua
                    @Override // rx.functions.Action0
                    public final void call() {
                        this.f16124a.a();
                    }
                });
            }
        } catch (Exception unused) {
            System.out.println("gl thread exception");
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.m_bInitOK = false;
        this.m_bIsUpdating = false;
        this.gl10 = gl10;
        Message message = new Message();
        message.what = 6;
        this.mMainHandler.sendMessage(message);
    }

    public void releaseRes() {
        Messenger.getDefault().unregister(this);
    }

    public void setInitOK(boolean z) {
        this.m_bInitOK = z;
    }

    public void setScreenWidthAndHeight(int i, int i2) {
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
    }

    public void setUpdatingFlag(boolean z) {
        this.m_bIsUpdating = z;
    }

    public void handleInitGame(float f2, String str, long j, String str2, String str3, long j2, String str4, String str5, String str6, String str7, int i, int i2, String str8, int i3, boolean z, boolean z2, String str9) {
        String str10;
        int iIntValue;
        try {
            if (!isGLValid()) {
                EchoesHelper.onGameExit("offline");
                return;
            }
            if (TextUtils.isEmpty(str3)) {
                str10 = "";
                iIntValue = 0;
            } else {
                String[] strArrSplit = str3.split(":");
                String str11 = strArrSplit[0];
                iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
                str10 = str11;
            }
            String resRootPath = this.engineEnv.getResRootPath();
            String configPath = this.engineEnv.getConfigPath();
            String mapRootPath = this.engineEnv.getMapRootPath();
            String mapTempRootPath = this.engineEnv.getMapTempRootPath();
            if (this.engineEnv.getType() == 1) {
                nativeInitGame(f2, str, j, str2, str10, iIntValue, j2, str4, str5, str6, str7, resRootPath, configPath, mapRootPath, i, i2, str8, z, z2);
            } else {
                nativeInitGame(f2, str, j, str2, str10, iIntValue, j2, str4, str5, str6, str7, resRootPath, this.engineEnv.getRescachePath(), configPath, mapRootPath, mapTempRootPath, i, i2, z2 ? 1 : 0, i3, 0, str9);
            }
            nativeOnGetPhoneType(b.h.b.a.n.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(Context context) {
        this.loadingDialog = new LoadingDialog(context);
        this.loadingDialog.show();
    }

    public /* synthetic */ void a() {
        LoadingDialog loadingDialog = this.loadingDialog;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            this.loadingDialog = null;
        }
    }
}

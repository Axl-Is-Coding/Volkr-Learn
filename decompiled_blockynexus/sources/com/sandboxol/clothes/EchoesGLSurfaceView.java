package com.sandboxol.clothes;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/* JADX INFO: loaded from: classes3.dex */
public class EchoesGLSurfaceView extends BlockGLSurfaceView {
    public EchoesRenderer mEchoesRenderer;
    private EchoesHandler mMainHandler;

    private static final class SyncHelper {
        private static final SyncHelper instance = new SyncHelper();
        private Handler handler;

        private SyncHelper() {
            HandlerThread handlerThread = new HandlerThread("Handler-Clothes");
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void post(Runnable runnable) {
            this.handler.post(runnable);
        }
    }

    public EchoesGLSurfaceView(Context context) {
        super(context);
        initView();
    }

    private void addPost(Runnable runnable) {
        SyncHelper.instance.post(runnable);
    }

    public /* synthetic */ void a() {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleOnResume();
        }
    }

    public /* synthetic */ void b() {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleOnPause();
        }
    }

    public /* synthetic */ void c(int i, float f2, float f3) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleActionUp(i, f2, f3);
        }
    }

    public void changeAction(final int i) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f16816a.a(i);
            }
        });
    }

    public void changeActorSize(final float f2, final float f3) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.I
            @Override // java.lang.Runnable
            public final void run() {
                this.f16754a.a(f2, f3);
            }
        });
    }

    public void changeBackgroundImage(final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.G
            @Override // java.lang.Runnable
            public final void run() {
                this.f16750a.a(str);
            }
        });
    }

    public void changeChangeDefaultIdle(final int i) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f16805a.b(i);
            }
        });
    }

    public void changeChangeDefaultIdleOtherPlayer(final int i, final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f16831a.a(i, str);
            }
        });
    }

    public void changeName(final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f16826a.b(str);
            }
        });
    }

    public void changeOnGameState(final String str, final boolean z) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.P
            @Override // java.lang.Runnable
            public final void run() {
                this.f16773a.a(str, z);
            }
        });
    }

    public void changeParts(final String str, final String str2) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f16835a.a(str, str2);
            }
        });
    }

    public void changePartsOtherPlayer(final String str, final String str2, final String str3) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f16843a.a(str, str2, str3);
            }
        });
    }

    public void changePosition(final float f2, final float f3, final float f4) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f16801a.a(f2, f3, f4);
            }
        });
    }

    public void changeSex(final int i) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.S
            @Override // java.lang.Runnable
            public final void run() {
                this.f16777a.c(i);
            }
        });
    }

    public void changeSexOtherPlayer(final int i, final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f16807a.b(i, str);
            }
        });
    }

    public void changeSkinColor(final float f2, final float f3, final float f4, final float f5) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f16796a.a(f2, f3, f4, f5);
            }
        });
    }

    public void changeSkinColorOtherPlayer(final float f2, final float f3, final float f4, final float f5, final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f16781a.a(f2, f3, f4, f5, str);
            }
        });
    }

    public void changeSurface(final int i, final int i2) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f16851a.a(i, i2);
            }
        });
    }

    public void changeVipLevel(final int i) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f16838a.d(i);
            }
        });
    }

    public void changeVipLevelOtherPlayer(final int i, final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.N
            @Override // java.lang.Runnable
            public final void run() {
                this.f16768a.c(i, str);
            }
        });
    }

    public void checkResource(final int i, final String str, final String str2) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f16812a.a(i, str, str2);
            }
        });
    }

    public /* synthetic */ void d() {
        if (this.mEchoesRenderer != null) {
            this.mMainHandler.onDestroy();
            setMainHandler(null);
            this.mMainHandler = null;
            this.mEchoesRenderer = null;
        }
    }

    public /* synthetic */ void e(int i) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleKeyDown(i);
        }
    }

    public /* synthetic */ void f() {
        super.onPause();
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.M
            @Override // java.lang.Runnable
            public final void run() {
                this.f16767a.b();
            }
        });
    }

    public /* synthetic */ void g() {
        super.onResume();
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.T
            @Override // java.lang.Runnable
            public final void run() {
                this.f16779a.a();
            }
        });
    }

    public EchoesRenderer getRenderer() {
        return this.mEchoesRenderer;
    }

    public /* synthetic */ void h() {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleReloadActor();
        }
    }

    public void handleAddActorDisplay(final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.K
            @Override // java.lang.Runnable
            public final void run() {
                this.f16761a.c(str);
            }
        });
    }

    public void handleChangeMode(final int i, final int i2) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f16828a.b(i, i2);
            }
        });
    }

    public void handleChangePartyOwner(final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f16810a.d(str);
            }
        });
    }

    public void handleChat(final String str, final String str2) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f16791a.b(str, str2);
            }
        });
    }

    public void handleDeleteActorDisplay(final String str) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f16787a.e(str);
            }
        });
    }

    public void initGame(final String str, final String str2, final int i, final int i2, final int i3) {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.C
            @Override // java.lang.Runnable
            public final void run() {
                this.f16735a.a(str, str2, i, i2, i3);
            }
        });
    }

    protected void initView() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setFocusableInTouchMode(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.clothes.BlockGLSurfaceView
    public void onAttached() {
        addPost(new Runnable() { // from class: com.sandboxol.clothes.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f16825a.c();
            }
        });
    }

    public void onDestroy() {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.setInitOK(false);
        }
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f16834a.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.clothes.BlockGLSurfaceView
    public void onDetached() {
        addPost(new Runnable() { // from class: com.sandboxol.clothes.Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f16776a.e();
            }
        });
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(final int i, KeyEvent keyEvent) {
        if (i == 4) {
            queueEvent(new Runnable() { // from class: com.sandboxol.clothes.O
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16771a.e(i);
                }
            });
            return false;
        }
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.A
            @Override // java.lang.Runnable
            public final void run() {
                this.f16729a.f(i);
            }
        });
        return true;
    }

    @Override // com.sandboxol.clothes.BlockGLSurfaceView
    public void onPause() {
        addPost(new Runnable() { // from class: com.sandboxol.clothes.D
            @Override // java.lang.Runnable
            public final void run() {
                this.f16741a.f();
            }
        });
    }

    @Override // com.sandboxol.clothes.BlockGLSurfaceView
    public void onResume() {
        addPost(new Runnable() { // from class: com.sandboxol.clothes.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f16790a.g();
            }
        });
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        if (isInEditMode()) {
            return;
        }
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f16840a.c(i, i2);
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        final int[] iArr = new int[pointerCount];
        final float[] fArr = new float[pointerCount];
        final float[] fArr2 = new float[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            fArr[i] = motionEvent.getX(i);
            fArr2[i] = motionEvent.getY(i);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            final int pointerId = motionEvent.getPointerId(0);
            final float f2 = fArr[0];
            final float f3 = fArr2[0];
            queueEvent(new Runnable() { // from class: com.sandboxol.clothes.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16847a.b(pointerId, f2, f3);
                }
            });
        } else if (action == 1) {
            final int pointerId2 = motionEvent.getPointerId(0);
            final float f4 = fArr[0];
            final float f5 = fArr2[0];
            queueEvent(new Runnable() { // from class: com.sandboxol.clothes.E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16742a.d(pointerId2, f4, f5);
                }
            });
        } else if (action == 2) {
            queueEvent(new Runnable() { // from class: com.sandboxol.clothes.L
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16763a.b(iArr, fArr, fArr2);
                }
            });
        } else if (action == 3) {
            queueEvent(new Runnable() { // from class: com.sandboxol.clothes.F
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16746a.a(iArr, fArr, fArr2);
                }
            });
        } else if (action == 5) {
            int action2 = motionEvent.getAction() >> 8;
            final int pointerId3 = motionEvent.getPointerId(action2);
            final float x = motionEvent.getX(action2);
            final float y = motionEvent.getY(action2);
            queueEvent(new Runnable() { // from class: com.sandboxol.clothes.J
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16757a.a(pointerId3, x, y);
                }
            });
        } else if (action == 6) {
            int action3 = motionEvent.getAction() >> 8;
            final int pointerId4 = motionEvent.getPointerId(action3);
            final float x2 = motionEvent.getX(action3);
            final float y2 = motionEvent.getY(action3);
            queueEvent(new Runnable() { // from class: com.sandboxol.clothes.B
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16731a.c(pointerId4, x2, y2);
                }
            });
        }
        return true;
    }

    @Override // com.sandboxol.clothes.BlockGLSurfaceView
    public void queueEvent(final Runnable runnable) {
        addPost(new Runnable() { // from class: com.sandboxol.clothes.H
            @Override // java.lang.Runnable
            public final void run() {
                this.f16752a.a(runnable);
            }
        });
    }

    public void reloadActor() {
        queueEvent(new Runnable() { // from class: com.sandboxol.clothes.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f16789a.h();
            }
        });
    }

    public void setEchoesRenderer(EchoesRenderer echoesRenderer) {
        this.mEchoesRenderer = echoesRenderer;
        setRenderer(this.mEchoesRenderer);
    }

    public void setMainHandler(EchoesHandler echoesHandler) {
        this.mMainHandler = echoesHandler;
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.SetMainHandler(echoesHandler);
        }
    }

    @Override // com.sandboxol.clothes.BlockGLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int i, final int i2, final int i3) {
        addPost(new Runnable() { // from class: com.sandboxol.clothes.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f16820a.a(surfaceHolder, i, i2, i3);
            }
        });
    }

    @Override // com.sandboxol.clothes.BlockGLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(final SurfaceHolder surfaceHolder) {
        addPost(new Runnable() { // from class: com.sandboxol.clothes.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f16794a.a(surfaceHolder);
            }
        });
    }

    @Override // com.sandboxol.clothes.BlockGLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
        addPost(new Runnable() { // from class: com.sandboxol.clothes.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f16818a.b(surfaceHolder);
            }
        });
    }

    public EchoesGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public /* synthetic */ void a(int i, float f2, float f3) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleActionDown(i, f2, f3);
        }
    }

    public /* synthetic */ void b(int i, float f2, float f3) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleActionDown(i, f2, f3);
        }
    }

    public /* synthetic */ void c(int i, int i2) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.setScreenWidthAndHeight(i, i2);
        }
    }

    public /* synthetic */ void e() {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.setInitOK(false);
            this.mEchoesRenderer.handleOnDestroy();
        }
        super.onDetached();
    }

    public /* synthetic */ void f(int i) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleKeyDown(i);
        }
    }

    public /* synthetic */ void a(int[] iArr, float[] fArr, float[] fArr2) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleActionCancel(iArr, fArr, fArr2);
        }
    }

    public /* synthetic */ void b(int[] iArr, float[] fArr, float[] fArr2) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleActionMove(iArr, fArr, fArr2);
        }
    }

    public /* synthetic */ void c() {
        super.onAttached();
    }

    public /* synthetic */ void c(int i) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeSex(i);
        }
    }

    public /* synthetic */ void d(int i, float f2, float f3) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleActionUp(i, f2, f3);
        }
    }

    public /* synthetic */ void a(Runnable runnable) {
        super.queueEvent(runnable);
    }

    public /* synthetic */ void b(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
    }

    public /* synthetic */ void e(String str) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleDeleteActorDisplay(str);
        }
    }

    public /* synthetic */ void a(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    public /* synthetic */ void b(int i, String str) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeSexOtherPlayer(i, str);
        }
    }

    public /* synthetic */ void c(String str) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleAddActorDisplay(str);
        }
    }

    public /* synthetic */ void d(String str) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangePartyOwner(str);
        }
    }

    public /* synthetic */ void a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        changeSurface(i2, i3);
    }

    public /* synthetic */ void b(int i, int i2) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeMode(i, i2);
        }
    }

    public /* synthetic */ void c(int i, String str) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeVipLevelOtherPlayer(i, str);
        }
    }

    public /* synthetic */ void d(int i) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeVipLevel(i);
        }
    }

    public /* synthetic */ void a(String str, String str2, int i, int i2, int i3) {
        if (this.mEchoesRenderer != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.mEchoesRenderer.handleOnDestroy();
            this.mEchoesRenderer.handleInitGame(str, str2, i, i2, i3);
            this.mEchoesRenderer.handleOnResume();
            this.mEchoesRenderer.setInitOK(true);
            Message message = new Message();
            message.what = 3;
            this.mMainHandler.sendMessage(message);
            Log.e("GLThread", "engine init time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            Log.e("GLThread", "Init Game done ==============================strRootPath ：" + str);
            Log.e("GLThread", "Init Game done ==============================strConfigPath ：" + str2);
        }
    }

    public /* synthetic */ void b(String str) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeName(str);
        }
    }

    public /* synthetic */ void b(String str, String str2) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChat(str, str2);
        }
    }

    public /* synthetic */ void b(int i) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeDefaultIdle(i);
        }
    }

    public /* synthetic */ void a(String str, String str2) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeParts(str, str2);
        }
    }

    public /* synthetic */ void a(String str, String str2, String str3) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangePartsOtherPlayer(str, str2, str3);
        }
    }

    public /* synthetic */ void a(float f2, float f3, float f4, float f5) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeSkinColor(f2, f3, f4, f5);
        }
    }

    public /* synthetic */ void a(float f2, float f3, float f4, float f5, String str) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeSkinColorOtherPlayer(f2, f3, f4, f5, str);
        }
    }

    public /* synthetic */ void a(int i) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeAction(i);
        }
    }

    public /* synthetic */ void a(float f2, float f3) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeActorSize(f2, f3);
        }
    }

    public /* synthetic */ void a(int i, int i2) {
        EchoesRenderer echoesRenderer;
        if (!this.mGLThread.hasCurrentContext() || (echoesRenderer = this.mEchoesRenderer) == null) {
            return;
        }
        echoesRenderer.handleSurfaceChanged(i, i2);
    }

    public /* synthetic */ void a(float f2, float f3, float f4) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangePosition(f2, f3, f4);
        }
    }

    public /* synthetic */ void a(String str) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeBackgroundImage(str);
        }
    }

    public /* synthetic */ void a(int i, String str) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleDefaultIdleOtherPlayer(i, str);
        }
    }

    public /* synthetic */ void a(String str, boolean z) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleChangeOnGameState(str, z);
        }
    }

    public /* synthetic */ void a(int i, String str, String str2) {
        EchoesRenderer echoesRenderer = this.mEchoesRenderer;
        if (echoesRenderer != null) {
            echoesRenderer.handleCheckResource(i, str, str2);
        }
    }
}

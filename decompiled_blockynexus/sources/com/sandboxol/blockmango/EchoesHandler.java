package com.sandboxol.blockmango;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sandboxol.game.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"DefaultLocale"})
public class EchoesHandler extends Handler {
    public static final int HANDLER_CONFIRM_UPDATE_RES = 10;
    public static final int HANDLER_COPY_COMPLETE = 4;
    public static final int HANDLER_DOWNLOAD_NEW_APP = 12;
    public static final int HANDLER_EXIT_GAME = 13;
    public static final int HANDLER_GL_INIT_OK = 6;
    public static final int HANDLER_INIT_OK = 5;
    public static final int HANDLER_POPUP_CONFIRM_UPDATE_APP = 8;
    public static final int HANDLER_POPUP_CONFIRM_UPDATE_RES = 9;
    public static final int HANDLER_REMOVE_LOADINGPAGE = 16;
    public static final int HANDLER_RESET_START = 15;
    public static final int HANDLER_SHOWTIPS = 17;
    public static final int HANDLER_SHOW_DIALOG = 1;
    public static final int HANDLER_SHOW_EDITBOX_DIALOG = 2;
    public static final int HANDLER_SHOW_SMALL_EDITBOX_DIALOG = 18;
    public static final int HANDLER_UPDATE_COPY = 3;
    public static final int HANDLER_UPDATE_DOWNLOAD = 7;
    public static final int HANDLER_UPDATE_VERSION_TEXT = 11;
    public static final int HANDLER_USER_PROP = 14;
    private WeakReference<EchoesActivity> mActivity;

    public static class CopyComplete {
    }

    public static class CopyMessage {
        public int mnCopyCount;
        public int mnWholeCount;

        public CopyMessage(int i, int i2) {
            this.mnCopyCount = i;
            this.mnWholeCount = i2;
        }
    }

    public static class DialogMessage {
        public String message;
        public String titile;

        public DialogMessage(String str, String str2) {
            this.titile = str;
            this.message = str2;
        }
    }

    public static class EditBoxMessage {
        public String content;
        public int inputFlag;
        public int inputMode;
        public int maxLength;
        public int returnType;
        public String title;

        public EditBoxMessage(String str, String str2, int i, int i2, int i3, int i4) {
            this.content = str2;
            this.title = str;
            this.inputMode = i;
            this.inputFlag = i2;
            this.returnType = i3;
            this.maxLength = i4;
        }
    }

    public static class UpdateDownloadMessage {
        public int downloadState;
        public int mnDownloadCount;
        public int mnWholeCount;

        public UpdateDownloadMessage(int i, int i2, int i3) {
            this.mnDownloadCount = i;
            this.mnWholeCount = i2;
            this.downloadState = i3;
        }
    }

    public static class downloadAppMessage {
        public String url;

        public downloadAppMessage(String str) {
            this.url = str;
        }
    }

    class downloadThread extends Thread {
        private EchoesHandler mainHandler;

        public downloadThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            String strDownloadBaseFile = EchoesHandler.this.downloadBaseFile("http://192.168.1.11:8086/config/mcdownload.cfg");
            System.out.println(strDownloadBaseFile);
            Uri uri = Uri.parse(strDownloadBaseFile);
            if (uri.getHost() == null || !(uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https"))) {
                ((EchoesActivity) EchoesHandler.this.mActivity.get()).finish();
            } else {
                ((EchoesActivity) EchoesHandler.this.mActivity.get()).startActivity(new Intent("android.intent.action.VIEW", uri));
            }
        }

        public downloadThread(EchoesHandler echoesHandler) {
            this.mainHandler = echoesHandler;
        }
    }

    public EchoesHandler(EchoesActivity echoesActivity) {
        this.mActivity = new WeakReference<>(echoesActivity);
    }

    private void OnGLInitOK() {
        this.mActivity.get().DoMainInit();
    }

    private void copyComplete(Message message) {
        EchoesGLSurfaceView.getInstance().initStartModel();
        EchoesGLSurfaceView.getInstance().initGame(false);
    }

    private void exitGame() {
        EchoesGLSurfaceView.getInstance().exitGame();
    }

    private void popupUpdateAppConfirm(Message message) {
        new AlertDialog.Builder(this.mActivity.get()).setTitle(this.mActivity.get().getString(R.string.dialog_title)).setMessage(this.mActivity.get().getString(R.string.update_app_tips)).setIcon(R.mipmap.ic_launcher).setPositiveButton(this.mActivity.get().getString(R.string.dialog_ok_text), new DialogInterface.OnClickListener() { // from class: com.sandboxol.blockmango.EchoesHandler.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                EchoesHandler.this.new downloadThread(this).start();
            }
        }).show();
    }

    private void popupUpdateResConfirm(Message message) {
        final EchoesActivity echoesActivity = this.mActivity.get();
        new AlertDialog.Builder(echoesActivity).setTitle(this.mActivity.get().getString(R.string.dialog_title)).setMessage(String.format("%s:%.3fkb", this.mActivity.get().getString(R.string.update_text_tips), Float.valueOf(EchoesRenderer.nativeGetTotalDownloadSize() * 0.001f))).setIcon(R.mipmap.ic_launcher).setPositiveButton(this.mActivity.get().getString(R.string.dialog_ok_text), new DialogInterface.OnClickListener() { // from class: com.sandboxol.blockmango.EchoesHandler.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Message messageObtainMessage = echoesActivity.mChildHandler.obtainMessage();
                messageObtainMessage.what = 10;
                echoesActivity.mChildHandler.sendMessage(messageObtainMessage);
            }
        }).setNegativeButton(this.mActivity.get().getString(R.string.dialog_cancel_text), new DialogInterface.OnClickListener() { // from class: com.sandboxol.blockmango.EchoesHandler.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                echoesActivity.finish();
            }
        }).show();
    }

    private void showDialog(Message message) {
        EchoesActivity echoesActivity = this.mActivity.get();
        DialogMessage dialogMessage = (DialogMessage) message.obj;
        new AlertDialog.Builder(echoesActivity).setTitle(dialogMessage.titile).setMessage(dialogMessage.message).setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.sandboxol.blockmango.EchoesHandler.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).create().show();
    }

    private void showEditBoxDialog(Message message) {
        try {
            if (this.mActivity.get().isFinishing()) {
                return;
            }
            EditBoxMessage editBoxMessage = (EditBoxMessage) message.obj;
            new EchoesEditBoxDialog(this.mActivity.get(), editBoxMessage.title, editBoxMessage.content, editBoxMessage.inputMode, editBoxMessage.inputFlag, editBoxMessage.returnType, editBoxMessage.maxLength).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void showSmallEditBoxDialog(Message message) {
        try {
            if (this.mActivity.get().isFinishing()) {
                return;
            }
            EditBoxMessage editBoxMessage = (EditBoxMessage) message.obj;
            new EchoesSmallEditBoxDialog(this.mActivity.get(), editBoxMessage.title, editBoxMessage.content, editBoxMessage.inputMode, editBoxMessage.inputFlag, editBoxMessage.returnType, editBoxMessage.maxLength).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void updateCopyView(Message message) {
        CopyMessage copyMessage = (CopyMessage) message.obj;
        this.mActivity.get().SetUpdateTips(String.format("%s:%.2f%%", this.mActivity.get().getString(R.string.prepare_text), Float.valueOf((copyMessage.mnCopyCount * 100.0f) / copyMessage.mnWholeCount)));
    }

    private void updateDownloadView(Message message) {
        String str;
        float f2 = (r8.mnDownloadCount * 100.0f) / r8.mnWholeCount;
        if (((UpdateDownloadMessage) message.obj).downloadState == 0) {
            str = String.format("%s:%.3fkb/%.3fkb\n%.2f%%", this.mActivity.get().getString(R.string.download_text), Float.valueOf(EchoesRenderer.nativeGetCurrentDownloadSize() * 0.001f), Float.valueOf(EchoesRenderer.nativeGetTotalDownloadSize() * 0.001f), Float.valueOf(f2));
        } else {
            str = String.format("%s:%.2f%%", this.mActivity.get().getString(R.string.update_text), Float.valueOf(f2));
        }
        this.mActivity.get().SetUpdateTips(str);
    }

    private void useProp(String str) {
        EchoesGLSurfaceView.getInstance().useProp(str);
    }

    public String downloadBaseFile(String str) throws Throwable {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(((HttpURLConnection) new URL(str).openConnection()).getInputStream()));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            stringBuffer.append(line);
                        } catch (Exception e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return stringBuffer.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e = e5;
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                showDialog(message);
                break;
            case 2:
                showEditBoxDialog(message);
                break;
            case 3:
                updateCopyView(message);
                break;
            case 4:
                copyComplete(message);
                break;
            case 5:
                this.mActivity.get().RemoveLoadingView();
                break;
            case 6:
                OnGLInitOK();
                break;
            case 7:
                updateDownloadView(message);
                break;
            case 8:
                popupUpdateAppConfirm(message);
                break;
            case 9:
                popupUpdateResConfirm(message);
                break;
            case 11:
                this.mActivity.get().SetVersionText(EchoesRenderer.nativeGetLocalVersion(), EchoesRenderer.nativeGetServerVersion());
                break;
            case 12:
                try {
                    this.mActivity.get().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((downloadAppMessage) message.obj).url)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 13:
                exitGame();
                break;
            case 14:
                useProp((String) message.obj);
                break;
            case 15:
                this.mActivity.get().addLoadingView();
                break;
            case 18:
                showSmallEditBoxDialog(message);
                break;
        }
    }
}

package io.rong.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e;
import androidx.fragment.app.F;
import androidx.fragment.app.FragmentActivity;
import io.rong.eventbus.EventBus;

/* JADX INFO: loaded from: classes5.dex */
public class ErrorDialogManager {
    public static final String KEY_EVENT_TYPE_ON_CLOSE = "de.greenrobot.eventbus.errordialog.event_type_on_close";
    public static final String KEY_FINISH_AFTER_DIALOG = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
    public static final String KEY_ICON_ID = "de.greenrobot.eventbus.errordialog.icon_id";
    public static final String KEY_MESSAGE = "de.greenrobot.eventbus.errordialog.message";
    public static final String KEY_TITLE = "de.greenrobot.eventbus.errordialog.title";
    protected static final String TAG_ERROR_DIALOG = "de.greenrobot.eventbus.error_dialog";
    protected static final String TAG_ERROR_DIALOG_MANAGER = "de.greenrobot.eventbus.error_dialog_manager";
    public static ErrorDialogFragmentFactory<?> factory;

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {
        protected Bundle argumentsForErrorDialog;
        private EventBus eventBus;
        private Object executionScope;
        protected boolean finishAfterDialog;

        public static void attachTo(Activity activity, Object obj, boolean z, Bundle bundle) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            HoneycombManagerFragment honeycombManagerFragment = (HoneycombManagerFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER);
            if (honeycombManagerFragment == null) {
                honeycombManagerFragment = new HoneycombManagerFragment();
                fragmentManager.beginTransaction().add(honeycombManagerFragment, ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER).commit();
                fragmentManager.executePendingTransactions();
            }
            honeycombManagerFragment.finishAfterDialog = z;
            honeycombManagerFragment.argumentsForErrorDialog = bundle;
            honeycombManagerFragment.executionScope = obj;
        }

        public void onEventMainThread(ThrowableFailureEvent throwableFailureEvent) {
            if (ErrorDialogManager.isInExecutionScope(this.executionScope, throwableFailureEvent)) {
                ErrorDialogManager.checkLogException(throwableFailureEvent);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.TAG_ERROR_DIALOG);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                DialogFragment dialogFragment2 = (DialogFragment) ErrorDialogManager.factory.prepareErrorFragment(throwableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.TAG_ERROR_DIALOG);
                }
            }
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.eventBus.unregister(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            this.eventBus = ErrorDialogManager.factory.config.getEventBus();
            this.eventBus.register(this);
        }
    }

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {
        protected Bundle argumentsForErrorDialog;
        private EventBus eventBus;
        private Object executionScope;
        protected boolean finishAfterDialog;
        private boolean skipRegisterOnNextResume;

        public static void attachTo(Activity activity, Object obj, boolean z, Bundle bundle) {
            AbstractC0336n supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            SupportManagerFragment supportManagerFragment = (SupportManagerFragment) supportFragmentManager.a(ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER);
            if (supportManagerFragment == null) {
                supportManagerFragment = new SupportManagerFragment();
                F fA = supportFragmentManager.a();
                fA.a(supportManagerFragment, ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER);
                fA.a();
                supportFragmentManager.b();
            }
            supportManagerFragment.finishAfterDialog = z;
            supportManagerFragment.argumentsForErrorDialog = bundle;
            supportManagerFragment.executionScope = obj;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.eventBus = ErrorDialogManager.factory.config.getEventBus();
            this.eventBus.register(this);
            this.skipRegisterOnNextResume = true;
        }

        public void onEventMainThread(ThrowableFailureEvent throwableFailureEvent) {
            if (ErrorDialogManager.isInExecutionScope(this.executionScope, throwableFailureEvent)) {
                ErrorDialogManager.checkLogException(throwableFailureEvent);
                AbstractC0336n fragmentManager = getFragmentManager();
                fragmentManager.b();
                DialogInterfaceOnCancelListenerC0327e dialogInterfaceOnCancelListenerC0327e = (DialogInterfaceOnCancelListenerC0327e) fragmentManager.a(ErrorDialogManager.TAG_ERROR_DIALOG);
                if (dialogInterfaceOnCancelListenerC0327e != null) {
                    dialogInterfaceOnCancelListenerC0327e.dismiss();
                }
                DialogInterfaceOnCancelListenerC0327e dialogInterfaceOnCancelListenerC0327e2 = (DialogInterfaceOnCancelListenerC0327e) ErrorDialogManager.factory.prepareErrorFragment(throwableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog);
                if (dialogInterfaceOnCancelListenerC0327e2 != null) {
                    dialogInterfaceOnCancelListenerC0327e2.show(fragmentManager, ErrorDialogManager.TAG_ERROR_DIALOG);
                }
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.eventBus.unregister(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.skipRegisterOnNextResume) {
                this.skipRegisterOnNextResume = false;
            } else {
                this.eventBus = ErrorDialogManager.factory.config.getEventBus();
                this.eventBus.register(this);
            }
        }
    }

    public static void attachTo(Activity activity) {
        attachTo(activity, false, null);
    }

    protected static void checkLogException(ThrowableFailureEvent throwableFailureEvent) {
        ErrorDialogConfig errorDialogConfig = factory.config;
        if (errorDialogConfig.logExceptions) {
            String str = errorDialogConfig.tagForLoggingExceptions;
            if (str == null) {
                str = EventBus.TAG;
            }
            Log.i(str, "Error dialog manager received exception", throwableFailureEvent.throwable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isInExecutionScope(Object obj, ThrowableFailureEvent throwableFailureEvent) {
        Object executionScope;
        return throwableFailureEvent == null || (executionScope = throwableFailureEvent.getExecutionScope()) == null || executionScope.equals(obj);
    }

    private static boolean isSupportActivity(Activity activity) {
        String name;
        Class<?> superclass = activity.getClass();
        do {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new RuntimeException("Illegal activity type: " + activity.getClass());
            }
            name = superclass.getName();
            if (name.equals("androidx.fragment.app.FragmentActivity")) {
                return true;
            }
            if (name.startsWith("com.actionbarsherlock.app") && (name.endsWith(".SherlockActivity") || name.endsWith(".SherlockListActivity") || name.endsWith(".SherlockPreferenceActivity"))) {
                throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + name);
            }
        } while (!name.equals("android.app.Activity"));
        if (Build.VERSION.SDK_INT >= 11) {
            return false;
        }
        throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    }

    public static void attachTo(Activity activity, boolean z) {
        attachTo(activity, z, null);
    }

    public static void attachTo(Activity activity, boolean z, Bundle bundle) {
        attachTo(activity, activity.getClass(), z, bundle);
    }

    public static void attachTo(Activity activity, Object obj, boolean z, Bundle bundle) {
        if (factory != null) {
            if (isSupportActivity(activity)) {
                SupportManagerFragment.attachTo(activity, obj, z, bundle);
                return;
            } else {
                HoneycombManagerFragment.attachTo(activity, obj, z, bundle);
                return;
            }
        }
        throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    }
}

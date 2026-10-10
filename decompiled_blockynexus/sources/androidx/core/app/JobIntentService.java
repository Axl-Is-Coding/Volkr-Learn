package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Object f934a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final HashMap<ComponentName, h> f935b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b f936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    h f937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    a f938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f939f = false;
    boolean g = false;
    boolean h = false;
    final ArrayList<d> i;

    interface b {
        IBinder compatGetBinder();

        e dequeueWork();
    }

    static final class c extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Context f941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f942e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f943f;
        boolean g;
        boolean h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f941d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.f942e = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f942e.setReferenceCounted(false);
            this.f943f = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f943f.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        public void a() {
            synchronized (this) {
                if (this.h) {
                    if (this.g) {
                        this.f942e.acquire(60000L);
                    }
                    this.h = false;
                    this.f943f.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.f943f.acquire(600000L);
                    this.f942e.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                this.g = false;
            }
        }
    }

    final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f945b;

        d(Intent intent, int i) {
            this.f944a = intent;
            this.f945b = i;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void complete() {
            JobIntentService.this.stopSelf(this.f945b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f944a;
        }
    }

    interface e {
        void complete();

        Intent getIntent();
    }

    static final class f extends JobServiceEngine implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final JobIntentService f947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        JobParameters f949c;

        final class a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final JobWorkItem f950a;

            a(JobWorkItem jobWorkItem) {
                this.f950a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void complete() {
                synchronized (f.this.f948b) {
                    if (f.this.f949c != null) {
                        f.this.f949c.completeWork(this.f950a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                return this.f950a.getIntent();
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f948b = new Object();
            this.f947a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.b
        public e dequeueWork() {
            synchronized (this.f948b) {
                if (this.f949c == null) {
                    return null;
                }
                JobWorkItem jobWorkItemDequeueWork = this.f949c.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f947a.getClassLoader());
                return new a(jobWorkItemDequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f949c = jobParameters;
            this.f947a.a(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.f947a.b();
            synchronized (this.f948b) {
                this.f949c = null;
            }
            return zB;
        }
    }

    static final class g extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JobInfo f952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final JobScheduler f953e;

        g(Context context, ComponentName componentName, int i) {
            super(componentName);
            a(i);
            this.f952d = new JobInfo.Builder(i, this.f954a).setOverrideDeadline(0L).build();
            this.f953e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ComponentName f954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f956c;

        h(ComponentName componentName) {
            this.f954a = componentName;
        }

        public void a() {
        }

        void a(int i) {
            if (!this.f955b) {
                this.f955b = true;
                this.f956c = i;
            } else {
                if (this.f956c == i) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.f956c);
            }
        }

        public void b() {
        }

        public void c() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.i = null;
        } else {
            this.i = new ArrayList<>();
        }
    }

    static h a(Context context, ComponentName componentName, boolean z, int i) {
        h cVar;
        h hVar = f935b.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            cVar = new c(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new g(context, componentName, i);
        }
        h hVar2 = cVar;
        f935b.put(componentName, hVar2);
        return hVar2;
    }

    protected abstract void a(Intent intent);

    boolean b() {
        a aVar = this.f938e;
        if (aVar != null) {
            aVar.cancel(this.f939f);
        }
        this.g = true;
        return c();
    }

    public boolean c() {
        return true;
    }

    void d() {
        ArrayList<d> arrayList = this.i;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f938e = null;
                if (this.i != null && this.i.size() > 0) {
                    a(false);
                } else if (!this.h) {
                    this.f937d.a();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f936c;
        if (bVar != null) {
            return bVar.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f936c = new f(this);
            this.f937d = null;
        } else {
            this.f936c = null;
            this.f937d = a(this, new ComponentName(this, (Class<?>) JobIntentService.class), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.i;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.h = true;
                this.f937d.a();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.i == null) {
            return 2;
        }
        this.f937d.c();
        synchronized (this.i) {
            ArrayList<d> arrayList = this.i;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i2));
            a(true);
        }
        return 3;
    }

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e eVarA = JobIntentService.this.a();
                if (eVarA == null) {
                    return null;
                }
                JobIntentService.this.a(eVarA.getIntent());
                eVarA.complete();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            JobIntentService.this.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r1) {
            JobIntentService.this.d();
        }
    }

    void a(boolean z) {
        if (this.f938e == null) {
            this.f938e = new a();
            h hVar = this.f937d;
            if (hVar != null && z) {
                hVar.b();
            }
            this.f938e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    e a() {
        b bVar = this.f936c;
        if (bVar != null) {
            return bVar.dequeueWork();
        }
        synchronized (this.i) {
            if (this.i.size() <= 0) {
                return null;
            }
            return this.i.remove(0);
        }
    }
}

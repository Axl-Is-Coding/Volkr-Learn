package io.rong.push.common.stateMachine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class StateMachine {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    private static final int SM_INIT_CMD = -2;
    private static final int SM_QUIT_CMD = -1;
    private String mName;
    private SmHandler mSmHandler;
    private HandlerThread mSmThread;

    public static class LogRec {
        private IState mDstState;
        private String mInfo;
        private IState mOrgState;
        private StateMachine mSm;
        private IState mState;
        private long mTime;
        private int mWhat;

        LogRec(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            update(stateMachine, message, str, iState, iState2, iState3);
        }

        public IState getDestState() {
            return this.mDstState;
        }

        public String getInfo() {
            return this.mInfo;
        }

        public IState getOriginalState() {
            return this.mOrgState;
        }

        public IState getState() {
            return this.mState;
        }

        public long getTime() {
            return this.mTime;
        }

        public long getWhat() {
            return this.mWhat;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("time=");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.mTime);
            sb.append(String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar));
            sb.append(" processed=");
            IState iState = this.mState;
            sb.append(iState == null ? "<null>" : iState.getName());
            sb.append(" org=");
            IState iState2 = this.mOrgState;
            sb.append(iState2 == null ? "<null>" : iState2.getName());
            sb.append(" dest=");
            IState iState3 = this.mDstState;
            sb.append(iState3 != null ? iState3.getName() : "<null>");
            sb.append(" what=");
            StateMachine stateMachine = this.mSm;
            String whatToString = stateMachine != null ? stateMachine.getWhatToString(this.mWhat) : "";
            if (TextUtils.isEmpty(whatToString)) {
                sb.append(this.mWhat);
                sb.append("(0x");
                sb.append(Integer.toHexString(this.mWhat));
                sb.append(")");
            } else {
                sb.append(whatToString);
            }
            if (!TextUtils.isEmpty(this.mInfo)) {
                sb.append(" ");
                sb.append(this.mInfo);
            }
            return sb.toString();
        }

        public void update(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            this.mSm = stateMachine;
            this.mTime = System.currentTimeMillis();
            this.mWhat = message != null ? message.what : 0;
            this.mInfo = str;
            this.mState = iState;
            this.mOrgState = iState2;
            this.mDstState = iState3;
        }
    }

    private static class LogRecords {
        private static final int DEFAULT_SIZE = 20;
        private int mCount;
        private boolean mLogOnlyTransitions;
        private Vector<LogRec> mLogRecVector;
        private int mMaxSize;
        private int mOldestIndex;

        synchronized void add(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            this.mCount++;
            if (this.mLogRecVector.size() < this.mMaxSize) {
                this.mLogRecVector.add(new LogRec(stateMachine, message, str, iState, iState2, iState3));
            } else {
                LogRec logRec = this.mLogRecVector.get(this.mOldestIndex);
                this.mOldestIndex++;
                if (this.mOldestIndex >= this.mMaxSize) {
                    this.mOldestIndex = 0;
                }
                logRec.update(stateMachine, message, str, iState, iState2, iState3);
            }
        }

        synchronized void cleanup() {
            this.mLogRecVector.clear();
        }

        synchronized int count() {
            return this.mCount;
        }

        synchronized LogRec get(int i) {
            int i2 = this.mOldestIndex + i;
            if (i2 >= this.mMaxSize) {
                i2 -= this.mMaxSize;
            }
            if (i2 >= size()) {
                return null;
            }
            return this.mLogRecVector.get(i2);
        }

        synchronized boolean logOnlyTransitions() {
            return this.mLogOnlyTransitions;
        }

        synchronized void setLogOnlyTransitions(boolean z) {
            this.mLogOnlyTransitions = z;
        }

        synchronized void setSize(int i) {
            this.mMaxSize = i;
            this.mCount = 0;
            this.mLogRecVector.clear();
        }

        synchronized int size() {
            return this.mLogRecVector.size();
        }

        private LogRecords() {
            this.mLogRecVector = new Vector<>();
            this.mMaxSize = 20;
            this.mOldestIndex = 0;
            this.mCount = 0;
            this.mLogOnlyTransitions = false;
        }
    }

    private static class SmHandler extends Handler {
        private static final Object mSmHandlerObj = new Object();
        private boolean mDbg;
        private ArrayList<Message> mDeferredMessages;
        private State mDestState;
        private HaltingState mHaltingState;
        private boolean mHasQuit;
        private State mInitialState;
        private boolean mIsConstructionCompleted;
        private LogRecords mLogRecords;
        private Message mMsg;
        private QuittingState mQuittingState;
        private StateMachine mSm;
        private HashMap<State, StateInfo> mStateInfo;
        private StateInfo[] mStateStack;
        private int mStateStackTopIndex;
        private StateInfo[] mTempStateStack;
        private int mTempStateStackCount;

        private class HaltingState extends State {
            private HaltingState() {
            }

            @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
            public boolean processMessage(Message message) {
                SmHandler.this.mSm.haltedProcessMessage(message);
                return true;
            }
        }

        private class QuittingState extends State {
            private QuittingState() {
            }

            @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
            public boolean processMessage(Message message) {
                return false;
            }
        }

        private class StateInfo {
            boolean active;
            StateInfo parentStateInfo;
            State state;

            private StateInfo() {
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("state=");
                sb.append(this.state.getName());
                sb.append(",active=");
                sb.append(this.active);
                sb.append(",parent=");
                StateInfo stateInfo = this.parentStateInfo;
                sb.append(stateInfo == null ? "null" : stateInfo.state.getName());
                return sb.toString();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final StateInfo addState(State state, State state2) {
            StateInfo stateInfoAddState;
            if (this.mDbg) {
                StateMachine stateMachine = this.mSm;
                StringBuilder sb = new StringBuilder();
                sb.append("addStateInternal: E state=");
                sb.append(state.getName());
                sb.append(",parent=");
                sb.append(state2 == null ? "" : state2.getName());
                stateMachine.log(sb.toString());
            }
            if (state2 != null) {
                StateInfo stateInfo = this.mStateInfo.get(state2);
                stateInfoAddState = stateInfo == null ? addState(state2, null) : stateInfo;
            } else {
                stateInfoAddState = null;
            }
            StateInfo stateInfo2 = this.mStateInfo.get(state);
            if (stateInfo2 == null) {
                stateInfo2 = new StateInfo();
                this.mStateInfo.put(state, stateInfo2);
            }
            StateInfo stateInfo3 = stateInfo2.parentStateInfo;
            if (stateInfo3 != null && stateInfo3 != stateInfoAddState) {
                throw new RuntimeException("state already added");
            }
            stateInfo2.state = state;
            stateInfo2.parentStateInfo = stateInfoAddState;
            stateInfo2.active = false;
            if (this.mDbg) {
                this.mSm.log("addStateInternal: X stateInfo: " + stateInfo2);
            }
            return stateInfo2;
        }

        private final void cleanupAfterQuitting() {
            if (this.mSm.mSmThread != null) {
                getLooper().quit();
                this.mSm.mSmThread = null;
            }
            this.mSm.mSmHandler = null;
            this.mSm = null;
            this.mMsg = null;
            this.mLogRecords.cleanup();
            this.mStateStack = null;
            this.mTempStateStack = null;
            this.mStateInfo.clear();
            this.mInitialState = null;
            this.mDestState = null;
            this.mDeferredMessages.clear();
            this.mHasQuit = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void completeConstruction() {
            if (this.mDbg) {
                this.mSm.log("completeConstruction: E");
            }
            int i = 0;
            for (StateInfo stateInfo : this.mStateInfo.values()) {
                int i2 = 0;
                while (stateInfo != null) {
                    stateInfo = stateInfo.parentStateInfo;
                    i2++;
                }
                if (i < i2) {
                    i = i2;
                }
            }
            if (this.mDbg) {
                this.mSm.log("completeConstruction: maxDepth=" + i);
            }
            this.mStateStack = new StateInfo[i];
            this.mTempStateStack = new StateInfo[i];
            setupInitialStateStack();
            sendMessageAtFrontOfQueue(obtainMessage(-2, mSmHandlerObj));
            if (this.mDbg) {
                this.mSm.log("completeConstruction: X");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void deferMessage(Message message) {
            if (this.mDbg) {
                this.mSm.log("deferMessage: msg=" + message.what);
            }
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.copyFrom(message);
            this.mDeferredMessages.add(messageObtainMessage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Message getCurrentMessage() {
            return this.mMsg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IState getCurrentState() {
            return this.mStateStack[this.mStateStackTopIndex].state;
        }

        private final void invokeEnterMethods(int i) {
            while (i <= this.mStateStackTopIndex) {
                if (this.mDbg) {
                    this.mSm.log("invokeEnterMethods: " + this.mStateStack[i].state.getName());
                }
                this.mStateStack[i].state.enter();
                this.mStateStack[i].active = true;
                i++;
            }
        }

        private final void invokeExitMethods(StateInfo stateInfo) {
            while (true) {
                int i = this.mStateStackTopIndex;
                if (i < 0) {
                    return;
                }
                StateInfo[] stateInfoArr = this.mStateStack;
                if (stateInfoArr[i] == stateInfo) {
                    return;
                }
                State state = stateInfoArr[i].state;
                if (this.mDbg) {
                    this.mSm.log("invokeExitMethods: " + state.getName());
                }
                state.exit();
                StateInfo[] stateInfoArr2 = this.mStateStack;
                int i2 = this.mStateStackTopIndex;
                stateInfoArr2[i2].active = false;
                this.mStateStackTopIndex = i2 - 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isDbg() {
            return this.mDbg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isQuit(Message message) {
            return message.what == -1 && message.obj == mSmHandlerObj;
        }

        private final void moveDeferredMessageAtFrontOfQueue() {
            for (int size = this.mDeferredMessages.size() - 1; size >= 0; size--) {
                Message message = this.mDeferredMessages.get(size);
                if (this.mDbg) {
                    this.mSm.log("moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.mDeferredMessages.clear();
        }

        private final int moveTempStateStackToStateStack() {
            int i = this.mStateStackTopIndex + 1;
            int i2 = i;
            for (int i3 = this.mTempStateStackCount - 1; i3 >= 0; i3--) {
                if (this.mDbg) {
                    this.mSm.log("moveTempStackToStateStack: i=" + i3 + ",j=" + i2);
                }
                this.mStateStack[i2] = this.mTempStateStack[i3];
                i2++;
            }
            this.mStateStackTopIndex = i2 - 1;
            if (this.mDbg) {
                this.mSm.log("moveTempStackToStateStack: X mStateStackTop=" + this.mStateStackTopIndex + ",startingIndex=" + i + ",Top=" + this.mStateStack[this.mStateStackTopIndex].state.getName());
            }
            return i;
        }

        private void performTransitions(State state, Message message) {
            State state2 = this.mStateStack[this.mStateStackTopIndex].state;
            boolean z = this.mSm.recordLogRec(this.mMsg) && message.obj != mSmHandlerObj;
            if (this.mLogRecords.logOnlyTransitions()) {
                if (this.mDestState != null) {
                    LogRecords logRecords = this.mLogRecords;
                    StateMachine stateMachine = this.mSm;
                    Message message2 = this.mMsg;
                    logRecords.add(stateMachine, message2, stateMachine.getLogRecString(message2), state, state2, this.mDestState);
                }
            } else if (z) {
                LogRecords logRecords2 = this.mLogRecords;
                StateMachine stateMachine2 = this.mSm;
                Message message3 = this.mMsg;
                logRecords2.add(stateMachine2, message3, stateMachine2.getLogRecString(message3), state, state2, this.mDestState);
            }
            State state3 = this.mDestState;
            if (state3 != null) {
                while (true) {
                    if (this.mDbg) {
                        this.mSm.log("handleMessage: new destination call exit/enter");
                    }
                    invokeExitMethods(setupTempStateStackWithStatesToEnter(state3));
                    invokeEnterMethods(moveTempStateStackToStateStack());
                    moveDeferredMessageAtFrontOfQueue();
                    State state4 = this.mDestState;
                    if (state3 == state4) {
                        break;
                    } else {
                        state3 = state4;
                    }
                }
                this.mDestState = null;
            }
            if (state3 != null) {
                if (state3 == this.mQuittingState) {
                    this.mSm.onQuitting();
                    cleanupAfterQuitting();
                } else if (state3 == this.mHaltingState) {
                    this.mSm.onHalting();
                }
            }
        }

        private final State processMsg(Message message) {
            StateInfo stateInfo = this.mStateStack[this.mStateStackTopIndex];
            if (this.mDbg) {
                this.mSm.log("processMsg: " + stateInfo.state.getName());
            }
            if (isQuit(message)) {
                transitionTo(this.mQuittingState);
            } else {
                while (true) {
                    if (stateInfo.state.processMessage(message)) {
                        break;
                    }
                    stateInfo = stateInfo.parentStateInfo;
                    if (stateInfo == null) {
                        this.mSm.unhandledMessage(message);
                        break;
                    }
                    if (this.mDbg) {
                        this.mSm.log("processMsg: " + stateInfo.state.getName());
                    }
                }
            }
            if (stateInfo != null) {
                return stateInfo.state;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void quit() {
            if (this.mDbg) {
                this.mSm.log("quit:");
            }
            sendMessage(obtainMessage(-1, mSmHandlerObj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void quitNow() {
            if (this.mDbg) {
                this.mSm.log("quitNow:");
            }
            sendMessageAtFrontOfQueue(obtainMessage(-1, mSmHandlerObj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setDbg(boolean z) {
            this.mDbg = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setInitialState(State state) {
            if (this.mDbg) {
                this.mSm.log("setInitialState: initialState=" + state.getName());
            }
            this.mInitialState = state;
        }

        private final void setupInitialStateStack() {
            if (this.mDbg) {
                this.mSm.log("setupInitialStateStack: E mInitialState=" + this.mInitialState.getName());
            }
            StateInfo stateInfo = this.mStateInfo.get(this.mInitialState);
            this.mTempStateStackCount = 0;
            while (stateInfo != null) {
                StateInfo[] stateInfoArr = this.mTempStateStack;
                int i = this.mTempStateStackCount;
                stateInfoArr[i] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                this.mTempStateStackCount = i + 1;
            }
            this.mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
        }

        private final StateInfo setupTempStateStackWithStatesToEnter(State state) {
            this.mTempStateStackCount = 0;
            StateInfo stateInfo = this.mStateInfo.get(state);
            do {
                StateInfo[] stateInfoArr = this.mTempStateStack;
                int i = this.mTempStateStackCount;
                this.mTempStateStackCount = i + 1;
                stateInfoArr[i] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                if (stateInfo == null) {
                    break;
                }
            } while (!stateInfo.active);
            if (this.mDbg) {
                this.mSm.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.mTempStateStackCount + ",curStateInfo: " + stateInfo);
            }
            return stateInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void transitionTo(IState iState) {
            this.mDestState = (State) iState;
            if (this.mDbg) {
                this.mSm.log("transitionTo: destState=" + this.mDestState.getName());
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            StateMachine stateMachine;
            if (this.mHasQuit) {
                return;
            }
            if (this.mDbg) {
                this.mSm.log("handleMessage: E msg.what=" + message.what);
            }
            this.mMsg = message;
            State stateProcessMsg = null;
            boolean z = this.mIsConstructionCompleted;
            if (!z) {
                if (!z) {
                    Message message2 = this.mMsg;
                    if (message2.what == -2 && message2.obj == mSmHandlerObj) {
                        this.mIsConstructionCompleted = true;
                        invokeEnterMethods(0);
                    }
                }
                throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
            }
            stateProcessMsg = processMsg(message);
            performTransitions(stateProcessMsg, message);
            if (!this.mDbg || (stateMachine = this.mSm) == null) {
                return;
            }
            stateMachine.log("handleMessage: X");
        }

        private SmHandler(Looper looper, StateMachine stateMachine) {
            super(looper);
            this.mHasQuit = false;
            this.mDbg = false;
            this.mLogRecords = new LogRecords();
            this.mStateStackTopIndex = -1;
            this.mHaltingState = new HaltingState();
            this.mQuittingState = new QuittingState();
            this.mStateInfo = new HashMap<>();
            this.mDeferredMessages = new ArrayList<>();
            this.mSm = stateMachine;
            addState(this.mHaltingState, null);
            addState(this.mQuittingState, null);
        }
    }

    protected StateMachine(String str) {
        this.mSmThread = new HandlerThread(str);
        this.mSmThread.start();
        initStateMachine(str, this.mSmThread.getLooper());
    }

    private void initStateMachine(String str, Looper looper) {
        this.mName = str;
        this.mSmHandler = new SmHandler(looper, this);
    }

    protected void addLogRec(String str) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.mLogRecords.add(this, smHandler.getCurrentMessage(), str, smHandler.getCurrentState(), smHandler.mStateStack[smHandler.mStateStackTopIndex].state, smHandler.mDestState);
    }

    protected final void addState(State state, State state2) {
        this.mSmHandler.addState(state, state2);
    }

    public final Collection<LogRec> copyLogRecs() {
        Vector vector = new Vector();
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            Iterator it = smHandler.mLogRecords.mLogRecVector.iterator();
            while (it.hasNext()) {
                vector.add((LogRec) it.next());
            }
        }
        return vector;
    }

    protected final void deferMessage(Message message) {
        this.mSmHandler.deferMessage(message);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.println(getName() + ":");
        printWriter.println(" total records=" + getLogRecCount());
        for (int i = 0; i < getLogRecSize(); i++) {
            LogRec logRec = getLogRec(i);
            if (logRec != null) {
                printWriter.printf(" rec[%d]: %s\n", Integer.valueOf(i), logRec.toString());
            }
            printWriter.flush();
        }
        IState currentState = getCurrentState();
        if (currentState != null) {
            printWriter.println("curState=" + currentState.getName());
        }
    }

    protected final Message getCurrentMessage() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return smHandler.getCurrentMessage();
    }

    protected final IState getCurrentState() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return smHandler.getCurrentState();
    }

    public final Handler getHandler() {
        return this.mSmHandler;
    }

    public final LogRec getLogRec(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return smHandler.mLogRecords.get(i);
    }

    public final int getLogRecCount() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return 0;
        }
        return smHandler.mLogRecords.count();
    }

    public final int getLogRecSize() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return 0;
        }
        return smHandler.mLogRecords.size();
    }

    protected String getLogRecString(Message message) {
        return "";
    }

    public final String getName() {
        return this.mName;
    }

    protected String getWhatToString(int i) {
        return null;
    }

    protected void haltedProcessMessage(Message message) {
    }

    public boolean isDbg() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return false;
        }
        return smHandler.isDbg();
    }

    protected final boolean isQuit(Message message) {
        SmHandler smHandler = this.mSmHandler;
        return smHandler == null ? message.what == -1 : smHandler.isQuit(message);
    }

    protected void log(String str) {
        Log.d(this.mName, str);
    }

    protected void logAndAddLogRec(String str) {
        addLogRec(str);
        log(str);
    }

    protected void logd(String str) {
        Log.d(this.mName, str);
    }

    protected void loge(String str) {
        Log.e(this.mName, str);
    }

    protected void logi(String str) {
        Log.i(this.mName, str);
    }

    protected void logv(String str) {
        Log.v(this.mName, str);
    }

    protected void logw(String str) {
        Log.w(this.mName, str);
    }

    public final Message obtainMessage() {
        return Message.obtain(this.mSmHandler);
    }

    protected void onHalting() {
    }

    protected void onQuitting() {
    }

    protected final void quit() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.quit();
    }

    protected final void quitNow() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.quitNow();
    }

    protected boolean recordLogRec(Message message) {
        return true;
    }

    protected final void removeMessages(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.removeMessages(i);
    }

    public final void sendMessage(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessage(obtainMessage(i));
    }

    protected final void sendMessageAtFrontOfQueue(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i));
    }

    public final void sendMessageDelayed(int i, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i), j);
    }

    public void setDbg(boolean z) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.setDbg(z);
    }

    protected final void setInitialState(State state) {
        this.mSmHandler.setInitialState(state);
    }

    public final void setLogOnlyTransitions(boolean z) {
        this.mSmHandler.mLogRecords.setLogOnlyTransitions(z);
    }

    public final void setLogRecSize(int i) {
        this.mSmHandler.mLogRecords.setSize(i);
    }

    public void start() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.completeConstruction();
    }

    protected final void transitionTo(IState iState) {
        this.mSmHandler.transitionTo(iState);
    }

    protected final void transitionToHaltingState() {
        SmHandler smHandler = this.mSmHandler;
        smHandler.transitionTo(smHandler.mHaltingState);
    }

    protected void unhandledMessage(Message message) {
        if (this.mSmHandler.mDbg) {
            loge(" - unhandledMessage: msg.what=" + message.what);
        }
    }

    protected final void addState(State state) {
        this.mSmHandler.addState(state, null);
    }

    protected void loge(String str, Throwable th) {
        Log.e(this.mName, str, th);
    }

    public final Message obtainMessage(int i) {
        return Message.obtain(this.mSmHandler, i);
    }

    public final Message obtainMessage(int i, Object obj) {
        return Message.obtain(this.mSmHandler, i, obj);
    }

    public final void sendMessage(int i, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessage(obtainMessage(i, obj));
    }

    protected final void sendMessageAtFrontOfQueue(int i, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i, obj));
    }

    public final void sendMessageDelayed(int i, Object obj, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i, obj), j);
    }

    public final Message obtainMessage(int i, int i2) {
        return Message.obtain(this.mSmHandler, i, i2, 0);
    }

    public final Message obtainMessage(int i, int i2, int i3) {
        return Message.obtain(this.mSmHandler, i, i2, i3);
    }

    public final void sendMessage(int i, int i2) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessage(obtainMessage(i, i2));
    }

    protected final void sendMessageAtFrontOfQueue(int i, int i2) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i, i2));
    }

    public final void sendMessageDelayed(int i, int i2, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i, i2), j);
    }

    protected StateMachine(String str, Looper looper) {
        initStateMachine(str, looper);
    }

    public final Message obtainMessage(int i, int i2, int i3, Object obj) {
        return Message.obtain(this.mSmHandler, i, i2, i3, obj);
    }

    public final void sendMessage(int i, int i2, int i3) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessage(obtainMessage(i, i2, i3));
    }

    protected final void sendMessageAtFrontOfQueue(int i, int i2, int i3) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i, i2, i3));
    }

    public final void sendMessageDelayed(int i, int i2, int i3, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i, i2, i3), j);
    }

    protected StateMachine(String str, Handler handler) {
        initStateMachine(str, handler.getLooper());
    }

    public final void sendMessage(int i, int i2, int i3, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessage(obtainMessage(i, i2, i3, obj));
    }

    protected final void sendMessageAtFrontOfQueue(int i, int i2, int i3, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(obtainMessage(i, i2, i3, obj));
    }

    public final void sendMessageDelayed(int i, int i2, int i3, Object obj, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageDelayed(obtainMessage(i, i2, i3, obj), j);
    }

    public final void sendMessage(Message message) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessage(message);
    }

    protected final void sendMessageAtFrontOfQueue(Message message) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageAtFrontOfQueue(message);
    }

    public final void sendMessageDelayed(Message message, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return;
        }
        smHandler.sendMessageDelayed(message, j);
    }
}

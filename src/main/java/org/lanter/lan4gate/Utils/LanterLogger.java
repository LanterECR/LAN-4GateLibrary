package org.lanter.lan4gate.Utils;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Class provides simple wrapper for Android logging
 * Required for separately disabling logs in current library
 */
public class LanterLogger {
    private static LOG_LEVEL mLogLevel = LOG_LEVEL.ERROR;
    private static final String mLogTag = "org.lanter.lan4gate";
    /**
     * Logging levels
     */
    public enum LOG_LEVEL {
        OFF(1),
        ERROR(2),
        WARNING(3),
        INFO(4);

        private final int mOperationValue;
        private final static Map<Integer, LOG_LEVEL> mStaticValuesMap = new HashMap<>();

        static {
            for(LOG_LEVEL operation : LOG_LEVEL.values()) {
                mStaticValuesMap.put(operation.mOperationValue, operation);
            }
        }

        LOG_LEVEL(int value) {
            mOperationValue = value;
        }
        public static LOG_LEVEL getValue(int value) {
            return mStaticValuesMap.get(value);
        }
        public int getNumber() {
            return mOperationValue;
        }
    }

    /**
     * Return current {@link LOG_LEVEL}
     * @return Current log level. By default - ERROR
     */
    private static LOG_LEVEL getLogLevel() {
        return mLogLevel;
    }

    /**
     * Change current log level
     * @param level New log level
     */
    public static void setLogLevel(LOG_LEVEL level) {
        mLogLevel = level;
    }

    public static void error(String message) {
        if(levelAllowed(LOG_LEVEL.ERROR)) {
            Log.e(mLogTag, message);
        }
    }

    public static void warning(String message) {
        if(levelAllowed(LOG_LEVEL.WARNING)) {
            Log.w(mLogTag, message);
        }
    }

    public static void info(String message) {
        if(levelAllowed(LOG_LEVEL.INFO)) {
            Log.i(mLogTag, message);
        }
    }

    public static boolean levelAllowed(LOG_LEVEL level) {
        return mLogLevel.getNumber() >= level.getNumber();
    }
}

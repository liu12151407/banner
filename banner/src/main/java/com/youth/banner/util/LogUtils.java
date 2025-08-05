package com.youth.banner.util;

import android.util.Log;

/**
 * 日志工具类
 * 提供统一的日志输出方法，方便调试和问题排查
 */
public class LogUtils {
    /**
     * 默认日志标签
     */
    public static final String TAG = "banner_log";

    /**
     * 调试开关
     */
    private static final boolean DEBUG = true;

    /**
     * 输出调试级别日志
     * @param msg 日志消息
     */
    public static void d(String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }

    /**
     * 输出错误级别日志
     * @param msg 日志消息
     */
    public static void e(String msg) {
        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }

    /**
     * 输出信息级别日志
     * @param msg 日志消息
     */
    public static void i(String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    /**
     * 输出详细级别日志
     * @param msg 日志消息
     */
    public static void v( String msg) {
        if (DEBUG) {
            Log.v(TAG, msg);
        }
    }

    /**
     * 输出警告级别日志
     * @param msg 日志消息
     */
    public static void w(String msg) {
        if (DEBUG) {
            Log.w(TAG, msg);
        }
    }
}

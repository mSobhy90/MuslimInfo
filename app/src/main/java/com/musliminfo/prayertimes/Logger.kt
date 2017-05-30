package com.musliminfo.prayertimes

import android.util.Log

object Logger {
    private val LOG_TAG = "MUSLIM_INFO_PROVIDER - "
    private val VERBOSE = true

    /**
     * Returns a String representation of an object to be used as a tag for logs.

     * @param   instance  instance representing class whose name should be converted to a String<br></br>
     *                    **ClassName.class should be used for static contexts**
     *
     *
     * @return  a string representing class name to be used in `Log.i(**logTag**, whatever log msg);`
     */
    fun logTag(instance: Any): String {
        val className: String
        if (instance is Class<*>) {
            className = instance.simpleName
        } else {
            className = instance.javaClass.simpleName
        }

        return LOG_TAG + className
    }

    /**
     * Prints a verbose message using Android [Log].

     * @param  instance    instance of class to use for generating LOG_TAG
     *
     * @param  logMessage  message to logged **will be chunk-ed if too long**
     *
     *
     * @see .logTag
     */
    fun v(instance: Any, logMessage: String) {
        if (!(VERBOSE && BuildConfig.DEBUG)) {
            return
        }

        val tag = logTag(instance)
        if (logMessage.length > 4000) {
            val chunkCount = logMessage.length / 4000
            Log.v(tag, "logMessage length = " + logMessage.length + " divided to " + (chunkCount + 1) + " chunks")
            for (i in 0..chunkCount) {
                val max = 4000 * (i + 1)
                val message: String
                if (max >= logMessage.length) {
                    message = logMessage.substring(4000 * i)
                } else {
                    message = logMessage.substring(4000 * i, max)
                }

                Log.v(tag, "chunk " + (i + 1) + " of " + (chunkCount + 1) + ":\n" + message)
            }
        } else {
            Log.v(tag, logMessage)
        }
    }

    /**
     * Prints a debug message using Android [Log].

     * @param  instance    instance of class to use for generating LOG_TAG
     *
     * @param  logMessage  message to logged **will be chunk-ed if too long**
     *
     *
     * @see .logTag
     */
    fun d(instance: Any, logMessage: String) {
        if (!BuildConfig.DEBUG) {
            return
        }

        val tag = logTag(instance)
        if (logMessage.length > 4000) {
            val chunkCount = logMessage.length / 4000
            Log.d(tag, "logMessage length = " + logMessage.length + " divided to " + (chunkCount + 1) + " chunks")
            for (i in 0..chunkCount) {
                val max = 4000 * (i + 1)
                val message: String
                if (max >= logMessage.length) {
                    message = logMessage.substring(4000 * i)
                } else {
                    message = logMessage.substring(4000 * i, max)
                }

                Log.d(tag, "chunk " + (i + 1) + " of " + (chunkCount + 1) + ":\n" + message)
            }
        } else {
            Log.d(tag, logMessage)
        }
    }

    /**
     * Prints an info message using Android [Log]<br></br>
     * **Should NOT be used for debug purposes as it's unstoppable.**

     * @param  instance    instance of class to use for generating LOG_TAG
     *
     * @param  logMessage  message to logged
     *
     *
     * @see .logTag
     */
    fun i(instance: Any, logMessage: String) {
        Log.i(logTag(instance), logMessage)
    }

    /**
     * Prints a warning message using Android [Log]<br></br>
     * **Should NOT be used for debug purposes as it's unstoppable.**

     * @param  instance    instance of class to use for generating LOG_TAG
     *
     * @param  logMessage  message to logged
     *
     *
     * @see .logTag
     */
    fun w(instance: Any, logMessage: String) {
        Log.w(logTag(instance), logMessage)
    }

    /**
     * Prints an error message using Android [Log]<br></br>
     * **Should NOT be used for debug purposes as it's unstoppable.**

     * @param  instance    instance of class to use for generating LOG_TAG
     *
     * @param  logMessage  message to logged
     *
     *
     * @see .logTag
     */
    fun e(instance: Any, logMessage: String) {
        Log.e(logTag(instance), logMessage)
    }

    /**
     * Same as [.e] but with a `throwable` to log exceptions as well<br></br>
     * **Tip:** Exceptions should always be accompanied by an explanation of why it occurred<br></br>
     * **Should NOT be used for debug purposes as it's unstoppable**

     * @param  instance    instance of class to use for generating LOG_TAG
     *
     * @param  logMessage  message to logged
     *
     * @param  throwable   a throwable object to log stacktrace of
     *
     *
     * @see .e
     * @see .logTag
     */
    fun e(instance: Any, logMessage: String,
          throwable: Throwable) {
        Log.e(logTag(instance), logMessage, throwable)
    }

    /**
     * Prints an WTF (What a Terrible Failure) message using Android [Log]<br></br>
     * **Should NOT be used for debug purposes as it's unstoppable.**

     * @param  instance    instance of class to use for generating LOG_TAG
     *
     * @param  logMessage  message to logged
     *
     *
     * @see .logTag
     */
    fun wtf(instance: Any, logMessage: String) {
        Log.wtf(logTag(instance), logMessage)
    }

    /**
     * Same as [.wtf] but with a `throwable` to log exceptions as well<br></br>
     * **Tip:** Exceptions should always be accompanied by an explanation of why it occurred<br></br>
     * **Should NOT be used for debug purposes as it's unstoppable**

     * @param  instance    instance of class to use for generating LOG_TAG
     *
     * @param  logMessage  message to logged
     *
     * @param  throwable   a throwable object to log stacktrace of
     *
     *
     * @see .wtf
     * @see .logTag
     */
    fun wtf(instance: Any, logMessage: String,
            throwable: Throwable) {
        Log.wtf(logTag(instance), logMessage, throwable)
    }
}

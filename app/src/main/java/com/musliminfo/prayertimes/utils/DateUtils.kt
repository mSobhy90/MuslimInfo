package com.musliminfo.prayertimes.utils

import com.musliminfo.prayertimes.Logger
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    val DEFAULT_REQUEST_DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd",
            Locale.ENGLISH)
    val DEFAULT_TIMESTAMP_FORMAT = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
    val DEFAULT_HUMAN_READABLE_TIMESTAMP_FORMAT = SimpleDateFormat("MMM d, EEE",
            Locale.ENGLISH)
    private val DEFAULT_RESPONSE_DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",
            Locale.ENGLISH)

    /**
     * Formats dates to the following format [.DEFAULT_REQUEST_DATE_FORMAT].

     * @param   dateToFormat  to be formatted to the default formatter
     *
     *
     * @return  the formatted string representation of the provided date
     */
    fun formatDateToDefaultRequestFormat(dateToFormat: Date): String {
        return formatDateToString(dateToFormat, DEFAULT_REQUEST_DATE_FORMAT)
    }

    /**
     * Formats dates using the provided `dateFormat`.

     * @param   dateToFormat  to be formatted to the default formatter
     *
     * @param   dateFormat    to be used to format the provided date
     *
     *
     * @return  the formatted string representation of the provided date
     */
    fun formatDateToString(dateToFormat: Date, dateFormat: DateFormat): String {
        return dateFormat.format(dateToFormat)
    }

    /**
     * Extracts date out of the provided `formattedDate` using [.DEFAULT_RESPONSE_DATE_FORMAT].

     * @param   formattedDate  to be converted to date
     *
     *
     * @return  the date object representation of the provided date string
     */
    fun formatResponseDateStringToDate(formattedDate: String): Date {
        return formatStringToDate(formattedDate, DEFAULT_RESPONSE_DATE_FORMAT)
    }

    /**
     * Extracts date out of the provided `formattedDate` using the provided `dateFormat`.

     * @param   formattedDate  to be converted to date
     *
     * @param   dateFormat     to be used to parse the provided date string
     *
     *
     * @return  the date object representation of the provided date string
     */
    fun formatStringToDate(formattedDate: String, dateFormat: DateFormat): Date {
        try {
            return dateFormat.parse(formattedDate)
        } catch (e: ParseException) {
            Logger.w(this,
                    "Invalid date format provided, formattedDate = " + formattedDate.toString() + " dateFormat = "
                            + dateFormat.toString() + "\n Returning today's date as a replacement.")
            return Calendar.getInstance().time
        }

    }

    /**
     * Constructs a date object that maps to the data of the next weekday matching the provided `weekday`.

     * @param   weekday  to get date at (protip: use [Calendar.MONDAY]...)
     *
     *
     * @return  the constructed date object
     */
    @JvmOverloads fun getNextDateForDay(weekday: Int, dateToCheckFrom: Date = Calendar.getInstance().time): Date {
        val nextDateForDayWeekDayFromDate = Calendar.getInstance()
        nextDateForDayWeekDayFromDate.time = dateToCheckFrom

        while (nextDateForDayWeekDayFromDate.get(Calendar.DAY_OF_WEEK) != weekday) {
            nextDateForDayWeekDayFromDate.add(Calendar.DATE, 1)
        }

        return nextDateForDayWeekDayFromDate.time
    }
}

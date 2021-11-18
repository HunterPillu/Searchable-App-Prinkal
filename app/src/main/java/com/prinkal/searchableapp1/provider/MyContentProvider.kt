package com.prinkal.searchableapp1.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.prinkal.searchableapp1.database.DatabaseBuilder
import com.prinkal.searchableapp1.database.DatabaseHelperImpl

class MyContentProvider : ContentProvider() {
    companion object {
        /**
         * Authority name can be of any constant String.
         */
        private const val AUTHORITY_NAME = "ContentProviderSample.Contacts"

        /**
         * Base name can be of any constant String
         */
        private const val BASE_NAME = "iDoAndroid"

        /**
         * Constants
         */
        private const val CONTACTS = 1
        private const val CONTACTS_GET_BY_SYNC_ID = 2

        /**
         * Utility class uses to match the URI of ContentProviders
         */
        private val URI_MATCHER = UriMatcher(UriMatcher.NO_MATCH)

        init {
            URI_MATCHER.addURI(AUTHORITY_NAME, BASE_NAME + "contacts", CONTACTS)
            URI_MATCHER.addURI(AUTHORITY_NAME, BASE_NAME + "contacts/sync", CONTACTS_GET_BY_SYNC_ID)
        }
    }

    override fun onCreate(): Boolean {
        return true
    }

    /**
     * Query method is used to query the database of an application and cursor will be returned
     *
     * @param uri           uri to access the application
     * @param projection    list of column in the given table
     * @param selection     selection string
     * @param selectionArgs selection arguments
     * @param sortOrder     sorting order of the results
     * @return              cursor
     */
    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? {

        // Get the instance of SQLiteDatabase

        val dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(context!!))
        var cursor: Cursor? = null

        // Match the uri
        val uriType = URI_MATCHER.match(uri)

        // Check whether requested columns are present in database. If not then throw exception
        //checkColumns(projection, uriType)
        when (uriType) {
            CONTACTS -> {
                /**
                 * setTables is to set the list of tables to be queried.
                 */
                cursor = dbHelper.getSearchedResultAsCursor(selection!!, selection)
                //Log.e("prinkal-query",Gson().toJson(cursor))

                /**
                 * Now query it accordingly as per the requirement. In CONTACTS I will retrieve all
                 * the contacts from table. So selection, selectionArgs, having and groupBy are null
                 */

                /**
                 * This is register to watch the content uri changes.
                 */
                cursor.setNotificationUri(context!!.contentResolver, uri)
            }
            CONTACTS_GET_BY_SYNC_ID -> {
            }
        }
        return cursor
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    /**
     * Insert data into database client application
     *
     * @param uri       uri reference in an application
     * @param values    data to be inserted as content values
     * @return          uri
     */
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return uri
    }

    /**
     * Delete the data from the database
     *
     * @param uri           uri of an reference
     * @param selection     selection statement to delete query
     * @param selectionArgs selection arguments to delete query
     * @return              integer, no of rows affected
     */
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {

        return 0
    }

    /**
     * Update data in the database
     * @param uri           uri reference to the process
     * @param values        content values to be updated
     * @param selection     where clause condition
     * @param selectionArgs arguments for the selection clause
     * @return              integer, number of rows affected (updated)
     */
    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 0
    }
}
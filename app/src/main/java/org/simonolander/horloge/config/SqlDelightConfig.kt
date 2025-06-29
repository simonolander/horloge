package org.simonolander.horloge.config

import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

class SqlDelightConfig(
    schema: SqlSchema<QueryResult.Value<Unit>>,
) : AndroidSqliteDriver.Callback(schema) {
    override fun onConfigure(db: SupportSQLiteDatabase) {
        super.onConfigure(db)
        db.query("PRAGMA journal_mode=WAL;")
        db.query("PRAGMA busy_timeout=3000;")
    }
}

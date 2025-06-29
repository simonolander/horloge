package org.simonolander.horloge.config

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.simonolander.horloge.infrastructure.db.ChimeRepository
import org.simonolander.horloge.infrastructure.db.chime.ChimeDatabase
import org.simonolander.horloge.infrastructure.db.chime.ChimeQueries

private enum class SqlDrivers {
    CHIME,
}

val horlogeModule =
    module {
        single<SqlDriver>(named(SqlDrivers.CHIME)) {
            AndroidSqliteDriver(
                schema = ChimeDatabase.Schema,
                context = androidContext(),
                name = "chime.db",
                callback = SqlDelightConfig(ChimeDatabase.Schema),
            )
        }

        single {
            ChimeQueries(get(named(SqlDrivers.CHIME)))
        }

        singleOf(::ChimeRepository)
    }

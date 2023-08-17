package com.example.ceramaster.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class DatabaseMigration {
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase){
            database.execSQL(
                "CREATE TABLE glazes (\n" +
                        "                id              INTEGER     PRIMARY KEY,\n" +
                        "                isCommon        BOOLEAN ,\n" +
                        "                nameGlaze       TEXT    ,\n" +
                        "                article         TEXT,\n" +
                        "                countryOriginal TEXT,\n" +
                        "                manufacturer    TEXT,\n" +
                        "                minTemp         INTEGER,\n" +
                        "                maxTemp         INTEGER  ,\n" +
                        "                CTE             INTEGER,\n" +
                        "                effect          TEXT,\n" +
                        "                color           TEXT,\n" +
                        "                massStock       DOUBLE )"
            )
        }
    }
}
package com.example.ceramaster.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class DatabaseMigration {
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase){
            database.execSQL(
                "CREATE TABLE glazes (\n" +
                        "                id              INT     PRIMARY KEY,\n" +
                        "                isCommon        BOOLEAN NOT NULL,\n" +
                        "                nameGlaze       TEXT    NOT NULL,\n" +
                        "                article         TEXT,\n" +
                        "                countryOriginal TEXT,\n" +
                        "                manufacturer    TEXT,\n" +
                        "                minTemp         INT,\n" +
                        "                maxTemp         INT     NOT NULL,\n" +
                        "                CTE             INT,\n" +
                        "                effect          TEXT,\n" +
                        "                color           TEXT,\n" +
                        "                massStock       DOUBLE  NOT NULL)"
            )
        }
    }
}
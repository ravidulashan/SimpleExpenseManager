package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ravidu Lashan on 04/12/2015.
 */
public abstract class AbstractDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "130037X.db";

    public static final String ACC_Col_NAME = "accounts";
    public static final String ACC_NO_COL_NAME = "accountNo";
    public static final String BANK_COLUMN_NAME = "bankName";
    public static final String ACC_HOLDER_NAME = "accountHolderName";
    public static final String BALANCE_NAME = "balance";
    public static final String EX_TYPE_NAME = "type";
    public static final String AMT_NAME = "amount";
    public static final String DATE_NAME = "date";

    public AbstractDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE accounts " +
                        "(accountNo TEXT PRIMARY KEY NOT NULL, bankName TEXT NOT NULL,accountHolderName TEXT NOT NULL,balance REAL NOT NULL)"
        );
        sqLiteDatabase.execSQL(
                "CREATE TABLE transactions " +
                        "(accountNo TEXT NOT NULL, type INTEGER NOT NULL,date TEXT NOT NULL,amount REAL NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS transactions");
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS accounts");
        onCreate(sqLiteDatabase);
    }
}

package com.example.apparquivo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CalendarioActivity extends AppCompatActivity {

    private SQLiteCalendarDB dbHandler;
    private EditText editText;
    private CalendarView calendarView;
    private String selectedDate;
    private SQLiteDatabase sqLiteDatabase;
    private TextView myDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        editText = (EditText) findViewById(R.id.editTxt);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myDate = (TextView) findViewById(R.id.myDate);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String  date = dayOfMonth + "/" + (month + 1) + "/" + year;
                myDate.setText(date);

                selectedDate = Integer.toString(dayOfMonth) + Integer.toString(month) + Integer.toString(year);
                ReadDataBase(view);

            }
        });

        try {
            dbHandler = new SQLiteCalendarDB(this, "CalendarDB", null, 1);
            sqLiteDatabase = dbHandler.getWritableDatabase();
            sqLiteDatabase.execSQL("CREATE TABLE EventCalendar(Date TEXT, Event TEXT)");
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void InsertDataBase(View view) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("Date", selectedDate);
        contentValues.put("Event", editText.getText().toString());
        sqLiteDatabase.insert("EventCalendar", null, contentValues);

    }

    public void ReadDataBase(View view) {
        String query = "Select Event from EventCalendar where Date =" + selectedDate;
        try{
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            cursor.moveToFirst();
            editText.setText(cursor.getString(0));
        }
        catch (Exception e) {
            e.printStackTrace();
            editText.setText("");
        }

    }
}
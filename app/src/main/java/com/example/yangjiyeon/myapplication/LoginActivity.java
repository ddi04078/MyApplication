package com.example.yangjiyeon.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class
LoginActivity extends AppCompatActivity {

    private MySQLiteOpenHelper helper;
    String dbName = "st_file.db";
    int dbVersion = 1; // 데이터베이스 버전
    private SQLiteDatabase db;
    String tag = "SQLite"; // Log 에 사용할 tag


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //register.xml과 똑같이 id로 각 뷰를 얻어서 변수에 저장
        EditText idText = (EditText) findViewById(R.id.idText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        TextView registerButton = (TextView) findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent loginIntent = new Intent(LoginActivity.this, UserPreferenceActivity.class);
                LoginActivity.this.startActivity(loginIntent);
            }
        });

        //registerButton(텍스트뷰) 클릭시 발생하는 이벤트
        registerButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        // sqLite3 : 모바일 용으로 제작된 경량화 DB
        // C언어로 엔진이 제작되어 가볍다
        // 안드로이드에서 sqLite3 를 쉽게 사용할 수 있도록 SQLiteOpenHelper클래스제공
        helper = new MySQLiteOpenHelper(
                this,  // 현재 화면의 제어권자
                dbName,// db 이름
                null,  // 커서팩토리-null : 표준커서가 사용됨
                dbVersion);       // 버전

        try {
//         // 데이터베이스 객체를 얻어오는 다른 간단한 방법
//         db = openOrCreateDatabase(dbName,  // 데이터베이스파일 이름
//                          Context.MODE_PRIVATE, // 파일 모드
//                          null);    // 커서 팩토리
//
//         String sql = "create table mytable(id integer primary key autoincrement, name text);";
//        db.execSQL(sql);

            db = helper.getWritableDatabase(); // 읽고 쓸수 있는 DB
            //db = helper.getReadableDatabase(); // 읽기 전용 DB select문
        } catch (SQLiteException e) {
            e.printStackTrace();
            Log.e(tag, "데이터베이스를 얻어올 수 없음");
            finish(); // 액티비티 종료
        }

        insert (); // insert 문 - 삽입추가

        select(); // select 문 - 조회

        update(); // update 문 - 수정변경

        delete(); // delete 문 - 삭제 행제거

        select();
    } // end of onCreate

    void delete() {
        db.execSQL("delete from mytable where id=2;");
        Log.d(tag, "delete 완료");
    }

    void update() {
        db.execSQL("update mytable set name='Park' where id=5;");
        Log.d(tag, "update 완료");
    }

    void select() {
        Cursor c = db.rawQuery("select * from mytable;", null);
        while(c.moveToNext()) {
            int id = c.getInt(0);
            String name = c.getString(1);
            Log.d(tag,"id:"+id+",name:"+name);
        }
    }

    void insert () {
        db.execSQL("insert into mytable (name) values('Seo');");
        db.execSQL("insert into mytable (name) values('Choi');");
        db.execSQL("insert into mytable (name) values('Park');");
        db.execSQL("insert into mytable (name) values('Heo');");
        db.execSQL("insert into mytable (name) values('Kim');");
        Log.d(tag, "insert 성공~!");
    }


}

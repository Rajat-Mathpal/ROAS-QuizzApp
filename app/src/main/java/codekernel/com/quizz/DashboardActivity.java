package codekernel.com.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void ClickDBMS (View v){

        Intent intent =new Intent(DashboardActivity.this,QuestionActivity1.class);
        startActivity(intent);
    }
    public void Result(View v){
        Intent intent = new Intent(DashboardActivity.this,ResultActivity.class);
        startActivity(intent);
    }
    public void Help(View v){
        Intent intent = new Intent(DashboardActivity.this,QuestionActivity1.class);
        startActivity(intent);
    }
    public void GeneralQuiz (View v){
        Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
        startActivity(intent);
    }


}

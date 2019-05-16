package codekernel.com.quizz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    String result;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    Map<String,String> map;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

        btn=findViewById(R.id.resultBtn);
        t1=(TextView)findViewById(R.id.textView5);
        t2=(TextView)findViewById(R.id.textView6);
        t3=(TextView)findViewById(R.id.textView7);
        map=new HashMap<>();
        result="10";

        Intent i=getIntent();

        String questions = i.getStringExtra("total");
        String correct = i.getStringExtra("correct");
        String wrong = i.getStringExtra("incorrect");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.put("Result",result);
                String uid=firebaseAuth.getCurrentUser().getUid().toString();
                firebaseFirestore.collection("Result").document(uid).set(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(ResultActivity.this,"result saved",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


    }
}

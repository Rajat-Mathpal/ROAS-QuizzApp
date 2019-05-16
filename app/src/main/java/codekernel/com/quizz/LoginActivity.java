package codekernel.com.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText uName;
    EditText uPassword;
    Button login;


    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uName = (EditText)findViewById(R.id.user_name);
        uPassword = (EditText)findViewById(R.id.user_password);
        login = (Button) findViewById(R.id.login);

        firebaseAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String userName = uName.getText().toString();
                final String password = uPassword.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(userName,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                            finish();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Signup Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            uName.setText("");
                            uPassword.setText("");

                            if(task.getException().getMessage().contains("already in use by another account")){
                                loginUser(userName,password);
                            }
                        }
                    }
                });

//

            }
        });



        firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(LoginActivity.this,Dasboard.class));
                    finish();
                }
            }
        });



    }


    public void loginUser(String user, String pass){
        firebaseAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    uName.setText("");
                    uPassword.setText("");

                }
            }
        });
    }



}

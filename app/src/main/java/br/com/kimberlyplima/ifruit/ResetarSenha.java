package br.com.kimberlyplima.ifruit;

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
import com.google.firebase.auth.SignInMethodQueryResult;

public class ResetarSenha extends AppCompatActivity {

    private Button btnResetarSenha;
    FirebaseAuth firebaseAuth;
    TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetar_senha);

        firebaseAuth = FirebaseAuth.getInstance();

        btnResetarSenha = findViewById(R.id.btn_reset_pwd);

        txtEmail = findViewById(R.id.txt_email_reset_pwd);

        btnResetarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetarSenha(v);
            }
        });

    }

    public void resetarSenha(View v){
        firebaseAuth.fetchSignInMethodsForEmail(txtEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
            @Override
            public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                boolean check = !task.getResult().getSignInMethods().isEmpty();
                if(!check){
                    Toast.makeText(ResetarSenha.this, "E-mail inexistente na base" , Toast.LENGTH_LONG).show();
                } else {

                }
            }
        });
    }
}

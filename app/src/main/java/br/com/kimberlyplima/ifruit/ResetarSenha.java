package br.com.kimberlyplima.ifruit;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;

import org.w3c.dom.Text;

public class ResetarSenha extends AppCompatActivity {

    private Button btnResetarSenha;
    FirebaseAuth firebaseAuth;
    TextView txtEmail;
//    TextView txtSenha2;
//    TextView txtSenha1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetar_senha);

        firebaseAuth = FirebaseAuth.getInstance();

        btnResetarSenha = findViewById(R.id.btn_reset_pwd);

        txtEmail = findViewById(R.id.txt_email_reset_pwd);
//        txtSenha1 = findViewById(R.id.txt_pwd_first);
//        txtSenha2 = findViewById(R.id.txt_pwd_confirm);


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
                    recuperarSenha(txtEmail.getText().toString());
                }
            }
        });
    }

    private void recuperarSenha(String email) {
//        if(!senha1.equals(senha2)){
//            Toast.makeText(ResetarSenha.this, "As senhas não conferem" , Toast.LENGTH_LONG).show();
//            return;
//        } else {
            FirebaseUser user = firebaseAuth.getCurrentUser();
//            user.updatePassword(senha1).addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//                    if(task.isSuccessful()){
//                        Toast.makeText(ResetarSenha.this, "Senha alterada com sucesso!" , Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(ResetarSenha.this, MainActivity.class));
//                    }
//                    else{
//                        Toast.makeText(ResetarSenha.this, "Erro ao alterar a senha..." , Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
            firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(ResetarSenha.this, "Siga as instruções enviadas ao seu e-mail!" , Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ResetarSenha.this, MainActivity.class));
                    } else {
                        Toast.makeText(ResetarSenha.this, "Erro ao recuperar a senha..." , Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
//    }
}

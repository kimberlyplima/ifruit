package br.com.kimberlyplima.ifruit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCadastro;
    private EditText txtSenha;
    private EditText txtSenha2;
    private EditText txtEmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtSenha = (EditText) findViewById(R.id.txt_senha);
        txtEmail = (EditText) findViewById(R.id.txt_email);
        txtSenha2 = (EditText) findViewById(R.id.txt_senha2);
        btnCadastro = (Button) findViewById(R.id.btn_cadastro);
        mAuth = FirebaseAuth.getInstance();


        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoSenha = txtSenha.getText().toString();
                String textoEmail = txtEmail.getText().toString();
                String textoSenha2 = txtSenha2.getText().toString();
                if(TextUtils.isEmpty(textoSenha) || TextUtils.isEmpty(textoSenha2) || TextUtils.isEmpty(textoEmail)){
                    Toast.makeText(CadastroActivity.this, "O preenchimento dos campos e obrigatorio" , Toast.LENGTH_LONG).show();
                }else if(!textoSenha.equals(textoSenha2)){
                    Toast.makeText(CadastroActivity.this, "As senhas não conferem" , Toast.LENGTH_LONG).show();
                } else {
                    cadastrarUsuario(textoEmail, textoSenha);
                }
            }
        });
    }

    private void cadastrarUsuario(String email , String senha){
        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(CadastroActivity.this, LojaVirtualActivity.class));
                            Toast.makeText(CadastroActivity.this, "Usuario cadastrado com sucesso",Toast.LENGTH_LONG).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(CadastroActivity.this, "Falha ao cadastrar usuario.",
                                    Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
}

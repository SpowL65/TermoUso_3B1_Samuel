package com.example.termodeuso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmButton = (Button) findViewById(R.id.confirmButton);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkboxView);

        final EditText nameInput = (EditText) findViewById(R.id.nameInput);
        final EditText cpfInput = (EditText) findViewById(R.id.cpfInput);
        final EditText phoneInput = (EditText) findViewById(R.id.phoneInput);
        final EditText emailInput = (EditText) findViewById(R.id.emailInput);


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Erro :(");
                if(nameInput.getText().toString().matches("")){
                    builder.setMessage("Insira seu NOME!");
                }else if(cpfInput.getText().toString().matches("")){
                    builder.setMessage("Insira seu CPF!");
                }else if(phoneInput.getText().toString().matches("")){
                    builder.setMessage("Insira seu TELEFONE!");
                }else if(emailInput.getText().toString().matches("")){
                    builder.setMessage("Insira seu EMAIL!");
                }else if(!checkBox.isChecked()){
                    builder.setMessage("Você precisa concordar com os termos de uso!");
                }else{
                    builder.setTitle(":)");
                    builder.setMessage("Usuário cadastrado");
                }

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alerta = builder.create();
                alerta.show();
            }
        });



    }
}

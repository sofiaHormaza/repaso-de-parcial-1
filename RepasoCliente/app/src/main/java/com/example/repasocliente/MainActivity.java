package com.example.repasocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    ComunicacionTCP comm;
    private Button enviar;
    private EditText posX;
    private EditText posY;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar=findViewById(R.id.enviarBtn);
        posX=findViewById(R.id.posX);
        posY=findViewById(R.id.posY);
        message=findViewById(R.id.message);

        comm=new ComunicacionTCP(this);
        comm.solicitarConexion();

        enviar.setOnClickListener(
                (v)->{
                    String pX=posX.getText().toString();

                    String pY=posY.getText().toString();

                    String mensaj=message.getText().toString();

                    comm.mandarMensaje(pX+":"+pY+":"+mensaj);
                }
        );

    }
}

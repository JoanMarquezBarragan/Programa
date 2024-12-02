//Començar important llibreries
package com.example.programafinal;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import android.media.session.MediaController;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

// Declarar TODO
    TextView Titulo, T1, T2, T3, T4, R1, R2, R3, R4;
    Button b1;
    EditText EN1, EN2, EN3, EN4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Conectar textos
        Titulo = (TextView) findViewById(R.id.Titulo);
        T1 = (TextView) findViewById(R.id.T1);
        T2 = (TextView) findViewById(R.id.T2);
        T3 = (TextView) findViewById(R.id.T3);
        T4 = (TextView) findViewById(R.id.T4);
        R1 = (TextView) findViewById(R.id.R1);
        R2 = (TextView) findViewById(R.id.R2);
        R3 = (TextView) findViewById(R.id.R3);
        R4 = (TextView) findViewById(R.id.R4);

        //Conectar boton
        b1 = (Button) findViewById(R.id.b1);

        //Conectar textos editables
        EN1 = (EditText) findViewById(R.id.EN1);
        EN2 = (EditText) findViewById(R.id.EN2);
        EN3 = (EditText) findViewById(R.id.EN3);
        EN4 = (EditText) findViewById(R.id.EN4);


        //Fer funcionar el boto
        b1.setOnClickListener(new View.OnClickListener() {

            //Funcionar amb el boto pres
            @Override
            public void onClick(View view) {

                //convertilos en Variables "float"
                String val1= EN1.getText().toString();
                String val2= EN2.getText().toString();
                String val3= EN3.getText().toString();
                String val4= EN4.getText().toString();

                float Num1 = Float.parseFloat(val1);
                float Num2 = Float.parseFloat(val2);
                float Num3 = Float.parseFloat(val3);
                float Num4 = Float.parseFloat(val4);


                //Declarar Valors
                float Amin = 45;
                float Amax =60;
                float Vmin = 1;
                float Vmax = 5;
                float Vel1;
                float Vel2;
                float Vel;
                float t = 1;

                //Declarar frases d'ajuda
                String Ang;
                String Vol;

                //Comprobar angulo
                if( Amin > Num1 ){
                    Ang ="Proba a elevar més el braç.";
                }
                else if( Amax < Num1 ){
                    Ang = "Baixa el braç.";
                }
                else {
                    Ang = "Mante el angle, esta bé.";
                }

                //Comprobar voltes
                if( Vmin >= Num2 ){
                    Vol = "Dona més cop de canell.";
                }
                else if (Vmax < Num2 ) {
                    Vol = "Dona menys cop de canell.";
                }
                else  {
                    Vol = "Bon cop de canell.";
                }

                // Buscar velocitat
                Vel1=(Num4/t);
                Vel2 = (float) (((-Num3) +4.9 * pow(t, 2) + 3.0) / t);
                Vel= (float) sqrt(pow(Vel1,2) + pow(Vel2, 2));

                R1.setText(Ang);
                R2.setText(Vol);
                R3.setText("La velocitat aproximada que hauries de aconseguir és de " +  Vel+ "m/s.");
                R4.setText("Segueix aixì.");

            }
        });
    }
}
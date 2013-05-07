package com.asccode.myteam;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main extends Activity {

    private EditText etTotalJogadores;
    private TextView tvJogadoresTime1;
    private TextView tvJogadoresTime2;
    private Button botaoOK;
    private Button botaoSORTEAR;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etTotalJogadores = (EditText) findViewById(R.id.etTotalJogadores);
        tvJogadoresTime1 = (TextView) findViewById(R.id.tvJogadoresTime1);
        tvJogadoresTime2 = (TextView) findViewById(R.id.tvJogadoresTime2);
        botaoOK = (Button) findViewById(R.id.botaoOK);
        botaoSORTEAR = (Button) findViewById(R.id.botaoSORTEAR);

        botaoOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                etTotalJogadores.setText("12");
                tvJogadoresTime1.setText("0");
                tvJogadoresTime2.setText("0");

                botaoSORTEAR.setVisibility(1);

            }

        });

        botaoSORTEAR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int numRand =  (int)( 2 * Math.random() );

                int total = Integer.parseInt( etTotalJogadores.getEditableText().toString() );

                int totalJogadoresTime1 = Integer.parseInt ( tvJogadoresTime1.getText().toString() );
                int totalJogadoresTime2 = Integer.parseInt ( tvJogadoresTime2.getText().toString() );

                if(numRand == 0){     // Cola time 1

                    if( totalJogadoresTime1 < Math.ceil( total/2 ) ){

                        tvJogadoresTime1.setText( String.valueOf( ++totalJogadoresTime1 ) );

                        Toast.makeText(Main.this, "TIME 1", Toast.LENGTH_LONG).show();

                    }else if( totalJogadoresTime2 < Math.ceil( total/2 ) ){

                        tvJogadoresTime2.setText( String.valueOf( ++totalJogadoresTime2 ) );

                        Toast.makeText(Main.this, "TIME 2", Toast.LENGTH_LONG).show();


                    }

                }else{ // cola time 2

                    if( totalJogadoresTime2 < Math.ceil( total/2 ) ){

                        tvJogadoresTime2.setText( String.valueOf( ++totalJogadoresTime2 ) );

                        Toast.makeText(Main.this, "TIME 2", Toast.LENGTH_LONG).show();

                    }else if( totalJogadoresTime1 < Math.ceil( total/2 ) ){

                        tvJogadoresTime1.setText( String.valueOf( ++totalJogadoresTime1 ) );

                        Toast.makeText(Main.this, "TIME 1", Toast.LENGTH_LONG).show();

                    }

                }

            }

        });

    }
}

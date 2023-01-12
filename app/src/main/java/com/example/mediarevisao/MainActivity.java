package com.example.mediarevisao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNota1;
    EditText etNota2;
    EditText etNota3;
    EditText etNota4;
    TextView tvMedia;
    ImageView imgSituacao;
    TextView tvSituacao;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNota1 = findViewById(R.id.etNota1);
        etNota2 = findViewById(R.id.etNota2);
        etNota3 = findViewById(R.id.etNota3);
        etNota4 = findViewById(R.id.etNota4);
        tvMedia = findViewById(R.id.tvMedia);
        imgSituacao = findViewById(R.id.ivSituacaco);
        tvSituacao = findViewById(R.id.tvSituacao);
        btCalcular = findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double media = calcularMedia();

                tvMedia.setText( String.valueOf( media ) );
                tvSituacao.setText( validarSituacao( media ) );


            }
        });

    }

    public double calcularMedia() {
        double media , n1, n2, n3, n4;
        n1 = Double.parseDouble(etNota1.getText().toString());
        n2 = Double.parseDouble(etNota2.getText().toString());
        n3 = Double.parseDouble(etNota3.getText().toString());
        n4 = Double.parseDouble(etNota4.getText().toString());

        media = (n1 + n2 + n3 + n4) / 4;
        return media;
    }

    public String validarSituacao( double media ) {
        String situacao;
        if ( media >= 7 ) {
            situacao = "APROVADO";
            imgSituacao.setImageResource(R.drawable.ap);
            Toast.makeText(this, "PARABÉNS !!!", Toast.LENGTH_SHORT).show();
        } else {
            situacao = "REPROVADO";
            imgSituacao.setImageResource(R.drawable.rp);
            Toast.makeText(this, "SE FERROU !!!", Toast.LENGTH_SHORT).show();
        }
        return situacao;
    }

    public void reiniciar( View view ) {
        etNota1.setText("");
        etNota2.setText("");
        etNota3.setText("");
        etNota4.setText("");
        tvMedia.setText("-");
        imgSituacao.setImageResource(R.drawable.inte);
        tvSituacao.setText("Situação");
    }

}
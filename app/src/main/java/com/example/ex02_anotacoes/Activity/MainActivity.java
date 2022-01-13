package com.example.ex02_anotacoes.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ex02_anotacoes.Fragment.CriarNotaFragment;
import com.example.ex02_anotacoes.Fragment.LerNotaFragment;
import com.example.ex02_anotacoes.R;

public class MainActivity extends AppCompatActivity {

    Button btnCriar, btnVer;
    CriarNotaFragment criarNotaFragment;
    LerNotaFragment lerNotaFragment;
    public static final String NOME_ARQUIVO="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCriar = findViewById(R.id.btnCriar);
        btnVer = findViewById(R.id.btnVer);

        criarNotaFragment = new CriarNotaFragment();
        lerNotaFragment = new LerNotaFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, criarNotaFragment);
        transaction.commit();

        btnCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, criarNotaFragment);
                transaction.commit();
            }
        });

        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, lerNotaFragment);
                transaction.commit();
            }
        });

    }
}
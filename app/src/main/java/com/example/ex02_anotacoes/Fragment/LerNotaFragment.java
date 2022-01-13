package com.example.ex02_anotacoes.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ex02_anotacoes.Activity.MainActivity;
import com.example.ex02_anotacoes.R;

public class LerNotaFragment extends Fragment {

    TextView textView;

    public LerNotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ler_nota, container, false);

        textView = v.findViewById(R.id.textView);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(MainActivity.NOME_ARQUIVO, 0);
        String mensagem = sharedPreferences.getString("texto", "Nenhum texto salvo");
        textView.setText(mensagem);

        return v;
    }
}
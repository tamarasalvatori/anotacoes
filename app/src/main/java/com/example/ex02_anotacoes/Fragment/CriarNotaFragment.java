package com.example.ex02_anotacoes.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ex02_anotacoes.Activity.MainActivity;
import com.example.ex02_anotacoes.R;
import com.example.ex02_anotacoes.Utils.AudioPlayer;

public class CriarNotaFragment extends Fragment {

    EditText editText;
    Button btnSalvar;

    public CriarNotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_criar_nota, container, false);

        editText = v.findViewById(R.id.editText);
        btnSalvar = v.findViewById(R.id.btnSalvar);

        final SharedPreferences sharedPreferences = getContext().getSharedPreferences(MainActivity.NOME_ARQUIVO, 0);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(!editText.getText().toString().equals("")){
                    editor.putString("texto", editText.getText().toString());
                    editor.commit();
                    editText.getText().clear();
                    Toast.makeText(getContext(),"Dados salvos com sucesso!", Toast.LENGTH_LONG).show();
                    AudioPlayer.playAudio(getContext(), R.raw.ok);
                }else {
                    Toast.makeText(getContext(),"Preencha o campo anotações!", Toast.LENGTH_LONG).show();
                    AudioPlayer.playAudio(getContext(), R.raw.no);
                }
            }
        });

        return v;
    }
}
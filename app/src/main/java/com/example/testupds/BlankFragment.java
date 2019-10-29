package com.example.testupds;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class BlankFragment extends Fragment {

    private String u,campo;
    int punt;

    TextView tvTituño, tv1, tv2,tv3, tv4, tv5;
    private OnFragmentInteractionListener mListener;

    public BlankFragment() {

    }

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           // u = getArguments().getString("username");
            //punt = getArguments().getInt("nota");
            campo = getArguments().getString("campo");

            Log.i("exito","recibido: "+punt+u+" campo"+campo);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_blank, container, false);
        tvTituño = view.findViewById(R.id.textViewTitulo);
        tvTituño.setText(campo);
        if(campo!=null)
        switch (campo){
            case "aire_libre":
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("AL AIRE LIBRE");
                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("INGENIERIA HAMBIENTAL");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("INGENIER@S AGRÓNOM@S");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("INGENIERIA MINERA");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText(" POLICIA");

                tv5 = view.findViewById(R.id.textView5);
                tv5.setText("PROFESOR DE EDUCACION FÍSICA");
                break;
            case "artistico":
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("ARTISTICO PLASTICO");
                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("ARQUITECTURA");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("DISEÑADOR");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("ESCULTOR");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText("PINTOR");

                tv5 = view.findViewById(R.id.textView5);
                tv5.setText("DIBUJANTE");
                break;
            case "calculo":
                Log.i("exito","entro a calculo");
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("CALCULO");

                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("AUDITOR");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("CONTADOR PUBLICO");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("ECONOMISTA");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText("ESTADISTICA, FUNCIONARIOS BANCARIOS");

                tv5 = view.findViewById(R.id.textView5);
                tv5.setText("MATEMATICAS");
                break;
            case "cientifico":
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("CIENTIFICO");

                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("MEDICINA");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("FISICOS");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("ODONTOLOGIA");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText("TECNICOS DE LABORATORIO");

                tv5 = view.findViewById(R.id.textView5);
                tv5.setText("QUIMICA Y PSICOLOGIA");
                break;
            case "literario":
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("LITERARIO");

                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("PROFESORES (LITERARIOS)");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("PERIODISTA");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("LINGUISTA");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText("ESCRITORES");
                break;
            case "mecanico_constructivo":
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("MECANICO CONSTRUCTIVO");

                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("INGENIERIA DE SISTEMAS");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("INGENIERIA CIVIL");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("INGENIERIA INDUSTRIAL");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText("INGENIERIA MECÁICA");

                tv5 = view.findViewById(R.id.textView5);
                tv5.setText("ING. ELECTRICA, MECATRONICA");
                break;
            case "musical":
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("MUSICA");

                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("COMPOSITORES");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("MÚSICOS");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("PROFESORES DE MUSICA");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText("DANZA");
                break;
            case "ofisina":
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("TRABAJO DE OFICINA");

                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("INGENIERIA DE SISTEMAS");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("INGENIERIA INFORMATICA");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("CONTABILIDAD");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText("MANEJO DE COMPUTADORAS");

                tv5 = view.findViewById(R.id.textView5);
                tv5.setText("SECRETARI@");
                break;
            case "persuasivo":
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("PERSUASIVO");

                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("DERECHO");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("ADMINISTRACION DE EMPRESAS");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("NEGOCIOS, AGENTES DE PUBLICIDAD");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText("PERIODISTA");

                tv5 = view.findViewById(R.id.textView5);
                tv5.setText("POLITICOS");
                break;
            case "servicio_social":
                tvTituño = view.findViewById(R.id.textViewTitulo);
                tvTituño.setText("SERVICIO SOCIAL");

                tv1 = view.findViewById(R.id.textView1);
                tv1.setText("ENFERMERIA");

                tv2 = view.findViewById(R.id.textView2);
                tv2.setText("MEDICINA");

                tv3 = view.findViewById(R.id.textView3);
                tv3.setText("PEDAGOG@S EN GENERAL");

                tv4 = view.findViewById(R.id.textView4);
                tv4.setText("TRABAJO SOCIAL");

                tv5 = view.findViewById(R.id.textView5);
                tv5.setText("PSICOLOGIA");
                break;
                default:
                    tvTituño = view.findViewById(R.id.textViewTitulo);
                    tvTituño.setText("PORFAVOR COMPLETAR EL TEST PARA MOSTRAR UN RESULTADO");
                    break;
        }
        else{
            tvTituño = view.findViewById(R.id.textViewTitulo);
            tvTituño.setText("PORFAVOR COMPLETAR EL TEST PARA MOSTRAR UN RESULTADO");
        }
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

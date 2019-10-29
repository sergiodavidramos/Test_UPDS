package com.example.testupds;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.testupds.questionsFragment.OnListFragmentInteractionListener;
import java.util.List;

public class MyquestionsFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MyquestionsFragmentRecyclerViewAdapter.ViewHolder> {

    private final List<questions> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyquestionsFragmentRecyclerViewAdapter(List<questions> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.respuestasfragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.txtPregunta.setText(holder.mItem.getPregunta());
        if(holder.mItem.getRespuesta()==1){
            holder.rb1.setText("ME DESAGRADA MUCHO");
            holder.rb1.setChecked(true);
        }
        if(holder.mItem.getRespuesta()==2){
            holder.rb1.setText("NO ME GUSTA");
            holder.rb1.setChecked(true);
        }
        if(holder.mItem.getRespuesta()==3){
            holder.rb1.setText("ME ES INDIFERENTE");
            holder.rb1.setChecked(true);
        }
        if(holder.mItem.getRespuesta()==4){
            holder.rb1.setText("ME GUSTA");
            holder.rb1.setChecked(true);
        }
        if(holder.mItem.getRespuesta()==5){
            holder.rb1.setText("ME GUSTA MUCHO");
            holder.rb1.setChecked(true);
        }



        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtPregunta;
        public final RadioButton rb1;
        public questions mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtPregunta =view.findViewById(R.id.textViewP);
            rb1 = view.findViewById(R.id.radioButton1);

    }

        @Override
        public String toString() {
            return super.toString() + " '" + txtPregunta.getText() + "'";
        }
    }
}

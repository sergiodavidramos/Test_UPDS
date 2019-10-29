package com.example.testupds;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testupds.InitFragmentFragment.OnListFragmentInteractionListener;
import java.util.List;



public class MyInitFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MyInitFragmentRecyclerViewAdapter.ViewHolder> {

    private final List<Test> mValues;
    private final OnListFragmentInteractionListener mListener;
    int cont=0;

    public MyInitFragmentRecyclerViewAdapter(List<Test> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_initfragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        cont++;
        holder.mItem = mValues.get(position);
        holder.tvTitulo.setText("ETAPA "+cont+": TEST "+holder.mItem.getNombreTest());
        holder.imView.setImageResource(holder.mItem.image);
       // holder.setText(holder.mItem.getNombreTest());

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
        public final ImageView imView;
        public final TextView tvTitulo;
        public final Button btnEnqueConsiste;
        public final Button btnTest;
        public final Button btnResult;
        public final CardView cardView;
        public final RelativeLayout rLayout;
        public Test mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imView = view.findViewById(R.id.imageView);
            tvTitulo = view.findViewById(R.id.textView);
            btnEnqueConsiste = view.findViewById(R.id.buttonEnqueConsiste);
            btnTest= view.findViewById(R.id.buttonTest);
            btnResult= view.findViewById(R.id.buttonResult);
            cardView= view.findViewById(R.id.cardView);
            rLayout= view.findViewById(R.id.relative);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitulo.getText() + "'";
        }
    }
}

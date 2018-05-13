package br.com.felix.horizontalbargraph.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.com.felix.horizontalbargraph.BarView;
import br.com.felix.horizontalbargraph.R;
import br.com.felix.horizontalbargraph.interfaces.OnItemClickListener;
import br.com.felix.horizontalbargraph.model.BarItem;

/**
 * Created by user on 12/01/2018.
 */

public class BarItemRecycleViewAdapter extends RecyclerView.Adapter<BarItemRecycleViewAdapter.ItemViewHolder> {


    private static final String TAG = "BarAdapter";
    private Double maxValue = 0.0;
    private List<BarItem> items;
    private OnItemClickListener listener;

    public BarItemRecycleViewAdapter(List<BarItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
        getBiggerValue(items);
    }

    private void getBiggerValue(List<BarItem> items) {
        for (BarItem item : items) {
            if ( item.getValue1 () > maxValue ) {
                this.maxValue = item.getValue1 ();
            }

            if ( item.getValue2 () != null && item.getValue2 () > maxValue ) {
                this.maxValue = item.getValue2 ();
            }
        }

        this.maxValue += this.maxValue * 0.3;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_balanco, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        BarItem viewModel = getItem(position);
        holder.txtDesciption.setText(viewModel.getDescription());

        holder.barView1.setText (viewModel.getText1 ());
        holder.barView1.setColors (viewModel.getTextColorBar1 (), viewModel.getColorBar1 ());

        float percent = getPercent (viewModel.getValue1 ());
        holder.barView1.setPercentage (percent);

        if (viewModel.getValue2() != null && viewModel.getValue2() >= 0) {
            holder.barView2.txtValue.setText (viewModel.getText2 ());
            holder.barView2.setColors (viewModel.getTextColorBar2 (), viewModel.getColorBar2 ());

            percent = getPercent(viewModel.getValue2());
            holder.barView2.setPercentage (percent);
        } else {
            holder.barView1.setVisibility (View.VISIBLE);
            holder.barView2.setVisibility (View.GONE);
        }

    }

    private float getPercent (Double value) {
        Double percent = (value / maxValue);
        return percent.floatValue ();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public BarItem getItem(int position) {
        return items.get(position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtDesciption;
        public LinearLayout llRoot;
        public BarView barView1, barView2;

        public ItemViewHolder(View view) {
            super(view);
            txtDesciption = view.findViewById(R.id.txtMes);

            barView1 = view.findViewById (R.id.barView1);
            barView2 = view.findViewById (R.id.barView2);

            llRoot = view.findViewById(R.id.llRoot);
            llRoot.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClick(items.get(getAdapterPosition()));
            }
        }
    }
}
package com.example.coronavirushelplines;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>  implements Filterable {

   private List<StatesModel> states;
   private List<StatesModel> stateFilter;
    Context context;

    public HomeAdapter( Context context){
        this.context = context;
    }


    @NonNull
    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.states,parent,false);
        return new HomeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeViewHolder holder, int position) {
        holder.stateNumber.setText(states.get(position).getNumber());
        holder.state.setText(states.get(position).getState());

        final String getStateNumber = states.get(position).getNumber();
        final String getState = states.get(position).getState();
        final String getHotlineOne = states.get(position).getHotlineOne();
        final String getHotlineTwo = states.get(position).getHotlineTwo();
        final String getRegion = states.get(position).getRegion();

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Hotlines.class);
                    intent.putExtra("state", getState);
                    intent.putExtra("hotlineOne", getHotlineOne);
                    intent.putExtra("hotlineTwo", getHotlineTwo);
                    intent.putExtra("region", getRegion);
                    context.startActivity(intent);

                }
            });
    }

    @Override
    public int getItemCount() {
        return states == null ? 0 : states.size();
    }

    public void setStateAdapterItems(List<StatesModel> states){
        if (states != null) {
            if(this.states != null) this.states.clear();
            this.states = states;
            stateFilter = new ArrayList<>(states);
            notifyDataSetChanged();
        } else return;
    }

    public void setFilteredStates(List<StatesModel> filteredStates) {
        if (filteredStates == null) return;
        if(states != null) states.clear();
        states = filteredStates;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<StatesModel> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0) {
                filteredList.addAll(stateFilter);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (StatesModel item : stateFilter ){
                    if(item.getState().toLowerCase().trim().contains(filterPattern))
                        filteredList.add(item);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            states.clear();
            states.addAll((List<StatesModel>) results.values);
            notifyDataSetChanged();
        }
    };



    public class HomeViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView state;
        AppCompatTextView stateNumber;


        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            state = itemView.findViewById(R.id.state);
            stateNumber = itemView.findViewById(R.id.stateNumber);

        }
    }
}

package com.example.masukov.touristapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AttractionListFragment extends Fragment {

    private RecyclerView mAttractionRecyclerView;
    private AttractionAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attraction_list, container, false);
        mAttractionRecyclerView = (RecyclerView) view.findViewById(R.id.attraction_recycler_view);
        mAttractionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI(){
        AttractionLab attractionLab = AttractionLab.get(getActivity());
        List<Attraction> attractions = attractionLab.getAttractions();
        mAdapter = new AttractionAdapter(attractions);
        mAttractionRecyclerView.setAdapter(mAdapter);
    }

    private class AttractionHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mDataTextView;
        private Attraction mAttraction;

        public AttractionHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_attraction, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.attraction_title);
            mDataTextView = (TextView) itemView.findViewById(R.id.attraction_date);
        }

        public void bind(Attraction attraction){
            mAttraction = attraction;
            mTitleTextView.setText(mAttraction.getTitle());
            mDataTextView.setText(mAttraction.getDate().toString());
        }

        public void onClick(View view){
            Toast.makeText(getActivity(), mAttraction.getTitle()+" clicked", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private class AttractionAdapter extends RecyclerView.Adapter<AttractionHolder>{

        private List<Attraction> mAttractions;

        public AttractionAdapter(List<Attraction> attractions){
            mAttractions = attractions;
        }

        @NonNull
        @Override
        public AttractionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new AttractionHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AttractionHolder holder, int position) {

            Attraction attraction = mAttractions.get(position);
            holder.bind(attraction);
        }

        @Override
        public int getItemCount() {
            return mAttractions.size();
        }
    }
}

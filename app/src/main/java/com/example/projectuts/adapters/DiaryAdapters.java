package com.example.projectuts.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuts.R;
import com.example.projectuts.models.Diary;

import java.util.List;

public class DiaryAdapters extends RecyclerView.Adapter<DiaryAdapters.ViewHolder> {

    public interface OnItemDiaryListener {
        void onDiaryClicked(int index, Diary item);
    }

    private List<Diary> items;
    private OnItemDiaryListener listener;

    public DiaryAdapters(List<Diary> items, OnItemDiaryListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_diary, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Diary item = items.get(position);
        holder.bind(position, item);
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleView, dateView, momentView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title_view);
            dateView = itemView.findViewById(R.id.date_view);
            momentView = itemView.findViewById(R.id.moment_view);
        }

        public void bind(final int index, final Diary item) {
            dateView.setText(item.getDate());
            titleView.setText(item.getTitle());
            momentView.setText(item.getMoment());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDiaryClicked(index, item);
                }
            });
        }
    }
}

package com.example.studentinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentinfo.Models.StudentInfo;
import com.example.studentinfo.R;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    Context context;
    List<StudentInfo> infoList;

    public InfoAdapter(Context context, List<StudentInfo> infoList) {
        this.context = context;
        this.infoList = infoList;
    }

    @NonNull
    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.info_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.ViewHolder holder, int position) {
        holder.nameTxtv.setText(infoList.get(position).getFullName());
        holder.courseTxtv.setText(infoList.get(position).getCourse());
        holder.dobTxtv.setText(infoList.get(position).getDob());
        holder.adtimeTxtv.setText(infoList.get(position).getAdTime());
        holder.genderTxtv.setText(infoList.get(position).getGender());
        holder.languageTxtv.setText(infoList.get(position).getLanguages());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTxtv, courseTxtv, dobTxtv, adtimeTxtv, genderTxtv, languageTxtv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTxtv = itemView.findViewById(R.id.nameTxtv);
            courseTxtv = itemView.findViewById(R.id.courseTxtv);
            dobTxtv = itemView.findViewById(R.id.dobTxtv);
            adtimeTxtv = itemView.findViewById(R.id.adtimeTxtv);
            genderTxtv = itemView.findViewById(R.id.genderTxtv);
            languageTxtv = itemView.findViewById(R.id.languageTxtv);
        }
    }
}

package com.example.database.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database.R;
import com.example.database.db.entity.Mahasiswa;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
    private List<Mahasiswa> mahasiswaList;
    private Context context;
    private Dialog dialog;

    public MahasiswaAdapter(List<Mahasiswa> mahasiswaList, Context context) {
        this.mahasiswaList = mahasiswaList;
        this.context = context;
    }

    public interface Dialog{
        void onClick(int position);
    }
    public void setDialog(Dialog dialog){
        this.dialog=dialog;
    }
    @NonNull
    @Override
    public MahasiswaAdapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent,false);
        return new MahasiswaAdapter.MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.MahasiswaViewHolder holder, int position) {
        holder.tvFullName.setText(mahasiswaList.get(position).fullNama);
        holder.tvNpm.setText(mahasiswaList.get(position).npm);

    }

    @Override
    public int getItemCount() {return mahasiswaList.size();}

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        TextView tvFullName, tvNpm;
        public MahasiswaViewHolder(@NonNull View itemView){
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvNpm = itemView.findViewById(R.id.tvNpm);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog != null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }


}

package ir.amirhfarahani.fragmenttest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.amirhfarahani.fragmenttest.Model.DataModel;
import ir.amirhfarahani.fragmenttest.R;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder>
{
    Context context;
    List<DataModel> dataModels;

    public Adapter(Context context, List<DataModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        DataModel data=dataModels.get(position);
        holder.id.setText(data.getId());
        holder.registered_stocks.setText(data.getRegistered_stocks());

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView id,registered_stocks;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            registered_stocks=itemView.findViewById(R.id.registered_stocks);


        }
    }
}

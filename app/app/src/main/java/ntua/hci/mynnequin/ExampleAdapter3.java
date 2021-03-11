package ntua.hci.mynnequin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter3 extends RecyclerView.Adapter<ExampleAdapter3.ExampleViewHolder> implements Filterable {
    private List<ExampleItem2> exampleList;
    private List<ExampleItem2> exampleListFull;
    class ExampleViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView productNameQuantity1;
        TextView productNameQuantity2;
        ExampleViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView1 = itemView.findViewById(R.id.text_view1);
            textView2 = itemView.findViewById(R.id.text_view2);
            textView3 = itemView.findViewById(R.id.item_quantity);
            productNameQuantity1 = itemView.findViewById(R.id.productNameQuantity1);
            productNameQuantity2 = itemView.findViewById(R.id.productNameQuantity2);
        }
    }
    ExampleAdapter3(List<ExampleItem2> exampleList) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item3,
                parent, false);
        return new ExampleViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem2 currentItem = exampleList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
        holder.textView3.setText("Quantity: " + String.valueOf(currentItem.quantity));
        holder.productNameQuantity1.setText(String.valueOf(currentItem.product_name_cart));
        holder.productNameQuantity2.setText(String.valueOf(currentItem.product_name_cart));
    }
    @Override
    public int getItemCount() {
        return exampleList.size();
    }
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ExampleItem2> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ExampleItem2 item : exampleListFull) {
                    if (item.getText2().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}

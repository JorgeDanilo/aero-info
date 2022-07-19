package sistemas.jd.gomes.aeroinfo.presentation.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sistemas.jd.gomes.aeroinfo.R;
import sistemas.jd.gomes.aeroinfo.data.model.Airport;

public class MovieAdapter extends ArrayAdapter<Airport> {

    private Context mContext;
    private List<Airport> moviesList;

    public MovieAdapter(@NonNull Context context, ArrayList<Airport> list) {
        super(context, 0, list);
        mContext = context;
        moviesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_selecte, parent, false);

        Airport currentAirport = moviesList.get(position);

        TextView name = listItem.findViewById(R.id.tvName);
        name.setText(currentAirport.getName());

        TextView code = listItem.findViewById(R.id.tvCode);
        code.setText(currentAirport.getCod());

        return listItem;
    }
}
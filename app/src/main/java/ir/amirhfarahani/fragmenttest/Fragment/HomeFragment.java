package ir.amirhfarahani.fragmenttest.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ir.amirhfarahani.fragmenttest.Adapter.Adapter;
import ir.amirhfarahani.fragmenttest.Model.DataModel;
import ir.amirhfarahani.fragmenttest.R;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<DataModel>dataModels;
    Adapter adapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataModels=new ArrayList<>();
        loadData();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.first_recyclerview);

        recyclerView.setHasFixedSize(true);
        adapter=new Adapter(getContext(),dataModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);



        return view;
    }


    public void loadData()
    {
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, "", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try {

                    JSONArray jsonArray = response.getJSONArray("results");
                    if (jsonArray.length() != 0) {
                        for (int i = 0; i < jsonArray.length(); i++)
                        {
                            JSONObject jsonObject_results = jsonArray.getJSONObject(i);


                            String id=jsonObject_results.getString("id");
                            String registered_stocks = jsonObject_results.getString("registered_stocks");

                            DataModel data=new DataModel(id,registered_stocks);
                            dataModels.add(data);



                        }
                    }

                    //load_allProperty(BaseUrl);

                    //load_allProperty(BaseUrl);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("error", e.toString());
                    Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("error_res",error.toString());

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
package edu.northsouth.krishokiot.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eclipsesource.json.JsonObject;

import java.io.IOException;

import edu.northsouth.krishokiot.R;
import edu.northsouth.krishokiot.constants.SettingsConstant;
import edu.northsouth.krishokiot.networks.RequestPoster;

public class LandFragment extends Fragment {
    private EditText etLandType;
    private EditText etSqft;
    private EditText etLat;
    private EditText etLon;
    private Button btnSave;

    private String landType;
    private double sqft;
    private double lat;
    private double lon;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_land, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etLandType = view.findViewById(R.id.etLand);
        etLat = view.findViewById(R.id.et_lat);
        etLon = view.findViewById(R.id.et_lon);
        etSqft = view.findViewById(R.id.et_sqft);
        btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                landType = etLandType.getText().toString();
                sqft = Double.parseDouble(etSqft.getText().toString());
                lat = Double.parseDouble((etLat.getText().toString()));
                lon = Double.parseDouble((etLon.getText().toString()));

                JsonObject requestObject = new JsonObject();
                requestObject.add("landType", landType);
                requestObject.add("sqft", sqft);
                requestObject.add("lat", lat);
                requestObject.add("lon", lon);

                RequestPoster requestPoster = new RequestPoster();
                try {
                    System.out.println(requestObject.toString());
                    String result = requestPoster.post(SettingsConstant.BASE_URL + SettingsConstant.LAND_SAVE_END_POINT, requestObject.toString());
                    if (result.equals("true")) {
                        Toast.makeText(getContext(), "Land Saved Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                    etLat.setText("");
                    etLon.setText("");
                    etLandType.setText("");
                    etSqft.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

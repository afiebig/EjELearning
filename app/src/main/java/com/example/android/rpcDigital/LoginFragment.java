package com.example.android.rpcDigital;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginFragment extends Fragment implements  View.OnClickListener   {

    private Button btnLoginJson;

    private EditText username, password;

    private ProgressDialog pDialog;

    private String urlJsonLogin = "http://www.ingvaldiviavivar.com/api/login";

    private static String TAG = LoginFragment.class.getSimpleName();

    private TextView txtResponse;

    private String jsonResponse;

    private  JsonObjectRequest jsonReq;

    public LoginFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        btnLoginJson = (Button) rootView.findViewById(R.id.login_button);
        btnLoginJson.setOnClickListener(this);

        username = (EditText) rootView.findViewById(R.id.useredittext);
        password = (EditText) rootView.findViewById(R.id.passedittext);

        txtResponse = (TextView) rootView.findViewById(R.id.txtvresponse);

        return rootView;
    }

    public void onClick(View v) {
        String user, pass;
        user = username.getText().toString();
        pass = password.getText().toString();

        txtResponse.setText(makeJsonObjectRequest(user,pass));

        AppController.getInstance().getRequestQueue().add(jsonReq);


    }

    private String makeJsonObjectRequest(String user, String pass) {

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("username",user);
        params.put("password",pass);
        urlJsonLogin = urlJsonLogin + "?username=" + user + "&password=" + pass;

        jsonReq = new JsonObjectRequest(Method.POST,
                urlJsonLogin, null, new Response.Listener<JSONObject>() {

            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    String login = response.getString("login");
                    String permissions = response.getString("permissions");
                    String access_token = response.getString("access_token");
                    String expires_in = response.getString("expires_in");
                    String refresh_token = response.getString("refresh_token");


                    jsonResponse = "";
                    jsonResponse += "login: " + login + "\n\n";
                    jsonResponse += "permissions: " + permissions + "\n\n";
                    //jsonResponse += "access_token: " + access_token + "\n\n";
                    //jsonResponse += "expires_in: " + expires_in + "\n\n";
                    //jsonResponse += "refresh_token: " + refresh_token + "\n\n";

                    txtResponse.setText(jsonResponse);

                } catch (JSONException e) {
                    e.printStackTrace();
                    jsonResponse = "Acceso Denegado Favor Revise sus credenciales";
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                jsonResponse = "Acceso Denegado Favor Revise sus credenciales";
            }
        });

        urlJsonLogin = "http://www.ingvaldiviavivar.com/api/login";
        return jsonResponse;
    }

}


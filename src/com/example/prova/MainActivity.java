package com.example.prova;

import java.io.UnsupportedEncodingException;

import com.example.prova.core.Constants;
import com.exmple.prova.connection.Connection;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dialog = new ProgressDialog(MainActivity.this);
		dialog.setMessage("carregando...");
		dialog.show();
		new TesteCon().execute();
	}

	private class TesteCon extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
			try {
				//
//				Connection.getPairs().clear();
//				Connection.createParam("nome", "coco");
//				String result =	 Connection.sendRequestPost(Constants.URL);

				String result =	 Connection.sendRequestGet(Constants.URL+"nome="+"coco");
				return result;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {

			dialog.dismiss();

			if (result != null) {
				Log.i(Constants.TAG, result);
			}

			super.onPostExecute(result);
		}

	}
}

package course.examples.FragmentDynamicLayout;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuotesFragment extends Fragment {

	private TextView mQuoteView = null;
	private int mCurrIdx = -1;

	private static final String TAG = "Quotes Fragment";

	public int getShownIndex() {
		return mCurrIdx;
	}

	public void showQuote(int newIndex, String strQuote){
		//Actualizamos el índice de la cita actual
		mCurrIdx = newIndex;
		//Establecemos el TextView al texto de la cita
		//Que lo obtenemos del array de citas que está declarado en la QuoteViewerActivity
		mQuoteView.setText(strQuote);
	}

	@Override
	public void onAttach(Activity activity) {
		Log.d(TAG, getClass().getSimpleName() + ":entered onAttach()");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, getClass().getSimpleName() + ":entered onCreate()");
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, getClass().getSimpleName() + ":entered onCreateView()");
		return inflater.inflate(R.layout.quote_fragment, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		//Se crea la activity. Ya podemos instanciar nuestros objets
		//el TextView donde mostrar las citas
		//el array de citas
		Log.d(TAG, getClass().getSimpleName() + ":onActivityCreated()");
		super.onActivityCreated(savedInstanceState);
		mQuoteView = (TextView) getActivity().findViewById(R.id.quoteView);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.d(TAG, getClass().getSimpleName() + ": onConfigurationChanged()");
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onStart() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	public void onResume() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}

	@Override
	public void onPause() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onStop()");
		super.onStop();
	}

	@Override
	public void onDetach() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onDetach()");
		super.onDetach();
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.d(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
		super.onDestroyView();
	}

}

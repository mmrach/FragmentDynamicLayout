package course.examples.FragmentDynamicLayout;

import android.app.Activity;
import android.app.ListFragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import course.examples.FragmentDynamicLayout.R;

public class TitlesFragment extends ListFragment {
	//Extiende de ListFragment, para poder gestionar los eventos de seleccion de la lista.

	//Declaramos un ListSelectionListener (interface) que lo instanciamos a null
	//Se instanciará a algo distinto de null cuando alguien implemente la interfaz
	//en este caso la QuoteViewerActivity con lo que el mListener pasará a ser la propia
	//QuoteViewerActivity
	private ListSelectionListener mListener = null;

	private static final String TAG = "Titles Fragment";

	//Declararmos el ListSeletionListener, nuestra interfaz.
	public interface ListSelectionListener {
		//Con un método onListSelection al que deberá darle código el que implemente
		//la interfaz.
		public void onListSelection(int index);  //Será llamado para propagar el evento
		public String[] getTitles();             //Será llamado para obetner la lista de titulos
	}

	@Override
	public void onListItemClick(ListView l, View v, int pos, long id) {
		//Recibimos una selección en la lista
		//Como la clase es un ListFragment tiene el método getListView mediante
		//el que accede al widget ListView y marcamos a true el elemento en la posición que me pasan
		Log.d(TAG, getClass().getSimpleName() + ":entered onListItemClick()");
		getListView().setItemChecked(pos, true);

		//Llamamos al onListSelection(pos) del listnener para que haga su acción.
		mListener.onListSelection(pos);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d(TAG, getClass().getSimpleName() + ":entered onAttach()");
		try {
			mListener = (ListSelectionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnArticleSelectedListener");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, getClass().getSimpleName() + ":entered onCreate()");
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Log.d(TAG, getClass().getSimpleName() + ":entered onCreateView()");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedState) {
		super.onActivityCreated(savedState);
		Log.d(TAG, getClass().getSimpleName() + ":entered onCreate()");
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.title_item, mListener.getTitles()));
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
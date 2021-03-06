package com.dmurphy.dnd.csheet.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dmurphy.dnd.csheet.MainActivity;
import com.dmurphy.dnd.csheet.R;
import com.dmurphy.dnd.csheet.character.Race;

public class RaceFragment extends Fragment {
	private MainActivity activity;
	private Vibrator vibe;
	private TextView title;
	private TextView name;
	private TextView description;
	private ImageView picture;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.race_class_fragment, container,
				false);

		activity = (MainActivity) getActivity();
		vibe = activity.getVibe();

		final Button previous = (Button) v.findViewById(R.id.previousButton);
		final Button next = (Button) v.findViewById(R.id.nextButton);

		title = (TextView) v.findViewById(R.id.abilityName);
		title.setText(R.string.race);

		name = (TextView) v.findViewById(R.id.name);
		name.setText("");

		description = (TextView) v.findViewById(R.id.description);
		description
				.setText("Click on a race to find out more information about racial bonuses and features.");

		picture = (ImageView) v.findViewById(R.id.picture);
		picture.setImageResource(R.drawable.idle);

		next.setEnabled(false);
		next.setAlpha(0.3f);
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				vibe.vibrate(50);
				activity.swapFragment(new ClassFragment(), "class_fragment");
			}
		});

		previous.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vibe.vibrate(50);
				getFragmentManager().popBackStack();
			}
		});

		ListView listView = (ListView) v.findViewById(R.id.raceClassList);
		final ArrayList<String> list = new ArrayList<String>();

		final List<Race> races = activity.getRaces();

		for (Race race : races) {
			list.add(race.getName());
		}

		final StableArrayAdapter adapter = new StableArrayAdapter(
				v.getContext(), android.R.layout.simple_list_item_1, list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Race race = races.get(position);
				new SetImageTask(race, parent.getContext()).execute(race.getPicName());
				activity.getCharacter().setRace(race);
				next.setEnabled(true);
				next.setAlpha(1f);
			}
		});

		try {
			Race race = activity.getCharacter().getRace();
			new SetImageTask(race, v.getContext()).execute(race.getPicName());
			next.setEnabled(true);
			next.setAlpha(1f);
		} catch (NullPointerException e) {

		}

		return v;
	}

	private class SetImageTask extends AsyncTask<String, Void, Bitmap> {
		/**
		 * The system calls this to perform work in a worker thread and delivers
		 * it the parameters given to AsyncTask.execute()
		 */
		private Context context;
		private Race race;

		private SetImageTask(Race race, Context context) {
			this.context = context;
			this.race = race;
		}

		protected Bitmap doInBackground(String... urls) {
			return BitmapFactory.decodeResource(
					context.getResources(),
					context.getResources().getIdentifier(urls[0], "drawable",
							context.getPackageName()));
		}

		/**
		 * The system calls this to perform work in the UI thread and delivers
		 * the result from doInBackground()
		 */
		protected void onPostExecute(Bitmap result) {
			picture.setImageBitmap(result);
			name.setText(race.getName());
			description.setText(race.getDescription());
		}
	}

	private class StableArrayAdapter extends ArrayAdapter<String> {

		HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		public StableArrayAdapter(Context context, int textViewResourceId,
				List<String> objects) {
			super(context, textViewResourceId, objects);
			for (int i = 0; i < objects.size(); ++i) {
				mIdMap.put(objects.get(i), i);
			}
		}

		@Override
		public long getItemId(int position) {
			String item = getItem(position);
			return mIdMap.get(item);
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

	}

}

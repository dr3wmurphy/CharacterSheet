package com.dmurphy.dnd.csheet.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dmurphy.dnd.csheet.MainActivity;
import com.dmurphy.dnd.csheet.R;

public class LoadFragment extends Fragment {
	private MainActivity activity;
	private Vibrator vibe;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.list_fragment, container, false);
		
		activity = (MainActivity) getActivity();
		vibe = activity.getVibe();
		
		Button cancel = (Button) v.findViewById(R.id.previousButton);
		cancel.setText(R.string.cancel);
		
		Button load = (Button) v.findViewById(R.id.nextButton);
		load.setText(R.string.load);
		
		TextView title = (TextView) v.findViewById(R.id.abilityName);
		title.setText(R.string.load_character);

		load.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				vibe.vibrate(50);
				activity.swapFragment(new SheetFragment(), "character_sheet");
			}
		});
		
		cancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vibe.vibrate(50);
				getFragmentManager().popBackStack();
			}	
		});

		return v;
	}

}

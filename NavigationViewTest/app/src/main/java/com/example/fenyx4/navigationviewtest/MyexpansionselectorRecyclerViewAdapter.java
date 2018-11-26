package com.example.fenyx4.navigationviewtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.content.Context;

import com.example.fenyx4.navigationviewtest.expansionSelectorFragment.OnListFragmentInteractionListener;

import java.io.IOException;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display an {@link Expansion} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MyexpansionselectorRecyclerViewAdapter extends RecyclerView.Adapter<MyexpansionselectorRecyclerViewAdapter.ViewHolder> {

    private final List<Expansion> mExpansions;
    private final OnListFragmentInteractionListener mListener;

    public MyexpansionselectorRecyclerViewAdapter(List<Expansion> expansions, OnListFragmentInteractionListener listener) {
        mExpansions = expansions;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_expansionselector, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Expansion expansion = mExpansions.get(position);
        holder.mItem = expansion;
        holder.mIdView.setText(mExpansions.get(position).getName());
        holder.mIdView.setChecked(holder.mItem.getApplied());
        //holder.mContentView.setText(mValues.get(position).content);

        StateListDrawable myStates = new StateListDrawable();
        int stateChecked = android.R.attr.state_checked;

        Bitmap checkOffBMP;
        try {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inScaled = true;
            opts.inDensity = 120;//DisplayMetrics.DENSITY_MEDIUM;
            Rect padding = new Rect();
            opts.inTargetDensity = holder.mIdView.getResources().getDisplayMetrics().densityDpi;
            checkOffBMP = BitmapFactory.decodeStream(holder.mIdView.getContext().getAssets().open(expansion.getCheckboxOffPath()), padding, opts);

            BitmapDrawable checkOffDrawable = new BitmapDrawable(checkOffBMP);
            myStates.addState(new int[]{ -stateChecked }, checkOffDrawable);
            Bitmap checkOnBMP = BitmapFactory.decodeStream(holder.mIdView.getContext().getAssets().open(expansion.getCheckboxOnPath()), padding, opts);
            BitmapDrawable checkOnDrawable = new BitmapDrawable(checkOnBMP);
            myStates.addState(new int[]{ stateChecked }, checkOnDrawable);
            holder.mIdView.setButtonDrawable(myStates);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mExpansions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final CheckBox mIdView;
        //public final TextView mContentView;
        public Expansion mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (CheckBox) view.findViewById(R.id.number_entry);

            Typeface tf = Typeface.createFromAsset(mIdView.getContext().getAssets(),"fonts/se-caslon-ant.ttf");
            mIdView.setTypeface(tf);


        }

        @Override
        public String toString() {
            return super.toString() + " '" + mIdView.getText() + "'";
        }
    }
}

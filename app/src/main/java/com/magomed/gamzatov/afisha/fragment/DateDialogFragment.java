package com.magomed.gamzatov.afisha.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.magomed.gamzatov.afisha.R;

public class DateDialogFragment extends DialogFragment{
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] dates = {"1", "2", "3", "4", "5", "6"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.action_date)
                .setItems(dates, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), dates[which],Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();
    }
}

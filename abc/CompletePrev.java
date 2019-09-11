package com.mellakhi.foudhil.abc;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class CompletePrev extends AppCompatDialogFragment {

    Button ok;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog builder = new AlertDialog.Builder(getActivity()).create();


        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.complete_prev_dialog, null);

        view.setBackgroundColor(Color.argb(1,0,0,0));

        ok = view.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        });

        builder.setView(view);
        return builder;
    }

}

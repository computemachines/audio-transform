package com.computemachines.audiotransform;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tparker on 5/23/16.
 */
public class MicrophoneDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View layout = getActivity().getLayoutInflater().inflate(R.layout.fragment_microphone, null);
        initListeners(layout);
        builder.setView(layout);
        return builder.create();
    }
    private void initListeners(View layout) {
        layout.findViewById(R.id.microphone_cancel).setOnClickListener(new View.OnClickListener() {
            public DialogFragment dialogFragment;

            @Override
            public void onClick(View v) {
                dialogFragment.dismiss();
            }
            public View.OnClickListener init(DialogFragment dialogFragment){
                this.dialogFragment = dialogFragment;
                return this;
            }
        }.init(this));
    }
}

package com.pd.fairytailstore.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.pd.fairytailstore.R;

public class DialogFragmentAboutUs  extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//Диалог который не боится поворотов. Можно из него чего-то братьи передавать, например пользовательские настройки и пр
        View view = getLayoutInflater().inflate(R.layout.about_us,null);// Фрегмент диалог не имеет своей активити
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setMessage("Тут будет история  разработчике приложения ")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("mylogs", "Пользователь почитал о нас" + i);
                        dismiss();
                    }
                });

        return builder.create();
    }
}

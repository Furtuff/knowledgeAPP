package fr.wildcodeschool.eateam.knowledgeishere;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tuffery on 09/12/16.
 */

public class CustomAdapterWithCalendar extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<String> list;
    boolean[] checkBoxState;
    View customView;
    Button dateButton;

    public CustomAdapterWithCalendar(Context context, ArrayList<String> list) {
        //super(context, R.layout.list_view_item);
        this.context = context;
        this.list = list;
        checkBoxState = new boolean[list.size()];
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //(LayoutInflater.from(getContext()));


        customView = inflater.inflate(R.layout.calendar_listview, parent, false);
        ViewGroup.LayoutParams params = customView.getLayoutParams();
        params.height = 200;
        final CheckBox text = (CheckBox) customView.findViewById(R.id.checkBox2);
        this.dateButton = (Button)customView.findViewById(R.id.dateButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(dateButton);
                Toast.makeText(customView.getContext(),"Next update", Toast.LENGTH_SHORT).show();
            }
        });
        text.setText(list.get(position));
        if(checkBoxState[position]){
            text.setChecked(true);
        }
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    text.setChecked(true);
                    checkBoxState[position] = true;
                }else{
                    text.setChecked(false);
                    checkBoxState[position] = false;
                }
            }
        });
        return customView;

    }
    public void showDatePicker(final Button datePickerShowDialogButton) {
        // Initializiation
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        View customView = inflater.inflate(R.layout.custom_date_picker, null);
        dialogBuilder.setView(customView);
        final Calendar now = Calendar.getInstance();
        final DatePicker datePicker = (DatePicker) customView
                .findViewById(R.id.dialog_datepicker);
        final TextView dateTextView = (TextView) customView
                .findViewById(R.id.dialog_dateview);
        final SimpleDateFormat dateViewFormatter = new SimpleDateFormat(
                "EEEE, dd.MM.yyyy");
        final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        // Minimum date

        // View settings
        dialogBuilder.setTitle("Choose a date");
        Calendar choosenDate = Calendar.getInstance();
        int year = choosenDate.get(Calendar.YEAR);
        int month = choosenDate.get(Calendar.MONTH);
        int day = choosenDate.get(Calendar.DAY_OF_MONTH);
        try {
            Date choosenDateFromUI = formatter.parse(datePickerShowDialogButton
                    .getText().toString());
            choosenDate.setTime(choosenDateFromUI);
            year = choosenDate.get(Calendar.YEAR);
            month = choosenDate.get(Calendar.MONTH);
            day = choosenDate.get(Calendar.DAY_OF_MONTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar dateToDisplay = Calendar.getInstance();
        dateToDisplay.set(year, month, day);
        dateTextView.setText(dateViewFormatter.format(dateToDisplay.getTime()));
        // Buttons
        dialogBuilder.setNegativeButton("Go to today",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        datePickerShowDialogButton.setText(formatter.format(now
                                .getTime()));
                        dialog.dismiss();
                    }
                });
        dialogBuilder.setPositiveButton("Choose",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Calendar choosen = Calendar.getInstance();
                        choosen.set(datePicker.getYear(),
                                datePicker.getMonth(),
                                datePicker.getDayOfMonth());
                        datePickerShowDialogButton.setText(dateViewFormatter
                                .format(choosen.getTime()));
                        dialog.dismiss();
                    }
                });
        final AlertDialog dialog = dialogBuilder.create();
        // Initialize datepicker in dialog atepicker
        datePicker.init(year, month, day,
                new DatePicker.OnDateChangedListener() {
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        Calendar choosenDate = Calendar.getInstance();
                        choosenDate.set(year, monthOfYear, dayOfMonth);
                        dateTextView.setText(dateViewFormatter
                                .format(choosenDate.getTime()));
                       /* if (choosenDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
                                || now.compareTo(choosenDate) < 0) {
                            dateTextView.setTextColor(Color
                                    .parseColor("#ff0000"));
                            ((Button) dialog
                                    .getButton(AlertDialog.BUTTON_POSITIVE))
                                    .setEnabled(false);
                        } else {
                            dateTextView.setTextColor(Color
                                    .parseColor("#000000"));
                            ((Button) dialog
                                    .getButton(AlertDialog.BUTTON_POSITIVE))
                                    .setEnabled(true);
                        }*/
                    }
                });
        // Finish
        dialog.show();
    }
    //animation du menu
   /* private void launchCalendar() {
        FragmentManager fm = ((Activity) context).getFragmentManager();
        Fragment f = ((Activity) context).getFragmentManager().findFragmentByTag("prout");
        if (f != null) {
            ((Activity) context).getFragmentManager().popBackStack();
        } else {
            ((Activity) context).getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down)
                    .add(R.id.fragmentContainer, CalendarFragment
                                    .instantiate(context, CalendarFragment.class.getName()),
                            "prout"
                    ).addToBackStack(null).commit();
        }
    }
*/

}


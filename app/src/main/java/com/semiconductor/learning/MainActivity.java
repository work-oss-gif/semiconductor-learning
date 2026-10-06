package com.semiconductor.learning;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    // Each lesson: title, explanation, quiz question, three options, index of the right option, why.
    private static final String[][] LESSONS = {
        {
            "1. What is a semiconductor?",
            "Materials fall into three groups by how well they let electric current through.\n\n"
            + "Conductors (copper) let current flow easily. Insulators (rubber) almost block it. "
            + "Semiconductors (silicon) sit in the middle.\n\n"
            + "Why is the middle useful? Because we can CONTROL it. By adding tiny amounts of other "
            + "atoms, or applying a voltage, we can make a semiconductor conduct or not conduct. "
            + "That on/off control is the foundation of every computer chip.",
            "Why are semiconductors so useful in electronics?",
            "They never conduct electricity|Their conductivity can be controlled|They conduct better than copper",
            "1",
            "Their conductivity can be controlled. Copper always conducts and rubber never does, "
            + "but a semiconductor can be switched between the two behaviours."
        },
        {
            "2. Doping: n-type and p-type",
            "Pure silicon conducts poorly. Doping means mixing in a very small number of foreign atoms "
            + "(roughly one in millions).\n\n"
            + "n-type: add phosphorus. It has one extra electron that is free to move. "
            + "(n = negative charge carriers.)\n\n"
            + "p-type: add boron. It is missing an electron, which leaves a 'hole'. "
            + "Neighbouring electrons hop into the hole, so the hole appears to move like a positive charge. "
            + "(p = positive.)\n\n"
            + "Neither type is electrically charged overall. The names describe the carriers, not a net charge.",
            "What is a 'hole' in p-type silicon?",
            "A physical drilled hole in the chip|A missing electron that acts like a positive charge carrier|An extra electron",
            "1",
            "A hole is a missing electron. Nearby electrons keep filling it, so the gap seems to travel."
        },
        {
            "3. The diode",
            "Put p-type and n-type silicon side by side and you get a p-n junction, which is a diode.\n\n"
            + "At the border, electrons and holes cancel out and form a thin 'depletion region' with no free carriers.\n\n"
            + "Forward bias (positive to the p side): the region shrinks and current flows once about 0.7 V "
            + "is reached for silicon.\n\n"
            + "Reverse bias (positive to the n side): the region grows and almost no current flows.\n\n"
            + "So a diode is a one-way valve for current. LEDs are special diodes that also give off light.",
            "What does a diode do?",
            "Lets current flow mainly in one direction|Amplifies any signal|Stores data permanently",
            "0",
            "A diode is a one-way valve: it conducts in forward bias and blocks in reverse bias."
        },
        {
            "4. The transistor",
            "A transistor is a switch with no moving parts, controlled by electricity.\n\n"
            + "Most chips use MOSFETs. A MOSFET has a source, a drain and a gate. "
            + "Between source and drain is a channel. A voltage on the gate creates or removes "
            + "that channel.\n\n"
            + "Gate on: current flows (a '1'). Gate off: no current (a '0').\n\n"
            + "Used gently, a small gate change causes a large current change, so a transistor can also amplify.",
            "In a MOSFET, what controls whether current flows between source and drain?",
            "The voltage on the gate|The colour of the chip|The size of the battery only",
            "0",
            "The gate voltage opens or closes the channel, which is why it works as a switch."
        },
        {
            "5. From transistors to chips",
            "Wire a few transistors together and you get a logic gate such as AND, OR or NOT. "
            + "Combine gates and you can add numbers, store bits and make decisions.\n\n"
            + "A modern processor contains billions of transistors, each one switching billions of times per second.\n\n"
            + "Everything your phone does, from photos to games, is built from huge numbers of these simple on/off switches.",
            "What is a logic gate built from?",
            "A few transistors wired together|A single wire|Magnets",
            "0",
            "Logic gates are small groups of transistors arranged so their outputs follow a rule like AND or NOT."
        },
        {
            "6. How chips are made",
            "1. Grow a pure silicon crystal and slice it into thin discs called wafers.\n"
            + "2. Coat the wafer with a light-sensitive layer.\n"
            + "3. Photolithography: shine light through a patterned mask, like a stencil, to print the circuit.\n"
            + "4. Etch and dope the exposed areas to build transistors.\n"
            + "5. Repeat with dozens of layers, then add metal wiring.\n"
            + "6. Cut the wafer into individual chips and package them.\n\n"
            + "Everything happens in ultra-clean rooms, because a single dust speck can ruin a chip.",
            "What is photolithography used for?",
            "Printing circuit patterns onto the wafer with light|Growing the silicon crystal|Cooling the finished chip",
            "0",
            "Light shone through a mask transfers the circuit pattern onto the wafer, layer by layer."
        }
    };

    private static final int BG = Color.rgb(18, 24, 38);
    private static final int CARD = Color.rgb(32, 42, 64);
    private static final int ACCENT = Color.rgb(80, 170, 255);
    private static final int GOOD = Color.rgb(90, 200, 120);
    private static final int BAD = Color.rgb(230, 100, 100);

    private int current = -1; // -1 = home screen
    private float density;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        density = getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (current < 0) showHome(); else showLesson(current);
    }

    @Override
    public void onBackPressed() {
        if (current >= 0) {
            current = -1;
            showHome();
        } else {
            super.onBackPressed();
        }
    }

    private int dp(int v) {
        return (int) (v * density);
    }

    private LinearLayout newPage() {
        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(BG);
        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(dp(16), dp(32), dp(16), dp(24));
        scroll.addView(page);
        setContentView(scroll);
        return page;
    }

    private TextView text(String s, int sp, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(sp);
        t.setTextColor(color);
        if (bold) t.setTypeface(Typeface.DEFAULT_BOLD);
        t.setPadding(0, dp(6), 0, dp(6));
        return t;
    }

    private Button button(String label, int color) {
        Button b = new Button(this);
        b.setText(label);
        b.setAllCaps(false);
        b.setTextColor(Color.WHITE);
        b.setBackgroundColor(color);
        b.setTextSize(16);
        b.setGravity(android.view.Gravity.START | android.view.Gravity.CENTER_VERTICAL);
        b.setPadding(dp(16), dp(14), dp(16), dp(14));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, dp(6), 0, dp(6));
        b.setLayoutParams(lp);
        return b;
    }

    private void showHome() {
        LinearLayout page = newPage();
        page.addView(text("Semiconductor Learning", 28, Color.WHITE, true));
        page.addView(text("Six short lessons. Each ends with a quiz question.", 16, Color.LTGRAY, false));
        for (int i = 0; i < LESSONS.length; i++) {
            final int index = i;
            Button b = button(LESSONS[i][0], CARD);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current = index;
                    showLesson(index);
                }
            });
            page.addView(b);
        }
    }

    private void showLesson(final int index) {
        String[] lesson = LESSONS[index];
        LinearLayout page = newPage();
        page.addView(text(lesson[0], 24, Color.WHITE, true));
        page.addView(text(lesson[1], 17, Color.rgb(220, 225, 235), false));
        page.addView(text("Quiz: " + lesson[2], 19, ACCENT, true));

        final TextView feedback = text("", 16, Color.WHITE, false);
        String[] options = lesson[3].split("\\|");
        final int correct = Integer.parseInt(lesson[4]);
        final String why = lesson[5];
        for (int i = 0; i < options.length; i++) {
            final int choice = i;
            final Button b = button(options[i], CARD);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (choice == correct) {
                        b.setBackgroundColor(GOOD);
                        feedback.setTextColor(GOOD);
                        feedback.setText("Correct! " + why);
                    } else {
                        b.setBackgroundColor(BAD);
                        feedback.setTextColor(BAD);
                        feedback.setText("Not quite. Try another answer.");
                    }
                }
            });
            page.addView(b);
        }
        page.addView(feedback);

        if (index + 1 < LESSONS.length) {
            Button next = button("Next lesson", ACCENT);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current = index + 1;
                    showLesson(current);
                }
            });
            page.addView(next);
        }
        Button home = button("Back to lessons", CARD);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = -1;
                showHome();
            }
        });
        page.addView(home);
    }
}

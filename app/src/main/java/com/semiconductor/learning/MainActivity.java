package com.semiconductor.learning;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity {

    private static final int BG = Color.rgb(18, 24, 38);
    private static final int CARD = Color.rgb(32, 42, 64);
    private static final int ACCENT = Color.rgb(80, 170, 255);
    private static final int GOOD = Color.rgb(90, 200, 120);
    private static final int BAD = Color.rgb(230, 100, 100);

    // Where the user is: group -1 = home; lesson -1 = the group's lesson list.
    private int group = -1;
    private int lesson = -1;
    private float density;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        density = getResources().getDisplayMetrics().density;
        prefs = getSharedPreferences("progress", MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        render();
    }

    @Override
    public void onBackPressed() {
        if (lesson >= 0) {
            lesson = -1;
            render();
        } else if (group >= 0) {
            group = -1;
            render();
        } else {
            super.onBackPressed();
        }
    }

    private void render() {
        if (group < 0) showHome();
        else if (lesson < 0) showGroup(group);
        else showLesson(group, lesson);
    }

    // ---------------------------------------------------------------- progress

    private boolean isDone(int g, int l) {
        return prefs.getBoolean("done_" + g + "_" + l, false);
    }

    private void markDone(int g, int l) {
        prefs.edit().putBoolean("done_" + g + "_" + l, true).apply();
    }

    private int doneCount(int g) {
        int n = 0;
        for (int l = 0; l < Content.LESSONS[g].length; l++) {
            if (isDone(g, l)) n++;
        }
        return n;
    }

    // ---------------------------------------------------------------- helpers

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
        b.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        b.setPadding(dp(16), dp(14), dp(16), dp(14));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, dp(6), 0, dp(6));
        b.setLayoutParams(lp);
        return b;
    }

    // ---------------------------------------------------------------- screens

    private void showHome() {
        LinearLayout page = newPage();
        int total = 0;
        int done = 0;
        for (int g = 0; g < Content.LESSONS.length; g++) {
            total += Content.LESSONS[g].length;
            done += doneCount(g);
        }
        page.addView(text("Semiconductor Learning", 28, Color.WHITE, true));
        page.addView(text(done + " of " + total + " lessons completed", 16, Color.LTGRAY, false));
        for (int g = 0; g < Content.GROUP_TITLES.length; g++) {
            final int index = g;
            String label = Content.GROUP_TITLES[g] + "\n" + Content.GROUP_BLURBS[g]
                    + "\n" + doneCount(g) + " / " + Content.LESSONS[g].length + " done";
            Button b = button(label, CARD);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    group = index;
                    lesson = -1;
                    render();
                }
            });
            page.addView(b);
        }
    }

    private void showGroup(final int g) {
        LinearLayout page = newPage();
        page.addView(text(Content.GROUP_TITLES[g], 26, Color.WHITE, true));
        page.addView(text(Content.GROUP_BLURBS[g], 16, Color.LTGRAY, false));
        for (int l = 0; l < Content.LESSONS[g].length; l++) {
            final int index = l;
            String mark = isDone(g, l) ? "✓  " : "○  ";
            Button b = button(mark + Content.LESSONS[g][l][0], CARD);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lesson = index;
                    render();
                }
            });
            page.addView(b);
        }
        Button home = button("Back to all groups", ACCENT);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group = -1;
                render();
            }
        });
        page.addView(home);
    }

    private void showLesson(final int g, final int l) {
        String[] data = Content.LESSONS[g][l];
        LinearLayout page = newPage();
        page.addView(text(Content.GROUP_TITLES[g], 14, ACCENT, false));
        page.addView(text(data[0], 24, Color.WHITE, true));
        page.addView(text(data[1], 17, Color.rgb(220, 225, 235), false));
        page.addView(text("Quiz: " + data[2], 19, ACCENT, true));

        final TextView feedback = text("", 16, Color.WHITE, false);
        String[] options = data[3].split("\\|");
        final int correct = Integer.parseInt(data[4]);
        final String why = data[5];

        // Shuffle so the right answer is not always in the same place.
        List<Integer> order = new ArrayList<Integer>();
        for (int i = 0; i < options.length; i++) order.add(i);
        Collections.shuffle(order);

        for (int pos = 0; pos < order.size(); pos++) {
            final int choice = order.get(pos);
            final Button b = button(options[choice], CARD);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (choice == correct) {
                        b.setBackgroundColor(GOOD);
                        feedback.setTextColor(GOOD);
                        feedback.setText("Correct! " + why);
                        markDone(g, l);
                    } else {
                        b.setBackgroundColor(BAD);
                        feedback.setTextColor(BAD);
                        feedback.setText("Not quite. Re-read the lesson and try another answer.");
                    }
                }
            });
            page.addView(b);
        }
        page.addView(feedback);

        if (l + 1 < Content.LESSONS[g].length) {
            Button next = button("Next lesson", ACCENT);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lesson = l + 1;
                    render();
                }
            });
            page.addView(next);
        }
        Button list = button("Back to " + Content.GROUP_TITLES[g], CARD);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lesson = -1;
                render();
            }
        });
        page.addView(list);
    }
}

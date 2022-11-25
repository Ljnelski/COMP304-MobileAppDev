package com.example.liamnelski_comp304_lab4.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liamnelski_comp304_lab4.Database.Models.Test;
import com.example.liamnelski_comp304_lab4.R;

import java.util.ArrayList;
import java.util.List;

public class TestAdaptor extends RecyclerView.Adapter<TestAdaptor.TestHolder> {

    List<Test> tests = new ArrayList<>();
    private Context currentActivity;

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_list_item, parent, false);
        currentActivity = parent.getContext();

        return new TestHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        Test currentTest = tests.get(position);

        holder.testTypeTextView.setText(currentTest.getTestType());
        holder.testRouteTextView.setText(currentTest.getTestRoute());
        holder.testResultTextView.setText(currentTest.getTestResult());
        holder.testDateTextView.setText(currentTest.getTestDate());
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
        notifyDataSetChanged();
    }

    class TestHolder extends  RecyclerView.ViewHolder {

        private TextView testTypeTextView;
        private TextView testRouteTextView;
        private TextView testResultTextView;
        private TextView testDateTextView;

        public TestHolder(@NonNull View itemView) {
            super(itemView);
            testTypeTextView = itemView.findViewById(R.id.listItemTestTypeTextView);
            testRouteTextView = itemView.findViewById(R.id.listItemTestRouteTextView);
            testResultTextView = itemView.findViewById(R.id.listItemTestResultTextView);
            testDateTextView = itemView.findViewById(R.id.listItemTestDateTextView);
        }
    }
}

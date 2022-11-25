package com.example.liamnelski_comp304_lab4.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liamnelski_comp304_lab4.Database.Models.Applicant;
import com.example.liamnelski_comp304_lab4.R;
import com.example.liamnelski_comp304_lab4.TestInfoViewActivity;
import com.example.liamnelski_comp304_lab4.UpdateInfoActivity;

import java.util.ArrayList;
import java.util.List;

public class ApplicantAdaptor extends RecyclerView.Adapter<ApplicantAdaptor.ApplicantHolder> {

    private List<Applicant> applicants = new ArrayList<>();
    private Context currentActivity;

    @NonNull
    @Override
    public ApplicantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.applicant_list_item, parent, false);
        currentActivity = parent.getContext();

        return new ApplicantHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicantHolder holder, int position) {
        Applicant currentApplicant = applicants.get(position);
        holder.applicantLastNameTextView.setText(currentApplicant.getLastName().toString());
        holder.applicantFirstNameTextView.setText(currentApplicant.getFirstName().toString());
        holder.applicantIdTextView.setText(Integer.toString(currentApplicant.getId()));
        holder.applicantTestCentreTextView.setText(currentApplicant.getTestCentre());

        holder.editApplicantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentActivity, UpdateInfoActivity.class);
                intent.putExtra("focusedApplicantId", currentApplicant.getId());
                intent.putExtra("focusedApplicantFirstname", currentApplicant.getFirstName());
                intent.putExtra("focusedApplicantLastname", currentApplicant.getLastName());
                intent.putExtra("focusedApplicantTestCentre", currentApplicant.getTestCentre());
                currentActivity.startActivity(intent);
            }
        });

        holder.viewApplicantTestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentActivity, TestInfoViewActivity.class);
                intent.putExtra("focusedApplicantId", currentApplicant.getId());
                intent.putExtra("focusedApplicantFirstname", currentApplicant.getId());
                intent.putExtra("focusedApplicantLastname", currentApplicant.getId());
                intent.putExtra("focusedApplicantTestCentre", currentApplicant.getId());
                currentActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return applicants.size();
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
        notifyDataSetChanged();
    }

    class ApplicantHolder extends RecyclerView.ViewHolder {
        private TextView applicantLastNameTextView;
        private TextView applicantFirstNameTextView;
        private TextView applicantTestCentreTextView;
        private TextView applicantIdTextView;
        private Button editApplicantButton;
        private Button viewApplicantTestsButton;

        public ApplicantHolder(View itemView) {
            super(itemView);
            applicantLastNameTextView = itemView.findViewById(R.id.listItemApplicantLastNameTextView);
            applicantFirstNameTextView = itemView.findViewById(R.id.listItemApplicantFirstNameTextView);
            applicantTestCentreTextView = itemView.findViewById(R.id.listItemApplicantTestCentreTextView);
            applicantIdTextView = itemView.findViewById(R.id.listItemApplicantIdTextView);
            editApplicantButton = itemView.findViewById(R.id.listItemApplicantEditButton);
            viewApplicantTestsButton = itemView.findViewById(R.id.listItemApplicantTestDataButton);
        }
    }
}

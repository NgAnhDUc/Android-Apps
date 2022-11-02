package com.example.nguyenanhduc_btapck.Fragment_Menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.nguyenanhduc_btapck.EditProfileActivity;
import com.example.nguyenanhduc_btapck.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {
    ImageView imageView;
    TextView nameTv;
    TextView emailTv;
    Button editProfilebtn;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile,container,false);

        nameTv = view.findViewById(R.id.name_tv);
        emailTv = view.findViewById(R.id.email_tv);
        imageView = view.findViewById(R.id.img_avatar);
        editProfilebtn = view.findViewById(R.id.editprofile_btn);
        editProfilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private void showUserInformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            return;
        }

        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();

        nameTv.setText(name);
        emailTv.setText(email);
        Glide.with(getActivity()).load(photoUrl).error(R.drawable.ic_launcher_foreground).into(imageView);

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}

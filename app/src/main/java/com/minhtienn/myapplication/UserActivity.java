package com.minhtienn.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.minhtienn.myapplication.adapters.UserAdapter;
import com.minhtienn.myapplication.models.User;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);

        RecyclerView rvUser = findViewById(R.id.rvUser);

        userList = new ArrayList<User>();
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@fpt.edu.vn"));


        UserAdapter adapter = new UserAdapter(userList);

        rvUser.setAdapter(adapter);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
    }
}
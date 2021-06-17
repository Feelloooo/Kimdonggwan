package org.project.exercise1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragchinese extends Fragment {
    private View view;

    RecyclerView recyclerView;
    MyAdapter myAdapter;


    public static Fragchinese newInstance(){

        Fragchinese fragchinese = new Fragchinese();
        return fragchinese;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view = inflater.inflate(R.layout.frag_chinesefood, container, false);

      recyclerView = view.findViewById(R.id.recyclerView);
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      myAdapter = new MyAdapter(getContext(), getMylist());
      recyclerView.setAdapter(myAdapter);

      return view;
    }

    private ArrayList<Model> getMylist() {

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("반객");
        m.setDescription("충북 청주시 서원구 성봉로 186");
        m.setImg(R.drawable.list1_chinese);
        models.add(m);

        m = new Model();
        m.setTitle("이종구항아리짬뽕");
        m.setDescription("충북 청주시 흥덕구 가로수로1164번길 50");
        m.setImg(R.drawable.list2_chinese);
        models.add(m);

        m = new Model();
        m.setTitle("금릉");
        m.setDescription("충북 청주시 청원구 율봉로201번길 17");
        m.setImg(R.drawable.list3_chinese);
        models.add(m);

        m = new Model();
        m.setTitle("차이향");
        m.setDescription("충북 청주시 청원구 율봉로201번길 17");
        m.setImg(R.drawable.list4_chinese);
        models.add(m);

        m = new Model();
        m.setTitle("금용");
        m.setDescription("충북 청주시 청원구 내덕로 33 1층");
        m.setImg(R.drawable.list5_chinese);
        models.add(m);

        m = new Model();
        m.setTitle("만리향");
        m.setDescription("충북 청주시 서원구 장전로20번가길 4");
        m.setImg(R.drawable.list6_chinese);
        models.add(m);

        m = new Model();
        m.setTitle("조기종의향미각");
        m.setDescription("충북 청주시 서원구 용호로5번길 66");
        m.setImg(R.drawable.list7_chinese);
        models.add(m);

        m = new Model();
        m.setTitle("교동짬뽕봉명점");
        m.setDescription("충북 청주시 흥덕구 덕암로24번길 12-1");
        m.setImg(R.drawable.list8_chinese);
        models.add(m);

        return models;
    }
}

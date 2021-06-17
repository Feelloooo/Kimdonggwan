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

public class Fragwestern extends Fragment {
    private View view;


    RecyclerView recyclerView;
    MyAdapter myAdapter;

    public static Fragwestern newInstance(){
        Fragwestern fragwestern = new Fragwestern();

        return fragwestern;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view = inflater.inflate(R.layout.frag_westernfood, container, false);

      recyclerView = view.findViewById(R.id.recyclerView);
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      myAdapter = new MyAdapter(getContext(), getMylist());
      recyclerView.setAdapter(myAdapter);

      return view;
    }


    private ArrayList<Model> getMylist() {

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("파브리카 충북대점");
        m.setDescription("충북 청주시 서원구 1순환로 682 메가박스 충북대점 2층");
        m.setImg(R.drawable.list1_western);
        models.add(m);

        m = new Model();
        m.setTitle("빌라디쉐프 나폴리점");
        m.setDescription("충북 청주시 서원구 1순환로 1080-2");
        m.setImg(R.drawable.list2_western);
        models.add(m);

        m = new Model();
        m.setTitle("더그랜드허젤");
        m.setDescription("충북 청주시 서원구 남이면 양촌1길 9-69 1동 더 그랜드 허젤");
        m.setImg(R.drawable.list3_western);
        models.add(m);

        m = new Model();
        m.setTitle("오월브런치레스토랑");
        m.setDescription("충북 청주시 상당구 상당로69번길 5");
        m.setImg(R.drawable.list4_western);
        models.add(m);

        m = new Model();
        m.setTitle("위셰프 본점");
        m.setDescription("충북 청주시 흥덕구 2순환로 1098");
        m.setImg(R.drawable.list5_western);
        models.add(m);

        m = new Model();
        m.setTitle("테디헤이데이");
        m.setDescription("충북 청주시 상당구 상당로 89 1층 테디헤이데이");
        m.setImg(R.drawable.list6_western);
        models.add(m);

        m = new Model();
        m.setTitle("미오키친");
        m.setDescription("충북 청주시 상당구 상당로81번길 9-1");
        m.setImg(R.drawable.list7_western);
        models.add(m);

        m = new Model();
        m.setTitle("오상그리아");
        m.setDescription("충북 청주시 청원구 율량로202번길 80 오 상그리아");
        m.setImg(R.drawable.list8_western);
        models.add(m);

        return models;
    }
}

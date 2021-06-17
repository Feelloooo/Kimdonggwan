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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fragkorean extends Fragment {
    private View view;


    RecyclerView recyclerView;
    MyAdapter myAdapter;
    public static Fragkorean newInstance(){
        Fragkorean fragkorean = new Fragkorean();

        return fragkorean;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view = inflater.inflate(R.layout.frag_koreanfood, container, false);

      recyclerView = view.findViewById(R.id.recyclerView);
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      myAdapter = new MyAdapter(getContext(), getMylist());
      recyclerView.setAdapter(myAdapter);

      return view;
    }

    private ArrayList<Model> getMylist() {

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("부부농장");
        m.setDescription("충북 청주시 상당구 문의면 대청호반로 834-1");
        m.setImg(R.drawable.list1);
        m.setPhonenumber("12345678");
        models.add(m);

        m = new Model();
        m.setTitle("봉용불고기");
        m.setDescription("충북 청주시 청원구 상당로203번길 14");
        m.setImg(R.drawable.list2);
        m.setPhonenumber("98765432");
        models.add(m);

        m = new Model();
        m.setTitle("청심재재");
        m.setDescription("충북 청주시 상당구 무심동로372번길 44");
        m.setImg(R.drawable.list3);
        m.setPhonenumber("98765432");
        models.add(m);

        m = new Model();
        m.setTitle("참살이 오리전문점");
        m.setDescription("충북 청주시 상당구 용암북로 124-1");
        m.setImg(R.drawable.list4);
        m.setPhonenumber("98765432");
        models.add(m);

        m = new Model();
        m.setTitle("마중한정식");
        m.setDescription("충북 청주시 상당구 문의면 대청호반로 845-5 마중한정식");
        m.setImg(R.drawable.list5);
        m.setPhonenumber("98765432");
        models.add(m);

        m = new Model();
        m.setTitle("본궁석갈비");
        m.setDescription("충북 청주시 흥덕구 가포산로 197");
        m.setImg(R.drawable.list6);
        m.setPhonenumber("98765432");
        models.add(m);

        m = new Model();
        m.setTitle("청심재재");
        m.setDescription("충북 청주시 상당구 무심동로372번길 44");
        m.setImg(R.drawable.list3);
        m.setPhonenumber("98765432");
        models.add(m);

        m = new Model();
        m.setTitle("청심재재");
        m.setDescription("충북 청주시 상당구 무심동로372번길 44");
        m.setImg(R.drawable.list3);
        m.setPhonenumber("98765432");
        models.add(m);

        m = new Model();
        m.setTitle("청심재재");
        m.setDescription("충북 청주시 상당구 무심동로372번길 44");
        m.setImg(R.drawable.list3);
        m.setPhonenumber("98765432");
        models.add(m);

        return models;
    }

}

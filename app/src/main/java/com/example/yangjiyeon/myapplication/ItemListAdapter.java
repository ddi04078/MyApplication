package com.example.yangjiyeon.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;
import java.util.List;

public class ItemListAdapter extends BaseAdapter {

    private Context context;
    private List<Item> itemList;

    public ItemListAdapter(Context context, List<Item> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    //출력할 총갯수를 설정하는 메소드
    @Override
    public int getCount() {
        return itemList.size();
    }

    //특정한 아이템을 반환하는 메소드
    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    //아이템별 아이디를 반환하는 메소드
    @Override
    public long getItemId(int i) {
        return i;
    }

    //가장 중요한 부분
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.item, null);

        //뷰에 다음 컴포넌트들을 연결시켜줌
        TextView addr1 = (TextView)v.findViewById(R.id.addr1);
        TextView addr2 = (TextView)v.findViewById(R.id.addr2);
        TextView mapx = (TextView)v.findViewById(R.id.mapx);
        TextView mapy = (TextView)v.findViewById(R.id.mapy);
        TextView tel = (TextView)v.findViewById(R.id.tel);
        TextView title = (TextView)v.findViewById(R.id.title);

        addr1.setText(itemList.get(i).getaddr1());
        addr2.setText(itemList.get(i).getaddr2());
        mapx.setText(itemList.get(i).getmapx());
        mapy.setText(itemList.get(i).getmapy());
        tel.setText(itemList.get(i).gettel());
        title.setText(itemList.get(i).gettitle());

        //이렇게하면 findViewWithTag를 쓸 수 있음 없어도 되는 문장임
        //v.setTag(itemList.get(i).getItemID());

        //만든뷰를 반환함
        return v;
    }
}
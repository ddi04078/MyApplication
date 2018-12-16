package com.example.yangjiyeon.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;



import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.json.XML;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;



import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

//키 : 96W192NgCx0baB%2BUh9bpdbO8G%2F56kNv04MMzzsgUoJP8Pt5MVwNXxfWy6j%2BF0Q4MtThG3Lg3VN9ifshBZvvH5A%3D%3D


public class TravelInfoActivity extends AppCompatActivity {

    TextView text;

    String key="96W192NgCx0baB%2BUh9bpdbO8G%2F56kNv04MMzzsgUoJP8Pt5MVwNXxfWy6j%2BF0Q4MtThG3Lg3VN9ifshBZvvH5A%3D%3D";

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_info);

        text= (TextView)findViewById(R.id.text);
    }

    //Button을 클릭했을 때 자동으로 호출되는 callback method
    public void mOnClick(View v){

        switch( v.getId() ){
            case R.id.button:

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        data= getXmlData();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기


                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                text.setText(data); //TextView에 문자열  data 출력
                            }
                        });

                    }
                }).start();

                break;
        }

    }


    String getXmlData(){

        StringBuffer buffer=new StringBuffer();

//        String str= edit.getText().toString();//EditText에 작성된 Text얻어오기

        //   String location = URLEncoder.encode(str);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding     //지역 검색 위한 변수
//        String queryUrl="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"//요청 URL
//                +"addr="+location
//                +"&pageNo=1&numOfRows=1000&ServiceKey=" + key;

        String queryUrl="http://extinfo.seantour.com/acd/api/tour_api.do?" +
                "sortCode=001002001&sido=1100000000&pageIndex=1&serviceKey=key";



        try {
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//태그 이름 얻어오기

                        if(tag.equals("item")) ;// 첫번째 검색결과
                        else if(tag.equals("title")){
                            buffer.append("제목 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("addr")){
                            buffer.append("주소 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("phone")){
                            buffer.append("연락처 :");
                            xpp.next();
                            buffer.append(xpp.getText());//cpId
                            buffer.append("\n");
                        }
                        else if(tag.equals("homepage")){
                            buffer.append("홈페이지 :");
                            xpp.next();
                            buffer.append(xpp.getText());//cpNm
                            buffer.append("\n");
                        }
                        else if(tag.equals("description")){
                            buffer.append("설명 :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //태그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈

                        break;
                }

                eventType= xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }

        buffer.append("파싱 끝\n");

        return buffer.toString();//StringBuffer 문자열 객체 반환

    }




//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_travel_info);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                getData();
//            }
//        }).start();
//
//    }
//
//
//    public void getData() {
//       try {
////           StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList");
////           urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + "96W192NgCx0baB%2BUh9bpdbO8G%2F56kNv04MMzzsgUoJP8Pt5MVwNXxfWy6j%2BF0Q4MtThG3Lg3VN9ifshBZvvH5A%3D%3D");
////           urlBuilder.append("&" + URLEncoder.encode("startPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("pageSize","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("AND", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("B", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("15", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("4", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode("4", "UTF-8"));
////           urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
//
//           StringBuilder urlBuilder = new StringBuilder("http://extinfo.seantour.com/acd/api/tour_api.do"); /*URL*/
//           urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+ "1va%2ByNjcWHtnvK5bJrmiceopvzMw6jCMJbVCIlLRLm39PS30kmQQ4i6AJ0NZ2OOW7kJlK0nbHHslbfMLAOgpzA%3D%3D"); /*Service Key*/
//           urlBuilder.append("&" + URLEncoder.encode("sortCode","UTF-8") + "=" + URLEncoder.encode("001002001", "UTF-8")); /*5.테마코드표 참조*/
//           urlBuilder.append("&" + URLEncoder.encode("sido","UTF-8") + "=" + URLEncoder.encode("1100000000", "UTF-8")); /*6.시도코드표 참조*/
//           urlBuilder.append("&" + URLEncoder.encode("pageIndex","UTF-8") + "=" + URLEncoder.encode("1,2,3", "UTF-8")); /*페이지번호 페이지당 100건 조회 */
//           urlBuilder.append("&" + URLEncoder.encode("sortCode","UTF-8") + "=" + URLEncoder.encode("0011002001", "UTF-8")); /*5.테마코드표 참조*/
//           urlBuilder.append("&" + URLEncoder.encode("sido","UTF-8") + "=" + URLEncoder.encode("1100000000", "UTF-8")); /*6.시도코드표 참조*/
//           urlBuilder.append("&" + URLEncoder.encode("pageIndex","UTF-8") + "=" + URLEncoder.encode("1, 2, 3", "UTF-8")); /*페이지번호 페이지당 100건 조회 */
//
//
//           URL url = new URL(urlBuilder.toString());
//           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//           conn.setRequestMethod("GET");
//           conn.setRequestProperty("content-type", "application/json");
//           System.out.println("Response code: " + conn.getResponseCode());
//           BufferedReader rd;
//           if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//               rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//           } else {
//               rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//           }
//           StringBuilder sb = new StringBuilder();
//           String line;
//           while ((line = rd.readLine()) != null) {
//               sb.append(line);
//           }
//           rd.close();
//           conn.disconnect();
//
//           JSONObject jsonObj = XML.toJSONObject(sb.toString());
//           Log.d("TEST", jsonObj.toString());
//       } catch (Exception e) {
//
//       }

}

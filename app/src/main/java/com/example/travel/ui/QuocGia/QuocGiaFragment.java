package com.example.travel.ui.QuocGia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travel.Adapters.QuocGiaAdapter;
import com.example.travel.Models.CountryItem;
import com.example.travel.R;

import java.util.ArrayList;

public class QuocGiaFragment extends Fragment {

    private ArrayList<CountryItem> countryItems = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_quocgia, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new QuocGiaAdapter(countryItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        countryItems.add(new CountryItem(R.drawable.aus, "Australia","0","0","Australia is the sixth biggest country in the world by land area, and is part of the Oceanic and Australasian regions. Australia, New Zealand, New Guinea and other islands on the Australian tectonic plate are together called Australasia, which is one of the world's great ecozones. When other Pacific islands are included with Australasia, it is called Oceania. 25 million[10] people live in Australia,","Currencies- Australian dollars (AUD)","Languages- English Language","Capital city- Canberra","Other cities- sydney, melbourne, Brisbane, Perth"));
        countryItems.add(new CountryItem(R.drawable.chi, "China","1","0","China has 33 administrative units directly under the central government; these consist of 22 provinces, 5 autonomous regions, 4 municipalities (Chongqing, Beijing, Shanghai, and Tianjin), and 2 special administrative regions (Hong Kong and Macau). The island province of Taiwan, which has been under separate administration since 1949, is discussed in the article Taiwan. Beijing (Peking).","Currencies- ¥ Renminbi","Languages- Mandarin Chinese","Capital city- Beijing","Other cities- Hong kong, Shanghai, Guangzhou, Shenzhen"));
        countryItems.add(new CountryItem(R.drawable.eng, "England","2","0","England is a country that is part of the United Kingdom. It shares land borders with Wales to its west and Scotland to its north. The Irish Sea lies northwest of England and the Celtic Sea to the southwest. England is separated from continental Europe by the North Sea to the east and the English Channel to the south. The country covers five-eighths of the island of Great Britain, which lies in the North Atlantic.","Currencies-Pound sterling (GBP; £)","Languages- English,Cornish","Capital city- London","Other cities- Manchester, Birmingham, Liverpool, bristol"));
        countryItems.add(new CountryItem(R.drawable.indu, "Indonesia","3","0","Indonesia officially the Republic of Indonesia  is a country in Southeast Asia and Oceania, between the Indian and Pacific oceans. It consists of more than seventeen thousand islands, including Sumatra, Java, Borneo (Kalimantan), Sulawesi, and New Guinea (Papua). Indonesia is the world's largest island country and the 14th largest country by land area, at 1,904,569 square kilometres (735,358 square miles).","Currencies- Indonesian rupiah","Languages- Indonesian","Capital city- Jakarta","Other cities- Bandung, Surabaya, Medan, Makassar"));
        countryItems.add(new CountryItem(R.drawable.italy, "Italy","4","0","Italy officially the Italian Republic is a country consisting of a peninsula delimited by the Alps and surrounded by several islands. Italy is located in south-central Europe, and it is also considered a part of western Europe. A unitary parliamentary republic with its capital in Rome, the country covers a total area of 301,340 km2 and shares land borders with France, Switzerland, Austria, Slovenia.","Currencies- Euro (€)b (EUR)","Languages- Italian","Capital city- Rome","Other cities- Venice, Milan, Florence, NaplesVenice, Milan, Florence, Naples"));
        countryItems.add(new CountryItem(R.drawable.jap, "Japan","5","0","Japan is an island country in East Asia located in the northwest Pacific Ocean. It borders the Sea of Japan to the west, and it extends from the Sea of Okhotsk in the north to the East China Sea and Taiwan in the south. Japan is part of the Pacific Ring of Fire and comprises an archipelago of 6,852 islands covering 377,975 square kilometers (145,937 sq mi); its five main islands, from north to south, are Hokkaido, Honshu, Shikoku, Kyushu, and Okinawa.","Currencies- Japanese yen (¥) (JPY)","Languages- Japanese","Capital city- Tokyo","Other cities- Osaka, Kyoto, Sapporo, Fukuoka"));
        countryItems.add(new CountryItem(R.drawable.nz, "New Zealand","6","0","New Zealand is an island country in the southwestern Pacific Ocean. It comprises two main landmasses—the North Island (Te Ika-a-Māui) and the South Island (Te Waipounamu)—and around 600 smaller islands, covering a total area of 268,021 square kilometres (103,500 sq mi). New Zealand is about 2,000 kilometres (1,200 mi) east of Australia across the Tasman Sea and 1,000 kilometres (600 mi) south of the islands of New Caledonia, Fiji, and Tonga. ","Currencies- New Zealand dollar ($) (NZD)","Languages- English,  Māori","Capital city- Wellington","Other cities- Auckland, Christchurch, Dunedin, Queenstown"));
        countryItems.add(new CountryItem(R.drawable.nig, "Nigeria","7","0","Nigeria, an African country on the Gulf of Guinea, has many natural landmarks and wildlife reserves. Protected areas such as Cross River National Park and Yankari National Park have waterfalls, dense rainforest, savanna and rare primate habitats. One of the most recognizable sites is Zuma Rock, a 725m-tall monolith outside the capital of Abuja that’s pictured on the national currency.","Currencies- Nigerian naira","Languages- English Language","Capital city- Abuja","Other cities- Lagos, Kano, Warri, Port harcourt"));
        countryItems.add(new CountryItem(R.drawable.sri, "Sri Lanka","8","0","Sri Lanka officially the Democratic Socialist Republic of Sri Lanka, is an island country in South Asia, located in the Indian Ocean southwest of the Bay of Bengal and southeast of the Arabian Sea. It is geographically separated from the Indian subcontinent by the Gulf of Mannar and the Palk Strait. Sri Jayawardenepura Kotte is its legislative capital, and Colombo is its largest city and centre of commerce.","Currencies- Sri Lankan rupee (Rs) (LKR)","Languages- Sinhala,Tamil,English","Capital city-  Sri Jayawardenepura Kotte ","Other cities- Colombo, dehiwala, trincomalee, moratuwa, homagama"));
        countryItems.add(new CountryItem(R.drawable.ame, "United States","9","0","The United States of America (USA), commonly known as the United States (U.S. or US) or America, is a country mostly located in central North America, between Canada and Mexico. It consists of 50 states, a federal district, five major self-governing territories, and various possessions. At 3.8 million square miles (9.8 million km2), it is the world's third- or fourth-largest country by total area.","Currencies- United States dollar ($) (USD)","Languages- English","Capital city- Washington, D.C","Other cities- New York, San Francisco, Chicaga, Los Angeles"));



        return root;
    }
}
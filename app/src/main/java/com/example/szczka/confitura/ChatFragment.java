package com.example.szczka.confitura;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.szczka.confitura.adapter.CustomAdapter;
import com.example.szczka.confitura.R;
import com.example.szczka.confitura.adapter.CustomAdapter;


public class ChatFragment extends Fragment {
    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset, mDataset2;
    protected int[] mDataset3;

    int [] icon = {R.drawable.lisa, R.drawable.piotr,R.drawable.iga,R.drawable.marcin, R.drawable.marcinmnich,R.drawable.piotr,R.drawable.iga, R.drawable.marcin,R.drawable.wud,R.drawable.wud, R.drawable.wud};
    String [] text1 = {"15:00 - 15:40","15:45 - 16:20","16:30 - 17:20","17:30 - 18:10","18:20 - 19:00","19:10 - 19:50","20:00 - 20:40","20:50 - 21:30"};
    String [] description = {"Pracowała dla Copenhagen Institute of Interaction Design. Aktywna na scenie startupowej od kilku lat. Uwielbia odkrywać równowagę między psychologią a światem cyfrowym, przy czym nie zapomina o użytkownikach.",
            "Założyciel Fuzers. Przedsiębiorca i projektant usług z zamiłowaniem do projektów z zakresu projektowania doświadczeń użytkowników (customer experience design). Inicjator oraz w latach 2012-2017 organizator jednego z największych TEDxów w Polsce - TEDxLublin oraz od 2016 roku jeden z europejskich ambasadorów programu TEDx. ",
            "Projektantka interakcji i badaczka z 10-letnim doświadczeniem, trener biznesu, obecnie wspiera firmy w rozwoju kompetencji UX ich zespołów. Współautorka bestsellerowej książki \"Badania jako podstawa projektowania user experience, wydanej przez wydawnictwo PWN. Opiekun merytoryczny studiów podyplomowych User Experience & Product Design na AGH w Krakowie",
            "Wykładowca w Katedrze Multimediów w Polsko-Japońskiej Akademii Technik Komputerowych w Warszawie, absolwent Wydziału Informatyki tej samej uczelni. Specjalizuje się w zagadnieniach Human-Computer Interaction, Augmented Reality oraz Interactive Digital Storytelling. Certyfikowany ekspert programów Adobe (ACE).",
            "UX Designer skupiający się na projektowaniu czystych i funkcjonalnych aplikacji w ścisłej współpracy z użytkownikami, badaczami oraz deweloperami. Specjalizujący się w usability, prototypowaniu oraz architekturze informacji. Aktualnie szczęśliwy UX Designer w Opera Software oraz pasjonat VR.",
            "Założyciel Fuzers. Przedsiębiorca i projektant usług z zamiłowaniem do projektów z zakresu projektowania doświadczeń użytkowników (customer experience design). Inicjator oraz w latach 2012-2017 organizator jednego z największych TEDxów w Polsce - TEDxLublin oraz od 2016 roku jeden z europejskich ambasadorów programu TEDx. ",
            "Projektantka interakcji i badaczka z 10-letnim doświadczeniem, trener biznesu, obecnie wspiera firmy w rozwoju kompetencji UX ich zespołów. Współautorka bestsellerowej książki \"Badania jako podstawa projektowania user experience, wydanej przez wydawnictwo PWN. Opiekun merytoryczny studiów podyplomowych User Experience & Product Design na AGH w Krakowie",
            "Wykładowca w Katedrze Multimediów w Polsko-Japońskiej Akademii Technik Komputerowych w Warszawie, absolwent Wydziału Informatyki tej samej uczelni. Specjalizuje się w zagadnieniach Human-Computer Interaction, Augmented Reality oraz Interactive Digital Storytelling. Certyfikowany ekspert programów Adobe (ACE).",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        rootView.setTag(TAG);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);


        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {

            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new CustomAdapter(mDataset,mDataset2,mDataset3);

        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }


    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;


        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    private void initDataset() {
        mDataset = new String[text1.length];
        mDataset2 = new String[description.length];
        mDataset3 = new int[icon.length];
        for (int i = 0; i < text1.length; i++) {
            mDataset[i] = text1[i];
            mDataset2[i] = description[i];
            mDataset3[i] = icon[i];
        }
    }
}
package com.example.szczka.confitura;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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


public class SecondFragment extends Fragment {
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

    int [] icon = {R.drawable.piotr,R.drawable.iga,R.drawable.marcin, R.drawable.domi,R.drawable.krzysztoff,R.drawable.lisa, R.drawable.julia, R.drawable.krzysztof};
    String [] text1 = {"Piotr Wojciechowski","Iga Mościchowska","Marcin Wichrowski","Dominika Sobolewska","Krzysztof Kubasek","Lisa Apers","Julia Falkowska","Krzysztof Piwowar"};
    String [] description = {
            "Założyciel Fuzers. Przedsiębiorca i projektant usług z zamiłowaniem do projektów z zakresu projektowania doświadczeń użytkowników (customer experience design). Inicjator oraz w latach 2012-2017 organizator jednego z największych TEDxów w Polsce - TEDxLublin oraz od 2016 roku jeden z europejskich ambasadorów programu TEDx. ",
            "Projektantka interakcji i badaczka z 10-letnim doświadczeniem, trener biznesu, obecnie wspiera firmy w rozwoju kompetencji UX ich zespołów. Współautorka bestsellerowej książki \"Badania jako podstawa projektowania user experience, wydanej przez wydawnictwo PWN. Opiekun merytoryczny studiów podyplomowych User Experience & Product Design na AGH w Krakowie",
            "Wykładowca w Katedrze Multimediów w Polsko-Japońskiej Akademii Technik Komputerowych w Warszawie, absolwent Wydziału Informatyki tej samej uczelni. Specjalizuje się w zagadnieniach Human-Computer Interaction, Augmented Reality oraz Interactive Digital Storytelling. Certyfikowany ekspert programów Adobe (ACE).",
            "Artystka, projektant, nauczyciel akademicki na Wydziale Architektury Wnętrz i Wzornictwa w Akademii Sztuk Pięknych im. E. Gepperta we Wrocławiu, gdzie od 4 lat prowadzi Pracownię Projektowania Obiektów Multimedialnych i Interaktywnych przy Centrum Sztuk Użytkowych.",
            "Projektant produktów codziennego użytku, doktorant oraz wykładowca Wrocławskiej Akademii Sztuk Pięknych im Eugeniusza Gepperta oraz Poznańskiej School Of Form. Absolwent Wrocławskiej Akademii Sztuk Pięknych w Katedrze Architektury Wnętrz i Wzornictwa Przemysłowego.",
            "Projektantka. Pracowała dla Copenhagen Institute of Interaction Design. Atywna na scenie startupowej od kilku lat. Uwielbia odkrywać równowagę między psychologią a światem cyfrowym, przy czym nie zapomina o użytkownikach.  ",
            "Ekspertka z ponad 10-letnim doświadczeniem w realizacji badań usability i badań marketingowych. Doktorantka i pracownik Laboratorium Human Computer Interaction na Politechnice Wrocławskiej.",
            "Od ponad 12 lat działa w obszarze digital. Na co dzień pomaga definiować, budować oraz dostarczać produkty i usługi, które łączą potrzeby ludzi i biznesu."
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
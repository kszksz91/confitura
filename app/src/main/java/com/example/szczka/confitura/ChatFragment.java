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

    int [] icon = {R.drawable.lisa, R.drawable.piotr,R.drawable.iga,R.drawable.marcin, R.drawable.krzysztof,R.drawable.domi,R.drawable.krzysztoff,R.drawable.julia};
    String [] text1 = {"15:00 - 15:40","15:45 - 16:20","16:30 - 17:20","17:30 - 18:10","18:20 - 19:00","19:10 - 19:50","20:00 - 20:40","20:50 - 21:30"};
    String [] description = {"Pracowała dla Copenhagen Institute of Interaction Design. Aktywna na scenie startupowej od kilku lat. Uwielbia odkrywać równowagę między psychologią a światem cyfrowym, przy czym nie zapomina o użytkownikach.",
            "W trakcie warsztatu przećwiczymy wybrane metody i narzędzia wykorzystywane w trakcie fazy badawczej projektu, które wspierają pozyskiwanie informacji od użytkowników oraz spojrzenie na wyzwanie z ich perspektywy. Jako uczestnik otrzymasz także zestaw kilku gotowych do wydruku plansz, które będziesz mógł wykorzystać w swojej pracy zaraz po spotkaniu.",
            "Praca projektanta UX wymaga stałej współpracy z różnymi interesariuszami, których poziom wiedzy o UX i procesie projektowym jest, delikatnie mówiąc, zróżnicowany. Do typowych obowiązków w zakresie projektowania dochodzi więc potrzeba stałej ewangelizacji i edukowania zespołu. Ale jak to robić, żeby nie wyjść na wymądrzającego się dupka lub lesera, który umie tylko w karteczki post-it? ",
            "Projekt „Sztuka współczesna dla wszystkich” ma na celu stworzenie innowacyjnego w skali światowej rozwiązania polegającego na opracowaniu multimedialnego przewodnika w formie aplikacji na urządzenia przenośne (smartfon i tablet) ułatwiającego dostęp do dzieł sztuki eksponowanych osobom z dysfunkcjami słuchu i wzroku oraz polepszającego doświadczenie odbioru sztuki dla osób pełnosprawnych z Polski i zza granicy.",
            "UX Designer skupiający się na projektowaniu czystych i funkcjonalnych aplikacji w ścisłej współpracy z użytkownikami, badaczami oraz deweloperami. Specjalizujący się w usability, prototypowaniu oraz architekturze informacji. Aktualnie szczęśliwy UX Designer w Opera Software oraz pasjonat VR.",
            "Instalacja w przestrzeni monitorowanej przez kamerę umieszczoną nad ekranem. Gesty użytkowników bawiących się świecącymi zabawkami są rejestrowane przez system śledzenia ruchu. Za pomocą specjalnego oprogramowania informacja o historii ruchu zostaje w interaktywny sposób przełożona na abstrakcyjne obrazy i dźwięk. Rozmiar, forma i kolor obrazu wyświetlanego na ekranie koresponduje z pozycją zabawek wprawionych w ruch przez uczestników gry.",
            "Projekt robota społecznego wykonany wraz z Kołem naukowym robotyków KONAR oraz międzynarodowym projektem LIREC.",
            "Na warsztacie omówimy możliwości zastosowań badań eyetrackingowych w pracy projektanta interfejsów użytkownika. Wspólnie przejdziemy przez proces przygotowania badania oraz przykładowej analizy wyników.",
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
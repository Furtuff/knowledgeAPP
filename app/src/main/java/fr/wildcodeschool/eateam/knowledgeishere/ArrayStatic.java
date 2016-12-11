package fr.wildcodeschool.eateam.knowledgeishere;

import java.util.ArrayList;

/**
 * Created by tuffery on 09/12/16.
 */

public class ArrayStatic {
    public static ArrayList<String> fakelist(){
        ArrayList<String> fakelist = new ArrayList<>();
        for (int i = 0 ; i <10; i++){
            fakelist.add("Concrete description of the task planned to be done XXX and YYY are executed daily");
        }
        return fakelist;
    }
    public static ArrayList<String> fakelistDimension(){
        ArrayList<String> fakelist = new ArrayList<>();

        fakelist.add("5/10 Dimension A");
        fakelist.add("6/10 Dimension B");
        fakelist.add("8/10 Dimension C");
        fakelist.add("4/10 Dimension D");

        return fakelist;
    }

}

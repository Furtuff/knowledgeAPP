package fr.wildcodeschool.eateam.knowledgeishere;

import java.util.ArrayList;

/**
 * Created by tuffery on 09/12/16.
 */

public class ArrayStatic {
    public static ArrayList<String> fakelist(){
        ArrayList<String> fakelist = new ArrayList<>();
        for (int i = 0 ; i <50; i++){
            fakelist.add("Concrete description of the task planned to be done XXX and YYY are executed daily");
        }
        return fakelist;
    }


}

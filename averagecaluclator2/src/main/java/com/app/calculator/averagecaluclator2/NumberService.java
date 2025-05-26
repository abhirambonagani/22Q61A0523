package com.app.calculator.averagecaluclator2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

    //private final LinkedList<Integer> window = new LinkedList<>(); 

    public ResponseDTO processnumber(String numberId) {

        List<Integer> prevState = new ArrayList<>(window);
        List<Integer> fetchNumbers= fetchNumbersFromApi(numberId);

        for(Integer numm : fetchNumbers){

            if(!window.contains(numm)){

                if(window.size()>=WINDOW_SIZE){
window.pollFirst();
                }
                window.add(numm);
            }
        }           

        double avg = window.stream().mapToInt(i->i).average().orElse(0.0);
        // TODO Auto-generated method stub
        return new ResponseDTO(prevState, new ArrayList<>(window), avg);
           }

    private List<Integer> fetchNumbersFromApi(String numberId) {
        // TODO Auto-generated method stub

        ExecutorService executorService  = Executors.newSingleThreadExecutor();
        Callable<List<Integer>> task = ()->{
            switch (numberId) {
                case "p": return Arrays.asList(2,3,5,7);
                case "f": return Arrays.asList(1,1,2,3,5);
                case "e": return Arrays.asList(2,4,6,8);
                case "r": return new Random().ints(4,1,100).boxed().toList();
                
            
                default:
                    return Collections.
emptyList();            }
        };


        try{
            return executorService.submit(task).get(500,TimeUnit.MILLISECONDS);
        }
        catch(Exception e){
            return Collections.emptyList();


        }
        finally{
            executorService.shutdown();
        }

    
    }

    private final LinkedList<Integer> window = new LinkedList<>();
    private final int WINDOW_SIZE= 10;


}

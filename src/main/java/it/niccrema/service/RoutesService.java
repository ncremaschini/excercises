package it.niccrema.service;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.Collection;
import java.util.ArrayList;

public class RoutesService {
    
    private List<LinkedList<String>> inputTrip;
    private List<LinkedList<String>> outputTrip;
    private List<LinkedList<String>> segmentsToBeVisited;
  
    public String findRoutes(String[][] routes) {
         
        inputTrip = new ArrayList<LinkedList<String>>();
        outputTrip = new ArrayList<LinkedList<String>>();
        segmentsToBeVisited = new ArrayList<LinkedList<String>>();
      
        Arrays.asList(routes).forEach(segment -> {
            LinkedList<String> linkedListSegment = new LinkedList<String>(Arrays.asList(segment));
            inputTrip.add(linkedListSegment);
        });
        
        segmentsToBeVisited.addAll(inputTrip);
      
        LinkedList<String> firstSegment = lookForFirstSegment();
      
        outputTrip.add(firstSegment);
        LinkedList<String> segmentToVisit = firstSegment;

        while(!segmentsToBeVisited.isEmpty()){
            LinkedList<String> nextSegment = lookForNextSegment(segmentToVisit);
            outputTrip.add(nextSegment);
            segmentsToBeVisited.remove(segmentToVisit);
            segmentToVisit = nextSegment;
        }

        String resultString = createResultString();
        return resultString;
    }
    
    private LinkedList<String> lookForFirstSegment(){
        LinkedList<String> firstSegment = null;
        
        for(LinkedList<String> segment : inputTrip){
          List<LinkedList<String>> checkedSegments = new ArrayList<LinkedList<String>>();
          for(LinkedList<String> subSegment : inputTrip){
            checkedSegments.add(subSegment);

            if(segment.getFirst().equals(subSegment.getLast())){
              break;
            }else{  
              if(checkedSegments.containsAll(inputTrip)){
                firstSegment = segment;
              }
            }
          }
          
          if(firstSegment != null){
             break;
          }
        }
                
        return firstSegment;
    }
  
    private LinkedList<String> lookForNextSegment(LinkedList<String> currentSegment){
      LinkedList<String> nextSegment = null;
      
      for(LinkedList<String> segment : inputTrip){
        if(segment.getFirst().equals(currentSegment.getLast())){
            nextSegment = segment;
            break;
        }
      }
      
      return nextSegment;
    }

    private String createResultString(){
        StringBuilder resultStringBuilder = new StringBuilder();
     
        List<String> outputTripList = outputTrip.stream()
                  .filter(Objects::nonNull)
                  .flatMap(Collection::stream)
                  .distinct()
                  .collect(Collectors.toList());
        
        outputTripList.forEach(segment -> {
              resultStringBuilder.append(segment);
              resultStringBuilder.append(", ");
        });
       
        String resultString = resultStringBuilder.toString();
        
        resultString = resultString.trim();
        resultString = resultString.substring(0,resultString.length()-1);

        return resultString;
    }
 
}
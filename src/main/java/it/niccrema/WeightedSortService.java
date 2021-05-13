package it.niccrema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class WeightedSortService {
	
	public static String orderWeight(String strng) {
        
		List<String> stringsToOrder = Arrays.asList(strng.split(" "));
        
        List<WeightedItem> arrayToSort = new ArrayList<WeightedItem>(stringsToOrder.size());
              
        stringsToOrder.forEach(item -> arrayToSort.add(new WeightedItem(item, calculateWeight(item))));
        
        Collections.sort(arrayToSort);
        
        StringBuilder resultStringBuilder = new StringBuilder();

        arrayToSort.forEach(item ->  {
            resultStringBuilder.append(item.item);
            resultStringBuilder.append(" "); 
          });

        return resultStringBuilder.toString().trim();
          
	}
  
    private static int calculateWeight(String inputString) throws NumberFormatException {
        int weight = 0;
        for(int i=0;i<inputString.length();i++){
          int charToInt = Integer.parseInt(String.valueOf(inputString.charAt(i)));
          weight += charToInt;
        }
      
        return weight;
    }
  
    private static class WeightedItem implements Comparable<WeightedItem> {
      private final String item;
      private final Integer weight;
        
      public WeightedItem(String item, int weight){
        this.item = item;
        this.weight = weight;
      }
      
      public String getItem(){
        return item;
      }
      
      public Integer getWeight(){
        return weight;
      }
      
      public int compareTo(WeightedItem otherItem){
          if(this.weight.compareTo(otherItem.getWeight()) != 0){
            return this.weight.compareTo(otherItem.getWeight());
          }else{
            return this.item.compareTo(otherItem.getItem());
          }
      }
    }
}
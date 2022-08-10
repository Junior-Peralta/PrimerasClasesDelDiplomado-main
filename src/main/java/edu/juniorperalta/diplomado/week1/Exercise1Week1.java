package edu.juniorperalta.diplomado.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * Parejas que suman igual
 * Escribir un método que returne la lista de parejas que sumados (cada numero separado por una coma en un string) sea igual a el resultado esperado
 * <p>
 * Ejemplo:
 * <p>
 * numbers = [1,4,5,0]
 * target = 5
 * <p>
 * Example output
 * 1,4
 * 5,0
 *
 * @author aluis on 4/24/2022.
 */
public class Exercise1Week1 {

    public static List<String> pairOfSumToTarget(List<Integer> numbers, int target) {
        List<String> results = new ArrayList<>();
        // TODO Solve the problem

        for(int i = 0; i < numbers.size(); i++) {
            for(int j = i+1; j<numbers.size(); j++){
                if(numbers.get(i) + numbers.get(j) == target){
                    results.add(numbers.get(i) + ", " + numbers.get(j));
                }
            }

        }

        return results;
    }

    public static void main(String[] args) {
        List<String> results = pairOfSumToTarget(List.of(1, 4, 5, 0), 5);
        for (String result : results) {
            System.out.println(result);
        }
    }

}
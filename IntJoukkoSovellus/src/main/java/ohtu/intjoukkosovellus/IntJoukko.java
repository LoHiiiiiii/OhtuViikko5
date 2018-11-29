
package ohtu.intjoukkosovellus;

import java.util.ArrayList;

public class IntJoukko {

    private final ArrayList<Integer>  joukko = new ArrayList<>();

    public boolean lisaa(int luku) {
        if (!joukko.contains(luku)) {
            joukko.add(luku);
            return true;
        }
        return false;
    }
    
    private void lisaa(ArrayList<Integer> x){
        for(int i : x){
            lisaa(i);
        }
    }

    public boolean kuuluu(int luku) {
        return joukko.contains(luku);
    }

    public boolean poista(int luku) {
        for(int i = 0; i < joukko.size(); ++i){
            if (joukko.get(i) == luku){
                joukko.remove(i);
                return true;
            }
        }
        return false;
    }

    private void poista(ArrayList<Integer> x){
        for(int i : x){
            poista(i);
        }
    }
    
    public int koko() {
        return joukko.size();
    }

    @Override
    public String toString() {
        String tuotos = "{";
        boolean first = true;
        for(int i : joukko){
            if (!first){
                tuotos += ", ";
            } else { 
                first = false;
            }
            tuotos += i;
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toArray() {
        int[] array = new int[joukko.size()];
        int counter = 0;
        for(int i : joukko){
            array[counter] = i;
            counter++;
        }
        return array;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        x.lisaa(a.joukko);
        x.lisaa(b.joukko);
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i : a.joukko){
            if (b.kuuluu(i)){
                x.lisaa((i));
            }
        }
        return x;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        x.lisaa(a.joukko);
        x.poista(b.joukko);
        return x;
    }
        
}
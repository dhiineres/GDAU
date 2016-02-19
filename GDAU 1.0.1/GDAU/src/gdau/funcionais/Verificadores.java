package gdau.funcionais;

public class Verificadores {
    
    public boolean verificaData(int d, int m, int a){
        if (d > 0  && d < 32 && m > 0 && m < 13 && a >= 2016){
            if (m == 1 || m == 3 || m == 5 || m == 7 ||
                    m == 8 || m == 10 || m == 12 ){
                return true;
            }else if (m == 4 || m == 6 || m == 9 || m == 11){
                if (d < 31){
                    return true;
                }
            }else if(m == 2){
                if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)){
                    if (d < 30){
                        return true;
                    }
                }else{
                    if (d < 29){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

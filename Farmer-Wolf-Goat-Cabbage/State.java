
public class State {
    public int[] obj;
    
    public State(){
        obj=new int[4];
        obj[0]=obj[1]=obj[2]=obj[3]=0;
    }

    public State(int farmer, int cabbage, int wolf, int goat) {
        obj=new int[4];
        obj[0]=farmer;
        obj[1]=cabbage;
        obj[2]=wolf;
        obj[3]=goat;
    }
    
    
    public State[] generateNextSTate(){
        State [] ret = new State[4];
        ret[0]=new State(1-obj[0],obj[1],obj[2],obj[3]);
        for (int i = 1; i < 4; i++) {
            State state = ret[i];
            ret[i]=new State(1-obj[0],obj[1],obj[2],obj[3]);
            if(obj[0]==obj[i]){
                ret[i].obj[i] = 1- ret[i].obj[i];
            }
        }
        return ret;
    }
    
    public boolean isIllegal(){
       
        if (obj[0]==1 && obj[1]==0 && obj[3]==0)
            return true;
        if (obj[0]==0 && obj[1]==1 && obj[3]==1)
            return true;
        if (obj[0]==1 && obj[2]==0 && obj[3]==0)
            return true;
        if (obj[0]==0 && obj[2]==1 && obj[3]==1)
            return true;
        return false;
    }
    
    public String toString(){
        return "" + obj[0] + obj[1] +obj [2]+obj[3];
    }
    
}

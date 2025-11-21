import java.util.ArrayList;

public class SortedList {
    public SortedList(){
        list = new ArrayList<>();
    }

    ArrayList<String> list;

    private int search(String target){
        int low =0;
        int high = list.size()-1;

        while(low<=high){
            int mid= (low +high)/2;
            int compare = target.compareTo(list.get(mid));

            if(compare==0){
                return mid;
            }
            else if(compare<0){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -low-1;
    }
    public void add(String item){
        int position = search(item);
        if(position<0){
            position= -position-1;
        }
        list.add(position,item);
    }
    public int size(){
        return list.size();
    }

    public String location(String target){
        int position = search(target);

        if(position>=0){
            return "Found " + target +" at index " + position;
        }
        else{
            int addPosition = -position -1;
            return target + " was not found. "+ target +" would be at index " + addPosition ;
        }
    }

    public String get(int index){
        return list.get(index);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(i).append(" : ").append(list.get(i)).append("\n");
        }
        return sb.toString();
    }

    /* Test
    public static void main(String[] args) {
        SortedList list = new SortedList();

        list.add("A");
        list.add("D");
        list.add("E");
        list.add("B");
        list.add("C");
        list.add("F");

        System.out.println(list);
        System.out.println(list.location("A"));
        System.out.println(list.location("B"));
        System.out.println(list.location("C"));
        System.out.println(list.location("D"));
        System.out.println(list.location("E"));
        System.out.println(list.location("F"));

    }
    */


}

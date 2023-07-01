package View;
//--------------------------------------------------------
import java.util.*;
//--------------------------------------------------------
public abstract class Menu<T> {
    //call title
    protected String title;
    protected ArrayList<T> mChon;

    public Menu() {
    }
    //--------------------------------------------------------
    public Menu(String td, String[] mc) {
        // set title =td
        title = td;
        //set mChon
        mChon = new ArrayList<>();
        //for each : loop value in array 'mc', add value from 's' to 'mChon'
        // 'mChon.add((T) s)' force String to 'T'
        for (String s : mc) mChon.add((T) s);
    }
    //--------------------------------------------------------
    public void display() {
        System.out.println(title);
        System.out.println("------------------------");
        for (int i = 0; i < mChon.size(); i++)
            System.out.println((i + 1) + "." + mChon.get(i)+ ".");
        System.out.println("------------------------");
    }
    //--------------------------------------------------------
    public int getSelected() {
        display();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Selection : ");
        return sc.nextInt();
    }
    //--------------------------------------------------------
    public abstract void execute(int n);
    //--------------------------------------------------------
    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n > mChon.size()) {
                break;
            }
            if (n == 0) {
                break;
            }
        }
    }
    //--------------------------------------------------------
}

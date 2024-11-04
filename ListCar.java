package Vehicle;
import java.util.List;
import java.util.Scanner;

public class ListCar {
    Car[] listCars;
    public int soluong;
    public ListCar(){
        listCars = new Car[0];
    }
    public ListCar( Car[] listCars){
        this.listCars = new Car[listCars.length];     
        for(int i=0;i<=listCars.length;i++)
        {
            this.listCars[i]=listCars[i];
        }       
    }
    public void inpuListCar(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n danh sach xe: ");
        n = sc.nextInt();
        listCars = new Car[n];
        for(int i=0;i<n;i++)
        {
            listCars[i]=new Car();
            listCars[i].inputCar();
        }
        soluong=n;
    }
    public void outputListCar(){
        for(int i=0;i<soluong;i++)
        {
            listCars[i].outputCar();
        }
    }
}
